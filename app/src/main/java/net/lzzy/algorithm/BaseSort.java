package net.lzzy.algorithm;


/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public abstract class BaseSort<T extends Comparable<? super T>> {
    //region

    private Integer items[];
    private long runtime;//运行时长
    private int compareCount;//比较次数
    private int moveCount;//移动次数
    private int swapCount;//交换次数

    //endregion

    public BaseSort(Integer items[]){
        this.items=items;
    }

    //返回运行时长
    public long getRuntime() {
        return runtime;
    }

    //返回比较次数
    public int getCompareCount() {
        return compareCount;
    }

    //返回移动次数
    public int getMoveCount() {
        return moveCount;
    }

    //返回交换次数
    public int getSwapCount() {
        return swapCount;
    }

    //比较两个数
    public boolean compareTwo(int a,int b){
        compareCount++;
        return a>=b?true:false;
    }
    //交换两个数
    public void swap(int j,int temp){
        temp=items[j];
        items[j]=items[j+1];
        items[j+1]=temp;
        swapCount++;
    }
    //返回排序结果
    public Integer[] returnResoult(){
        return items;
    }
    //移动
    public void move(int j){
        moveCount++;
        items[j+1]=items[j];
    }
    public void sorttWithTime(){
        long current=System.currentTimeMillis();
        sort();
        long end=System.currentTimeMillis();
        runtime=end-current;
    }
    //抽象排序方法
    public abstract void sort();
}
