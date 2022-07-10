package bochkarev.base;

import bochkarev.config.RemoteConfig;
import bochkarev.config.WebConfig;
import bochkarev.helpers.AllureAttachments;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseSetup {

    static WebConfig config;
    static RemoteConfig remoteConfig;
    static String web;
    protected static String login;
    protected static String password;
    protected static String rememberMe;

    @BeforeAll
    static void config() {
        web = System.getProperty("web", "local");
        config = ConfigFactory.create(WebConfig.class, System.getProperties());
        remoteConfig = ConfigFactory.create(RemoteConfig.class, System.getProperties());
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = config.browserName();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        Configuration.baseUrl = config.urlWeb();
        RestAssured.baseURI = config.urlApi();
        //Configuration.holdBrowserOpen = true;
        login = config.userLogin();
        password = config.userPassword();
         rememberMe = config.rememberMe();
        if (web.equals("remote")) {
            Configuration.remote = ("https://" + remoteConfig.remoteUser() + ":"
                    + remoteConfig.remotePassword() + "@" + remoteConfig.remoteUrl());
        }
    }

    @AfterEach
    void afterEach() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();

        if (web.equals("remote")) {
            AllureAttachments.addVideo();
        }

        closeWebDriver();
    }
}
