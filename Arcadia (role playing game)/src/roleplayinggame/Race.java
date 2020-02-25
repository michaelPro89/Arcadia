/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roleplayinggame;

/**
 *
 * @author mikemike
 */
public abstract class Race 

{
  
    int toughness;
    int speed;
    String raceName;
    
    // make these methods abstract to force new classes who wants to extend this
    // class to implement these fields as they are most important for Race class
    abstract public void setToughness(int toughness);
    abstract public void setSpeed(int speed);
    abstract public void setRaceName(String raceName);
    
    //non-abstract methods
    public int getToughness()
    {  
        return this.toughness;
    };
    
    
    
}
