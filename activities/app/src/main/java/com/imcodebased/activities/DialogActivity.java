package com.imcodebased.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void onClick(View v) {
        showDialog(0);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        final CharSequence[] options = this.getResources().getTextArray(R.array.choices);
        boolean[] itemChecked = new boolean[options.length];


        switch (id) {
            case 0:
                return new AlertDialog.Builder(this).
                        setIcon(R.drawable.ic_image).
                        setTitle("Awesome Steven! Do you agree?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "OK clicked", Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this, "Cancel Clicked", Toast.LENGTH_LONG).show();
                            }
                        }).setMultiChoiceItems(DialogActivity.this.getResources().getStringArray(R.array.choices), itemChecked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(DialogActivity.this, options[which] + " is " + (isChecked ? " checked " : " unchecked"), Toast.LENGTH_SHORT).show();
                            }
                        }).create();

            case 1:
                progressDialog = new ProgressDialog(this);
                progressDialog.setIcon(R.drawable.ic_image);
                progressDialog.setTitle("Downloading");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "ok", Toast.LENGTH_SHORT).show();
                    }
                });

                return progressDialog;

        }

        return null;
    }

    public void onShowProgressDialog(View view) {

        showDialog(1);
        progressDialog.setProgress(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i :
                        new int[]{1, 2, 3, 4, 5}) {
                    try {
                        Thread.sleep(100);
                        progressDialog.incrementProgressBy(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
