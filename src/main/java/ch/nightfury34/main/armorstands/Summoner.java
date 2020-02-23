package ch.nightfury34.main.armorstands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.lang.reflect.Method;
import java.util.Vector;

public class Summoner {

    private final static double LARGEY = 0;
    private final static double MEDIUMY = 0.75;
    private final static double SMALLY = 0.75;


    private final static double LARGEZ = 0;
    private final static double MEDIUMZ = 0.05;
    private final static double SMALLZ = 0.075;

    public Summoner(Vector<LocalArmorStand> armorStands, Location location) {
        for (LocalArmorStand stand:armorStands) {
            summonStand(stand, location.clone());
        }
    }

    public Summoner(Vector<ParsedArmorstand> parsedArmorstands, Vector<ArmorstandPosition> pos, Location location){
        for(ParsedArmorstand stand:parsedArmorstands){
            summonStand(stand, getPosByName(stand.getCustomname(), pos), location.clone());
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
        location.setPitch(0);
        location.setYaw(0);
        pos.adjustLocation(location);
        if(stand.getSize().equalsIgnoreCase("small")){
            //SUMMON VILLAGER
            location.setY(location.getY() + SMALLY);
            location.setZ(location.getZ() + SMALLZ);
            location.setYaw((float)Math.toDegrees(pos.getRotation().getY()));
            location.setPitch((float)Math.toDegrees(pos.getRotation().getX()));
            Villager villager = (Villager) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
            villager.setBaby();
            setNoAITag(villager, true);
            villager.getEquipment().setHelmet(stand.getItemStack());
            villager.setCanPickupItems(false);
            villager.setAgeLock(true);
            villager.teleport(location);
            villager.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 60000, 1, false, false));
        }else if(stand.getSize().equalsIgnoreCase("medium")){
            //SUMMON SMALL ARMORSTAND
            location.setY(location.getY() + MEDIUMY);
            location.setZ(location.getZ() + MEDIUMZ);
            ArmorStand arstand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            arstand.setGravity(false);
            arstand.setHeadPose(pos.getRotation());
            arstand.setSmall(true);
            arstand.setVisible(!stand.getVisible());
            arstand.setHelmet(stand.getItemStack());
        }else if(stand.getSize().equalsIgnoreCase("large")){
            //SUMMON NORMAL ARMORSTAND
            location.setY(location.getY() + LARGEY);
            location.setZ(location.getZ() + LARGEZ);

            ArmorStand arstand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
            arstand.setGravity(false);
            arstand.setHeadPose(pos.getRotation());
            arstand.setSmall(false);
            arstand.setVisible(!stand.getVisible());
            arstand.setHelmet(stand.getItemStack());
        }else if(stand.getSize().equalsIgnoreCase("solid")){
            //SETBLOCK
        }
;
    }

    private ArmorstandPosition getPosByName(String name, Vector<ArmorstandPosition> pos){
        for (ArmorstandPosition e:pos) {
            if(e.getCustomname().equalsIgnoreCase(name)){
                return e;
            }
        }
        System.out.println("----------------------Null---------------------");
        return null;

    }


    public void setNoAITag(Entity ent, boolean noAI) {
        try {
            String pack = Bukkit.getServer().getClass().getPackage().getName();
            String version = pack.substring(pack.lastIndexOf(".") + 1);
            Method k = Class.forName("net.minecraft.server." + version + ".EntityInsentient").getMethod("k",
                    boolean.class);
            Object entity = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftEntity")
                    .getMethod("getHandle").invoke(ent);
            k.invoke(entity, noAI);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
