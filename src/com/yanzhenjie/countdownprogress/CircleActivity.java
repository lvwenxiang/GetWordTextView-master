/**
 * 
 */
package com.yanzhenjie.countdownprogress;

import me.solidev.getwordtextview.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @author wenxiang.lv
 *
 */
public class CircleActivity extends Activity {
	  /**
     * Ĭ�����͡�
     */
    private CircleTextProgressbar mTvDefault;
    /**
     * ����ֵġ�
     */
    private CircleTextProgressbar mTvFive;
    /**
     * Բ�ĵ����ɫ��
     */
    private CircleTextProgressbar mTvCicleColor;

    /**
     * ˳����������
     */
    private CircleTextProgressbar mTvCount;
    /**
     * ���������
     */
    private CircleTextProgressbar mTvWide;
    /**
     * խ��������
     */
    private CircleTextProgressbar mTvNarrow;
    /**
     * ��ɫ��������
     */
    private CircleTextProgressbar mTvRedPro;
    /**
     * ��ɫ�߿�
     */
    private CircleTextProgressbar mTvRedFrame;
    /**
     * ��ɫԲ�ġ�
     */
    private CircleTextProgressbar mTvRedCircle;
    /**
     * ������
     */
    private CircleTextProgressbar mTvSkip;
    /**
     * ���½��������֡�
     */
    private CircleTextProgressbar mTvProgressBar1, mTvProgressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        mTvDefault = (CircleTextProgressbar) findViewById(R.id.tv_default);
        mTvFive = (CircleTextProgressbar) findViewById(R.id.tv_five_text);
        mTvCicleColor = (CircleTextProgressbar) findViewById(R.id.tv_red_circle_color);

        // ��ϵͳ������һ������0-100��
        mTvCount = (CircleTextProgressbar) findViewById(R.id.tv_count);
        mTvCount.setProgressType(CircleTextProgressbar.ProgressType.COUNT);

        // ���������
        mTvWide = (CircleTextProgressbar) findViewById(R.id.tv_five_wide);
        mTvWide.setProgressLineWidth(30);//д���ȡ�
        mTvWide.setTimeMillis(3500);// �ѵ���ʱʱ��ĳ�һ�㡣

        // խ��������
        mTvNarrow = (CircleTextProgressbar) findViewById(R.id.tv_five_narrow);
        mTvNarrow.setProgressLineWidth(3);// д���ȡ�

        // ��ɫ��������
        mTvRedPro = (CircleTextProgressbar) findViewById(R.id.tv_red_progress);
        mTvRedPro.setProgressColor(Color.RED);

        // ��ɫ�߿��������
        mTvRedFrame = (CircleTextProgressbar) findViewById(R.id.tv_red_frame);
        mTvRedFrame.setOutLineColor(Color.RED);

        // ��ɫԲ�Ľ�������
        mTvRedCircle = (CircleTextProgressbar) findViewById(R.id.tv_red_circle);
        mTvRedCircle.setInCircleColor(Color.RED);

        mTvProgressBar1 = (CircleTextProgressbar) findViewById(R.id.tv_red_progress_text1);
        mTvProgressBar1.setCountdownProgressListener(1, progressListener);
        mTvProgressBar1.setProgressType(CircleTextProgressbar.ProgressType.COUNT);

        mTvProgressBar2 = (CircleTextProgressbar) findViewById(R.id.tv_red_progress_text2);
        mTvProgressBar2.setCountdownProgressListener(2, progressListener);


        // ģ����������������
        mTvSkip = (CircleTextProgressbar) findViewById(R.id.tv_red_skip);
        mTvSkip.setOutLineColor(Color.TRANSPARENT);
        mTvSkip.setInCircleColor(Color.parseColor("#AAC6C6C6"));
        mTvSkip.setProgressColor(Color.DKGRAY);
        mTvSkip.setProgressLineWidth(3);
    }

    private CircleTextProgressbar.OnCountdownProgressListener progressListener = new CircleTextProgressbar.OnCountdownProgressListener() {
        @Override
        public void onProgress(int what, int progress) {
            if (what == 1) {
                mTvProgressBar1.setText(progress + "%");
            } else if (what == 2) {
                mTvProgressBar2.setText(progress + "%");
            }
            // ��������ҳ����������жϽ��ȣ����ȵ���100����0��ʱ�������������������
        }
    };

    public void onClick(View view) {
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_start) {
            mTvDefault.reStart();
            mTvFive.reStart();
            mTvCicleColor.reStart();
            mTvCount.reStart();
            mTvWide.reStart();
            mTvNarrow.reStart();
            mTvRedPro.reStart();
            mTvRedFrame.reStart();
            mTvRedCircle.reStart();
            mTvProgressBar1.reStart();
            mTvProgressBar2.reStart();
            mTvSkip.reStart();
        }
        return true;
    }
}
