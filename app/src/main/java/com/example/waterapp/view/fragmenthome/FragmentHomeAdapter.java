package com.example.waterapp.view.fragmenthome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterapp.R;

public class FragmentHomeAdapter extends RecyclerView.Adapter<FragmentHomeViewHolder> {

    /* The context we use to utility methods, app resources and layout inflaters */
    private final Context context;

    /*
     * Below, we've defined an interface to handle clicks on items within this Adapter. In the
     * constructor of our ForecastAdapter, we receive an instance of a class that has implemented
     * said interface. We store that instance in this variable to call the onClick method whenever
     * an item is clicked in the list.
     */
    final private FragmentHomeAdapterOnClickHandler clickHandler;


    /**
     * Creates a ForecastAdapter.
     *
     * @param context      Used to talk to the UI and app resources
     * @param clickHandler The on-click handler for this adapter. This single handler is called
     *                     when an item is clicked.
     */
    public FragmentHomeAdapter(Context context, FragmentHomeAdapterOnClickHandler clickHandler) {
        this.context = context;
        this.clickHandler = clickHandler;
    }


    @NonNull
    @Override
    public FragmentHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        int layoutId = R.layout.today_history_list_item;

        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);

        view.setFocusable(true);

        return new FragmentHomeViewHolder(view);
    }

    //TODO change logic for Cursor

    @Override
    public void onBindViewHolder(@NonNull FragmentHomeViewHolder holder, int position) {
        holder.ivDrink.setImageResource(R.drawable.ic_water_glass);
        holder.ibDelete.setImageResource(R.drawable.ic_delete_button);

        holder.tvDate.setText("22:00");
        holder.tvDate.setContentDescription("22:00 desc");

        holder.tvNextTimeLabel.setVisibility(View.INVISIBLE);

        holder.tvWaterVolume.setText("200 ml");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
