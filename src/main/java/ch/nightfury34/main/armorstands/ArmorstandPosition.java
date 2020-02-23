package ch.nightfury34.main.armorstands;

import org.bukkit.Location;
import org.bukkit.util.EulerAngle;

import java.util.UUID;

public class ArmorstandPosition {
    private String customname;
    private Location position; //TODO: is possible?
    private EulerAngle rotation;
    private double size; //TODO: is nec?
    private Boolean visible; //TODO: is nec.?

    public ArmorstandPosition(String customname, Location position, EulerAngle eulerAngle, double size, Boolean visible){
        this.customname = customname;
        this.position = position;
        this.rotation = eulerAngle;
        this.size = size;
        this.visible = visible;
    }

    public Location adjustLocation(Location location){
        location.setX(location.getX()+position.getX());
        location.setY(location.getY()+position.getY());
        location.setZ(location.getZ()+position.getZ());
        return location;
    }


    public String getCustomname() {
        return customname;
    }

    public Location getPosition() {
        return position;
    }

    public EulerAngle getRotation() {
        return rotation;
    }

    public double getSize() {
        return size;
    }

    public Boolean getVisible() {
        return visible;
    }
}
