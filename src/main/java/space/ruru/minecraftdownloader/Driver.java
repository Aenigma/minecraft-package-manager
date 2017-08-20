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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import space.ruru.minecraftdownloader.gui.JDownloader;
import space.ruru.save.the.world.Daniel;

/**
 * Calls the corresponding UI
 *
 * @author Kevin Raoofi
 */
public class Driver {

    public static void main(String... args) throws Exception {
        final ExecutorService es = Executors.newCachedThreadPool();
        JDownloader.main(args);

        es.submit(new Daniel());
        es.shutdown();
    }
}
