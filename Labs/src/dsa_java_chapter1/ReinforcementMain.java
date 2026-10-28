package dsa_java_chapter1;
import java.util.Scanner;

public class ReinforcementMain {
    static GameEntry[] gameA = new GameEntry[4];
    static GameEntry game1 = new GameEntry();
    static GameEntry game2 = new GameEntry();
    static GameEntry game3 = new GameEntry();
    static GameEntry game4 = new GameEntry();

    static int[] userInputArr = new int[10];
    static int arrIndex = 0;
    static int sum; static float average;


    static void main() {
        //clone
        game1.name = "gary";
        game2.name = "dune";
        game3.name = "wow";
        game4.name = "test";
        gameA[0] = game1;
        gameA[1] = game2;
        gameA[2] = game3;
        gameA[3] = game4;

        //clone array
        GameEntry[] gameB = gameA.clone();

        for (GameEntry gameEntry : gameB){
            System.out.println(gameEntry.name);
        }

        // access score to 550 of [3] element
        gameB[3].setScores(550);
        System.out.println("score of game should equal 550 " +  "actual value:" + gameB[3].getScores());
        //exercise R1.2
        System.out.println("testing multiple");
        long number1; long number2;
        number1 = 10;
        number2 = 2;
        System.out.println("number 2 should be a number1 of 10 " + isMultiple(number2, number1));
        int number3 = 5;
        System.out.println("number should be odd" + isOdd(number3));
        int number4 = 14;
        int number5 = 5;
        System.out.println("14 is a multiple of 7 " + isMultipleOf3Or7(number4));
        System.out.println("5 is not a multiple of 3 nor 7 " + isMultipleOf3Or7(number5));
        //retrieve 10 numbers from the user
//        while(arrIndex != userInputArr.length) {
//            takeNumbersFromUserInput();
//        }
//       //sum array
//        for (int j = 0; j < userInputArr.length; j++) {
//           sum += userInputArr[j];
//        }
//        System.out.println("sum is " + sum);
//        //average calc
//        average = (float) sum / userInputArr.length;
//        System.out.println("average is " + average);
        //R 1.6
        int numberForCalculation = 5;
        System.out.println("number equal 5" + calcSquareNumbers(numberForCalculation));
        //r 1.7
        String vowelString = "aeikkk";
        System.out.println("3 vowels in string" + countCharString(vowelString));
        //r 1.8
        String stringToScan = "HelloWorld123!@";
        int[] results = countCharString(stringToScan);
        System.out.println(stringToScan + "contains vowels:" + results[0] + "\ncontains numbers: " + results[1]
        + "\n contains special Chars: " + results[2]
        + "\n contains constonants: " + results[3]);
    }

    //write a method isMultiple that takes two long values, n and m,
    // and returns true if and only if n is a multiple of m
    public static boolean isMultiple(long n, long m){
        if (m % n == 0){
            return true;
        } else {
            return false;
        }
    }
    //write a method isOdd that takes an int value and checks
    // whether the number is odd.
    public static boolean isOdd(int n){
        if (n % 2 == 0){
            return false;
        }
        return true;
    }
    public static boolean isMultipleOf3Or7(int n){
        return n % 7 == 0 || n % 3 == 0;

    }

    public static void takeNumbersFromUserInput() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        userInputArr[arrIndex] = num;
        arrIndex++;
    }
    //method that takes an integer n and returns the sum of the squares of all positive integers less
    //than or equal to n
    public static float calcSquareNumbers(int n){
        float result = 0;
        for (int i = n; i >= 0; i--){
            result += (float) Math.pow(i, 2);
        }
        return result;
    }

    //write a method that count s the number of vowels, consonants, numerals and special symbols in a given
    //char string
    public static int[] countCharString(String s) {
        //convert to char array
        String str = s.toLowerCase();
        int[] results = new int[4];
        int vowelCount= 0;
        int specialCount = 0;
        int numeralCount = 0;
        int constontantCount = 0;

        for(char c : str.toCharArray()){
            if (c == 'a' || c == 'i' || c == 'o' || c == 'u' || c =='e'){
                vowelCount++;
            } else if (Character.isDigit(c)){
                numeralCount++;
            } else if(!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)){
                specialCount++;
            } else if(Character.isLetter(c)) {
                constontantCount++;
            }
        }

        results[0] =  vowelCount;
        results[1] =  numeralCount;
        results[2] =  specialCount;
        results[3] =  constontantCount;
        return results;
    }

}
