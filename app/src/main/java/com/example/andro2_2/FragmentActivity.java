package com.example.andro2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FragmentActivity extends androidx.fragment.app.FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    public void goTo2Activity (View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
