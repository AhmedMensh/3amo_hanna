package com.pharmacy.android.dwa.CartAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.Cart.MainCart;
import com.pharmacy.android.dwa.DataModel.ItemCartModel;
import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.DialogFrag.DialogScan;
import com.pharmacy.android.dwa.FragmentPages.FragmentDetailItem;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Sufyan_Karajeh on 2/20/2018.
 */

public class Item_cartAdapter extends RecyclerView.Adapter<Item_cartAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<ItemCartModel> fragmentList;
    SessionApp sessionApp;


    public Item_cartAdapter(Context mContext, ArrayList<ItemCartModel> fragmentList) {
        this.mContext = mContext;
        this.fragmentList = fragmentList;
sessionApp=new SessionApp(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_item_cart, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final ItemCartModel storeCard = fragmentList.get(position);

       holder.NameItem.setText(storeCard.getName());
        holder.weightItem.setText(storeCard.getWeight());
        holder.Price.setText("$"+storeCard.getPrice());
        holder.Count.setText(storeCard.getCount());

        holder.Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int count= Integer.parseInt(holder.Count.getText().toString());
               if(count<99)
                holder.Count.setText((count+1)+"");
            }
        });

        holder.Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count= Integer.parseInt(holder.Count.getText().toString());
                if(count>0)
                holder.Count.setText((count-1)+"");
            }
        });

        if(sessionApp.getLang().equals("en")) {
            holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_profile_notif_raight));
        }else{
            holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_profile_notif));

        }

        holder.layCorner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(MainCart.buttonClick);
                setMessageToast(mContext.getString(R.string.remove));
                fragmentList.remove(position);
                notifyDataSetChanged();
            }
        });

    }


    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        TextView NameItem;
        TextView weightItem;
        TextView Price;
        TextView Count;
        LinearLayout mainLayout;

        ImageView Add;
        ImageView Sub;
        CircleImageView image;
        LinearLayout layCorner;
        ImageView imgCorener;

        public ViewHolder(View v) {
            super(v);

            NameItem =  v.findViewById(R.id.nameItem);
            mainLayout=v.findViewById(R.id.mainLayout);

            weightItem =  v.findViewById(R.id.weightItem);
            Price=v.findViewById(R.id.price);
            Count=v.findViewById(R.id.count);
            Add =  v.findViewById(R.id.add);
            Sub=v.findViewById(R.id.sub);
            image=v.findViewById(R.id.image);
            layCorner=v.findViewById(R.id.layCorner);
            imgCorener=v.findViewById(R.id.imgCorener);

        }

    }

    public  void setMessageToast(String mess)
    {
        Toast.makeText(mContext,mess+"",Toast.LENGTH_SHORT).show();
    }





}