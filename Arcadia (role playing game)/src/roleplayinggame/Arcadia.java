/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplayinggame;

/**
 *
 * @author M4K3L
 */
public class Arcadia extends World
{
    
    
    
    
    Arcadia()
    {
        setWorldName("Arcadia");
        setTownName("Stark");
        setWorldDescription("In the Arcadia world there was harmony and God's splendor until the conflict arised between\\n\" +\n"
                + "\"two opposite movemements - Radiant and Dire.\\n\" +\n"
                + "\"Balance between good and evil is dissolving after death of its Guardian, and must be restored by the appearance of another."
                + "\"In order to bring balance someone needs to find 4 missing codes of conduct \\n\" +\n"
                + "\"and creation of the World before they will be destroyed, which are spread around the Arcadia world.\\n\" +\n"
                + "\"The hope is only in the hands of the newborn child which name is yet unknown and mind is not corrupted...");

    }
    
    
     @Override
    public void setWorldName(String worldName) {
        
        super.worldName = worldName;
        
      
    }
   

    @Override
    public void setTownName(String townName) {
        
        super.townName = townName;
    }

    @Override
    public void setWorldDescription(String worldDecsription) {
        
        super.worldDescription = worldDescription;
    }
    
    
    
    
    
    
}
