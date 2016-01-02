package com.example.activitytest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by mookrs on 15/7/1.
 */
public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", this.toString());
        Log.d("FirstActivity", "Task id is " + getTaskId());
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式Intent
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity(intent);

                // 隐式Intent
                //Intent intent = new Intent("com.example.activitytest.ACTION_START");
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");
                //startActivity(intent);

                // 调用系统浏览器
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //startActivity(intent);

                // 调用系统拨号界面
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                //startActivity(intent);

                // 向下一个活动传递数据
                //String data = "Hello SecondActivity";
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //intent.putExtra("extra_data", data);
                //startActivity(intent);

                // 在活动销毁时返回结果给上一个活动
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivityForResult(intent, 1);

                // 在FirstActivity的基础上启动FirstActivity
                //Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                //startActivity(intent);

                // 测试FirstActivity的singleTop/singleTask启动模式
                // 测试SecondActivity的singleInstance启动模式
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);

                //SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 第一个参数用于指定我们通过哪一个资源文件来创建菜单
        // 第二个参数用于指定我们的菜单项将添加到哪一个Menu对象当中
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    // 得到上一个活动返回的数据
    // 第一个参数requestCode，即我们在启动活动时传入的请求码。
    // 第二个参数resultCode，即我们在返回数据时传入的处理结果。
    // 第三个参数data，即携带着返回数据的 Intent。
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity", "onRestart");
    }
}
