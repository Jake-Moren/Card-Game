// Programmer: Jake Moren
// Class: CS 145 OL
// Date: 04/13/2023
// Lab: Lab 4 Cards 
// Reference Material: CS145 Week 3 lecture videos 
import java.util.*; 
//program imports the scanner from the library
import java.util.Scanner; 
public class PlayerObject
{//start of PlayerObject class
   private final int INITIAL_DEAL = 2; 
   private Stack<Card> playerHand = new Stack<Card>(); 
   private int playerNumber; 
   private DeckOfCards deckObject; 
   private int handTotalValue = 0; //3 
   private String handToString = ""; //", Ace Of hearts, Deuce of Diamonds"
   private Scanner input = new Scanner(System.in); 
   //class attributes above this line 
   
   public PlayerObject(int playerNumber, DeckOfCards deckObject)
   {//start of PlayerObject constructor method
      this.playerNumber = playerNumber; 
      this.deckObject = deckObject; 
      initializePlayerHand(); 
   }//end of PlayerObject method 
   
   //if I get a card that has a faceValue() of "ace", I will prompt the user 
   
   private void initializePlayerHand()//start of initialziePlayerHand method
   {//use the DEckOfCards dealCard() method to deal initial 2 cards 
      for(int i = 0; i < INITIAL_DEAL; i++)
      {//start of for loop
         playerTakeCard(); 
      }//end of for loop
      showPlayerHand(); 
   }//end of initializePlayerHand 
   
   private void takeCardIntoAccount(Card indivCard)
   {//start of takeCardIntoAccount
      this.handTotalValue += indivCard.getCardValue(); 
      this.handToString += ", " + indivCard.toString(); 
   }//end of takeCardIntoAccount
   
   public void playerTakeCard()
   {//start of playerTakeCard method 
      Card newCard = deckObject.dealCard(); 
      if(newCard.faceValue().toLowerCase().equals("ace"))
      {//start of if statement 
         System.out.println(toString() + ", What value do you want the ace to be? (1 or 11)");
         int userInput = Integer.parseInt(this.input.next()); 
         newCard.changeCardValue(userInput);
         //tackles the issue of what to set the value of ace
      }//end of if statement
      playerHand.push(newCard);//add a card into the stack
      takeCardIntoAccount(newCard);//getting the new value of the hand
   }//end of playerTakeCard method
   
   public void showPlayerHand()
   {//start of showPlayerHand method
      System.out.println(toString() + 
      ", these are your cards:" + 
      this.handToString.substring(1) +
       ": " + this.handTotalValue); 
   }//end of showPlayerHand method  
   
   public String toString()
   {//start of toString method 
      return "Player " + this.playerNumber; 
   }//end of toString method 
   
   public int getTotalValue()
   {//start of getTotalValue method 
      return this.handTotalValue; 
   }//end of getTotalValue 
}//end of PlayerObject class
   