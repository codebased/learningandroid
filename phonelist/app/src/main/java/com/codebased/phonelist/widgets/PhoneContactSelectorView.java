package com.codebased.phonelist.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.codebased.phonelist.Utils.KeyboardUtil;
import com.codebased.phonelist.R;

import java.util.ArrayList;

public class PhoneContactSelectorView extends LinearLayout implements
        AdapterView.OnItemClickListener,
        AdapterView.OnItemSelectedListener {

    private AutoCompleteTextView mPhoneSearchTextView;
    private PhoneContactAdapter mPhoneContactAdapter;
    private ArrayList<ListItemData> mPhoneContactList;
    private PhoneContactSelectorListener mPhoneContactSelectorListener;

    public PhoneContactSelectorView(Context context) {
        super(context);
        init();
    }

    public PhoneContactSelectorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhoneContactSelectorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.phonecontactview, this);

        mPhoneSearchTextView = (AutoCompleteTextView) findViewById(R.id.phoneSearchTextView);

        if (isInEditMode()) {
            mPhoneContactAdapter = new PhoneContactAdapter
                    (getContext(), R.layout.item, mPhoneContactList);
            mPhoneSearchTextView.setAdapter(mPhoneContactAdapter);

            return;
        }

        mPhoneSearchTextView.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    ListItemData itemData = new ListItemData();
                    itemData.setText(mPhoneSearchTextView.getText().toString());
                    addNewEmergencyContact(itemData);
                    KeyboardUtil.hideSystemKeyboard(v.getContext(), v);

                    return true;
                }

                return false;

            }
        });


    }

    public void populatePhoneSearchAdapter() {
        mPhoneContactList = (ArrayList<ListItemData>) ContactUtils.getPhoneContacts(getContext());
        mPhoneContactAdapter = new PhoneContactAdapter
                (getContext(), R.layout.item, mPhoneContactList);

        mPhoneSearchTextView.setAdapter(mPhoneContactAdapter);
        mPhoneSearchTextView.setOnItemClickListener(this);
        mPhoneSearchTextView.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        addNewEmergencyContact((ListItemData) adapterView.getItemAtPosition(position));
        KeyboardUtil.hideSystemKeyboard(adapterView.getContext(), view);
    }

    private void addNewEmergencyContact(ListItemData contactItem) {
        if (mPhoneContactSelectorListener != null) {
            mPhoneContactSelectorListener.onInserted(contactItem);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        KeyboardUtil.hideSystemKeyboard(adapterView.getContext(), adapterView);
    }

    public PhoneContactSelectorListener getPhoneContactSelectorListener() {
        return mPhoneContactSelectorListener;
    }

    public void setPhoneContactSelectorListener(PhoneContactSelectorListener selectorListener) {
        mPhoneContactSelectorListener = selectorListener;
    }
}
