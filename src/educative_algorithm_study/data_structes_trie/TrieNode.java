package educative_algorithm_study.data_structes_trie;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/30 23:13
 * Version 1.0
 * @description
 **/
public class TrieNode {
    TrieNode[] children;
    boolean isEndWorld;
    static final int ALPHABET_SIZE = 26;
    TrieNode(){
        this.isEndWorld = false;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    public void markAsLeaf(){
        this.isEndWorld = true;
    }

    public void unMarkAsLeaf() {
        this.isEndWorld = false;
    }
}
