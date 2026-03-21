package leetcode.buy_sell_stock;
class Solution {

    // YAKLAŞIM 1: BENİM İLK ÇÖZÜMÜM (YANLIŞ) - Global Min & Max

    // İlk aklıma gelen şey şuydu: "En ucuza al, en pahalıya sat."
    // Bunun için tüm dizideki mutlak minimum ve maksimum değeri bulmak yeterli gibi göründü.
    // İki ayrı for loop ile global min'i ve global max'ı buldum.
    // Sonra şunu kontrol ettim: min, max'tan önce mi geliyor?
    // Eğer öyleyse farkı döndür, değilse 0 döndür.
    //
    // NEDEN YANLIŞ?
    // Çünkü "global min" ve "global max" her zaman en karlı çifti oluşturmaz.
    // Örnek: prices = [2, 10, 1, 3]
    //   -> Global min = 1 (index 2), Global max = 10 (index 1)
    //   -> indexOfMin (2) < indexOfMax (1) FALSE -> kod 0 döndürür.
    //   -> Ama gerçek cevap: 2'den alıp 10'a satmak = 8 kar!
    //
    // Temel yanılgı: Min her zaman max'tan önce gelmez.
    // Bu yaklaşım sadece "en ucuzu bul, en pahalıyı bul" der,
    // ama "en ucuz alıştan sonra en pahalı satışı bul" demez.

    public int maxProfitWrong(int[] prices) {
        int min = prices[0];
        int indexOfMin = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                indexOfMin = i;
            }
        }

        int max = prices[0];
        int indexOfMax = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                indexOfMax = i;
            }
        }

        // Sadece "min, max'tan önce mi geliyor?" diye bakıyorum.
        // Bu kontrol yetersiz — aralarında daha karlı bir çift olabilir.
        if (indexOfMin < indexOfMax) {
            return max - min;
        } else {
            return 0;
        }
    }


    // YAKLAŞIM 2: DOĞRU ÇÖZÜM - Greedy / Tek Geçişli DP

    // Hatamı anlayınca şunu fark ettim:
    // "Her gün için şunu sormalıyım: bugüne kadar gördüğüm en ucuz fiyattan
    //  alıp bugün satsaydım ne kadar kazanırdım?"
    //
    // Bu yüzden diziyi soldan sağa gezerken iki şeyi takip etmem yeterli:
    //   1. minPrice  -> Şimdiye kadar gördüğüm en düşük fiyat (potansiyel alış günüm)
    //   2. maxProfit -> Şimdiye kadar hesapladığım en yüksek kar (rekorumu tutuyorum)
    //
    // Her adımda:
    //   - Bugünkü fiyat minPrice'tan düşükse -> alış noktamı güncelle
    //   - Değilse -> "bugün satsaydım ne kazanırdım?" diye bak, rekorumu kır mı?
    //
    // Bu yaklaşım neden işe yarıyor?
    // Çünkü her satış anında, o ana kadarki EN UCUZ alış fiyatını biliyorum.
    // Geri gidip "ya daha önce daha karlı bir çift vardı?" diye bakmama gerek yok, -> dynamic programming
    // çünkü minPrice zaten bunu takip ediyor.
    //
    // Zaman Karmaşıklığı: O(n) — diziyi sadece bir kez dönüyoruz.
    // Alan Karmaşıklığı: O(1) — sadece iki değişken tutuyoruz.

    public int maxProfit(int[] prices) {
        // Integer.MAX_VALUE kullanıyorum çünkü ilk karşılaştırmada
        // prices[0] her zaman "şimdiye kadarki minimum" olacak.
        // prices[0]'ı doğrudan da atayabilirdim ama bu daha genel bir başlangıç.
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            // ADIM 1: Bugünkü fiyat, şimdiye kadar gördüğüm en ucuz fiyat mı?
            // Eğer öyleyse, bu noktayı potansiyel alış günüm olarak kaydet.
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            // ADIM 2: Bugün satış yapsaydım ne kazanırdım?
            // (Bugünkü fiyat - şimdiye kadarki en ucuz fiyat)
            // Bu, şimdiye kadarki rekorumu (maxProfit) geçiyor mu?
            // Geçiyorsa, yeni rekor bu.
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        // Hiç kar edilemeyen durumda (fiyatlar sürekli düştüyse) 0 döner.
        return maxProfit;
    }
}