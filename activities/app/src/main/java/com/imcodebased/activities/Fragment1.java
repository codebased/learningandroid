package com.imcodebased.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static helpers.LogUtil.logSuperStartEntry;
import static helpers.LogUtil.logSuperStopEntry;

/**
 * Created by codebased on 24/07/16.
 */
public class Fragment1 extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ( isAdded())return;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        logSuperStartEntry(Fragment1.class);
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        logSuperStartEntry(Fragment1.class);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        logSuperStartEntry(Fragment1.class);
        super.onViewCreated(view, savedInstanceState);
        logSuperStopEntry(Fragment1.class);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        logSuperStartEntry(Fragment1.class);
        super.onActivityCreated(savedInstanceState);
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        logSuperStartEntry(Fragment1.class);
        super.onViewStateRestored(savedInstanceState);
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onStart() {
        logSuperStartEntry(Fragment1.class);
        super.onStart();
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onResume() {
        logSuperStartEntry(Fragment1.class);
        super.onResume();
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        logSuperStartEntry(Fragment1.class);
        super.onSaveInstanceState(outState);
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onPause() {
        logSuperStartEntry(Fragment1.class);
        super.onPause();
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onStop() {
        logSuperStartEntry(Fragment1.class);
        super.onStop();
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onLowMemory() {
        logSuperStartEntry(Fragment1.class);
        super.onLowMemory();
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onDestroyView() {
        logSuperStartEntry(Fragment1.class);
        super.onDestroyView();
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onDestroy() {
        logSuperStartEntry(Fragment1.class);
        super.onDestroy();
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onDetach() {
        logSuperStartEntry(Fragment1.class);
        super.onDetach();
        logSuperStopEntry(Fragment1.class);
    }

    @Override
    public void onAttach(Context context) {
        logSuperStartEntry(Fragment1.class);
        super.onAttach(context);
        logSuperStopEntry(Fragment1.class);
    }
}
