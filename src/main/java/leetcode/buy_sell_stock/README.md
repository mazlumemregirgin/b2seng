# 121. Best Time to Buy and Sell Stock

## Soru Tanımı (Problem Statement)

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`th day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

**Example 1:**
```
Input:  prices = [7, 1, 5, 3, 6, 4]
Output: 5
Explanation: Buy on day 2 (price = 1), sell on day 5 (price = 6). Profit = 6 - 1 = 5.
```

**Example 2:**
```
Input:  prices = [7, 6, 4, 3, 1]
Output: 0
Explanation: No transaction is done. Prices only go down.
```

**Constraints:**
- `1 <= prices.length <= 10⁵`
- `0 <= prices[i] <= 10⁴`

---

## Çözüm Süreci

### 1. İlk Deneme: Java Stream ile Built-in Fonksiyonlar

İlk aklıma gelen yaklaşım, `IntStream` kullanarak dizinin minimum ve maksimum değerlerini bulmaktı. Hem daha "modern" hem de daha kısa görünüyordu.

```java
int min = Arrays.stream(prices).min().getAsInt();
int max = Arrays.stream(prices).max().getAsInt();
return max - min; // Bu yaklaşım zaten temelden yanlış!
```

Bu yaklaşım hem pratik hem de mantıksal açıdan hatalıydı:

- Stream API ile index bilgisine ulaşmak doğrudan mümkün değil; hangi günde min, hangi günde max olduğunu bilmeden "önce al, sonra sat" kuralını kontrol edemiyordum.
- Daha da önemlisi, "global min ve global max = en yüksek kar" varsayımı başlı başına yanlış. Bu yüzden bu yaklaşımı bıraktım.

---

### 2. İkinci Deneme: For Loop ile Global Min & Max (Yanlış Çözüm)

Stream yerine iki ayrı `for` loop kurdum. İlkiyle dizinin global minimumunu ve indeksini, ikincisiyle global maksimumunu ve indeksini buldum.

```java
int min = prices[0], indexOfMin = 0;
for (int i = 1; i < prices.length; i++) {
    if (prices[i] < min) { min = prices[i]; indexOfMin = i; }
}

int max = prices[0], indexOfMax = 0;
for (int i = 1; i < prices.length; i++) {
    if (prices[i] > max) { max = prices[i]; indexOfMax = i; }
}

if (indexOfMin < indexOfMax) return max - min;
else return 0;
```

Bazı test case'leri geçti, bazıları geçmedi. Kodu debug edince şunu fark ettim:

#### 🐛 Neden Yanlış?

Bu yaklaşımın temel varsayımı şu: "En düşük fiyat ve en yüksek fiyat arasındaki fark, her zaman en karlı işlemi verir."

Bu varsayım **yanlış**. İki kritik senaryo bunu çürütüyor:

**Senaryo A — Global min, global max'tan SONRA geliyor:**
```
prices = [2, 10, 1, 3]
Global min = 1 (index 2)
Global max = 10 (index 1)
indexOfMin (2) > indexOfMax (1) → kod 0 döndürür ❌
Gerçek cevap: 2'den alıp 10'a satmak = 8 kar ✅
```

**Senaryo B — Min doğru yerde ama aralarında daha karlı başka bir çift var:**
```
prices = [10, 1, 5, 3, 2]
Global min = 1 (index 1), Global max = 10 (index 0)
indexOfMin (1) > indexOfMax (0) → kod 0 döndürür ❌
Gerçek cevap: 1'den alıp 5'e satmak = 4 kar ✅
```

**Temel Yanılgı:** Kodumuz "tüm dizideki en ucuz gün" ile "tüm dizideki en pahalı gün"ü buluyordu. Oysa soru şunu istiyor: "En ucuz alış gününden **sonra** gelen en pahalı satış günü."

---

### 3. Doğru Çözüm: Greedy / Tek Geçişli Dinamik Programlama

Hatamı anladıktan sonra sorunu yeniden çerçeveledim:

> Her gün için şunu sormalıyım: "Bugüne kadar gördüğüm en ucuz fiyattan alıp **bugün** satsaydım ne kazanırdım?"

Bu soruyu her gün sormak için iki şeyi takip etmem yeterli:

1. `minPrice` → Şimdiye kadar gördüğüm en düşük fiyat *(potansiyel alış günüm)*
2. `maxProfit` → Şimdiye kadar hesapladığım en yüksek kar *(rekorumu tutuyorum)*

```java
int minPrice = Integer.MAX_VALUE;
int maxProfit = 0;

for (int i = 0; i < prices.length; i++) {
    if (prices[i] < minPrice) {
        minPrice = prices[i];             // Yeni alış noktası buldum.
    } else if (prices[i] - minPrice > maxProfit) {
        maxProfit = prices[i] - minPrice; // Yeni kar rekoru kırdım.
    }
}
return maxProfit;
```

#### Neden İşe Yarıyor?

Diziyi soldan sağa gezerken, her satış anında elimdeki `minPrice` her zaman o güne kadarki **en ucuz alış fiyatını** tutuyor. Yani "geriye dönüp daha iyi bir alış noktası var mıydı?" diye bakmama gerek yok — `minPrice` bunu zaten canlı takip ediyor.

Bu yaklaşım aynı zamanda bir **Greedy** (açgözlü) strateji: her adımda elimizdeki en iyi bilgiyle (o ana kadar gördüğüm en düşük fiyat) en iyi kararı veriyoruz.

---

## Karmaşıklık Analizi

| Yaklaşım | Zaman | Alan | Doğru mu? |
|---|---|---|---|
| Global Min-Max (Yanlış) | O(n) | O(1) | ❌ |
| Greedy / Tek Geçiş (Doğru) | O(n) | O(1) | ✅ |

Her iki yaklaşım da O(n) zaman ve O(1) alan kullanıyor. Fark, **neyi takip ettiğimizde**: global min/max yerine "şimdiye kadarki min"i takip etmek her şeyi değiştiriyor.

---

## Neler Öğrendim? (Takeaways)

- "En küçük ve en büyük eleman = en yüksek kar" sezgisi, **sıra önemli olduğunda** yanlış olabilir. Bu soru tam da bu tuzağı test ediyor.
- Diziler üzerindeki optimizasyon problemlerinde çoğu zaman iki ayrı pass yerine tek bir pass yeterli. Tek geçişte hem minimum alış fiyatını hem de maksimum karı güncellemek mümkün.
- `Integer.MAX_VALUE` ile başlamak, ilk elemanı özel casing yapmaktan kurtarır ve kodun genelliğini artırır.
- Greedy yaklaşımlar her problemde işe yaramaz, ama "o ana kadar gördüğüm en iyi değeri tut ve ilerle" mantığı bu problemde mükemmel oturuyor.