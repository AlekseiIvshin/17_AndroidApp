package com.example.aleksei_ivshin.firstapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class MainActivity extends FragmentActivity implements HeadlinesFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.fragment_left_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            HeadlinesFragment headlinesFragment = new HeadlinesFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_left_container, headlinesFragment).commit();
        }
    }

    @Override
    public void onArticleSelected(int position) {
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);
        if (articleFragment != null) {
            articleFragment.setData(position + "");
        } else {
            ArticleFragment newArticleFragment = new ArticleFragment();
            newArticleFragment.setData("New article");
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_rigth_container, newArticleFragment).addToBackStack(null).commit();
        }
    }
}
