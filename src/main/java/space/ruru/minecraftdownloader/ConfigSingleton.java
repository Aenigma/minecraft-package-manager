/*
 * Copyright 2017 Kevin Raoofi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package space.ruru.minecraftdownloader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.prefs.Preferences;

/**
 *
 * @author Kevin Raoofi
 */
public class ConfigSingleton {

    private static final ConfigSingleton SINGLETON = new ConfigSingleton();

    private final Path DEFAULT_PACKAGE_DIR = Paths.get(
            "C:/Users/Kevin/projects/minecraftdownloader");

    private final String DEFAULT_URL_BASE = "https://example.com/downloads/";

    public final String packageDir;
    public final String urlBase;
    public final Path packagePath;

    private ConfigSingleton() {
        final Preferences pref = Preferences.userNodeForPackage(
                ConfigSingleton.class);

        this.urlBase = pref.get("URL_BASE", DEFAULT_URL_BASE);
        this.packageDir = pref.get("PACKAGING_DIR",
                DEFAULT_PACKAGE_DIR.toAbsolutePath()
                .toString());
        this.packagePath = Paths.get(packageDir);
    }

    public static ConfigSingleton getInstance() {
        return SINGLETON;
    }

}
