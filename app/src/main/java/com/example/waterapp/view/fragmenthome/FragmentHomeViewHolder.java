package com.example.waterapp.view.fragmenthome;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterapp.R;

class FragmentHomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    final ImageView ivDrink;
    final ImageButton ibDelete;

    final TextView tvDate;
    final TextView tvNextTimeLabel ;
    final TextView tvWaterVolume;


    public FragmentHomeViewHolder(@NonNull View view) {
        super(view);

        ivDrink = (ImageView) view.findViewById(R.id.drink_pic);
        tvDate = (TextView) view.findViewById(R.id.drink_time);
        tvNextTimeLabel = (TextView) view.findViewById(R.id.next_time);
        tvWaterVolume = (TextView) view.findViewById(R.id.water_volume);
        ibDelete = (ImageButton) view.findViewById(R.id.btn_delete);

        view.setOnClickListener(this);
    }

    /**
     * This gets called by the child views during a click. We fetch the date that has been
     * selected, and then call the onClick handler registered with this adapter, passing that
     * date.
     *
     * @param v the View that was clicked
     */
    @Override
    public void onClick(View v) {
       // int adapterPosition = getAdapterPosition();
       // mCursor.moveToPosition(adapterPosition);
       // long dateInMillis = mCursor.getLong(MainActivity.INDEX_WEATHER_DATE);
       // mClickHandler.onClick(dateInMillis);
    }
}
