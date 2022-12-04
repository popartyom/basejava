package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.util.*;

/**
 * @author Artyom Popov
 */
public class ListStorage extends AbstractStorage {

    private static final List<Resume> listStorage = new ArrayList<>();

    @Override
    public void clear() {
        listStorage.clear();
        System.out.println("Storage is empty!");
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(listStorage);
    }

    @Override
    public int size() {
        return listStorage.size();
    }

    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (uuid.equals(listStorage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        listStorage.set((Integer) searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        listStorage.add(r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        listStorage.remove(((Integer) searchKey).intValue());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return listStorage.get((Integer) searchKey);
    }
}
