package com.idelfatk.parallelconfig;

import com.idelfatk.config.Project;
import org.junit.platform.engine.ConfigurationParameters;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy;

public class CustomStrategy implements ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {
    int threads = Integer.parseInt(Project.config.threads());
    @Override
    public int getParallelism() {
        return threads;
    }

    @Override
    public int getMinimumRunnable() {
        return 0;
    }

    @Override
    public int getMaxPoolSize() {
        return threads;
    }

    @Override
    public int getCorePoolSize() {
        return threads;
    }

    @Override
    public int getKeepAliveSeconds() {
        return 10;
    }

    @Override
    public ParallelExecutionConfiguration createConfiguration(ConfigurationParameters configurationParameters) {
        return this;
    }
}