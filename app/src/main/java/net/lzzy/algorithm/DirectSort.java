package net.lzzy.algorithm;


/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:The program by LXQ
 */
public class DirectSort extends BaseSort {

    private Integer items[];//数组

    /**
     * 构造方法
     */
    public DirectSort(Integer items[]){
        super(items);
        this.items=items;
    }
    //排序方法
    @Override
    public void sort()
    {
        int kIndex = 0;
        for(int i=0;i<items.length-1;i++){
            for(int j=0;j<items.length-1;j++){
                if(compareTwo(items[j],items[j+1])){
                    swap(j,kIndex);
                }
            }
        }
    }

}
