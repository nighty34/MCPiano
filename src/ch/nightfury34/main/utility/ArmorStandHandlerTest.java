package ch.nightfury34.main.utility;

import ch.nightfury34.main.armorstands.ArmorstandPosition;
import ch.nightfury34.main.armorstands.ParsedArmorstand;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Vector;

public class ArmorStandHandlerTest {

    @Before
    public void setUp(){
        ArmorStandHandler a = new ArmorStandHandler();
    }

    @Test
    public void test(){
        ArmorStandHandler.parse(new File("test.txt"));
    }

    @Test
    public void MaterialTest(){
        System.out.println(XMaterial.fromString("light_weighted_pressure_plate".toUpperCase()).parseMaterial());
    }

    @Test
    public void getParesArmorStandsTest(){
        Vector<ParsedArmorstand> stands = JSONHandler.parseArmorStands("jsontest.json", null);
        for (ParsedArmorstand e:stands){
            System.out.println(e.getName());
            System.out.println(e.getLocation());
            System.out.println(e.getCustomname());
            System.out.println(e.getCustomNBT());
            System.out.println(e.getDynamic());
            System.out.println(e.getEnableRotCener());
            System.out.println(e.getRawID());
            System.out.println(e.getSize());
            System.out.println(e.getVisible());
            System.out.println("----------------");
        }
    }

    @Test
    public void getArmorStandPositionsTest(){
        Vector<ArmorstandPosition> pos = JSONHandler.parsePostions(new File("jsontest.json"), null);
        for(ArmorstandPosition e:pos){
            System.out.println(e.getCustomname());
            System.out.println(e.getSize());
            System.out.println(e.getVisible());
            System.out.println(e.getPosition());
            System.out.println(e.getRotation());
            System.out.println("----------------");
        }
    }
}