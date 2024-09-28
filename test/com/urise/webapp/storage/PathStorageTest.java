package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

public class PathStorageTest extends AbstractStorageTest {
    PathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}