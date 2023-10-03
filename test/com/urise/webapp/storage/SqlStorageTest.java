package com.urise.webapp.storage;

import com.urise.webapp.*;

public class SqlStorageTest extends AbstractStorageTest {
    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}