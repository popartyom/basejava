package com.urise.webapp.storage;

import com.urise.webapp.model.*;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];
        }
        System.out.println("No such element: " + uuid + "!");
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);
}
