package kr.ac.cnu.computer.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    int current_progress = 0;

    TextView resultView = (TextView) findViewById(R.id.result);
    EditText inputView = (EditText) findViewById(R.id.input);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(current_progress);

        Button applicationButton = findViewById(R.id.applicationbutton);
        applicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_progress = Integer.parseInt(String.valueOf(inputView.getText()));
                if (0 <= current_progress && current_progress <= 100){
                    progressBar.setProgress(current_progress);
                    resultView.setText(inputView.getText());
                }else {
                    showDialog();
                }
            }
        });


        public void showDialog(View view){
            AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this);
            msgBuilder.setTitle("잘못된 접근");
            msgBuilder.setMessage("잘못된 값을 입력하였습니다. 0 ~ 100 사이의 값을 입력하십시오.");
        }


        Button clearbutton = (Button) findViewById(R.id.clearbutton);
        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(0);
                resultView.setText("");
            }
        });
    }
}