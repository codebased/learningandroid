package com.codebased.phonelist;

import android.animation.Animator;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codebased.phonelist.Utils.KeyboardUtil;
import com.codebased.phonelist.widgets.ListItemData;
import com.codebased.phonelist.widgets.PhoneContactSelectorListener;
import com.codebased.phonelist.widgets.PhoneContactSelectorView;

public class MobilePaymentFragment extends Fragment {

    private PhoneContactSelectorView phoneListView;
    private RelativeLayout paytoLayout;
    private RelativeLayout emptyLayout;

    private Button payButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_emergency, null);

        phoneListView = (PhoneContactSelectorView) view.findViewById(R.id.phoneListView);
        paytoLayout = (RelativeLayout) view.findViewById(R.id.paytoLayout);
        emptyLayout = (RelativeLayout) view.findViewById(R.id.emptyLayout);
        payButton = (Button) paytoLayout.findViewById(R.id.payButton);

        return view;

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
                            paytoLayout.findViewById(R.id.image).setBackground(getResources().getDrawable(R.drawable.unnamed));
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
            }
        });
    }
}