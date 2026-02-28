package datastructures.queue;

import java.util.Collections;
import java.util.PriorityQueue;

/*
    Priority Queue: Normal bir queue FIFO mantığı ile çalışırken, Priority Queue'da
    elemanlar önceliklerine göre sıralanır. En yüksek önceliğe sahip
    olan eleman, queue'un en başındadır ve ilk o çıkarılır.
 */
public class PriorityQ {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30);
        pq.offer(790);
        pq.offer(80);

        System.out.println(pq); // bunun sonucu [30, 790, 80]

        /* ben aslında küçükten büyüğe sıralı gelmesini beklemiştim.
         fakat priorityqueue, verileri bir Min-Heap yapısında tutar. Heap yapısı tüm listenin tamamen sıralı olmasını
         garanti etmez. Ancak şunu garanti eder: "Root her zaman en küçük elemandır" bu yüzden en küçük eleman yani 5
         ilk başta gözükür.
        */

        // Doğru sıralamayı görmek için poll()'lamalıyım.

        System.out.println("Priority Queue yazdırılıyor...");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // bunun sonucu 30, 80, 790
        }

        /*
        MÜLAKAT NOTU:
        Eğer mülakatta "PriorityQueue'yu yazdırdım ama sıralı çıkmadı, neden?" diye sorulursa:

        "Çünkü PriorityQueue bir Binary Heap'tir. Heap yapısı tam sıralı bir liste değil, kısmi sıralı
         bir ağaç yapısıdır. Sadece en üstteki elemanın en küçük olduğu garanti edilir. Tam sıralı çıktı
         almak için elemanları poll() ile tek tek çekmek gerekir."
         */

        /*
        PriorityQueue Min-Heap yapısını kullandığı için default olarak küçükten büyüğe doğru bir yazdırma yapar.
        Ama günlük hayatta "öncelik" dediğimiz şey değişebilir olduğu için mesela VIP üyeler için banka hesabı
        kabarık olan daha önceliklidir. Bu yüzden yapıyı Min-Heap'ten Max-Heap'e çevirmemiz gerekiyor.
         */

        /*
        MÜLAKAT NOTU: PriorityQueue'yu Max-Heap' nasıl çevirirsin?
        CEVAP: Constructor içine bir Comparator vererek.
        Collections.reverseOrder() methodunu kullanabilirim.
         */
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.offer(30);
        pq2.offer(790);
        pq2.offer(80);

        while (!pq2.isEmpty()) {
            System.out.println(pq2.poll()); // Artık çıktı 790, 80, 30
        }


    }

}
