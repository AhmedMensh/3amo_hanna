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
import com.pharmacy.android.dwa.Utilities.SwipeHelper;
import com.pharmacy.android.dwa.Utilities.Constance;

import java.util.ArrayList;
import java.util.List;

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


        itemAdapter=new ItemAdapter(getActivity(),DataList,Index);
        recyclerViewItem.setAdapter(itemAdapter);
        subCategoryAdapter=new SubCategoryAdapter(getActivity(),DataList);
        recyclerViewSubCategory.setAdapter(subCategoryAdapter);


new SwipeHelper(getActivity(), recyclerViewItem) {
            @Override
            public void instantiateUnderlayButton(RecyclerView.ViewHolder viewHolder, final List<UnderlayButton> underlayButtons) {
                switch (Index){
                    case 1:
                        colorSwip=getResources().getColor(R.color.green);
                        break;
                    case 2:colorSwip=getResources().getColor(R.color.blue); break;
                    case 3:colorSwip=getResources().getColor(R.color.Red); break;
                    case 4:colorSwip=getResources().getColor(R.color.test); break;
                    case 5:colorSwip=getResources().getColor(R.color.yellow); break;
                    case 6:colorSwip=getResources().getColor(R.color.green); break;
                }

                underlayButtons.add(new SwipeHelper.UnderlayButton(
                        getString(R.string.save),
                        0,
                       colorSwip,
                        new SwipeHelper.UnderlayButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                setMessageToast("Save "+pos);
                            }
                        }
                ));


            }
        };

    }

    public void fillData(int position){
DataList.clear();
       if(position==1){
           DataList.add(new SubCategoerItemModel(getString(R.string.medicines)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.medicines)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.medicines)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.medicines)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.medicines)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.medicines)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.green));
           viewLine.setBackgroundColor(getResources().getColor(R.color.green));
           MainHome.title.setText(getResources().getString(R.string.medicines));
           Constance.ListSize=DataList.size();
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));
       }else if(position==2){
           DataList.add(new SubCategoerItemModel(getString(R.string.supplements)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.supplements)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.supplements)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.supplements)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.supplements)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.supplements)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.blue));
           viewLine.setBackgroundColor(getResources().getColor(R.color.blue));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.supplements));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }else if(position==3){
           DataList.add(new SubCategoerItemModel(getString(R.string.kids)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.kids)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.kids)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.kids)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.kids)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.kids)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.Red));
           viewLine.setBackgroundColor(getResources().getColor(R.color.Red));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.kids));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }else if(position==4){
           DataList.add(new SubCategoerItemModel(getString(R.string.cosmetics)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.cosmetics)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.cosmetics)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.cosmetics)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.cosmetics)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.cosmetics)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.test));
           viewLine.setBackgroundColor(getResources().getColor(R.color.test));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.cosmetics));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }else if(position==5){
           DataList.add(new SubCategoerItemModel(getString(R.string.equipments)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.equipments)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.equipments)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.equipments)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.equipments)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.equipments)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.yellow));
           viewLine.setBackgroundColor(getResources().getColor(R.color.yellow));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.equipments));
           MainHome.subTitle.setText(getString(R.string.Around)+" "+DataList.size()+" "+getString(R.string.items));

       }else if(position==6){
           DataList.add(new SubCategoerItemModel(getString(R.string.other)+"1"));
           DataList.add(new SubCategoerItemModel(getString(R.string.other)+"2"));
           DataList.add(new SubCategoerItemModel(getString(R.string.other)+"3"));
           DataList.add(new SubCategoerItemModel(getString(R.string.other)+"4"));
           DataList.add(new SubCategoerItemModel(getString(R.string.other)+"5"));
           DataList.add(new SubCategoerItemModel(getString(R.string.other)+"6"));

           contentSubCategory.setBackgroundColor(getResources().getColor(R.color.green));
           viewLine.setBackgroundColor(getResources().getColor(R.color.green));
           Constance.ListSize=DataList.size();
           MainHome.title.setText(getResources().getString(R.string.other));
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
