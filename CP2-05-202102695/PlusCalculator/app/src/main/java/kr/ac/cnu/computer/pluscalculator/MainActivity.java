package kr.ac.cnu.computer.pluscalculator;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int flag = 0;
    String a = "";
    String b = "";
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView processView = (TextView) findViewById(R.id.process);
        TextView resultView = (TextView) findViewById(R.id.result);

        Button onebutton = (Button) findViewById(R.id.one);
        onebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "1";
                }else {
                    b += "1";
                }
                processView.append("1");
            }
        });

        Button twobutton = (Button) findViewById(R.id.two);
        twobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "2";
                }else {
                    b += "2";
                }
                processView.append("2");
            }
        });

        Button threebutton = (Button) findViewById(R.id.three);
        threebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "3";
                }else {
                    b += "3";
                }
                processView.append("3");
            }
        });

        Button fourbutton = (Button) findViewById(R.id.four);
        fourbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "4";
                }else {
                    b += "4";
                }
                processView.append("4");
            }
        });

        Button fivebutton = (Button) findViewById(R.id.five);
        fivebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "5";
                }else {
                    b += "5";
                }
                processView.append("5");
            }
        });

        Button sixbutton = (Button) findViewById(R.id.six);
        sixbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "6";
                }else {
                    b += "6";
                }
                processView.append("6");
            }
        });

        Button sevenbutton = (Button) findViewById(R.id.seven);
        sevenbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "7";
                }else {
                    b += "7";
                }
                processView.append("7");
            }
        });

        Button eightbutton = (Button) findViewById(R.id.eight);
        eightbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "8";
                }else {
                    b += "8";
                }
                processView.append("8");
            }
        });

        Button ninebutton = (Button) findViewById(R.id.nine);
        ninebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "9";
                }else {
                    b += "9";
                }
                processView.append("9");
            }
        });

        Button zerobutton = (Button) findViewById(R.id.zero);
        zerobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag == 0){
                    a += "0";
                }else{
                    b += "0";
                }
                processView.append("0");
            }
        });

        Button plusbutton = (Button) findViewById(R.id.plus);
        plusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 1;
                processView.append("+");
                if (!b.equals("")){
                    a = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
                    b = "";
                    resultView.setText(a);
                }

            }
        });

        Button equalbutton = (Button) findViewById(R.id.equal);
        equalbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = Integer.parseInt(a) + Integer.parseInt(b);
                TextView resultView = (TextView) findViewById(R.id.result);
                resultView.setText(Integer.toString(result));
                processView.setText("");
            }
        });

        Button clearbutton = (Button) findViewById(R.id.clear);
        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 0;
                result = 0;
                resultView.setText(Integer.toString(result));
                TextView processView = (TextView) findViewById(R.id.process);
                processView.setText("");
                a = "";
                b = "";
            }
        });
    }
}
