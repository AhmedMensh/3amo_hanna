package com.pharmacy.android.dwa.Cart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.CartAdapter.Item_cartAdapter;
import com.pharmacy.android.dwa.DataModel.ItemCartModel;
import com.pharmacy.android.dwa.DialogFrag.DialogAddressHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.SessionApp;
import com.pharmacy.android.dwa.Utilities.SwipeHelper;

import java.util.ArrayList;
import java.util.List;

public class FragmentCartCheckOut extends Fragment {

    View rootView;
    LinearLayout Notifi,NotNotifi;
    TextView txtNotifi,txtNotNotifi;
    LinearLayout delivaryAddress;
    EditText editDelivAdd;

    SessionApp sessionApp;

    ArrayList<ItemCartModel> DataList=new ArrayList<ItemCartModel>();
    public FragmentCartCheckOut() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_checkout, container, false);

         sessionApp=new SessionApp(getContext());
         MainCart.TitleFragment.setText(R.string.checkout);
        MainCart.TitleFragment.setTextColor(getResources().getColor(R.color.blue));
        MainCart.coora1.setBackground(getResources().getDrawable(R.drawable.coora));
        MainCart.coora2.setBackground(getResources().getDrawable(R.drawable.coora2));
        MainCart.coora3.setBackground(getResources().getDrawable(R.drawable.coora));
        MainCart.coora4.setBackground(getResources().getDrawable(R.drawable.coora));
        Button review=rootView.findViewById(R.id.review);



        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragmentWithOutAnim(new FragmentCartReview());
            }
        });

        initiElement();
        ActionElement();

        return rootView;
    }
    public void initiElement(){

        Notifi=rootView.findViewById(R.id.LayleftNot);
        NotNotifi=rootView.findViewById(R.id.LayRighttNot);
        delivaryAddress=rootView.findViewById(R.id.delivaryAddress);
        editDelivAdd=rootView.findViewById(R.id.editDelivAdd);


        txtNotifi=rootView.findViewById(R.id.leftNot);
        txtNotNotifi=rootView.findViewById(R.id.RighttNot);




        actionClick(1);
    }

    public void actionClick(int id){
        switch (id){
            case 1:
                if(sessionApp.getLang().equals("en")) {
                    Notifi.setBackground(getResources().getDrawable(R.drawable.border_check_left));
                 }
                else {
                    Notifi.setBackground(getResources().getDrawable(R.drawable.border_check_raight));
                }
                txtNotifi.setTextColor(getResources().getColor(R.color.white));

                NotNotifi.setBackground(null);
                txtNotNotifi.setTextColor(getResources().getColor(R.color.gray));
                sessionApp.setPaymentType("1");
                break;

            case 2:
                Notifi.setBackground(null);
                txtNotifi.setTextColor(getResources().getColor(R.color.gray));
                if(sessionApp.getLang().equals("en")) {
                    NotNotifi.setBackground(getResources().getDrawable(R.drawable.border_check)); }
                else {
                    NotNotifi.setBackground(getResources().getDrawable(R.drawable.border_check_left));
                }

                txtNotNotifi.setTextColor(getResources().getColor(R.color.white));
                sessionApp.setPaymentType("2");
                break;
        }
    }

    public void ActionElement(){

        Notifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClick(1);
            }
        });
        NotNotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionClick(2);
            }
        });

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

    public void loadFragmentWithOutAnim(Fragment fragment) {

        ((FragmentActivity) getContext()).getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        FragmentTransaction transaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame_container_cart, fragment);
        transaction.commit();
    }

}
