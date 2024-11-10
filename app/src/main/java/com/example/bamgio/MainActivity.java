package com.example.bamgio;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtgio;
    Button btngio;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtgio = findViewById(R.id.txtgio);
        btngio = findViewById(R.id.btngio);

        btngio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer = new CountDownTimer(10000, 1000) {
                    int x=9;
                    @Override
                    public void onTick(long millisUntilFinished) {
                        txtgio.setText(x+" ");
                        x--;
                    }

                    @Override
                    public void onFinish() {
                        Toast toast = Toast.makeText(MainActivity.this, "Hết giờ!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                };
                countDownTimer.start();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}