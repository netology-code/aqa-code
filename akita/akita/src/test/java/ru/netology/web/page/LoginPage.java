package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.netology.web.data.DataHelper;

@Name("Страница входа")
public class LoginPage extends AkitaPage {
  @Name("Логин")
  @FindBy(css = "[data-test-id=login] input")
  public SelenideElement loginField;
  @Name("Пароль")
  @FindBy(css = "[data-test-id=password] input")
  public SelenideElement passwordField;
  @Name("Продолжить")
  @FindBy(css = "[data-test-id=action-login]")
  public SelenideElement loginButton;

  public VerificationPage validLogin(DataHelper.AuthInfo info) {
    loginField.setValue(info.getLogin());
    passwordField.setValue(info.getPassword());
    loginButton.click();
    return Selenide.page(VerificationPage.class);
  }
}
