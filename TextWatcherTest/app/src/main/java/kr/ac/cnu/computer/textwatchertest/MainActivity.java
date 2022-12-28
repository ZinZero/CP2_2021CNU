package kr.ac.cnu.computer.textwatchertest;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TextWatcher";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "CharSequence: " + s + ", start: " + start + ", count: " + count + ", after: " + after);
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "CharSequence: " + s + ", start: " + start + ", before: " + ", count: " + count);
            }
            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "Editable: " + s.toString());
            }
        });
    }
}