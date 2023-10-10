import exceptions.WrongFormatException;

import javax.sound.midi.MidiUnavailableException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MidiUnavailableException, InterruptedException {
        System.out.println("Enter chord sequence in format \'A# Fm D#m\'");
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        List<Chord> chords = new LinkedList<>();
        for(String l:line){
            try {
                chords.add(new Chord(l));
            } catch (WrongFormatException e) {
                System.out.println("Error" + e);
            }
        }
        new Player().generateMelody(chords);
    }}