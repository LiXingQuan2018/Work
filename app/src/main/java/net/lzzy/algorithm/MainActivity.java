package net.lzzy.algorithm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Integer[] items;
    private EditText edtItems;
    private TextView tvResult;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtItems = findViewById(R.id.activity_main_edt_items);
        findViewById(R.id.activity_main_btn_generate).setOnClickListener(this);
        findViewById(R.id.activity_main_btn_sort).setOnClickListener(this);
        tvResult = findViewById(R.id.activity_main_tv_result);
        spinner=findViewById(R.id.spinner);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_btn_generate:
                generateItems();
                displayItems(edtItems);
                break;
            case R.id.activity_main_btn_sort:
                selectSortFun();
                //directSort();
                //insertSort();
                //DirectSort sort=new DirectSort(items);//直接选择排序
                //InsertSort sort=new InsertSort(items);//直接插入排序
//                ShellSort sort=new ShellSort(items);//希尔排序
//                sort.sorttWithTime();//调用排序方法
//                items=sort.returnResoult();//获得排序结果
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("排序完成")
//                        .setMessage("对比次数："+sort.getCompareCount()
//                        +"\n交换次数："+sort.getSwapCount()+
//                        "\n移动次数："+sort.getMoveCount()+
//                        "\n运行时长："+sort.getRuntime())
//                        .show();
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

    //直接选择排序
    private void directSort() {
        //todo:直接选择排序的具体实现
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

    //直接插入排序
    private void insertSort(){
        int i,j;
        for(i=1;i<items.length;i++){
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
    public void selectSortFun(){
        BaseSort sort = null;
        switch (spinner.getSelectedItemPosition()){
            case 0:
                sort=new DirectSort(items);//直接选择排序
                Toast.makeText(this, "直接选择排序",
                        Toast.LENGTH_SHORT).show();
                break;
            case 1:
                sort=new InsertSort(items);//直接插入排序
                Toast.makeText(this, "直接插入排序",
                        Toast.LENGTH_SHORT).show();
                break;
            case 2:
                sort=new ShellSort(items);//希尔排序
                Toast.makeText(this, "希尔排序",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        sort.sorttWithTime();//调用排序方法
        items=sort.returnResoult();//获得排序结果
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("排序完成")
                .setMessage("对比次数："+sort.getCompareCount()
                        +"\n交换次数："+sort.getSwapCount()+
                        "\n移动次数："+sort.getMoveCount()+
                        "\n运行时长："+sort.getRuntime())
                .show();
    }
}
