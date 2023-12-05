package aton;
// Card class represents a playing card.

public class Card {
   private final String face; // face of card ("Ace", "Deuce", ...)
   private final String suit; // suit of card ("Hearts", "Diamonds", ...)

   // two-argument constructor initializes card's face and suit
   public Card(String cardFace, String cardSuit) {
      this.face = cardFace; // initialize face of card
      this.suit = cardSuit; // initialize suit of card
   } 

   // return String representation of Card
   public String toString() {             
      return face + " of " + suit;        
   }                
   public String getFace(){ //returns the face of the card
      return face;
   }
   public String getSuit(){ //returns the suit of the card
      return suit;
   }
} 

/*a pair -> 2 of the same suits
 * 2 pairs -> 2 pairs of the same suits
 * 3 of akind -> a set of 3 suits
 * 4 of a kind -> a 4 set of suits
 * flush -> if 5 of the same suits
 * straight -> 5 sequential faces counting up
 * full house -> 3 of 1 face + 2 of another face (3 of the same num, 2 of the same num)
 */



