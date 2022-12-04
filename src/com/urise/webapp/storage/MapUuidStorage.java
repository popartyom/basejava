package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.util.*;

public class MapUuidStorage extends AbstractStorage{

    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object uuid) {
        mapStorage.put((String) uuid, r);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return mapStorage.containsKey((String) uuid);
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        mapStorage.put((String) uuid, r);
    }

    @Override
    protected void doDelete(Object uuid) {
        mapStorage.remove((String) uuid);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return mapStorage.get((String) uuid);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(mapStorage.values());
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}
