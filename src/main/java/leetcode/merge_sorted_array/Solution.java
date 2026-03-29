package leetcode.merge_sorted_array;

public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // İLK AKLA GELEN: LinkedList
        // İki sıralı listeyi birleştirirken aklıma LinkedList geldi.
        // "Doğru pozisyona add(index, value) ile O(1)'de eklerim" diye düşündüm.
        // Ama hemen fark ettim: add(index, value) için önce o index'e ulaşmam gerekiyor.
        // LinkedList'te index'e erişim O(n) — yani toplamda O(n²) olurdu. Vazgeçtim.

        // DOĞRU YAKLAŞIM: Sondan Başa 3 Pointer
        // Yeni bir dizi oluşturmak yerine nums1'i in-place doldurabiliriz.
        // Püf nokta: önden değil, SONDAN başlamak.
        //
        // Neden sondan? Çünkü nums1'in sonunda zaten n tane boş (0) slot var.
        // En büyük elemanı en sona yazmaya başlarsak, henüz işlemediğimiz
        // elemanların üzerine yazmış olmayız. Çakışma sorunu ortadan kalkar.
        //
        // 3 pointer kuruyoruz:
        //   i -> nums1'in gerçek elemanlarının en sağı  (m-1)
        //   j -> nums2'nin en sağı                      (n-1)
        //   k -> nums1'in fiziksel en sonu (yazma yeri) (m+n-1)
        //
        // Her adımda nums1[i] ile nums2[j]'yi karşılaştır,
        // büyük olanı nums1[k]'ya yaz, ilgili pointer'ı ve k'yı sola kaydır.
        //
        // Zaman Karmaşıklığı: O(m + n) — her eleman tam bir kez işleniyor.
        // Alan Karmaşıklığı: O(1)      — ekstra dizi yok, sadece 3 değişken.

        int i = m - 1;      // nums1'in gerçek elemanlarının sonu
        int j = n - 1;      // nums2'nin sonu
        int k = m + n - 1;  // nums1'in en sonu (yazma yeri)

        // nums2'de eleman kaldığı sürece devam et.
        // nums1 bitip nums2 kalırsa onları da başa kopyalamamız gerekir.
        // nums1 biter nums2 bitmezse zaten yerindeler — bir şey yapmaya gerek yok.
        while (j >= 0) {

            // Eğer nums1'de hala eleman varsa VE nums1'deki sayı daha büyükse
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i]; // Büyük olanı en sona yaz
                i--;                 // nums1 işaretçisini sola kaydır
            } else {
                // nums2'deki sayı büyükse VEYA nums1'deki elemanlar bittiyse
                nums1[k] = nums2[j]; // nums2'deki sayıyı yaz
                j--;                 // nums2 işaretçisini sola kaydır
            }

            k--; // Her durumda yazma yerini bir sola kaydır
        }
    }
}
