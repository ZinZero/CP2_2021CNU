package kr.ac.cnu.computer.progressbar;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int current_progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultView = findViewById(R.id.result);
        EditText editText = findViewById(R.id.editText);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(current_progress);

        Button applyButton = findViewById(R.id.apply);
        applyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_progress = Integer.parseInt(String.valueOf(editText.getText()));
                if (0 <= current_progress && current_progress <= 100){
                    progressBar.setProgress(current_progress);
                    resultView.setText(editText.getText());
                }else{
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                        alertDialogBuilder.setTitle("잘못된 접근");
                        alertDialogBuilder.setMessage("잘못된 값을 입력하였습니다. 0 ~ 100사이의 값을 입력하십시오.");
                        alertDialogBuilder.show();
                }

            }
        });
        
        Button clearButton = findViewById(R.id.clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(0);
                current_progress = 0;
                resultView.setText("0");
            }
        });

    }
}