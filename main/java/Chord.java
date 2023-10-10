import exceptions.WrongFormatException;

import java.util.LinkedList;
import java.util.List;

public class Chord {

    public static Note getInterval(Note note, int halfTones){
        int noteNum = note.ordinal();
        int secondNoteNum=halfTones+noteNum;
        if(secondNoteNum>=Note.values().length){
            secondNoteNum-=Note.values().length;
        }
        return Note.values()[secondNoteNum];
    }

    String name; // название аккорда в формате "A, A#, Dm, C#m

    List<Note> notes;
    public Chord(String name) throws WrongFormatException {
        this.name = name;
        notes=getNotes(name);
        throw new WrongFormatException();
    }

    private List<Note> getNotes(String chord) throws WrongFormatException {
        Note first; //main note

        List<Note> notes = new LinkedList();


        //Парсим основную ноту. Если есть диез, повышаем на полтона
        if(chord.matches("[A-G]#m?")){ // is sharp
            first=Note.valueOf(String.valueOf(chord.charAt(0))+"s");
        }
        else if(chord.matches("[A-G]m?")){
            first=Note.valueOf(String.valueOf(chord.charAt(0)));
        }
        else {
            throw new WrongFormatException("Неверный формат ввода аккорда, можно вводить только минорные аккорды в формате Am, D#m и мажорные в формате B, G" );
        }
        notes.add(first);


        //Добавляем третью ноту, на 2 полутона выше, если минор и на три, если мажор

        if(chord.matches("[A-G]#?m")){
            notes.add(getInterval(first,3));
        }
        else{
            notes.add(getInterval(first,4));
        }

        //Добавляем верхнюю ноту, которая выше первой на квинту (5 полутонов)

        notes.add(getInterval(first, 7)); //
        return notes;
    }
}
