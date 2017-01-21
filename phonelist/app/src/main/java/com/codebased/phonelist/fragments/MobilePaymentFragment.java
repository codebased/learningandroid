package com.codebased.phonelist.fragments;

import android.animation.Animator;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codebased.phonelist.R;
import com.codebased.phonelist.utils.ContactUtils;
import com.codebased.phonelist.utils.KeyboardUtil;
import com.codebased.phonelist.widgets.ExpandableListAdapter;
import com.codebased.phonelist.widgets.models.ListHeaderData;
import com.codebased.phonelist.widgets.models.ListItemData;
import com.codebased.phonelist.widgets.listeners.PhoneContactSelectorListener;
import com.codebased.phonelist.widgets.PhoneContactSelectorView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobilePaymentFragment extends Fragment {

    private Map<ListHeaderData, List<ListItemData>> items;
    private List<ListHeaderData> headers;
    private PhoneContactSelectorView phoneListView;
    private RelativeLayout paytoLayout;
    private RelativeLayout emptyLayout;

    private Button payButton;
    private ExpandableListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_emergency, null);

        phoneListView = (PhoneContactSelectorView) view.findViewById(R.id.phoneListView);
        paytoLayout = (RelativeLayout) view.findViewById(R.id.paytoLayout);
        emptyLayout = (RelativeLayout) view.findViewById(R.id.emptyLayout);
        payButton = (Button) paytoLayout.findViewById(R.id.payButton);
        listView = (ExpandableListView) view.findViewById(R.id.lvExp);

        List<ListItemData> contactList = ContactUtils.getPhoneContacts(getActivity().getApplicationContext());

        prepareItems(contactList);

        listView.setAdapter(new ExpandableListAdapter<>
                (getActivity().getApplicationContext(), headers, items));

        phoneListView.getVoiceButtonView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int REQUEST_CODE = 1;
                String DIALOG_TEXT = "Speak name or a number";
                try {
                    Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, DIALOG_TEXT);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                    intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, REQUEST_CODE);
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                    startActivityForResult(intent, 2);
                } catch (ActivityNotFoundException ex) {
                    // TODO: 14/09/16 instead of this exception way check that if intent handler is available in a better way
                }
            }
        });

        return view;

    }


    private void prepareItems(List<ListItemData> contacts) {

        ListHeaderData header = null;
        ListItemData previousItem = null;

        List<ListItemData> headerItems = null;
        items = new HashMap<>();
        headers = new ArrayList<>();
        for (ListItemData item :
                contacts) {

            if (previousItem == null ||
                    !previousItem.getText().startsWith(item.getText().substring(0, 1))) {
                headerItems = new ArrayList<>();
                header = new ListHeaderData();
                header.setText(item.getText().substring(0, 1));
                headers.add(header);

                items.put(header, headerItems);
            }

            previousItem = item;
            headerItems.add(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        phoneListView.populatePhoneSearchAdapter();
        phoneListView.setPhoneContactSelectorListener(new PhoneContactSelectorListener() {
            @Override
            public void onInserted(final ListItemData listItemData) {

                emptyLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        paytoLayout.setVisibility(View.VISIBLE);
                        emptyLayout.setVisibility(View.VISIBLE);
                        paytoLayout.setAlpha(0);
                        emptyLayout.animate().alpha(0).setDuration(400).setListener(new Animator.AnimatorListener() {


                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                emptyLayout.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }

                        }).start();
                        paytoLayout.animate().alpha(1).setDuration(500).setListener(new Animator.AnimatorListener() {


                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }

                        }).start();

                        ((TextView) paytoLayout.findViewById(R.id.title)).setText(listItemData.getText());
                        ((TextView) paytoLayout.findViewById(R.id.subtitle)).setText(listItemData.getSubtext());
                        ((TextView) paytoLayout.findViewById(R.id.subtitle)).setText(listItemData.getSubtext());
                        if (listItemData.getThumbnail() != null) {
                            BitmapDrawable ob = new BitmapDrawable(getResources(), listItemData.getThumbnail());
                            paytoLayout.findViewById(R.id.image).setBackground(ob);
                        } else {
                            paytoLayout.findViewById(R.id.image).setBackground(getResources().getDrawable(R.drawable.grumpy));
                        }

                        paytoLayout.findViewById(R.id.amount).requestFocus();
                        paytoLayout.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                KeyboardUtil.showSystemKeyboard(getActivity(), paytoLayout.findViewById(R.id.amount));
                            }
                        }, 200);

                    }
                }, 200);


                KeyboardUtil.hideSystemKeyboard(getActivity(), phoneListView);

            }

            @Override
            public void onDeleted(ListItemData listItemData) {

            }
        });

        paytoLayout.findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paytoLayout.setVisibility(View.GONE);
                emptyLayout.setVisibility(View.VISIBLE);
                emptyLayout.setAlpha(1);
                phoneListView.mPhoneSearchTextView.setText("");
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paytoLayout.setVisibility(View.GONE);
                emptyLayout.setVisibility(View.VISIBLE);
                emptyLayout.setAlpha(1);
                phoneListView.mPhoneSearchTextView.setText("");
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultcode, Intent intent) {
        super.onActivityResult(requestCode, resultcode, intent);
        ArrayList<String> speech;
        if (resultcode == Activity.RESULT_OK) {
            if (requestCode == 2) {
                speech = intent.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                phoneListView.mPhoneSearchTextView.setText(speech.get(0).replace(" ", ""));
                // @todo need to make sure that it select from the list.
            }
        }
    }
}