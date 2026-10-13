package lab4;

import java.util.Scanner;

public class TestPrintQueue {

    //helper function to build menu and look for user input.
    public static int getMenuChoice(Scanner sc) {
        int userChoice;

        System.out.println("Please select an option from the list.");
        System.out.println("1. Enqueue a job.");
        System.out.println("2. Dequeue a job.");
        System.out.println("3. Peek at the job at front of the queue.");
        System.out.println("4. Empty the queue.");
        System.out.println("5. Display all jobs.");
        System.out.println("6. Quit the program.");

        //menu validation
        if (!sc.hasNextInt()){
            System.out.println("Please enter a valid choice.");
            sc.next();
        }
        userChoice = sc.nextInt();
        //clear space on buffer
        sc.nextLine();
        return userChoice;
    }


    public static void main(String[] args) {

        //menu starts here
        System.out.println("Welcome to PrintServer!");
        QueueArrayBased printQueue = new QueueArrayBased();
        Scanner sc = new Scanner(System.in);
        int choice;

        //menu loop
        do {
            choice = getMenuChoice(sc);

            switch (choice) {
                case 1:
                    System.out.println("enter the name of the job you want to enqueue.");
                    String jobName = sc.nextLine();
                    System.out.println("enter number of pages");

                    while(!sc.hasNextInt()){
                        System.out.println("Please enter a valid page number");
                        sc.next();
                    }
                    int pages = sc.nextInt();
                    sc.nextLine();

                    PrintJob newJob = new PrintJob();
                    newJob.setDoc_name(jobName);
                    newJob.setPages(pages);

                    try{
                        printQueue.enqueue(newJob);
                        System.out.println(printQueue.peek() + "has been added to the queue.");

                    } catch(QueueException e){
                        System.out.println("error adding job" + e.getMessage());
                    }
                    break;

                case 2:
                    //dequeue from the front of the queue
                    try{
                        printQueue.dequeue();
                    } catch(QueueException e){
                        System.out.println("error dequeueing job \n " + e.getMessage());
                    }
                    break;
                case 3:
                    //Peek at the job at front of the queue
                    try {
                        printQueue.peek();
                    } catch(QueueException e){
                        System.out.println("error peeking job " + e.getMessage());
                    }
                    break;
                case 4:
                    //empty the queue
                    try {
                        printQueue.peek();
                    } catch(QueueException e) {
                        System.out.println("error peeking job " + e.getMessage());
                    }
                    break;
                case 5:
                    //display all the jobs
                    System.out.println("placeholder print option");
                    break;
                case 6:
                    //quit the program
                    System.out.println("Goodbye! Your Queue is lost.");
                    System.exit(0);
            }

        } while (choice != 6);
        sc.close();
    }
}
