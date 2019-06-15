package net.lzzy.algorithm;

/**
 * Created by lzzy_gxy on 2019/6/15.
 * Description:
 */
public class InsertSort extends BaseSort {

    private Integer items[];

    public InsertSort(Integer items[]){
        super(items);
        this.items=items;
    }

    @Override
    public void sort() {
        int i,j;
        for(i=1;i<items.length;i++){
            int temp=items[i];
            for(j=i-1;compareTwo(j,0)&&compareTwo(items[j],temp);j--){
            //for(j=i-1;j>=0&&items[j]>temp;j--){
                //items[j+1]=items[j];
                move(j);
            }
            items[j+1]=temp;
        }

    }
}
