package com.imcodebased.architecture.mvp;


import java.util.List;

public class MainPresenterImpl implements MainPresenter, ItemService.ItemListener {

    private MainView mainView;
    private ItemService mItemService;

    public MainPresenterImpl(MainView mainView, ItemService itemService) {
        this.mainView = mainView;
        this.mItemService = itemService;
    }

    @Override
    public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }

        mItemService.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (mainView != null) {
            mainView.showMessage(String.format("Item %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onLoad(List<String> items) {
        if (mainView != null) {
            mainView.setItems(items);
            mainView.hideProgress();
        }
    }
}
