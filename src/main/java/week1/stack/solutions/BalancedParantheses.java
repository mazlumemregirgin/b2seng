package week1.stack.solutions;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParantheses {

    //Açıklama: Verilen bir String yalnızca ( ve ) karakterlerinden oluşmaktadır.
    // Stack kullanarak parantezlerin dengeli (her açılan parantezin kapanmış olması) olup olmadığını kontrol eden metodu yazınız.
    //Örnek: (()) → true, (() → false


    // 1- gelen karakter dizisinde (,[,{ karakterlerinden biri ise stacke pushlayacağım.
    // 2- kapama işareti gelirse pop yapacağım ama pop yaptığım char gerçekten açma işaretinin kapaması olacak ( ise ) olmalı yoksa false
    // 3- en son stack boş kalırsa herkes eşleşmiş demektir. return true

    // ({[ ]})
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String word = scan.nextLine();

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < word.length(); i++) {
            char paranthesis = word.charAt(i);

            if (paranthesis == '(' || paranthesis == '[' || paranthesis == '{') {
                stack.push(paranthesis);
            } else {

                if (stack.isEmpty()) {
                    System.out.println("Not balanced!");
                    return;
                }

                char poppedElement = stack.pop();
                boolean isMatched = false;

                switch (paranthesis) {
                    case ')':
                        if (poppedElement == '(') isMatched = true;
                        break;
                    case ']':
                        if (poppedElement == '[') isMatched = true;
                        break;
                    case '}':
                        if (poppedElement == '{') isMatched = true;
                        break;
                }

                if (!isMatched) {
                    System.out.println("Not balanced!");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Balanced!");
        } else {
            System.out.println("Not balanced!");
        }
    }
}
