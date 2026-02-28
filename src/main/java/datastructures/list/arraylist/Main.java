package datastructures.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        ArrayList List interacini impolement eder.
        Normal arraylerin aksine boyutu sabit değildir; eleman eklendikçe otomatik olarak büyür.

        Çalışma Mantığı ve Kapasite Artışı
            İnitial Capacity: bir arraylist oluşturduğumda default olarak 10 kapasite ile bir bizi tutulur.
            Resizing: Dizi dolduğunda Java, mevcut dizinin 1.5 katı büyüklüğünde yeni bir dizi oluşturulur.
            Kopyalama: Eski dizideki tüm elemanlar yeni diziye Arrays.copfOf yöntemi ile aktarılır.
            eski diziyi garbage collector siler.

        Advantages:
            random access of elements O(1)
            good locality of reference and data cache utilization
            easy to insert/delete at the end.

        Disadvantages:
            wastes more memory
            shifting elements is time consuming
            expanding/Shrinking the array is time consuming
         */
        List<String> myArrayList =new ArrayList<>();

        /*
        arrayliste iki farklı şekilde eleman ekleyebiliriz.
        index numarasız .add("emre") kullanırsak listenin en sonuna ekleme yapar ve O(1)
         */
        myArrayList.add("a");
        myArrayList.add("b");
        myArrayList.add("c");

        //index numarası belirtirsek .add(2, "emre") ikinci indexe istenilen elemanı ekleriz ama O(n)
        myArrayList.add(2, "merhaba");

        //listedeki ilgili indexteki elemanı döndürmek için .get(index_number) kullanmalıyız.
        System.out.println(myArrayList.get(2));

        System.out.println(myArrayList.getLast());

        //listeden eleman silmek için .remove(index_number) kullanmalıyız. ama O(n)
        myArrayList.remove(1);

        // sondan eleman silmek O(1) ama listenin son elemanınn index numarasını bilmek gerekiyor
        myArrayList.removeLast();

        System.out.println(myArrayList);

    }

    /*
    MÜLAKAT NOTLARI

    1. ArrayList'in add işlemi her zaman O(1) midir ?
    Cevap: hayır, eğer dizi doluysa,, yeni dizi oluşturma ve kopyalama işlemi gerçekleieceği için
    işlem O(n) sürer.

    2. Arraylistin boyutu arttıkça kapasitesi her seferinde 1 artar mı?
    Cevap: hayır geometrik artar.

    3. Elimde 1 milyon veri var ver sürekli listenin en başına eklemen gerekiyor. ArrayList mi kullanmalıyım?
    Cevap: Hayır, Arraylist'in başına ekleme yapmak her seferinde 1 milyon elemanı sağa kaydırmak demektir O(n)
    Bu senaryoda LinkedList tercih edilmelidir.

    4. ArrayList içine int, double gibi primitive tipler koyabilir miyiz?
    Cevap: Hayır sadece objeler konabilir. ArrayList<int> yapamam. ArrayList<Integer> yapmalıyım

    5. ArrayList'in kapasitesi dolduğunda ne kadar artar ve bu artışın maliyeti nedir?
    Cevap: int newCapacity = oldCapacity + (oldCapacity >> 1); satırı ile 1.5 kat artış gerçekleşir
    Maliyeti O(n) dir.

    6. Resizing O(n) maliyetliyse, ArrayList neden hızlı deniliyor?
    Cevap: çünkü bu işlem her seferinde yapılmaz. 1000 eleman eklerken sadece birkaç kez resizing yapılır.
    buna "Amortized O(1)" denir. yani toplam maliyeti toplam ekleme sayısına böldüğümde, ekleme başına düşen
    maliyet hala sabite çok yakındır

    7. Bu malityeti nasıl minimize ebebiliriz?
    eğer eklenecek veri miktarını önceden tahmin edebiliyorsak, ArrayListi oluştururken bir Initial Capacity vermeliyiz.

    8. Kapasite artışını biz manuel tetikleyebilir miyiz?
    Cevap: evet, ensureCapacity(int minCapacity) metodu ile kapasiteyi manuel olarak artırabiliriz.
    Ayrıcam fazla boş alan kaldıysa trimToSize() ile kapasiteyi mevcut eleman sayısına eşitleyerek bellek tasarufu yapabiliriz

    9. Bir ArrayList içinde döngüyle dönerken (for-each) bir elemanı list.remove() ile silersen ne olur?
    Cevap: ConcurrentModificationException hatası fırlatır.
    Neden? ArrayList arka planda modCount (değişiklik sayacı) tutar. Iterator ile döngüye girdiğinde bu sayacı kilitler.
    Sen liste üzerinden direkt silme yaparsan sayaç değişir, Iterator bunu fark eder ve "Veri tutarlılığı bozuldu!"
    diyerek hata verir.
    Çözüm: Silme işlemini Iterator.remove() metoduyla veya Java 8+ ile gelen list.removeIf() ile yapmalısın.


    10. ArrayList belleği nasıl kullanır? neden bazen LinkedList'ten daha avantajlıdır?
    Cevap: CPU Cache Locality -> arraylist bir dizi olduğu için elemanlar bellekte yanyanadır. Cpu, bir elemanı okurken
    yanındakileri de cachee alır.
    LinkedListte elemanlar belleğin her yerine dağıldığı için CPU sürekli cache miss yapar.
     */


}
