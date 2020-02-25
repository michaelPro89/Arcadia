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
public class  InvokerTheApperentice extends Enemy
{

    int health = 9;
    int experience = 4;
    private final int INVENTORY_LIMIT = 2;
    ArrayList inventory = new ArrayList(INVENTORY_LIMIT);
    final String SKILL_NAME = "Tornado";
    final int SKILL_POWER = 11;

       InvokerTheApperentice()
    {
        setToughness(5);
        setSpeed(2);
       setEnemyName("Invoker the Apperentice");
       addItem("2th Codex of Conduct and Creation of the World");
      
 
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
    
    

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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
