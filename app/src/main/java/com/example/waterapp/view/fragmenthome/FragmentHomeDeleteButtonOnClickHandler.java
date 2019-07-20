package com.example.waterapp.view.fragmenthome;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * The interface that receives onClick messages for button delete inside view holder in recycler view.
 */
public interface FragmentHomeDeleteButtonOnClickHandler extends RecyclerView.OnClickListener {

    @Override
    void onClick(View v);
}
