package datastructures.queue;


import java.util.LinkedList;

/*
    Java'da LinkedList, hem bir List hem de bir Deque'dir.
    Doubly LinkedList olarak implemente edilmiştir. Bellekte elemanlar yan yana
    durmaz. Her bir eleman bir Node nesnesidir

    Bir node 3 şey içerir:
    1- data -> saklanan veri
    2- Next -> bir sonraki düğümün bellek adresi
    3- Prev -> bir önceki düğümün bellek adresi

    Pros:
    -Boyutu dinamiktir, başta belirtmeye gerek yoktur.
    -Başa ve sona ekleme/çıkarma işlemleri çok verimlidir (O(1))

    Cons:
    -Her eleman için fazladan prev ve next adreslerini tuttuğu için daha fazla bellek (RAM) harcar.
    -Rastgele erişim çok yavaştır.

    Başa/sonra ekleme -> O(1) -> sadece adres bağları değiştirilir, çok hızlıdır.
    Araya ekleme -> O(n) -> ilgili indekse gidene kadar düğümleri tek tek gezmek zorundayız.
    Erişim -> O(n) -> ArrayList gibi direkt adrese gidemez, baştan saymaya başlar.
    Silme -> O(1) -> eğer silinecek düğümün adresini biliyorsak, bağları koparmak yeterlidir.
 */

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Liste özellikleri
        list.add("Java");
        System.out.println(list);
        list.add(1, "Python"); // Araya ekleme yapmak çok hızlıdır
        System.out.println(list);

        // Queue/Deque özellikleri
        list.addFirst("C++");  // Başına ekle
        list.addLast("Go");    // Sonuna ekle
        System.out.println(list);

        // Veri çekme
        System.out.println("Baş: " + list.peekFirst());
        System.out.println("Son: " + list.getLast());

        // veri silme
        list.removeFirst(); // Baştakini siler
        list.removeLast(); // sondakini siler
        System.out.println(list);
    }
}
