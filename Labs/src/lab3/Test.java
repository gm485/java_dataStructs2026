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

        //test strings to test against
        String test01 = "{a{b}c}";
        System.out.println("is " + test01 + " balanced: " + isBalanced(test01));


    }

    //method to check for balanced braces, takes stack as input and checks against this.
    public static boolean isBalanced(String s) {
        final String opening = "({["; //opening delimeters
        final String closing = ")}]"; //closing delimeters
        //stack
        StackInterface stack = new StackReferenceBased();

        //convert param to charArray,
        //check to determine whether brackets match
        //loop over each item, when you find opening bracket
        //push to stack
        for(char c: s.toCharArray()) {
            if(opening.indexOf(c) != -1){
                stack.push(c);
            } else if (closing.indexOf(c) != -1){
                //check if the stack is empty exit function returning false
                if (stack.isEmpty()) {
                    return false;
                }
                //check left against right delimeter of opening
                //closing pop does not match opening that has been added to the stack.
                if (closing.indexOf(c) != opening.indexOf((Character)stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
