package com.example.waterapp.view.fragmenthome;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterapp.R;
import com.example.waterapp.presenter.HomePresenter;
import com.example.waterapp.view.progressBar.ArcProgress;

public class FragmentHome extends Fragment implements View.OnClickListener {
    Context context = getContext();
    FragmentHomeAdapterOnClickHandler fragmentHomeAdapterOnClickHandler;
    RecyclerView recyclerView;
    ArcProgress arcProgress;
    ImageButton ibAddWater;

    HomePresenter hp = HomePresenter.getInstance();
    FragmentHomeAdapter fragmentHomeAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ibAddWater = (ImageButton) view.findViewById(R.id.btn_add_water);
        ibAddWater.setOnClickListener(this);
        recyclerView = (RecyclerView) view.findViewById(R.id.event_menu);
        initArcProgress(view);
        initRecyclerView();
        return view;
    }


    //TODO change logic for setMax and setProgress
    private void initArcProgress(View view) {

        arcProgress = (ArcProgress) view.findViewById(R.id.progress_circular);

        arcProgress.setMax(2000);
        arcProgress.setProgress(850);
        arcProgress.setBottomText("Daily Drink Target");
        arcProgress.setBottomTextSize(44);
    }

    private void initRecyclerView() {
        fragmentHomeAdapter = new FragmentHomeAdapter(context, fragmentHomeAdapterOnClickHandler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(fragmentHomeAdapter);
        fragmentHomeAdapter.setHistory();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_add_water:
                hp.addWater();
                fragmentHomeAdapter.setHistory();
                fragmentHomeAdapter.notifyDataSetChanged();
                break;

        }


    }


}
