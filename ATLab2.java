package aton;
import java.util.Scanner;
//Plays the card game 21.

public class ATLab2 {
   // execute application
   public static void main(String[] args) {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order

      printIntro(); //prints the rules of 21
      boolean gameFlag = true; 

      System.out.println("Do you want to play the game?");
      Scanner scanner = new Scanner(System.in);
      String answer = scanner.next().toLowerCase();
      System.out.println();

      if(answer.equals("y") || answer.equals("ye") || answer.equals("yes")){ //if player says yes, the game begins
         playGame(myDeckOfCards);
      }
      else if(answer.equals("n") || answer.equals("no")){ //if player says no, program stops
         gameFlag = false;
      }
      else{
         System.out.println("Your input was either any iternation of no, or it was an invalid input. The game will now close."); //program stops if the first input isnt a recognized command
         gameFlag = false;
      }

      while(gameFlag == true){ //Once the game runs once, if you player wants to continue, the loop will allow the player to play until they no longer want to play
         System.out.println("Do you want to play again?");
         answer = scanner.next().toLowerCase();
         if(answer.equals("y") || answer.equals("ye") || answer.equals("yes")){
            playGame(myDeckOfCards);
         }
         else if(answer.equals("n") || answer.equals("no")){
         gameFlag = false;
         }
         else{
            System.out.println("Your input was either any iternation of no, or it was an invalid input. Please enter a valid input."); 
         }
      }

      System.out.println();
   } 
   public static void printIntro(){
      System.out.println("");
      System.out.println("This is the Card Game: 21.\nThe goal of the game is to have your cards add up to\nmore than the dealer, but less than 21.\nIf your cards added up are higher than the dealer, than you win.\n\nAny card with a number is tallied up. Any face value card is worth 10.\nHowever, an ace you can choose to be a 1 or a 11.\nThe dealer shows 1 card, and their 2nd is hidden\nYou start with 2 cards, and you can choose to grab more cards");
      System.out.println("from the deck until you're statisfied with your value.\nOnce you're statisfied, the dealer will reveal their card\nand you will compare who has the higher value. Highest one that is below 21 wins.\nHowever, if the dealer's 2 cards is below 16 in value,\nThen they're forced to draw another card.");
      System.out.println();
   }
   public static void playGame(DeckOfCards myDeckOfCards){ //plays the game between you and the dealer. 
      String dealerName = "The dealer";
      String playerName = "You";

      Scanner scanner = new Scanner(System.in); //scanner records user's input for if they want to continue playing the game
      String answer;

      int playCount = 0; //counts the points of the player
      int dealerCount = 0; //counts the points of the dealer

      boolean playTurn = true; //player gets to continue playing until their total points surpass 20. 21 means they win, 21+ means they lose automatically
      dealerCount = dealerCount + playCard(myDeckOfCards, dealerName, dealerCount); //dealer draws a card first
      System.out.println("The dealer's current score is: " + dealerCount);
      System.out.println("One of his cards is hidden.");
      System.out.println();
      playCount = playCount + playCard(myDeckOfCards, playerName, playCount); //players draw a 2 cards at first
      playCount = playCount + playCard(myDeckOfCards, playerName, playCount);


      System.out.println("Your current score is: " + playCount);

      while(playTurn){ //now player gets to keep pulling cards until they're satisfied with their score, or they surpass 20.
         if(playCount < 21){
         System.out.println("Do you want to draw another card? (Y or N)");
         answer = scanner.nextLine().toLowerCase();
         if(answer.equals("y")){
            playCount = playCount + playCard(myDeckOfCards, playerName, playCount);
            System.out.println("Your current score is " + playCount);
         }
         else if(answer.equals("n") || answer.equals("no")){ //loop ends when the player no longer wants to draw cards by saying no
            playTurn = false;
         }
         else{ //loop restarts if the input isn't a yes or a no.
            System.out.println("Improper input. Please try again");
         }
      }
         else if(playCount == 21){ //player automatically wins if they score a 21
         System.out.println("You won!");
         playTurn = false;
      }
         else{ //player automatically loses if they score above 21
            System.out.println("Unfortunately, you've lost. The dealer won.");
            playTurn = false;
         }
      }
      if(playCount < 21){ //now is the dealer's turn. 
         dealerCount = dealerCount + playCard(myDeckOfCards, dealerName, dealerCount); //dealer reveals their 2nd card
         if(dealerCount <= 16){ //if the 2 cards added up is less than 16, then they will automatically draw another card
            System.out.println("Because the dealer's 2 cards is less than 16, he will draw another card");
            dealerCount = dealerCount + playCard(myDeckOfCards, dealerName, dealerCount); //dealer draws another card
         }
         if(dealerCount > 21){ //the dealer loses if they add up to above 21
            System.out.println("The dealer has lost. You win!");
         }
         else if(playCount > dealerCount && playCount <= 21){ //player wins if both the scores are below 22, and the player is greater than the dealer
            System.out.println("You scored " + (playCount - dealerCount) + " points higher than the dealer! You won!");
         }
         else{ //player loses if the dealer scores higher than the player
            System.out.println("The dealer scored " + (dealerCount - playCount) + " points higher than you. You lost.");
         }
      }
      
   }
   public static int playCard(DeckOfCards myDeckOfCards, String name, int count){ //a card is played and returns a score value for the card. 
      Scanner scanner = new Scanner(System.in); //scanner records the user's input for what score they want if they have an Ace
      String answer;
      int playCount = 0;
      Card cardOne = myDeckOfCards.dealCard();
      cardOne = myDeckOfCards.dealCard();
         System.out.println(name + " drew a " + cardOne + ".");
         if(cardOne.getFace().contains("One")){
            playCount++;
         }
         else if(cardOne.getFace().contains("Two")){
            playCount = playCount + 2;
         }
         else if(cardOne.getFace().contains("Three")){
            playCount = playCount + 3;
         }
         else if(cardOne.getFace().contains("Four")){
            playCount = playCount + 4;
         }
         else if(cardOne.getFace().contains("Five")){
            playCount = playCount + 5;
         }
         else if(cardOne.getFace().contains("Six")){
            playCount = playCount + 6;
         }
         else if(cardOne.getFace().contains("Seven")){
            playCount = playCount + 7;
         }
         else if(cardOne.getFace().contains("Eight")){
            playCount = playCount + 8;
         }
         else if(cardOne.getFace().contains("Nine")){
            playCount = playCount + 9;
         }
         else{
            playCount = playCount + 10; //shorthand for every other face (queen/king/jack).
         }
         if(cardOne.getFace().contains("Ace") && name.contains("You")){ //if statement only applies to the user
            System.out.println("You just got an Ace. Do you want to gain a 1 or a 10? (Answer with a 1 or a 10)");
            answer = scanner.next();
            if(answer.toLowerCase().equals("1")){
               playCount = playCount - 9; //subtracts by 9 because the above else statement counts aces as a 10, when the player wanted a 1.
               System.out.println();
            }
         }
         else if(cardOne.getFace().contains("Ace") && name.contains("The dealer")){ //if statement only applies to the dealer
            System.out.println("The dealer just got an Ace. He can choose to either go with a 1 or a 10.");
            if((count + 10) > 21){ //since the dealer isn't a real player, they will draw a 10 everytime if the resulting score doesnt bring them over 21. if so, then 1 otherwise.
               playCount = playCount - 9;
               System.out.println("The dealer decided to choose a 1 for their Ace.");
            }
            else{
               System.out.println("The dealer decided to choose a 10 for their Ace.");
            }
         }
         return playCount; //returns the score of the card.
   }
} 

