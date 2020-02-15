package ch.nightfury34.main;

import org.bukkit.Location;
import org.bukkit.Sound;

import static org.bukkit.Sound.NOTE_BASS;
import static org.bukkit.Sound.NOTE_PIANO;

public class MusicManager {

    private Location source;

    public MusicManager(Location source){
        this.source = source;
    }

    public void playSound(String note){
        String[] infos = note.split("(?<=\\G.{2})"); //Split to identify Base/Piano
        float pitch = getPitch(infos[0]);

        if(infos[1].equalsIgnoreCase("b")) {
            source.getWorld().playSound(source, NOTE_BASS, 2f, pitch);
        }else{
            source.getWorld().playSound(source, NOTE_PIANO, 2f, pitch);
        }

    }

    private float getPitch(String id) {
        switch (id) {
            case "F0": return 0.5F; //F#
            case "g0": return 0.53F;//G
            case "G0": return 0.56F;//G#
            case "a0": return 0.6F;//A
            case "A0": return 0.63F;//A#
            case "b0": return 0.67F;//B
            case "c0": return 0.7F;//C
            case "C0": return 0.76F;//C#
            case "d0": return 0.8F;//D
            case "D0": return 0.84F;//D#
            case "e0": return 0.9F;//E
            case "f0": return 0.94F;//F
            case "F1": return 1.0F;//F#
            case "g1": return 1.06F;//G
            case "G1": return 1.12F;//G#
            case "a1": return 1.18F;//A
            case "A1": return 1.26F;//A#
            case "b1": return 1.34F;//B
            case "c1": return 1.42F;//C
            case "C1": return 1.5F;//C#
            case "d1": return 1.6F;//D
            case "D1": return 1.68F;//D#
            case "e1": return 1.78F;//E
            case "f1": return 1.88F;//F
            case "F2": return 2.0F;//F#
            default: return 0.0F;
        }
    }
}
