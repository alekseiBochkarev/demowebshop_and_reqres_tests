package webshopandreqres.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
})
public interface RemoteConfig extends Config {

    @Key("remoteUser")
    String remoteUser();

    @Key("remotePassword")
    String remotePassword();

    @Key("remote.URL")
    String remoteUrl();
}
