/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplayinggame;

/**
 *
 * @author M4K3L
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
