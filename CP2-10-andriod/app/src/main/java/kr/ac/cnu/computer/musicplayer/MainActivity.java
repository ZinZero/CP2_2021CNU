package kr.ac.cnu.computer.musicplayer;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int music;
    TextView titleView;
    ImageButton playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();

        }else{
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        music = soundPool.load(this, R.raw.old_pop, 1);

        // 음악 제목
//        titleView = findViewById(R.id.titleView);
//        // 음악 탐색바
//        SeekBar seekBar = findViewById(R.id.seekBar);
//
//        // Play 버튼. 다시 누르면 Pause 버튼으로 변경
//        playButton = findViewById(R.id.playButton);

        // MediaPlayer 음악 재생 관련 객체

    }



    public void playSound(View v){
        switch (v.getId()){
            case R.id.rewindButton:

            case R.id.playButton:
                soundPool.play(1, 1, 1, 0, 0, 1);
                break;
            case R.id.forwardButton:

        }
    }
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}