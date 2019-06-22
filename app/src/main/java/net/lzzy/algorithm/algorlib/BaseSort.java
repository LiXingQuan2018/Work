package net.lzzy.algorithm.algorlib;


/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public abstract class BaseSort<T extends Comparable<? super T>> {

    T[] items;
    private long duration;
    private int compareCount;
    private int swapCount;
    int moveStep;

    BaseSort(T[] items){
        this.items=items;

    }
    //比较大小
    boolean bigger(T a,T b){
        compareCount++;
        return a.compareTo(b)>0;
    }

    void swap(int i, int j){
        swapCount++;
        T num=items[i];
        items[i]=items[j];
        items[j]=num;
    }

    public String getResult(){
        String display="";
        for(T i:items){
            display=display.concat(i+"，");
        }
        return display.substring(0,display.length()-1);
    }

    public void sortWithTime(){
        long start=System.currentTimeMillis();
        sort();
        duration=System.currentTimeMillis()-start;
    }
    abstract void sort();

    public long getDuration(){
        return duration;
    }

    public int getCompareCount() {
        return compareCount;
    }

    public int getSwapCount() {
        return swapCount;
    }

    public int getMoveStep() {
        return moveStep;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
