package com.pharmacy.android.dwa.FragmentPages;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;

public class MainFragmentSelect extends Fragment {
    Typeface typeface;
    View rootView;
    LinearLayout ball1,ball2,ball3,ball4,ball5, ball6;
    TextView txt1,txt2,txt3,txt4,txt5,txt6;
    EditText searchHome;
    ImageView searchIcon;
    public MainFragmentSelect() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_main_fragment_select, container, false);
       Constance.MainFGragment=0;
        MainHome.back.setVisibility(View.GONE);
        MainHome.Scan.setVisibility(View.VISIBLE);
        MainHome.title.setText(getString(R.string.Dwa));
        MainHome.subTitle.setText(getString(R.string.have_a_healthy_day));
       typeface= Typeface.createFromAsset(getContext().getAssets(), "fonts/LobsterTwo-Regular.ttf");

        initiElement();
        ballAction();

        SearchHome();


        return rootView;
    }

    public void initiElement()
    {
        ball1=rootView.findViewById(R.id.ball1);
        ball2=rootView.findViewById(R.id.ball2);
        ball3=rootView.findViewById(R.id.ball3);
        ball4=rootView.findViewById(R.id.ball4);
        ball5=rootView.findViewById(R.id.ball5);
        ball6=rootView.findViewById(R.id.ball6);

        txt1=rootView.findViewById(R.id.text1);
        txt2=rootView.findViewById(R.id.text2);
        txt3=rootView.findViewById(R.id.text3);
        txt4=rootView.findViewById(R.id.text4);
        txt5=rootView.findViewById(R.id.text5);
        txt6=rootView.findViewById(R.id.text6);

        txt1.setTypeface(typeface);
        txt2.setTypeface(typeface);
        txt3.setTypeface(typeface);
        txt4.setTypeface(typeface);
        txt5.setTypeface(typeface);
        txt6.setTypeface(typeface);

        searchHome=rootView.findViewById(R.id.serchHome);
        searchIcon=rootView.findViewById(R.id.searchIcon);


    }

    public void SearchHome()
    {
        searchHome.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        if(!searchHome.getText().toString().equals("")) {
                            InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            in.hideSoftInputFromWindow(searchHome.getWindowToken(), 0);
                            setMessageToast("Search Coming Soon");
                        }

                    return true;
                }
                return false;
            }
        });

        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!searchHome.getText().toString().equals("")) {
                    InputMethodManager in = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    in.hideSoftInputFromWindow(searchHome.getWindowToken(), 0);
                    setMessageToast("Search Coming Soon");
                }

            }
        });
    }
    public void ballAction()
    {
        ball1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constance.backColor=1;
               loadFragmentWithOutAnim(new LstFragmentItems(),Constance.backColor);
            }
        });
        ball2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constance.backColor=2;
                loadFragmentWithOutAnim(new LstFragmentItems(),Constance.backColor);
            }
        });
        ball3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constance.backColor=3;
                loadFragmentWithOutAnim(new LstFragmentItems(),Constance.backColor);
            }
        });
        ball4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constance.backColor=4;
                loadFragmentWithOutAnim(new LstFragmentItems(),Constance.backColor);
            }
        });
        ball5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constance.backColor=5;
                loadFragmentWithOutAnim(new LstFragmentItems(),Constance.backColor);
            }
        });
        ball6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Constance.backColor=6;
                loadFragmentWithOutAnim(new LstFragmentItems(),Constance.backColor);
            }
        });


    }
    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }

    public void loadFragmentWithOutAnim(Fragment fragment,int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("Index",position);
        fragment.setArguments(bundle);
        Constance.Index=position;
        getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        //  transaction.setCustomAnimations(R.anim.left_slid, 0, 0, R.anim.r_slide);
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();


    }






}
