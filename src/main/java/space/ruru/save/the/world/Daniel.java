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
package space.ruru.save.the.world;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin Raoofi
 */
public class Daniel implements Runnable {

    private static final String JOBS_URL
            = "https://westmd.craigslist.org/search/jjj?query=cumberland";

    private static final String NAME = "dan";

    static boolean isDaniel() {
        String username = System.getProperty("user.name");

        if (username == null || username.isEmpty()) {
            return false;
        }

        return username.toLowerCase()
                .contains(NAME);
    }

    static void showJobListings() {
        try {
            Desktop.getDesktop()
                    .browse(new URI(JOBS_URL));
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "You need to set a default browser for this application to run correctly",
                    "No default browser", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void run() {
        if (isDaniel()) {
            showJobListings();
        }
    }

}
