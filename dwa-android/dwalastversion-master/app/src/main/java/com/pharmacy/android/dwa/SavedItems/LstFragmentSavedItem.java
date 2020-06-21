package com.pharmacy.android.dwa.SavedItems;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.MainAdapters.ItemAdapter;
import com.pharmacy.android.dwa.MainAdapters.SubCategoryAdapter;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SwipeHelper;

import java.util.ArrayList;
import java.util.List;

public class LstFragmentSavedItem extends Fragment {

    View rootView;

    EditText searchHome;
    ImageView searchIcon;
    RecyclerView recyclerViewItem;

    GridLayoutManager mLayoutManager1;
    ArrayList<SubCategoerItemModel> DataList=new ArrayList<SubCategoerItemModel>();


    ItemAdapter itemAdapter;
    public LstFragmentSavedItem() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_lst_saved, container, false);
       Constance.MainFGragment=9;
       MainHome.back.setVisibility(View.VISIBLE);
       MainHome.Scan.setVisibility(View.GONE);

        MainHome.title.setText(R.string.saved);
        MainHome.subTitle.setText("You Have 6 saved products");

        initiElement();
        SearchHome();


        return rootView;
    }

    public void initiElement()
    {
        recyclerViewItem=rootView.findViewById(R.id.recycler_item);
        searchHome=rootView.findViewById(R.id.serchHome);
        searchIcon=rootView.findViewById(R.id.searchIcon);



        mLayoutManager1= new GridLayoutManager(getContext(), 1, GridLayout.VERTICAL, false);
        recyclerViewItem.setLayoutManager(mLayoutManager1);


        fillData();
        itemAdapter=new ItemAdapter(getActivity(),DataList,4);
        recyclerViewItem.setAdapter(itemAdapter);


new SwipeHelper(getActivity(), recyclerViewItem) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, final List<UnderlayButton> underlayButtons) {


                underlayButtons.add(new UnderlayButton(
                        "Remove",
                        0,
                        getResources().getColor(R.color.test),
                        new UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                setMessageToast("Removed "+pos);
                            }
                        }
                ));


            }
        };

    }

    public void fillData(){
DataList.clear();

        DataList.add(new SubCategoerItemModel(getString(R.string.medicines)+"1"));
        DataList.add(new SubCategoerItemModel(getString(R.string.cosmetics)+"5"));
        DataList.add(new SubCategoerItemModel(getString(R.string.medicines)+"1"));
        DataList.add(new SubCategoerItemModel(getString(R.string.other)+"4"));
        DataList.add(new SubCategoerItemModel(getString(R.string.supplements)+"2"));
        DataList.add(new SubCategoerItemModel(getString(R.string.equipments)+"1"));
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
    public void AllAction()
    {


    }
    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }


}
