import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase(); // 모두 대문자로 
        str2 = str2.toUpperCase();
        
        List<String> list1 = generateBigrams(str1);
        List<String> list2 = generateBigrams(str2);

        Map<String, Integer> map1 = generateFrequencyMap(list1);
        Map<String, Integer> map2 = generateFrequencyMap(list2);

        int intersectionSize = 0;
        int unionSize = 0;

        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                intersectionSize += Math.min(map1.get(key), map2.get(key));
                unionSize += Math.max(map1.get(key), map2.get(key));
            } else {
                unionSize += map1.get(key);
            }
        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                unionSize += map2.get(key);
            }
        }

        double jaccardSimilarity = (unionSize == 0) ? 1 : (double) intersectionSize / unionSize;
        return (int) (jaccardSimilarity * 65536);
    }

    private List<String> generateBigrams(String str) {
        List<String> bigrams = new ArrayList<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);
            if (Character.isLetter(first) && Character.isLetter(second)) {
                bigrams.add("" + first + second);
            }
        }
        return bigrams;
    }

    private Map<String, Integer> generateFrequencyMap(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }
}
