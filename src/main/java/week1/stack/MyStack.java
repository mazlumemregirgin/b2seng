package week1.stack;
import java.util.Arrays;

public class MyStack {

    private int maxSize;
    private int top;
    private String[] stackArray;

    public MyStack(int size) {
        this.maxSize = size;
        this.top = -1;
        this.stackArray = new String[maxSize];
    }

    /*
        PseudoCode for push()
        1- check if the stack full
            if full return err msg
        2- if not full; first increment the top value then insert the element. preIncrement

     */
    public void push(String item){
        if(top == maxSize-1){
            System.out.println("Stack Dolu");
            return;
        }
        stackArray[++top]= item;
    }

    /*
        pseudoCode for pop()
        1- check if the stack empty
            if empty return err msg
        2- if not empty; first pop then decrement the index number. postDecrement
     */
    public String pop(){
        if (top == -1){
            System.out.println("Stack Boş");
        }
        String poppedElement = stackArray[top];
        stackArray[top--] = null;

        return poppedElement;
    }

    // return the top element of the stack
    public String peek(){
        return stackArray[top];
    }
    // if the top number is -1 return true; then false
    public boolean isEmpty(){
        return top == -1;
    }

    /*
        pseudoCode for Search()
        son element 1 bir önceki 2 ondan önceki 3 olarak gidiyor
        5 elemanlı bir arrayim var ve ben 4. elemanın search ile positionını
        bulmak istiyorum (arrayin sondan ikini elemanı olduğu için sonuç 2 çıkması gerekiyor.)

        Eğer arrayin lengthinden o elemanın indexini çıkarırsam positionunı bulabilirim.

        length - index = position
        5 - 3 = 2

     */
    public int search(String item){
        return (top+1)- Arrays.asList(stackArray).indexOf(item);
    }

    // stackimi print ettiğimde memory adresi yerine arrayin içini görmek için
    // toString() fonksiyonunu override ettim.
    @Override
    public String toString(){
        if (top == -1){
            return "Stack boş";
        }
        return Arrays.toString(stackArray);
    }
}