package com.imcodebased.dagger;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listview)
     ListView listView;

    // @Inject Request dependencies. Can be used on a constructor, a field, or a method
    @Inject
    DataProvider dataProvider;

    @Inject
    Application applicationContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((DaggerApplication) getApplication()).getAppComponent().inject(this);

    }

    @Override
    protected void onResume() {
        super.onResume();

        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataProvider.getData()));
    }
}