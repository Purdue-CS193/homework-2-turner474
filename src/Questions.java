/*
* CS 193 Homework 3
*
* TODO: READ THESE INSTRUCTIONS!
*
* The comments in the methods are for clarification. No tricks or riddles.
*
* The overall algorithm should not change. Don't focus on improving the runtime. 
*
* Debug in whichever way you feel is best.
*
* IT WILL BE AN AUTOMATIC 0, IF YOU MAKE CHANGES TO TESTCASES.JAVA
*
* Bonus: Understand these methods! They are helpful in interviews :)
* 
*/

import java.util.*;

public class Questions {

    // Task 1
    public static int findMax(int[] input) {
        // find the max in the input array
        int max = input[0];//Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }
        return max;
    }

    // Task 2
    public static int findMin(int[] input) {
        // find the smallest element in the array
        int min = input[0]; //Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < min) {
                min = input[i];
                //System.out.println(input[i]);
            }
        }
        return min;
    }

    // Task 3
    public static int findSum(int[] input) {
        // find the sum of all the elements in the array
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
        }
        return sum;
    }

    // Task 4
    public static int findAverage(int[] input) {
        // find the average of the input
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
        }
        int average = (sum / (input.length));
        return average;
    }

    // Task 5
    public static ArrayList<String> fizzBuzz(int n) {
        // EXPLANATION: RETURN A LIST 1 TO n BUT
        // Multiples OF 3 ARE REPLACED BY "fizz"
        // Multiples OF 5 ARE REPLACED BY "buzz"
        // Multiples OF 3 AND 5 ARE REPLACED BY "fizzbuzz"
        //
        // FROM 1 TO 15 THE LIST WOULD LOOK LIKE
        // {"1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"}
        // Note: In java an array is different from a list
        // The data structure we will be using is an ArrayList

        ArrayList<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 ==0) {
                answer.add("fizzbuzz");
            } else if (i % 5 == 0) {
                answer.add("buzz");
            } else if (i % 3 == 0) {
                answer.add("fizz");
            } else {
                answer.add(Integer.toString(i));
            }
        }
        return answer;
    }
    
    // Task 6
    public static int reverseNumber(int input) {
        // reverse the number
        // 12345 should become 54321
        // Hint: How would you turn 9 into 95? Not by adding 86
        StringBuilder answer = new StringBuilder();

        while (input != 0) {
            int digit = input % 10;
            answer.append(digit);
            input = input / 10;
        }

        // Convert the reversed string to an integer
        return Integer.parseInt(answer.toString());
    }

    
    //EXTRA CREDIT BELOW HERE
    
    // Task 7
    // Look for a specific element in sorted array
    // keep in mind for this algorithm to work, array HAS to be sorted
    public static int binarySearch(int[] input, int target) {
        // look for the index of target in input
        int low = 0;
        int high = input.length; //-1;
        for (int i = 0; i < high; i++) {
            if (input[i] == target) {
                return i;
            //low = low + 1;
                }
            }
        return -1;
    }
            //int mid = (low + high) / 2;
            //if (input[mid] == target) { // middle element is the target. Success!!!
                //return mid;
           // } else if (input[mid] > target) { // middle element is greater than the target
           //     low = mid + 1;
          //  } else { // middle element is smaller than the target
               // high = mid - 1;

        //return -1; // element is not found
    //}
    
    // Task 8
    public static int countDuplicates(String input) {
        // Count the number of letters that are duplicated
        // The input string will always be lower case and contain no numbers
        // Example: Input: This is homework, Return: 3 (letters i, s, h, and o occur more than once

        input = input.toLowerCase(); // Ensure string is lower case
        int[] alphabetTemplate = new int[26];
        int counter = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                int index = ch - 'a'; // Map character to index (0-25) in the alphabetTemplate
                if (alphabetTemplate[index] == 1) {
                    counter++; // This letter has already occurred once, so it's a duplicate
                    alphabetTemplate[index] = -1; // Mark it as a duplicate
                } else if (alphabetTemplate[index] == 0) {
                    alphabetTemplate[index] = 1; // First occurrence of this letter
                }
            }
        }

        return counter;
    }


    // Task 9
    public static int sumBetween193(int[] input) {
        // Sum up numbers between the first 193 and the next 193 non-inclusive
        int sum = 0;
        boolean startCounting = false;
        for (int i = 0; i < input.length; i++) {
            if (startCounting) {
                sum = sum + input[i];
                if (input[i] == 193) {
                    startCounting = false;
                    break;
                }
            } else {
                if(input[i] == 193) {
                    startCounting = true;
                }
            }
        }
        return sum-193;
    }

    // Task 10
    public static boolean findSubstring(String theBigOne, String sub) {
        // checks to see if variable sub appears in theBigOne
        // highly recommended to write this one out on a notebook
        int counter = 0;
        for (int i = 1; i < theBigOne.length(); i++) {
            if (theBigOne.charAt(i) == sub.charAt(0)) {
                for (int j = ; j < theBigOne.length(); j++) {
                    if (theBigOne.charAt(j) == sub.charAt(j - i)) {
                        counter += 1;
                    } else { // a character didn't match so break
                        break;
                    }
                    if (counter == sub.length()) {
                        return true;
                    }
                }
            }
        }
        return true;
    }
    // Main method is used for testing purposes
    public static void main(String[] args) {
        // Example given below
        // Run reverseNumber with your own input
        System.out.println(reverseNumber(54321)); 
    }
}
