package com.expand.demo.view;

import me.solidev.getwordtextview.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextViewExpandableAnimation extends LinearLayout implements
		OnClickListener {

	/**
	 * TextView
	 */
	private TextView textView;

	/**
	 * ����/ȫ��TextView <br>
	 * shrink/expand TextView
	 */
	private TextView tvState;

	/**
	 * ��������۵�/չ����ͼƬ <br>
	 * shrink/expand icon
	 */
	private ImageView ivExpandOrShrink;

	/**
	 * �ײ��Ƿ��۵�/����ĸ��಼�� <br>
	 * shrink/expand layout parent
	 */
	private RelativeLayout rlToggleLayout;

	/**
	 * ��ʾ�۵���ͼƬ��Դ <br>
	 * shrink drawable
	 */
	private Drawable drawableShrink;
	/**
	 * ��ʾ��ʾȫ����ͼƬ��Դ <br>
	 * expand drawable
	 */
	private Drawable drawableExpand;

	/**
	 * ȫ��/�����ı���������ɫ <br>
	 * color of shrink/expand text
	 */
	private int textViewStateColor;
	/**
	 * չ����ʾ�ı� <br>
	 * expand text
	 */
	private String textExpand;
	/**
	 * ������ʾ�ı� <br>
	 * shrink text
	 */
	private String textShrink;

	/**
	 * �Ƿ��۵���ʾ�ı�ʾ <br>
	 * flag of shrink/expand
	 */
	private boolean isShrink = false;

	/**
	 * �Ƿ���Ҫ�۵��ı�ʾ <br>
	 * flag of expand needed
	 */
	private boolean isExpandNeeded = false;

	/**
	 * �Ƿ��ʼ��TextView <br>
	 * flag of TextView Initialization
	 */
	private boolean isInitTextView = true;

	/**
	 * �۵���ʾ������ <br>
	 * number of lines to expand
	 */
	private int expandLines;

	/**
	 * �ı������� <br>
	 * Original number of lines
	 */
	private int textLines;

	/**
	 * ��ʾ���ı� <br>
	 * content text
	 */
	private CharSequence textContent;

	/**
	 * ��ʾ���ı���ɫ <br>
	 * content color
	 */
	private int textContentColor;

	/**
	 * ��ʾ���ı������С <br>
	 * content text size
	 */
	private float textContentSize;

	/**
	 * �����߳� <br>
	 * thread
	 */
	private Thread thread;

	/**
	 * �������ȼ�� <br>
	 * animation interval
	 */
	private int sleepTime = 22;

	/**
	 * handler�ź� <br>
	 * handler signal
	 */
	private final int WHAT = 2;
	/**
	 * ���������ź� <br>
	 * animation end signal of handler
	 */
	private final int WHAT_ANIMATION_END = 3;

	/**
	 * ����������ֻ�Ǹı�ͼ�꣬�������� <br>
	 * animation end and expand only,but not disappear
	 */
	private final int WHAT_EXPAND_ONLY = 4;

	public TextViewExpandableAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
		initValue(context, attrs);
		initView(context);
		initClick();
	}

	private void initValue(Context context, AttributeSet attrs) {
		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.TextViewExpandableAnimation);

		expandLines = ta.getInteger(
				R.styleable.TextViewExpandableAnimation_tvea_expandLines, 5);

		drawableShrink = ta
				.getDrawable(R.styleable.TextViewExpandableAnimation_tvea_shrinkBitmap);
		drawableExpand = ta
				.getDrawable(R.styleable.TextViewExpandableAnimation_tvea_expandBitmap);

		textViewStateColor = ta.getColor(
				R.styleable.TextViewExpandableAnimation_tvea_textStateColor,
				getResources().getColor(R.color.colorPrimary));

		textShrink = ta
				.getString(R.styleable.TextViewExpandableAnimation_tvea_textShrink);
		textExpand = ta
				.getString(R.styleable.TextViewExpandableAnimation_tvea_textExpand);

		if (null == drawableShrink) {
			drawableShrink = getResources().getDrawable(
					R.drawable.icon_green_arrow_up);
		}

		if (null == drawableExpand) {
			drawableExpand = getResources().getDrawable(
					R.drawable.icon_green_arrow_down);
		}

		if (TextUtils.isEmpty(textShrink)) {
			textShrink = context.getString(R.string.shrink);
		}

		if (TextUtils.isEmpty(textExpand)) {
			textExpand = context.getString(R.string.expand);
		}

		textContentColor = ta.getColor(
				R.styleable.TextViewExpandableAnimation_tvea_textContentColor,
				getResources().getColor(
						R.color.color_gray_light_content_text));
		textContentSize = ta.getDimension(
				R.styleable.TextViewExpandableAnimation_tvea_textContentSize,
				14);

		ta.recycle();
	}

	private void initView(Context context) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.layout_textview_expand_animation, this);

		rlToggleLayout = (RelativeLayout) findViewById(R.id.rl_expand_text_view_animation_toggle_layout);

		textView = (TextView) findViewById(R.id.tv_expand_text_view_animation);
		textView.setTextColor(textContentColor);
		textView.getPaint().setTextSize(textContentSize);

		ivExpandOrShrink = (ImageView) findViewById(R.id.iv_expand_text_view_animation_toggle);

		tvState = (TextView) findViewById(R.id.tv_expand_text_view_animation_hint);
		tvState.setTextColor(textViewStateColor);

	}

	private void initClick() {
		textView.setOnClickListener(this);
		rlToggleLayout.setOnClickListener(this);
	}

	public void setText(CharSequence charSequence) {

		textContent = charSequence;

		textView.setText(charSequence.toString());

		ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
		viewTreeObserver.addOnPreDrawListener(new OnPreDrawListener() {

			@Override
			public boolean onPreDraw() {
				if (!isInitTextView) {
					return true;
				}
				textLines = textView.getLineCount();
				isExpandNeeded = textLines > expandLines;
				isInitTextView = false;
				if (isExpandNeeded) {
					isShrink = true;
					doAnimation(textLines, expandLines, WHAT_ANIMATION_END);
				} else {
					isShrink = false;
					doNotExpand();
				}
				return true;
			}
		});

	}

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (WHAT == msg.what) {
				textView.setMaxLines(msg.arg1);
				textView.invalidate();
			} else if (WHAT_ANIMATION_END == msg.what) {
				setExpandState(msg.arg1);
			} else if (WHAT_EXPAND_ONLY == msg.what) {
				changeExpandState(msg.arg1);
			}
			super.handleMessage(msg);
		}

	};

	/**
	 * @param startIndex
	 *            ��ʼ������������� <br>
	 *            start index of animation
	 * @param endIndex
	 *            �����������յ����� <br>
	 *            end index of animation
	 * @param what
	 *            �����������handler�źű�ʾ <br>
	 *            signal of animation end
	 */
	private void doAnimation(final int startIndex, final int endIndex,
			final int what) {

		thread = new Thread(new Runnable() {

			@Override
			public void run() {

				if (startIndex < endIndex) {
					// �����ֹ����С�ڽ�����������ô����չ������������
					// if start index smaller than end index ,do expand action
					int count = startIndex;
					while (count++ < endIndex) {
						Message msg = handler.obtainMessage(WHAT, count, 0);

						try {
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						handler.sendMessage(msg);
					}
				} else if (startIndex > endIndex) {
					// �����ֹ�������ڽ�����������ô�����۵�����������
					// if start index bigger than end index ,do shrink action
					int count = startIndex;
					while (count-- > endIndex) {
						Message msg = handler.obtainMessage(WHAT, count, 0);
						try {
							Thread.sleep(sleepTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						handler.sendMessage(msg);
					}
				}

				// �����������ͽ������ź�
				// animation end,send signal
				Message msg = handler.obtainMessage(what, endIndex, 0);
				handler.sendMessage(msg);

			}

		});

		thread.start();

	}

	/**
	 * �ı��۵�״̬�������ı��۵���չ��״̬�����������۵�/չ��ͼƬ���֣� change shrink/expand state(only change
	 * state,but not hide shrink/expand icon)
	 * 
	 * @param endIndex
	 */
	@SuppressWarnings("deprecation")
	private void changeExpandState(int endIndex) {
		rlToggleLayout.setVisibility(View.VISIBLE);
		if (endIndex < textLines) {
			ivExpandOrShrink.setBackgroundDrawable(drawableExpand);
			tvState.setText(textExpand);
		} else {
			ivExpandOrShrink.setBackgroundDrawable(drawableShrink);
			tvState.setText(textShrink);
		}

	}

	/**
	 * �����۵�״̬������۵������趨�����ı���������ô�۵�/չ��ͼƬ���ֽ�������,�ı���һֱ����չ��״̬�� change shrink/expand
	 * state(if number of expand lines bigger than original text lines,hide
	 * shrink/expand icon,and TextView will always be at expand state)
	 * 
	 * @param endIndex
	 */
	@SuppressWarnings("deprecation")
	private void setExpandState(int endIndex) {

		if (endIndex < textLines) {
			isShrink = true;
			rlToggleLayout.setVisibility(View.VISIBLE);
			ivExpandOrShrink.setBackgroundDrawable(drawableExpand);
			textView.setOnClickListener(this);
			tvState.setText(textExpand);
		} else {
			isShrink = false;
			rlToggleLayout.setVisibility(View.GONE);
			ivExpandOrShrink.setBackgroundDrawable(drawableShrink);
			textView.setOnClickListener(null);
			tvState.setText(textShrink);
		}

	}

	/**
	 * �����۵� do not expand
	 */
	private void doNotExpand() {
		textView.setMaxLines(expandLines);
		rlToggleLayout.setVisibility(View.GONE);
		textView.setOnClickListener(null);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.rl_expand_text_view_animation_toggle_layout
				|| v.getId() == R.id.tv_expand_text_view_animation) {
			clickImageToggle();
		}

	}

	private void clickImageToggle() {
		if (isShrink) {
			// ������Ѿ��۵�����ô���з��۵�����
			// do shrink action
			doAnimation(expandLines, textLines, WHAT_EXPAND_ONLY);
		} else {
			// ����Ƿ��۵�����ô�����۵�����
			// do expand action
			doAnimation(textLines, expandLines, WHAT_EXPAND_ONLY);
		}

		// �л�״̬
		// set flag
		isShrink = !isShrink;
	}

	public Drawable getDrawableShrink() {
		return drawableShrink;
	}

	public void setDrawableShrink(Drawable drawableShrink) {
		this.drawableShrink = drawableShrink;
	}

	public Drawable getDrawableExpand() {
		return drawableExpand;
	}

	public void setDrawableExpand(Drawable drawableExpand) {
		this.drawableExpand = drawableExpand;
	}

	public int getExpandLines() {
		return expandLines;
	}

	public void setExpandLines(int newExpandLines) {
		int start = isShrink ? this.expandLines : textLines;
		int end = textLines < newExpandLines ? textLines : newExpandLines;
		doAnimation(start, end, WHAT_ANIMATION_END);
		this.expandLines = newExpandLines;
	}

	/**
	 * ȡ����ʾ���ı����� get content text
	 * 
	 * @return content text
	 */
	public CharSequence getTextContent() {
		return textContent;
	}

	public int getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
	}

}