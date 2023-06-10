// Programmer: Jake Moren
// Class: CS 145 OL
// Date: 04/13/2023
// Lab: Lab 4 Cards 
// Reference Material: CS145 Week 3 lecture videos 
import java.util.*; 
//program imports the scanner from the library
public class CardMain
{//start of CardMain class
   public static void main(String[]args)
   {//start of main method 
      
      CardGame21 newGame1 = new CardGame21(); 
      newGame1.playGame();
      //instantiating an object => Classname objectName = new Classname(); 
      //accessing object methods => objectName.methodName 
      
      
   }//end of main method 
}//end of CardMain class   

  //same deck for all players 
      //instructions will be provided
      //will ask how many people are playing 
      //then each player will recive two cards that everyone can see
      //the dealer will also get two cards but only the second card will be seen 
      //the player to the left of the dealer will go first
      //the player will be asked to hit or hold/stay
      //if they select hit they will be given another card (again will be seen)
      //if they get an ace, they can change the value of the ace (1 or 11)
      //if they select stay then they will not receive any more cards
      //if they select stay it is the next persons turn
      //if you are dealt 21 points you will win with a blackjack
      //if you get over 21 points you loose (called bust)
      // to win you need to have more points than the dealer and less than 21
      //when everyone is done with there turn it goes back to the dealer where his car is shown
      //if the dealer has less 16 points he needs to hit \
      //if the dealer has 17 points he will  stay 
      //then compare winning condition => player and dealer : more than dealer but less than 21 
      //tie: player and dealer, points need to be the same but less than 21 
      //lose: automatically when you get more than 21 
      //win: automatically when you get 21 in the beginning.
       
      
      //Stack is going to be used for cardDeck 
      //Queue is going to be used to determine which player goes net 
      //Class called cardDeck => methods like shuffle deck, retrieve card from deck 
      //Class called cardObject => attributes like Suit, rank, attachedValue 
      //Class called PlayerObject => player hand, initial 2 cards dealt, 
      
      
      //all players choose hold 
      //show all cards in dealer hand 
      //calculate the total value of the dealer hand, 
      //dealerforGame.getTotalValue() 
      //if > 17 dealer holds 
      //else dealer hits 
      //check for 21 or BUST 
