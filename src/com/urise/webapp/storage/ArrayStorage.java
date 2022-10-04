package com.urise.webapp.storage;

import com.urise.webapp.model.*;
import org.jetbrains.annotations.*;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage {
    Resume[] storage = new Resume[10000];
    private int size;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Storage is empty!");
    }

    @Override
    public void save(Resume r) {
        if (getIndex(r.getUuid()) == -1) {
            if (size < storage.length) {
                storage[size] = r;
                size++;
                System.out.println(r.getUuid() + " was saved!");
            } else {
                System.out.println(r.getUuid() + " wasn't saved! The storage is full!");
            }
        } else {
            System.out.println(r.getUuid() + " is already exists!");
        }
    }

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
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println(uuid + " was deleted!");
        }
        System.out.println("No such element: " + uuid + "!");
    }

    @Override
    public void update(@NotNull Resume r) {
        int index = getIndex(r.getUuid());
        if (index > -1) {
            storage[index] = r;
            System.out.println("Updated " + r.getUuid() + "!");
        } else {
            System.out.println("No such element: " + r.getUuid() + "!");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public Resume[] getAll() {
        if (size >= 0) {
            return Arrays.copyOf(storage, size);
        }
        System.out.println("Storage is empty!");
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
