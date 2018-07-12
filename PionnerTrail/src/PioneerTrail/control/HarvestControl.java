
package PioneerTrail.control;

import PioneerTrail.model.Player;
import PioneerTrail.exceptions.HarvestControlException;
import static javax.swing.text.html.HTML.Tag.HEAD;

/**
 *
 * @author Cynthia
 */
public class HarvestControl {
 
    public static int calculateWood(Player player, int initialWood, float consumedWood, int maxWood) throws HarvestControlException  {
        
        if (initialWood<10) { 
            throw new HarvestControlException ( " invalid diameter");
        }
        
          if (player.getTotalDistTraveled() <2) {
           throw new HarvestControlException ( " invalid diameter" );
          }  
          if (player.getTotalDistTraveled() > consumedWood * 2){
               throw new HarvestControlException (" invalid diameter" );
          }
           if (initialWood > maxWood) {
             
                throw new HarvestControlException ( " invalid diameter" );
           } 
        return (int) (initialWood - consumedWood);
        
    }
}
