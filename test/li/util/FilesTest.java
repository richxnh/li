package li.util;

import java.io.File;

import li.test.BaseTest;

import org.junit.Test;

public class FilesTest extends BaseTest {
    @Test
    public void root() {
        Files.root();
    }

    @Test
    public void list() {
        Files.list(Files.root(), ".*", true);
    }

    @Test
    public void load() {
        Files.load(Files.list(Files.root(), ".xml", true).get(0));
    }

    @Test
    public void read() {
        Files.read(new File(Files.list(Files.root(), ".xml", true).get(0)));
    }

    @Test
    public void write() {

    }

    @Test
    public void xpath() {

    }
}