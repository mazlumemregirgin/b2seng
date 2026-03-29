package leetcode.contains_duplicates;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // -------------------------------------------------------
        // TEST CASE 1: Duplicate var — 1 iki kez geçiyor
        // Beklenen: true
        // -------------------------------------------------------
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("=== Test Case 1: [1, 2, 3, 1] ===");
        System.out.println("Sonuc: " + solution.containsDuplicate(nums1)); // true
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 2: Tüm elemanlar farklı
        // Beklenen: false
        // -------------------------------------------------------
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("=== Test Case 2: [1, 2, 3, 4] ===");
        System.out.println("Sonuc: " + solution.containsDuplicate(nums2)); // false
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 3: Birden fazla duplicate var
        // Beklenen: true
        // -------------------------------------------------------
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("=== Test Case 3: [1, 1, 1, 3, 3, 4, 3, 2, 4, 2] ===");
        System.out.println("Sonuc: " + solution.containsDuplicate(nums3)); // true
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 4: Tek elemanlı dizi — duplicate olamaz
        // Beklenen: false
        // -------------------------------------------------------
        int[] nums4 = {42};
        System.out.println("=== Test Case 4: [42] ===");
        System.out.println("Sonuc: " + solution.containsDuplicate(nums4)); // false
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 5: Negatif sayılar içeren dizi
        // Beklenen: true  (-3 iki kez geçiyor)
        // -------------------------------------------------------
        int[] nums5 = {-3, 0, 5, -3, 7};
        System.out.println("=== Test Case 5: [-3, 0, 5, -3, 7] ===");
        System.out.println("Sonuc: " + solution.containsDuplicate(nums5)); // true
        System.out.println();

        // -------------------------------------------------------
        // TEST CASE 6: Duplicate sadece dizinin en sonunda
        // Beklenen: true
        // -------------------------------------------------------
        int[] nums6 = {1, 2, 3, 4, 5, 1};
        System.out.println("=== Test Case 6: [1, 2, 3, 4, 5, 1] ===");
        System.out.println("Sonuc: " + solution.containsDuplicate(nums6)); // true
    }
}
