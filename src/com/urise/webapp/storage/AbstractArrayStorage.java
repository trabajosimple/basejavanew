package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    public static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public final void save(Resume r) {
        int i = getIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else if (i > 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            addElement(i, r);
        }
    }

    public final void update(Resume r) {
        int i = getIndex(r.getUuid());
        if (i <= 0) {
            throw new NotExistStorageException(r.getUuid());
        }
        storage[i] = r;
    }

    public final Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i < 0) {
            throw new NotExistStorageException(uuid);
        }
        return new Resume(storage[i]);
    }

    public final void delete(String uuid) {
        int i = getIndex(uuid);
        if (i < 0) {
            throw new NotExistStorageException(uuid);
        }
        deleteElement(i);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public final Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public final int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void addElement(int i, Resume r);

    protected abstract void deleteElement(int i);
}
