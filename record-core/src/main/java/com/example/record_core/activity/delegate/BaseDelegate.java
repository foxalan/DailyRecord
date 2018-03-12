package com.example.record_core.activity.delegate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;

/**
 * Function :
 * Modify Date : 2018/3/12
 *
 * @Author : Alan
 * Issue : TODO
 * Whether Solve :
 */

public abstract class BaseDelegate extends Fragment implements ISupportFragment {

    private SupportFragmentDelegate DELEGATE = new SupportFragmentDelegate(this);


    /**
     * 得到Fragment的布局或View
     * @return
     */
    public abstract Object getLayout();

    /**
     * 绑定布局，用于进行子View的各种操作
     * @param savedInstanceState
     * @param rootView
     */
    public abstract void onBindView(Bundle savedInstanceState,View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView;

        if (getLayout() instanceof Integer){
            rootView = inflater.inflate((Integer) getLayout(),container,false);
        }else if (getLayout() instanceof View){
            rootView = (View) getLayout();
        }else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }

        onBindView(savedInstanceState,rootView);
        return rootView;
    }


}
