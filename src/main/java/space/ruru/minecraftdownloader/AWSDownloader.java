/*
 * Copyright 2017 Russe.
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Russell
 */
public class AWSDownloader {

    ConfigSingleton config = ConfigSingleton.getInstance();

    public AWSDownloader() {

    }

    public void downloadKey() throws FileNotFoundException, IOException {
        try {
            URL website = new URL(ConfigSingleton.getInstance().getUrlBase() + "index_package.json");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(config.getMinecraftDirectory() + "//index_package.json");

            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AWSDownloader.class.getName()).log(Level.SEVERE, null, ex);
        }
        downloadChange();
    }

    private void downloadChange() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        
        Path mcDir = Paths.get(config.getMinecraftDirectory());
        byte[] json = Files.readAllBytes(mcDir.resolve("index_package.json"));
        //Serializes string to the object. 
        DownloadPackage dp = mapper.readValue(json, DownloadPackage.class);
        final Map<String, List<PackageEntry>> entries = dp.getPackages();
        for (Map.Entry<String, List<PackageEntry>> entry : entries.entrySet()) {
            PackageDownloader pd = new PackageDownloader(entry.getValue());
            pd.downloadAll();
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }

    }

}
