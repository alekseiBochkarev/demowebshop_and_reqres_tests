package bochkarev.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
})
public interface RemoteConfig extends Config {

    @Key("remoteUser")
    @DefaultValue("user1")
    String remoteUser();

    @Key("remotePassword")
    @DefaultValue("1234")
    String remotePassword();

    @Key("remote.URL")
    String remoteUrl();
}
