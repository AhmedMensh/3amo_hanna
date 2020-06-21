package com.pharmacy.android.dwa.CartAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.Cart.MainCart;
import com.pharmacy.android.dwa.DataModel.AddressDataModel;
import com.pharmacy.android.dwa.DataModel.ItemCartModel;
import com.pharmacy.android.dwa.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Sufyan_Karajeh on 2/20/2018.
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<AddressDataModel> fragmentList;


    public AddressAdapter(Context mContext, ArrayList<AddressDataModel> fragmentList) {
        this.mContext = mContext;
        this.fragmentList = fragmentList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_address, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final AddressDataModel storeCard = fragmentList.get(position);

holder.TitleAddress.setText(storeCard.getTitel());
holder.Address.setText(storeCard.getAddress());

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



        TextView TitleAddress;
        TextView Address;
        LinearLayout layCorner;
        ImageView imgCorener;


        public ViewHolder(View v) {
            super(v);

            TitleAddress =  v.findViewById(R.id.TitleAddress);
            Address=v.findViewById(R.id.addressTxt);
            layCorner=v.findViewById(R.id.layCorner);
            imgCorener=v.findViewById(R.id.imgCorener);


        }

    }
    public  void setMessageToast(String mess)
    {
        Toast.makeText(mContext,mess+"",Toast.LENGTH_SHORT).show();
    }




}