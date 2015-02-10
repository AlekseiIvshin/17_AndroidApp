package com.example.aleksei_ivshin.firstapp;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by dnss on 10.02.2015.
 */
public class HeadlinesFragment extends ListFragment {

    OnHeadlineSelectedListener mCallback;

    private AbsListView listView;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException((activity.toString() + " must implement OnHeadlineSelectedListener"));
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mCallback.onArticleSelected(position);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listView=null;
    }
}
