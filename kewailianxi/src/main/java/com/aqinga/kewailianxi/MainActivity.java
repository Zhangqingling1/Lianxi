package com.aqinga.kewailianxi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//聊天室与截图
public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private Button button;
    private TextView tv_bbs;
    private String[] name = {"你吃饭了吗?","今天天气很好啊","你中奖了","我们去看电影吧","晚上去哪玩啊",};
    private ImageView image;
    private Button jietu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.liaotian);
        image = (ImageView) findViewById(R.id.imageview);
        tv_bbs = (TextView) findViewById(R.id.tv_bbs);
        jietu = (Button) findViewById(R.id.jietu);
        button.setOnClickListener(this);
        button.setOnLongClickListener(this);
        tv_bbs.setOnClickListener(this);
        tv_bbs.setOnLongClickListener(this);
        jietu.setOnClickListener(this);
        button.setOnClickListener(this);
        tv_bbs.setGravity(Gravity.LEFT|Gravity.BOTTOM);
        tv_bbs.setLines(10);
        tv_bbs.setMaxLines(10);
        tv_bbs.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.liaotian||v.getId()==R.id.tv_bbs){
            int random = (int) ((Math.random()*10)%5);
            String newStr = String.format("%s\n%s%s",tv_bbs.getText().toString(),DateUtil.getCurDateStr(),name[random]);
            tv_bbs.setText(newStr);
        }else if (v.getId()==R.id.jietu){
            Bitmap bitmap = tv_bbs.getDrawingCache();
            image.setImageBitmap(bitmap);
            handler.postDelayed(reset,200);
        }
    }
    private Handler handler = new Handler();
    private Runnable reset = new Runnable() {
        @Override
        public void run() {
            tv_bbs.setDrawingCacheEnabled(false);
            tv_bbs.setDrawingCacheEnabled(true);
        }
    };

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
