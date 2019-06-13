package net.lzzy.algorithm;

import android.util.Log;

/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:The program by LXQ
 */
public class CustomizeSort implements Comparable {

    //region

    private long runtime;//运行时长
    private int compareCount;//比较次数
    private int moveCount;//移动次数
    private int swapCount;//交换次数
    private Integer items[];

    //endregion

    /**
     * 构造方法
     */
    public CustomizeSort(Integer items[]){
        this.items=items;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public long getRuntime() {
        return runtime;
    }

    public int getCompareCount() {
        return compareCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getSwapCount() {
        return swapCount;
    }

    //比较两个数
    public boolean compareTwo(int a,int b){
        compareCount++;
        return a>=b?true:false;
    }

    //交换两个数
    public void swap(int j,int kIndex){
        swapCount++;
        kIndex=items[j];
        items[j]=items[j+1];
        items[j+1]=kIndex;
    }

    public void move(){
        moveCount++;
    }

    //返回排序结果
    public Integer[] returnResoult(){
        //sort();
        return items;
    }

    //排序方法
    public void sort(){
        long current=System.currentTimeMillis();
        Log.e("curent",current+"");
        int kIndex = 0;
        for(int i=0;i<items.length-1;i++){
            for(int j=0;j<items.length-1;j++){
                if(compareTwo(items[j],items[j+1])){
                    swap(j,kIndex);
                }
            }
        }
        long end=System.currentTimeMillis();
        Log.e("end",end+"");
        runtime=end-current;
        Log.e("runtime",runtime+"");
    }

}
