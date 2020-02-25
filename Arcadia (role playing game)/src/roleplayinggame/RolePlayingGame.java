
package roleplayinggame;

/**
 *
 * @author Michal Switala
 */
public class RolePlayingGame 
{
    
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {
              
        RolePlayingGame rpg1 = new RolePlayingGame();
      
        //Create player
        Player player1 = new Player();
 
        //Create available heros here
        Invoker invoker1 = new Invoker();
        Warlock warlock1 = new Warlock();
        Sven sven1 = new Sven();
        ChaosKnight chaos1 = new ChaosKnight();
        Omniknight omni1 = new Omniknight();
        ShadowFiend shadow1 = new ShadowFiend();
        
        //Create bosses
        RadiantBoss radiant1 = new RadiantBoss();
        DireBoss dire1 = new DireBoss();
        
        //Create gameLogic and other classes here
        Stark stark1 = new Stark();
        GameLogic gameLog = new GameLogic();
        FightMode fightMod = new FightMode();
        InputWindow inputW = new InputWindow("Arcadia (Gameplay)");
        OutputWindow outputW = new OutputWindow("Arcadia (Story)");
        InputValidator inputV = new InputValidator();
        
        //Print out the story of the game
        gameLog.setNewGame(true);
        outputW = gameLog.showTheStory(outputW);
        outputW = gameLog.askForGame(outputW, "Do you want to begin your journey ?");
        inputW = gameLog.showGameWindow(inputW);
     
        while (gameLog.isNewGame())
        {
            
            //Setup player name, race and choice of characters
            player1 = gameLog.setupPlayer(player1, inputW, inputV);
            player1 = gameLog.chooseRace(player1, inputW, inputV);
            player1 = gameLog.chooseCharacters(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1);

            //Begin game and set stark1.setGoToStark to true
            gameLog.loadGame(inputW, stark1);

  
            while (stark1.isGoToStark()) 
            {  
                gameLog.showDirectons(player1, inputW, inputV, stark1);
                gameLog.goNorth(player1, inputW, inputV, stark1, fightMod);

                if (fightMod.isFightWithGuard()) {

                    gameLog.fightSetup(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod);
                    gameLog.setupEnemy(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod, radiant1, dire1);
                    gameLog.fight(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod);
                    gameLog.loose(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod, radiant1, dire1);
                }
                
     
                //Search for 3 codex inside player inventory before entering palace to make sure player may enter palace
                gameLog.searchForCodex(player1, warlock1, chaos1, invoker1, omni1, shadow1, sven1);
                //Enter the palace if player decides to do so
                gameLog.enterThePalace(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod, dire1, radiant1);
                gameLog.goEast(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod);
                gameLog.goWest(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod);
                gameLog.goSouth(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod);

                //Setup fight and enemy before any fight if player decides to fight
                gameLog.fightSetup(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod);
                gameLog.setupEnemy(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod, radiant1, dire1);
                
                //Only if fightwithGuard is set to true
                while(fightMod.isFightWithBoss() || fightMod.isFightWithEnemyEast() || fightMod.isFightWithEnemySouth() || fightMod.isFightWithEnemyWest()) 
                {
                    gameLog.fight(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod);
                    gameLog.checkHealth(player1, inputW, inputV, stark1, fightMod, dire1, radiant1, rpg1, warlock1, chaos1, invoker1, omni1, shadow1, sven1);
                    gameLog.chooseNewHero(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod);
                    gameLog.loose(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod, radiant1, dire1);
                    gameLog.win(player1, inputW, inputV, warlock1, chaos1, invoker1, omni1, shadow1, sven1, stark1, fightMod, radiant1, dire1);
                    
                }
                
            }
        }
    }
    
   
    
    
    
}
