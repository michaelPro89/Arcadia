
package roleplayinggame;

/**
 *
 * @author Michal Switala
 */
public class GameLogic 
{
         private boolean newGame;
         private boolean win;
         private boolean loose;
         private boolean firstCodex;
         private boolean secondCodex;
         private boolean thirdCodex;

    
    // Put here game logic
    public OutputWindow showTheStory(OutputWindow outputW)
    {
        outputW.showWindow();
        outputW.setVisibleButtons(false);
        outputW.appendTabSizeAt(11);
        outputW.addText("Story:\n"
                + "\n"
                + "      In the Arcadia world there was harmony and God's splendor until the conflict arised between\n"
                + "two opposite movements - Radiants and Dires.\n"
                + "Balance between good and evil is dissolving after death of its Guardian, and must be restored by the appearance of another.");
       
        outputW.nextLine();
        outputW.nextLineWithSeparators();

        outputW.addText("In order to bring balance, someone needs to find 4 missing Codex of Conduct "
                + "and Creation of the World before they will be destroyed, which are spread around the Arcadia world. "
                + "The hope is only in the hands of the newborn child which name is yet unknown and mind is not corrupted.");
        
        outputW.setVisibleButtons(true);
        
        
        
               
        return outputW;
    }
    
       public OutputWindow askForGame(OutputWindow outWindow, String question)
        {
            outWindow.setMessageLabel(question);
            outWindow.waitForDecision();
            
              
            return outWindow;
        }
    
        public InputWindow showGameWindow(InputWindow inputW)
        {
            
            inputW.showWindow();
            return inputW;
            
        }
       
       
    public Player setupPlayer(Player player1, InputWindow inputW, InputValidator inputV)
    {

        inputW.addText("Please choose your name (atleast 4 characters).");
        inputW.nextLine();
        inputW.nextLine();
        inputW.addText("What is your name?: ");
        player1.setName(inputV.checkInputLength(inputW.waitForPlayerInput("Enter your name below: ")));

        //if player enters invalid name ask to enter name once again
        while(inputV.isInputIsNot4Letters())
        {
              player1.setName(inputV.checkInputLength(inputW.waitForPlayerInput("Your name must be atleast 4 characters. Try again. ")));
        }
        
        //Seperate the text above and scroll down to the end of the text
        inputW.separateLines();
        inputW.scrollDown();
      
        return player1;
    }
                
       public Player chooseRace(Player player1, InputWindow inputW, InputValidator inputV) {
 
           
           inputW.addText("Now you have to choose your race.");
           inputW.nextLine();
           inputW.addText("You can choose between Radiants and Dires. ");
           inputW.nextLine();
           inputW.addText("Dires are tough and Radiants have lower toughness but they have higher skills power.");
           inputW.nextLine();
           inputW.addText("Remember, choose wisely as it can't be changed during the game.");
           inputW.nextLine();
           inputW.nextLine();
           inputW.addText("What race do You want to pick?: ");
           inputW.nextLine();
           inputW.addText("1. Radiants");
           inputW.nextLine();
           inputW.addText("2. Dires");

           inputW.scrollDown();

           //ask player to choose Race here
           player1.setPlayerChoice(inputW.waitForPlayerInput("Choose your race below:  "));

           //Check if player choosed a race
           inputV.checkPlayerChoice(2, player1.getPlayerChoice());

           //If not, ask to choose again
           while (inputV.isWrongChoice()) {
               player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between Radiants and Dires:  "));
               inputV.checkPlayerChoice(2, player1.getPlayerChoice());
           }

           
           switch (player1.getPlayerChoice().substring(0, 1))
           {
               case "1":
                   player1.setRace("Radiants");
                   break;
               case "2":
                   player1.setRace("Dires");
                   break;
           }
           
           inputW.separateLines();
           inputW.scrollDown();

         return player1;
        }
       
       public Player chooseCharacters(Player player1, InputWindow inputW, InputValidator inputV, 
               Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, Omniknight omni1, ShadowFiend shadow1, Sven sven1)
       {
            //Local variable to check if Player choosed the same hero again
          boolean duplicateHero = false;
          boolean listIsEmpty = true;
                  
        inputW.addText("Now you have to pick atleast 1 and up to 3 units of availsable heros below: ");
        inputW.nextLine();
        inputW.nextLine();
         
             if(player1.getRace().equalsIgnoreCase("Dires"))
            {   
                inputW.addText("1. "+warlock1.getHERO_NAME()+warlock1.getHeroDescription());
                inputW.nextLine();
                inputW.addText("2. "+chaos1.getHERO_NAME()+chaos1.getHeroDescription() );
                inputW.nextLine();
                inputW.addText("3. "+shadow1.getHERO_NAME()+shadow1.getHeroDescription());
                inputW.nextLine();
                inputW.addText("4. none");
  
                 
                inputW.scrollDown();

            } else if (player1.getRace().equalsIgnoreCase("Radiants"))
            {
                inputW.addText("1. " + invoker1.getHERO_NAME() + invoker1.getHeroDescription());
                inputW.nextLine();
                inputW.addText("2. "+sven1.getHERO_NAME()+sven1.getHeroDescription());
                inputW.nextLine();
                inputW.addText("3. "+omni1.getHERO_NAME()+omni1.getHeroDescription());
                inputW.nextLine();
                inputW.addText("4. none");
                 
                inputW.scrollDown();

            }
        
             
             while(listIsEmpty)
             {
        
            //Loop 3 times and allow player to pick 3 heros  overhere
           for (int unit = 0; unit < player1.getHEROS_LIMIT(); unit++) {
         
               String heroCount = "FIRST";
               
               switch (unit) {
                   case 0:
                       heroCount = " FIRST hero";
                       break;
                   case 1:
                       heroCount = " SECOND hero";
                       break;
                   case 2:
                       heroCount = " THIRD  hero";
                       break;
                   default:
                       break;
               }
               
               //This condition is just to stop player from choosing the same hero and force him to choose 3 different heros
               if (duplicateHero) {
                   player1.setPlayerChoice(inputW.waitForPlayerInput("You have already choosen this hero. Try again:"));
                   inputV.checkPlayerChoice(4, player1.getPlayerChoice());
                   
                   duplicateHero = false;
                   
               } else {
                   player1.setPlayerChoice(inputW.waitForPlayerInput("Pick your"+ heroCount +" and enter below: "));
                   inputV.checkPlayerChoice(4, player1.getPlayerChoice());
               }
               
               while (inputV.isWrongChoice()) {
                   player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose from 1 to 4. Try again: "));
                   inputV.checkPlayerChoice(4, player1.getPlayerChoice());
               }
            
               //Add characters to the list ovehere and check if there is duplication
               switch (player1.getPlayerChoice().substring(0, 1)) {   
                   case "1":

                       if (player1.getRace().equalsIgnoreCase("Dires") && player1.searchForHero("Warlock")) {

                           duplicateHero = true;
                           unit--;

                       } else if (player1.getRace().equalsIgnoreCase("Dires")) {
                           player1.addCharacter("Warlock");
                       }

                       if (player1.getRace().equalsIgnoreCase("Radiants") && player1.searchForHero("Invoker")) {

                           duplicateHero = true;
                           unit--;

                       } else if (player1.getRace().equalsIgnoreCase("Radiants")) {
                           player1.addCharacter("Invoker");
                       }
                       break;

                   case "2":
                       if (player1.getRace().equalsIgnoreCase("Dires") && player1.searchForHero("Chaos Knight")) {

                           duplicateHero = true;
                           unit--;

                       } else if (player1.getRace().equalsIgnoreCase("Dires")) {
                           player1.addCharacter("Chaos Knight");
                       }

                       if (player1.getRace().equalsIgnoreCase("Radiants") && player1.searchForHero("Sven")) {

                           duplicateHero = true;
                           unit--;

                       } else if (player1.getRace().equalsIgnoreCase("Radiants")) {
                           player1.addCharacter("Sven");
                       }

                       break;

                   case "3":
                       if (player1.getRace().equalsIgnoreCase("Dires") && player1.searchForHero("Shadow Fiend")) {

                           duplicateHero = true;
                           unit--;
                       } else if (player1.getRace().equalsIgnoreCase("Dires")) {
                           player1.addCharacter("Shadow Fiend");
                       }

                       if (player1.getRace().equalsIgnoreCase("Radiants") && player1.searchForHero("Omniknight")) {
                           duplicateHero = true;
                           unit--;
                       } else if (player1.getRace().equalsIgnoreCase("Radiants")) {
                           player1.addCharacter("Omniknight");
                       }
                       break;

                   case "4":
                       if (player1.getRace().equalsIgnoreCase("Dires")) {
                           //add nothing
                       } else if (player1.getRace().equalsIgnoreCase("Radiants")) {
                           //add nothing
                       }
                       break;

                }


            }

            //Check if player1.charactersList array has 0 heros inside, if yes then force player to choose once again
               if (player1.isCharactersListEmpty()) {
                   listIsEmpty = true;
                  
                   inputW.nextLine();
                   inputW.nextLine();
                   inputW.addText("You didn't choose any hero. You have to pick atleast 1 up to 3 heros. Try again.");
                   inputW.scrollDown();
               } else {

                   //if player1.characterList has atleast 1 hero inside, get out of the loop 
                   listIsEmpty = false;
                   inputW.separateLines();
                   inputW.addText("Your choosed heros are: ");
                   inputW.nextLine();
                   
                   //debug code
                   System.out.println("Your hero list size is: "+player1.getCharacterListSize());
                   
                   switch (player1.getCharacterListSize())
                   {
                       case 1:     inputW.addText("1. "+player1.showCharacterAt(0));
                       break;
                       case 2:     
                           inputW.addText("1. " + player1.showCharacterAt(0));
                           inputW.nextLine();
                           inputW.addText("2. " + player1.showCharacterAt(1));
                       break;
                       case 3:   
                           inputW.addText("1. " + player1.showCharacterAt(0));
                           inputW.nextLine();
                           inputW.addText("2. " + player1.showCharacterAt(1));
                           inputW.nextLine();
                           inputW.addText("3. " + player1.showCharacterAt(2));
                           break;
                   }
                   inputW.scrollDown();
               }
           }

        return player1;

    }
       
