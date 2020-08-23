package ch.nightfury34.main;

import ch.nightfury34.main.events.EventHandler;
import ch.nightfury34.main.commands.CommandPiano;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class main extends JavaPlugin {

    private File file; //dir piano
    private File file2; //dir Spawning

    @Override
    public void onEnable(){
        Bukkit.getPluginManager().registerEvents(new EventHandler(), this);
        getCommand("piano").setExecutor(new CommandPiano());
        Combo.initilize();

        file = new File("plugins/mcPiano");  //TODO: Elegantere Lösung
        file2 = new File("plugins/stander");

        if(!file.exists()){
            try{
                file.mkdir();
                File file1 = new  File("plugins/mcPiano/music");
                if(!file1.exists()){
                    file1.mkdir();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(!file2.exists()){
            try{
                file2.mkdir();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDisable(){
        System.out.println("Plugin Deactivated");
    }

   /* @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }*/
}

