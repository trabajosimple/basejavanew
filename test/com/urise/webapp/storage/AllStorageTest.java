package com.urise.webapp.storage;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ListStorageTest.class, ArrayStorageTest.class, SortedArrayStorageTest.class,
        MapResumeStorageTest.class, MapUUIDStorageTest.class, FileStorageTest.class,
        PathStorageTest.class, DataPathStorageTest.class, JsonPathStorageTest.class,
        XmlPathStorageTest.class})
public class AllStorageTest {}
