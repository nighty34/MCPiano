package ch.nightfury34.main.armorstands;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.Vector;

public class Summoner {

    public Summoner(Vector<LocalArmorStand> armorStands, Location location) {
        for (LocalArmorStand stand:armorStands) {
            summonStand(stand, location.clone());
        }
    }

    private void summonStand(LocalArmorStand stand, Location location){ //TODO
        stand.adjustLocation(location);
        location.setYaw(0);
        location.setPitch(0);
        ArmorStand arstand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        arstand.setHeadPose(stand.getHeadpose());
        arstand.setVisible(false);
        arstand.setArms(true);
        arstand.setGravity(false);
        arstand.setHelmet(stand.getMaterial());


    }
}
