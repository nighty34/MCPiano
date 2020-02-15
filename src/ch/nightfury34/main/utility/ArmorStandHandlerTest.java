package ch.nightfury34.main.utility;

import org.bukkit.entity.ArmorStand;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

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
}