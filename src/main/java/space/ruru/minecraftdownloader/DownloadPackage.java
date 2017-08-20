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

import java.util.List;
import java.util.Map;

/**
 *
 * @author Kevin Raoofi
 */
public class DownloadPackage {

    private final ConfigSingleton config = ConfigSingleton.getInstance();

    private Map<String, List<PackageEntry>> packages;

    public Map<String, List<PackageEntry>> getPackages() {
        return packages;
    }

    public void setPackages(Map<String, List<PackageEntry>> packages) {
        this.packages = packages;
    }

    public String getVersion() {
        return config.getVersion();
    }

    @Override
    public String toString() {
        return "DownloadPackage{" + "packages=" + packages + '}';
    }

}
