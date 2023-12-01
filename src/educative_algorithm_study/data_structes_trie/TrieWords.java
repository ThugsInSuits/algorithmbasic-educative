package educative_algorithm_study.data_structes_trie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/1 09:48
 * Version 1.0
 * @description
 **/
public class TrieWords {
    //Recursive Function to generate all words
    public static void getWords(TrieNode root, ArrayList< String > result, int level, char[] str)
    {
       if (root.isEndWorld) {
           String temp = "";
           for (int x = 0; x < level; x++) {
               temp += Character.toString(str[x]);
           }
           result.add(temp);
       }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                str[level] = (char) (i + 'a');
                getWords(root.children[i],result,level+1,str);
            }
        }
    }
    public static ArrayList < String > findWords(TrieNode root)
    {
        ArrayList < String > result = new ArrayList < String > ();
        char[] chararr = new char[20];
        getWords(root,result,0,chararr);
        return result;
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their","abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();
        System.out.println("Keys: "+ Arrays.toString(keys));

        // Construct trie

        for (int i = 0; i < keys.length ; i++)
            t.insert(keys[i]);


        ArrayList < String > list = findWords(t.getRoot());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
