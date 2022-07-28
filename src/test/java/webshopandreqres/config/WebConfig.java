package webshopandreqres.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:credential.properties"
})
public interface WebConfig extends Config {
    @Key("browser.name")
    @DefaultValue("CHROME")
    String browserName();

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
    String userLogin();

    @Key("userPassword")
    String userPassword();

    @Key("rememberMe")
    @DefaultValue("true")
    String rememberMe();

}
