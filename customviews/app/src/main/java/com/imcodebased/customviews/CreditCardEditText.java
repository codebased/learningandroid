package com.imcodebased.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by codebased on 16/08/16.
 */
public class CreditCardEditText extends EditText {
    public CreditCardEditText(Context context) {
        super(context);
        setValidation();
    }

    public CreditCardEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setValidation();
    }

    public CreditCardEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setValidation();
    }

    private void setValidation() {

        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_NUMPAD_SUBTRACT || keyCode == KeyEvent.KEYCODE_MINUS || (keyCode >= 7 && keyCode <= 16)
                        || keyCode >= 143 && keyCode <= 153) {
                    return false;
                }
                return true;
            }
        });
    }
}
