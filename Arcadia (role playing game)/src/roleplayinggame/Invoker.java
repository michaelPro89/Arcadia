package roleplayinggame;

import java.util.ArrayList;
/*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public class Invoker extends Radiants
{
    
     private final int FINAL_HEALTH = 25;
    private int health = FINAL_HEALTH;
    private int level = 0;
    private int experience = 0;
    private final int INVENTORY_SIZE = 5;
    private ArrayList inventoryList = new ArrayList(INVENTORY_SIZE);
    private boolean inventoryFull;
    private final String HERO_NAME = "Invoker";
    private final String SKILL_NAME = "Sunstrike";
    private final int SKILL_POWER = 17;
    private String heroDescription = " - powerful mage with ability to cast his spells. "
            + "He uses very strong skill called ''Sunstrike'' which deals high damage to enemy.";

    
    
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

    
    public String getSKILL_NAME() {
        return SKILL_NAME;
    }
    
    public int getSKILL_POWER() {
        return SKILL_POWER;
    }

    public String getHERO_NAME() {
        return HERO_NAME;
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
