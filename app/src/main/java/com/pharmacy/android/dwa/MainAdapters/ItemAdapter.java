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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.FragmentPages.FragmentDetailItem;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import java.util.ArrayList;

/**
 * Created by Sufyan_Karajeh on 2/20/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<SubCategoerItemModel> fragmentList;
    private int IndexParent;
    private int isSave;
    SessionApp sessionApp;


    public ItemAdapter(Context mContext, ArrayList<SubCategoerItemModel> fragmentList,int ind,int isSave) {
        this.mContext = mContext;
        this.fragmentList = fragmentList;
        IndexParent=ind;
        this.isSave=isSave;
        sessionApp=new SessionApp(mContext);

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

        if(isSave==1){

            if(IndexParent==1 ){
                if(sessionApp.getLang().equals("en")) {
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_brown_right));
                }else{
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_brown_left));

                }
            }else if(IndexParent==2){
                if(sessionApp.getLang().equals("en")) {
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_pink_right));
                }else{
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_pink_left));

                }
            }else if(IndexParent==3){
                if(sessionApp.getLang().equals("en")) {
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_profile_notif_raight));
                }else{
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_profile_notif));

                }
            }else if(IndexParent==4){
                if(sessionApp.getLang().equals("en")) {
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_test_right));
                }else{
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_test_left));

                }
            }else if(IndexParent==5){
                if(sessionApp.getLang().equals("en")) {
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_yello_right));
                }else{
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_yello_left));

                }

            }
            else if(IndexParent==7){
                if(sessionApp.getLang().equals("en")) {
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_check_raight));
                }else{
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_check_left));

                }

            }


            holder.layCorner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setAnimation(MainHome.buttonClick);
                    setMessageToast(  mContext.getString(R.string.saved));

                }
            });

        }else{
            if(IndexParent==4){
                if(sessionApp.getLang().equals("en")) {
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_test_right));
                }else{
                    holder.layCorner.setBackground(mContext.getResources().getDrawable(R.drawable.border_corner_test_left));

                }
            }
            holder.imgCorener.setImageDrawable(mContext.getResources().getDrawable(R.drawable.removeitem));

            holder.layCorner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    view.setAnimation(MainHome.buttonClick);
                    setMessageToast(  mContext.getString(R.string.remove));
                    fragmentList.remove(position);
                    notifyDataSetChanged();
                }
            });
        }



        switch (Constance.backColor){
            case 1:
                holder.itemIamge.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_snakes));
                holder.buyBtn.setTextColor(mContext.getResources().getColor(R.color.brown));
                break;
            case 2:
                holder.itemIamge.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_dairy));
                holder.buyBtn.setTextColor(mContext.getResources().getColor(R.color.brown_light));
                break;
            case 3:
                holder.itemIamge.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_fruits));
                holder.buyBtn.setTextColor(mContext.getResources().getColor(R.color.Red));
                break;
            case 4:
                holder.itemIamge.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_beverages));
                holder.buyBtn.setTextColor(mContext.getResources().getColor(R.color.test));
                break;
            case 5:
                holder.itemIamge.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_bakery));
                holder.buyBtn.setTextColor(mContext.getResources().getColor(R.color.yellow));
                break;
            case 6:
                holder.itemIamge.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_vegetables));
                holder.buyBtn.setTextColor(mContext.getResources().getColor(R.color.green));
                break;
            case 7:
                holder.itemIamge.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_personal_care));
                holder.buyBtn.setTextColor(mContext.getResources().getColor(R.color.blue));
                break;
        }

    }


    @Override
    public int getItemCount() {
        return fragmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView NameItem;
        LinearLayout mainLayout;

        Button buyBtn;
        LinearLayout layCorner;
        ImageView imgCorener ,itemIamge;

        public ViewHolder(View v) {
            super(v);

            itemIamge = v.findViewById(R.id.image);
            NameItem =  v.findViewById(R.id.nameItem);
            mainLayout=v.findViewById(R.id.mainLayout);
            layCorner=v.findViewById(R.id.layCorner);
            imgCorener=v.findViewById(R.id.imgCorener);
            buyBtn = v.findViewById(R.id.buy);


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
    public  void setMessageToast(String mess)
    {
        Toast.makeText(mContext,mess+"",Toast.LENGTH_SHORT).show();
    }


}