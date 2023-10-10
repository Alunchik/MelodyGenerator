import exceptions.WrongFormatException;
import org.junit.Test;

public class ChordTest {
    @Test(expected = WrongFormatException.class)
    public void testChordWrongName() throws WrongFormatException {
        Chord ch = new Chord("An");
    }
    @Test(expected = WrongFormatException.class)
    public void testChordNonExisting() throws WrongFormatException {
        Chord ch = new Chord("U");
    }
}
