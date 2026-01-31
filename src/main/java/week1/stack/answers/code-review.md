# Bölüm 4 — Code Review Şablonu

> Kod inceleme sorularında: problem tanımı, bulunan sorun(lar), etkileri (performans / bellek / design), önerilen düzeltme ve kısa bir test planı yazın. Bu dosyada **cevaplar boş** bırakılacaktır.

---

## Soru 8 — "Loitering" Problemi
**Kod:**
```java
public String pop() {
    if (isEmpty()) return null;
    return stackArray[top--];
}
```

**Bulunan sorun(lar):**

**Etkisi:**

**Önerilen düzeltme (kısa):**

**Test senaryosu:**

---

## Soru 9 — Inheritance Hatası
**Soru:** Java `Stack` sınıfının `Vector`'dan `extends` etmesi tasarım problemine neden olur mu? Eğer bir geliştirici `stack.add(0, "Hatalı Veri")` çağırırsa ne olur?

**Bulunan sorun(lar):**

**Etkisi:**

**Öneri (composition vs inheritance):**

---

## Soru 10 — Thread-Safety ve Performans
**Soru:** Tek thread çalışan bir işlem hattında `Stack` yerine `ArrayDeque` kullanımı ve `synchronized` anahtar kelimesinin etkisi nedir?

**Bulunan sorun(lar):**

**Kısa notlar / Örnek durumlar:**

---