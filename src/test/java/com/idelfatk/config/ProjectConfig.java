
package com.idelfatk.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/remote_web.properties"
})
public interface ProjectConfig extends Config {
    String remoteDriver();

    String baseUrl();

    String browser();

    String browserSize();

    String username();

    String password();

    String lockedUsername();
    String browserVersion();
}