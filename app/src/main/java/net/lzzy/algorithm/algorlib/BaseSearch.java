package net.lzzy.algorithm.algorlib;

/**
 * Created by lzzy_gxy on 2019/6/22.
 * Description:
 */
public abstract class BaseSearch<T extends Comparable<? super T>> {
    T[] items;
    private long duration;
    private int compareCount;
    private int swapCount;
    int moveStep;

    BaseSearch(T[] items){
        this.items=items;
        compareCount=0;
        swapCount=0;
        moveStep=0;
    }

    boolean equal(T a,T b){
        return true;
    }

    int compare(T a,T b){
        compareCount++;
        return a.compareTo(b);
    }
    abstract int search(T key);

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
