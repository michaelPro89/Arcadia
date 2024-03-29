package roleplayinggame;

import java.util.ArrayList;
/*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public class ShadowFiendTheSlave extends Enemy
{
    
     
    int health = 9;
    int experience = 4;
    private final int INVENTORY_LIMIT = 2;
    ArrayList inventory = new ArrayList(INVENTORY_LIMIT);
    final String SKILL_NAME = "Shadowraze";
    final int SKILL_POWER = 13;
  
       ShadowFiendTheSlave()
    {
        setToughness(5);
        setSpeed(2);
        setEnemyName("Shadow Fiend the Slave");
        addItem("2th Codex of Conduct and Creation of the World");
        
    }

       
         public void removeItem(String item) {
        String itemToRemove = item;
        this.inventory.remove(itemToRemove);

    }

       
    public Boolean addItem(String item) {

        boolean inventoryFull = false;

        // Block from adding to inventory if the size of inventoryList is equal to or higher then available Inventory_size
        if (this.inventory.size() < this.INVENTORY_LIMIT) {
            this.inventory.add(item);

        } else {
            inventoryFull = true;
        }

        //return true if inventory is full
        return inventoryFull;

    }
    
    @Override
    public void setToughness(int toughness) 
    {     
        super.toughness = toughness;
           
    }

    @Override
    public void setSpeed(int speed)
    {
        super.speed = speed;
    }

    @Override
    public void setEnemyName(String enemyName) 
    {
        super.enemyName = enemyName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList inventory) {
        this.inventory = inventory;
    }

    public String getSKILL_NAME() {
        return SKILL_NAME;
    }

    public int getSKILL_POWER() {
        return SKILL_POWER;
    }
    
    
    
    
    
}
