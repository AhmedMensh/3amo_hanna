package com.pharmacy.android.dwa.FragmentPages;

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

import java.util.ArrayList;

public class LstFragmentItems extends Fragment {

    View rootView;

    EditText searchHome;
    ImageView searchIcon;
    int colorSwip;
    RecyclerView recyclerViewItem,recyclerViewSubCategory;

    LinearLayout contentSubCategory;
    View viewLine;
    GridLayoutManager mLayoutManager;
    GridLayoutManager mLayoutManager1;
    ArrayList<SubCategoerItemModel> DataList=new ArrayList<SubCategoerItemModel>();


    ItemAdapter itemAdapter;
    SubCategoryAdapter subCategoryAdapter;
    int Index;
    Bundle bundle;
    public LstFragmentItems() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_lst_items, container, false);
       Constance.MainFGragment=1;
       MainHome.back.setVisibility(View.VISIBLE);
       MainHome.Scan.setVisibility(View.GONE);

       bundle = this.getArguments();
        initiElement();
        SearchHome();


        return rootView;
    }

    public void initiElement()
    {
        recyclerViewItem=rootView.findViewById(R.id.recycler_item);
        recyclerViewSubCategory=rootView.findViewById(R.id.recycler_sub_Category);
        contentSubCategory=rootView.findViewById(R.id.contentSubCategory);
        viewLine=rootView.findViewById(R.id.viewLine);
        searchHome=rootView.findViewById(R.id.serchHome);
        searchIcon=rootView.findViewById(R.id.searchIcon);

        mLayoutManager = new GridLayoutManager(getContext(), 1, GridLayout.HORIZONTAL, false);
        recyclerViewSubCategory.setLayoutManager(mLayoutManager);

        mLayoutManager1= new GridLayoutManager(getContext(), 1, GridLayout.VERTICAL, false);
        recyclerViewItem.setLayoutManager(mLayoutManager1);

        if(bundle != null){
            Index = bundle.getInt("Index");
            fillData(Index);
        }


        itemAdapter=new ItemAdapter(getActivity(),DataList,Index,1);
        recyclerViewItem.setAdapter(itemAdapter);
        subCategoryAdapter=new SubCategoryAdapter(getActivity(),DataList);
        recyclerViewSubCategory.setAdapter(subCategoryAdapter);


    }

    public void fillData(int position){
DataList.clear();
       if(position==1){
           DataList.add(new SubCategoerItemModel(getString(R.string.snacks)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.snacks)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.snacks)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.snacks)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.snacks)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.snacks)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.brown));
           viewLine.setBackgroundColor(getResources().getColor(R.color.brown));
           MainHome.title.setText(getResources().getString(R.string.snacks));
           Constance.ListSize=DataList.size();
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));
       }else if(position==2){
           DataList.add(new SubCategoerItemModel(getString(R.string.dairy)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.dairy)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.dairy)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.dairy)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.dairy)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.dairy)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.brown_light));
           viewLine.setBackgroundColor(getResources().getColor(R.color.brown_light));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.dairy));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }else if(position==3){
           DataList.add(new SubCategoerItemModel(getString(R.string.fruits)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.fruits)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.fruits)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.fruits)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.fruits)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.fruits)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.Red));
           viewLine.setBackgroundColor(getResources().getColor(R.color.Red));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.fruits));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }else if(position==4){
           DataList.add(new SubCategoerItemModel(getString(R.string.beverages)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.beverages)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.beverages)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.beverages)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.beverages)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.beverages)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.test));
           viewLine.setBackgroundColor(getResources().getColor(R.color.test));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.beverages));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }else if(position==5){
           DataList.add(new SubCategoerItemModel(getString(R.string.bakery)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.bakery)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.bakery)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.bakery)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.bakery)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.bakery)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.yellow));
           viewLine.setBackgroundColor(getResources().getColor(R.color.yellow));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.bakery));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }else if(position==6){
           DataList.add(new SubCategoerItemModel(getString(R.string.vegetables)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.vegetables)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.vegetables)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.vegetables)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.vegetables)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.vegetables)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.green));
           viewLine.setBackgroundColor(getResources().getColor(R.color.green));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.vegetables));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }

       else if(position==7){
           DataList.add(new SubCategoerItemModel(getString(R.string.personal_care)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.personal_care)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.personal_care)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.personal_care)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.personal_care)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.personal_care)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.blue));
           viewLine.setBackgroundColor(getResources().getColor(R.color.blue));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.personal_care));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }

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
                            setMessageToast(getString(R.string.sertchcomingsoon));
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
                    setMessageToast(getString(R.string.sertchcomingsoon));
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
