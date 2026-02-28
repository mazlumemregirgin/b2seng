package algorithms.search.interpolation;

public class Main {
    public static void main(String[] args) {

        /*
        binary searchün upgrade edilmiş hali diyebiliriz. binary search her adımda hep en ortadaki elemana bakar
        bu algoritmada ise orta nokta, aranan değerin büyüklüğüne göre oran orantı ile hesaplanır.

        Şartlar:
        1. veri kümesi sorted olmalıdır.
        2. veri kümesi uniformly distributed olmalıdır. yani sayılar düzgün artmalı outlierlar
        düzensiz artışlar olmamalıdır [1,2,1000,10000000] gibi olmamamlı

        javada built-in interpolation search classı yoktur çünkü sadece çok spesifik caseler için kullanılır.
        çoğunlukla binary search daha güvenli sonuç verir.

        complexity -> O(log(logn)) binary searchten daha hızlı


        MÜLAKAT NOTLARI:

        1. binary search varken neden interpolation search kullanalım?
        Cevap: eğer veri düzgün dağılımlı ise binary searchun O(logn) süresini O(log(logn))'e indirir.
        bu devasa veri setlerinde ciddi bir performans artışı sağlar.

        2. interpolation search neden her zaman binary search yerine kullanılamıyor?
        Cevap: Hesaplama maliyeti -> interpolationda çok fazla işlem var
        Güvenilmezlik -> veri dağılımı uniformly distributed değilse algoritma O(n)'e düşer. binary search ise her zaman
        O(logn) garantisi verir.
         */
    }
}
