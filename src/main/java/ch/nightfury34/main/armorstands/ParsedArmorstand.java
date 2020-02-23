package ch.nightfury34.main.armorstands;

import ch.nightfury34.main.utility.PropertiesHandler;
import ch.nightfury34.main.utility.XMaterial;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ParsedArmorstand {
    private String name;
    private String rawID;
    private String customname;
    private Boolean isItem; //TODO: Check if is nec.
    private Boolean enableRotCener; //TODO: Check if is nec.
    private String size;
    private Boolean isDynamic; //TODO: Check if is nec.
    private Boolean visible;
    private String customNBT;
    private Location location; //TODO: Check if is possible


    public ParsedArmorstand(String name, String rawID, String customname, Boolean isItem, Boolean enableRotCener, String size,
                            Boolean isDynamic, Boolean visible, String customNBT, Location location){
        this.name = name;
        this.rawID = rawID;
        this.customname = customname;
        this.isItem = isItem;
        this.enableRotCener = enableRotCener;
        this.size = size;
        this.isDynamic = isDynamic;
        this.visible = visible;
        this.customNBT = customNBT;
        this.location = location;
    }



    public ItemStack getItemStack(){ //TODO fix
        String[] infos = rawID.split(":");
        try {
            System.out.println("info: " + rawID);
            String material = PropertiesHandler.getInstance().getEntry("plugins/mcPiano/materials.properties", infos[0]);
            System.out.println("Properties: " + material);
            ItemStack itemStack = new ItemStack(XMaterial.fromString(rawID.toUpperCase()).parseItem());
            if(itemStack!=null) {
                return itemStack; //add Subid
            }else if(material!=null){
                return new ItemStack(XMaterial.fromString(material).parseItem());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ItemStack(Material.DIRT);
    }


    public String getName() {
        return name;
    }

    public String getRawID() {
        return rawID;
    }

    public String getCustomname() {
        return customname;
    }

    public Boolean getItem() {
        return isItem;
    }

    public Boolean getEnableRotCener() {
        return enableRotCener;
    }

    public String getSize() {
        return size;
    }

    public Boolean getDynamic() {
        return isDynamic;
    }

    public Boolean getVisible() {
        return visible;
    }

    public String getCustomNBT() {
        return customNBT;
    }

    public Location getLocation() {
        return location;
    }
}
