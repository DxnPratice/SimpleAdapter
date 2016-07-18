package weather.newer.com.simpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static String KEY_LOGO="logo";
    private static String KEY_TITLE="title";
    private static String KEY_INFO="info";
   //适配器
    SimpleAdapter adapter;
    ArrayAdapter adapter2;
    //视图
    ListView  listview;
    ListView listView2;
    //数据
    ArrayList<Map<String ,Object>>  listitems;
    ArrayList<String> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //获得listview控件
        listview= (ListView) findViewById(R.id.listView);
        listitems=new ArrayList<>();
        Map<String ,Object> item1=new HashMap<>();
        item1.put(KEY_LOGO,R.drawable.audi);
        item1.put(KEY_TITLE,"奥迪");
        item1.put(KEY_INFO,"奥迪介绍");

        HashMap<String,Object> item2 =new HashMap<>();
        item2.put(KEY_LOGO,R.drawable.ford);
        item2.put(KEY_TITLE,"福特");
        item2.put(KEY_INFO,"福特介绍");

        HashMap<String,Object> item3 =new HashMap<>();
        item3.put(KEY_LOGO,R.drawable.jeep);
        item3.put(KEY_TITLE,"吉普");
        item3.put(KEY_INFO,"吉普介绍");

        HashMap<String,Object> item4 =new HashMap<>();
        item4.put(KEY_LOGO,R.drawable.chevrolet);
        item4.put(KEY_TITLE,"雪弗兰");
        item4.put(KEY_INFO,"雪弗兰介绍");

        listitems.add(item1);
        listitems.add(item2);
        listitems.add(item3);
        listitems.add(item4);

        for(int i=0; i<10; i++){
            listitems.add(item1);
        }
        String[]from={KEY_LOGO,KEY_TITLE,KEY_INFO};
       int []to={R.id.imageView,R.id.textView,R.id.textView2};
        adapter=new SimpleAdapter(this,listitems,R.layout.list_item,from,to);
        listview.setAdapter(adapter);

       //initView();




    }

    private void initView() {
        listView2 = (ListView) findViewById(R.id.listView2);
        data=new ArrayList<>();

        for(int i= 0; i<30;i++){
            data.add("数据项"+i);
        }
        //适配器ctrl+p
//        adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_single_choice,
//                data);
        adapter2= new ArrayAdapter<String>(
                this,
                R.layout.list_item2,
                R.id.textView3,
                data);


        //设置选择模式
        listView2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView2.setAdapter(adapter2);


    }
}
