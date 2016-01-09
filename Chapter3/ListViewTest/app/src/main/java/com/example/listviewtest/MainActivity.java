package com.example.listviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,
                R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private void initFruits() {
        Fruit apple = new Fruit("Apple", R.mipmap.apple_pic);
        fruitList.add(apple);
        Fruit banana = new Fruit("Banana", R.mipmap.banana_pic);
        fruitList.add(banana);
        Fruit orange = new Fruit("Orange", R.mipmap.orange_pic);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", R.mipmap.watermelon_pic);
        fruitList.add(watermelon);
        Fruit pear = new Fruit("Pear", R.mipmap.pear_pic);
        fruitList.add(pear);
        Fruit grape = new Fruit("Grape", R.mipmap.grape_pic);
        fruitList.add(grape);
        Fruit pineapple = new Fruit("Pineapple", R.mipmap.pineapple_pic);
        fruitList.add(pineapple);
        Fruit strawberry = new Fruit("Strawberry", R.mipmap.strawberry_pic);
        fruitList.add(strawberry);
        Fruit cherry = new Fruit("Cherry", R.mipmap.cherry_pic);
        fruitList.add(cherry);
        Fruit mango = new Fruit("Mango", R.mipmap.mango_pic);
        fruitList.add(mango);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
