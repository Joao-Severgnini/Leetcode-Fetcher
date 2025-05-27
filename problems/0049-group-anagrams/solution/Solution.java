import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {  
        // Map to group words by their sorted character key
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Convert the word to a char array and sort it to use as a key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // If the key doesn't exist in the map, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the original word to the correct group
            map.get(key).add(word);
        }

        // Return all grouped anagram lists
        return new ArrayList<>(map.values());
    }
}
