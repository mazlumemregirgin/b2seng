package leetcode.buy_sell_stock;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // -------------------------------------------------------
        // TEST CASE 1: Klasik örnek — kar var
        // Beklenen: 5 (1'den al, 6'ya sat)
        // -------------------------------------------------------
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("=== Test Case 1: [7, 1, 5, 3, 6, 4] ===");
        System.out.println("Dogru Cozum  -> maxProfit: " + solution.maxProfit(prices1));       // 5
        System.out.println("Yanlis Cozum -> maxProfit: " + solution.maxProfitWrong(prices1));  // 5 (tesadüfen doğru)
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 2: Fiyatlar sürekli düşüyor — kar yok
        // Beklenen: 0
        // -------------------------------------------------------
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("=== Test Case 2: [7, 6, 4, 3, 1] ===");
        System.out.println("Dogru Cozum  -> maxProfit: " + solution.maxProfit(prices2));       // 0
        System.out.println("Yanlis Cozum -> maxProfit: " + solution.maxProfitWrong(prices2));  // 0
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 3: Yanlış çözümün çöktüğü senaryo!
        // Global max (10), global min'den (1) ÖNCE geliyor.
        // Yanlış kod: 0 döner. Doğru cevap: 8 (2'den al, 10'a sat)
        // -------------------------------------------------------
        int[] prices3 = {2, 10, 1, 3};
        System.out.println("=== Test Case 3: [2, 10, 1, 3] ===");
        System.out.println("Dogru Cozum  -> maxProfit: " + solution.maxProfit(prices3));       // 8
        System.out.println("Yanlis Cozum -> maxProfit: " + solution.maxProfitWrong(prices3));  // 0 (YANLIŞ!)
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 4: Yanlış çözümün çöktüğü ikinci senaryo!
        // Min sonra, max önce geliyor.
        // Yanlış kod: 0 döner. Doğru cevap: 4 (1'den al, 5'e sat)
        // -------------------------------------------------------
        int[] prices4 = {10, 1, 5, 3, 2};
        System.out.println("=== Test Case 4: [10, 1, 5, 3, 2] ===");
        System.out.println("Dogru Cozum  -> maxProfit: " + solution.maxProfit(prices4));       // 4
        System.out.println("Yanlis Cozum -> maxProfit: " + solution.maxProfitWrong(prices4));  // 0 (YANLIŞ!)
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 5: Tek elemanlı dizi
        // Beklenen: 0
        // -------------------------------------------------------
        int[] prices5 = {5};
        System.out.println("=== Test Case 5: [5] ===");
        System.out.println("Dogru Cozum  -> maxProfit: " + solution.maxProfit(prices5));       // 0
        System.out.println("Yanlis Cozum -> maxProfit: " + solution.maxProfitWrong(prices5));  // 0
        System.out.println();
    }
}