       public void loadGame(InputWindow inputW, Stark stark1)
       {
               
        // pause a game before start for a while and display loading game text
        inputW.loading();
        inputW.separateLines();
        inputW.addText("... You just woke up in your apartment and you go in front of it. You can see a big sign on the wall: "
                + "'Welcome in "+ stark1.getTownName()+ "'. ");
        inputW.nextLine();
        inputW.addText("You can also see beatiful sunshine above in the sky.");
               
        inputW.nextLine();
        inputW.nextLine();
        stark1.setGoToStark(true);

    }
            
              public void showDirectons(Player player1, InputWindow inputW, InputValidator inputV, Stark stark1)
      {
          

         
          inputW.addText("You are in town Stark. ");
          inputW.nextLine();
          inputW.nextLine();
          inputW.addText("Where do you want to go ?:");
          inputW.nextLine();
          inputW.addText("1. North.");
          inputW.nextLine();
          inputW.addText("2. East.");
          inputW.nextLine();
          inputW.addText("3. West.");
          inputW.nextLine();
          inputW.addText("4. South.");
          inputW.scrollDown();

          player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your direction below: "));
          inputV.checkPlayerChoice(4, player1.getPlayerChoice());

          while (inputV.isWrongChoice()) {
              player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 4: "));
              inputV.checkPlayerChoice(4, player1.getPlayerChoice());
          }

          switch(player1.getPlayerChoice().substring(0, 1))
          {
              case "1":  stark1.setGoNorth(true);
             break;
              case "2":  stark1.setGoEast(true);
             break;
              case "3":  stark1.setGoWest(true);
             break;
              case "4":  stark1.setGoSouth(true);
             break;
              
          }
          
          
        //Seperate the text above and scroll down to the end of the text
        inputW.separateLines();
        inputW.scrollDown();
    
      }

       public void goNorth(Player player1, InputWindow inputW, InputValidator inputV, 
                Stark stark1, FightMode fightmod)
       {
           if(stark1.isGoNorth())
           {

               inputW.addText("You are at the North gate. You meet there Guard " + stark1.getGuardName()+".");
               inputW.nextLine();
               inputW.nextLine();
               inputW.addText("What do You want to do ?: ");
               inputW.nextLine();
               inputW.addText("1. Talk to the Guard.");
               inputW.nextLine();
               inputW.addText("2. Attack.");
               inputW.nextLine();
               inputW.addText("3. Keep going North.");
               inputW.nextLine();
               inputW.addText("4. Go back to town.");
               inputW.scrollDown();

               player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
               inputV.checkPlayerChoice(4, player1.getPlayerChoice());

               // Check if player choosed the correct answer, if not then ask again
               while (inputV.isWrongChoice()) {
                   player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 4: "));
                   inputV.checkPlayerChoice(4, player1.getPlayerChoice());
               }

            switch (player1.getPlayerChoice().substring(0, 1)) 
            {
                 //IF player pick "1" as his choice do this: - Talk to guard           
                case "1":
                    
                    inputW.separateLines();
                    inputW.addText("Guard "+stark1.getGuardName()+" says: Greetings " + player1.getPlayerName() + " ! " + stark1.getGuardTalks());
                    inputW.nextLine();
                    inputW.nextLine();
                    inputW.addText("What do you want to do ?: ");
                    inputW.nextLine();
                    inputW.addText("1. Keep going North (Hills of Parnon).");
                    inputW.nextLine();
                    inputW.addText("2. Go back to town.");
                    inputW.scrollDown();
                    
                    player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
                    inputV.checkPlayerChoice(2, player1.getPlayerChoice());

                    while (inputV.isWrongChoice()) {
                        player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                        inputV.checkPlayerChoice(2, player1.getPlayerChoice());
                    }
                    
            
                    if(player1.getPlayerChoice().substring(0, 1).equalsIgnoreCase("1"))
                      {
                             stark1.setGoToPalace(true);
                             inputW.separateLines();
                        } else {
                        
                        stark1.setGoNorth(false);
                        stark1.setGoEast(false);
                        stark1.setGoWest(false);
                        stark1.setGoSouth(false);
                        stark1.setGoToStark(true);
                        inputW.separateLines();
                      }
                            
                    break;
                    
                 //  Attack guard.
                case "2":                  
                    fightmod.setFightWithGuard(true);       
                    fightmod.setFightSetup(true);    
                    inputW.separateLines();
                   break;
            
                // keep going north
                case "3":                      
                    stark1.setGoToPalace(true);
                  inputW.separateLines();
                    break;
                    
                // go back to town 
                case "4": 
                    
                    //Set all directions to false of  world and return back to town
                    stark1.setGoNorth(false);
                    stark1.setGoEast(false);
                    stark1.setGoWest(false);
                    stark1.setGoSouth(false);
                    stark1.setGoToStark(true);
                    inputW.separateLines();
                    break;
           }
              
            inputW.scrollDown();
            stark1.setGoNorth(false);

        }

    }
          
