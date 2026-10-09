package lab3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //testing of the stack
        StackInterface stack = new StackReferenceBased();
        //menu scanner
        Scanner sc = new Scanner(System.in);
        //user menu choice
        int userChoice = 0;


        //user loop
        //use cases:
        //1: push string to stack.
        //2: pop a string from stack, check if stack is empty.
        //3: peek at the top of the stack, error handling.
        //4: empty the stack, default stack is empty
        //5: isBalanced string method check
        //6: exit the program.
        do {
            printMenu();
            System.out.println("enter your choice");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid choice");
                sc.nextLine();
                continue;
            }
            //users choice
            userChoice = sc.nextInt();
            sc.nextLine();


            //switch case to handle user menu choices
            switch (userChoice) {
                case 1:
                    //push a string to the stack
                    //take users input
                    System.out.print("String to push to stack?");
                    String pushItem = sc.nextLine();
                    stack.push(pushItem);
                    //update user on success or failure
                    if (pushItem.equals(stack.peek())) { //object comparison
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
                        Object popItem = stack.pop();
                        System.out.println(popItem + ", popped from the stack.");

                    } catch (StackException e) {
                        System.out.println("pop attempt failed.");
                    }
                    stack.displayStack();
                    break;
                case 3:
                    //case 3 peek at the top of the stack
                    System.out.println("Attempting to peek at the top of the stack");
                    try {
                        System.out.println(stack.peek() + ", Top of the stack.");

                    } catch (StackException e) {
                        System.out.println("Stack is empty. " + e.getMessage());
                    }
                    break;
                case 4:
                    //empty the stack
                    //error stack already empty
                    System.out.println("attempting to empty the stack");
                    stack.popAll();
                    stack.displayStack();
                    System.out.println("stack emptied successfully");
                    break;

                case 5:
                    System.out.println("enter a balanced string to check against brackets");
                    //is the input a string
                    //regex to check for string input
                    String bracketInput = sc.nextLine();
                    if (!bracketInput.matches("[a-zA-Z\\{\\}\\[\\]\\(\\)\\s]*")){
                        System.out.println("Invalid bracket entered. Please try again.");
                    }else {
                        if (isBalanced(bracketInput)) {
                            System.out.println("Bracket check against brackets successful.");
                            stack.displayStack();
                        } else {
                            System.out.println("Bracket check against brackets failed.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("attempting to close the program");
                    System.exit(0);
                default:
                    System.out.println("invalid choice. Please select a number from the list");
                    break;

            }
        }
        while (userChoice != 6);
    }


    //method to check for balanced braces, takes stack as input and checks against this.
    public static boolean isBalanced(String s) {
        final String opening = "({["; //opening delimeters
        final String closing = ")}]"; //closing delimeters
        //stack
        StackInterface stack = new StackReferenceBased();
        //check if string contains brackets
        boolean isBracketsPresent = false;

        //convert param to charArray,
        //check to determine whether brackets match
        //loop over each item, when you find opening bracket
        //push to stack
        for(char c: s.toCharArray()) {
            if(opening.indexOf(c) != -1){
                isBracketsPresent = true;
                try {
                    //push operations can fail for implementation-dependent reasons
                    stack.push(c);
                }catch(StackException e){
                    System.out.println("error pushing to stack, see error" + e.getMessage());
                }
            } else if (closing.indexOf(c) != -1){
                //check if the stack is empty exit function returning false
                isBracketsPresent = true;
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
        return isBracketsPresent && stack.isEmpty();
    }

    //method to print user choice menu
    public static void printMenu() {
        String border = "#".repeat(70);

        System.out.println(border);
        System.out.println(String.format("# %-66s #", "Welcome to STackTest! Please select a number from the list."));
        System.out.println(String.format("# %-66s #", "# 1. Push a string on to the stack"));
        System.out.println(String.format("# %-66s #", "2. Pop a string from the stack."));
        System.out.println(String.format("# %-66s #", "3. Peek at the top of the stack."));
        System.out.println(String.format("# %-66s #", "4. Empty the stack."));
        System.out.println(String.format("# %-66s #", "5. Check if a string has balanced brackets."));
        System.out.println(String.format("# %-66s #", "6. Quit the program."));
        System.out.println(border);
    }


}
