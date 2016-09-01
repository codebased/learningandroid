package com.imcodebased.storage;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by codebased on 23/08/16.
 */
public class InternalStorageActivity extends AppCompatActivity {

    private Button btn;

    private static final String FILE_NAME = "temporaryfile.txt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnDelete:
                doDelete();
                break;
            case R.id.btnWrite:
                doWrite();
                break;
            case R.id.btnRead:
                doRead();
                break;
        }
    }


    private void doRead() {

        try {
            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Log.i("InternalStorageActivity", line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDelete() {
        deleteFile(FILE_NAME);
    }


    private void doWrite() {

        String string = "iOS Swift is simple than an Android.";

        try {
            FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(string);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
