package educative_algorithm_study.data_structes_trie;

import java.util.Arrays;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/1 10:21
 * Version 1.0
 * @description
 **/
public class DictWord {
    public static boolean isFormationPossible(String[] dict,String word) {
        if (word.length() < 2 || dict.length < 2 ){
            return false;
        }
        Trie trie = new Trie();
        for (int i = 0; i < dict.length; i++) {
            trie.insert(dict[i]);
        }

        for (int i = 0; i < word.length(); i++) {
            String first = word.substring(0,i);
            String second = word.substring(i,word.length());
            if (trie.search(first) && trie.search(second)) {
                return true;
            }
        }
        // write your code here
        return false;
    }

    public static void main(String args[]){
        // Input dict (use only 'a' through 'z' and lower case)
        String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};

        Trie t = new Trie();

        System.out.println("Keys: "+ Arrays.toString(dict));

        if(isFormationPossible(dict, "helloworld"))
            System.out.println("true");
        else
            System.out.println("false");

    }
}
