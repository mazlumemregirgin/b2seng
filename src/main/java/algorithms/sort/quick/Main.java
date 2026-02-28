package algorithms.sort.quick;

public class Main {
    public static void main(String[] args) {


        /*
        quicksort: moves smaller elements to left of a pivot.
                   recursively divide array in 2 partitions.

        big o complexity ->  O(n^2) -> dizi zaten sıralıysa ve biz hep en sondaki elemnaı pivot seçiyorsak
        dizi her seferinde sadece 1 eleman eksilir.
        aveage case -> O(nlogn)
        space complexity -> O(logn)

        merge sort gibi divide and conquer mantığı ile çalışır ama yaklaşımı tam tersidir.
        merge sort önce böler sonra birleştirirken sıralar;
        quick sort ise önce sıralar, sonra böler.

        Quick sort mantığı: pivot ve partitioning
        1. pivot seçimi: diziden bir eleman seçilir(genelde en sondaki eleman seçilir.)
        2. partition: pivottan küçük olan tüm elemanlar sol tarafa, büyük olanlar sağ tarafa taşınır.
        3. yerleştirme: pivot tam olması gereken yerine yerleşir.
        4. recurison: pivotun solunda ve sağında kalan alt diziler için aynı işlem tekrarlanır.


        Neden javada dula-pivot kullanılıyor?
        klasik quicksortta 1 pivot 2 parça olur.
        dual-pivotta 2 pivot seçilir ve dizi 3 parçaya bölünür. -> bu yöntem, modern işlemcilerin cache yapısına
        daha uygundur ve klasik Quicksorttan çok daha hızlıdır.

         MÜLAKAT NOTLARI
         1. worst case (O(n^2)) nasıl engellersin?
         cevap: pivot seçimini rastgele yaparak(randomized quick sort) veya 'median-of-three'(ilk , orta ve son
         elemanın ortancasını pivot seçme) yöntemini kullanarak en kötü durum ihtimalini matemaitksel olarak yok
         dencek kadar azaltabilirim.

         2. quick sort stable mıdır?
         cevap: hayır değildir. swap işlemleri sırasında aynı değere sahip elemanların orijinal sırası bozulabilir.

         3. neden merge sorttan daha hızlı kabul edilir?
         cevap: çünkü merge sort gibi O(n) ekstra bellek ayırma ve kopyalama işlemi yapmaz. In-place çalışır

        4. Elimizde 1 milyon elemanlı, neredeyse tamamen sıralı (sadece 5-10 eleman yanlış yerde) bir dizi var.
        Quick Sort mu yoksa Insertion Sort mu kullanırsın?
        cevap: Insertion Sort. Çünkü Insertion Sort "adaptive" bir algoritmadır ve neredeyse sıralı dizilerde
        O(n) performans gösterir. Quick Sort ise bu durumda bile diziyi parçalara ayırmaya çalışır ve O(nlogn)
        (veya kötü pivot seçilirse daha yavaş) çalışır.

        5. Quick Sort ve Merge Sort arasındaki 'Hafıza (Space Complexity)' farkı nedir?
        cevap: Merge Sort O(n) ek alan ister (dizinin kopyasını oluşturur). Quick Sort ise "in-place" çalışır, sadece
         recursive çağrılar için stack üzerinde O(logn) yer kaplar. Bellek kısıtlıysa Quick Sort açık ara öndedir.

        6.Bir e-ticaret sitesinin (Tarladan gibi) ürün listesini sıralıyorsun. Kullanıcı önce 'Fiyata Göre' sıraladı,
        sonra 'Popülerliğe Göre' sıraladı. Aynı popülerlikteki ürünlerin fiyat sırasının bozulmamasını nasıl sağlarsın?
        cevap: Stable (Kararlı) bir algoritma kullanarak. Insertion Sort veya Merge Sort (veya Java'daki Timsort)
        kullanırsam, popülerliği aynı olan ürünlerin önceki "fiyat sıralaması" bozulmaz. Quick Sort kullanırsam bu sıra
        rastgele değişebilir.

        7. Java'nın Arrays.sort() metodunun içinde neden tek bir algoritma yok da sürekli birinden diğerine geçiyor?
        cevap: Buna "Hibrit Yaklaşım" denir. Büyük veri setlerinde O(nlogn) (Quicksort/Merge) algoritmalarının
        matematiksel üstünlüğünden yararlanılırken, veri setleri parçalanıp küçüldüğünde (örneğin n < 47),
        Insertion Sort'un düşük yönetim maliyeti ve CPU Cache dostu yapısından yararlanılır.

         */
    }

}
