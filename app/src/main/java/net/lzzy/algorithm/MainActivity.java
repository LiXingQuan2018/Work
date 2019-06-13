package net.lzzy.algorithm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                directSort();
                displayItems(tvResult);
                break;
            default:
                break;
        }
    }

    private void displayItems(TextView tv) {
        String display = "";
        for (Integer i : items) {
            display = display.concat(i + ",");
        }
        display = display.substring(0, display.length() - 1);
        tv.setText(display);
    }

    private void directSort() {
        //todo:直接选择排序的具体实现
        /*int r[]=new int[items.length+1];//定义一个新数值
        r[0]=0;
        for (int i=1;i<r.length;i++){//将随机数数组复制到新数组里，从1开始
            r[i]=items[i-1];
        }
        int kIndex = 0;//记录k的数组下标
        for(int i=1;i<r.length-1;i++){//i遍历数组，从1开始
            int k=r[i];//默认k的初始值为r[i]
            for(int j=i+1;j<r.length;j++){//j遍历剩余的数
                if(r[j]<=k){//如果r[j]小于k
                    //赋值
                    k=r[j];
                    kIndex=j;
                }
            }
            //交换位置
            r[0]=r[i];
            r[i]=k;
            r[kIndex]=r[0];
        }
        for(int i=0;i<items.length;i++){
            items[i]=r[i+1];//将items数组内容换成r
        }*/

        //优化后的代码
        int kIndex;
        for(int i=0;i<items.length-1;i++){
            for(int j=0;j<items.length-1;j++){
                if(items[j]>items[j+1]){
                    kIndex=items[j];
                    items[j]=items[j+1];
                    items[j+1]=kIndex;
                }
            }
        }
    }

    private void insertSort(){
        int i,j;
        for(i=1;i<items.length;i++){
            /*if(items[i]<items[i-1]){
                int low=items[i];
                items[i]=items[i-1];
                for(int j=i-2;j>=0;j--){
                    if(low>=items[j]){
                        items[j+1]=low;
                        //items[j+1]=items[j];
                        //items[j]=low;
                        break;
                    }else{
                        items[j+1]=items[j];
                    }
                }
            }*/
            //不断地从无序区中取出其第一个元素，
            // 搜寻该元素应该放在有序区的哪个位置，
            // 并将该元素放入该位置，完成这个步骤后，
            // 有序区长度+1，无序区长度-1，
            // 直至无序区长度为0，即无序区中不再有元素
            int temp=items[i];
            for(j=i-1;j>=0&&items[j]>temp;j--){
                items[j+1]=items[j];
            }
            items[j+1]=temp;
        }
    }


    private void generateItems() {
        items = new Integer[10];
        Random generator = new Random();
        for (int i = 0; i < items.length; i++) {
            items[i] = generator.nextInt(99);
        }
    }
}
