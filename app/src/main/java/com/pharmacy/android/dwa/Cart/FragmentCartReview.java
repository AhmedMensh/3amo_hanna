package com.pharmacy.android.dwa.Cart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DataModel.ItemCartModel;
import com.pharmacy.android.dwa.DialogFrag.DialogAddNewAddress;
import com.pharmacy.android.dwa.DialogFrag.DialogAddressHome;
import com.pharmacy.android.dwa.DialogFrag.DialogAfterSubmit;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.SessionApp;

import java.util.ArrayList;

public class FragmentCartReview extends Fragment {

    View rootView;
    TextView productTxt;
    TextView countPrice;

    TextView PaymentTxt;
    TextView PaymentPrice;
    TextView checkinfo;
    SessionApp sessionApp;
    public FragmentCartReview() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_review, container, false);

         sessionApp=new SessionApp(getContext());
         MainCart.TitleFragment.setText(R.string.revieworder);
        MainCart.TitleFragment.setTextColor(getResources().getColor(R.color.Red));
        MainCart.coora1.setBackground(getResources().getDrawable(R.drawable.coora));
        MainCart.coora2.setBackground(getResources().getDrawable(R.drawable.coora));
        MainCart.coora3.setBackground(getResources().getDrawable(R.drawable.coora3));
        MainCart.coora4.setBackground(getResources().getDrawable(R.drawable.coora));
        Button Confirm=rootView.findViewById(R.id.Confirm);




        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(sessionApp.getPaymentType().equals("1")){

//                  loadFragmentWithOutAnim(new FragmentCartPayment());
              }else if(sessionApp.getPaymentType().equals("2")) {
                  DialogAfterSubmit dFragment1 = new DialogAfterSubmit();
                  android.app.FragmentManager fm1 =((FragmentActivity) getActivity()).getFragmentManager();
                  dFragment1.setCancelable(false);
                  dFragment1.show(fm1, "Dialog");
              }
                //  loadFragmentWithOutAnim();
            }
        });

        iniElement();
        return rootView;
    }

    public void iniElement(){
        productTxt=  rootView.findViewById(R.id.productTxt);
        countPrice=  rootView.findViewById(R.id.countPrice);
        checkinfo=  rootView.findViewById(R.id.checkinfo);
        PaymentTxt= rootView.findViewById(R.id.PaymentTxt);
        PaymentPrice= rootView.findViewById(R.id.PaymentPrice);

        productTxt.setText("sample item\n\n" +
                "sample item\n\n" +
                "sample item\n\n" +
                "sample item");

        PaymentTxt.setText("SubTotal\n\n" +
                "Delivery Charges\n\n" +
                "Total Amount\n\n" +
                "Method");

        PaymentPrice.setText("$12,55\n\n" +
                "$2,5\n\n" +
                "$15,05\n\n" +
                "K-Net");


        countPrice.setText("$2,99\n\n" +
                "2*$2,99\n\n" +
                "$2,99\n\n" +
                "$2,99");
        checkinfo.setText("\n\n" +
                "E.g Johan Doe\n\n" +
                "00-555-555-6666\n\n" +
                "email@domain.com\n\n" +
                "City,building 5,street 10");
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
