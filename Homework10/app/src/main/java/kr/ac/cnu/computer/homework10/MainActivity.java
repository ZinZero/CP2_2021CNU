package kr.ac.cnu.computer.homework10;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    TextView titleView;
    ImageButton playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 음악 제목
        titleView = findViewById(R.id.titleView);
        // 음악 탐색바
        SeekBar seekBar = findViewById(R.id.seekBar);

        // Play 버튼. 다시 누르면 Pause 버튼으로 변경
        playButton = findViewById(R.id.playButton);

        // MediaPlayer 음악 재생 관련 객체
        player = MediaPlayer.create(this, R.raw.old_pop);

    }

    /**
     * 이 버튼을 누르면 현재 위치에서 5초 뒤로 이동한다.
     * @param view
     */
    public void rewindAction(View view) {
        player.seekTo(player.getCurrentPosition() - 5000);
    }

    /**
     * 재생 중이 아니면 음악을 재생하고, 재생중이면 음악을 중지한다.
     * @param view
     */
    public void playAction(View view) {
        if (!player.isPlaying()) {
            player.start();
            playButton.setImageResource(R.drawable.ic_pause);
        } else {
            player.pause();
            playButton.setImageResource(R.drawable.ic_play_arrow);
        }
    }

    /**
     * 이 버튼을 누르면 현재 위치에서 5초 앞으로 이동한다.
     * @param view
     */
    public void forwardAction(View view) {
        player.seekTo(player.getCurrentPosition() + 5000);
    }

}