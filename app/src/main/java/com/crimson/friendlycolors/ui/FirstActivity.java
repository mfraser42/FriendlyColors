package com.crimson.friendlycolors.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.crimson.friendlycolors.R;


public class FirstActivity extends Activity {

    private EditText mColorField;
    private EditText mNameField;
    private Button mButton;
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mColorField = (EditText) findViewById(R.id.colorET);
        mNameField = (EditText) findViewById(R.id.nameET);
        mButton = (Button) findViewById(R.id.startButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String color = mColorField.getText().toString();
                String name = mNameField.getText().toString();
                if ((name.length() == 0 ) || (color.length() == 0)){
                    Toast.makeText(FirstActivity.this, "Please enter your name and one of the following colors to continue: red, blue, yellow, green, black, pink, mint or white.", Toast.LENGTH_LONG).show();
                } else {
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    int colorCheck = checkColor(color);
                    if (colorCheck == -7) {
                        Toast.makeText(FirstActivity.this, "That's not an available color, pick: red, blue, yellow, green, black, pink, mint or white.", Toast.LENGTH_LONG).show();
                    } else {
                        startStory(name, color);
                    }
                }
            }
        });
    }

    private int checkColor(String color) {
        String[] colors = {"red", "blue", "yellow", "green", "white", "black", "mint", "pink"};

        int check = -7;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equalsIgnoreCase(color)) {
                check = 1;
                return check;
            }
        }
        return check;
    }

    private void startStory(String name, String bgColor) {
        Intent intent = new Intent(this, FriendlyActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("bg", bgColor);
        startActivity(intent);
    }
}
