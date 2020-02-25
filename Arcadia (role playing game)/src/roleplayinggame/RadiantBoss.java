/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplayinggame;

import java.util.ArrayList;

/**
 *
 * @author M4K3L
 */
public class RadiantBoss extends Radiants
{
    
    private int health = 50;
     private final int BOSS_INVENTORY_LIMIT = 5;
    ArrayList BOSS_INVENTORY = new ArrayList(BOSS_INVENTORY_LIMIT);
    private final String BOSS_NAME = "Almighty Warlock";
    private final String SKILL_NAME = "Chaotic Offering";
    private final int SKILL_POWER = 16;
    private final String SKILL_DESCRIPTION = "Summons a Golem from the depths, stunning all enemies around.";

      RadiantBoss()
    {
        
        addItem("4th Codex of Conduct and Creation of the World");

    }
    
    public Boolean addItem(String item) {

        boolean inventoryFull = false;
        
        // Block from adding to inventory if the size of inventoryList is equal to or higher then available Inventory_size
        if (this.BOSS_INVENTORY.size() < this.BOSS_INVENTORY_LIMIT) {
           this.BOSS_INVENTORY.add(item);

        } else {
            inventoryFull = true;
        }

        //return true if inventory is full
        return inventoryFull;

    }
    
    public ArrayList getBOSS_INVENTORY() {
        return BOSS_INVENTORY;
    }
    
    public int getHealth() {
        return health;
    }

    public int getSKILL_POWER() {
        return SKILL_POWER;
    }

    
    public String getBOSS_NAME() {
        return BOSS_NAME;
    }

    public String getSKILL_NAME() {
        return SKILL_NAME;
    }

    public String getSKILL_DESCRIPTION() {
        return SKILL_DESCRIPTION;
    }
    
   
    public void setHealth(int health) {
        this.health = health;
    }


    
}
