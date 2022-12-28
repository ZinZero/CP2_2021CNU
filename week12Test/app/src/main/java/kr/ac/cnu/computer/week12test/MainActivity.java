package kr.ac.cnu.computer.week12test;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    public TextView contentsEdit;
    public Button sendButton;
    public MessageAdapter adapter;
    /*
        문제에 맞게 onCreate 메소드를 정의하시오.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        contentsEdit = findViewById(R.id.contentsEdit);
        sendButton = findViewById(R.id.sendButton);

        // DBHelper객체를 생성하여 테이블 생성 및 데이터 가져오기
        dbHelper = new DBHelper(this, 1);
        adapter = new MessageAdapter(dbHelper.selectAll());

        // Recyclerview에 adapter 할당
        recyclerView.setAdapter(adapter);

        sendButton.setOnClickListener(v -> sendAction(v));

        contentsEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // text길이 검사해서 1 이상이면 버튼 활성화
                if (s.length() >= 1)
                    sendButton.setEnabled(true);
                else
                    sendButton.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    /*
        전송 버튼을 누를 때 동작 되는 메소드
        이 메소드 내용 작성
    */
    public void sendAction(View view) {
        String content = contentsEdit.getText().toString();
        int id = (int)dbHelper.insert(content, MessageType.RIGHT_CONTENTS);
        String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.KOREA).format(new java.util.Date());
        adapter.add(new Message(id, content, date, MessageType.RIGHT_CONTENTS));
        adapter.notifyItemInserted(id); // 어뎁터에게 신규 메시지를 추가했다고 알림을 날림

        contentsEdit.setText("");
    }
}