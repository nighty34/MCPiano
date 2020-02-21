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

    public Summoner(Vector<ParsedArmorstand> parsedArmorstands, Vector<ArmorstandPosition> pos, Location location){
        for(ParsedArmorstand stand:parsedArmorstands){
            summonStand(stand, getPosByName(stand.getCustomname(), pos), location);
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

    private void summonStand(ParsedArmorstand stand, ArmorstandPosition pos, Location location){
        pos.adjustLocation(location);
        ArmorStand arstand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        arstand.setArms(true);
        arstand.setGravity(false);
        arstand.setHeadPose(pos.getRotation());
        arstand.setVisible(stand.getVisible());
        arstand.setHelmet(stand.getItemStack());
    }

    private ArmorstandPosition getPosByName(String name, Vector<ArmorstandPosition> pos){
        for (ArmorstandPosition e:pos) {
            if(e.getCustomname().equalsIgnoreCase(name)){
                return e;
            }
        }
        return null;
    }
}
