package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Artyom Popov
 */
public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private final Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    @Override
    protected Path getSearchKey(String uuid) {
        return new Path(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path Path) {
        try {
            doWrite(r, new BufferedOutputStream(Paths.newOutputStream(Path.toPath())));
        } catch (IOException e) {
            throw new StorageException("Path write error", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(Path Path) {
        return Path.exists();
    }

    @Override
    protected void doSave(Resume r, Path Path) {
        try {
            Path.createNewPath();
        } catch (IOException e) {
            throw new StorageException("Couldn't create Path " + Path.getAbsolutePath(), Path.getName(), e);
        }
        doUpdate(r, Path);
    }

    @Override
    protected void doDelete(Path Path) {
        if (!Path.delete()) {
            throw new StorageException("Path delete error", Path.getName());
        }
    }

    @Override
    protected Resume doGet(Path Path) {
        try {
            return doRead(new BufferedInputStream(Paths.newInputStream(Path.toPath())));
        } catch (IOException e) {
            throw new StorageException("Path read error", Path.getName(), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        Path[] paths = directory.listPaths();
        if (paths == null) {
            throw new StorageException("Directory read error", null);
        }
        List<Resume> list = new ArrayList<>(paths.length);
        for (Path Path : paths) {
            list.add(doGet(Path));
        }
        return list;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if (list == null) {
            throw new StorageException("Directory read error", null);
        }
        return list.length;
    }
}
