package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

public class PathStorageTest extends AbstractStorageTest {
    protected static final String PATHSTORAGE_DIR = "d:\\tmp\\storage2";

    PathStorageTest() {
        super(new PathStorage(PATHSTORAGE_DIR, new ObjectStreamSerializer()));
    }
}