/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplayinggame;

import java.util.ArrayList;

/**
 * * @author mikemike
 */
public class Omniknight extends Radiants
{
     
    private final int FINAL_HEALTH = 35;
    private int health = FINAL_HEALTH;
    private int level = 0;
    private int experience = 0;
    private final int INVENTORY_SIZE = 5;
    private ArrayList inventoryList = new ArrayList(INVENTORY_SIZE);
    private boolean inventoryFull;
    private final String HERO_NAME = "Omniknight";
    private final String SKILL_NAME = "Purification";
    private final int SKILL_POWER = 13;
    private String heroDescription = " -  he had spent his entire life in the service of "
            + "the Omniscience. He uses ''Purification'' as his skill.";

    
    
              public void resetStats()
    {
        this.health = this.FINAL_HEALTH;
        this.level = 0;
        this.experience = 0;
        this.inventoryList.clear();
    }
      
    
      public void removeItem(String item) {
        String itemToRemove = item;
        this.inventoryList.remove(itemToRemove);

    }
    
    public ArrayList getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(ArrayList inventoryList) {
        this.inventoryList = inventoryList;
    }
    
    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public String getHERO_NAME() {
        return HERO_NAME;
    }

    public String getSKILL_NAME() {
        return SKILL_NAME;
    }

    public int getSKILL_POWER() {
        return SKILL_POWER;
    }

    public String getHeroDescription() {
        return heroDescription;
    }
    
    
    
    
    public void setLevel(int level) {
        this.level = level;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

               public boolean searchInventoryFor(String item)
    {

        boolean containsSearchedItem = false;

        if (this.inventoryList.contains(item)) {

            containsSearchedItem = true;

        }

        return containsSearchedItem;
    }

    
    public void showInventory()
    {
        
        System.out.println("Inventory has size of: "+this.inventoryList.size());
        
        System.out.println("=== Iterate using Java 8 forEach and lambda ===");
        
          this.inventoryList.forEach(inventoryList -> 
          {
            System.out.println(this.inventoryList);
        });
          
          
        
    }
    
    
    public Boolean addToInventory(String item)
    {

        // Block from adding to inventory if the size of inventoryList is equal to or higher then available Inventory_size
        if (this.inventoryList.size() < this.INVENTORY_SIZE) {
            this.inventoryList.add(item);

        } else {
            this.inventoryFull = true;
        }

        //return true if inventory is full
        return this.inventoryFull;


}
    
    
}
