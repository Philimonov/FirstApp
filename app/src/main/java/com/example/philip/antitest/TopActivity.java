package com.example.philip.antitest;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

import com.example.philip.antitest.R;

public class TopActivity extends DialogFragment {
    final String LOG_TAG = "myLogs";
    EditText front, back;
    DBHelper dbHelper;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        setCancelable(false);
        front.findViewById(R.id.front);
        back.findViewById(R.id.back);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.activity_top, null))
                // Add action buttons
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        ContentValues cv = new ContentValues();
                        String fronttext = front.getText().toString();
                        String backtext = back.getText().toString();
                        SQLiteDatabase db = dbHelper.getWritableDatabase();
                        cv.put("Front", fronttext);
                        cv.put("Back", backtext);
                        // ????????? ??????
                        db.insert("mytable", null, cv);
                        Toast.makeText(getActivity(), "Saved", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // ??????????? ???????????
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // ??????? ??????? ? ??????
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "email text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

    }
}