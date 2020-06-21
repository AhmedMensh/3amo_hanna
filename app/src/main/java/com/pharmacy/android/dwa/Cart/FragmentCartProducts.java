package com.pharmacy.android.dwa.Cart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.CartAdapter.Item_cartAdapter;
import com.pharmacy.android.dwa.DataModel.ItemCartModel;
import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.DialogFrag.DialogScan;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.LogReg.ChooseUser;
import com.pharmacy.android.dwa.LogReg.Login;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SessionApp;
import com.pharmacy.android.dwa.Utilities.SwipeHelper;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import spencerstudios.com.bungeelib.Bungee;

public class FragmentCartProducts extends Fragment {

    View rootView;
    Item_cartAdapter adapter;
    GridLayoutManager mLayoutManager;
    RecyclerView recycler_item;
    SessionApp sessionApp;
 CardView TakeScan;
    ArrayList<ItemCartModel> DataList=new ArrayList<ItemCartModel>();
    public FragmentCartProducts() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_product, container, false);

         sessionApp=new SessionApp(getContext());
        recycler_item=rootView.findViewById(R.id.recycler_item);
        TakeScan=rootView.findViewById(R.id.TakeScan);
        mLayoutManager = new GridLayoutManager(getContext(), 1, GridLayout.VERTICAL, false);
        recycler_item.setLayoutManager(mLayoutManager);


        Button checkOut=rootView.findViewById(R.id.checkOut);

        prepareData();

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sessionApp.Logedin() || sessionApp.getUserType().equals("3")){
                    loadFragmentWithOutAnim(new FragmentCartCheckOut());
                }else {
                    Intent intent = new Intent(getActivity(), ChooseUser.class);
                    getActivity().finish();
                    startActivity(intent);
                    Bungee.fade(getActivity());
                }

            }
        });

        TakeScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setAnimation(MainCart.buttonClick);
                DialogScan dFragment1 = new DialogScan();
                android.app.FragmentManager fm1 =((FragmentActivity) getContext()).getFragmentManager();
                dFragment1.setCancelable(false);
                dFragment1.show(fm1, "Dialog");

            }
        });



        return rootView;
    }
    public void prepareData(){
        DataList.add(new ItemCartModel("test1","10 gram","8","15.8","-1"));
        DataList.add(new ItemCartModel("test2","50 gram","2","25.6","-1"));
        DataList.add(new ItemCartModel("test3","30 gram","5","10.7","-1"));

        adapter=new Item_cartAdapter(getContext(),DataList);
        recycler_item.setAdapter(adapter);

    }

    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }

    public void loadFragmentWithOutAnim(Fragment fragment) {

        ((FragmentActivity) getContext()).getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        FragmentTransaction transaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame_container_cart, fragment);
        transaction.commit();
    }

}
