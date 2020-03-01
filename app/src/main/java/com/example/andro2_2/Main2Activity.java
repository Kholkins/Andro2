package com.example.andro2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar sbWeight;
    private Button btn1;
    private Button btn2;

    private LinearLayout.LayoutParams lParams1;
    private LinearLayout.LayoutParams lParams2;

    // константы для ID пунктов меню
    private final int MENU_ALPHA_ID = 1;
    private final int MENU_SCALE_ID = 2;
    private final int MENU_TRANSLATE_ID = 3;
    private final int MENU_ROTATE_ID = 4;
    private final int MENU_COMBO_ID = 5;

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        sbWeight.setOnSeekBarChangeListener(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();

        tv = (TextView) findViewById(R.id.tv);
        // регистрируем контекстное меню для компонента tv
        registerForContextMenu(tv);
    }

    public void goBack (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int leftValue = progress;
        int rightValue = seekBar.getMax() - progress;
        // настраиваем вес
        lParams1.weight = leftValue;
        lParams2.weight = rightValue;
        // в текст кнопок пишем значения переменных
        btn1.setText(String.valueOf(leftValue));
        btn2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.tv:
                // добавляем пункты
                menu.add(0, MENU_ALPHA_ID, 0, "alpha");
                menu.add(0, MENU_SCALE_ID, 0, "scale");
                menu.add(0, MENU_TRANSLATE_ID, 0, "translate");
                menu.add(0, MENU_ROTATE_ID, 0, "rotate");
                menu.add(0, MENU_COMBO_ID, 0, "combo");
                break;
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }


}