       public void enterThePalace(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod, DireBoss dire1, RadiantBoss radiant1)
      {
        if (stark1.isGoToPalace()) {

            inputW.addText("After a long journey You have finally reached Hills of Parnon. You see a huge Palace on the top of it.");
            inputW.nextLine();
            inputW.nextLine();
            inputW.addText("What do you want to do ?: ");
            inputW.nextLine();
            inputW.addText("1. Try to enter the Palace.");
            inputW.nextLine();
            inputW.addText("2. Go back to town.");
            inputW.scrollDown();

            player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
            inputV.checkPlayerChoice(2, player1.getPlayerChoice());

            while (inputV.isWrongChoice()) {
                player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                inputV.checkPlayerChoice(2, player1.getPlayerChoice());
            }

            inputW.separateLines();

            switch (player1.getPlayerChoice().substring(0, 1)) {
                case "1":
                    //if player has collected all 3 Codex, let him inside Palace
                    if (isFirstCodex() && isSecondCodex() && isThirdCodex()) {
                        if (player1.getRace().equalsIgnoreCase("Dires")) {
                            inputW.nextLine();
                            inputW.addText("You have entered the Palace. You see " + dire1.getBOSS_NAME() + " (BOSS) standing in front of You.");
                            inputW.nextLine();
                            inputW.nextLine();
                            inputW.addText(dire1.getBOSS_NAME() + " says: Hi " + player1.getPlayerName() + ", finally we can meet. You have something that belongs to me.");

                        } else if (player1.getRace().equalsIgnoreCase("Radiants")) {
                            inputW.nextLine();
                            inputW.nextLine();
                            inputW.addText("You have entered the Palace. You see " + radiant1.getBOSS_NAME() + "(BOSS) standing in front of You.");
                            inputW.nextLine();
                            inputW.addText(radiant1.getBOSS_NAME() + " says: Ave " + player1.getPlayerName() + ", I was waiting for this moment. Get over here !#@");

                        }

                        inputW.nextLine();
                        inputW.nextLine();
                        inputW.addText("What do you want to do ?: ");
                        inputW.nextLine();
                        inputW.addText("1. Try to kill him.");
                        inputW.nextLine();
                        inputW.addText("2. Run back to town.");
                        inputW.scrollDown();

                        player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
                        inputV.checkPlayerChoice(2, player1.getPlayerChoice());

                        while (inputV.isWrongChoice()) {
                            player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                            inputV.checkPlayerChoice(2, player1.getPlayerChoice());
                        }

                        if (player1.getPlayerChoice().substring(0, 1).equalsIgnoreCase("1")) {

                            //If player decides to fight with Boss set our booleans to true, so we can get into fight with boss and fight setup later on
                            fightmod.setFightWithBoss(true);
                            fightmod.setFightSetup(true);

                        } else {
                            fightmod.setFightWithGuard(false);
                            fightmod.setFightSetup(false);
                            fightmod.setFightWithBoss(false);
                            fightmod.setFightWithEnemyEast(false);
                            fightmod.setFightWithEnemySouth(false);
                            fightmod.setFightWithEnemyWest(false);
                            stark1.setGoToStark(true);
                        }
                    } //if player didn't collect 3 codex, give him some hint and send him back to the town
                    else {
                        inputW.nextLine();
                        inputW.addText("You are in front of the gate. You hear someone behind the gate saying:  only the one who is worthy may enter the Palace ...  ");
                        inputW.nextLine();
                        inputW.nextLine();
                        inputW.addText("What do you want to do ?: ");
                        inputW.nextLine();
                        inputW.addText("1.  Go back to town.");
                        inputW.scrollDown();

                        player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
                        inputV.checkPlayerChoice(1, player1.getPlayerChoice());

                        while (inputV.isWrongChoice()) {
                            player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose available options only: "));
                            inputV.checkPlayerChoice(1, player1.getPlayerChoice());

                        }

                        switch (player1.getPlayerChoice().substring(0, 1)) {
                            case "1":

                                fightmod.setFightWithGuard(false);
                                fightmod.setFightSetup(false);
                                fightmod.setFightWithBoss(false);
                                fightmod.setFightWithEnemyEast(false);
                                fightmod.setFightWithEnemySouth(false);
                                fightmod.setFightWithEnemyWest(false);
                                stark1.setGoToStark(true);

                                break;
                        }
                    }

                    break;

                case "2":

                    fightmod.setFightWithGuard(false);
                    fightmod.setFightSetup(false);
                    fightmod.setFightWithBoss(false);
                    fightmod.setFightWithEnemyEast(false);
                    fightmod.setFightWithEnemySouth(false);
                    fightmod.setFightWithEnemyWest(false);
                    stark1.setGoToStark(true);
                    break;
            }

            inputW.separateLines();
            inputW.scrollDown();
            stark1.setGoToPalace(false);
        }
    }
 
       public void fightSetup(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod)
       
