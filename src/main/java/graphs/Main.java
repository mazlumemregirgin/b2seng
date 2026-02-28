package graphs;

public class Main {
    public static void main(String[] args) {

        /*
         Graph -> baya önemli birşey kesinlikle nilinmesi gerekiyor
         bunu bilmeyeni backend developer yapmıyorlarmış.

         İki ana bileşenden oluşur:
         1. vertex(node): veriyi temsil eden noktalar.
         2. Edge(kenar): nodelar arasıdnaki bağlantılar.


         Graph türleri:
         a. directed: bağlantılar tek yönlüdür. (instagramda birini takip etmek)
         b. undirected: bağlantılar karşılıklıdır.(facebookta arkadaş olmak)
         c. weighted: bağlantıların bir değeri/maliyeti vardır.(iki şehir arasındaki yolun kilomentresi)
         d. unweighted: tüm bağlantılar eşittir.

         Graphı kodda nasıl tutarız?? (Representation)
         1. Adjacency Matrix: düğümleri satır ve sütunlara dizdiğimiz 2 boyutlu bir matristir. (int[][] matrix)
            -eğer i ve j arasında bir bağ varsa matrix[i][j] = 1 olur.
            -avantaj: iki düğüm arasında bağ var mı bakmak O(1)dir
            -dezavantaj: çok fazla yer kaplar O(V^2). eğer çok az bağlantı varsa (sparse graph), matrisin çoğu sıfırla
            dolar ve bellek israf olur.

         2. Adjacency List: her düğümün, komşularını tuttuğu bir liste genelde (ArrayList<LinkedList>) vardır.
            -avantaj: sadece var olan bağlantıları tuttuğu için bellek dostudur.
            -dezavantaj: iki düğümün komşu olup olmadığnı anlamak için listeyi taraman gerekir. O(Degree)


         ilginç bir şekilde Java'da built-in Graph classı yok. ArrayList var, HashMap var TreeSet var ama bir graph yok.
         çünkü graphın binlerce farklı varyasyonu vardır. java bu yüzden hiç bulaşmamıştır grapha
         Ama sektörde bu iş için profesyonel kütüphaneler kullanılır:
         1. JGraphT
         2. Google Guava
         3. Apache Commons Graph



         MÜLAKAT NOTLARI
         1. LinkedInde 2.dereceden bağlantı özelliğini nasıl kodlarsın?
         cevap: bu bir dfs sorusudur. çünkü bfs bir düğümden başlayarak katman katman ilerler. 1. katman doğrudan
         arkadaşlıklardır, 2. katman ise onların arkadaşlarıdır.

         2. Bir para transferi sistemi düşün. A, B'ye; B, C'ye; C de tekrar A'ya para gönderiyor. bu bir kara para
         aklama döngüsü olabilir. bunu kodda nasıl tespit edersin?
         cevap: bu bir directed graphtır. dfs kullanarak gezerim. eğer gezdiğim bir kolda, henüz işlemi bitmemiş bir
         düğüme tekrar rastlarsam, orada bir cycle vardır.

         3. üniversitede ders seçiyorsun. bazı dersleri alabilmek için önce diğerlerini (ön koşul) bitirmen lazım.
         hangi sırayla ders çalışman gerektiğini bulan bir algoritma yaz.
         cevap: bu topological sort sorusudur. sadece directed acyclic graph yapılarında çalışır. okların yönüne göre
         önce yapılması gerekeni başa koyan bir sıralama üretir.

         4. neden adjacency list??
         cevap: çünkü gerçek dünya verileri genellikle sparse(seyrek) yapıdadır. herkes herkesle arkadaş değildir.
         belleği boşuna harcamamak için list kullanmalıyız

























         */
    }
}
