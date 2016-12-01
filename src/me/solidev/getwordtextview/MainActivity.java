package me.solidev.getwordtextview;

import me.solidev.library.GetWordTextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	 private GetWordTextView mEnglishGetWordTextView;
	    private GetWordTextView mChineseGetWordTextView;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        mEnglishGetWordTextView = (GetWordTextView) findViewById(R.id.english_get_word_text_view);
	        //mEnglishGetWordTextView.setText("A view that can get every word inside,it's very helpful view!");
	         mEnglishGetWordTextView.setText("\"Oh,that, yes,\" she said, \"would you please show me how to use the TV?");
	        mEnglishGetWordTextView.setOnWordClickListener(new GetWordTextView.OnWordClickListener() {
	            @Override
	            public void onClick(String word) {
	                showToast(word);
	            }
	        });

	        mChineseGetWordTextView = (GetWordTextView) findViewById(R.id.chinese_get_word_text_view);
	        mChineseGetWordTextView.setText("����һ�����ľ��ӵ����ӣ�����һ�����ľ��ӵ����ӡ�");
	        mChineseGetWordTextView.setOnWordClickListener(new GetWordTextView.OnWordClickListener() {
	            @Override
	            public void onClick(String word) {
	                showToast(word);
	            }
	        });
	        findViewById(R.id.btn_dismiss_selected).setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                mEnglishGetWordTextView.dismissSelected();
	                mChineseGetWordTextView.dismissSelected();
	            }
	        });
	    }

	    Toast toast;

	    public void showToast(String msg) {
	        if (toast == null) {
	            toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
	        }
	        toast.setText(msg);
	        toast.show();
	    }

}
