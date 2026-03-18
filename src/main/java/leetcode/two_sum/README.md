# 1. Two Sum

## Soru Tanımı (Problem Statement)
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

**Example 1:**

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

**Example 2:**

Input: nums = [3,2,4], target = 6
Output: [1,2]

**Example 3:**

Input: nums = [3,3], target = 6
Output: [0,1]

**Constraints:**

- 2 <= nums.length <= 10⁴
- -10⁹ <= nums[i] <= 10⁹
- -10⁹ <= target <= 10⁹
- Only one valid answer exists.

**Follow-up:** Can you come up with an algorithm that is less than O(n²) time complexity?

---

## Çözüm Yaklaşımları

### 1. Brute Force (ilk akla gelen bu çözümdü)
- **Mantık:** İçi içe iki döngü (nested loop) kurarak her sayıyı ve ondan sonraki sayıları toplarız. Toplamı hedefe eşit olanı bulduğumuzda döneriz.
- **Zaman Karmaşıklığı (Time Complexity):** O(n²) - Her eleman için geri kalanları kontrol ediyoruz.
- **Alan Karmaşıklığı (Space Complexity):** O(1) - Ekstra bir veri yapısı kullanmadık.

### 2. İyileştirilmiş Çözüm (Optimizasyon - HashMap)
- **Mantık:** Diziyi bir kez gezerken, her elemanın hedefe ulaşması için gereken değeri (target - num) bir HashMap'te ararız. Yoksa sayının kendisini HashMap'e indeksiye ekleriz.
- **Zaman Karmaşıklığı (Time Complexity):** O(n) - Sadece bir kez diziyi dönüyoruz. HashMap'te arama (look-up) ortalama O(1)'dir.
- **Alan Karmaşıklığı (Space Complexity):** O(n) - En kötü durumda (worst-case) tüm elemanları HashMap'e kaydetmemiz gerekir.

---

## Neler Öğrendim? 
- Çözüm esnasında diziyi iki kere dönmek yerine `HashMap` kullanarak zaman boyutunu ciddi manada kısalttığımı fark ettim...

---

## Teorik Hız vs. Pratik Performans

LeetCode üzerinde $O(n)$ çözüm her zaman "en iyisi" gibi görünse de, yaptığım yerel testlerde küçük veri setlerinde durumun farklı olduğunu gözlemledim.

### 📊 Yerel Test Sonuçları (Küçük Veri Seti - n=9)

Aşağıdaki metrikler, `{2, 7, 11, 15, 18, 20, 25, 30, 40}` dizisi ve `target = 65` için alınmıştır:

| Metrik | Brute Force O(n²) | HashMap Optimized O(n) |
|---|---|---|
| Süre (ns) | 23,600 ns | 109,700 ns |
| Bellek Artışı | 0 bytes | 0 bytes (ölçek altı) |
| Kazanan | 🏆 Brute Force | - |

---

### 🧐 Neden $O(n)$ Daha Yavaş Çıktı? (HashMap Kısıtları)

Her zaman $O(n) < O(n^2)$ olduğu varsayımı, veri boyutu sonsuza giderken geçerlidir. Küçük verilerde (n < 50-100) durum değişebilir:

1. **Kurulum Maliyeti (Overhead):** Brute force sadece iki `int` karşılaştırması yaparken; HashMap bir nesne oluşturur, `hashCode` hesaplar ve karmaşık bir veri yapısını yönetir. Küçük veride bu "yönetim maliyeti", asıl işten daha uzun sürer.

2. **Bellek Yakınlığı (Cache Locality):** İşlemciler, diziler gibi bellekte yan yana duran verilere çok hızlı erişir. HashMap'te ise veriler belleğin farklı yerlerine dağılabilir, bu da işlemci önbelleğinin (L1/L2 Cache) verimini düşürür.

3. **Hashing İşlemi:** Bir sayının Map'teki yerini bulmak için yapılan matematiksel hesaplama, basit bir `if` kontrolünden daha maliyetlidir.

---

### 💡 Çıkarım 

- **Küçük Veri Setleri:** Basitlik (Brute Force) genellikle daha hızlıdır. "Daha zekice" olan çözüm, ek yükü nedeniyle daha hantal kalabilir.
- **Büyük Veri Setleri (n > 1000):** İşte burada HashMap farkını ortaya koyar. Veri büyüdükçe $O(n^2)$'deki üstel artış, HashMap'in sabit maliyetini ezip geçer.