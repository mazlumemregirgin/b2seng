package algorithms.sort.selection;

public class Main {
    public static void main(String[] args) {

        /*
        Selection Sort -> yine inanılmaz verimsiz kötü bir sıralama algoritması
        bu verimsiziliği yüzünden java bile ciddiye alıp built in method oluşturmamış

        Seçmeli sıralama diyebiliriz.
        her iterationda en küçüğü buluyor ve listenin en başına atıyor. sonrasında diğer
        elemanlarla iterationa devam ediyor.


        Selection Sort Mantığı
        Bu algoritma diziyi zihinsel olarak ikiye böler: şıralanmış kısım ve sıralanmamış kısım.

        1. dizinin sıralanmamış kısmını baştan sona tara.
        2. içindeki en küçük elemanı bul
        3. bu en küçük elemanı, sıralanmamış kısmın en başındaki elemanla takas et
        4. artık o eleman sıralanmış kısmın bir parçası oldu
        5. geri kalan dizi için aynı işlemi tekrarla.

        complexity -> O(n^2) -> berbat ötesi. kaç uzaklaş asla kullanma gerek yok

         */

        int[] array = {9,1,3,6,2,8,5,4,7};
        selectionSort(array);

        for(int i=0;i<array.length;i++){
            System.out.print(i);
        }

    }

    public static void selectionSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    /*
    MÜLAKAT NOTLARI:

    1. buble sort ile farkı nedir?
    Cevap: bubble sort her turda birçok kez sqap yapabilir. selection sort ise her turda sadece bir kez
    en küçüğü bulduktan sonra swap yapar. bu yüzden yazma maliyeti daha düşüktür.

    2. Dizi zaten sıralıysa selection sort kaç işlem yapar?
    Cevap: yine O(n^2) işlem yapar. "best case" performansı bile kötüdür çünkü optimizasyon mekanizması yoktur;
    her seferinde tüm elemanları kontrol eder.

    3. eğer bir sistemde veriyi okumak ucuz ama belleğe yazmak çok maliteyliyse neden selection sortu tercih edebilirsin
    Cevap: cünkü selection sort, tüm O(n^2) algoritmaları araasında minimum sayıda swap yapan algoritmadır.

    4. selection sortu biraz daha hızlandırmak için her turda hem en küçüğü hem de en büyüğü bulup uçlara yerleştirsek
    karmaşıklık değişir mi?
    Cevap: işlem sayısı yarıya iner ancak Big O perspektifinden bakıldığında karmaşıklık hala O(n^2) olur.

    5. bubble sort mu selection sort mu?
    Cevap: genellikle selection sort. çünkü swap sayısı cok daha azdır.

     */
}
