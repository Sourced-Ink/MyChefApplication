package com.example.mycheflogin.Model;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mycheflogin.R;
import com.example.mycheflogin.RecipeStepsActivity;

import java.util.ArrayList;

public class DbAdapter extends RecyclerView.Adapter<DbAdapter.DbViewHolder> {

     ArrayList<DbModelClass> objModelClassArrayList;
     private OnClicking myOnClick;
//     private static String recipeSteps;

    public DbAdapter(ArrayList<DbModelClass> objModelClassArrayList, OnClicking onClicking){
        this.objModelClassArrayList=objModelClassArrayList;
        this.myOnClick=onClicking;
    }

    @NonNull
    @Override
    public DbViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row, parent,false);
        return new DbViewHolder(singleRow, myOnClick);
    }

    @Override
    public void onBindViewHolder(@NonNull DbViewHolder holder, final int position) {
        DbModelClass objDbModelClass=objModelClassArrayList.get(position);
        holder.imageDesTV.setText(objDbModelClass.getImageDes());
        holder.ourImagebtn.setImageBitmap(objDbModelClass.getOurImage());
    }


    @Override
    public int getItemCount() {
        return objModelClassArrayList.size();
    }

    public static class DbViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OnClicking onClicking;

        TextView imageDesTV;
        ImageButton ourImagebtn;

        public DbViewHolder(@NonNull View itemView, OnClicking onClicking) {
            super(itemView);
            imageDesTV=itemView.findViewById(R.id.sr_recipe_desc);
            ourImagebtn=itemView.findViewById(R.id.sr_image);

            this.onClicking=onClicking;

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            onClicking.onItemClick(getAdapterPosition());
        }
    }

    public interface OnClicking{
        void onItemClick(int position);
    }
}
