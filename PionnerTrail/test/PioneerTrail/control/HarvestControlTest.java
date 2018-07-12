/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.control;

import PioneerTrail.exceptions.HarvestControlException;
import PioneerTrail.model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cynthia
 */
public class HarvestControlTest {
    
    public HarvestControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateWood method, of class HarvestControl.
     * @throws PioneerTrail.exceptions.HarvestControlException
     */
    @Test
    public void testCalculateWood() throws HarvestControlException {
        System.out.println("Valid Case");
        Player player = new Player();
        player.setTotalDistTraveled(2);
        int initialWood = 80;
        float consumedWood = 1.0F;
        int maxWood = 100;
        int expResult = 79;
        int result = HarvestControl.calculateWood( player, initialWood, consumedWood, maxWood);
        assertEquals(expResult, result);
       
        System.out.println("test 2 Invalid case 1");
        
        player.setTotalDistTraveled(10);
        initialWood = 9;
        consumedWood = 5.0F;
        maxWood = 100;
        expResult = -1;
        result = HarvestControl.calculateWood(player, initialWood, consumedWood, maxWood);
        assertEquals(expResult, result);
        
        System.out.println("test 3 Invalid case 2");
        
        player.setTotalDistTraveled(1);
        initialWood = 70;
        consumedWood = 0.5F;
        maxWood = 100;
        expResult = -2;
        result = HarvestControl.calculateWood(player, initialWood, consumedWood, maxWood);
        assertEquals(expResult, result);
        
        System.out.println("test 4 Invalid case 3");
        
        player.setTotalDistTraveled(41);
        initialWood = 70;
        consumedWood = 20.0F;
        maxWood = 100;
        expResult = -3;
        result = HarvestControl.calculateWood(player, initialWood, consumedWood, maxWood);
        assertEquals(expResult, result);
        
        System.out.println("test 5 Invalid case 4");
        
        player.setTotalDistTraveled(20);
        initialWood = 101;
        consumedWood = 10.0F;
        maxWood = 100;
        expResult = -4;
        result = HarvestControl.calculateWood(player, initialWood, consumedWood, maxWood);
        assertEquals(expResult, result);
        
        System.out.println("test 1 boundary 1");
        
        player.setTotalDistTraveled(2);
        initialWood = 10;
        consumedWood = 1.0F;
        maxWood = 100;
        expResult = 9;
        result = HarvestControl.calculateWood(player, initialWood, consumedWood, maxWood);
        assertEquals(expResult, result);
        
        System.out.println("test 1 boundary 2");
        
        player.setTotalDistTraveled(2);
        initialWood = 10;
        consumedWood = 1.0F;
        maxWood = 100;
        expResult = 9;
        result = HarvestControl.calculateWood(player, initialWood, consumedWood, maxWood);
        assertEquals(expResult, result);
        
        System.out.println("test 1 boundary 3");
        
        player.setTotalDistTraveled(18);
        initialWood = 10;
        consumedWood = 9.0F;
        maxWood = 100;
        expResult = 1;
        result = HarvestControl.calculateWood(player, initialWood, consumedWood, maxWood);
        assertEquals(expResult, result);
    }
    
}
