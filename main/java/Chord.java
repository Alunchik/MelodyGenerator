import exceptions.WrongFormatException;

public class Chord {
    String name; // название аккорда в формате "A, A#, Dm, C#m
    public Chord(String name) throws WrongFormatException {
        this.name = name;
        throw new WrongFormatException();
    }
}
