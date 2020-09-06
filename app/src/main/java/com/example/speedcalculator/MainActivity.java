package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button clear_button = findViewById(R.id.clear_button);
        Button  calculate_button = findViewById(R.id.calculate_button);
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_enter_distance_meter = findViewById(R.id.editText_enter_distanace_meter);
                EditText editText_enter_time_second = findViewById(R.id.editText_enter_time_second);
                String distanceText = editText_enter_distance_meter.getText().toString();
                String timeText = editText_enter_time_second.getText().toString();
                TextView answer_text = findViewById(R.id.answer_editText);
                if(distanceText!=null && !distanceText.isEmpty() && timeText !=null && !timeText.isEmpty()){
                    Double distance = Double.parseDouble(distanceText);
                    Double time  = Double.parseDouble(timeText);
                    Double answer_1 = (distance/time)*3.6;
                    String str = String.format(
                            Locale.getDefault(), "%.2f",answer_1
                    );
                    if (time==0){
                        String msg = getString(R.string.time_must_be_greater_than_zero);
                        Toast t = Toast.makeText(
                                MainActivity.this,
                                msg, Toast.LENGTH_LONG
                        );
                        t.show();

                    }else {
                    if(answer_1 > 80){
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("SPEED CALCULATOR");
                        dialog.setMessage("Speed is over limit");
                        dialog.setPositiveButton("ok", null);
                        dialog.show();
                    }
                    answer_text.setText(str);
                    }
                }
                else {
                    String msg = getString(R.string.request_distance);
                    Toast t = Toast.makeText(
                            MainActivity.this,
                            msg, Toast.LENGTH_LONG
                    );
                    t.show();
                }

            }
        });
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_enter_distance_meter = findViewById(R.id.editText_enter_distanace_meter);
                EditText editText_enter_time_second = findViewById(R.id.editText_enter_time_second);
                editText_enter_distance_meter.setText(null);
                editText_enter_time_second.setText(null);
            }
        });
    }
}