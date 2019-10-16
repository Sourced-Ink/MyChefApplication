package com.example.mycheflogin.Model;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mycheflogin.R;
import java.util.ArrayList;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.DbViewHolder> {

    ArrayList<DbModelClass> objModelClassArrayList;

    public DbAdapter(ArrayList<DbModelClass> objModelClassArrayList){
        this.objModelClassArrayList=objModelClassArrayList;
    }

    @NonNull
    @Override
    public DbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row, parent,false);
        return new DbViewHolder(singleRow);
    }

    @Override
    public void onBindViewHolder(@NonNull DbViewHolder holder, int position) {
        DbModelClass objDbModelClass=objModelClassArrayList.get(position);
        holder.imageDesTV.setText(objDbModelClass.getImageDes());
        holder.ourImagebtn.setImageBitmap(objDbModelClass.getOurImage());
    }

    @Override
    public int getItemCount() {
        return objModelClassArrayList.size();
    }

    public static class DbViewHolder extends RecyclerView.ViewHolder{
        TextView imageDesTV;
        ImageButton ourImagebtn;

        public DbViewHolder(@NonNull View itemView) {
            super(itemView);
            imageDesTV=itemView.findViewById(R.id.sr_recipe_desc);
            ourImagebtn=itemView.findViewById(R.id.sr_image);
        }
    }
}