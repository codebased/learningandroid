package com.imcodebased.architecture.mvp;

import de.greenrobot.event.EventBus;

/*
No need for interfaces, callbacks for asynchronous communication or data propagation through all software layers.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private ItemService mItemService;

    public MainPresenterImpl(MainView mainView, ItemService itemService) {
        this.mainView = mainView;
        this.mItemService = itemService;
    }

    @Override
    public void onResume() {
        EventBus.getDefault().register(this);

        if (mainView != null) {
            mainView.showProgress();
        }

        mItemService.findItems();
    }

    @Override
    public void onItemClicked(int position) {
        if (mainView != null) {
            mainView.showMessage(String.format("Item %d clicked", position + 1));
        }
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    public void onEvent(ItemEventMessage event) {
        if (mainView != null) {
            mainView.setItems(event.getItems());
            mainView.hideProgress();
        }
    }
}
