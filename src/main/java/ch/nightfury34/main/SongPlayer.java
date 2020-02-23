package ch.nightfury34.main;

import ch.nightfury34.main.utility.NBSDecoder;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.PositionSongPlayer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.io.File;

public class SongPlayer {

    private static final String FILEPATH = "plugins/mcPiano/music";

    public SongPlayer(Location location, Player player, String name){
        PositionSongPlayer psp = new PositionSongPlayer(getSong(name));
        psp.setTargetLocation(location);
        psp.setAutoDestroy(false);
        psp.setDistance(50);
        psp.addPlayer(player);
        psp.setPlaying(true);
    }

    public Song getSong(String filename){
        return NBSDecoder.parse(new File(FILEPATH + filename + ".nbs")); //TODO: Check
    }




}
