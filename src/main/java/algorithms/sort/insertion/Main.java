package algorithms.sort.insertion;

public class Main {
    public static void main(String[] args) {

        /*
        insertion sort: yine berbat bir sıralama algortiması ama bazı yönleriyle diğerleri kadar kötü olmayabiliyor
        after comparing elemnts to the left, shift elemnts to the right to make room to insert a value.


        Adımlar:
        1. ikinci elemandan başla
        2. mevcut elemanı bir temp olarak eline al
        3. solundaki elemanlarla karşılaştır.
        4. eğer solundaki eleman tempten büyükse, o elemanı bir sağa kaydır.
        5. tempin sığaacğı boşluğa tempi yerleştir.

        big o complexity -> O(n^2) - çok kötü ama küçük verisetlerinde hayat kurtarır.

        javada kullanılan Arrays.Sort() algoritması 47 elemana kadar insertion sort kullanıyor.
        daha büyük verisetlerinde ise dual-pivot quicksort algoritması kullanıyor.

        best case is O(n) compared to selection sort O(n^2)

        neredeyse sıralı verilerde Şampiyon -> O(n)
        küçük verilerde ise en hızlısı.
         */

        int[] myArray = {3,5,2,7,4,8,1,9,6,0};

        insertionSort(myArray);

        for(int i: myArray){
            System.out.print(i + " ");
        }

    }

    private static void insertionSort(int[] myArray) {
        for (int i = 1; i < myArray.length; i++) {
            int temp = myArray[i];
            int j = i - 1;

            while (j >= 0 && myArray[j] > temp) {
                myArray[j + 1] = myArray[j];
                j--;
            }
            myArray[j+1]=temp;
        }}
}

/*
       MÜLAKAT NOTLARI:
    1. neden selection sort yerine insertion sort tercih edilmeli?
    cevap: çümkü inertion sort adaptif bir algoritmadır. dizi biraz bile sıralı olsa O(n^2)den çok daha hızlı çalışır..
    ama selection sort dizi ne olursa olsun O(n^2)

    2. Online Algorithm nedir?
    cevap: veriler parça parça gelirken sıralama yapabilen algoritmalardır. insertion osrt mükemmel
    bir online algoritmadır. yeni bir veri geldiğinde tüm diziyi tekrar sıralamak yerine onu sadece ait olduğu
    yere insert eder.

    3. Neden daha verimliisi varken küçük diziler için insertion sort kullanılıyor?
    cevap: çünkü O(n^2) ve O(nlogn) arasındaki fark sonsuza giderken anlamlıdır. n=10 gibi
    küçük sayılarda, insertion sortun basitliğii merge sortun karmaşıklığını hız olarak geçer

    4. Madem O(n^2) bu kadar kötü, neden java hala kütüphanesinde bunu tutuyor?
    cevap: cümkü insertion sort adaptive bir algoritmadır. veri setinin sıralı olup olmamasına göre hızlanır.
    ayrıca küçük verisetlerinde overhead en düşük olan algoritmadır.

    5. neden quick sort teorik olarak daha hızlı olmasına rağmen, küçük verisetlerinde insertion sort bazen
    daha hızlı sonuç verir?
    cevap: Bunun sebebi 'Locality of Reference' (Referans Yerelliği) ve CPU Cache mekanizmasıdır.
    Insertion Sort, verileri bellekte yan yana (sequential) okur ve yazar. Modern işlemciler, yan yana duran
    verilere erişirken 'Cache Hit' oranını artırır. Quick Sort ise 'Recursion' kullandığı için sürekli farklı
    bellek adreslerine zıplar (Stack Frame oluşturur). Küçük n değerlerinde, Insertion Sort'un bu donanım dostu
    yapısı, Quick Sort'un algoritmik üstünlüğünü geçer

 */
