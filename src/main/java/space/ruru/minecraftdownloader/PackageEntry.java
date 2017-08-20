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

import java.util.Objects;

public final class PackageEntry {

    private String url;
    private String fileName;
    private String digest;

    public PackageEntry(String url, String fileName, String digest) {
        this.url = url;
        this.fileName = fileName;
        this.digest = digest;
    }

    public PackageEntry() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.url);
        hash = 17 * hash + Objects.hashCode(this.fileName);
        hash = 17 * hash + Objects.hashCode(this.digest);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PackageEntry other = (PackageEntry) obj;
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.digest, other.digest)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PackageEntry{" + "url=" + url + ", fileName=" + fileName
                + ", digest=" + digest + '}';
    }

}
