/* Luis E. Ortiz Cotto
   #801-16-5704
   CCOM4029 Sec.002
   Prof. Patricia Ordonez
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/**
*	This GUI assumes that you are using a 52 card deck and that you have 13 sets in the deck.
*	The GUI is simulating a playing table
	@author Patti Ordonez
*/
public class Table extends JFrame implements ActionListener
{
	final static int numDealtCards = 9;
	JPanel player1;
	JPanel player2;
	JPanel deckPiles;
	JLabel deck;
	JLabel stack;
	JList p1HandPile;
	JList p2HandPile;
	Deck cardDeck;
	Deck stackDeck;

	SetPanel [] setPanels = new SetPanel[13];
	JLabel topOfStack;
	JLabel deckPile;
	JButton p1Stack;
	JButton p2Stack;

	JButton p1Deck;
	JButton p2Deck;

	JButton p1Lay;
	JButton p2Lay;

	JButton p1LayOnStack;
	JButton p2LayOnStack;

	Hand p1Hand; //DefaultListModel p1Hand;
	Hand p2Hand; //DefaultListModel p2Hand;

  JButton firstCT; //Player 1 turn
	JButton secondCT; //Player 2 turn

	boolean first = true;
	boolean second = false;
	//boolean lastTurn = false;

	private void deal(Card [] cards)
	{
		for(int i = 0; i < cards.length; i ++)
			cards[i] = (Card)cardDeck.dealCard();
	}

	public Table()
	{
		super("The Card Game of the Century");

		setLayout(new BorderLayout());
		setSize(1200,700);


		cardDeck = new Deck();

		for(int i = 0; i < Card.suit.length; i++){
			for(int j = 0; j < Card.rank.length; j++){
				Card card = new Card(Card.suit[i],Card.rank[j]);
				cardDeck.addCard(card);
			}
		}
		cardDeck.shuffle();
		stackDeck = new Deck();

		JPanel top = new JPanel();

		for (int i = 0; i < Card.rank.length;i++)
			setPanels[i] = new SetPanel(Card.getRankIndex(Card.rank[i]));


		top.add(setPanels[0]);
		top.add(setPanels[1]);
		top.add(setPanels[2]);
		top.add(setPanels[3]);

		player1 = new JPanel();

		player1.add(top);




		add(player1, BorderLayout.NORTH);
		JPanel bottom = new JPanel();


		bottom.add(setPanels[4]);
		bottom.add(setPanels[5]);
		bottom.add(setPanels[6]);
		bottom.add(setPanels[7]);
		bottom.add(setPanels[8]);

		player2 = new JPanel();




		player2.add(bottom);
		add(player2, BorderLayout.SOUTH);


		JPanel middle = new JPanel(new GridLayout(1,3));

		p1Stack = new JButton("Stack");
		p1Stack.addActionListener(this);
		p1Deck = new JButton("Deck ");
		p1Deck.addActionListener(this);
		p1Lay = new JButton("Lay  ");
		p1Lay.addActionListener(this);
		p1LayOnStack = new JButton("LayOnStack");
		p1LayOnStack.addActionListener(this);
		firstCT = new JButton("P1_End");
		firstCT.addActionListener(this);


		Card [] cardsPlayer1 = new Card[numDealtCards];
		deal(cardsPlayer1);
		p1Hand = new Hand(); //Modified from DefaultListModel();
		for(int i = 0; i < cardsPlayer1.length; i++)
			p1Hand.addCard(cardsPlayer1[i]); //Modified from p1Hand.addElement(cardsPlayer1[i]);
		p1HandPile = new JList(p1Hand.getArray()); //p1Hand);
    System.out.println("Initial Player 1: " + p1Hand.toString()); //Shows the hand

		middle.add(new HandPanel("Player 1", p1HandPile, p1Stack, p1Deck, p1Lay, p1LayOnStack, firstCT));

		deckPiles = new JPanel();
		deckPiles.setLayout(new BoxLayout(deckPiles, BoxLayout.Y_AXIS));
		deckPiles.add(Box.createGlue());
		JPanel left = new JPanel();
		left.setAlignmentY(Component.CENTER_ALIGNMENT);


		stack = new JLabel("Stack");
		stack.setAlignmentY(Component.CENTER_ALIGNMENT);

		left.add(stack);
		topOfStack = new JLabel();
		topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
		topOfStack.setAlignmentY(Component.CENTER_ALIGNMENT);
		left.add(topOfStack);
		deckPiles.add(left);
		deckPiles.add(Box.createGlue());

		JPanel right = new JPanel();
		right.setAlignmentY(Component.CENTER_ALIGNMENT);

		deck = new JLabel("Deck");

		deck.setAlignmentY(Component.CENTER_ALIGNMENT);
		right.add(deck);
		deckPile = new JLabel();
		deckPile.setIcon(new ImageIcon(Card.directory + "b.gif"));
		deckPile.setAlignmentY(Component.CENTER_ALIGNMENT);
		right.add(deckPile);
		deckPiles.add(right);
		deckPiles.add(Box.createGlue());
		middle.add(deckPiles);


		p2Stack = new JButton("Stack");
		p2Stack.addActionListener(this);
		p2Deck = new JButton("Deck ");
		p2Deck.addActionListener(this);
		p2Lay = new JButton("Lay  ");
		p2Lay.addActionListener(this);
		p2LayOnStack = new JButton("LayOnStack");
		p2LayOnStack.addActionListener(this);
		secondCT = new JButton("P2_End");
		secondCT.addActionListener(this);


		Card [] cardsPlayer2 = new Card[numDealtCards];
		deal(cardsPlayer2);
		p2Hand = new Hand(); //Modified from DefaultListModel();

		for(int i = 0; i < cardsPlayer2.length; i++)
			p2Hand.addCard(cardsPlayer2[i]); //Modified from p2Hand.addElement(cardsPlayer2[i]);

		p2HandPile = new JList(p2Hand.getArray()); //p2Hand);
		System.out.println("Initial Player 2: " + p2Hand.toString()); //Shows the hand

		middle.add(new HandPanel("Player 2", p2HandPile, p2Stack, p2Deck, p2Lay, p2LayOnStack, secondCT));

		add(middle, BorderLayout.CENTER);

		JPanel leftBorder = new JPanel(new GridLayout(2,1));


		setPanels[9].setLayout(new BoxLayout(setPanels[9], BoxLayout.Y_AXIS));
		setPanels[10].setLayout(new BoxLayout(setPanels[10], BoxLayout.Y_AXIS));
		leftBorder.add(setPanels[9]);
		leftBorder.add(setPanels[10]);
		add(leftBorder, BorderLayout.WEST);

		JPanel rightBorder = new JPanel(new GridLayout(2,1));

		setPanels[11].setLayout(new BoxLayout(setPanels[11], BoxLayout.Y_AXIS));
		setPanels[12].setLayout(new BoxLayout(setPanels[12], BoxLayout.Y_AXIS));
		rightBorder.add(setPanels[11]);
		rightBorder.add(setPanels[12]);
		add(rightBorder, BorderLayout.EAST);

	}

