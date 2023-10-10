import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteTest {
    @Test
    public void testNote(){
        assertEquals(0, Note.A);
        assertEquals(2, Note.B);
        assertEquals(11, Note.Gs);
    }
}
