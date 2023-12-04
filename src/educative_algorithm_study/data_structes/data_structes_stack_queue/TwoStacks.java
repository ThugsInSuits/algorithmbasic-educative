package educative_algorithm_study.data_structes.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/25 16:31
 * Version 1.0
 * @description
 **/
public class TwoStacks <V> {
    private int maxSize;
    private V[] array;
    private int top1, top2;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];
        top1 = -1;
        top2 = max_size;
    }

    //insert at top of first stack
    public void push1(V value) {
        if (top1 < top2 - 1) {
            array[++top1] = value;
        }
    }

    //insert at top of second stack
    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        }
    }

    //remove and return value from top of first stack
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        }
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if (top2 < maxSize) {
            return array[top2++];
        }
        return null;
    }
}