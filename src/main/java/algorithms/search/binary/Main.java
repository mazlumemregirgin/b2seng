package algorithms.search.binary;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        /* binary search, sıralı bir veri kümesinde, aranan elemanı bulmak iin her adımda arama alanını ikiye bölen
           divide and conquer algoritmasıdır.

           ÇALIŞMA MANTIĞI
           1. listenin tam ortasındaki elemana bakılır.
           2. aranan sayı ortadaki sayıya eşitse, işlem biter.
           3. aranan sayı ortadakinde küçükse, listenin sol yarısına odaklanılır.(sağ taraf çöpe atılır)
           4. aranan sayı ortadakinden büyüksei listenin sağ yarısına odaklanılır. (sol taraf çöpe atılır.)
           5. bu işlem arama alanı tükenen veya eleman bulunana kadar tekrarlanır.

           VERİ KÜMESİ MUTLAKA SORTED OLMALI!!

           Complexity -> O(logn)
           örnek: 1 milyon elemanlı bir listede linear search en kötü ihtimalle 1.000.000 işlem yaparken,
           binary search sadece 20 işlemde sonucu bulur.
        */

        int[] numbers = {1,2,3,4,5,6,7,8,9};

        // javada built-in binarySearch algoritması vardır.
        int index = Arrays.binarySearch(numbers, 9);

        if (index >= 0) {
            System.out.println(index);
        }

        int myIndex = myBinarySearch(numbers, 9);
        System.out.println(myIndex);


    }
    public static int myBinarySearch(int[] numbers, int key) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == numbers[mid]) {
                return mid;
            } else if (key < numbers[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /*
    Gerçek hayat senaryosu: bir şirkette nerede kullanılır?

    Şirketlerde binary search genellikle statik veya az değişen devasa veri setleri üzerinde çok hızlı sorgulama
    için kullanılır.

    Örnek Senaryo: diyelimki bir e ticaret siten var ve "ülke kodları" ile "kargo ücretleri"ni tutan bir tablon var.
    bu veriler çok nadir değişir ve hafızada tutulur.
    Burada linear search yapmak yerine binarysearch yapmak daha mantıklı O(n) -> O(logn)

    public static int customBinarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}
     */



    /*
    MÜLAKAT NOTLARI

    1. binary search'ün en büyük kısıtı nedir?
    Cevap: verinin mutlaka sıralı olması gerekir.

    2. Neden orta noktayı (low+high)/2 şeklinde hesaplamıyoruz?
    Cevap: eğer low ve high çok büyük sayılarsa, toplamları Integer.MAX_VALUE değerini aşabilir
    ve "Integer Overflow" hatasına neden olur. low + (high-low)/2 daha güvenlidir.

    3. dizi boyutu iki katına çıktığında, Binary Search'ün adım sayısı nasıl değişir?
    Cevap: binary search O(log 2 tabanında n ) olduğun için dizi boyutu iki katına çıkarsa adım sayısı sadece 1 artar.

    4. ne zaman binary ne zaman linear?
    Cevap: aranan eleman dizinin en başında ise linear daha mantıklı
    veri seti çok küçükse linear

    5. neden binary search'ü linkedlist üzerinde kullanmıyoruz?
    Cevap: çünkü binary search'Ün temeli random access üzerine kuruludur. ortadaki elemana O(1) sürede zıplamak gerekiyor
    ama linkedlistte ortadaki elemana gitmek için baştan başlayıp tek tek saymak gerekir. O(n). bu da tüm algoritmanın
    hızını O(n) e düşürür

    6. veri şeti sürekli güncelleniyorsa binary search mantıklı mıdır?
    Cevap: hayır. çünkü her eklemede sıralamayı sorted tutmak gerekir. ve bu çok maliyetlidir

    7. eğer aradığımız eleman dizide birden fazla kez geçiyorsa, binary search bize hangisini verir?
    Cevap: herhangi birini verir. biz ama mesela first occurenceı istiyorsak midi bulduktan sonrasında yine nolur nolmaz
    ilk veya sonu occurence istediğine göre listeyi o yünde daraltıp acaba bulunan midden daha önce veya sonra bir kere
    daha var mı diye bakmalıyız



     */
}