package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public class ShellSort extends BaseSort {

    private Integer items[];

    public ShellSort(Integer[] items) {
        super(items);
        this.items=items;
    }

    @Override
    public void sort() {
        //增量gap，并逐步缩小增量
        for(int gap=items.length/2;gap>0;gap/=2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i=gap;i<items.length;i++){
                int j = i;
                while(compareTwo(j-gap,0) &&
                        !compareTwo(items[j],items[j-gap])){
                //while(j-gap>=0 && items[j]<items[j-gap]){
                    //插入排序采用交换法
                    items[j] = items[j]+items[j-gap];
                    items[j-gap] = items[j]-items[j-gap];
                    items[j] = items[j]-items[j-gap];
                    j-=gap;
                }
            }
        }
    }
}
