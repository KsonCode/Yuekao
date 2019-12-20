package com.laoxu.yuekao.view.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class FlowLayout extends ViewGroup {

    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = 0;

        int count = getChildCount();//得到子控件的数量

        if (count>0){
            for (int i = 0; i < count; i++) {
                //循环每一个子控件
                View view = getChildAt(i);

                //子view添加进去的，所以要让系统测量一下每个子控件的大小
                view.measure(0,0);

                int childWidth = view.getMeasuredWidth();//view的宽
                int childHeight = view.getMeasuredHeight();//view的高


                //累加right
                right =left+childWidth;

                //屏幕宽度，px像素单位
                int widthPixels = getResources().getDisplayMetrics().widthPixels;

                //如果每一行的right大于屏幕宽度，开始折行判断
                if (right>widthPixels){
                    left = 0;//折行后第一个控件距离左边距离为0
                    right = left+childWidth;
                    top = bottom+30;

                }

                bottom = top+childHeight;

                //就是对view进行摆放
                view.layout(left,top,right,bottom);

                left+=childWidth+30;


            }
        }


    }

    /**
     * 加入数据
     */
    public void add(List<String> tags){

        if (tags!=null&&tags.size()>0){
            for (String tag : tags) {
                //动态创建textview
                final TextView textView = new TextView(getContext());
                textView.setText(tag);//设置文本
                //添加子控件到当前流式布局中
                addView(textView);

                textView.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        flowCallback.flowClick(textView.getText().toString());
                    }
                });

            }
        }


    }

    /**
     * 添加单个view到流式布局
     */
    public void addTextView(String name){

        final TextView textView = new TextView(getContext());
        textView.setText(name);

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
                flowCallback.flowClick(textView.getText().toString());

            }
        });

        //加入到流式布局中
        addView(textView);
    }

    private FlowCallback flowCallback;

    public void setFlowCallback(FlowCallback flowCallback) {
        this.flowCallback = flowCallback;
    }

    public interface FlowCallback{
        void flowClick(String name);
    }

}
