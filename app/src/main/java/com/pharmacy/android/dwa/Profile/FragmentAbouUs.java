package com.pharmacy.android.dwa.Profile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pharmacy.android.dwa.R;

public class FragmentAbouUs extends Fragment {

    View rootView;
    public FragmentAbouUs() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_aboutus, container, false);


        initiElement();

        ActionElement();
        return rootView;
    }
    public void initiElement(){



    }

    public void ActionElement(){

    }
    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }


}
