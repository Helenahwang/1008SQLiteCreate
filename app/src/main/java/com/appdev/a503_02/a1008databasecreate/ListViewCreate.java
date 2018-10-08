package com.appdev.a503_02.a1008databasecreate;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewCreate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_create);

        //방법 1
        //출력할 데이터 배열이나 List 생성
        //String[] girlgroups = {"블랙핑크","레드벨벳","소녀시대","우주소녀","여자친구"};

        //방법 1
        //위의 데이터를 가지고 Adapter 생성
        //첫번째는 context, 두번째는 출력할 제공된 셀의 모양, 세번째는 출력할 데이터
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, girlgroups);

        //방법 1 과 2 공통
        //ListView에 위의 adapter 연결
        ListView listView1 = (ListView)findViewById(R.id.listView);

        //방법 1
        //listView.setAdapter(adapter);


        //방법2
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.girlgroups, android.R.layout.simple_list_item_1);
        listView1.setAdapter(adapter);

        listView1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView1.setDivider(new ColorDrawable(Color.RED));
        listView1.setDividerHeight(3);


        listView1.setOnItemClickListener(new ListView.OnItemClickListener(){
            @Override
            //첫번째 매개변수는 이벤트가 발생한 객체
            //두번째 매개변수는 항목 뷰 - 선택한 항목의 뷰
            //세번째 매개변수는 클릭한 항목 뷰의 인덱스
            //네번째 매개변수는 항목 뷰의 아이디
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewCreate.this, position+"번째 선택", Toast.LENGTH_LONG).show();
            }
        });

    }
}
