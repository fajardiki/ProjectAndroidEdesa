package com.example.projectandroidedesa;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projectandroidedesa._sliders.FragmentSlider;
import com.example.projectandroidedesa._sliders.SliderIndicator;
import com.example.projectandroidedesa._sliders.SliderPagerAdapter;
import com.example.projectandroidedesa._sliders.SliderView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    String [] tittles =  {"Tittle1","Tittle2","Tittle3","Tittle4","Tittle4"};
    String [] deskriptions =  {"Deskription1","Deskription1","Deskription1","Deskription1","Deskription1"};
    int [] images = {R.drawable.logo1,R.drawable.logo2,R.drawable.logo3,R.drawable.logo4,R.drawable.logo5};
    ListView lv;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        // list view

        lv = (ListView) rootView.findViewById(R.id.listpengumuman);
        MyAdapter adapter = new MyAdapter(getActivity(), tittles, deskriptions, images);
        lv.setAdapter(adapter);

        return rootView;

    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }

    class MyAdapter extends ArrayAdapter {
        int [] imageArray;
        String [] deskriptionArray;
        String [] tittleArray;

        public MyAdapter(FragmentActivity activity, String[] tittles, String[] deskriptions, int[] images) {
            super(activity, R.layout.listview_pengumuman,R.id.idjudul, tittles);
            this.imageArray = images;
            this.deskriptionArray = deskriptions;
            this.tittleArray = tittles;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
        // inflating layout
        LayoutInflater inflater  = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_pengumuman, parent, false);

        // Get the reference to the view object
        ImageView myImage = (ImageView) row.findViewById(R.id.idPic);
        TextView myTittle = (TextView) row.findViewById(R.id.idjudul);
        TextView myDescription = (TextView) row.findViewById(R.id.idisi);

        // Providing the element of an array by specifying its position
        myImage.setImageResource(imageArray[position]);
        myTittle.setText(tittleArray[position]);
        myDescription.setText(deskriptionArray[position]);

        return row;
        }
    }

}
