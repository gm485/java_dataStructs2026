package lab3;

import lab2.Node;

public class StackReferenceBased implements StackInterface
{
  private Node top;

  public StackReferenceBased()
  {
    top = null;
  }  // end default constructor
  //============================================================================
  //============================================================================
  //============================================================================

  public boolean isEmpty()
  {
    return top ==  null;
  }  // end isEmpty
//============================================================================
//============================================================================
//============================================================================

  public void push(Object newItem)
  {
    top = new Node(newItem, top);
  }  // end push
  //============================================================================
  //============================================================================
  //============================================================================

  public Object pop() throws StackException
  {
    if (!isEmpty())
    {
      Node temp = top;
      top = top.getNext();
      return temp.getItem();
    }
    else
    {
      throw new StackException("StackException on " + "pop: stack empty");
    }  // end if
  }  // end pop
  //============================================================================
  //============================================================================
  //============================================================================

  public void popAll()
  {
    top = null;
  }  // end popAll

//============================================================================
//============================================================================
//============================================================================
  public Object peek() throws StackException
  {
    if (!isEmpty())
    {
      return top.getItem();
    }
    else
    {
      throw new StackException("StackException on " + "peek: stack empty");
    }  // end if

  } // end peek
//============================================================================
//============================================================================
//============================================================================


  //display stack vertically print the stack, indicating which item is at the top
  public void displayStack() {
    //if the stack is empty
    Node curr = top;
    if (curr == null) {
      System.out.println("the stack is empty");
    }
    System.out.println("Top of the Stack");
    //print out the stack
    while(curr != null) {
      System.out.println(curr.getItem());
      curr = curr.getNext();

    }

  }

}  // end StackReferenceBased