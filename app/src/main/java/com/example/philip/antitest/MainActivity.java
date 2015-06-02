package com.example.philip.antitest;

import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView basicfront,basicback;
    final String LOG_TAG = "myLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Cursor c = db.query("mytable", null, null, null, null, null, null);

        // ?????? ??????? ??????? ?? ?????? ?????? ???????
        // ???? ? ??????? ??? ?????, ???????? false
        if (c.moveToFirst()) {

            // ?????????? ?????? ???????? ?? ????? ? ???????
            basicfront = c.getColumnIndex("name");
            basicback = c.getColumnIndex("email");

            do {
                // ???????? ???????? ?? ??????? ???????? ? ????? ??? ? ???
                Log.d(LOG_TAG, ", name = " + c.getString(basicfront) +
                                ", email = " + c.getString(basicback));
                // ??????? ?? ????????? ??????
                // ? ???? ????????? ??? (??????? - ?????????), ?? false - ??????? ?? ?????
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

      /*  public void showPopupMenu(View v) {
            PopupMenu popupMenu = new PopupMenu(this, v);
            popupMenu.inflate(R.menu.popupmenu);
            popupMenu.show();// ??? Android 4.0
            // ??? ?????? Android 3.0 ????? ???????????? ??????? ???????
            // popupMenu.getMenuInflater().inflate(R.menu.popupmenu,
            // popupMenu.getMenu());
        }*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
            return true;

        }
        if (id== R.id.add) {
            showDialog(findViewById(R.id.add));
            return true;

        }

        return super.onOptionsItemSelected(item);
    }
    public void showDialog(View v){
        FragmentManager manager = getFragmentManager();
        TopActivity topActivity= new TopActivity();
        topActivity.show(manager,"Dialog");
    }
    public void onGroupItemClick(MenuItem item) {
        // One of the group items (using the onClick attribute) was clicked
        // The item parameter passed here indicates which item it is
        // All other menu item clicks are handled by onOptionsItemSelected()
    }
}

