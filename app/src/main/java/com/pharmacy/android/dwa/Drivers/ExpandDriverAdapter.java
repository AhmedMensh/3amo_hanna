package com.pharmacy.android.dwa.Drivers;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.R;

import java.util.ArrayList;
/**
 * Created by Sufyan_Karajeh on 2/28/2018.
 */

public class ExpandDriverAdapter extends BaseExpandableListAdapter {

    private ArrayList<SubCategoerItemModel> fragList;
    Context mContext;
    public ExpandDriverAdapter() {
    }

    public ExpandDriverAdapter(Context mContext, ArrayList<SubCategoerItemModel> fragList) {
        this.mContext = mContext;
        this.fragList = fragList;
    }

    @Override
    public int getGroupCount() {

        return fragList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return fragList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return i1;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    public View getGroupView(final int i, final boolean b, View view, ViewGroup viewGroup) {



            LayoutInflater inflater = (LayoutInflater)
                    this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parent_view, viewGroup, false);

            TextView OrNum=view.findViewById(R.id.nameItem);

        OrNum.setText(OrNum.getText().toString()+""+fragList.get(i).getName());




        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        //  String mID = mainCategories.get(i).getMainCategoryID();

        LayoutInflater inflater = (LayoutInflater)
                this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        view = inflater.inflate(R.layout.child_view, viewGroup, false);




        return view;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }


}