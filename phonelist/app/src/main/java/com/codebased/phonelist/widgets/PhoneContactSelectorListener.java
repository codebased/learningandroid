package com.codebased.phonelist.widgets;

public interface PhoneContactSelectorListener {
    void onInserted(ListItemData listItemData);

    void onDeleted(ListItemData listItemData);
}