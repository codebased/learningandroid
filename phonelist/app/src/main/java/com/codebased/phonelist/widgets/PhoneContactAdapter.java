package com.codebased.phonelist.widgets;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;


import com.codebased.phonelist.R;

import java.util.ArrayList;

public class PhoneContactAdapter extends ArrayAdapter<ListItemData> {
    private ArrayList<ListItemData> items;
    private ArrayList<ListItemData> itemsAll;
    private ArrayList<ListItemData> suggestions;
    private int viewResourceId;

    public PhoneContactAdapter(Context context, int viewResourceId, ArrayList<ListItemData> items) {
        super(context, viewResourceId, items);
        this.items = items;
        this.itemsAll = (ArrayList<ListItemData>) items.clone();
        this.suggestions = new ArrayList<>();
        this.viewResourceId = viewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(viewResourceId, null);
        }
        ListItemData listItemData = items.get(position);
        if (listItemData != null) {
            TextView textView = (TextView) v.findViewById(R.id.text);
            if (textView != null) {
                textView.setText(listItemData.getText());
            }

            TextView numberTextView = (TextView) v.findViewById(R.id.subtext);
            if (numberTextView != null) {
                numberTextView.setText(listItemData.getSubtext());
            }

            ImageView image = (ImageView) v.findViewById(R.id.thumbnail);
            if (listItemData.getThumbnail() != null)
                image.setImageBitmap(listItemData.getThumbnail());
            else
                image.setImageBitmap(null);

        }

        return v;
    }

    @Override
    public Filter getFilter() {
        return nameFilter;
    }

    Filter nameFilter = new Filter() {
        @Override
        public String convertResultToString(Object resultValue) {
            String str = ((ListItemData) (resultValue)).getText();
            return str;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            if (constraint != null) {
                constraint = constraint.toString();
                suggestions.clear();
                synchronized (this) {
                    for (ListItemData listItemData : itemsAll) {
                        final String text = listItemData.getText().toLowerCase();
                        final String number = listItemData.getSubtext().toLowerCase().replaceAll("\\s", "");
                        if (text.contains(constraint) || number.contains(constraint)) {
                            suggestions.add(listItemData);
                        }
                    }

                    FilterResults filterResults = new FilterResults();
                    filterResults.values = suggestions;
                    filterResults.count = suggestions.size();
                    return filterResults;
                }
            } else {
                return new FilterResults();
            }
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            synchronized (this) {
                ArrayList<ListItemData> filteredList = (ArrayList<ListItemData>) results.values;
                clear();
                if (results.count > 0) {
                    addAll(filteredList);
                }

                notifyDataSetChanged();
            }
        }
    };
}