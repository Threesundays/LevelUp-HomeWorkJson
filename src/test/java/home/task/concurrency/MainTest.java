package home.task.concurrency;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MainTest extends TestCase {
@Test
    public void testCreateNewFile() throws IOException {
    Main.createNewFile("C:\\Users\\Three\\IdeaProjects\\HomeWork\\src\\test\\resources\\huytest.txt");
    File file = new File("C:\\Users\\Three\\IdeaProjects\\HomeWork\\src\\test\\resources\\huytest.txt");
    boolean exists = file.exists();
    assertTrue(exists);
    file.delete();
}
}