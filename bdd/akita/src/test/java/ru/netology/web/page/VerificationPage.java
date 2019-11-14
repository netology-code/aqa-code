package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.netology.web.data.DataHelper;

@Name("Подтверждение входа")
public class VerificationPage extends AkitaPage {
  @FindBy(css = "[data-test-id=code] input")
  @Name("Код")
  private SelenideElement codeField;
  @FindBy(css = "[data-test-id=action-verify]")
  @Name("Продолжить")
  private SelenideElement verifyButton;

  public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
    codeField.setValue(verificationCode.getCode());
    verifyButton.click();
    return Selenide.page(DashboardPage.class);
  }
}
