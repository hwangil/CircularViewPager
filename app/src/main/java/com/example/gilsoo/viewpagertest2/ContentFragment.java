package com.example.gilsoo.viewpagertest2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gilsoo on 2017-01-27.
 */
public class ContentFragment extends Fragment {

    TextView fragmentText;
    String text;
    public ContentFragment(){}
    public static ContentFragment newInstance(String text){
        ContentFragment contentFragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        fragmentText = (TextView)view.findViewById(R.id.fragmentText);
        fragmentText.setText(text);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            text = getArguments().getString("text");
        }else{
           text = "nop!";
        }
    }

}
