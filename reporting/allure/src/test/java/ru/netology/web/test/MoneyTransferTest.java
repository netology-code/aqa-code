package ru.netology.web.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV1;
import ru.netology.web.page.LoginPageV2;
import ru.netology.web.page.LoginPageV3;

import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {
    @BeforeAll
    static void setUpAll() {
      SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
      SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
      open("http://localhost:9999");
      val loginPage = new LoginPageV1();
//    val loginPage = open("http://localhost:9999", LoginPageV1.class);
      val authInfo = DataHelper.getAuthInfo();
      val verificationPage = loginPage.validLogin(authInfo);
      val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
      verificationPage.validVerify(verificationCode);
    }

  @Test
  void shouldTransferMoneyBetweenOwnCardsV2() {
    open("http://localhost:9999");
    val loginPage = new LoginPageV2();
//    val loginPage = open("http://localhost:9999", LoginPageV2.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
  }

  @Test
  void shouldTransferMoneyBetweenOwnCardsV3() {
    val loginPage = open("http://localhost:9999", LoginPageV3.class);
    val authInfo = DataHelper.getAuthInfo();
    val verificationPage = loginPage.validLogin(authInfo);
    val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
  }
}

