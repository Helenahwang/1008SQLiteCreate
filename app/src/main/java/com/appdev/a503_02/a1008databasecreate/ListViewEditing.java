package com.appdev.a503_02.a1008databasecreate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewEditing extends AppCompatActivity {

    //ListView 출력을 위한 변수
    private List<String> list1;
    private ListView listView1;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_editing);

        list1 = new ArrayList<>();
        list1.add("Encapsulation(캡슐화");

        //어답터 생성해서 list1 불러오기
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, list1);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list1);

        //xml에 작성한 것 불러오기
        listView1 = (ListView)findViewById(R.id.listView);

        // 선택되게 만들기
        //listView1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        //어답터와 xml 연결하기
        listView1.setAdapter(adapter);


        Button insert = (Button)findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)findViewById(R.id.word);

                //입력한 내용의 좌우 공백을 제거하고 가져오기
                String word = editText.getText().toString().trim();

                if(word.length() == 0){
                    Toast.makeText(ListViewEditing.this, "삽입할 단어를 입력하세요!", Toast.LENGTH_LONG).show();
                    return;
                }

                list1.add(word);

                //리스트 뷰 다시 출력
                adapter.notifyDataSetChanged();


            }
        });

        //싱글 삭제
        /*
        Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //선택한 행 번호 가져오기
                int pos = listView1.getCheckedItemPosition();

                //선택한 행 번호가 List 안의 번호인지 확인해서 아니면 리턴
                if(pos < 0 || pos >= list1.size()){
                    Toast.makeText(ListViewEditing.this, "선택하고 삭제를 누르세요!", Toast.LENGTH_LONG).show();
                    return;
                }
                //데이터 삭제
                list1.remove(pos);

                adapter.notifyDataSetChanged();
                listView1.clearChoices();
                Toast.makeText(ListViewEditing.this, "삭제 성공!", Toast.LENGTH_LONG).show();

            }
        });
        */


        Button delete = (Button)findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //선택 여부를 배열로 받아오기
                SparseBooleanArray sb = listView1.getCheckedItemPositions();

                //뒤에서부터 삭제를 수행
                for(int i=listView1.getCount()-1; i>=0; i--){
                    if(sb.get(i) == true){
                        list1.remove(i);
                    }
                }


                adapter.notifyDataSetChanged();
                listView1.clearChoices();
                Toast.makeText(ListViewEditing.this, "삭제 성공!", Toast.LENGTH_LONG).show();

            }
        });





    }
}
