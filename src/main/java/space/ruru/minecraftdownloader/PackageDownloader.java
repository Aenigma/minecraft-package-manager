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

import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;

/**
 *
 * @author Kevin Raoofi
 */
public class PackageDownloader implements Closeable {

    private static final Logger LOG = Logger.getLogger(PackageDownloader.class
            .getName());

    private final ConfigSingleton config = ConfigSingleton.getInstance();

    private final OkHttpClient client;
    private final List<PackageEntry> downloadList;

    public PackageDownloader(List<PackageEntry> downloadList) {
        this.downloadList = downloadList;
        this.client = new OkHttpClient();
    }

    public void downloadAll() throws IOException {
        for (PackageEntry packageEntry : downloadList) {
            download(packageEntry);
        }
    }

    public void download(PackageEntry pe) throws IOException {
        final Request rqst = new Request.Builder().url(pe.getUrl())
                .build();
        final Path destination = Paths.get(config.getMinecraftDirectory())
                .resolve(pe.getFileName());

        Files.createDirectories(destination.getParent());

        client.newCall(rqst)
                .enqueue(new PackageDownloadCallback(destination, pe));
    }

    public static void main(String... args) throws IOException {
        DownloadPackage buildPackage = new DownloadPackage();

        Map<String, List<PackageEntry>> dlMap = new HashMap<>();
        List<PackageEntry> packagesList = new ArrayList<>();

        packagesList.add(new PackageEntry("http://google.com",
                "potato/test.html", ""));

        dlMap.put("test", packagesList);

        buildPackage.setPackages(dlMap);

        List<PackageEntry> downloadAbles = buildPackage.getPackages()
                .values()
                .stream()
                .map((packages) -> packages.stream())
                .reduce(Stream::concat)
                .get()
                .collect(Collectors.toList());

        try (PackageDownloader pd = new PackageDownloader(downloadAbles)) {
            pd.downloadAll();
        }
    }

    @Override
    public void close() {
        client.dispatcher()
                .executorService()
                .shutdown();
    }

    private static class PackageDownloadCallback implements Callback {

        private final Path destination;
        private final PackageEntry pe;

        public PackageDownloadCallback(Path destination, PackageEntry pe) {
            this.destination = destination;
            this.pe = pe;
        }

        @Override
        public void onFailure(Call call, IOException e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Sink sink = Okio.sink(destination);
            try (BufferedSink bs = Okio.buffer(sink)) {
                ResponseBody body = response.body();
                if (body == null) {
                    return;
                }
                BufferedSource inputSource = body.source();

                bs.writeAll(inputSource);
                //bs.writeAll(body.source());
            }

            System.out.println("Saved " + pe.getUrl() + " to " + destination);
        }
    }
}
