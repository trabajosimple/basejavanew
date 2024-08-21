package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public interface Storage {

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    List<Resume> getAllSorted();

    default void clear() {
    }

    default Resume[] getAll() {
        return null;
    }

    default int size() {
        return 0;
    }

}
