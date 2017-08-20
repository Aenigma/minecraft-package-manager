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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Kevin Raoofi
 */
public class PackageUtils {

    private final ConfigSingleton config = ConfigSingleton.getInstance();

    private final Path packageDir = config.packagePath;
    private final String urlBase = config.urlBase;

    private String generateUrl(Path entry) {
        String relativePath = getRelativePath(entry);

        return urlBase + relativePath;
    }

    private String getRelativePath(Path p) {
        String relativePath = packageDir.relativize(p)
                .toString();

        if (File.separator.equals("\\")) {
            relativePath = relativePath.replace("\\", "/");
        }

        return relativePath;
    }

    public PackageEntry newInstance(Path p) {
        try {
            final String digest = DigestUtils.sha1Hex(Files.newInputStream(p));
            final PackageEntry pe = new PackageEntry(
                    generateUrl(p),
                    getRelativePath(p),
                    digest);

            return pe;
        } catch (IOException ex) {
            Logger.getLogger(PackageUtils.class.getName())
                    .log(Level.SEVERE, null, ex);

            // if you're building a package and you have IO problems, YOU have problems
            throw new RuntimeException(ex);
        }
    }

    private Path getPackagePath(PackageEntry pe) {
        return packageDir.resolve(pe.getFileName());
    }

    public boolean verify(PackageEntry pe) throws IOException {
        final Path packagePath = getPackagePath(pe);
        final String digest = DigestUtils.sha1Hex(Files.newInputStream(
                packagePath));

        return digest.equals(pe.getDigest());
    }
}
