package ch.nightfury34.main.armorstands;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class LocalArmorStand{ //evtl. implements/extends


    private EulerAngle headpose;
    private double[] localLocation;
    private ItemStack material;


    public LocalArmorStand(EulerAngle headpose, double[] localLocation, ItemStack material){
        this.headpose = headpose;
        this.localLocation = localLocation;
        this.material = material;
    }


    public double[] getLocalLocation() {
        return localLocation;
    }

    public EulerAngle getHeadpose() {
        return headpose;
    }

    public Location adjustLocation(Location location){
        location.setX(location.getX()+localLocation[0]);
        location.setY(location.getY()+localLocation[1]);
        location.setZ(location.getZ()+localLocation[2]);
        return location;
    }

    public ItemStack getMaterial() {
        return material;
    }
}
