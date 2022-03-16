package com.joma.mvpcounter.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

import com.joma.mvpcounter.R;
import com.joma.mvpcounter.data.Injector;
import com.joma.mvpcounter.databinding.ActivityMainBinding;
import com.joma.mvpcounter.presenter.CounterPresenter;
import com.joma.mvpcounter.presenter.PresenterContracts;

public class MainActivity extends AppCompatActivity implements PresenterContracts.CounterView {
    private ActivityMainBinding binding;
    private CounterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = Injector.getPresenter();
        presenter.attachView(this);
        initListeners();
    }

    private void initListeners() {
        binding.btnPlus.setOnClickListener(view -> {
            presenter.increment();
            presenter.toast();
            presenter.colorChange();
        });
        binding.btnMinus.setOnClickListener(view -> {
            presenter.decrement();
            presenter.toast();
            presenter.colorChange();
        });
    }


    @Override
    public void updateCounter(int counter) {
        binding.tvCount.setText(String.valueOf(counter));
    }

    @Override
    public void isFiveToast() {
        Toast.makeText(this, "Ураа", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void isTenColor() {
        binding.tvCount.setTextColor(this.getResources().getColor(R.color.green, getTheme()));
    }
}