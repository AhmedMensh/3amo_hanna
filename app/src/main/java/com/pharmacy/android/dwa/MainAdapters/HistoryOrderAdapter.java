package com.pharmacy.android.dwa.MainAdapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.FragmentPages.FragmentDetailItem;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;

import java.util.ArrayList;

/**
 * Created by Sufyan_Karajeh on 2/20/2018.
 */

public class HistoryOrderAdapter extends RecyclerView.Adapter<HistoryOrderAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<SubCategoerItemModel> fragmentList;



    public HistoryOrderAdapter(Context mContext, ArrayList<SubCategoerItemModel> fragmentList) {
        this.mContext = mContext;
        this.fragmentList = fragmentList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_history, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final SubCategoerItemModel storeCard = fragmentList.get(position);


        holder.productTxt.setText("sample item\n" +
                "sample item\n" +
                "sample item\n" +
                "sample item");

        holder.countPrice.setText("$2,99\n" +
                "2*$2,99\n" +
                "$2,99\n" +
                "$2,99");
        holder.checkinfo.setText("\n" +
                "E.g Johan Doe\n" +
                "00-555-555-6666\n" +
                "email@domain.com\n" +
                "City,building 5,street 10");

        if(storeCard.getName().equals("1")){
            holder.viewLine1.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
            holder.Tracking.setVisibility(View.VISIBLE);
            holder.NumOrder.setText("Order #"+storeCard.getName());

            holder.DateOredr.setText(Html.fromHtml("<font color=\""
                    +mContext.getResources().getColor(R.color.blue)+"\">"+
                    "Current Order" + "</font>"+" | 09.01.2019"));
            holder.mainLayoutCheck.setVisibility(View.GONE);

            holder.LineProduct.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
            holder.LineCheckInf.setBackgroundColor(mContext.getResources().getColor(R.color.blue));
            holder.titleProduct.setTextColor(mContext.getResources().getColor(R.color.blue));
            holder.titleCheckInfo.setTextColor(mContext.getResources().getColor(R.color.blue));
            holder.seeData.setTextColor(mContext.getResources().getColor(R.color.blue));
            holder.seeData.setBackground(mContext.getResources().getDrawable(R.drawable.button_border_blue));
            holder.seeData.setText(mContext.getString(R.string.see_more));

        }else{
            holder.viewLine1.setBackgroundColor(mContext.getResources().getColor(R.color.silver));
            holder.Tracking.setVisibility(View.GONE);
            holder.NumOrder.setText(mContext.getString(R.string.ordernum)+storeCard.getName());
//
            holder.DateOredr.setText(Html.fromHtml("<font color=\""
                    +mContext.getResources().getColor(R.color.gray)+"\">"+
                    mContext.getString(R.string.prv_oredr)+ "</font>"+" | 07.01.2019"));
            holder.mainLayoutCheck.setVisibility(View.GONE);

            holder.LineProduct.setBackgroundColor(mContext.getResources().getColor(R.color.gray));
            holder.LineCheckInf.setBackgroundColor(mContext.getResources().getColor(R.color.gray));
            holder.titleProduct.setTextColor(mContext.getResources().getColor(R.color.gray));
            holder.titleCheckInfo.setTextColor(mContext.getResources().getColor(R.color.gray));
            holder.seeData.setTextColor(mContext.getResources().getColor(R.color.black));
            holder.seeData.setBackground(mContext.getResources().getDrawable(R.drawable.button_border_black));
            holder.seeData.setText(mContext.getString(R.string.see_more));
        }

        holder.seeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(MainHome.buttonClick);
                if(holder.mainLayoutCheck.isShown()){
                    holder.mainLayoutCheck.setVisibility(View.GONE);
                    holder.seeData.setText(mContext.getString(R.string.see_more));
                }else{
                    holder.mainLayoutCheck.setVisibility(View.VISIBLE);
                    holder.seeData.setText(mContext.getString(R.string.see_less));
                }
            }
        });

        holder.Tracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(MainHome.buttonClick);
                setMessageToast(  mContext.getString(R.string.coomingsoon));
            }
        });
    }


    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView NumOrder;
         TextView DateOredr;
         TextView titleProduct;
        TextView productTxt;
        TextView countPrice;
        TextView checkinfo;
        TextView titleCheckInfo;

        View LineProduct;
        View LineCheckInf;


       View  viewLine1;
        LinearLayout mainLayoutCheck;

        LinearLayout Tracking;
        Button seeData;

        public ViewHolder(View v) {
            super(v);

            NumOrder =  v.findViewById(R.id.numOrder);
            DateOredr =  v.findViewById(R.id.DateOredr);
            titleProduct =  v.findViewById(R.id.titleProduct);
            titleCheckInfo =  v.findViewById(R.id.titleCheckInfo);

            LineProduct =  v.findViewById(R.id.LineProducts);
            LineCheckInf =  v.findViewById(R.id.LineCheck);
            viewLine1=  v.findViewById(R.id.viewLine1);

             productTxt=  v.findViewById(R.id.productTxt);
             countPrice=  v.findViewById(R.id.countPrice);
             checkinfo=  v.findViewById(R.id.checkinfo);



            mainLayoutCheck=v.findViewById(R.id.layoutCheckInfo);
            Tracking=v.findViewById(R.id.Tracking);

            seeData=v.findViewById(R.id.seeData);



        }

    }

    public  void setMessageToast(String mess)
    {
        Toast.makeText(mContext,mess+"",Toast.LENGTH_SHORT).show();
    }

}