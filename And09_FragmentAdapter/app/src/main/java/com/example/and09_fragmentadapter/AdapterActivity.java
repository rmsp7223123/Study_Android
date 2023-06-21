package com.example.and09_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;

import com.example.and09_fragmentadapter.listv.ListFragment;

public class AdapterActivity extends AppCompatActivity {

//    ListView listv;

    Button btn_list;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        btn_list = findViewById(R.id.btn_list);
        manager = getSupportFragmentManager();
        btn_list.setOnClickListener(v -> {
            manager.beginTransaction().replace(R.id.container_frame, new ListFragment()).commit();
        });

//
////        용도나 형태에 따라 어댑터의 종류가 다름 Array형태로 String을 넣는 방식은 사용빈도가 가장 낮은 오래된 방식(ArrayAdapter)
//
////        Context(맥락) : 현재 모든 앱의 상태, 그리고 화면에 떠있는 객체의 상태등 모든 상태를 알 수 있는 변수
////        ↑ 액티비티이냐, 화면에 떠있는 객체(상태)이냐를 묻는것
//
////        ArrayAdapter(Context ↑, 반복 될 모양의 xml, 내용이 바뀌어야 한다면 사용 될 데이터)
////        기본 템플릿 : android.R.layout.simple_list_item_1(커스텀 필요)
//
//        String[] arrItem = new String[10];
//
//        for (int i = 0; i < 10; i++) {
//            arrItem[i] = "MBJ " + UUID.randomUUID().toString();
//        }
//
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrItem);
//
//        listv = findViewById(R.id.listv);
//        listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(AdapterActivity.this, arrItem[position], Toast.LENGTH_SHORT).show();
//                Log.d("리스트", "onItemClick: " + position + "AAA" + parent + "BBB" + id);
//            }
//        });
//        listv.setAdapter(adapter);
    }
}