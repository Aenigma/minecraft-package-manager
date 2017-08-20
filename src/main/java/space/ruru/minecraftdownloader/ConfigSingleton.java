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
import java.util.Optional;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 *
 * @author Kevin Raoofi
 */
public class ConfigSingleton {

    private static final ConfigSingleton SINGLETON = new ConfigSingleton();

    private static final Path DEFAULT_PACKAGE_DIR = Paths.get(
            "C:/Users/Kevin/projects/minecraftdownloader");

    private static final String DEFAULT_URL_BASE
            = "https://example.com/downloads/";

    final Preferences pref = Preferences.userNodeForPackage(
            ConfigSingleton.class);

    private static final String VERSION = "0.0.1";

    private ConfigSingleton() {
    }

    public static ConfigSingleton getInstance() {
        return SINGLETON;
    }

    public String getPackageDir() {
        return pref.get("PACKAGING_DIR",
                DEFAULT_PACKAGE_DIR.toAbsolutePath()
                .toString());
    }

    public void setPackageDir(String packageDir) {
        pref.put("PACKAGING_DIR", packageDir);
    }

    public String getUrlBase() {
        return pref.get("URL_BASE", DEFAULT_URL_BASE);
    }

    public void setUrlBase(String urlBase) {
        pref.put("URL_BASE", urlBase);
    }

    public Path getPackagePath() {
        return Paths.get(getPackageDir());
    }

    public String getVersion() {
        return VERSION;
    }

    public String getMinecraftDirectory() {
        final String appLoc = Optional.ofNullable(System.getenv("APPDATA"))
                .orElse(System.getProperty("user.home"));

        final String defaultMcDir = Paths.get(appLoc)
                .resolve(".minecraft")
                .toAbsolutePath()
                .toString();

        return pref.get("MINECRAFT_DIR", defaultMcDir);
    }

    public void setMinecraftDirectory(String dir) {
        pref.put("MINECRAFT_DIR", dir);
    }

    public void clear() throws BackingStoreException {
        pref.clear();
    }
}
