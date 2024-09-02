package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamSerializer;

public class FileStorageTest extends AbstractStorageTest {

    protected static final String FILESTORAGE_DIR = "d:\\tmp\\storage1";

    public FileStorageTest() {
        super(new FileStorage(FILESTORAGE_DIR, new ObjectStreamSerializer()));
    }
}