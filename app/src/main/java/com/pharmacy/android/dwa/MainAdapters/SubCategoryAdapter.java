package com.pharmacy.android.dwa.MainAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Sufyan_Karajeh on 2/20/2018.
 */

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<SubCategoerItemModel> fragmentList;
    int pos=-1;


    public SubCategoryAdapter(Context mContext, ArrayList<SubCategoerItemModel> fragmentList) {
        this.mContext = mContext;
        this.fragmentList = fragmentList;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_sub_category, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final SubCategoerItemModel storeCard = fragmentList.get(position);

        holder.NameItem.setText(storeCard.getName()+"");
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (Constance.backColor){
                    case 1: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.green));break;
                    case 2: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.blue));break;
                    case 3: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.Red));break;
                    case 4: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.test));break;
                    case 5: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.yellow));break;
                    case 6: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.green));break;
                }
                pos=position;


                notifyDataSetChanged();
            }
        });

        if(pos==position){
            switch (Constance.backColor){
                case 1:
                    holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.greenDark));break;
                case 2: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.blueDark));break;
                case 3: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.RedDark));break;
                case 4: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.testDark));break;
                case 5: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.yellowDark));break;
                case 6: holder.mainLayout.setBackgroundColor(mContext.getResources().getColor(R.color.greenDark));
                 break;
            }
            holder.NameItem.setTextColor(mContext.getResources().getColor(R.color.white));

        }else{
            holder.mainLayout.setBackground(mContext.getResources().getDrawable(R.drawable.boredrcorner5dp));
            holder.NameItem.setTextColor(mContext.getResources().getColor(R.color.black));
        }

    }


    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView NameItem;
         LinearLayout mainLayout;


        public ViewHolder(View v) {
            super(v);

            NameItem =  v.findViewById(R.id.nameSub);
            mainLayout =v.findViewById(R.id.mainLayout);


        }

    }


}