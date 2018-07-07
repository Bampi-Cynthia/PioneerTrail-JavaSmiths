/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PioneerTrail.control;

import PioneerTrail.exceptions.WagonControlException;
import PioneerTrail.model.Game;
import PioneerTrail.model.Resource;
import PioneerTrail.model.Wagon;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public void testcalculateWagonCurrentWeight() {
        System.out.println("addtoWagon");
        System.out.println("test 1 Valid case");
        Wagon wagon = new Wagon();
        Resource resource = new Resource();
        resource.setQuantity(4);
        resource.setWeight(2);
        wagon.setCapacity(500);
        wagon.setCurrentWeight(150);
        int expResult = 158;
        int result = 0;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("test 2 Invalid case 1");

        resource.setQuantity(2);
        resource.setWeight(4);
        wagon.setCurrentWeight(500);
        wagon.setCapacity(500);
        expResult = -1;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            System.out.println(ex.getMessage());
            result = -1;
            //Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("test 3 Invalid case 2");

        resource.setQuantity(0);
        resource.setWeight(0);
        wagon.setCurrentWeight(250);
        wagon.setCapacity(500);
        expResult = -2;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            result = -2;
            System.out.println(ex.getMessage());
//Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("test 4 Invalid case 3");

        resource.setQuantity(4);
        resource.setWeight(0);
        wagon.setCurrentWeight(250);
        wagon.setCapacity(500);
        expResult = -3;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            System.out.println(ex.getMessage());
            result = -3;
//Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("test 5 Invalid case 4");

        resource.setQuantity(4);
        resource.setWeight(20);
        wagon.setCurrentWeight(450);
        wagon.setCapacity(500);
        expResult = -4;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            System.out.println(ex.getMessage());
            result = -4;
//Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("test 6 Boundary case 1");

        resource.setQuantity(499);
        resource.setWeight(1);
        wagon.setCurrentWeight(0);
        wagon.setCapacity(500);
        expResult = 499;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            System.out.println(ex.getMessage());
//Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("test 7 Boundary case 2");

        resource.setQuantity(1);
        resource.setWeight(499);
        wagon.setCurrentWeight(0);
        wagon.setCapacity(500);
        expResult = 499;
        try {
            result = WagonControl.calculateWagonCurrentWeight(wagon, resource);
        } catch (WagonControlException ex) {
            System.out.println(ex.getMessage());
            //Logger.getLogger(WagonControlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    /**
     * Test of calculateWagonCurrentIntegrity method, of class WagonControl.
     */
    @Test
    public void testCalculateWagonCurrentIntegrity() {
        System.out.println("calculateWagonCurrentIntegrity VALID CASE");
        Wagon wagon = new Wagon();
        Game game = new Game();
        wagon.setIntegrity(90);
        game.setMilesTraveled(200);
        int maxIntegrity = 100;
        int expResult = 70;
        int result = WagonControl.calculateWagonCurrentIntegrity(wagon, game, maxIntegrity);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("INVALID CASE 1");
        wagon.setIntegrity(-1);
        game.setMilesTraveled(200);
        maxIntegrity = 100;
        expResult = -1;
        result = WagonControl.calculateWagonCurrentIntegrity(wagon, game, maxIntegrity);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("INVALID CASE 2");
        wagon.setIntegrity(100);
        game.setMilesTraveled(-1);
        maxIntegrity = 100;
        expResult = -2;
        result = WagonControl.calculateWagonCurrentIntegrity(wagon, game, maxIntegrity);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("INVALID CASE 3");
        wagon.setIntegrity(13);
        game.setMilesTraveled(200);
        maxIntegrity = 100;
        expResult = -3;
        result = WagonControl.calculateWagonCurrentIntegrity(wagon, game, maxIntegrity);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("BOUDARY CASE 1");
        wagon.setIntegrity(1);
        game.setMilesTraveled(10);
        maxIntegrity = 100;
        expResult = 0;
        result = WagonControl.calculateWagonCurrentIntegrity(wagon, game, maxIntegrity);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);

        System.out.println("BOUDARY CASE 2");
        wagon.setIntegrity(100);
        game.setMilesTraveled(1000);
        maxIntegrity = 100;
        expResult = 0;
        result = WagonControl.calculateWagonCurrentIntegrity(wagon, game, maxIntegrity);
        System.out.println("Return value = " + result);
        assertEquals(expResult, result);
    }

}
