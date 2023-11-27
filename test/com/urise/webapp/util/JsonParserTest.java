package com.urise.webapp.util;

import com.urise.webapp.model.*;
import org.junit.*;

import static com.urise.webapp.TestData.*;

/**
 * @author Artyom Popov
 */
public class JsonParserTest {
    @Test
    public void testResume() {
        String json = JsonParser.write(R1);
        System.out.println(json);
        Resume resume = JsonParser.read(json, Resume.class);
        Assert.assertEquals(R1, resume);
    }

    @Test
    public void write() {
        Section section1 = new TextSection("Objective1");
        String json = JsonParser.write(section1, Section.class);
        System.out.println(json);
        Section section2 = JsonParser.read(json, Section.class);
        Assert.assertEquals(section1, section2);
    }
}