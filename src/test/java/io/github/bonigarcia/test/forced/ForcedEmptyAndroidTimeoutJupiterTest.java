/*
 * (C) Copyright 2018 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia.test.forced;

import static io.github.bonigarcia.BrowserType.ANDROID;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.SeleniumJupiter;
import io.github.bonigarcia.SeleniumJupiterException;
import io.github.bonigarcia.handler.DockerDriverHandler;

public class ForcedEmptyAndroidTimeoutJupiterTest {

    @BeforeAll
    static void setup() throws Exception {
        SeleniumJupiter.config().setAndroidDeviceTimeoutSec(0);
    }

    @Test
    void androidTimeoutTest() {
        assertThrows(SeleniumJupiterException.class, () -> {
            DockerDriverHandler dockerDriverHandler = new DockerDriverHandler();
            WebDriver driver = dockerDriverHandler.resolve(ANDROID, "7.1.1",
                    "chrome", "Samsung Galaxy S6");
            System.out.println(driver);
        });
    }

}
