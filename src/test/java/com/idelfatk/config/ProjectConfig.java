
package com.idelfatk.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/remote_web.properties"
})
public interface ProjectConfig extends Config {
    @Key("remoteDriver")
    String remoteDriver();

    @Key("baseUrl")
    String baseUrl();

    @Key("browser")
    String browser();

    @Key("browserSize")
    String browserSize();

    @Key("username")
    String username();

    @Key("password")
    String password();

    @Key("lockedUsername")
    String lockedUsername();

    @Key("browserVersion")
    String browserVersion();

    @Key("wrongUsername")
    String wrongUsername();

    @Key("wrongPassword")
    String wrongPassword();

    @Key("threads")
    String threads();
}