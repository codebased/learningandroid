package com.imcodebased.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final int CHECKBOX_ITEM = 101;

    private static final int RADIOBUTTON_1 = 201;
    private static final int RADIOBUTTON_2 = 202;
    private static final int RB_GROUP = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // wow you don't need to have layout file but it is really not a smart way to set contentView ;)
        TextView textView = new TextView(this);
        textView.setText("Hey");
        setContentView(textView);

        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // I am inflating which is very common way to do menu stuff.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);

        // you can even add sub menu - NEVER DO THAT :)
        SubMenu subMenu = menu.addSubMenu("Submenu Heading").setHeaderIcon(R.drawable.ic_genre);
        subMenu.add("I am Submenu");

        // creating a new check box item with the short cut.
        menu.add(0, CHECKBOX_ITEM, Menu.NONE, "Checkbox").setChecked(true)
                .setCheckable(true)
                .setShortcut('0', 'b');

        // create a radio button group.
        menu.add(RB_GROUP, RADIOBUTTON_1, Menu.NONE, "Radio Button 1");
        menu.add(RB_GROUP, RADIOBUTTON_2, Menu.NONE, "Radio Button 2").setChecked(true);
        menu.setGroupCheckable(RB_GROUP, true, true);

        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // before I can see the menu, I will change the text here.
        MenuItem action_menu = menu.findItem(R.id.action_hello);
        action_menu.setTitle("world");

        // I can even attach an intent against menu item.
        MenuItem action_intent = menu.findItem(R.id.action_intent);
        action_intent.setIntent(new Intent(this, DummyActivity.class));

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {

        toast("Side Menu More Opened...");
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_hello:
                toast("Action Hello which is now world");
                break;
            case CHECKBOX_ITEM:
                item.setChecked(!item.isChecked());
                break;
            case RADIOBUTTON_1:
                item.setChecked(true);
                break;
            case RADIOBUTTON_2:
                item.setChecked(true);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);


        menu.setHeaderIcon(R.drawable.ic_genre);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, menu.FIRST, Menu.NONE, "Item 1").setIcon(R.drawable.ic_genre);
        menu.add(0, menu.FIRST + 1, Menu.NONE, "Item 2").setCheckable(true);
        menu.add(0, menu.FIRST + 2, Menu.NONE, "Item 3").setShortcut('3', '3');

        SubMenu subMenu = menu.addSubMenu("Submenu");
        subMenu.add("Submenu Item");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        toast("Context Clicked : " + item.getItemId());
        return super.onContextItemSelected(item);
    }

    private void toast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
