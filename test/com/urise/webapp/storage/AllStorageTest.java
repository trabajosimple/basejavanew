package com.urise.webapp.storage;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ArrayStorageTest.class, ListStorageTest.class, MapResumeStorageTest.class,
        MapUUIDStorageTest.class, SortedArrayStorageTest.class})
public class AllStorageTest {
}
