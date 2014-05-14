package com.lau_saiwfy.whitenoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class TypeListActivity extends FragmentActivity
        implements TypeListFragment.Callbacks {

    private boolean mTwoPane;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_list);

        if (findViewById(R.id.type_detail_container) != null) {
            mTwoPane = true;
            ((TypeListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.type_list))
                    .setActivateOnItemClick(true);
        }
    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(TypeDetailFragment.ARG_ITEM_ID, id);
            TypeDetailFragment fragment = new TypeDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.type_detail_container, fragment)
                    .commit();

        } else {
            Intent detailIntent = new Intent(this, TypeDetailActivity.class);
            detailIntent.putExtra(TypeDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
