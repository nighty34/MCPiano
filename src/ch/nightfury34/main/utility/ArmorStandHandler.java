package ch.nightfury34.main.utility;

import ch.nightfury34.main.armorstands.LocalArmorStand;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Vector;

public class ArmorStandHandler {
    public static Vector<LocalArmorStand> parse(File decodeFile) {
        try {
            return parse(new FileInputStream(decodeFile), decodeFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Vector<LocalArmorStand> parse(InputStream inputStream, File decodeFile) {
        Vector<LocalArmorStand> stands = new Vector<LocalArmorStand>();
        String pose;
        String location;
        String material;

        try{
            Scanner myReader = new Scanner(decodeFile);
            while(myReader.hasNextLine()){ //Solange einträge
                String input = myReader.nextLine();
                if(input.contains("[Tick 0]")){
                    String[] inputs = input.split(" ");
                    ArrayUtils.reverse(inputs);
                    pose = inputs[0];
                    location = inputs[3] + inputs[2] + inputs[1];
                    material = inputs[6];
                    stands.add(new LocalArmorStand(getHeadPose(pose), getLocation(location), getMaterialtype(material)));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stands;
    }


    private static EulerAngle getHeadPose(String strPose){ //TODO: nichts static
        String[] infos = strPose.replace("Pose:{Head:[", "").replace("]}", "").split(",");
        return  new EulerAngle(Math.toRadians(Double.parseDouble(infos[0].replace("f", ""))),
                Math.toRadians(Double.parseDouble(infos[1].replace("f", ""))),
                Math.toRadians(Double.parseDouble(infos[2].replace("f", ""))));
    }

    private static double[] getLocation(String location){
        String[] infos = location.replace("(", "").replace(")", "").split(",");
        double[] output = new double[3];
        for(int i = 0;i < infos.length;i++)
        {
            // Note that this is assuming valid input
            // If you want to check then add a try/catch
            // and another index for the numbers if to continue adding the others (see below)
            output[i] = Double.parseDouble(infos[i]);
        }
        return output;
    }

    private static ItemStack getMaterialtype(String strMaterial){ //TODO fix
        String[] infos = strMaterial.split(":");
        try {
            System.out.println("info: " + strMaterial);
            String material = PropertiesHandler.getInstance().getEntry("plugins/mcPiano/materials.properties", infos[0]);
            System.out.println("Properties: " + material);
            ItemStack itemStack = new ItemStack(XMaterial.fromString(strMaterial.toUpperCase()).parseItem());
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
}
