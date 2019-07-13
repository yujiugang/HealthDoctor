package com.example.base.presenter;

public class BasePresenter<V> {

    private V View;

    public V getView() {
        return View;
    }

    public void setView(V view) {
        View = view;
    }

    public void detachView() {
        View = null;
    }
}
