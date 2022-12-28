package kr.ac.cnu.computer.chattingview;

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
    private DBHelper dbHelper;

    /*
        문제에 맞게 onCreate 메소드를 정의하시오.
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // DBHelper객체를 생성하여 테이블 생성 및 데이터 가져오기
        dbHelper = new DBHelper(this, 1);


    }

    /*
        전송 버튼을 누를 때 동작 되는 메소드
        이 메소드 내용 작성
    */
    public void sendAction(View view) {

    }
}