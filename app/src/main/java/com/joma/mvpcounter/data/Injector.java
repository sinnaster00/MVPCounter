package com.joma.mvpcounter.data;

import com.joma.mvpcounter.presenter.CounterPresenter;

public class Injector {

    public static CounterPresenter getPresenter() {
        return new CounterPresenter();
    }
}
