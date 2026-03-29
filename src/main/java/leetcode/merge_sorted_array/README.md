# 88. Merge Sorted Array

## Soru Tanımı (Problem Statement)

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing order**, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

Merge `nums1` and `nums2` into a single array sorted in non-decreasing order.

The final sorted array should **not be returned** by the function, but instead be stored inside the array `nums1`. To accommodate this, `nums1` has a length of `m + n`, where the first `m` elements denote the elements that should be merged, and the last `n` elements are set to `0` and should be **ignored**. `nums2` has a length of `n`.

**Example 1:**
```
Input:  nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
```

**Example 2:**
```
Input:  nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
```

**Example 3:**
```
Input:  nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
```

**Constraints:**
- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `1 <= m + n <= 200`
- `-10⁹ <= nums1[i], nums2[j] <= 10⁹`

**Follow-up:** Can you come up with an algorithm that runs in `O(m + n)` time?

---

## Çözüm Süreci

### 1. İlk Akla Gelen: LinkedList

İki sıralı diziyi birleştirirken ilk aklıma LinkedList geldi. Mantığım şuydu: doğru pozisyona `add(index, value)` ile eleman yerleştiririm, bu da O(1)'de olur.

Ama hemen bir sorun fark ettim: `add(index, value)` metodunun kendisi O(1) olsa da, o **index'e ulaşmak** O(n) zaman alır. LinkedList'te rastgele erişim yoktur, baştan sona gezmen gerekir. Bu yüzden her ekleme işlemi için O(n) harcarsam toplamda **O(n²)** olur. Brute force'tan farklı değil. Bu fikri bıraktım.

---

### 2. İkinci Düşünce: Önden Birleştirme (Neden Çalışmaz?)

"While döngüsüyle i ve j pointer'larını soldan sağa gezdiririm, küçük olanı nums1'e yazarım" diye düşündüm. Ama burada kritik bir sorun var:

nums1'e yazmaya çalışırken **henüz işlemediğim elemanların üzerine yazarım**. Örneğin `nums1 = [1,2,3,0,0,0]` dizisinde, nums2'den bir eleman yerleştirdiğimde nums1'in gerçek elemanlarından birini kaybedebilirim. Bu yaklaşım ekstra bir yedek dizi gerektirirdi, bu da O(m+n) ekstra alan demek.

---

### 3. Doğru Çözüm: Sondan Başa 3 Pointer

Asıl çözüm fikri şu sorudan geldi: "Önden yazınca çakışıyor, peki sondan yazsam?"

nums1'in sonunda zaten `n` tane boş slot var. En büyük elemanı en sona yazmaya başlarsam, daha önce işlemediğim elemanların **hiçbirinin üzerine yazmam**. Çakışma tamamen ortadan kalkar.

```
nums1 = [1, 2, 3, 0, 0, 0]   m = 3
nums2 = [2, 5, 6]             n = 3
              ↑               ↑
              i=2             j=2    k=5
```

Her adımda `nums1[i]` ile `nums2[j]`'yi karşılaştır, büyük olanı `nums1[k]`'ya yaz:

```
Adım 1: nums1[2]=3 vs nums2[2]=6  → 6 büyük → nums1[5]=6, j--, k--
Adım 2: nums1[2]=3 vs nums2[1]=5  → 5 büyük → nums1[4]=5, j--, k--
Adım 3: nums1[2]=3 vs nums2[0]=2  → 3 büyük → nums1[3]=3, i--, k--
Adım 4: nums1[1]=2 vs nums2[0]=2  → eşit, nums2'yi yaz → nums1[2]=2, j--, k--
Adım 5: j < 0 → döngü biter. nums1[0] ve nums1[1] zaten yerinde.

Sonuç: [1, 2, 2, 3, 5, 6] ✅
```

#### Döngü Koşulu: Neden Sadece `j >= 0`?

While koşulunun `j >= 0` olması, yani sadece nums2'yi kontrol etmesi önemli bir detay. İki durum var:

- **nums2 biter, nums1'de eleman kalır:** nums1'in kalan elemanları zaten doğru yerde ve sıralı. Hiçbir şey yapmaya gerek yok.
- **nums1 biter, nums2'de eleman kalır:** `i >= 0` koşulu `false` olur, `else` branch'ı çalışır ve nums2'nin kalan elemanları başa kopyalanır.

```java
int i = m - 1;
int j = n - 1;
int k = m + n - 1;

while (j >= 0) {
    if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[k] = nums1[i];
        i--;
    } else {
        nums1[k] = nums2[j];
        j--;
    }
    k--;
}
```

---

## Karmaşıklık Analizi

| Yaklaşım | Zaman | Alan |
|---|---|---|
| LinkedList ile ekleme | O(n²) | O(1) |
| Önden birleştirme (ekstra dizi) | O(m + n) | O(m + n) |
| Sondan başa 3 pointer | O(m + n) | O(1) |

Sondan başa yaklaşım hem zaman hem de alan açısından optimal: her eleman tam bir kez işleniyor ve ekstra dizi kullanmıyoruz.

---

## Neler Öğrendim? (Takeaways)

- LinkedList'te `add(index, value)` O(1) gibi görünse de index'e erişim O(n)'dir. Bir veri yapısının bir metodunun karmaşıklığı, o metodu kullanmanın **toplam** maliyetini vermez. Her katmanı ayrı düşünmek gerekiyor.
- "Önden yazınca çakışıyorsa, sondan yaz." Bu basit fikir döngü içindeki çakışma sorununu tamamen çözdü ve ekstra alan ihtiyacını ortadan kaldırdı. In-place problemlerde yön seçimi kritik olabiliyor.
- İki pointer yetmez mi diye düşünebilirsin, ama üçüncü pointer (`k`) yazma pozisyonunu takip ettiği için olmadan çözemezdik. Her pointer'ın net bir sorumluluğu var: `i` okuma (nums1), `j` okuma (nums2), `k` yazma.
- Döngü koşulunun `j >= 0` olması tesadüf değil: nums1'de kalan elemanlar zaten yerinde ve sıralı, onları taşımaya gerek yok. nums2 kalırsa mutlaka işlenmeli.