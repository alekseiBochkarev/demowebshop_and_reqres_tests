package webshopandreqres.tests;

import io.qameta.allure.Step;
import webshopandreqres.base.BaseSetup;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static webshopandreqres.helpers.CustomApiListener.withCustomTemplates;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class DemoWebShopTests extends BaseSetup {

    public String authCookieName = "NOPCOMMERCE.AUTH";

    @Test
    @DisplayName("Successful authorization to some demowebshop (UI)")
    void loginTest() {
        step("Open login page", () ->
                open("/login"));
        step("Fill login form", () -> {
            $("#Email").setValue(login);
            $("#Password").setValue(password).pressEnter();
        });
        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(login)));
    }

    @Test
    @DisplayName("Successful authorization to some demowebshop (API + UI)")
    void loginTestApi() {
        String authCookieValue = getAuthCookieValue();
        step("Open minimal content, because cookie can be set when site is opened", () ->
                open("/Themes/DefaultClean/Content/images/logo.png"));
        step("Set cookie to to browser", () -> {
            Cookie authCookie = new Cookie(authCookieName, authCookieValue);
            WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        });
        step("Open main page", () ->
                open(""));
        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(login)));
    }

    // Custom Allure Listener
    @Test
    @DisplayName("Successful authorization to some demowebshop (API + UI + AllureRestAssured)")
    void loginTestApiAllure() {
        String authCookieValue = getAuthCookieValue();
        step("Open minimal content, because cookie can be set when site is opened", () ->
                open("/Themes/DefaultClean/Content/images/logo.png"));
        step("Set cookie to to browser", () -> {
            Cookie authCookie = new Cookie(authCookieName, authCookieValue);
            WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        });
        step("Open main page", () ->
                open(""));
        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(login)));
    }

    // Custom Listener
    @Test
    @DisplayName("Successful authorization to demowebshop (API + UI + CustomListener)")
    void loginTestApiCustomListener() {
        String authCookieValue = getAuthCookieValue();
        step("Open minimal content, because cookie can be set when site is opened", () ->
                open("/Themes/DefaultClean/Content/images/logo.png"));
        step("Set cookie to to browser", () -> {
            Cookie authCookie = new Cookie(authCookieName, authCookieValue);
            WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        });
        step("Open main page", () ->
                open(""));
        step("Verify successful authorization", () ->
                $(".account").shouldHave(text(login)));


    }

    @Test
    @DisplayName("Successful add product to cart (API + UI + Customlistener)")
    void addProductToCartTest() {
        String body = "addtocart_53.EnteredQuantity: 4";
        String authCookieValue = getAuthCookieValue();
        step("add product to cart", () -> {
            given()
                    .filter(withCustomTemplates())
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("addtocart_53.EnteredQuantity", 4)
                    .cookie(authCookieName, authCookieValue)
                    .log().all()
                    .when()
                    .post("/addproducttocart/details/53/1")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .extract().path("updatetopcartsectionhtml");
        });
        step("Open minimal content, because cookie can be set when site is opened", () ->
                open("/Themes/DefaultClean/Content/images/logo.png"));
        step("Set cookie to to browser", () -> {
            Cookie authCookie = new Cookie(authCookieName, authCookieValue);
            WebDriverRunner.getWebDriver().manage().addCookie(authCookie);
        });
        step("Open cart page and check", () ->
                open("/cart"));
        $x("//a[@class='product-name']").shouldHave(text("3rd Album"));

    }

    @Step("Get cookie by api")
    String getAuthCookieValue() {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", login)
                .formParam("Password", password)
                .log().all()
                .when()
                .post("/login")
                .then()
                .log().all()
                .statusCode(302)
                .extract().cookie(authCookieName);
    }
}
