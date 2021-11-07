package roleplayinggame;

import java.util.ArrayList;
/*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public class Sven extends Radiants
{
    
    private final int FINAL_HEALTH = 45;
    private int health = FINAL_HEALTH;
    int level = 0;
    int experience = 0;
    private final int INVENTORY_SIZE = 5;
    ArrayList inventoryList = new ArrayList(INVENTORY_SIZE);
    boolean inventoryFull;
    final String HERO_NAME = "Sven";
    final String SKILL_NAME = "God's Strength";
    final int SKILL_POWER = 17;
    private String heroDescription = " - powerful Knight who follows his own Codex."
            + " His ''God's Strength'' skill channels his strength, granting bonus damage.";

    
    Sven()  { }
    
   
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

    public int getHealth() {
        return health;
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
