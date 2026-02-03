package queue;

/*
    queue -> FIFO -> First-In-First-Out
    İlk giren ilk çıkar.

    Enqueue -> ekleme
    Dequeue -> çıkarma

    Neden Kullanılır?
    1- Yapılacak işlemlerin geliş sırasına göre işlenmesi gerekiyorsa
    2- Hız Dengeleme: veri üreten taraf ile tüketen tarad farklı hızlarda çalışıyorsa, aradaki dengeyi kurmak için.
    3- Tek Bir kaynağı birden fazla isteğin kullanması gerektiğinde
*/

import java.util.LinkedList;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {

        //Queue(), Java'da bir interface olduğu için instantiate edemeyiz.
        // Bunun yerine Queueyi implement eden classları kullanmalıyız (LinkedList, Priority Queue gibi)
        //Queue<String> MyQueue = new Queue<>();

        Queue<String> MyQueue = new LinkedList<>();

        //queue'ya eleman eklemek için offer() veya add() kullanılır
        MyQueue.offer("a");
        MyQueue.offer("b");
        MyQueue.offer("c");

        MyQueue.add("d");

        //queue'dan eleman çıkarmak için poll() veya remove() kullanılır
        MyQueue.poll();

        MyQueue.remove();


        //Queueun en ilk eklenenine bakmak için element() veya peek() kullanılır
        System.out.println(MyQueue.peek());


        System.out.println(MyQueue);



    }
}
