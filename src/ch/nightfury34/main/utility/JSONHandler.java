package ch.nightfury34.main.utility;

import ch.nightfury34.main.armorstands.ArmorstandPosition;
import ch.nightfury34.main.armorstands.ParsedArmorstand;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.EulerAngle;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.util.UUID;
import java.util.Vector;

public class JSONHandler {

    public static Vector<ParsedArmorstand> parseArmorStands(String filepath, World world){
        return parseArmorstands(new File(filepath), world);
    }


    public static Vector<ParsedArmorstand> parseArmorstands(File file, World world){
        Vector<ParsedArmorstand> stands = new Vector<ParsedArmorstand>();
        try{
            JSONTokener tokener = new JSONTokener(file.toURI().toURL().openStream());
            JSONObject root = new JSONObject(tokener);
            JSONArray objects = root.getJSONArray("objects");
            for(int i = 0; objects.length()>i; i++){
                JSONObject data = objects.getJSONObject(i).getJSONObject("userData");
                JSONObject translation = data.getJSONObject("translation");
                stands.add(new ParsedArmorstand(
                        data.getString("name"),
                        data.getString("rawid"),
                        data.getString("customname"),
                        data.getBoolean("isItem"),
                        data.getBoolean("enableRotCenter"),
                        data.getString("size"),
                        data.getBoolean("isDynamic"),
                        data.getBoolean("visible"),
                        data.getString("customnbt"),
                        new Location(world, translation.getDouble("x"), translation.getDouble("y"), translation.getDouble("z"))
                ));



            }
        }catch (Exception e){

        }
        return stands;
    }


    public static Vector<ArmorstandPosition> parsePostions(File file, World world){
        Vector<ArmorstandPosition> postions = new Vector<ArmorstandPosition>();
        try {
            JSONTokener tokener = new JSONTokener(file.toURI().toURL().openStream());
            JSONObject root = new JSONObject(tokener);
            JSONArray objects = root.getJSONArray("keyframes").getJSONObject(0).getJSONArray("objects");
            for(int i = 0; objects.length()>i; i++){
                JSONObject data = objects.getJSONObject(i);
                JSONObject position = data.getJSONObject("position");
                JSONObject rotation = data.getJSONObject("rotation");
                postions.add(new ArmorstandPosition(data.getString("customname"),
                        new Location(world, position.getDouble("x"), position.getDouble("y"), position.getDouble("z")),
                        new EulerAngle(rotation.getDouble("x"), rotation.getDouble("y"), rotation.getDouble("z")),
                        data.getDouble("size"),
                        data.getBoolean("visible")
                ));

            }
        }catch (Exception e){

        }
        return postions;
    }
}
