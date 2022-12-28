package kr.ac.cnu.computer.lab11a;

import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    String databaseName = "example.db";
    String tableName = "directory";
    EditText nameEdit;
    EditText phoneEdit;
    int count = 0;
    SQLiteDatabase database;
    RecyclerView recyclerView;
//    PersonAdapter apater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}