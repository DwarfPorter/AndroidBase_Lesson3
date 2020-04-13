package ru.geekbrains.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("ON Start");
    }



    private void makeToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
