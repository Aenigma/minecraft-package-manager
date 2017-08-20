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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Russell
 */
public class AWSDownloader {
    

    public AWSDownloader() {

    }

    public void downloadKey() throws FileNotFoundException, IOException {
        try {
            URL website = new URL(ConfigSingleton.getInstance().getUrlBase() + "index_package.json");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(ConfigSingleton.getInstance().getMinecraftDirectory() + "//index_package.json");
            

            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AWSDownloader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
