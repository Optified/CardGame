package aton;
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;

public class DeckOfCards {
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

   private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
   private int currentCard = 0; // index of next Card to be dealt (0-51)
   //String[][]setCounter = new String[5][]
   int[] faceCounter = new int[13]; //counter to find any card combinations for faces
   int[] suitCounter = new int[4]; //counter to find any suit combinatinos for suits
   //both the counters correspond to the order of the string arrays for faces and suits below
   int countPair = 0;
   int countThree = 0;

   // constructor fills deck of Cards
   public DeckOfCards() {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};      

      // populate deck with Card objects                  
      for (int count = 0; count < deck.length; count++) { 
         Card hello = new Card(faces[count % 13], suits[count / 13]);
         deck[count] = hello;
      } 
      /*
      System.out.println(countPair);
      System.out.println(countThree);
      System.out.println(suitCounter[1]);  */                                             
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current Card with randomly selected Card
         Card temp = deck[first];   
         deck[first] = deck[second];
         deck[second] = temp;       
      } 
      //counts the types of faces and suits in the hand
      for(int i = 0; i < 5; i++){
         if(deck[i].getFace().contains("Ace")){
            faceCounter[0]++;
         }
         else if(deck[i].getFace().contains("Deuce")){
            faceCounter[1]++;
         }
         else if(deck[i].getFace().contains("Three")){
            faceCounter[2]++;
         }
         else if(deck[i].getFace().contains("Four")){
            faceCounter[3]++;
         }
         else if(deck[i].getFace().contains("Five")){
            faceCounter[4]++;
         }
         else if(deck[i].getFace().contains("Six")){
            faceCounter[5]++;
         }
         else if(deck[i].getFace().contains("Seven")){
            faceCounter[6]++;
         }
         else if(deck[i].getFace().contains("Eight")){
            faceCounter[7]++;
         }
         else if(deck[i].getFace().contains("Nine")){
            faceCounter[8]++;
         }
         else if(deck[i].getFace().contains("Ten")){
            faceCounter[9]++;
         }
         else if(deck[i].getFace().contains("Jack")){
            faceCounter[10]++;
         }
         else if(deck[i].getFace().contains("Queen")){
            faceCounter[11]++;
         }
         else if(deck[i].getFace().contains("King")){
            faceCounter[12]++;
         }
         if(deck[i].getSuit().contains("Hearts")){
            suitCounter[0]++;
         }
         else if(deck[i].getSuit().contains("Diamonds")){
            suitCounter[1]++;
         }
         else if(deck[i].getSuit().contains("Clubs")){
            suitCounter[2]++;
         }
        else if(deck[i].getSuit().contains("Spades")){
            suitCounter[3]++;
         }
      }//end of for loop

      //displays what type of hand the player has
      for(int i = 0; i < suitCounter.length; i++){
         if(suitCounter[i] == 5){
            System.out.println("You have a flush!");
         }
         else if(suitCounter[i] == 4){
            System.out.println("You have 4 of a kind!");
         }
         else if(suitCounter[i] == 3){
            countThree++;
         }
         else if(suitCounter[i] == 2){
            countPair++;
         }
      }  
         if(countPair == 1){
            System.out.println("You have a pair!");
         }
         else if(countPair >= 2){
            System.out.println("You have 2 pairs!");
         }
         if(countPair > 1 && countThree > 1){
            System.out.println("You have a full house!");
         }
         else if(countThree >= 1){
            System.out.println("You have 3 of a kind!");
         }
   } 

   // deal one Card
   public Card dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length) {
         return deck[currentCard++]; // return current Card in array
      } 
      else {
         return null; // return null to indicate that all Cards were dealt
      } 
   } 
} 