	public void actionPerformed(ActionEvent e)
	{
		Object src = e.getSource();
		if(p1Deck == src|| p2Deck == src){

			Card card = cardDeck.dealCard();

			if (card != null){
				if(src == p1Deck && first == true){
				  System.out.println("Initial player 1:"); //Will show the action the player makes
				  p1Hand.addCard(card); //Modified from	p1Hand.addElement(card);
					p1HandPile.setListData(p1Hand.getArray()); //New
					System.out.println("Added:" + card.toString()); //Displays a string of the card added
				}
				if(src == p2Deck && second == true){ //Modified from else
				  System.out.println("Initial player 2:"); //Will show the action the player makes
					p2Hand.addCard(card); //Modified from p2Hand.addElement(card);
					p2HandPile.setListData(p2Hand.getArray()); //New
					System.out.println("Added:" + card.toString()); //Displays a string of the card added
				}
			}
			if(cardDeck.getSizeOfDeck() == 0)
				deckPile.setIcon(new ImageIcon(Card.directory + "blank.gif"));

		}
		if(p1Stack == src || p2Stack == src){

			Card card = stackDeck.removeCard();

			if(card != null){
				Card topCard = stackDeck.peek();
				if (topCard != null)
					topOfStack.setIcon(topCard.getCardImage());
				else
					topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));

				if(p1Stack == src && first == true){
					p1Hand.addCard(card); //Modified from p1Hand.addElement(card);
					p1HandPile.setListData(p1Hand.getArray()); //New
				}
				if(p2Stack == src && second == true){ //Modified from else
					p2Hand.addCard(card); //Modified from p2Hand.addElement(card);
					p2HandPile.setListData(p2Hand.getArray()); //New

				}
			}
		}

		if(p1Lay == src && first == true){
			Object [] cards = p1HandPile.getSelectedValues();
			if (cards != null)
				for(int i = 0; i < cards.length; i++)
				{
					Card card = (Card)cards[i];
					layCard(card);
					p1Hand.removeCard(card); //Modified from p1Hand.removeElement(card);
					p1HandPile.setListData(p1Hand.getArray()); //New
				}
		}


		if(p2Lay == src && second == true){
			Object [] cards = p2HandPile.getSelectedValues();
			if (cards != null)
				for(int i = 0; i < cards.length; i++)
				{
					Card card = (Card)cards[i];
					layCard(card);
					p2Hand.removeCard(card); //Modified from p2Hand.removeElement(card);
					p2HandPile.setListData(p2Hand.getArray()); //New
				}
		}


		if(p1LayOnStack == src && first == true){
			int [] num  = p1HandPile.getSelectedIndices();
			if (num.length == 1)
			{
				Object obj = p1HandPile.getSelectedValue();
				if (obj != null)
				{
					p1Hand.removeCard(obj); //Modified from p1Hand.removeElement(obj);
					p1HandPile.setListData(p1Hand.getArray()); //New
					Card card = (Card)obj;
					stackDeck.addCard(card);
					topOfStack.setIcon(card.getCardImage());
					System.out.println("Discarded:" + card.toString()); //Shows the discarded card
				}
			}
		}


		if(p2LayOnStack == src && second == true){
			int [] num  = p2HandPile.getSelectedIndices();
			if (num.length == 1)
			{
				Object obj = p2HandPile.getSelectedValue();
				if (obj != null)
				{
					p2Hand.removeCard(obj); //Modified from p2Hand.removeElement(obj);
					p2HandPile.setListData(p2Hand.getArray()); //New
					Card card = (Card)obj;
					stackDeck.addCard(card);
					topOfStack.setIcon(card.getCardImage());
					System.out.println("Discarded:" + card.toString()); //Shows the discarded card
				}
			}
		}

		if(firstCT == src && first == true){
				System.out.println("Hand now: " + p1Hand.toString());
				System.out.println("Cards left in deck: " + cardDeck.getSizeOfDeck());
				first = false;
				second = true;
				/*if(cardDeck.getSizeOfDeck() == 0){
					lastTurn = true;
				}*/
		}
		if(secondCT == src && second == true){
				System.out.println("Hand now: " + p2Hand.toString());
				System.out.println("Cards left in deck: " + cardDeck.getSizeOfDeck());
				first = true;
				second = false;
				/*if(cardDeck.getSizeOfDeck() == 0){
					lastTurn = true;
				}*/
		}

		if((p1Hand.getNumberOfCards() < 1) || (p2Hand.getNumberOfCards() < 1)){ //lastTurn == true){
		int p1Value = 0;
		for (int i = 0; i < p1Hand.getNumberOfCards(); i++) {
			Card c = p1Hand.getCard(i);
			int p1CardValue = Card.getRankIndex(c.getRank()) - Card.getRankIndex('a') + 1;
			if (p1CardValue > 10) {
				p1CardValue = 10;
			}
			p1Value += p1CardValue;
		}
		if(p1Hand.getNumberOfCards() == 0){
			System.out.println("Player 1 Wins");
		}

		int p2Value = 0;
		for (int i = 0; i < p2Hand.getNumberOfCards(); i++) {
			Card s = p2Hand.getCard(i);
			int p2CardValue = Card.getRankIndex(s.getRank()) - Card.getRankIndex('a') + 1;
			if (p2CardValue > 10) {
				p2CardValue = 10;
			}
			p2Value += p2CardValue;
		}
		if(p1Hand.getNumberOfCards() == 0){
			System.out.println("Player 1 Wins");
		}

		System.out.println("Points: " + p1Value + " to " + p2Value);
		if(p1Value < p2Value){
			System.out.println("Player 1 Wins");
		}
		else{
			System.out.println("Player 2 Wins");
		}

	}

}


