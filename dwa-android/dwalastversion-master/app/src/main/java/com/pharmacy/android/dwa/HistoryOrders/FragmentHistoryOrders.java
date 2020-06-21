package com.pharmacy.android.dwa.HistoryOrders;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.MainAdapters.HistoryOrderAdapter;
import com.pharmacy.android.dwa.MainAdapters.ItemAdapter;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FragmentHistoryOrders extends Fragment {

    View rootView;
    RecyclerView recycler;
    GridLayoutManager mLayoutManager;
    HistoryOrderAdapter historyOrderAdapter;

    ArrayList<SubCategoerItemModel> DataList=new ArrayList<SubCategoerItemModel>();

    public FragmentHistoryOrders() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_lst_history, container, false);
       Constance.MainFGragment=1;
        MainHome.back.setVisibility(View.VISIBLE);
        MainHome.Scan.setVisibility(View.GONE);

        MainHome.title.setText(R.string.orders);
        MainHome.subTitle.setText("You have 3 current orders");
        initiElement();

        return rootView;
    }
    public void initiElement(){
        recycler=rootView.findViewById(R.id.recycler);
        mLayoutManager = new GridLayoutManager(getContext(), 1, GridLayout.VERTICAL, false);
        recycler.setLayoutManager(mLayoutManager);


        DataList.add(new SubCategoerItemModel("1"));
        DataList.add(new SubCategoerItemModel("2"));
        DataList.add(new SubCategoerItemModel("3"));


        historyOrderAdapter=new HistoryOrderAdapter(getActivity(),DataList);
         recycler.setAdapter(historyOrderAdapter);
    }


    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }

}
