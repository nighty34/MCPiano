package ch.nightfury34.main.utility;

import ch.nightfury34.main.armorstands.ArmorstandPosition;
import ch.nightfury34.main.armorstands.ParsedArmorstand;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.EulerAngle;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

public class JSONHandler {

    public static Vector<ParsedArmorstand> parseArmorStands(String filepath, World world) {
        return parseArmorstands(new File(filepath), world);
    }


    public static Vector<ParsedArmorstand> parseArmorstands(File file, World world) {
        Vector<ParsedArmorstand> stands = new Vector<ParsedArmorstand>();
        try{
            FileReader fileReader = new FileReader(file);

            JsonObject jsonObject = new Gson().fromJson(fileReader, JsonObject.class);
            JsonArray objects = jsonObject.getAsJsonArray("objects");
            for (int i = 0; objects.size() > i; i++) {
                JsonObject data = objects.get(i).getAsJsonObject().getAsJsonObject("userData");
                JsonObject translation = data.getAsJsonObject("translation");
                stands.add(new ParsedArmorstand(
                        data.get("name").getAsString(),
                        data.get("rawid").getAsString(),
                        data.get("customname").getAsString(),
                        data.get("isItem").getAsBoolean(),
                        data.get("enableRotCenter").getAsBoolean(),
                        data.get("size").getAsString(),
                        data.get("isDynamic").getAsBoolean(),
                        data.get("visible").getAsBoolean(),
                        data.get("customnbt").getAsString(),
                        new Location(world,
                                translation.get("x").getAsDouble(),
                                translation.get("y").getAsDouble(),
                                translation.get("z").getAsDouble())
                ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        /*try{
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

        }*/
            return stands;
        }


        public static Vector<ArmorstandPosition> parsePostions (File file, World world){
            Vector<ArmorstandPosition> postions = new Vector<ArmorstandPosition>();
            try{
                FileReader fileReader = new FileReader(file);
                JsonObject jsonObject = new Gson().fromJson(fileReader, JsonObject.class);
                JsonArray objects = jsonObject.getAsJsonArray("keyframes").get(0).getAsJsonObject().getAsJsonArray("objects");

                for(int i = 0; objects.size()>i; i++){
                    JsonObject data = objects.get(i).getAsJsonObject();
                    JsonObject position = data.getAsJsonObject("position");
                    JsonObject rotation = data.getAsJsonObject("rotation");
                    postions.add(new ArmorstandPosition(data.get("customname").getAsString(),
                            new Location(world,
                                    position.get("x").getAsDouble(),
                                    position.get("y").getAsDouble(),
                                    position.get("z").getAsDouble()),
                            new EulerAngle(rotation.get("x").getAsDouble(),
                                    rotation.get("y").getAsDouble(),
                                    rotation.get("z").getAsDouble()),
                            data.get("size").getAsDouble(),
                            data.get("visible").getAsBoolean()
                    ));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        /*try {
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

        }*/
            return postions;
    }
}

