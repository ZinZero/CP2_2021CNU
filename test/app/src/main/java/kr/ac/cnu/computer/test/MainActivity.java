package kr.ac.cnu.computer.test;

import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView resultView;
    ImageButton playButton;
    boolean oneFlag = false;
    boolean twoFlag = false;
    boolean threeFlag = false;
    int seekBarMax = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = findViewById(R.id.resultView);
        seekBar = findViewById(R.id.seekBar);
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!oneFlag) {
                    twoFlag = true;
                    oneFlag = true;
                } else {
                    twoFlag = false;
                    oneFlag = false;
                }
                playAction(v);

                seekBarThread th = new seekBarThread();
                th.start();

            }
        });

        seekBar.setMax(seekBarMax);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                resultView.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  }
        });
    }


    public void rewindAction(View view) {
        seekBar.setProgress(seekBar.getProgress() - 5);
        resultView.setText(String.valueOf(seekBar.getProgress()));
    }


    public void playAction(View view) {
        if (twoFlag) {
            threeFlag = true;
            playButton.setImageResource(R.drawable.ic_pause);
        } else {
            threeFlag = false;
            playButton.setImageResource(R.drawable.ic_play_arrow);
        }
    }

    public void forwardAction(View view) {
        seekBar.setProgress(seekBar.getProgress() + 5);
        resultView.setText(String.valueOf(seekBar.getProgress()));
    }

    class seekBarThread extends Thread{
        public void run(){
            while (threeFlag) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                seekBar.setProgress(seekBar.getProgress() + 1);
            }
        }
    }
}