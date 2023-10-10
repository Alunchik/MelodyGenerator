import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.List;

public class Player {


    MidiChannel player;

    public Player() {
        Synthesizer synth;
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
        MidiChannel[] channels = synth.getChannels();
        player = channels[10];
    }

    public void playGamma() throws MidiUnavailableException, InterruptedException {
        int[] octave =  new int[]{60, 62, 64, 65, 67, 69, 71, 72};
        for(int note: octave){
            player.noteOn(note, 50);
            Thread.sleep(500);
        }
        for(int i=octave.length-2; i>=0; i--){
            player.noteOn(octave[i], 50);
            Thread.sleep(500);
        }
    }

    public void playNote(Note note, int duration) throws InterruptedException {
        player.noteOn(note.ordinal()+60, 50);
        Thread.sleep(duration);
        System.out.println("Playing note " + note);
    }

    public void playBar(Chord chord) throws InterruptedException {
        for(Note note: chord.notes){
            playNote(note, 500);
        }
        playNote(chord.notes.get(1), 500);
    }

    public void generateMelody(List<Chord> list) throws InterruptedException {
        for(Chord chord: list){
            playBar(chord);
        }
        if(list.size()>0) {
            playNote(list.get(0).notes.get(0), 5000);
        }
    }
}
