package roleplayinggame;
/*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public abstract class World 
{
    
     String worldName;
    String worldDescription;
    String townName;
    private boolean goNorth;
    private boolean goEast;
    private boolean goWest;
    private boolean goSouth;

    public abstract void setWorldName(String worldName);
    public abstract void setTownName(String townName);
    public abstract void setWorldDescription(String worldDescription);

    
    
    
    
    public String getWorldName() {
        return worldName;
    }

    public String getWorldDescription() {
        return worldDescription;
    }

    public String getTownName() {
        return townName;
    }

    public boolean isGoNorth() {
        return goNorth;
    }

    public boolean isGoEast() {
        return goEast;
    }

    public boolean isGoWest() {
        return goWest;
    }

    public boolean isGoSouth() {
        return goSouth;
    }

    public void setGoNorth(boolean North) {
        this.goNorth = North;
    }

    public void setGoEast(boolean East) {
        this.goEast = East;
    }

    public void setGoWest(boolean West) {
        this.goWest = West;
    }

    public void setGoSouth(boolean South) {
        this.goSouth = South;
    }

    
    
    

    
}
