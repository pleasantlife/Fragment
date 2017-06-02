package com.kimjinhwan.android.fragment;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListFragment list;
    DetailFragment detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //프레그먼트 생성
        createFragments();
        //
        addList();
    }


    private void createFragments(){
        list = new ListFragment();
        list.setActivity(this);
        detail = new DetailFragment();
        detail.setActivity(this);
    }

    public void addList(){
        /*
           프래그먼트 화면에 넣기
         */
        //1. 프래그먼트 트랜잭션 시작하기

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); //Support가 붙은건 버전호환성을 위해 새로 만들어진 것.                             //호환성을 감안하여 support v4의 FragmentTransaction을 사용할 것. v4 : api ver 4 이상부터 지원함.
        //2. 화면에 프래그먼트 넣기
        transaction.add(R.id.container, list);                                            //transaction을 사용하면 stack구조를 사용할 수 있게 됨.
        //3. 스택을 사용하겠다고 알림

        //4. 트랜잭션 완료
       transaction.commit();
    }

    public void addDetail(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, detail);
        //트랜잭션 처리 전체를 stack에 담아놨다가, 안드로이드의 back버튼으로 뒤로 가기를 할 수 있다.
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void backToList(){
        super.onBackPressed();              //onBackPressed();뒤로가기 효과를 주는 함수
    }
}
