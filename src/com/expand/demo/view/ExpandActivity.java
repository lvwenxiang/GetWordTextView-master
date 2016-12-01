package com.expand.demo.view;

import me.solidev.getwordtextview.R;
import android.app.Activity;
import android.os.Bundle;

public class ExpandActivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);
        String text = getString(R.string.tips);

        TextViewExpandableAnimation tvExpand = (TextViewExpandableAnimation) findViewById(R.id.tv_expand);
        tvExpand.setText(text + text + text + text);
        TextViewExpandableAnimation tvExpand1 = (TextViewExpandableAnimation) findViewById(R.id.tv_expand1);
        tvExpand1.setText(text + text + text + text);
    }
}
