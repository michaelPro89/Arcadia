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
public class WarlockTheSlave extends Enemy
        
{
    
    int health = 10;
    int experience = 5;
    private final int INVENTORY_LIMIT = 2;
    ArrayList inventory = new ArrayList(INVENTORY_LIMIT);
    final String SKILL_NAME = "Fatal Bonds";
    final int SKILL_POWER = 17;
  
    WarlockTheSlave()
    {
        setToughness(5);
        setSpeed(2);
        setEnemyName("Warlock the Slave");
        addItem("1th Codex of Conduct and Creation of the World");
        addItem("Healing Potion");

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

    public int getExperience() {
        return experience;
    }

    public String getSKILL_NAME() {
        return SKILL_NAME;
    }

    public int getSKILL_POWER() {
        return SKILL_POWER;
    }

    
       
         public void removeItem(String item) {
        String itemToRemove = item;
        this.inventory.remove(itemToRemove);

    }
    
    
    public ArrayList getInventory() {
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    
    public void setInventory(ArrayList inventory) {
        this.inventory = inventory;
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
    
    
}
