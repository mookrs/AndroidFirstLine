package com.example.activitytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by mookrs on 15/7/3.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("SecondActivity", this.toString());
        Log.d("SecondActivity", "Task id is " + getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.second_layout);

        // 从上一个活动获得数据
        //Intent intent = getIntent();
        //String data = intent.getStringExtra("extra_data");
        //Log.d("SecondActivity", data);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 在活动销毁时返回结果给上一个活动。
                // setResult()方法专门用于向上一个活动返回数据，
                // 它接收两个参数，第一个参数用于向上一个活动返回处理结果，
                // 一般只使用RESULT_OK或RESULT_CANCELED这两个值，
                // 第二个参数则是把带有数据的Intent传递回去。
                //Intent intent = new Intent();
                //intent.putExtra("data_return", "Hello FirstActivity");
                //setResult(RESULT_OK, intent);
                //finish();

                //Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                //startActivity(intent);

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    // 不是通过点击按钮finish()当前活动，而是通过按下Back键回到FirstActivity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello FirstActivity(Back Button)");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity", "onDestroy");
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
}
