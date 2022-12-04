package com.urise.webapp.storage;

import com.urise.webapp.exception.*;
import com.urise.webapp.model.*;
import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Artyom Popov
 */
public abstract class AbstractArrayStorageTest extends AbstractStorageTest{

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
        } catch (StorageException e) {
            fail();
        }
        storage.save(new Resume("Overflow"));
    }
}
