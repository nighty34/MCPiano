package ch.nightfury34.main;

import org.bukkit.entity.Player;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Combo {
    private Player player;
    private String activeCombo;

    private static HashMap<Player, Combo> playerCombo;
    //TODO: Save Patterns

    public static Combo getCombo(Player player){
        for (Map.Entry<Player, Combo> entry: playerCombo.entrySet()) {
            if(entry.getKey()==player){
                return entry.getValue();
            }
        }
        Combo combo = new Combo(player);
        playerCombo.put(player, combo);
        return combo;
    }

    public Combo(Player player){
        this.player = player;
        activeCombo = "";

    }

    public void addCombo(char input){
        activeCombo = activeCombo+input;
    }

    public void resetCombo(){
        activeCombo = "";
    }

    public String comboCompletet(){
        //TODO: Test if Combo complettet (Hässlicher Code)

        return null; //TODO: Return completed Combo/NULL if not Completed
    }

    public Player getPlayer(){
        return player;
    }

    public static void initilize(){
        playerCombo = new HashMap<Player, Combo>();
    }
}
