package educative_algorithm_study.data_structes.data_structes_trie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/1 10:00
 * Version 1.0
 * @description
 **/
public class Sort {
    public static void getWords(TrieNode root,ArrayList<String> result,int level,char[] str) {
        if (root.isEndWorld) {
            String temp = "";
            for (int i = 0; i < level; i++) {
                temp += Character.toString(str[i]);
            }
            result.add(temp);
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                str[level] = (char) (i+'a');
                getWords(root.children[i],result,level+1,str);
            }
        }
    }
    public static ArrayList<String> sortArray(String[] arr) {
        ArrayList<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for (int i = 0; i < arr.length; i++) {
            trie.insert(arr[i]);
        }
        char[] char_arr = new char[20];
        getWords(trie.getRoot(),result,0,char_arr);
        return result;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};

        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = sortArray(keys);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }
}
