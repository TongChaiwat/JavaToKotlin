package com.example.javatokotlin.javaCode;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.javatokotlin.R;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button resetButton;
    Button countButton;
    Button randomButton;
    TextView numberTextView;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.constraintLayout);
        resetButton = findViewById(R.id.resetButton);
        countButton = findViewById(R.id.countButton);
        randomButton = findViewById(R.id.randomButton);
        numberTextView = findViewById(R.id.numberTextView);

        initUi();
    }

    private void initUi() {
        numberTextView.setText("0");

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countMe(numberTextView);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberTextView.setText("0");
                updateBackgroundColor(0);
            }
        });

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer randomInt = randomInt(50);
                numberTextView.setText(randomInt.toString());
                updateBackgroundColor(randomInt);
            }
        });
    }

    private Integer randomInt(Integer maximum) {
        Random random = new Random();
        return random.nextInt(maximum) + 1;
    }

    private void countMe(TextView textView) {
        String countString = textView.getText().toString();
        Integer count = Integer.parseInt(countString);
        count++;
        updateBackgroundColor(count);
        textView.setText(count.toString());
    }

    private void updateBackgroundColor(Integer number) {
        Resources resource = getResources();
        Integer colorRes;
        if (number > 0 && number <= 10) {
            colorRes = resource.getColor(android.R.color.holo_red_dark);
        } else if (number > 10 && number <= 20) {
            colorRes = resource.getColor(android.R.color.holo_green_dark);
        } else if (number > 20 && number <= 30) {
            colorRes = resource.getColor(android.R.color.holo_blue_dark);
        } else if (number > 30 && number <= 40) {
            colorRes = resource.getColor(android.R.color.holo_orange_dark);
        } else if (number > 40 && number <= 50) {
            colorRes = resource.getColor(android.R.color.holo_purple);
        } else {
            colorRes = resource.getColor(android.R.color.black);
        }
        layout.setBackgroundColor(colorRes);
    }

}