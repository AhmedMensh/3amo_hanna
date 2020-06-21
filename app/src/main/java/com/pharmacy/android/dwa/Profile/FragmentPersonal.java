package com.pharmacy.android.dwa.Profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DialogFrag.DialogAddressHome;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;

public class FragmentPersonal extends Fragment {

    View rootView;
    LinearLayout delivaryAddress;
    EditText editDelivAdd;
    public FragmentPersonal() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_personal, container, false);


        initiElement();

        ActionElement();
        return rootView;
    }
    public void initiElement(){

        delivaryAddress=rootView.findViewById(R.id.delAdd);
        editDelivAdd=rootView.findViewById(R.id.editDelivAdd);

    }

    public void ActionElement(){
        delivaryAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAddressHome dFragment1 = new DialogAddressHome();
                android.app.FragmentManager fm1 =((FragmentActivity) getContext()).getFragmentManager();
                dFragment1.setCancelable(false);
                dFragment1.show(fm1, "Dialog");
            }
        });
        editDelivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogAddressHome dFragment1 = new DialogAddressHome();
                android.app.FragmentManager fm1 =((FragmentActivity) getContext()).getFragmentManager();
                dFragment1.setCancelable(false);
                dFragment1.show(fm1, "Dialog");
            }
        });
    }
    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }


}
