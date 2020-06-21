package com.pharmacy.android.dwa.DriverFragments;

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
import android.widget.ExpandableListView;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.Drivers.ExpandDriverAdapter;
import com.pharmacy.android.dwa.MainAdapters.SubCategoryAdapter;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;

import java.util.ArrayList;

public class FragmentDeliveredOrderDriver extends Fragment {

    View rootView;
    EditText searchHome;
    ImageView searchIcon;

    RecyclerView recyclerViewSubCategory;
    SubCategoryAdapter subCategoryAdapter;

    public  ExpandableListView expandableListView;
    GridLayoutManager mLayoutManager;
    ArrayList<SubCategoerItemModel> DataList=new ArrayList<SubCategoerItemModel>();
    ArrayList<SubCategoerItemModel> DataList1=new ArrayList<SubCategoerItemModel>();
    ExpandDriverAdapter expandListAdapter;
    int previousGroup = -1;
    public FragmentDeliveredOrderDriver() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_deliverd_oredrdriver, container, false);
       Constance.MainFGragment=0;
        Constance.backColor=2;


        initiElement();
        SearchHome();
        fillData();


        return rootView;
    }

    public void initiElement()
    {
        expandableListView =  rootView.findViewById(R.id.exLayout);
        recyclerViewSubCategory=rootView.findViewById(R.id.recycler_sub_Category);
        searchHome=rootView.findViewById(R.id.serchHome);
        searchIcon=rootView.findViewById(R.id.searchIcon);

        mLayoutManager = new GridLayoutManager(getContext(), 1, GridLayout.HORIZONTAL, false);
        recyclerViewSubCategory.setLayoutManager(mLayoutManager);


        subCategoryAdapter=new SubCategoryAdapter(getActivity(),DataList);
        recyclerViewSubCategory.setAdapter(subCategoryAdapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {


                if (groupPosition != previousGroup) {
                    expandableListView.collapseGroup(previousGroup);
                    previousGroup = groupPosition;

                } else {
                    expandableListView.collapseGroup(0);
                    previousGroup = -1;

                }
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                previousGroup = -1;
            }
        });


        expandListAdapter = new ExpandDriverAdapter(getContext(), DataList1);
        expandableListView.setAdapter(expandListAdapter);
    }

    public void fillData()
    {
        DataList.clear();
            DataList.add(new SubCategoerItemModel(getString(R.string.today)));
            DataList.add(new SubCategoerItemModel(getString(R.string.thisweek)));
            DataList.add(new SubCategoerItemModel(getString(R.string.tismonth)));
            DataList.add(new SubCategoerItemModel(getString(R.string.select)));

        DataList1.clear();
            DataList1.add(new SubCategoerItemModel("1255"));
            DataList1.add(new SubCategoerItemModel("2565"));
            DataList1.add(new SubCategoerItemModel("9665"));
            DataList1.add(new SubCategoerItemModel("9668"));
            DataList1.add(new SubCategoerItemModel("3328"));
            DataList1.add(new SubCategoerItemModel("3615"));

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
