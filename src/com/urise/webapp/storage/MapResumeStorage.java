package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.util.*;

public class MapResumeStorage extends AbstractStorage{

    private final Map<String, Resume> mapStorage = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        mapStorage.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        mapStorage.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object resume) {
        mapStorage.remove(((Resume) resume).getUuid());
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
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
