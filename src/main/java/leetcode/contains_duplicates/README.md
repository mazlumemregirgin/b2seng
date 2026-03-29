# 217. Contains Duplicate

## Soru Tanımı (Problem Statement)

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is distinct.

**Example 1:**
```
Input:  nums = [1, 2, 3, 1]
Output: true
Explanation: 1 değeri 0. ve 3. indexlerde geçiyor.
```

**Example 2:**
```
Input:  nums = [1, 2, 3, 4]
Output: false
Explanation: Tüm elemanlar farklı.
```

**Example 3:**
```
Input:  nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Output: true
```

**Constraints:**
- `1 <= nums.length <= 10⁵`
- `-10⁹ <= nums[i] <= 10⁹`

---

## Çözüm Süreci

### 1. İlk Akla Gelen: Brute Force (İç İçe For Döngüsü)

İlk sezgim şuydu: her elemanı alıp, dizinin geri kalanındaki tüm elemanlarla karşılaştır. Eşit olan bir çift bulursan `true` döndür.

```java
for (int i = 0; i < nums.length; i++) {
    for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) return true;
    }
}
return false;
```

Bu yaklaşım doğru sonuç verir, ama her eleman için dizinin geri kalanını taradığından **zaman karmaşıklığı O(n²)** olur. 10⁵ elemanlı bir dizide bu 10 milyar karşılaştırma anlamına gelir — kabul edilemez.

Bu yaklaşımı yazmadan bıraktım ve daha iyi bir yol aradım.

---

### 2. Doğru Çözüm: HashSet ile O(n)

Brute force yerine aklıma şu soru geldi: "Her elemanı daha önce görüp görmediğimi **O(1)** sürede öğrenebilir miyim?"

Cevap **HashSet**. HashSet'in `add()` metodu tam da bunu yapıyor:

- Eleman sette **yoksa** → sete ekler ve `true` döner
- Eleman sette **varsa** → eklemez ve `false` döner

Yani `add()` metodunun dönüş değeri, benim "bunu daha önce gördüm mü?" sorusunun cevabı.

```java
HashSet<Integer> my_set = new HashSet<>();
boolean is_include = false;

for (int num : nums) {
    if (!my_set.add(num)) {   // add() false döndürdüyse -> zaten vardı
        is_include = true;
    }
}
return is_include;
```

Diziyi yalnızca **bir kez** dolaşıyoruz. Her adımda HashSet'e ekleme ve arama işlemleri ortalama **O(1)**. Toplamda **O(n)** zaman, **O(n)** alan.

---

## HashSet Nedir? Neden Burada Kullanıldı?

`HashSet`, Java'da matematiksel küme (set) veri yapısını implement eder. İki kritik özelliği bu problemi çözmek için biçilmiş kaftan:

1. **Tekrar eden eleman kabul etmez.** Aynı değeri iki kez eklemeye çalışırsan set değişmez — ve bunu `false` döndürerek bize bildirir.
2. **Arama ve ekleme O(1).** Hash fonksiyonu sayesinde "bu eleman var mı?" sorusu sabit sürede cevaplanır. Dizi gibi sırayla bakmak zorunda kalmaz.

Bu iki özellik birleşince, duplicate kontrolü için mükemmel bir araç ortaya çıkıyor.

---

## Karmaşıklık Analizi

| Yaklaşım | Zaman | Alan |
|---|---|---|
| Brute Force (iç içe döngü) | O(n²) | O(1) |
| HashSet | O(n) | O(n) |

HashSet çözümünde O(n) ekstra alan kullanıyoruz çünkü en kötü durumda (tüm elemanlar farklıysa) tüm diziyi sete ekliyoruz. Bu, zaman kazancı için ödenen makul bir bedel.

---

## Neler Öğrendim? (Takeaways)

- `HashSet.add()` metodunun boolean dönmesi, sadece "ekleme" değil aynı zamanda "daha önce gördüm mü?" sorusunun cevabı olarak kullanılabilir. Bu küçük detay kodu hem kısa hem de okunabilir yapıyor.
- Zaman ile alan arasındaki trade-off bu problemde net görünüyor: O(1) alan için O(n²) zaman ödersin, ya da O(n) alan kullanıp O(n) zamana inersin. Büyük veri setleri için ikinci seçenek her zaman kazanır.
- Bir problemi çözerken "bu kontrolü O(1)'de yapabilir miyim?" sorusu genellikle HashMap veya HashSet'e yönlendiriyor. Bu sezgiyi geliştirmek önemli.