/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplayinggame;

import java.util.ArrayList;

/**
 *
 * @author mikemike
 */
public class Warlock extends Dires
        
{

      private final int FINAL_HEALTH = 25;
    private int health = FINAL_HEALTH;
    private int level = 0;
    private int experience = 0;
    private final int INVENTORY_SIZE = 5;
    ArrayList inventoryList = new ArrayList(INVENTORY_SIZE);
    boolean inventoryFull;
    private final String HERO_NAME = "Warlock";
    private final String SKILL_NAME = "Fatal Bonds";
    private final int SKILL_POWER = 15;
    private String heroDescription = " - a powerful dark mage. He has very strong skill ''Fatal Bonds'' which binds several enemy units together "
                        + "and deals very high damage to all of them.";

    
    
    
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
  
    
    public String getHeroDescription() {
        return heroDescription;
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
    
    
    public Boolean addToInventory( ArrayList list)
    {

        // Block from adding to inventory if the size of inventoryList is equal to or higher then available Inventory_size
        if (this.inventoryList.size() < this.INVENTORY_SIZE) {
            this.inventoryList.add(list);

        } else {
            this.inventoryFull = true;
        }

        //return true if inventory is full
        return this.inventoryFull;


}
    
}
