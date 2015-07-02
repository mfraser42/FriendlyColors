package com.crimson.friendlycolors.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crimson.friendlycolors.R;
import com.crimson.friendlycolors.model.FriendlyData;
import com.crimson.friendlycolors.model.Scheme;
import com.parse.ParseObject;


public class FriendlyActivity extends Activity {

    public static final String TAG = FriendlyActivity.class.getSimpleName();

    private RelativeLayout mRL;
    private TextView mTextView;
    private Button mButton1;
    private Button mButton2;

    private FriendlyData mFriendlyData = new FriendlyData();
    private String mName;
    private String bgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendly);

        mRL = (RelativeLayout) findViewById(R.id.friendlyRL);
        mTextView = (TextView) findViewById(R.id.friendlyTV);
        mButton1 = (Button) findViewById(R.id.friendlyButton1);
        mButton2 = (Button) findViewById(R.id.friendlyButton2);

        Intent intent = getIntent();
        mName = intent.getStringExtra("name");
        bgColor = intent.getStringExtra("bg");

        if ( mName == null ) {
            mName = "Friend";
        }
        if (bgColor == null ) {
            bgColor = "white";
        }
        loadScreen();
    }

    private void loadScreen() {

        Scheme colorScheme = mFriendlyData.getColorScheme(bgColor);
        int bgColorNum = colorScheme.getBgColorNum();
        int textColorNum = colorScheme.getTextColor();

        mTextView.setText(String.format(mFriendlyData.getRandomText(), mName));
        mRL.setBackgroundColor(bgColorNum);
        mTextView.setTextColor(textColorNum);
        mButton1.setBackgroundColor(bgColorNum);
        mButton2.setBackgroundColor(bgColorNum);
        mButton1.setTextColor(textColorNum);
        mButton2.setTextColor(textColorNum);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                again();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void again() {
        mTextView.setText(String.format(mFriendlyData.getRandomText(), mName));
    }

}
