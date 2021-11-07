package roleplayinggame;

import java.security.SecureRandom;
/*
* @author Michal Switala
* Copyright © 2021 belongs solely to Michal Switala. 
* You can reach me out on : https://github.com/michaelPro89
*/
public class Stark extends Arcadia
{
    SecureRandom random = new SecureRandom();
    
    private String guardName = "Isacc";
    private int guardHealth = 1000;
    private int GUARD_TOUGHNESS = 5;
    private final int GUARD_SKILL_POWER = 25;
    private boolean goToStark;
    private boolean talkWithGuard;
    private boolean goToPalace;
    

    
    final private String [] GUARD_TALKS = 
 {" *Hicks!* Immm sooo drunkkk I cannt taak rajt now... sorri. ",
                "Did you hear about Hills of Parnon ? There is a rumour that only the one who will collect Codex of Conduct and Creation of the World  can enter the Palace. ",
                "Welcome to the Stark. This place is driven by commerce, corporate power, and rapid growth, with a sharp divide between the rich and poor. "};

    public boolean isGoToPalace() {
        return goToPalace;
    }

    public void setGoToPalace(boolean goToPalace) {
        this.goToPalace = goToPalace;
    }
  
    
    public boolean isTalkWithGuard() {
        return talkWithGuard;
    }

    public void setTalkWithGuard(boolean talkWithGuard) {
        this.talkWithGuard = talkWithGuard;
    }

        
    public void setGoToStark(boolean goBackToStark) {
        this.goToStark = goBackToStark;
    }

    public boolean isGoToStark() {
        return goToStark;
    }

    public int getGUARD_SKILL_POWER() {
        return GUARD_SKILL_POWER;
    }

    public int getGUARD_TOUGHNESS() {
        return GUARD_TOUGHNESS;
    }

    
    public String getGuardName() {
        return guardName;
    }

    public int getGuardHealth() {
        return guardHealth;
    }

    public String getGuardTalks() {
      
        return GUARD_TALKS[random.nextInt(this.GUARD_TALKS.length)];
    }

    public void setGuardHealth(int guardHealth) {
        this.guardHealth = guardHealth;
    }
 
}

    
