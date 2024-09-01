package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
  private final Map<String, Resume> storage = new HashMap<>();

  @Override
  protected Resume getSearchKey(String uuid) {
    return storage.get(uuid);
  }

  @Override
  protected void doSave(Resume searchKey, Resume resume) {
    storage.put(resume.getUuid(), resume);
  }

  @Override
  protected void doUpdate(Resume searchKey, Resume resume) {
    doSave(resume, resume);
  }

  @Override
  protected Resume doGet(Resume resume) {
    return resume;
  }

  @Override
  protected void doDelete(Resume resume) {
    storage.remove(resume.getUuid());
  }

  @Override
  protected boolean isExist(Resume resume) {
    return resume != null;
  }

  @Override
  public void clear() {
    storage.clear();
  }

  @Override
  public List<Resume> doCopyAll() {
    return new ArrayList<>(storage.values());
  }
  @Override
  public Resume[] getAll() {
    return storage.values().toArray(new Resume[0]);
  }
  @Override
  public int size() {
    return storage.size();
  }
}
