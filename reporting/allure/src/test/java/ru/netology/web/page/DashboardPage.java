package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");

  public DashboardPage() {
    heading.shouldBe(visible);
  }
}
