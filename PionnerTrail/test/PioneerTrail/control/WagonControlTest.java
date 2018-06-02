/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.control;

import PioneerTrail.model.Resource;
import PioneerTrail.model.Wagon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elías
 */
public class WagonControlTest {
    
    public WagonControlTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addtoWagon method, of class WagonControl.
     */
    @Test
    public void testAddtoWagon() {
        System.out.println("addtoWagon");
        System.out.println("test 1 Valid case");
        Wagon wagon = new Wagon();
        Resource resource = new Resource();
        resource.setQuantity(4);
        resource.setWeight(2);
        wagon.setCurrentWeight(150);
        wagon.setCapacity(500);
        int expResult = 158;
        int result = WagonControl.addtoWagon(wagon, resource);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("test 2 Invalid case 1");

        resource.setQuantity(2);
        resource.setWeight(4);
        wagon.setCurrentWeight(500);
        wagon.setCapacity(500);
        expResult = -1;
        result = WagonControl.addtoWagon(wagon, resource);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("test 3 Invalid case 2");

        resource.setQuantity(0);
        resource.setWeight(0);
        wagon.setCurrentWeight(250);
        wagon.setCapacity(500);
        expResult = -2;
        result = WagonControl.addtoWagon(wagon, resource);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("test 4 Invalid case 3");

        resource.setQuantity(4);
        resource.setWeight(0);
        wagon.setCurrentWeight(250);
        wagon.setCapacity(500);
        expResult = -3;
        result = WagonControl.addtoWagon(wagon, resource);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("test 5 Invalid case 4");

        resource.setQuantity(4);
        resource.setWeight(20);
        wagon.setCurrentWeight(450);
        wagon.setCapacity(500);
        expResult = -4;
        result = WagonControl.addtoWagon(wagon, resource);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("test 6 Boundary case 1");

        resource.setQuantity(499);
        resource.setWeight(1);
        wagon.setCurrentWeight(0);
        wagon.setCapacity(500);
        expResult = 499;
        result = WagonControl.addtoWagon(wagon, resource);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("test 7 Boundary case 2");

        resource.setQuantity(1);
        resource.setWeight(499);
        wagon.setCurrentWeight(0);
        wagon.setCapacity(500);
        expResult = 499;
        result = WagonControl.addtoWagon(wagon, resource);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateFoodAmount method, of class WagonControl.
     */
    @Test
    public void testCalculateFoodAmount() {
        System.out.println("calculateFoodAmount VALIDATE CASE");
     
        int actorsAlive = 4;
        int currentFoodAmount = 80;
        int maxFoodAmount = 100;
        int actorFoodConsumption = 10;
        int expResult = 40;
        int result = WagonControl.calculateFoodAmount(actorsAlive, currentFoodAmount, maxFoodAmount, actorFoodConsumption);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("INVALID CASE 1");
        
        actorsAlive = 0;
        currentFoodAmount = 80;
        maxFoodAmount = 100;
        actorFoodConsumption = 10;
        expResult = -1;
        result = WagonControl.calculateFoodAmount(actorsAlive, currentFoodAmount, maxFoodAmount, actorFoodConsumption);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("INVALID CASE 2");
        
        actorsAlive = 4;
        currentFoodAmount = 120;
        maxFoodAmount = 100;
        actorFoodConsumption = 10;
        expResult = -2;
        result = WagonControl.calculateFoodAmount(actorsAlive, currentFoodAmount, maxFoodAmount, actorFoodConsumption);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("INVALID CASE 3");
        
        actorsAlive = 4;
        currentFoodAmount = -1;
        maxFoodAmount = 100;
        actorFoodConsumption = 10;
        expResult = -3;
        result = WagonControl.calculateFoodAmount(actorsAlive, currentFoodAmount, maxFoodAmount, actorFoodConsumption);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("INVALID CASE 4");
        
        actorsAlive = 4;
        currentFoodAmount = 10;
        maxFoodAmount = 100;
        actorFoodConsumption = 10;
        expResult = -4;
        result = WagonControl.calculateFoodAmount(actorsAlive, currentFoodAmount, maxFoodAmount, actorFoodConsumption);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("BOUNDARY CASE 1");
        
        actorsAlive = 5;
        currentFoodAmount = 100;
        maxFoodAmount = 100;
        actorFoodConsumption = 20;
        expResult = 0;
        result = WagonControl.calculateFoodAmount(actorsAlive, currentFoodAmount, maxFoodAmount, actorFoodConsumption);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
        
        System.out.println("BOUNDARY CASE 2");
        
        actorsAlive = 1;
        currentFoodAmount = 1;
        maxFoodAmount = 100;
        actorFoodConsumption = 1;
        expResult = 0;
        result = WagonControl.calculateFoodAmount(actorsAlive, currentFoodAmount, maxFoodAmount, actorFoodConsumption);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
    }
    
}