       {
                    if(fightmod.isFightSetup())
           {
                               
                    inputW.addText("Choose your hero to fight with: ");
                    inputW.nextLine();

                    //show player available heros to pick
	switch (player1.getCharacterListSize()) {
                     case 1:
                         inputW.addText("1. " + player1.showCharacterAt(0));
                         
                         //display health
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Sven")) {               
                              inputW.addText(" (health: "+sven1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Warlock")) {
                               inputW.addText(" (health: "+warlock1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Chaos Knight")) {
                             inputW.addText(" (health: "+chaos1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Invoker")) {
                               inputW.addText(" (health: "+invoker1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Omniknight")) {
                              inputW.addText(" (health: "+omni1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Shadow Fiend")) {
                                inputW.addText(" (health: "+shadow1.getHealth()+")");
                         }
            
                       break;
                       case 2:     
                           inputW.addText("1. " + player1.showCharacterAt(0));
                           
                        //display health
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Sven")) {               
                              inputW.addText(" (health: "+sven1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Warlock")) {
                               inputW.addText(" (health: "+warlock1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Chaos Knight")) {
                             inputW.addText(" (health: "+chaos1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Invoker")) {
                               inputW.addText(" (health: "+invoker1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Omniknight")) {
                              inputW.addText(" (health: "+omni1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Shadow Fiend")) {
                                inputW.addText(" (health: "+shadow1.getHealth()+")");
                         }
            
                           
                           inputW.nextLine();
                           inputW.addText("2. " + player1.showCharacterAt(1));
                           
                      //display health
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Sven")) {               
                              inputW.addText(" (health: "+sven1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Warlock")) {
                               inputW.addText(" (health: "+warlock1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Chaos Knight")) {
                             inputW.addText(" (health: "+chaos1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Invoker")) {
                               inputW.addText(" (health: "+invoker1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Omniknight")) {
                              inputW.addText(" (health: "+omni1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Shadow Fiend")) {
                                inputW.addText(" (health: "+shadow1.getHealth()+")");
                         }
            
                       break;
                       case 3:   
                           inputW.addText("1. " + player1.showCharacterAt(0));
                            //display health
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Sven")) {               
                              inputW.addText(" (health: "+sven1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Warlock")) {
                               inputW.addText(" (health: "+warlock1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Chaos Knight")) {
                             inputW.addText(" (health: "+chaos1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Invoker")) {
                               inputW.addText(" (health: "+invoker1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Omniknight")) {
                              inputW.addText(" (health: "+omni1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(0).equalsIgnoreCase("Shadow Fiend")) {
                                inputW.addText(" (health: "+shadow1.getHealth()+")");
                         }
            
                           inputW.nextLine();
                           inputW.addText("2. " + player1.showCharacterAt(1));
                         //display health
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Sven")) {               
                              inputW.addText(" (health: "+sven1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Warlock")) {
                               inputW.addText(" (health: "+warlock1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Chaos Knight")) {
                             inputW.addText(" (health: "+chaos1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Invoker")) {
                               inputW.addText(" (health: "+invoker1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Omniknight")) {
                              inputW.addText(" (health: "+omni1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(1).equalsIgnoreCase("Shadow Fiend")) {
                                inputW.addText(" (health: "+shadow1.getHealth()+")");
                         }
            
                           inputW.nextLine();
                           inputW.addText("3. " + player1.showCharacterAt(2));
                           
                            //display health
                         if (player1.showCharacterAt(2).equalsIgnoreCase("Sven")) {               
                              inputW.addText(" (health: "+sven1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(2).equalsIgnoreCase("Warlock")) {
                               inputW.addText(" (health: "+warlock1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(2).equalsIgnoreCase("Chaos Knight")) {
                             inputW.addText(" (health: "+chaos1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(2).equalsIgnoreCase("Invoker")) {
                               inputW.addText(" (health: "+invoker1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(2).equalsIgnoreCase("Omniknight")) {
                              inputW.addText(" (health: "+omni1.getHealth()+")");
                         }
                         if (player1.showCharacterAt(2).equalsIgnoreCase("Shadow Fiend")) {
                                inputW.addText(" (health: "+shadow1.getHealth()+")");
                         }
            
                           break;
                   }
                   inputW.scrollDown();
                   
                    player1.setPlayerChoice(inputW.waitForPlayerInput("Choose your hero for fight: "));
                    inputV.checkPlayerChoice(player1.getCharacterListSize(), player1.getPlayerChoice());

                    while (inputV.isWrongChoice()) {
                        player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose your available hero: "));
                        inputV.checkPlayerChoice(player1.getCharacterListSize(), player1.getPlayerChoice());
                    }
                    
                    //assign name of the choosen hero to String so we can use it later in fightmode
                    switch(player1.getPlayerChoice().substring(0, 1))
                    {
                        case "1":
                            fightmod.setHeroName(player1.showCharacterAt(0));
                            break;
                        case "2":
                            fightmod.setHeroName(player1.showCharacterAt(1));
                            break;
                        case "3":
                            fightmod.setHeroName(player1.showCharacterAt(2));
                            break;
                    }

                    // assign information (ex. skill power, skill name )based on hero name to seperate variables                  
                    switch(fightmod.getHeroName())                          
                    {
                        case "Warlock":
                            fightmod.setHeroSkill(warlock1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(warlock1.getSKILL_POWER());
                            fightmod.setHeroToughness(warlock1.getToughness());
                            fightmod.setPlayerHP(warlock1.getHealth());
                            fightmod.setPlayerInventory(warlock1.getInventoryList());
                            break;
                        case "Sven":
                            fightmod.setHeroSkill(sven1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(sven1.getSKILL_POWER());
                            fightmod.setHeroToughness(sven1.getToughness());
                            fightmod.setPlayerHP(sven1.getHealth());
                              fightmod.setPlayerInventory(sven1.getInventoryList());
                            break;
                        case "Omniknight":
                            fightmod.setHeroSkill(omni1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(omni1.getSKILL_POWER());
                            fightmod.setHeroToughness(omni1.getToughness());
                            fightmod.setPlayerHP(omni1.getHealth());
                            fightmod.setPlayerInventory(omni1.getInventoryList());
                            break;
                        case "Invoker":
                            fightmod.setHeroSkill(invoker1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(invoker1.getSKILL_POWER());
                            fightmod.setHeroToughness(invoker1.getToughness());
                            fightmod.setPlayerHP(invoker1.getHealth());
                            fightmod.setPlayerInventory(invoker1.getInventoryList());
                            break;
                        case "Chaos Knight":
                            fightmod.setHeroSkill(chaos1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(chaos1.getSKILL_POWER());
                            fightmod.setHeroToughness(chaos1.getToughness());
                       fightmod.setPlayerHP(chaos1.getHealth());
                       fightmod.setPlayerInventory(chaos1.getInventoryList());
                       break;
                   case "Shadow Fiend":
                       fightmod.setHeroSkill(shadow1.getSKILL_NAME());
                       fightmod.setHeroSkillPower(shadow1.getSKILL_POWER());
                       fightmod.setHeroToughness(shadow1.getToughness());
                       fightmod.setPlayerHP(shadow1.getHealth());
                       fightmod.setPlayerInventory(shadow1.getInventoryList());
                       break;
               }
            
                // end setup overhere and get out of the setupFight method
             fightmod.setFightSetup(false);
           }
      
       }
       
       public void setupEnemy(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod,  RadiantBoss radiant1 , DireBoss dire1)
       {
           
           // dont turn booleans like example fightWithGuard to false HERE as we need it later on in fight method to execute proper code
           //Setup enemy health, name, skillpower etc. overhere
           if (fightmod.isFightWithGuard()) {

               fightmod.setEnemyName(stark1.getGuardName());
               fightmod.setEnemySkillPower(stark1.getGUARD_SKILL_POWER());
               fightmod.setEnemyHP(stark1.getGuardHealth());
               fightmod.setEnemyToughness(stark1.getGUARD_TOUGHNESS());
          

           } else if (fightmod.isFightWithBoss()) {
               //there is different boss for Dires and different for Radiants that's
               //why i have created switch case to assign different variables
               switch (player1.getRace()) {
                   case "Dires":
                       fightmod.setEnemyName(dire1.getBOSS_NAME());
                       fightmod.setEnemySkillPower(dire1.getSKILL_POWER());
                       fightmod.setEnemyHP(dire1.getHealth());
                       fightmod.setEnemyToughness(dire1.getToughness());
                       fightmod.setEnemyInventory(dire1.getBOSS_INVENTORY());
                       break;

                   case "Radiants":
                       fightmod.setEnemyName(radiant1.getBOSS_NAME());
                       fightmod.setEnemySkillPower(radiant1.getSKILL_POWER());
                       fightmod.setEnemyHP(radiant1.getHealth());
                       fightmod.setEnemyToughness(radiant1.getToughness());
                       fightmod.setEnemyInventory(radiant1.getBOSS_INVENTORY());
                       break;
               }

           } else if (fightmod.isFightWithEnemyEast()) {
               switch (player1.getRace()) {

                   case "Dires":
                       OmniknightTheApperentice enemyEast = new  OmniknightTheApperentice();
                       
                       if(isThirdCodex())
                       {
                           enemyEast.removeItem("3th Codex of Conduct and Creation of the World");
                       }
                       
                       fightmod.setEnemyName(enemyEast.getEnemyName());
                       fightmod.setEnemySkillPower(enemyEast.getSKILL_POWER());
                       fightmod.setEnemyHP(enemyEast.getHealth());
                       fightmod.setEnemyToughness(enemyEast.getToughness());
                       fightmod.setEnemyInventory(enemyEast.getInventory());

                       break;

                   case "Radiants":

                       ChaosKnightTheSlave eneEastRadiant = new ChaosKnightTheSlave();

                       if(isThirdCodex())
                       {
                          eneEastRadiant.removeItem("3th Codex of Conduct and Creation of the World");
                       }
                       
                       
                       fightmod.setEnemyName(eneEastRadiant.getEnemyName());
                       fightmod.setEnemySkillPower(eneEastRadiant.getSKILL_POWER());
                       fightmod.setEnemyHP(eneEastRadiant.getHealth());
                       fightmod.setEnemyToughness(eneEastRadiant.getToughness());
                       fightmod.setEnemyInventory(eneEastRadiant.getInventory());

                       break;
               }

           } else if (fightmod.isFightWithEnemyWest()) {
               switch (player1.getRace()) {

                   case "Dires":
                       InvokerTheApperentice  invoEne = new InvokerTheApperentice();
                       
                       if (isSecondCodex()) {
                           
                           invoEne.removeItem("2th Codex of Conduct and Creation of the World");
                       }
                       
                       fightmod.setEnemyName(invoEne.getEnemyName());
                       fightmod.setEnemySkillPower(invoEne.getSKILL_POWER());
                       fightmod.setEnemyHP(invoEne.getHealth());
                       fightmod.setEnemyToughness(invoEne.getToughness());
                       fightmod.setEnemyInventory(invoEne.getInventory());

                       break;

                   case "Radiants":

                       ShadowFiendTheSlave enem1 = new ShadowFiendTheSlave();

                       if (isSecondCodex()) {

                           enem1.removeItem("2th Codex of Conduct and Creation of the World");
                       }

                       fightmod.setEnemyName(enem1.getEnemyName());
                       fightmod.setEnemySkillPower(enem1.getSKILL_POWER());
                       fightmod.setEnemyHP(enem1.getHealth());
                       fightmod.setEnemyToughness(enem1.getToughness());
                       fightmod.setEnemyInventory(enem1.getInventory());

                       break;
               }

           } else if (fightmod.isFightWithEnemySouth()) {
               

               switch (player1.getRace()) {

                   case "Dires":
                       SvenTheApperentice enemySouth = new SvenTheApperentice();
                       
                       if (isFirstCodex()) {

                           enemySouth.removeItem("1th Codex of Conduct and Creation of the World");
                       }
                       
                       fightmod.setEnemyName(enemySouth.getEnemyName());
                       fightmod.setEnemySkillPower(enemySouth.getSKILL_POWER());
                       fightmod.setEnemyHP(enemySouth.getHealth());
                       fightmod.setEnemyToughness(enemySouth.getToughness());
                       fightmod.setEnemyInventory(enemySouth.getInventory());

                       break;

                   case "Radiants":

                       WarlockTheSlave wrl = new WarlockTheSlave();

                       if (isFirstCodex()) {

                           wrl.removeItem("1th Codex of Conduct and Creation of the World");
                       }
                       
                       fightmod.setEnemyName(wrl.getEnemyName());
                       fightmod.setEnemySkillPower(wrl.getSKILL_POWER());
                       fightmod.setEnemyHP(wrl.getHealth());
                       fightmod.setEnemyToughness(wrl.getToughness());
                       fightmod.setEnemyInventory(wrl.getInventory());

                       break;
               }
               
              
           }
       }
       
       
       public void fight(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod)
       {
           
           // Deal damage to each other overhere in all possible types of fights in the game
           if (fightmod.isFightWithGuard() || fightmod.isFightWithBoss() || fightmod.isFightWithEnemySouth() || fightmod.isFightWithEnemyEast() || fightmod.isFightWithEnemyWest()) {
  
               // Deal and set damage ovehere
               fightmod.setHeroDamage(fightmod.attackEnemy());
               fightmod.setEnemyDamage(fightmod.attackPlayer());


               inputW.separateLines();
               inputW.addText("You hit " + fightmod.getEnemyName() + " for " + fightmod.getHeroDamage() + " hitpoints with "
                       + fightmod.getHeroName() + " using " + fightmod.getHeroSkill() + " skill. ");
               inputW.nextLine();
               inputW.addText(fightmod.getEnemyName() + " hits You for " + fightmod.getEnemyDamage() + " hitpoints.  ");
               inputW.nextLine();
               inputW.nextLine();  
               inputW.addText(fightmod.getEnemyName() + " has: " + fightmod.getEnemyHP() + " health. ");
               inputW.nextLine();
               inputW.addText("You have: " + fightmod.getPlayerHP() + " health. ");

                  switch(fightmod.getHeroName())                          
               {
                   case "Warlock":
                       warlock1.setHealth(fightmod.getPlayerHP());
                       break;
                   case "Sven":
                       sven1.setHealth(fightmod.getPlayerHP());
                       break;
                   case "Omniknight":
                       omni1.setHealth(fightmod.getPlayerHP());
                       break;
                   case "Invoker":
                       invoker1.setHealth(fightmod.getPlayerHP());
                       break;
                   case "Chaos Knight":
                       chaos1.setHealth(fightmod.getPlayerHP());
                       break;
                   case "Shadow Fiend":
                       shadow1.setHealth(fightmod.getPlayerHP());
                       break;
               }

           }
       
           
           // Remove hero from player hero list if it dies 
           if (fightmod.isFightWithGuard()) {

               if (fightmod.getPlayerHP() <= 0) {

                   //remove hero from the hero list
                   player1.removeCharacter(fightmod.getHeroName());

                   //check if list of heros is empty
                   if (player1.getCharacterListSize() == 0) {
                    
                    setLoose(true);
                    
                   } else {
             
                       //Retrieve items from dead hero and save  to other heros which are still alive
                       
                       if (player1.charactersList.contains("Warlock")) {
                           fightmod.retrieveItems(warlock1.getInventoryList());
                       } else if (player1.charactersList.contains("Sven")) {
                           fightmod.retrieveItems(sven1.getInventoryList());
                       } else if (player1.charactersList.contains("Invoker")) {
                          fightmod.retrieveItems(invoker1.getInventoryList());
                       } else if (player1.charactersList.contains("Chaos Knight")) {
                             fightmod.retrieveItems(chaos1.getInventoryList());
                       } else if (player1.charactersList.contains("Omniknight")) {
                             fightmod.retrieveItems(omni1.getInventoryList());
                       } else if (player1.charactersList.contains("Shadow Fiend")) {
                           fightmod.retrieveItems(shadow1.getInventoryList());
                       }
                       
                       inputW.addText("Your hero " + fightmod.getHeroName() + " has died.");
                       inputW.nextLine();
                        inputW.addText("All Items from dead hero "+fightmod.getHeroName()+" has been picked up by Your other hero.");
                       inputW.scrollDown();

                   }

               }

               //Print out warning text from guard
               inputW.nextLine();
               inputW.nextLine();
               inputW.addText("Guard " + stark1.getGuardName() + ": I'm warning You " + player1.getPlayerName() + ", next time I won't be so nice!");
               inputW.nextLine();
               inputW.nextLine();
               inputW.addText("What do you want to do ?: ");
               inputW.nextLine();
               inputW.addText("1. Keep going North.");
               inputW.nextLine();
               inputW.addText("2. Go back to town.");
               inputW.scrollDown();

                    player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
                    inputV.checkPlayerChoice(2, player1.getPlayerChoice());

                    while (inputV.isWrongChoice()) {
                        player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                        inputV.checkPlayerChoice(2, player1.getPlayerChoice());
                    }
                    
            switch (player1.getPlayerChoice().substring(0, 1)) {
                case "1":
                    fightmod.setFightWithGuard(false);
                    stark1.setGoToPalace(true);
                    break;
                
                case "2":
                    fightmod.setFightWithGuard(false);
                    stark1.setGoToStark(true);
                    break;
                
              }

            inputW.separateLines();
        }

    }


           public void checkHealth (Player player1, InputWindow inputW, InputValidator inputV, Stark stark1, FightMode fightmod, DireBoss dire1, RadiantBoss radiant1, RolePlayingGame rpg1,
           Warlock warlock1, ChaosKnight chaos1, Invoker invoker1,  Omniknight omni1, ShadowFiend shadow1, Sven sven1)
           
         {

        // if enemy and player hero has died at the same time, just print out info and add item from enemy to player inventory
        if (fightmod.getEnemyHP() <= 0 && fightmod.getPlayerHP() <= 0) {

           
            if (fightmod.isFightWithBoss())
            {
                
                // if there are no more heros left to choose for player, set boolean loose to true   
                if (player1.getCharacterListSize() == 0) {
                    setLoose(true);
                } else {

                    setWin(true);
                    
                }
                
            } else if (fightmod.isFightWithEnemyEast() || fightmod.isFightWithEnemySouth() || fightmod.isFightWithEnemyWest()) {
                
                if (player1.getCharacterListSize() == 0) {
                    
                    setLoose(true);

                    //if list of heros is 1 or 1> say that enemy is dead and pick items
                } else {
                    
                    player1.removeCharacter(fightmod.getHeroName());

                    // say that enemy is dead and you have found codex 
                    inputW.nextLine();
                    inputW.nextLine();
                    inputW.addText("You have killed " + fightmod.getEnemyName() + ".");
                    inputW.nextLine();
                    inputW.addText("You have found and picked up items: ");
                    inputW.nextLine();
                    inputW.addText("" + fightmod.getEnemyInventory());
                    inputW.nextLine();
                    inputW.addText("Your hero " + fightmod.getHeroName() + " has died.");
                    inputW.nextLine();
                    inputW.addText("Items from dead hero has been picked up by others.");
                    inputW.nextLine();
                    inputW.nextLine();
                    inputW.addText("What do You want to do ?: ");
                    inputW.nextLine();
                    inputW.addText("1. Go back to town.");

                        //Retrieve AND save new found items and add them to other heros which are still alive
                       if (player1.charactersList.contains("Warlock")) {
                        fightmod.retrieveItems(warlock1.getInventoryList());
                        fightmod.addItems(warlock1.getInventoryList());
                    } else if (player1.charactersList.contains("Sven")) {
                        fightmod.retrieveItems(sven1.getInventoryList());
                        fightmod.addItems(sven1.getInventoryList());
                    } else if (player1.charactersList.contains("Invoker")) {
                        fightmod.retrieveItems(invoker1.getInventoryList());
                        fightmod.addItems(invoker1.getInventoryList());
                    } else if (player1.charactersList.contains("Chaos Knight")) {
                        fightmod.retrieveItems(chaos1.getInventoryList());
                        fightmod.addItems(chaos1.getInventoryList());
                    } else if (player1.charactersList.contains("Omniknight")) {
                        fightmod.retrieveItems(omni1.getInventoryList());
                        fightmod.addItems(omni1.getInventoryList());
                    } else if (player1.charactersList.contains("Shadow Fiend")) {
                        fightmod.retrieveItems(shadow1.getInventoryList());
                        fightmod.addItems(shadow1.getInventoryList());
                    }

                  
                       inputW.scrollDown();
                    
                
                    }
                    
                    player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
                    inputV.checkPlayerChoice(1, player1.getPlayerChoice());
                    
                    while (inputV.isWrongChoice()) {
                        player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose available options: "));
                        inputV.checkPlayerChoice(1, player1.getPlayerChoice());
                    }
                    
                    switch (player1.getPlayerChoice().substring(0, 1)) {
                        case "1":                            
                            
                            fightmod.setFightWithEnemyEast(false);
                            fightmod.setFightWithEnemySouth(false);
                            fightmod.setFightWithEnemyWest(false);
                            stark1.setGoToStark(true);
                            
                            break;
                        
                    }
                    
                }
           inputW.separateLines();
            
        } else if (fightmod.getEnemyHP() <= 0) {
            if (fightmod.isFightWithBoss()) {
                
                setWin(true);
                
            } else if (fightmod.isFightWithEnemyEast() || fightmod.isFightWithEnemySouth() || fightmod.isFightWithEnemyWest()) {
                        
                inputW.nextLine();
                inputW.nextLine();
                inputW.addText("You have killed " + fightmod.getEnemyName()+".");
                inputW.nextLine();
                inputW.addText("You have found and picked up items: ");
                inputW.nextLine();
                inputW.addText(""+fightmod.getEnemyInventory());    
                inputW.nextLine();
                inputW.nextLine();
                inputW.addText("What do You want to do ?: ");
                inputW.nextLine();
                inputW.addText("1. Go back to town.");
                inputW.scrollDown();

                // Add found items to hero inventory 
                switch (fightmod.getHeroName()) {
                    case "Warlock":
                        fightmod.addItems(warlock1.getInventoryList());
                        System.out.println("**********************************************");
                        System.out.println("WARLOCK HAS INSIDE: " +warlock1.getInventoryList());
                         System.out.println("**********************************************");
                        break;
                        
                    case "Sven":
                        fightmod.addItems(sven1.getInventoryList());
                        System.out.println("**********************************************");
                        System.out.println("SVEN HAS INSIDE: " +sven1.getInventoryList());
                         System.out.println("**********************************************");
                        break;
                    case "Omniknight":
                        fightmod.addItems(omni1.getInventoryList());
                        System.out.println("**********************************************");
                        System.out.println("OMNI HAS INSIDE: " +omni1.getInventoryList());
                         System.out.println("**********************************************");
                        break;
                    case "Invoker":
                        fightmod.addItems(invoker1.getInventoryList());
                        System.out.println("**********************************************");
                        System.out.println("INVOKER HAS INSIDE: " +invoker1.getInventoryList());
                         System.out.println("**********************************************");
                        break;
                    case "Chaos Knight":
                        fightmod.addItems(chaos1.getInventoryList());
                        System.out.println("**********************************************");
                        System.out.println("CHAOS HAS INSIDE: " +chaos1.getInventoryList());
                         System.out.println("**********************************************");
                        break;
                    case "Shadow Fiend":
                        fightmod.addItems(shadow1.getInventoryList());
                        System.out.println("**********************************************");
                        System.out.println("SHADOW HAS INSIDE: " +shadow1.getInventoryList());
                         System.out.println("**********************************************");
                        break;
                }
                
                player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
                inputV.checkPlayerChoice(1, player1.getPlayerChoice());
                
                while (inputV.isWrongChoice()) {
                    player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose available options: "));
                    inputV.checkPlayerChoice(1, player1.getPlayerChoice());
                }
                
                switch (player1.getPlayerChoice().substring(0, 1)) {
                    case "1":
                        fightmod.setFightSetup(false);
                        fightmod.setFightWithEnemyEast(false);
                        fightmod.setFightWithEnemySouth(false);
                        fightmod.setFightWithEnemyWest(false);
                        stark1.setGoToStark(true);
                      
                        break;

                }
               
            }
            inputW.separateLines();

         //If player dies do this:
            
        }else if (fightmod.getPlayerHP() <= 0) {

            //remove hero from the hero list
            player1.removeCharacter(fightmod.getHeroName());

            //check if list of heros is empty, if yes then game is over
            if (player1.getCharacterListSize() == 0) {

                setLoose(true);

            } else {

                     //Retrieve items from dead hero and save  to other heros which are still alive
                if (player1.charactersList.contains("Warlock")) {
                    fightmod.retrieveItems(warlock1.getInventoryList());
                } else if (player1.charactersList.contains("Sven")) {
                    fightmod.retrieveItems(sven1.getInventoryList());
                } else if (player1.charactersList.contains("Invoker")) {
                    fightmod.retrieveItems(invoker1.getInventoryList());
                } else if (player1.charactersList.contains("Chaos Knight")) {
                    fightmod.retrieveItems(chaos1.getInventoryList());
                } else if (player1.charactersList.contains("Omniknight")) {
                    fightmod.retrieveItems(omni1.getInventoryList());
                } else if (player1.charactersList.contains("Shadow Fiend")) {
                    fightmod.retrieveItems(shadow1.getInventoryList());
                }

                inputW.addText("Your hero " + fightmod.getHeroName() + " has died.");
                inputW.nextLine();
                inputW.addText("Items from dead hero has been picked up by others.");
                inputW.nextLine();
                inputW.nextLine();
                inputW.addText("What do You want to do ?: ");
                inputW.nextLine();
                inputW.addText("1. Choose another hero.");
                inputW.nextLine();
                inputW.addText("2. Go back to town.");
                inputW.scrollDown();

                    player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
                    inputV.checkPlayerChoice(2, player1.getPlayerChoice());

                    while (inputV.isWrongChoice()) {
                        player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                        inputV.checkPlayerChoice(2, player1.getPlayerChoice());
                    }

                switch (player1.getPlayerChoice().substring(0, 1)) {
                    case "1":
                        fightmod.setChooseNewHero(true);
                        break;
                        
                    case "2":
                        // Go back to stark
                        fightmod.setFightWithGuard(false);
                        fightmod.setFightSetup(false);
                        fightmod.setFightWithBoss(false);
                        fightmod.setFightWithEnemyEast(false);
                        fightmod.setFightWithEnemySouth(false);
                        fightmod.setFightWithEnemyWest(false);
                        stark1.setGoToStark(true);
                        break;

                }
      
                }
            
       inputW.separateLines();
            
            // If  both hero and enemy or none died, ask player if he wants to keep attacking enemy
            } else {
                
               inputW.nextLine();
               inputW.nextLine();
               inputW.addText("What do You want to do ?: ");
               inputW.nextLine();
               inputW.addText("1. Attack.");
               inputW.nextLine();
               inputW.addText("2. Go back to town.");
               inputW.scrollDown();

                    player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
                    inputV.checkPlayerChoice(2, player1.getPlayerChoice());

                    while (inputV.isWrongChoice()) {
                        player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                        inputV.checkPlayerChoice(2, player1.getPlayerChoice());
                    }

                switch (player1.getPlayerChoice().substring(0, 1)) {
                    case "1":
                        

                        fightmod.setFightWithEnemyEast(true);
                        fightmod.setFightWithEnemySouth(true);
                        fightmod.setFightWithEnemyWest(true);
           
                        
                        break;
                    case "2":

                        fightmod.setFightSetup(false);
                        fightmod.setFightWithBoss(false);
                        fightmod.setFightWithEnemyEast(false);
                        fightmod.setFightWithEnemySouth(false);
                        fightmod.setFightWithEnemyWest(false);
                        fightmod.setFightWithGuard(false);
                        stark1.setGoToStark(true);  
                        
                        inputW.separateLines();
                        
                        break;

                }

                      
            
            }
        }
  
  
      public void test(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod)
      {
          
          System.out.println("**************************");

          SvenTheApperentice ene1 = new SvenTheApperentice();
          WarlockTheSlave ene2 = new WarlockTheSlave();
          
          fightmod.setPlayerInventory(sven1.getInventoryList());
          sven1.setInventoryList(fightmod.getPlayerInventory());
          System.out.println("Sven inventory has: "+sven1.getInventoryList());
            System.out.println("**************************");
            
          fightmod.setPlayerInventory(ene1.getInventory());
          sven1.setInventoryList(fightmod.getPlayerInventory());
          
           System.out.println("Sven inventory has: "+sven1.getInventoryList());
            System.out.println("**************************");
            
            fightmod.setPlayerInventory(ene2.getInventory());
          sven1.setInventoryList(fightmod.getPlayerInventory());
          
           System.out.println("Sven inventory has: "+sven1.getInventoryList());
            System.out.println("**************************");


      }
           

       public void chooseNewHero(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod)
       {
           if (fightmod.isChooseNewHero())
           {
       
                    switch(player1.getPlayerChoice().substring(0, 1))
                    {
                        case "1":
                                                          
                            inputW.nextLine();
                            inputW.nextLine();
                            inputW.addText("Choose your hero to fight with: ");
                            inputW.nextLine();
                            
                            //show player available heros to pick
                                switch (player1.getCharacterListSize()) {
                                    case 1:
                                        inputW.addText("1. " + player1.showCharacterAt(0));
                                        break;
                                    case 2:
                                        inputW.addText("1. " + player1.showCharacterAt(0));
                                        inputW.nextLine();
                                        inputW.addText("2. " + player1.showCharacterAt(1));
                                        break;
                                    case 3:
                                        inputW.addText("1. " + player1.showCharacterAt(0));
                                        inputW.nextLine();
                                        inputW.addText("2. " + player1.showCharacterAt(1));
                                        inputW.nextLine();
                                        inputW.addText("3. " + player1.showCharacterAt(2));
                                        break;
                                }
                        
                            
                            
                   inputW.scrollDown();
                   
                    player1.setPlayerChoice(inputW.waitForPlayerInput("Choose your hero for fight: "));
                    inputV.checkPlayerChoice(player1.getCharacterListSize(), player1.getPlayerChoice());

                    while (inputV.isWrongChoice()) {
                        player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose your available hero: "));
                        inputV.checkPlayerChoice(player1.getCharacterListSize(), player1.getPlayerChoice());
                    }
                    
                    //assign name of the choosen hero to String so we can use it later in fightmode
                    switch(player1.getPlayerChoice().substring(0, 1))
                    {
                        case "1":
                            fightmod.setHeroName(player1.showCharacterAt(0));
                            break;
                        case "2":
                            fightmod.setHeroName(player1.showCharacterAt(1));
                            break;
                        case "3":
                            fightmod.setHeroName(player1.showCharacterAt(2));
                            break;
                    }

                    
                   //Assign NEW hero skills, hero toughness etc.
                  switch(fightmod.getHeroName())                          
                    {
                        case "Warlock":
                            fightmod.setHeroSkill(warlock1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(warlock1.getSKILL_POWER());
                            fightmod.setHeroToughness(warlock1.getToughness());
                            fightmod.setPlayerHP(warlock1.getHealth());
                            fightmod.setPlayerInventory(warlock1.getInventoryList());
                            break;
                        case "Sven":
                            fightmod.setHeroSkill(sven1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(sven1.getSKILL_POWER());
                            fightmod.setHeroToughness(sven1.getToughness());
                            fightmod.setPlayerHP(sven1.getHealth());
                              fightmod.setPlayerInventory(sven1.getInventoryList());
                            break;
                        case "Omniknight":
                            fightmod.setHeroSkill(omni1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(omni1.getSKILL_POWER());
                            fightmod.setHeroToughness(omni1.getToughness());
                            fightmod.setPlayerHP(omni1.getHealth());
                            fightmod.setPlayerInventory(omni1.getInventoryList());
                            break;
                        case "Invoker":
                            fightmod.setHeroSkill(invoker1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(invoker1.getSKILL_POWER());
                            fightmod.setHeroToughness(invoker1.getToughness());
                            fightmod.setPlayerHP(invoker1.getHealth());
                            fightmod.setPlayerInventory(invoker1.getInventoryList());
                            break;
                        case "Chaos Knight":
                            fightmod.setHeroSkill(chaos1.getSKILL_NAME());
                            fightmod.setHeroSkillPower(chaos1.getSKILL_POWER());
                            fightmod.setHeroToughness(chaos1.getToughness());
                       fightmod.setPlayerHP(chaos1.getHealth());
                       fightmod.setPlayerInventory(chaos1.getInventoryList());
                       break;
                   case "Shadow Fiend":
                       fightmod.setHeroSkill(shadow1.getSKILL_NAME());
                       fightmod.setHeroSkillPower(shadow1.getSKILL_POWER());
                       fightmod.setHeroToughness(shadow1.getToughness());
                       fightmod.setPlayerHP(shadow1.getHealth());
                       fightmod.setPlayerInventory(shadow1.getInventoryList());
                       break;
                  }
                  
                            break;
                            
                        case "2": 
                            
                            //Stop fighting and go back to town
                            fightmod.setFightWithGuard(false);
                            fightmod.setFightSetup(false);
                            fightmod.setFightWithBoss(false);
                            fightmod.setFightWithEnemyEast(false);
                            fightmod.setFightWithEnemySouth(false);
                            fightmod.setFightWithEnemyWest(false);

                            stark1.setGoToStark(true);
                             
                            inputW.separateLines();
                            inputW.scrollDown();
                            break;
                    }
                    
               fightmod.setChooseNewHero(false);
           }
       }
       
       
    public void heal(Player player1, InputWindow inputW,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, Omniknight omni1, ShadowFiend shadow1, Sven sven1) {
        
        boolean healingPotion = false;
        int heal = 15;
        
        if (player1.charactersList.contains("Warlock")) {
            
            healingPotion = warlock1.searchInventoryFor("healing potion");
            
            if (healingPotion) {
                
                warlock1.setHealth(warlock1.getHealth() + heal);
                inputW.addText("Health of Your hero "+warlock1.getHERO_NAME()+ " has been restored for: "+ heal + " HP.");
                
            }
        }    
        
        if (player1.charactersList.contains("Sven")) {
            
            healingPotion = sven1.searchInventoryFor("healing potion");
            
            if (healingPotion) {
                
                sven1.setHealth(sven1.getHealth() + heal);
                 inputW.addText("Health of Your hero "+sven1.getHERO_NAME()+ " has been restored for: "+ heal + " HP.");
            }
        }
        
        if (player1.charactersList.contains("Invoker")) {
            
            healingPotion = invoker1.searchInventoryFor("healing potion");
            
            if (healingPotion) {
                
                invoker1.setHealth(invoker1.getHealth() + heal);
                 inputW.addText("Health of Your hero "+invoker1.getHERO_NAME()+ " has been restored for: "+ heal + " HP.");
                
            }
        }
        
          if (player1.charactersList.contains("Chaos Knight")) {
            
            healingPotion = chaos1.searchInventoryFor("healing potion");
            
            if (healingPotion) {
                
                chaos1.setHealth(chaos1.getHealth() + heal);
                 inputW.addText("Health of Your hero "+chaos1.getHERO_NAME()+ " has been restored for: "+ heal + " HP.");
                
            }
        }
         if (player1.charactersList.contains("Shadow Fiend")) {
            
            healingPotion = shadow1.searchInventoryFor("healing potion");
            
            if (healingPotion) {
                
                shadow1.setHealth(shadow1.getHealth() + heal);
                 inputW.addText("Health of Your hero "+shadow1.getHERO_NAME()+ " has been restored for: "+ heal + " HP.");
                
            }
        }
        if (player1.charactersList.contains("Omniknight")) {

            healingPotion = chaos1.searchInventoryFor("healing potion");

            if (healingPotion) {

                omni1.setHealth(omni1.getHealth() + heal);
                inputW.addText("Health of Your hero " + omni1.getHERO_NAME() + " has been restored for: " + heal + " HP.");

            }
        }

    }
       
       
       public void searchForCodex(Player player1,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1,Omniknight omni1, ShadowFiend shadow1, Sven sven1)
       {
  
               boolean hasCodex;
           
           if (player1.charactersList.contains("Warlock")) {

               hasCodex = warlock1.searchInventoryFor("1th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setFirstCodex(true);
               }

               hasCodex = warlock1.searchInventoryFor("2th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setSecondCodex(true);
               }

               hasCodex = warlock1.searchInventoryFor("3th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setThirdCodex(true);
               }
               
               hasCodex = false;
           }

           if (player1.charactersList.contains("Sven")) {
               hasCodex = sven1.searchInventoryFor("1th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setFirstCodex(true);
               }

               hasCodex = sven1.searchInventoryFor("2th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setSecondCodex(true);
               }

               hasCodex = sven1.searchInventoryFor("3th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setThirdCodex(true);
               }

               hasCodex = false;

           }
        if (player1.charactersList.contains("Invoker")) {
               hasCodex = invoker1.searchInventoryFor("1th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setFirstCodex(true);
               }

               hasCodex = invoker1.searchInventoryFor("2th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setSecondCodex(true);
               }

               hasCodex = invoker1.searchInventoryFor("3th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setThirdCodex(true);
               }
               
               hasCodex = false;

        }
        if (player1.charactersList.contains("Chaos Knight")) {
          hasCodex = chaos1.searchInventoryFor("1th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setFirstCodex(true);
               }

               hasCodex = chaos1.searchInventoryFor("2th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setSecondCodex(true);
               }

               hasCodex =  chaos1.searchInventoryFor("3th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setThirdCodex(true);
               }
               
               hasCodex = false;
        }
        if (player1.charactersList.contains("Omniknight")) {
                hasCodex = omni1.searchInventoryFor("1th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setFirstCodex(true);
               }

               hasCodex = omni1.searchInventoryFor("2th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setSecondCodex(true);
               }

               hasCodex = omni1.searchInventoryFor("3th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setThirdCodex(true);
               }
               
               hasCodex = false;
        }
        if (player1.charactersList.contains("Shadow Fiend")) {
                  hasCodex = shadow1.searchInventoryFor("1th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setFirstCodex(true);
               }

               hasCodex = shadow1.searchInventoryFor("2th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setSecondCodex(true);
               }

               hasCodex = shadow1.searchInventoryFor("3th Codex of Conduct and Creation of the World");

               if (hasCodex) {
                   setThirdCodex(true);
               }
               
               hasCodex = false;
        }

        System.out.println("**********************************************");
        System.out.println(" HAS FIRST CODEX ? " + isFirstCodex());
        System.out.println(" HAS SECOND CODEX ? " + isSecondCodex());
        System.out.println(" HAS THIRD CODEX ? " + isThirdCodex());
        System.out.println("**********************************************");
    }

       public void goEast(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod)
       {          
           if (stark1.isGoEast()) {
    
               
               inputW.addText("You are at the East river. You have encountered an enemy: ");
               
               switch (player1.getRace()) {
                   case "Radiants":
                       ChaosKnightTheSlave enemy1 = new ChaosKnightTheSlave();
                       inputW.addText(enemy1.getEnemyName()+".");
                       break;

                   case "Dires":
                       OmniknightTheApperentice enemyEast = new OmniknightTheApperentice();
                       inputW.addText(enemyEast.getEnemyName()+".");
                       break;

               }
               inputW.nextLine();
                 inputW.nextLine();
               inputW.addText("What do You want to do ?:");
               inputW.nextLine();
               inputW.addText("1. Attack");
               inputW.nextLine();
               inputW.addText("2. Run.");
               inputW.scrollDown();
               
               player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
               inputV.checkPlayerChoice(2, player1.getPlayerChoice());
               
               while (inputV.isWrongChoice()) {
                   player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                   inputV.checkPlayerChoice(2, player1.getPlayerChoice());
               }
               
               switch (player1.getPlayerChoice().substring(0, 1)) {
                   case "1":                       
                       
                       fightmod.setFightWithEnemyEast(true);
                       fightmod.setFightSetup(true);
                       
                       break;
                   
                   case "2":                       
                       
                       stark1.setGoToStark(true);
                       
                       break;
                   
               }
               
               inputW.separateLines();
               inputW.scrollDown();
               stark1.setGoEast(false);
           }
           
    }
       
       public void goWest(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod)
       {
                if(stark1.isGoWest())
           {
               
               inputW.addText("You are at the west bridge. You have encountered an enemy: ");
               
               switch (player1.getRace()) {
                   case "Radiants":
                       WarlockTheSlave wrl = new WarlockTheSlave();
                       inputW.addText(wrl.getEnemyName() + ".");
                       break;

                   case "Dires":
                       InvokerTheApperentice  invoEne = new InvokerTheApperentice();
                       inputW.addText(invoEne.getEnemyName()+".");
                       break;

               }
               
               inputW.nextLine();
                 inputW.nextLine();
               inputW.addText("What do You want to do ?:");
               inputW.nextLine();
               inputW.addText("1. Attack");
               inputW.nextLine();
               inputW.addText("2. Run.");
               inputW.scrollDown();
               
               player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
               inputV.checkPlayerChoice(2, player1.getPlayerChoice());
               
               while (inputV.isWrongChoice()) {
                   player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                   inputV.checkPlayerChoice(2, player1.getPlayerChoice());
               }
               
               switch (player1.getPlayerChoice().substring(0, 1)) {
                   case "1":                       
                       
                       fightmod.setFightWithEnemyWest(true);
                       fightmod.setFightSetup(true);
                       
                       break;
                   
                   case "2":                       
                       
                       stark1.setGoToStark(true);
                       
                       break;
                   
               }
               
               inputW.separateLines();
               inputW.scrollDown();
               stark1.setGoWest(false);
        }       
           
       }
       
       public void goSouth(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod)
       {
           
                 if(stark1.isGoSouth())
           {
           
               inputW.addText("You have left the town. You can see far away ");
               
               switch (player1.getRace()) {
                   case "Radiants":
                       inputW.addText("Dires camp. You can also see that: ");
                       WarlockTheSlave wrl = new WarlockTheSlave();
                       inputW.addText(wrl.getEnemyName() + " is approaching towards You.");
                       break;

                   case "Dires":
                       SvenTheApperentice enemySouth = new SvenTheApperentice();
                       inputW.addText("Radiants camp. You can see also that: ");
     
                       inputW.addText(enemySouth.getEnemyName() + " is approaching towards You.");
                       break;

               }
               
               inputW.nextLine();
                 inputW.nextLine();
               inputW.addText("What do You want to do ?:");
               inputW.nextLine();
               inputW.addText("1. Attack.");
               inputW.nextLine();
               inputW.addText("2. Run back to town.");
               inputW.scrollDown();
               
               player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
               inputV.checkPlayerChoice(2, player1.getPlayerChoice());
               
               while (inputV.isWrongChoice()) {
                   player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose between 1 and 2: "));
                   inputV.checkPlayerChoice(2, player1.getPlayerChoice());
               }
               
               switch (player1.getPlayerChoice().substring(0, 1)) {
                   case "1":                       
                       
                       fightmod.setFightWithEnemySouth(true);
                       fightmod.setFightSetup(true);
                       
                       break;
                   
                   case "2":                       
                       
                       stark1.setGoToStark(true);
                       
                       break;
                   
               }
                   
               inputW.separateLines();
               inputW.scrollDown();
               stark1.setGoSouth(false);
           }  
      
       }

       public void win(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod,  RadiantBoss radiant1 , DireBoss dire1)
     {
         // If player Win the game... ;)
         
        if (isWin()) {
            switch (player1.getRace()) {
                case "Dires":

                    inputW.addText("You have managed to kill " + dire1.getBOSS_NAME() + " You have found 4th missing Codex of Conduct. You now all Codexes of Conduct and Creation of the World and You feel You are ready "
                            + "You can see from the hill that the Stark is on fire and You can feel that You are ready"
                            + " to conquer the rest World of Arcadia.");
                    inputW.nextLine();
                    inputW.nextLine();

                    break;
                case "Radiants":

                    inputW.addText("You have managed to kill " + radiant1.getBOSS_NAME() + " You have found 4th missing Codex of Conduct. You have now all Codexes of Conduct and Creation of the World. You can feel that the balance now has been restored and the World of Arcadia can"
                            + " enjoy  God's splendor once again!");
                    inputW.nextLine();
                    inputW.nextLine();

                    break;
            }

            inputW.addText("What do You want to do ?: ");
            inputW.nextLine();
            inputW.addText("1. Play again.");
            inputW.nextLine();
            inputW.addText("2. Exit game ");
            inputW.scrollDown();

            player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
            inputV.checkPlayerChoice(2, player1.getPlayerChoice());

            while (inputV.isWrongChoice()) {
                player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose betwen 1 and 2: "));
                inputV.checkPlayerChoice(2, player1.getPlayerChoice());
            }

            switch (player1.getPlayerChoice().substring(0, 1)) {
                case "1":
                    //Start new game
                    setFirstCodex(false);
                    setSecondCodex(false);
                    setThirdCodex(false);
                    fightmod.setFightWithBoss(false);
                    fightmod.setFightWithEnemyEast(false);
                    fightmod.setFightWithEnemySouth(false);
                    fightmod.setFightWithEnemyWest(false);
                    fightmod.setFightWithGuard(false);
                    fightmod.setFightSetup(false);
                    stark1.setGoToStark(false);
                    invoker1.resetStats();
                    chaos1.resetStats();
                    shadow1.resetStats();
                    sven1.resetStats();
                    omni1.resetStats();
                    chaos1.resetStats();
                    inputW.clearWindow();
                    setNewGame(true);
                    setWin(false);
                    setLoose(false);
                    break;

                case "2":
                    System.exit(0);
                    break;
            }
                
        
        }
    
    }
       
       public void loose(Player player1, InputWindow inputW, InputValidator inputV,Warlock warlock1, ChaosKnight chaos1, Invoker invoker1, 
               Omniknight omni1, ShadowFiend shadow1, Sven sven1, Stark stark1, FightMode fightmod,  RadiantBoss radiant1 , DireBoss dire1)
       {
           
         
        if (isLoose()) {

            //Loose condition is overhere
            switch (player1.getRace()) {

                case "Dires":
         
 
                    inputW.addText("Your all heros have died. The world Arcadia has restored the balance as it was before and there is no more evil.");

                    break;
                case "Radiants":

                    inputW.addText("Your all heros have died. The world of Arcadia has turned into chaos and Codex of Creation is now in hands of evil.");
         
                    break;

            }
            inputW.nextLine();
            inputW.nextLine();
            inputW.addText("What do You want to do ?: ");
            inputW.nextLine();
            inputW.addText("1. Play again.");
            inputW.nextLine();
            inputW.addText("2. Exit game ");
            inputW.scrollDown();

            player1.setPlayerChoice(inputW.waitForPlayerInput("Enter your decision below: "));
            inputV.checkPlayerChoice(2, player1.getPlayerChoice());

            while (inputV.isWrongChoice()) {
                player1.setPlayerChoice(inputW.waitForPlayerInput("You have to choose betwen 1 and 2: "));
                inputV.checkPlayerChoice(2, player1.getPlayerChoice());
            }

            switch (player1.getPlayerChoice().substring(0, 1)) {
                case "1":

                    //Start new game
                    setFirstCodex(false);
                    setSecondCodex(false);
                    setThirdCodex(false);
                    fightmod.setFightWithBoss(false);
                    fightmod.setFightWithEnemyEast(false);
                    fightmod.setFightWithEnemySouth(false);
                    fightmod.setFightWithEnemyWest(false);
                    fightmod.setFightWithGuard(false);
                    fightmod.setFightSetup(false);
                    stark1.setGoToStark(false);
                    invoker1.resetStats();
                    chaos1.resetStats();
                    shadow1.resetStats();
                    sven1.resetStats();
                    omni1.resetStats();
                    chaos1.resetStats();
                    inputW.clearWindow();
                    setNewGame(true);
                    setWin(false);
                    setLoose(false);
                                
                    break;

                case "2":
                    System.exit(0);
                    break;
            }


        }

    }
   
    public boolean isNewGame() {
        return newGame;
    }

    public void setNewGame(boolean newGame) {
        this.newGame = newGame;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public boolean isLoose() {
        return loose;
    }

    public void setLoose(boolean loose) {
        this.loose = loose;
    }

    public boolean isFirstCodex() {
        return firstCodex;
    }

    public void setFirstCodex(boolean firstCodex) {
        this.firstCodex = firstCodex;
    }

    public boolean isSecondCodex() {
        return secondCodex;
    }

    public void setSecondCodex(boolean secondCodex) {
        this.secondCodex = secondCodex;
    }

    public boolean isThirdCodex() {
        return thirdCodex;
    }

    public void setThirdCodex(boolean thirdCodex) {
        this.thirdCodex = thirdCodex;
    }
    
    

    
}

    
  