// DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom; 

public class DeckOfCards 
{//start of DeckOfCards class
   
   // random number generator 
   private static final SecureRandom randomNumbers = new SecureRandom(); 
   private static final int NUMBER_OF_CARDS = 52; 
   private Card[] deck = new Card[NUMBER_OF_CARDS]; //Card references
   private int currentCard = 0; //index of next Card to be dealt (0 - 51) 
   //class attributes 
    
    // constructor fills deck of Cards
    public DeckOfCards() 
    {//start of DeckOfCards constructor method
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "eight", "nine", "ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};  
        //makes a two arrays with faces and suits that will be the cards 
        //populate deck with Card objects
        for (int count = 0; count < deck.length; count++) 
        {//start of for loop
            deck[count] = 
                new Card(faces[count % 13], suits[count / 13]); //instante card object 52 times 
                //will run and make a new card 52 times 
        } //end of for loop 
    } //end of DeckOfCards Constructor method  
    
    //shuffle deck of Cards with one-pass algorithm
    public void shuffle() 
    {//start of shuffle method
        //next call to method dealCard should start at deck[0] again
        currentCard = 0; 
        
        //for each Card, pick another random Car (0-51) and swap them 
        for ( int first = 0; first < deck.length; first++) 
        {//start of for loop
            //select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS); 
            
            //swap current Card with randomlyselected Card
            Card temp = deck[first]; 
            deck[first] = deck[second];
            deck[second] = temp;  
        }//end for loop 
    }//end of shuffle method 
    
    // deal one card 
    public Card dealCard() 
    {//start of dealCard method
        //determine whether Cards remain to be dealt
        if (currentCard < deck.length) 
        {//start of if else statement
            return deck[currentCard++]; //return current Card in array
        }//end of if statement
        else 
        {//start of else statement
            return null; //return null to indicate that all Cards were dealt
        }//end if/else statement
    }//end of dealCard method 
}//end of DeckOfCards class 