package com.imcodebased.architecture.mvp;

public interface MainPresenter {

    void onResume();

    void onItemClicked(int position);

    void onDestroy();

    void onPause();
}