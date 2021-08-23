package com.example.recycularview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>
{
    private List<ModelClass> userList;
    public Adapter(List<ModelClass>userList)
    {
        this.userList=userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int resource=userList.get(position).getImageview1();
        String name=userList.get(position).getTextview1();
        String time=userList.get(position).getTextview2();
        String msg=userList.get(position).getTextview3();
        String line=userList.get(position).getDivider();
        holder.setData(resource,name,time,msg,line);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imageview;
        private TextView textview;
        private TextView textview2;
        private TextView textview3;
        private TextView divider;

        public ViewHolder(@NonNull  View itemView)
        {
            super(itemView);
            imageview=itemView.findViewById(R.id.imageview1);
            textview=itemView.findViewById(R.id.textview);
            textview2=itemView.findViewById(R.id.textview2);
            textview3=itemView.findViewById(R.id.textview3);
            divider=itemView.findViewById(R.id.divider);
        }

        public void setData(int resource, String name, String time, String msg, String line) {
            imageview.setImageResource(resource);
            textview.setText(name);
            textview2.setText(time);
            textview3.setText(msg);
            divider.setText(line);
        }
    }
}
