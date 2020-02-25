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
public class Dires extends Race
{
    
    
    Dires()
    {
        
        // set abstract methods overhere
        setToughness(8);
        setSpeed(5);
       setRaceName("Dires");
       
    };
    
    @Override
   public final void setToughness(int toughness)
   {
     
     super.toughness = toughness;
     
   };
    @Override
   public final void setSpeed(int speed)
   {
     
      super.speed = speed;
     
   };
   
   @Override
   public final void setRaceName(String raceName)
   {
     
       super.raceName = raceName;
     
   };
    
    
}
