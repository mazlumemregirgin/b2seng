# 📚 Week 1: Stack Exercises & Interview Questions

> Bu döküman, Week 1 kapsamında **Stack** veri yapısını anlamaya yönelik teorik sorular, kod takip (trace) alıştırmaları, pratik kod yazma görevleri ve kod inceleme (code review) sorularını içerir.

---

## ✅ Bölüm 1 — Teorik Bilgi ve Yorumlama
Bu sorular, konsepti ne kadar içselleştirdiğinizi ölçmeyi amaçlar. Kısa, net ve örneklerle cevaplayınız.

**Cevaplar:** `week1.stack/answers/theory.md`

1. **Soru 1: LIFO Nedir?**
    - Gerçek hayattan (yazılım dışı) Stack mantığına uyan 3 örnek veriniz.

2. **Soru 2: Stack vs. Array**
    - Kendi yazdığın `MyStack` sınıfında neden bir array kullanma ihtiyacı duydun? `top` değişkeni tam olarak hangi amaca hizmet ediyor?

3. **Soru 3: Complexity (Karmaşıklık)**
    - Bir Stack yapısında `push` ve `pop` işlemlerinin Big-O gösterimi nedir? Neden?

4. **Soru 4: Java Spesifik**
    - Neden `java.util.Stack` yerine `Deque<Integer> stack = new ArrayDeque<>();` kullanımı öneriliyor olabilir? (Kısa bir araştırma sorusu)

---

## 🧾 Bölüm 2 — Kod Okuma ve Trace (Simülasyon)
Aşağıdaki kod blokları çalıştırıldığında konsol çıktıları ne olur? Kağıt-kalem ile adım adım takip etmeye çalışın.

**Cevaplar:** `week1.stack/answers/trace.md`

**Soru 5**
```java
Stack<String> s = new Stack<>();
s.push("Elma");
s.push("Armut");
s.pop();
s.push("Çilek");
System.out.println(s.peek());
```
- Çıktı nedir?

**Soru 6**
```java
Stack<Integer> rakamlar = new Stack<>();
rakamlar.push(5);
rakamlar.push(10);
rakamlar.push(15);
System.out.println(rakamlar.search(5));
```
- Çıktı nedir?

**Soru 7 — Stack ile Geçici Veri Yönetimi**
Aşağıdaki kod parçasının sonunda `s1` ve `s2` stack'lerinin durumu ne olur?

```java
Stack<Integer> s1 = new Stack<>();
Stack<Integer> s2 = new Stack<>();

s1.push(10);
s1.push(20);
s1.push(30);

while(!s1.isEmpty()){
    int val = s1.pop();
    if(val % 20 != 0){
        s2.push(val);
    }
}
```
- `s1` ve `s2`'nin son içerikleri nedir?

---

## 💻 Bölüm 3 — Kod Yazma ve Algoritma (Pratik)
Lütfen çözümleri `week1.stack/solutions` klasörü altında **ayrı `.java` dosyaları** olarak yazınız. Her sorunun altında istenen dosya adını belirttim.

**Problem 1: String Reversing**
- Açıklama: Kullanıcıdan alınan bir kelimeyi (ör. "Mugla") bir `Stack` kullanarak ters çeviren kodu yazınız.
- Dosya: `reversedString.java`

**Problem 2: Balanced Parentheses (Temel Seviye)**
- Açıklama: Verilen bir `String` yalnızca `(` ve `)` karakterlerinden oluşmaktadır. `Stack` kullanarak parantezlerin dengeli (her açılan parantezin kapanmış olması) olup olmadığını kontrol eden metodu yazınız.
- Örnek: `(())` → `true`, `(()` → `false`
- Dosya: `balancedParentheses.java`

**Problem 3: Min Element (Zorlayıcı)**
- Açıklama: `MyStack` sınıfına öyle bir metot ekleyin ki, stack içindeki en küçük elemanı döndürsün. (İpucu: Bu işlemi yaparken stack yapısını bozmamaya çalışın.)
- Dosya: `minElement.java`

---

## 🔍 Bölüm 4 — Kod Review (Mülakat Tarzı)
Aşağıdaki kodlar işlevsel olabilir fakat mühendislik standartları, bellek yönetimi veya performans açısından sorunludur. Sorulara biçimsel ve teknik olarak yanıt veriniz.

**Cevaplar:** `week1.stack/answers/code_review.md`

**Soru 8: "Loitering" Problemi**
- Aşağıdaki `pop` metodunu inceleyin. Kod fonksiyonel olarak doğru çalışıyor (en üstteki elemanı döndürüyor ve `top` değerini azaltıyor). Ancak büyük ölçekli bir sistemde bu kod neden bir "Memory Leak" (bellek sızıntısı) riski taşır? Nasıl düzeltirsiniz?

```java
public String pop() {
    if (isEmpty()) return null;
    return stackArray[top--];
}
```

**Soru 9: Inheritance (Kalıtım) Hatası**
- Java'nın orijinal `Stack` sınıfı `Vector` sınıfını `extends` eder. Bu, Stack'in "sadece en üste erişim" prensibini nasıl bozabilir? Eğer bir geliştirici `stack.add(0, "Hatalı Veri")` çağırırsa ne olur? Tasarımsal olarak `extends` yerine ne kullanılmalıydı?

**Soru 10: Thread-Safety ve Performans**
- Mülakatta şu soru soruldu:

  "Uygulamamızda tek bir thread üzerinde çalışan yoğun bir veri işleme motoru var. Neden `java.util.Stack` kullanmak yerine `ArrayDeque` kullanmalıyız? `synchronized` anahtar kelimesinin buradaki performans etkisi nedir?"

- Cevabınızı açıklayınız.

---

> İyi çalışmalar! ✨
