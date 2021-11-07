package roleplayinggame;
/*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
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
