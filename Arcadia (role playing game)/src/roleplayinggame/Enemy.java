package roleplayinggame;
/*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public abstract class Enemy 
{
    
    int toughness;
    int speed;
     String enemyName;
    
    
     // make these methods abstract to force new classes who wants to extend this
    // class to implement these fields as they are most important for Race class
    abstract public void setToughness(int toughness);
    abstract public void setSpeed(int speed);
    abstract public void setEnemyName(String enemyName);

    
    
    public int getToughness() {
        return toughness;
    }

    public int getSpeed() {
        return speed;
    }

    public String getEnemyName() {
        return enemyName;
    }
    
    
    
}
