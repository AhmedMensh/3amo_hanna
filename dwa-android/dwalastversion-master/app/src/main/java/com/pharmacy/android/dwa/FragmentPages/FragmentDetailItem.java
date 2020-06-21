package com.pharmacy.android.dwa.FragmentPages;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pharmacy.android.dwa.DataModel.SubCategoerItemModel;
import com.pharmacy.android.dwa.DialogFrag.DialogScan;
import com.pharmacy.android.dwa.Home.MainHome;
import com.pharmacy.android.dwa.MainAdapters.ItemAdapter;
import com.pharmacy.android.dwa.MainAdapters.SubCategoryAdapter;
import com.pharmacy.android.dwa.R;
import com.pharmacy.android.dwa.Utilities.Constance;
import com.pharmacy.android.dwa.Utilities.SwipeHelper;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class FragmentDetailItem extends Fragment {

    View rootView;
    Bundle bundle;
    int Index;


    public FragmentDetailItem() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView=inflater.inflate(R.layout.fragment_details_item, container, false);
       Constance.MainFGragment=10;
        MainHome.back.setVisibility(View.VISIBLE);
        MainHome.Scan.setVisibility(View.GONE);

        MainHome.title.setText("sample item");
        MainHome.subTitle.setText("weight 10g");

        bundle = this.getArguments();

        final int[] sampleImages = {R.drawable.imgtest1, R.drawable.imgtest2,
                R.drawable.imgtest3};

        CarouselView carouselView= rootView.findViewById(R.id.carouselView);
        TextView Description= rootView.findViewById(R.id.description);
        carouselView.setPageCount(sampleImages.length);
        View viewLine=rootView.findViewById(R.id.viewLine);
        View viewLine1=rootView.findViewById(R.id.viewLine1);

        Button Buy=rootView.findViewById(R.id.buy);
        ImageView Scan=rootView.findViewById(R.id.scan);
        ImageView save=rootView.findViewById(R.id.save);


        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMessageToast("Buy");
            }
        });
        Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogScan dFragment1 = new DialogScan();
                android.app.FragmentManager fm1 =((FragmentActivity) getContext()).getFragmentManager();
                dFragment1.setCancelable(false);
                dFragment1.show(fm1, "Dialog");

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMessageToast("save");
            }
        });

        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(sampleImages[position]);
            }
        });

        Description.setText("Lobster Two Bold\n" +
                "\n" +
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab accusamus aspernatur atque consequuntur corporis cupiditate dicta doloremque eligendi eum facere facilis id, illo ipsa ipsam laboriosam magni maxime nostrum nulla numquam obcaecati officia omnis praesentium quas quidem quisquam tenetur ullam. Aperiam assumenda culpa est maiores odio repellendus sapiente tenetur voluptatem?");

        if(bundle != null){
            Index = bundle.getInt("Index");
            switch (Index){
                case 1:
                    viewLine.setBackgroundColor(getResources().getColor(R.color.green));
                    viewLine1.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 2:
                    viewLine.setBackgroundColor(getResources().getColor(R.color.blue));
                    viewLine1.setBackgroundColor(getResources().getColor(R.color.blue));
                    break;
                case 3:
                    viewLine.setBackgroundColor(getResources().getColor(R.color.Red));
                    viewLine1.setBackgroundColor(getResources().getColor(R.color.Red));
                    break;
                case 4:
                    viewLine.setBackgroundColor(getResources().getColor(R.color.test));
                    viewLine1.setBackgroundColor(getResources().getColor(R.color.test));
                    break;
                case 5:
                    viewLine.setBackgroundColor(getResources().getColor(R.color.yellow));
                    viewLine1.setBackgroundColor(getResources().getColor(R.color.yellow));
                    break;
                case 6:
                    viewLine.setBackgroundColor(getResources().getColor(R.color.green));
                    viewLine1.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
            }
        }
        return rootView;
    }

    public  void setMessageToast(String mess)
    {
        Toast.makeText(getContext(),mess+"",Toast.LENGTH_SHORT).show();
    }



}
