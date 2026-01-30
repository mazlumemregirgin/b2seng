package week1.stack;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        /* Stack -> Last-In-First-Out (LIFO) mantığı ile çalışır. Son giren ilk çıkar.
         Java'da Built-in Stack sınıfı, Vector sınıfını extend eder.
         java.util package'ının içindedir.

         5 temel method vardır:
         1- pop(), stackteki en üstteki elementi atar.
         2- push(), stack'in en üstüne element ekler.
         3- peek(), stackteki en üstteki elemente bakar ama pop gibi silmez. just look.
         4- empty(), stack boş mu kontrolü yapar.
         5- search(), stackteki elementlerin nerede olduğuna bakılır. En son eklenenin konumu 1'dir.
            ondan önce eklenen elementler 2,3,4 diye gider.
        */

        Stack <String> myStack = new Stack<>();

        System.out.println("My Stack");
        System.out.println(myStack);

        myStack.push("Yellow");
        myStack.push("Red");
        myStack.push("Blue");
        myStack.push("Green");

        System.out.println(myStack);

        myStack.pop();
        System.out.println(myStack);

        String topElement= myStack.peek();
        System.out.println(topElement);

        System.out.println(myStack.empty());

        System.out.println(myStack.search("Yellow"));


        //------------------------------------------------------------------

        MyStack myStack1 = new MyStack(5);

        System.out.println(myStack1);
        myStack1.push("mavi");
        System.out.println(myStack1);

        myStack1.push("sarı");
        myStack1.push("yeşil");
        myStack1.push("pembe");
        System.out.println(myStack1);

        String poppedElement = myStack1.pop();
        System.out.println(poppedElement);
        System.out.println(myStack1);


        System.out.println(myStack1.search("mavi"));
    }
}

