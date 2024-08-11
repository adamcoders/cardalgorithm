import java.util.Scanner;
import java.util.*;
public class Main {
  public static void main(String[] args) {
    System.out.println("You are about to witness a fascinating algorithm.");
    System.out.print("How many cards would you like in the deck?  ");
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int [] deck = new int [n];
    for(int i = 0; i < n; i++){
      deck[i] = 1;
    }
    System.out.println("---------------------------------");
    System.out.println("A sequence of random cards are initially face down (represented by 1).");
    System.out.println("\nA move consists of turning a face down card face up (represented by 0) and turning over the card to the right.");
    System.out.println("\nThe objective of this algorithm is to prove that regardless of the amount of cards and choice of the cards to turn, the algorithm sequence must terminate.\n");
    algorithm(deck);
  }

  public static void printDeck(int[] deck){
    for (int i = 0; i < deck.length; i++){
      System.out.print(deck[i] + " ");
    }
  }

  public static void turn(int[] deck, int card){
    if(deck[card] == 1){
      deck[card] = 0;
    }
    else if(deck[card] == 0){
      deck[card] = 1;
    }
  }

  public static void move(int[] deck, int card){
    if(deck[card] == 1){
      turn(deck, card);
      turn(deck, card + 1);
    }
  }

  public static void printDecimalfromDeck(int[] deck){
    long number = 0;
    int exp = deck.length - 1;
    int at = 0;
    while(exp >= 0 && at < deck.length){
      if(deck[at] == 1){
        number += Math.pow(2, exp);
      }
      exp--;
      at++;
    }
    System.out.print(number);
  }

  public static boolean checkifMustTerminate(int[] deck){
    for(int i = 0; i < deck.length - 1; i++){
      if(deck[i] == 1){
        return false;
      }
    }
    return true;
  }

  public static void algorithm(int[] deck){
    System.out.print("Deck now:  ");
    printDeck(deck);
    System.out.print("in decimal: ");
    printDecimalfromDeck(deck);
    System.out.println();
    while(checkifMustTerminate(deck) == false){
      move(deck, (int)(Math.random() * (deck.length - 1)));
      System.out.print("Deck now:  ");
      printDeck(deck);
      System.out.print("in decimal: ");
      printDecimalfromDeck(deck);
      System.out.println();
    }
    System.out.println("Sequence terminated.");
  }
}
