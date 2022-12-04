package com.urise.webapp.storage;

import org.junit.runner.*;
import org.junit.runners.*;

/**
 * @author Artyom Popov
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedArrayStorageTest.class,
                ListStorageTest.class,
                MapUuidStorageTest.class,
                MapResumeStorageTest.class
        })
public class AllStorageTest {

}
