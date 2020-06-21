package com.pharmacy.android.dwa.DialogFrag;

import android.Manifest;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.pharmacy.android.dwa.CartAdapter.AddressAdapter;
import com.pharmacy.android.dwa.DataModel.AddressDataModel;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.SwipeHelper;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class DialogAddressHome extends DialogFragment {


    GridLayoutManager mLayoutManager;
    RecyclerView recycler_item;
    AddressAdapter adapter;

    ArrayList<AddressDataModel> DataList=new ArrayList<AddressDataModel>();

    public DialogAddressHome() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.all_adress, container, false);
       getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.FILL_PARENT,
                WindowManager.LayoutParams.FILL_PARENT);

        LinearLayout back =rootView.findViewById(R.id.back);

        recycler_item=rootView.findViewById(R.id.recycler);

        mLayoutManager = new GridLayoutManager(getActivity(), 1, GridLayout.VERTICAL, false);
        recycler_item.setLayoutManager(mLayoutManager);

        Button AddAddress=rootView.findViewById(R.id.checkOut);

        AddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAddNewAddress dFragment1 = new DialogAddNewAddress();
                android.app.FragmentManager fm1 =((FragmentActivity) getActivity()).getFragmentManager();
                dFragment1.setCancelable(false);
                dFragment1.show(fm1, "Dialog");
            }
        });


        prepareData();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // view.startAnimation(buttonClick);
              dismiss();
            }
        });


        return rootView;
    }

    public  void setMessageToast(String mess)
    {
        Toast.makeText(getActivity(),mess+"",Toast.LENGTH_SHORT).show();
    }

    public void prepareData(){
        DataList.add(new AddressDataModel("Home","city,building1"));
        DataList.add(new AddressDataModel("Office","city,building2"));
        DataList.add(new AddressDataModel("test3","city,building3"));

        adapter=new AddressAdapter(getActivity(),DataList);
        recycler_item.setAdapter(adapter);

    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }
}
