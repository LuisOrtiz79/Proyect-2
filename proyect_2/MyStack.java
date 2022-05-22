/* Luis E. Ortiz Cotto
   #801-16-5704
   CCOM4029 Sec.002
   Prof. Patricia Ordonez
*/

/*The purpose of this program is to to create a stack with the use
  of the stack library that is in java. That has the standard operations
  such as push, pop, isEmpty, and top. Also with a main that has some test
  to prove that the functions are working properly*/

import java.util.*;

public class MyStack{
  /*Creates an empty stack*/
  private ArrayList<Card> stack;
  private int top;
  private int size;

  /*Is the constructor of the class MyStack*/
  public MyStack(int s){
    this.stack = new ArrayList<Card>(s); //Creates a new stack
    this.size = s;
	  this.top = -1;
  }

  /*Returns the variable that is first in the stack*/
  public Card top(){
    if(!isEmpty()){
      return stack.get(top);
    }
    return null;
  }

  /*Checks if the stack has a variable or not*/
  public boolean isEmpty() {
   return top == -1;
  }

  /*Puts the values in the stack*/
  public void push(Card card){
    top++;
    stack.add(card);
  }

  /*Eliminates the value at the top of the stack*/
  public Card pop(){
    if(!isEmpty()){
      int tmp = top;
      top--;
      return stack.get(tmp);

    }
    return null;
  }

  /*Returns the total of variable that the stack has*/
  public int getSize(){
    return size;
  }

  /*Functions a case test for the MyStack class*/
  /*public static void main(String args[]){
    ArrayList<Card> stack1 = new ArrayList<>(10);

    //Ask the user for the number of cards to push in the stack
    int s = 0;
    System.out.println("Please enter the number of card to add between 1 - 10: ");
    Scanner S = new Scanner(System.in);
    s=S.nextInt();

    System.out.println("Stack with a size of: " + stack1.getSize());

    //Inserts in the stack the number of cards given
    for(int i = 0; i < s; i++){
      int j = 0;
      Card card = new Card(Card.suit[i],Card.rank[j++]);
      stack1.push(card);
      System.out.println("Stack with a size of: " + stack1.getSize());
    }

    System.out.println("Stack: " + stack1 + " " + stack1.top());

    //Ask user for the number of cards to pop in the stack
    int p = 0;
    System.out.println("Please enter the number of card to remove between 1 - 10: ");
    Scanner P = new Scanner(System.in);
    p=S.nextInt();

    //Removes the first numbers cards given in the stack
    for(int j = 0; j < p; j++){
      int i = 0;
      Card card = new Card(Card.suit[j],Card.rank[i++]);
      stack1.pop(card);
      System.out.println("Stack with a size of: " + stack1.getSize());
    }

    System.out.println("Stack: " + stack1  + " " + stack1.top());
  }*/

}
