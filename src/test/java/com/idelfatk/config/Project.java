package com.idelfatk.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
    public static boolean isRemoteDriver() {
        return !(config.remoteDriver() == null) && !config.remoteDriver().isEmpty();
    }
}