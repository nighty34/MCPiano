package ch.nightfury34.main.events;

import ch.nightfury34.main.MusicManager;
import ch.nightfury34.main.Combo;
import ch.nightfury34.main.SongPlayer;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;


public class EventHandler implements Listener {

    @org.bukkit.event.EventHandler
    public void onEntityClick(PlayerInteractAtEntityEvent e){
        String clickedName = e.getRightClicked().getCustomName();
        MusicManager manager = new MusicManager(e.getPlayer().getLocation());
        if(clickedName.length()==3){
            e.getPlayer().sendMessage(clickedName);
            manager.playSound(clickedName);

            Combo combo = Combo.getCombo(e.getPlayer());
            combo.addCombo(clickedName.charAt(0));
            String song = combo.comboCompletet();
            if(song!=null){
                SongPlayer sp = new SongPlayer(e.getPlayer().getLocation(), e.getPlayer(), song);
            }
        }
    }


}
