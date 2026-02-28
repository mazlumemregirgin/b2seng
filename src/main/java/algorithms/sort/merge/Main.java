package algorithms.sort.merge;

public class Main {
    public static void main(String[] args) {

        /*
        merge sort: recursively divide array in 2, sort, re-combine

        mantığı:
        1. divide: diziyi tam ortasında iki böler
        2. conquer: her bir parçayı kendi içinde tekrar böler (with recursion).
        taki elinde tek bir eleman kalana kadar.
        3. merge: elde ettiğimiz sıralı küçük parçaları, birbiriyle karşılaştırarak tek bir sıralı dizi
        oluşturacak şiekilde birleştirir.

        big O complexity -> O(nlogn)
        space complexity -> O(n) -> birleştirme yaparken geçici diziler oluşturduğumuz için ekstradan
        orijinal dizi kadar yer kaplar.


        Gerçek hayatta nerede kullanılır?
        1. nesne sıralama: merge sort stable'dır. yani aynı değere sahip elemanların sırasını bozmaz.
        2. big data: eğer veri seti RAM'e sığmayacak kadar büyükse, merge sort veriyi parça parça
        diskten okuyup sıralayabilen tek mantıklı algoritmadır.


        Sektörde Merge Sort'un seçilme sebebi genellikle hız değil stabilitydir.
        A. diyelim ki "tarladan" projesinde ürünleri önce fiyata göre sıraladın. sonra kullanıcı aynı listeyi
        tarihe göre de sıralamak istedi.
        merge sort-> aynı tarihteki ürünlerin fiyat sırasını bozmaz.
        quicksort-< aynı tarihteki ürünlerin kendi içindeki fiyat sırasını karıştırabilir.


        Gerçek hayat logic örneği (java servis katmanı)
        Diyelim ki bir bankanın "Hesap Hareketleri" servisini yazıyorsun. Farklı mikroservislerden
        (Kredi Kartı servisi, Mevduat servisi, Yatırım servisi) gelen sıralı verileri tek bir listede birleştirip
        kullanıcıya sunman gerekiyor.

        // Üç farklı servisten gelen veriler zaten kendi içinde sıralı
        List<Transaction> creditCardOps = getCreditCardOps(); // Sıralı
        List<Transaction> bankAccountOps = getBankAccountOps(); // Sıralı

        // Bu iki listeyi birleştirip tek bir sıralı liste yapmak tam bir MERGE işlemidir.
        // Java'da Collections.sort() kullanarak bunu O(n log n) ile yaparsın.
        List<Transaction> allOps = new ArrayList<>(creditCardOps);
        allOps.addAll(bankAccountOps);
        Collections.sort(allOps); // İşte burada Merge Sort (Timsort) devreye girer.


        Eğer primitive(int[], double[], char[]) tiplerden oluşan diziler varsa:
        dizi çok küçükse(n<47): insertion sort kullanılır.
        dizi çok büyükse(n>=47): dual-pivot quicksort kullanılır.

        Eğer Nesne(Integer[], String[], User[]) tiplerinden oluşan bir dizi varsa:
        Java burada stability ve güvenliğe odaklanır.
        DİZİ BOYUTU NE OLURSA OLSUN TİMSORT KULLANILIR
        timsort = merge sort + insertion sort


        MÜLAKAT NOTLARI:
        1. mergesortun en büyük zayıflığı nedir?
        cevap: hafıza kullanımı. O(n) yer kaplaması, bellek kısıtı olan sistemlerde dezavantajdır.



         */
    }
}
