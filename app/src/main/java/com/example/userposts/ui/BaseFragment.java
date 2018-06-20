package com.example.userposts.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.userposts.R;
import com.example.userposts.ui.common.AppMvpPresenter;
import com.example.userposts.ui.common.AppMvpView;

/**
 * {@link BaseFragment -- Fragment which contains callback from presenter and view}
 * @author Sanjay Mallur
 */
public class BaseFragment<T extends AppMvpPresenter> extends Fragment implements AppMvpView {

    protected T mPresenter;//Presenter for fragments

    protected ProgressDialog mProgressDialog;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null)
            mPresenter.attachView(this);//attaching view in child fragment

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.detachView();//detaching view in child fragment

    }

    @Override
    public void setProgressIndicator(boolean active) {
        if(active) {
            if (mProgressDialog == null) {
                mProgressDialog = new ProgressDialog(getActivity());
                mProgressDialog.setCancelable(false);
                mProgressDialog.setTitle(null);
                mProgressDialog.setMessage(getString(R.string.s_loading_post_detail));
            } else {
                mProgressDialog.show();
            }
        } else  {
            mProgressDialog.hide();
        }

    }

}
