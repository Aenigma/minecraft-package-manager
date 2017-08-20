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

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Kevin Raoofi
 */
public class DownloadPackageBuilder {

    public static void main(String... args) throws IOException {
        final DownloadPackage pkg = new DownloadPackageBuilder()
                .buildPackage();

        ObjectMapper om = new ObjectMapper();

        String json = om.writerWithDefaultPrettyPrinter()
                .writeValueAsString(pkg);

        System.out.println(json);
        System.out.println(pkg);
    }

    private final ConfigSingleton config = ConfigSingleton.getInstance();

    /**
     * Absolute path to where the package data is fetched to build a package
     */
    final Path packageDir;

    /**
     * The URL base in which the packages are located
     */
    final String urlBase;

    private final PackageUtils pu = new PackageUtils();

    private DownloadPackageBuilder(Path packageDir, String urlBase) {
        this.packageDir = packageDir;
        this.urlBase = urlBase;
    }

    private DownloadPackageBuilder(String packageDir, String urlBase) {
        this(Paths.get(packageDir), urlBase);
    }

    public DownloadPackageBuilder() {
        this.packageDir = config.getPackagePath();
        this.urlBase = config.getUrlBase();
    }

    /**
     *
     * @param entry path to file to generate URL version of
     * @return
     */
    String generateUrl(Path entry) {
        String relativePath = this.packageDir.relativize(entry)
                .toString();

        if (File.separator.equals("\\")) {
            relativePath = relativePath.replace("\\", "/");
        }

        return urlBase + relativePath;
    }

    public List<PackageEntry> getPackages(Path categoryPath) throws IOException {
        final List<PackageEntry> entries = Files.walk(categoryPath)
                .filter(Files::isRegularFile)
                .map(pu::newInstance)
                .collect(Collectors.toList());
        return entries;
    }

    public DownloadPackage buildPackage() throws IOException {

        final Map<String, List<PackageEntry>> pkg = new HashMap<>();

        final Path[] packageCategories = Files.list(packageDir)
                .filter(Files::isDirectory)
                .toArray(Path[]::new);

        for (Path categoryPath : packageCategories) {
            final String category = packageDir.relativize(categoryPath)
                    .toString();
            final List<PackageEntry> entries = getPackages(categoryPath);
            pkg.put(category, entries);
        }

        final DownloadPackage res = new DownloadPackage();
        res.setPackages(pkg);
        return res;
    }

}
