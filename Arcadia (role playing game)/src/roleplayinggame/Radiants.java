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
public class Radiants extends Race
{
    
    Radiants()
    {
       // set abstract methods overhere
       setToughness(4); 
       setSpeed(10);
       setRaceName("Radiants");
       
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
