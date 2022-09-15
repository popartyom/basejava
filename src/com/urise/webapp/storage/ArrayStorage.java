package com.urise.webapp.storage;

import com.urise.webapp.model.*;
import org.jetbrains.annotations.*;

import java.util.*;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Storage is empty!");
    }

    public void save(Resume r) {
        if (getIndex(r.uuid) == -1) {
            if (size < storage.length) {
                storage[size] = r;
                size++;
                System.out.println(r.uuid + " was saved!");
            } else {
                System.out.println(r.uuid + " wasn't saved! The storage is full!");
            }
        } else {
            System.out.println(r.uuid + " is already exists!");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            return storage[index];
        }
        System.out.println("No such element: " + uuid + "!");
        return null;
    }

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

    public void update(@NotNull Resume r) {
        int index = getIndex(r.uuid);
        if (index > -1) {
            System.out.println("Uuid is " + storage[index]);
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        if (size >= 0) {
            return Arrays.copyOf(storage, size);
        }
        System.out.println("Storage is empty!");
        return null;
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].uuid)) {
                return i;
            }
        }
        return -1;
    }
}