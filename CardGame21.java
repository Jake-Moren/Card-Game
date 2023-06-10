// Programmer: Jake Moren
// Class: CS 145 OL
// Date: 04/13/2023
// Lab: Lab 4 Cards 
// Reference Material: CS145 Week 3 lecture videos 

import java.util.*; 
//program imports the scanner from the library
public class CardGame21
{//start of CardGame21
   private DeckOfCards deckOnTable; 
   private final Scanner input = new Scanner(System.in); 
   private int numberOfPlayers = 1; 
   private Queue<PlayerObject> playersList = new LinkedList<PlayerObject>(); 
   private final int MAX_NUMBER = 21; 
   private Dealer dealerForGame; 
   //class attributes I used a queue for the player list/order 
   
   
   public CardGame21()
   {//constructor method and start of CardGame21 method
      instructions(); 
      initializeDeck(); 
      initializeGame(); 
   }//end of CardGame21 method 
   
   private void initializeDeck()
   {//start of initializeDeck
      this.deckOnTable = new DeckOfCards(); 
      this.deckOnTable.shuffle(); //use this to select specifics
   }//end of initializeDeck  
   
   private void initializeGame()
   {//start of initializeGame 
      askNumberOfPlayers(); 
      populatePlayersList(); 
   }//end of initializeGame 
   
   private void askNumberOfPlayers()
   {//start of askNumberOfPlayers
      System.out.println("How many players are playing?");
      this.numberOfPlayers = Integer.parseInt(this.input.next());
   }//end of askNumberOfPlayers 
   
   private void populatePlayersList()
   {//start of populatePlayersList
      for(int i = 1; i<= this.numberOfPlayers; i++)
      //will add selected number of players
      {//start of for loop 
         playersList.add(new PlayerObject(i, this.deckOnTable));
      }//name.method and end of for loop 
      
      this.dealerForGame = new Dealer(this.deckOnTable);
   }//end of populatePlayersList 
    
   public void playGame()
   {//start of playGame method   
      this.dealerForGame.showDealerHand(true);  
      for(PlayerObject player: playersList)
      {//start of for loop
         System.out.println(); 
         player.showPlayerHand(); 
         System.out.println(player.toString() + ", Hit Or Hold?");
         String userInput = this.input.next(); 
         while(userInput.toLowerCase().equals("hit"))
         {//start of while loop
            player.playerTakeCard(); 
            player.showPlayerHand(); 
            if(player.getTotalValue() > MAX_NUMBER)
            {//start of if else statement
               System.out.println("BUST!"); 
               userInput = "hold"; 
            }//end of if statement
            else
            {//start of else statement                
               System.out.println(player.toString() + ", Hit Or Hold?");
               userInput = this.input.next();
            }//end of else statement 
         }//end of while loop
         System.out.println("You've chosen to hold"); 
      }//end of for loop
      this.dealerForGame.showDealerHand(false); 
      if(this.dealerForGame.getTotalValue() < 17){
         System.out.println("Dealer hit");
         this.dealerForGame.getCard(); 
         this.dealerForGame.showDealerHand(false);
      } 
      compareHands();  
   }//end of playGame method 
   
   public void compareHands()
   {//start of compareHands method
      for(PlayerObject player: this.playersList)
      {//start of for loop
         Dealer dealerObject = this.dealerForGame; 
         if(player.getTotalValue() > dealerObject.getTotalValue() &&
          player.getTotalValue() <= 21)
         {//start of if statement
            System.out.println(player.toString() + " Congratulations you beat the dealer.");
         }//end of if statement
         else if(player.getTotalValue() == dealerObject.getTotalValue())
         {//start of else if statement
            System.out.println("Push no one wins!");
         }//end of else if statement
         else
         {//start of else statement
            System.out.println(player.toString() + " The dealer won!");
         }//end of else statement
      }//end of for loop
   }//end of compareHands method

   private void instructions()
   {//start of instructions method 
   System.out.printf("             Welcome to the game of 21!%n");
   System.out.println("21 gets its name from the number of points you want to get ");
   System.out.println("The game starts off with each player being delt two cards");
   System.out.println("Its important to note that all cards will be displayed outright");
   System.out.println("The cards can be shown because the players are not playing ");
   System.out.println("against each other, but againts the dealer");
   System.out.println("The only exception to this rule is the dealer, their first card will");
   System.out.println("remain hidden until the end of the game. ");
   System.out.println("After all the players have recieved their inital deal");
   System.out.println("they will begin playing their turns");
   System.out.println("Each player will have the option to hit or to hold");
   System.out.println("If you ask to hit then you are aksing for another card");
   System.out.println("Or instead if you ask to hold you will not recieve another card");
   System.out.println("After you hold it is off to the next person");
   System.out.println("If at any point your hand exceeds the value of 21 ");
   System.out.println("you bust or in other words loose. ");
   System.out.println("The goal of the game is to be closer to 21 than the dealer ");
   System.out.println("Extra Notes:");
   System.out.println("In this game you will be given the option to choose the value of an ace");
   System.out.println("you can choose a 1 or an 11 the other cards represent their number value");
   System.out.printf("Kings,Queens, Jacks also known as face cards are worth 10 points %n%n");
   }//end of instructions method  
}//end of CardGame21 class 




