package com.urise.webapp.storage;

import com.urise.webapp.exception.*;
import com.urise.webapp.model.*;
import org.junit.*;

/**
 * @author Artyom Popov
 */
public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(storage.getClass().getDeclaredField("storage").get(storage), storage.get("uuid2"));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void delete() throws Exception {
        storage.delete("uuid2");
        Assert.assertEquals(2, storage.size());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void getAll() throws Exception {
//        Assert.assertArrayEquals(storage.getClass().getDeclaredFields()[1], storage.getAll());
    }
}