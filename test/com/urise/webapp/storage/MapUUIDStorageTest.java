package com.urise.webapp.storage;

public class MapUUIDStorageTest extends AbstractStorageTest {

  MapUUIDStorageTest() {
    super(new MapUUIDStorage());
  }

  @Override
  public void saveOverflow() {}
}
