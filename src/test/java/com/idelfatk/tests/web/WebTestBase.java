package com.idelfatk.tests.web;

import com.idelfatk.tests.TestBase;

import static com.idelfatk.helpers.Attachments.getConsoleLogs;
import static org.assertj.core.api.Assertions.assertThat;

public class WebTestBase extends TestBase {
    public void checkingBrowserConsoleErrors () {
        String consoleLogs = getConsoleLogs();
        String errorText = "SEVERE";
        assertThat(consoleLogs).doesNotContain(errorText);
    }
}
