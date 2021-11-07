package roleplayinggame;

import java.util.ArrayList;
/*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public class DireBoss extends Dires
{
    
    int health = 50;
    private final int BOSS_INVENTORY_LIMIT = 5;
    ArrayList BOSS_INVENTORY = new ArrayList(BOSS_INVENTORY_LIMIT);
    final String BOSS_NAME = "Omniknight the Guardian";
    final String SKILL_NAME = "Guardian Angel";
    final int SKILL_POWER = 16;

    DireBoss()
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

    public void setBOSS_INVENTORY(ArrayList BOSS_INVENTORY) {
        this.BOSS_INVENTORY = BOSS_INVENTORY;
    }

    
    public int getHealth() {
        return health;
    }

    public String getBOSS_NAME() {
        return BOSS_NAME;
    }

    public String getSKILL_NAME() {
        return SKILL_NAME;
    }

    public int getSKILL_POWER() {
        return SKILL_POWER;
    }
    
  


    public void setHealth(int health) {
        this.health = health;
    }


    
    
}
