package com.ngtkn.colorpickerapp;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.margaritov.preference.colorpicker.ColorPickerDialog;

public class MainActivity extends AppCompatActivity {

    Button button;
    ConstraintLayout layout;
    TextView textView;
    int color;

    ColorPickerDialog pickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        layout = findViewById(R.id.layout);
        textView = findViewById(R.id.textView);

        color = Color.parseColor("#005500");
        pickerDialog = new ColorPickerDialog(MainActivity.this, color);
        pickerDialog.setAlphaSliderVisible(true);
        pickerDialog.setTitle("Color Picker");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickerDialog.setOnColorChangedListener(new ColorPickerDialog.OnColorChangedListener() {
                    @Override
                    public void onColorChanged(int color) {
                        layout.setBackgroundColor(color);
                        textView.setText(Integer.toHexString(color));
                    }
                });
                pickerDialog.show();
            }
        });

    }
}
