package ch.nightfury34.main;

import ch.nightfury34.main.utility.PropertiesHandler;
import org.bukkit.entity.Player;

public class ViewInterpreter {


    public static String getPlayed(Player player){
        YawPitch yawPitch = new YawPitch(player.getEyeLocation().getYaw(), player.getEyeLocation().getPitch());

        for(int i=0;i<20;i++) {//TODO: add all possible keys
            try {
                String output = PropertiesHandler.getInstance().getEntry("", i + ""); //TODO: get Informations from propertiesFile: 1. Yaw1, Yaw2, Pitch1, Pitch2, Note
                String[] infos = output.split("");
                if (yawPitch.isBetween(Float.parseFloat(infos[0]), Float.parseFloat(infos[1]), Float.parseFloat(infos[2]), Float.parseFloat(infos[3]))) {
                    return infos[4];
                }
            }catch (Exception e){
                e.printStackTrace();
                return "F0";
            }
        }
        /*switch (yawPitch){ //TODO: validate faceing
            case : return "F0"; //F#
            case : return "g0";//G
            case : return "G0";//G#
            case : return "a0";//A
            case : return "A0";//A#
            case : return "b0";//B
            case : return "c0";//C
            case : return "C0";//C#
            case : return "d0";//D
            case : return "D0";//D#
            case : return "e0";//E
            case : return "f0";//F
            case : return "F1";//F#
            case : return "g1";//G
            case : return "G1";//G#
            case : return "a1";//A
            case : return "A1";//A#
            case : return "b1";//B
            case : return "c1";//C
            case : return "C1";//C#
            case : return "d1";//D
            case : return "D1";//D#
            case : return "e1";//E
            case : return "f1";//F
            case : return "F2";//F#
            case : return "F0b"; //F# ---Base----
            case : return "g0b";//G
            case : return "G0b";//G#
            case : return "a0b";//A
            case : return "A0b";//A#
            case : return "b0b";//B
            case : return "c0b";//C
            case : return "C0b";//C#
            case : return "d0b";//D
            case : return "D0b";//D#
            case : return "e0b";//E
            case : return "f0b";//F
            case : return "F1b";//F#
            case : return "g1b";//G
            case : return "G1b";//G#
            case : return "a1b";//A
            case : return "A1b";//A#
            case : return "b1b";//B
            case : return "c1b";//C
            case : return "C1b";//C#
            case : return "d1b";//D
            case : return "D1b";//D#
            case : return "e1b";//E
            case : return "f1b";//F
            case : return "F2b";//F#
            default: return "F0";*/
        return "F0";
    }
}

