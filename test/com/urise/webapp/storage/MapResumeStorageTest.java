package com.urise.webapp.storage;

public class MapResumeStorageTest extends AbstractStorageTest {

  MapResumeStorageTest() {
    super(new MapResumeStorage());
  }

  @Override
  public void saveOverflow() {}
}
