package datastrucutresAndAlgorithms.ey.training.week4.day18;

import java.util.HashMap;
import java.util.Map;

public class MaximumBalloon {
	public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> requirementMap = new HashMap<>();
        requirementMap.put('b',1);
        requirementMap.put('a',1);
        requirementMap.put('l',2);
        requirementMap.put('o',2);
        requirementMap.put('n',1);

        for(char each : text.toCharArray())
            map.put(each, map.getOrDefault(each, 0) + 1);

        if(requirementMap.size() > map.size()) return 0;

        int output = Integer.MAX_VALUE;

        for(Map.Entry<Character, Integer> entry : requirementMap.entrySet()) {
            if(requirementMap.containsKey(entry.getKey()))
                output = Math.min(output, map.get(entry.getKey())/(entry.getValue()));
        }

        return output;
    }
}
