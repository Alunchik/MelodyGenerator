import exceptions.WrongFormatException;
import org.junit.Test;

public class ChordTest {
    @Test(expected = WrongFormatException.class)
    public void testCreateTempFile() throws WrongFormatException {
        Chord ch = new ch("An");
    }
    @Test(expected = WrongFormatException.class)
    public void testCreateTempFile() throws WrongFormatException {
        Chord ch = new ch("U");
    }
}
