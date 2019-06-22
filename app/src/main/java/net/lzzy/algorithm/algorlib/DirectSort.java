package net.lzzy.algorithm.algorlib;


/**
 * Created by lzzy_gxy on 2019/6/13.
 * Description:The program by LXQ
 */
public class DirectSort<T extends Comparable<? super T>> extends BaseSort<T> {


    /**
     * 构造方法
     */
    public DirectSort(T items[]){
        super(items);
    }
    //排序方法
    @Override
    public void sort()
    {
        long start=System.currentTimeMillis();
        for(int i=0;i<items.length-1;i++){
            int j=i-1;
            if (items[j].compareTo(items[i])<0){
                continue;
            }
            T tun=(T) items[i];
            while (j>=0&&items[j].compareTo(tun)>0){
                items[j+1]=items[j];
                moveStep++;
                j--;
            }
            items[j+1]=tun;
        }
        setDuration(System.currentTimeMillis()-start);
    }

}
