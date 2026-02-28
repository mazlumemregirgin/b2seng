package hashTable;

import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {


        /*
        İNANILMAZ BİRŞEYMİŞ

        hash table: a data structure taht stores unique keys to values örneğin <Integer, String>
        each key/value pair is known as an Entry
        Fast insertion, look up, deletion of key/value pairs.
        not ideal for small data sets, great with large data sets.

        Hashing Mekanizması
        1. key: örneğin bir string: "mazlum"
        2. Hash Function: bu stringi alır ve matematiksel bir işlemden geçirerek bir sayıya (hash code) dönüştürür.
        3. bu sayı, dizinin(bucket) hangi indexine yerleşeceğini belirler
        key.hashCode() % capacity = index capacity hash tableın kapasitesi
        4. value: veri, o indeksteki kutucuğa(bucket) konulur.

        collision: hash function generates the same index for more than one key
        dünyadaki tüm kayler benzersiz olsa da, bazen farklı iki anahtar aynı indeksi üretebilir.
        less collisions = more efficiency
        Çözüm yöntemleri
        1. chaining: o indekse bir LinkedList koyulur. aynı yere düşenler birbirine bağlanır. (java bunu yapıyo)
        2. open addressing: eğer o indeks doluysa, bir sonraki boş kutucuk aranır.

        Big o complexity -> O(n) -> insert, search, delete
        best case -> O(1)




         */

        Hashtable<Integer, String> table = new Hashtable<>(10);
        HashMap<String, String> table2 = new HashMap<>(10);

        table2.put("a", "a");

        System.out.println(table2);

        table.put(100, "Spongebob");// -> eleman eklemek için .put(key, value) kullanmalıyım
        table.put(123, "Patrick");
        table.put(321, "Sandy");
        table.put(555, "Squidward");
        table.put(777, "gary");

        table.remove(777); // -> eleman silmek için .remove(key) kullanmalıyım.

        System.out.println(table.get(123)); // içinde ilgili keyin valuesunu öğrenme istersem .get(key) kullanmalıyım.

        for (Integer key : table.keySet()) {
            System.out.println(key.hashCode() + " "+ key + " "+ table.get(key)); // integerların key ve hashcodeları
                                                                                // aynı olur
        }

        /*
        gerçek hayat senaryosu
        Tarladan projesinde elimde 1 milyon ürün var ve her ürünün benzersiz bir barkodNo'su var.
        kullanıcı kasada barkodu okuttuğunda ürün ismini ve fiyatını saniyelerce beklemek istemez.
        barkodu Key, Ürün nesnesini Value yaparak bir Hash yapısında tutarsan, 1 milyon ürün arasından o ürünü
        nanosaniyeler içinde bulabilirim.


        MÜLAKAT NOTLARI:
        1. Hash Collision nedir ve nasıl çözülür?
        cevap: farklı iki key'in aynı hash kodunu üretip aynı indekse düşmesidir.
        çözüm için chaining veya open addresing kullanılır.

        2. hashCode() ve equlas() metotları arasındaki ilişki nedir?
        cevap: eğer iki nesne equal() ise, hashCode() değerleri mutlaka aynı olmalıdır. Ancak iki nesnenin hashCode()
        değeri aynıysa, bu nesneler equals() olmak zorunda değildir.(collision)

        3. load factor ve rehashing nedir?
        cevap: hashmapin doluluk oranıdır (varsayılan 0.75). eğer tablo %75 oranında dolarsa, java tablonun boyutunu
        iki katına çıkarır ve tüm elemanları yeni yerlerine tekrar yerleştirir buna da rehashing denir.

        4. Java 8'de HashMap'te yapılan 'treeify' değişikliği nedir?
        cevap: eskiden bir indekste çok fazla collision olursa orası uzun bir linkedliste dönüşüyor ve arama hızı O(n)
        oluyordu. java8 ile birlikte, bir indeksteki eleman sayısı belli bir eşiği (8) geçerse, java o linkedlisti
        otomatik olarak bir self-balancing binary search tree(red-black tree) yapısına dönüştürür.
        böylece en kötü ihtimalle bile hızı O(logn) olur.

        5. Null kabulu açısından HashMap mi daha iyi yoksa HashTable mı?
        cevap: hash table kesinlikle null kabul etmez. ne key ne de value null olamaz. eğer put(null, "mazlum") dersen
        NullPointerException fırlatır ve uygulama patlar
        HashMap bir tane null key ve istediğin kadar null value kabul eder. Fintech sistemlerinde bazen "atanmamış"
        değerler için bu esneklik hayat kurtarır.

        hashmap indeks hesaplama noktasında modulo yerine bitwise bit manipulation yapar bu yüzden donanım seviyesinde
        daha hızlıdır.
         */

    }
}
