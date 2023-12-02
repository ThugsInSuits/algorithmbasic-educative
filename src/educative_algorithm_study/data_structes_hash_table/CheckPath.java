package educative_algorithm_study.data_structes_hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 20:13
 * Version 1.0
 * @description
 **/
public class CheckPath {
    public static String tracePath(Map<String,String> map) {
        String result = "";
        HashMap<String,String> reverseMap = new HashMap<>();
        for(Map.Entry<String,String> entry:map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        String from = "";
        int count = 0;
        for(Map.Entry<String,String> entry : map.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                count++;
                from = entry.getKey();
            }
        }

        if (count > 1) {
            return "null";
        }

        String to = map.get(from);
        while (to != null) {
            result +=  from + "->" + ", ";
            from = to;
            to = map.get(to);
        }

        return result;
    }

    public static void main(String[] args) {
        HashMap<String,String> hMap = new HashMap<>();

        hMap.put("NewYork","Chicago");
        hMap.put("Boston","Texas");
        hMap.put("Missouri","NewYork");
        hMap.put("Texas","Missouri");

        String actual_output = CheckPath.tracePath(hMap);

        System.out.println(actual_output);
    }
}
