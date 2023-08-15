package test;

import java.util.*;
import java.util.stream.Collectors;

import static test.TestWork.KthSmallestElement.findKthSmallest;

public class TestWork {
    public static List<List<Integer>> findAllPairsWithSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                result.add(Arrays.asList(num, complement));
            }
            seen.add(num);
        }
        if(result.isEmpty()){
            System.out.println("Not found");
            return null;
        }

        return result;
    }

    public class KthSmallestElement {

        public static int findKthSmallest(int[] arr, int k) {
            if (k > 0 && k <= arr.length) {
                Arrays.sort(arr);
                return arr[k - 1];
            }
            return -1; // Invalid k value
        }
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : words) {
            int[] count = new int[26]; // Assuming lowercase English letters
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    keyBuilder.append('a' + i).append(count[i]);
                }
            }
            String key = keyBuilder.toString();

            anagramGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(anagramGroups.values());
    }
    public static void main(String[] args) {
        int[] nums = {8, 7, 2, 5, 3, 1, 5, 3};
        int target = 10;
        List<List<Integer>> pairs = findAllPairsWithSum(nums, target);
//        System.out.println(pairs);
//        System.out.println(99999);
        for (List<Integer> pair : pairs) {
            System.out.println("Pair found: (" + pair.get(0) + ", " + pair.get(1) + ")");
        }

            System.out.println(2 + "..............");

        int[] arr = {7, 4, 6, 3, 9, 1};
        int k = 3;
        int kthSmallest = findKthSmallest(arr, k);
        System.out.println("k’th smallest array element is " + kthSmallest);

        System.out.println(3 + "...............");

        String[] words = {
                "actors", "costar",
                "altered", "related",
                "auctioned", "education",
                "aspired", "despair",
                "mastering", "streaming",
                "recueds", "secured"
        };

        List<List<String>> anagramGroups = groupAnagrams(words);

        for (List<String> group : anagramGroups) {
            System.out.println(group);
        }
    }
}
