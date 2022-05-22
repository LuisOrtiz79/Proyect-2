/* Luis E. Ortiz Cotto
   #801-16-5704
   CCOM4029 Sec.002
   Prof. Patricia Ordonez
*/

import java.util.*;

public class Deck implements DeckInterface { //the implements was added new

   //java.util.LinkedList deck;
   //private int index;
   private MyStack deck; //New
   private int top;


  /**
   * Creates an empty deck of cards.
   */
   public Deck() {
      //deck = new LinkedList();
      deck = new MyStack(52); //New
      top = -1;

   }
	public Card peek()
	{
		/*if(deck.size() == 0)
			return null;
		else
			return (Card)deck.getLast();*/
    return deck.top();
	}

   public void addCard( Card card ) {
      //deck.add( card );
      deck.push(card); //New
      top++;
   }


   public int getSizeOfDeck() {
      //return deck.size();
      return deck.getSize(); //New
   }

   public Card dealCard() {

	 /*if ( deck.size() == 0 )
         return null;
      else

		return (Card) deck.removeFirst();*/
    return deck.pop(); //New
   }

   public Card removeCard() {
     /*if (deck.size() == 0)
        return null;
     else{
       return (Card) deck.removeLast( );
     }*/
     return deck.pop(); //New
   }


  /**
   * Shuffles the cards present in the deck.
   */
   public void shuffle() {
      //Collections.shuffle( deck );
      //deck.shuffleArray();
   }


  /**
   * Looks for an empty deck.
   * @return <code>true</code> if there are no cards left to be dealt from the deck.
   */
   public boolean isEmpty() {
		//return deck.size() == 0;
    return deck.isEmpty(); //New
   }



  /**
   * Restores the deck to "full deck" status.
   */
  public void restoreDeck() {
	//not sure if kosher
      //deck.removeAll(deck);
      Card last = deck.pop();
      while(last != null) {
        last = deck.pop();
      }
   }


}