/*	public static void main(String args[])
	{
		Table t = new Table();
		t.setVisible(true);
	}*/
	void layCard(Card card)
	{
		char rank = card.getRank();
		char suit = card.getSuit();
		int suitIndex =  Card.getSuitIndex(suit);
		int rankIndex =  Card.getRankIndex(rank);
		//setPanels[rankIndex].array[suitIndex].setText(card.toString());
		System.out.println("laying " + card);
		setPanels[rankIndex].array[suitIndex].setIcon(card.getCardImage());
	}

}

class HandPanel extends JPanel
{

	public HandPanel(String name,JList hand, JButton stack, JButton deck, JButton lay, JButton layOnStack, JButton turn)
	{
		//model = hand.createSelectionModel();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		add(Box.createGlue());
		JLabel label = new JLabel(name);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label);
		stack.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(Box.createGlue());
		add(stack);
		deck.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(Box.createGlue());
		add(deck);
		lay.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lay);
		layOnStack.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(layOnStack);
		turn.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(turn);
		add(Box.createGlue());
		add(hand);
		add(Box.createGlue());

	}

}
class SetPanel extends JPanel
{
	private Set data;
	JButton [] array = new JButton[4];

	public SetPanel(int index)
	{
		super();
		data = new Set(Card.rank[index]);

		for(int i = 0; i < array.length; i++){
			array[i] = new JButton("   ");
			add(array[i]);
		}
	}

}
