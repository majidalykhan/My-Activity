package com.example.myactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyActivity> myActivity;

    public ActivityAdapter(Context c, ArrayList<MyActivity> p){
        context = c;
        myActivity = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.my_activities,
                viewGroup , false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleActivity.setText(myActivity.get(position).getTitleActivity());
        holder.descActivity.setText(myActivity.get(position).getDescActivity());
        holder.dateActivity.setText(myActivity.get(position).getDateActivity());

    }

    @Override
    public int getItemCount() {
        return myActivity.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titleActivity, descActivity, dateActivity;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            titleActivity = (TextView) itemView.findViewById(R.id.activityTitle);
            descActivity = (TextView) itemView.findViewById(R.id.activityDescription);
            dateActivity = (TextView) itemView.findViewById(R.id.date);

        }
    }

}
