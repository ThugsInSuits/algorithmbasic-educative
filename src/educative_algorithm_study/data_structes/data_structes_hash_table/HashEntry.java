package educative_algorithm_study.data_structes.data_structes_hash_table;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/1 19:21
 * Version 1.0
 * @description
 **/
public class HashEntry {
    String key;
    int value;

    HashEntry next;

    public HashEntry(String key,int value) {
        this.key = key;
        this.value = value;
    }

}
