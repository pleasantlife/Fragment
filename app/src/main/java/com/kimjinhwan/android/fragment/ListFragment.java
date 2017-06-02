package com.kimjinhwan.android.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    MainActivity activity;

    public ListFragment() {
        // Required empty public constructor
    }

    public void setActivity(MainActivity activity){
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,                  //여기서 LayoutInFlater의 inflater는 이미 완성되어있는 레이아웃.
                             Bundle savedInstanceState) {

        //fragment의 메인 레이아웃을 inflate하고
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        //안의 위젯들을 코드에 연결한다.
        Button btnGo = (Button) view.findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.addDetail();
            }
        });
        return view;
    }

}
