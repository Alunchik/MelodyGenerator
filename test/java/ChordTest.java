import exceptions.WrongFormatException;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChordTest {
    @Test(expected = WrongFormatException.class)
    public void testChordWrongName() throws WrongFormatException {
        Chord ch = new Chord("An");
    }
    @Test(expected = WrongFormatException.class)
    public void testChordNonExisting() throws WrongFormatException {
        Chord ch = new Chord("U");
    }

    @Test
    public void testGetInterval(){
        assertEquals(Note.G, Chord.getInterval(Note.C, 7));
    }
}
