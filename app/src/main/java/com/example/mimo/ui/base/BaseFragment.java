package com.example.mimo.ui.base;

import android.os.Bundle;

import com.example.mimo.ui.AsyncLoader;

public class BaseFragment extends dagger.android.support.DaggerFragment {
    private AsyncLoader asyncLoader;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        asyncLoader = AsyncLoader.dialog(getActivity());
    }

    public void showLoader() {
        try {
            asyncLoader.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void hideLoader() {
        try {
            asyncLoader.hide();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dismissLoader();
    }

    private void dismissLoader() {
        try {
            asyncLoader.dismiss();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setLoadingIndicator(boolean active) {
        if (active)
            showLoader();
        else
            hideLoader();
    }
}
