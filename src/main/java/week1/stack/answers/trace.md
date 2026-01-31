# Bölüm 2 — Trace / Kod Okuma Şablonu

> Adım adım çalıştırma ve stack durumlarını tablo halinde yazmak en faydalı yöntemdir. Her soru için **kod**, **adımlar** ve **beklenen çıktı** başlıklarını bırakın; cevap alanlarını boş bırakın.

---

## Soru 5
**Kod:**
```java
Stack<String> s = new Stack<>();
s.push("Elma");
s.push("Armut");
s.pop();
s.push("Çilek");
System.out.println(s.peek());
```

**Adım adım (üstten alta):**

**Çıktı:**

**Açıklama / Not:**

---

## Soru 6
**Kod:**
```java
Stack<Integer> rakamlar = new Stack<>();
rakamlar.push(5);
rakamlar.push(10);
rakamlar.push(15);
System.out.println(rakamlar.search(5));
```

**Adımlar:**

**Çıktı (beklenti):**

**Açıklama (search() metodu nasıl çalışır):**

---

## Soru 7
**Kod:**
```java
Stack<Integer> s1 = new Stack<>();
Stack<Integer> s2 = new Stack<>();

s1.push(10);
s1.push(20);
s1.push(30);s

while(!s1.isEmpty()){
    int val = s1.pop();
    if(val % 20 != 0){
        s2.push(val);
    }
}
```

**Adım adım tablo (her iterasyon için s1 ve s2):**

**Son durum:**

**Açıklama / Not:**

---
