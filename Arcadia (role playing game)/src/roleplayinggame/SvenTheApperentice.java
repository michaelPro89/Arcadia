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
public class SvenTheApperentice extends Enemy
{
    
    private  int health = 20;
    private int experience = 4;
    private final int INVENTORY_LIMIT = 2;
    ArrayList inventory = new ArrayList(INVENTORY_LIMIT);
    final String SKILL_NAME = "Storm Hammer";
    final int SKILL_POWER = 10;
  
   SvenTheApperentice()
    {
 
        setToughness(5);
        setSpeed(2);
        setEnemyName("Sven the Apperentice");
        addItem("1th Codex of Conduct and Creation of the World");
        addItem("Healing Potion");

    
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

    public String getSKILL_NAME() {
        return SKILL_NAME;
    }

    public int getSKILL_POWER() {
        return SKILL_POWER;
    }

    public ArrayList getInventory() {
        return inventory;
    }
    
    
    
    
    
}
