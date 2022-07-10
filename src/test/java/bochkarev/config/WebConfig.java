package bochkarev.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:credential.properties"
})
public interface WebConfig extends Config {
    @Key("browser.name")
    @DefaultValue("CHROME")
    String browserName();

    @Key("browser.version")
    @DefaultValue("101")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1200x800")
    String browserSize();

    @Key("urlWeb")
    @DefaultValue("")
    String urlWeb();

    @Key("urlApi")
    @DefaultValue("")
    String urlApi();

    @Key("userLogin")
    @DefaultValue("qaguru@qa.guru")
    String userLogin();

    @Key("userPassword")
    @DefaultValue("qaguru@qa.guru1")
    String userPassword();

    @Key("rememberMe")
    @DefaultValue("true")
    String rememberMe();

}
