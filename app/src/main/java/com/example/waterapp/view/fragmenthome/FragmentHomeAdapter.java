package com.example.waterapp.view.fragmenthome;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waterapp.App;
import com.example.waterapp.R;
import com.example.waterapp.model.pojo.CurrentTimeRecord;
import com.example.waterapp.presenter.HomePresenter;
import com.example.waterapp.utils.TimeUtils;

import java.util.List;

public class FragmentHomeAdapter extends RecyclerView.Adapter<FragmentHomeAdapter.FragmentHomeViewHolder> {

    /* The context we use to utility methods, app resources and layout inflaters */
    private Context context;

    /*
     * Below, we've defined an interface to handle clicks on items within this Adapter. In the
     * constructor of our ForecastAdapter, we receive an instance of a class that has implemented
     * said interface. We store that instance in this variable to call the onClick method whenever
     * an item is clicked in the list.
     */

    HomePresenter homePresenter = HomePresenter.getInstance();

    FragmentHome fragmentHome;

    private List<CurrentTimeRecord> history;

    /**
     * Creates a ForecastAdapter.
     *
     * @param context      Used to talk to the UI and app resources
     */
    public FragmentHomeAdapter(Context context, FragmentHome fragmentHome) {
        this.context = context;
        this.fragmentHome = fragmentHome;
    }


    @NonNull
    @Override
    public FragmentHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = App.getInstance().getApplicationContext();
        int layoutId = R.layout.today_history_list_item;

        View view = LayoutInflater.from(context).inflate(layoutId, parent, false);

        view.setFocusable(false);
        view.setClickable(false);

        return new FragmentHomeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull FragmentHomeViewHolder holder, int position) {

        CurrentTimeRecord record = history.get(position);
        holder.setCurrentTimeRecord(record);
        holder.ivDrink.setImageResource(R.drawable.ic_water_glass);
        holder.ivDrink.setMaxHeight(22);
        holder.ivDrink.setMaxWidth(22);

        holder.ibDelete.setImageResource(R.drawable.ic_delete_button);

        holder.tvDate.setText(TimeUtils.getFormattedTime(record.getTime()));
        holder.tvDate.setContentDescription(TimeUtils.getFormattedTime(record.getTime()));

        holder.tvWaterVolume.setText(Long.toString(record.getWaterVolume()));

    }

    @Override
    public int getItemCount() {
        if (history == null) return 0;
        return history.size();
    }

    public void setHistory() {
        history = HomePresenter.getInstance().getDailyHistory();
    }

    class FragmentHomeViewHolder extends RecyclerView.ViewHolder implements FragmentHomeDeleteButtonOnClickHandler {

        final ImageView ivDrink;
        final ImageButton ibDelete;

        final TextView tvDate;
        final TextView tvWaterVolume;

        private CurrentTimeRecord currentTimeRecord;


        public FragmentHomeViewHolder(@NonNull View view) {
            super(view);

            ivDrink = (ImageView) view.findViewById(R.id.drink_pic);
            tvDate = (TextView) view.findViewById(R.id.drink_time);
            tvWaterVolume = (TextView) view.findViewById(R.id.water_volume);
            ibDelete = (ImageButton) view.findViewById(R.id.btn_delete);
            ibDelete.setOnClickListener(this);

        }

        public void setCurrentTimeRecord(CurrentTimeRecord currentTimeRecord) {
            this.currentTimeRecord = currentTimeRecord;
        }

        @Override
        public void onClick(View v) {

            int btnId = v.getId();

            if (btnId == ibDelete.getId()) {
                homePresenter.deleteWaterRecord(currentTimeRecord);
                setHistory();
                fragmentHome.initArcProgress();
                notifyDataSetChanged();

            }
        }
    }


}
