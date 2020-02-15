package ch.nightfury34.main.commands;

import ch.nightfury34.main.armorstands.Summoner;
import ch.nightfury34.main.utility.ArmorStandHandler;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class CommandPiano implements CommandExecutor {

    private static final String FILEPATH = "plugins/stander/";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();

            if(args[0].equalsIgnoreCase("spawn")){
                Summoner summoner = new Summoner(ArmorStandHandler.parse(new File(FILEPATH + args[1] + ".txt")), location);
            }



        }
        return true;
    }
}
