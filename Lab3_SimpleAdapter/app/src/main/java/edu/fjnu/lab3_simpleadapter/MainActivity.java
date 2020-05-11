package edu.fjnu.lab3_simpleadapter;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {
    private String[] name = { "Lion", "Tiger", "Monkey", "Dog" , "Cat","Elephant"};

    private ListView lt1;
    private int[] imageids = { R.drawable.lion, R.drawable.tiger,
            R.drawable.monkey, R.drawable.dog ,R.drawable.cat,R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String, Object>> listems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listem = new HashMap<String, Object>();
            listem.put("head", imageids[i]);
            listem.put("name", name[i]);
            listems.add(listem);
        }
        SimpleAdapter simplead = new SimpleAdapter(this, listems,
                R.layout.linearlayout, new String[] { "name", "head"},
                new int[] {R.id.name,R.id.head});
        lt1=(ListView)findViewById(R.id.lt1);
        lt1.setAdapter(simplead);
        lt1.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), name[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}