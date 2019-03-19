package org.pursuit.viewpager_json;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private String mParam1;
    private int mParam2;
    private String mParam3;
    private TextView textViewname;
    private TextView textViewNum;
    private ImageView imageView;


    public ViewFragment() {

    }

    public static ViewFragment newInstance(String image, int  number, String name) {
        ViewFragment fragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, image);
        args.putInt(ARG_PARAM2, number);
        args.putString(ARG_PARAM3, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textViewname = view.findViewById(R.id.viewpager_textView);
        textViewNum = view.findViewById(R.id.viewpager_textViewNumber);
        imageView = view.findViewById(R.id.viewpager_imageview);
        textViewname.setText(mParam3);
        textViewNum.setText(mParam2+"");
        Picasso.get().load(mParam1).into(imageView);
    }

}
