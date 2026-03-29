package leetcode.merge_sorted_array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // -------------------------------------------------------
        // TEST CASE 1: LeetCode örneği — iki eşit boyutlu dizi
        // Beklenen: [1, 2, 2, 3, 5, 6]
        // -------------------------------------------------------
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1, 3, nums2, 3);
        System.out.println("Test Case 1: " + Arrays.toString(nums1));
        // Beklenen:  [1, 2, 2, 3, 5, 6]

        // -------------------------------------------------------
        // TEST CASE 2: nums2 boş — nums1 zaten hazır
        // Beklenen: [1]
        // -------------------------------------------------------
        int[] nums1b = {1};
        int[] nums2b = {};
        solution.merge(nums1b, 1, nums2b, 0);
        System.out.println("Test Case 2: " + Arrays.toString(nums1b));
        // Beklenen:  [1]

        // -------------------------------------------------------
        // TEST CASE 3: nums1 boş — sadece nums2'den doldur
        // Beklenen: [1]
        // -------------------------------------------------------
        int[] nums1c = {0};
        int[] nums2c = {1};
        solution.merge(nums1c, 0, nums2c, 1);
        System.out.println("Test Case 3: " + Arrays.toString(nums1c));
        // Beklenen:  [1]

        // -------------------------------------------------------
        // TEST CASE 4: nums2'nin tüm elemanları nums1'den küçük
        // Sondan başa yazma yaklaşımının kritik testi:
        // nums2 elemanları işin sonunda başa yerleşmeli
        // Beklenen: [1, 2, 3, 4, 5, 6]
        // -------------------------------------------------------
        int[] nums1d = {4, 5, 6, 0, 0, 0};
        int[] nums2d = {1, 2, 3};
        solution.merge(nums1d, 3, nums2d, 3);
        System.out.println("Test Case 4: " + Arrays.toString(nums1d));
        // Beklenen:  [1, 2, 3, 4, 5, 6]

        // -------------------------------------------------------
        // TEST CASE 5: Negatif sayılar içeren diziler
        // Beklenen: [-5, -3, -1, 0, 2, 4]
        // -------------------------------------------------------
        int[] nums1e = {-3, -1, 4, 0, 0, 0};
        int[] nums2e = {-5, 0, 2};
        solution.merge(nums1e, 3, nums2e, 3);
        System.out.println("Test Case 5: " + Arrays.toString(nums1e));
        // Beklenen:  [-5, -3, -1, 0, 2, 4]

        // -------------------------------------------------------
        // TEST CASE 6: Eşit elemanlar içeren diziler
        // Beklenen: [1, 1, 2, 2, 3, 3]
        // -------------------------------------------------------
        int[] nums1f = {1, 2, 3, 0, 0, 0};
        int[] nums2f = {1, 2, 3};
        solution.merge(nums1f, 3, nums2f, 3);
        System.out.println("Test Case 6: " + Arrays.toString(nums1f));
        // Beklenen:  [1, 1, 2, 2, 3, 3]
    }
}
