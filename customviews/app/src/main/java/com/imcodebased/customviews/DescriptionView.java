package com.imcodebased.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by codebased on 16/08/16.
 */
public class DescriptionView extends TableLayout {
    public DescriptionView(Context context) {
        super(context);
        setContent();
    }

    public DescriptionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setContent();
    }

    private void setContent() {
        List<String> descriptions = getItems();
        TableRow tableRow = null;
        TextView descriptionTextView = null;
        for (int idx = 0; idx < descriptions.size(); idx++) {
            if (idx % 3 == 0) {
                tableRow = new TableRow(getContext());
                this.addView(tableRow, idx % 3);
            }

            descriptionTextView = new TextView(getContext());
            descriptionTextView.setText(descriptions.get(idx));
            descriptionTextView.setGravity(Gravity.CENTER);
            tableRow.addView(descriptionTextView);
        }
    }

    public List<String> getItems() {
        return Arrays.asList(getContext().getResources().getStringArray(R.array.descriptions));
    }
}
