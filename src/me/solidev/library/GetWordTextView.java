package me.solidev.library;

import java.util.List;

import me.solidev.getwordtextview.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by _SOLID
 * Date:2016/11/9
 * Time:11:02
 * <p>
 * Desc:A TextView that can get every word in content.
 * </p>
 */

public class GetWordTextView extends TextView {

    private CharSequence mText;
    private BufferType mBufferType;

    private OnWordClickListener mOnWordClickListener;
    private SpannableString mSpannableString;

    private BackgroundColorSpan mSelectedBackSpan;
    private ForegroundColorSpan mSelectedForeSpan;

    private int highlightColor;
    private String highlightText;
    private int selectedColor;
    private int language;//0:english,1:chinese

    public GetWordTextView(Context context) {
        this(context, null);
    }

    public GetWordTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GetWordTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.GetWordTextView);
        highlightColor = ta.getColor(R.styleable.GetWordTextView_highlightColor, Color.RED);
        highlightText = ta.getString(R.styleable.GetWordTextView_highlightText);
        Log.i("TAG","highlightText==="+highlightText);
        selectedColor = ta.getColor(R.styleable.GetWordTextView_selectedColor, Color.BLUE);
        language = ta.getInt(R.styleable.GetWordTextView_language, 0);
        ta.recycle();
    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        this.mText = text;
        mBufferType = type;
        setHighlightColor(Color.TRANSPARENT);
        setMovementMethod(LinkMovementMethod.getInstance());
        setText();
    }

    private void setText() {
    	mSpannableString = new SpannableString(mText);
        //set highlight text
        setHighLightSpan(mSpannableString);
        //separate word
        if (language == 0) {//deal english
            dealEnglish();
        } else {//deal chinese
            dealChinese();
        }
        super.setText(mSpannableString, mBufferType);

    }
//把每个中文处理出来
    private void dealChinese() {
        for (int i = 0; i < mText.length(); i++) {
            char ch = mText.charAt(i);
            Log.i("TAG","dealChinese==ch=="+ch);
            if (Utils.isChinese(ch)) {
                mSpannableString.setSpan(getClickableSpan(), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }
  //把每个英文处理出来
    private void dealEnglish() {
        List<WordInfo> wordInfoList = Utils.getEnglishWordIndices(mText.toString());
        for (WordInfo wordInfo : wordInfoList) {
        	 Log.i("TAG","dealEnglish==wordInfo=="+wordInfo.getStart());
            mSpannableString.setSpan(getClickableSpan(), wordInfo.getStart(), wordInfo.getEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        }
    }


    private void setHighLightSpan(SpannableString spannableString) {
        if (TextUtils.isEmpty(highlightText)) {
            return;
        }
        int hIndex = mText.toString().indexOf(highlightText);
        Log.i("TAG","hIndex==="+hIndex);
        while (hIndex != -1) {
            spannableString.setSpan(new ForegroundColorSpan(highlightColor), hIndex, hIndex + highlightText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            hIndex += highlightText.length();
            hIndex = mText.toString().indexOf(highlightText, hIndex);
        }
    }

    private void setSelectedSpan(TextView tv) {
        if (mSelectedBackSpan == null || mSelectedForeSpan == null) {
            mSelectedBackSpan = new BackgroundColorSpan(selectedColor);
            mSelectedForeSpan = new ForegroundColorSpan(Color.WHITE);
        } else {
            mSpannableString.removeSpan(mSelectedBackSpan);
            mSpannableString.removeSpan(mSelectedForeSpan);
        }
        mSpannableString.setSpan(mSelectedBackSpan, tv.getSelectionStart(), tv.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSpannableString.setSpan(mSelectedForeSpan, tv.getSelectionStart(), tv.getSelectionEnd(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        GetWordTextView.super.setText(mSpannableString, mBufferType);
    }

    public void dismissSelected() {
        mSpannableString.removeSpan(mSelectedBackSpan);
        mSpannableString.removeSpan(mSelectedForeSpan);
        GetWordTextView.super.setText(mSpannableString, mBufferType);
    }

    private ClickableSpan getClickableSpan() {
        return new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                TextView tv = (TextView) widget;
                String word = tv
                        .getText()
                        .subSequence(tv.getSelectionStart(),
                                tv.getSelectionEnd()).toString();
                setSelectedSpan(tv);

                if (mOnWordClickListener != null) {
                    mOnWordClickListener.onClick(word);
                }
            }

            @Override
            public void updateDrawState(TextPaint ds) {
            }
        };
    }


    public void setOnWordClickListener(OnWordClickListener listener) {
        this.mOnWordClickListener = listener;
    }

    public void setHighLightText(String text) {
        highlightText = text;
    }

    public void setHighLightColor(int color) {
        highlightColor = color;
    }

    public interface OnWordClickListener {
        void onClick(String word);
    }
}
