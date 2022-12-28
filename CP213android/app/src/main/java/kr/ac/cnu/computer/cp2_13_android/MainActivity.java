package kr.ac.cnu.computer.cp2_13_android;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Message> list = new ArrayList<>();
    private MessageAdapter adapter;
    private EditText contentsEdit;
    private DBHelper dbHelper;
    private RecyclerView recyclerView;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this, 1);
        recyclerView = findViewById(R.id.recyclerView);
        contentsEdit = findViewById(R.id.contentsEdit);
        sendButton = findViewById(R.id.sendButton);

        // 목록 가져오기
        list = dbHelper.selectAll();

        adapter = new MessageAdapter(list);
        recyclerView.setAdapter(adapter);

        // messageEdit에 글자가 입력되었을 때에만 전송 버튼 활성화
        contentsEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    sendButton.setEnabled(true);
                } else {
                    sendButton.setEnabled(false);
                }
            }
        });
        recyclerView.smoothScrollToPosition(list.size());

    }

    public void sendAction(View view) {
        String contents = contentsEdit.getText().toString();
        //내가 작성한 글은 Message Type을 right_contents로 설정
        long id = dbHelper.insert(contents, MessageType.RIGHT_CONTENTS);
        Message message = dbHelper.selectOne(id);
        list.add(message);
        adapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(list.size());
        contentsEdit.setText("");
    }
}