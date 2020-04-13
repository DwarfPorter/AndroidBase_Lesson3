package ru.geekbrains.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String COUNTER = "COUNTER";
    private static final String LIFECYCLE = "LIFE_CYCLE";

    private int counter = 0;

    private EditText etext;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            makeToast("Первый запуск!");
        }
        else{
            makeToast("Повторный запуск!");
        }

        etext = findViewById(R.id.editText);
        text = findViewById(R.id.textView);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                setTexts();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeToast("ON Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("ON Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("ON Stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("ON restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("ON Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("ON Start");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        makeToast("Повторный запуск onRestoreInstanceState");
        counter = savedInstanceState.getInt(COUNTER);
        setTexts();
    }

    private void setTexts() {
        etext.setText(((Integer) counter).toString());
        text.setText(((Integer) counter).toString());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        makeToast("Сохранение данных onSaveInstanceState");
        outState.putInt(COUNTER, counter);
    }

    private void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(LIFECYCLE, message);
    }
}
