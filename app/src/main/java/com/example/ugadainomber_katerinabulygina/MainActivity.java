package com.example.ugadainomber_katerinabulygina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Переменные
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int guess;
    boolean gameFinished;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Связываем наши переменные
        tvInfo = (TextView) findViewById(R.id.textView2);
        etInput = (EditText) findViewById(R.id.editText);
        bControl = (Button) findViewById(R.id.button2);

        guess = (int) (Math.random() * 100);
        gameFinished = false;

    }

    public void onClick(View v) {

        if (!gameFinished) {
            String strInp = etInput.getText().toString();
            if (strInp!= null && !strInp.isEmpty()) {
                int inp = Integer.parseInt(etInput.getText().toString());
                if (0 <= inp && 101 > inp) {
                    if (guess > inp)
                        tvInfo.setText(getResources().getString(R.string.behind));
                    if (guess < inp)
                        tvInfo.setText(getResources().getString(R.string.ahead));
                    if (guess == inp) {
                        tvInfo.setText(getResources().getString(R.string.hit));
                        bControl.setText(getResources().getString(R.string.play_more));
                        gameFinished = true;
                    }
                }else {
                    tvInfo.setText(getResources().getString(R.string.try_to_guess_range));
                }

            }else {
                tvInfo.setText(getResources().getString(R.string.input_number));
            }
        } else {
            guess = (int) (Math.random() * 100);
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            etInput.setText("");
            bControl.setText(getResources().getString(R.string.input_value));
            gameFinished = false;
        }
    }
}