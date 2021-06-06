package ru.netology.web.step;

import cucumber.api.java.ru.Пусть;
import lombok.var;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPage;
import ru.netology.web.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static ru.alfabank.tests.core.helpers.PropertyLoader.loadProperty;

public class TemplateSteps {
  private final AkitaScenario scenario = AkitaScenario.getInstance();

  @Пусть("^пользователь залогинен с именем \"([^\"]*)\" и паролем \"([^\"]*)\"$")
  public void loginWithNameAndPassword(String login, String password) {
    var loginUrl = loadProperty("loginUrl");
    open(loginUrl);

    scenario.setCurrentPage(page(LoginPage.class));
    var loginPage = (LoginPage) scenario.getCurrentPage().appeared();
    var authInfo = new DataHelper.AuthInfo(login, password);
    scenario.setCurrentPage(loginPage.validLogin(authInfo));

    var verificationPage = (VerificationPage) scenario.getCurrentPage().appeared();
    var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    scenario.setCurrentPage(verificationPage.validVerify(verificationCode));

    scenario.getCurrentPage().appeared();
  }
}
