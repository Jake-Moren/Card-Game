// Programmer: Jake Moren
// Class: CS 145 OL
// Date: 04/13/2023
// Lab: Lab 4 Cards 
// Reference Material: CS145 Week 3 lecture videos 
import java.util.*; 
//program imports the scanner from the library
import java.util.Scanner; 
public class Dealer
{//start of the Dealer class
   private final int INITIAL_DEAL = 2;//class attributes 
   private Stack<Card> dealerHand = new Stack<Card>(); 
   private DeckOfCards deckObject; 
   private int handTotalValue = 0; //3 
   private Scanner input = new Scanner(System.in);
   //class attributes 
    
   public Dealer(DeckOfCards deckObject)
   {//start of Dealer constructor method 
      this.deckObject = deckObject; 
      initializeDealerHand(); 
      //immediately show dealers hand      
   }//end of Dealer method 
   
    private void initializeDealerHand()
    {//use the DEckOfCards dealCard() method to deal initial 2 cards 
      for(int i = 0; i < INITIAL_DEAL; i++)
      {//start of for loop
         getCard(); 
      }//end of for loop
   }//end of initializeDealerHand method 
   
   public void getCard()
   {//start of getCard method
      Card indivCard = deckObject.dealCard();//dealing one card twice 
      dealerHand.push(indivCard);//adds card to stack with a push 
      takeCardIntoAccount(indivCard);//getting the cards values 
   }//end of getCard method 
   
   private void takeCardIntoAccount(Card indivCard)
   {//start of takeCardIntoAccount method
      this.handTotalValue += indivCard.getCardValue(); //value 
   }//end of takeCardIntoAccount method 
   
   public void showDealerHand(boolean hidden) 
   {//start of showDealerHand
      Stack<Card> handCopy = (Stack<Card>)this.dealerHand.clone(); 
      String handToString = ""; 
      if(hidden)
      {//start of if else statement
         handToString += handCopy.pop().toString(); 
         System.out.println("Dealer's Cards: (hidden card),  " + handToString);
      }//end of if statement 
      else
      {//start of else statement
         for(Card indivCard: handCopy)
         {//start of for loop
           handToString += "," + indivCard.toString(); 
         }//end of for loop
         System.out.println("Dealer's Cards: " + handToString);
      }//end of else statement  
   }//end of showDealerHand method
   
   public int getTotalValue()
   {//start of getTotalValue method 
      return this.handTotalValue; 
   }//end of getTotalValue method  
}//end of Dealer class
    
    
      
     

   //initialize dealer hand with 2 cards 
   //first card is hidden, to the players 
   //second card is shown, they can see it all the time 
   //dealer gets to play last 
   //dealer plays once or zero times: 
   // if dealer has less than 16/17 points -> he will 100% hit, 
   //if dealer has more, he will hold 
   //dealer will win if he is closer to 21 than ANY of the players 
   // dealer loses if he is over than 21 points, or if ANY of the players are closer to 21 
   
   //have a method that initializes the dealers hand 
   //have a class attribute that contains the cards; array dealerHand 
   //get total points of dealer, 
   //a method for the dealer to take a card, 
 
  //Goals 
  //compare to dealer
  //go over and take notes of show dealer hand method
  //crash protection for 1 or 11 and ask number of players, and player take card
  