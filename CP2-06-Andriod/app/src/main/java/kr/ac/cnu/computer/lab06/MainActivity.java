package kr.ac.cnu.computer.lab06;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int current_progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setIndeterminate(false);
        progressBar.setMax(100);
        progressBar.setProgress(current_progress);
        Button p_button = findViewById(R.id.progress_button);
        p_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress_dialog(view);
            }
        });
    }

    public void progress_dialog(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("어느 방향으로 진행하시겠습니까?");
        alertDialogBuilder.setPositiveButton("앞으로", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                if (current_progress <= 90){
                    progressBar.incrementProgressBy(10);
                    current_progress = progressBar.getProgress();
                    Toast.makeText(MainActivity.this,
                            current_progress+"% 진행되었습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "더 이상 진행할 수 없습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        alertDialogBuilder.setNegativeButton("뒤로", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (current_progress >= 10){
                    progressBar.incrementProgressBy(-10);
                    current_progress = progressBar.getProgress();
                    Toast.makeText(MainActivity.this,
                            current_progress+"% 진행되었습니다.",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this,
                            "더 이상 역행할 수 없습니다.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        alertDialogBuilder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),
                        "현재 진행율: "+current_progress+"%", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}