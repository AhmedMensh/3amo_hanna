package com.pharmacy.android.dwa.MainAdapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.FragmentPages.FragmentDetailItem;
import com.pharmacy.android.dwa.R;

import java.util.ArrayList;

/**
 * Created by Sufyan_Karajeh on 2/20/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<SubCategoerItemModel> fragmentList;
    private int IndexParent;


    public ItemAdapter(Context mContext, ArrayList<SubCategoerItemModel> fragmentList,int ind) {
        this.mContext = mContext;
        this.fragmentList = fragmentList;
        IndexParent=ind;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_item, parent, false);

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
                loadFragmentWithOutAnim(new FragmentDetailItem(),IndexParent);

            }
        });


    }


    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView NameItem;
        LinearLayout mainLayout;

        public ViewHolder(View v) {
            super(v);

            NameItem =  v.findViewById(R.id.nameItem);
            mainLayout=v.findViewById(R.id.mainLayout);


        }

    }

    public void loadFragmentWithOutAnim(Fragment fragment,int ind) {
        Bundle bundle = new Bundle();
        bundle.putInt("Index",ind);
        fragment.setArguments(bundle);
        FragmentTransaction transaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.add(R.id.frame_container, fragment);
        transaction.commit();
    }



}