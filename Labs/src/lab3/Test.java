package lab3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //testing of the stack
        StackInterface stack = new StackReferenceBased();
        //menu scanner
        Scanner sc = new Scanner(System.in);
        //display the stack
        stack.displayStack();


        //user menu
        int userChoice;


        //user loop
        //use cases:
        //1: push string to stack.
        //2: pop a string from stack, check if stack is empty.
        //3: peek at the top of the stack, error handling.
        //4: empty the stack, default stack is empty
        //5: isBalanced string method check
        //6: exit the program.
        do {
            System.out.println("enter your choice");
            printMenu();
            //users choice
            userChoice = sc.nextInt();

            //switch case to handle user menu choices
            switch (userChoice) {
                case 1:
                    //push a string to the stack
                    //take users input
                    System.out.print("String to push to stack?");
                    String pushItem = sc.next();
                    stack.push(pushItem);
                    //update user on success or failure
                    if (stack.peek() == pushItem) {
                        System.out.println(pushItem + " added to the stack.");
                    }
                    //display stack to the user
                    System.out.println("here is the new stack.");
                    stack.displayStack();
                    break;
                case 2:
                    //pop item from the stack
                    //error handling to check if the stack is empty
                    System.out.println("attempting to pop from the stack");
                    try {
                        stack.pop();

                    } catch (StackException e) {
                        System.out.println("pop attempt failed.");
                    }
                    stack.displayStack();
                    break;
                case 3:
                    //case 3 peek at the top of the stack
                    System.out.println("Attempting to peek at the top of the stack");
                    try {
                        stack.peek();
                    } catch (StackException e) {
                        System.out.println("Stack is empty. " + e.getMessage());
                    }
                    break;
                case 4:
                    //empty the stack
                    //error stack already empty
                    System.out.println("attempting to empty the stack");
                    try {
                        stack.popAll();

                    } catch (StackException e) {
                        System.out.println("stack is empty" + e.getMessage());
                    }
                    stack.displayStack();
                    break;
                case 5:
                    System.out.println("enter a balanced string to check against brackets");
                    //is the input a string


                case 6:
                    System.out.println("attempting to close the program");
                    System.exit(0);
                default:
                    System.out.println("invalid choice.");
                    System.exit(1);

            }
        }
        while (true);
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
                try {
                    //push operations can fail for implementation-dependent reasons
                    stack.push(c);
                }catch(StackException e){
                    System.out.println("error pushing to stack, see error" + e.getMessage());
                }
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

    //method to print user choice menu
    public static void printMenu() {
        System.out.println("Welcome to STackTest! Please select a number from the list.");
        System.out.println("1.\t Push a string on to the stack");
        System.out.println("2.\t Pop a string from the stack.");
        System.out.println("3.\t Peek at the top of the stack.");
        System.out.println("4.\t Empty the stack.");
        System.out.println("5.\t Check if a string has balanced brackets.");
        System.out.println("6.\t Quit the program.");
    }


}
