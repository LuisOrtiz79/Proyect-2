/* Luis E. Ortiz Cotto
   #801-16-5704
   CCOM4029 Sec.002
   Prof. Patricia Ordonez
*/

import java.util.*;

public class Pile implements PileInterface {

	private MyStack pile;

 /**
   * Creates an empty deck of cards.
   */
   public Pile() {
	   pile = new MyStack(52);
   }

  /**
   *  returns next Card in a deck that is facing down without removing it
   */
   @Override
   public Card peek() {
		 return pile.top();
   }
 /**
   * this method is used to add Cards to a Deck.  The Deck is completely empty when it is initialized.
   */
   @Override
   public void addCard(Card card) {
	   pile.push(card);
   }

 /**
   * returns number of cards on the deck
   * @return int
   */
   @Override
   public int getSizeOfDeck() {
	   return pile.getSize();
   }

   /**
   * removes first card on a deck so equivalent to flipping the card off of a deck that is faced down
   * @return <code>null</code> if there are no cards left on the Stack. Otherwise returns Card
   */
   @Override
   public Card dealCard(){
	   return pile.pop();
   }

 /**
   * removes Card last card placed on a deck so equivalent to removing card from deck that is faced up
   * @return <code>null</code> if there are no cards left on the deck. Otherwise removes Card
   */
   @Override
   public Card removeCard(){
		 return pile.pop();
   }

  /**
   * Shuffles the cards present in the deck.
   */
   @Override
   public void shuffle() {
		 //Collections.shuffle( pile );
   }

  /**
   * Looks for an empty deck.
   * @return <code>true</code> if there are no cards left to be dealt from the deck.
   */
   @Override
   public boolean isEmpty() {
		 return pile.isEmpty();
   }

  /**
   * Restores the deck to being empty and ready to add Cards to
   */
   @Override
   public void restoreDeck() {
	  Card done = pile.pop();
	  while(done != null) {done = pile.pop();}
   }


}
