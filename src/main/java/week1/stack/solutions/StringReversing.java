package week1.stack.solutions;

import java.util.Scanner;
import java.util.Stack;

public class StringReversing {
    //Açıklama: Kullanıcıdan alınan bir kelimeyi (ör. "Mugla") bir Stack kullanarak ters çeviren kodu yazınız.

    // 1- kullanıcıdan input olarak kelime almalıyım
    // 2- kelimedeki tüm harfleri bir stacke pushlamalıyım.
    // 3- stackteki tüm harfleri poplamalıyım


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a Word:");
        String word = scanner.nextLine();

        if (word.isEmpty()) {
            System.out.println("Word is Empty");
        }
        else {
            int wordLength = word.length();

            Stack<Character> stack = new Stack<>();

            for (int i =0; i<wordLength; i++) {
                stack.push(word.charAt(i));
            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
        }


    }
}
