package lab3;

public class Test {
    public static void main(String[] args) {
        //testing of the stack
        StackInterface stack = new StackReferenceBased();
        //add 4 items to the stack
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        //display the stack
        stack.displayStack();



    }

    //method to check for balanced braces, takes stack as input and checks against this.
    public boolean isBalanced(StackReferenceBased stack) {
     return false;
    }
}
