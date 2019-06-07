package com.ssk.retailshop.screen.customer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.ssk.retailshop.R;
import com.ssk.retailshop.screen.homenavigation.HomeNavigationActivity;
import com.ssk.retailshop.screen.report.ProfitLossReportFragment;

public class CreateCustomersActivity extends AppCompatActivity {

    ActionBar actionBar;
    TextView title;
    Fragment fm_active, fm_createCus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customers);

        Toolbar toolbar = findViewById(R.id.actionBar);
        title = findViewById(R.id.action_bar_title);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        InitFragment();
        LoadFragment(fm_createCus, "Tạo Khách hàng");


    }

    private boolean LoadFragment(final Fragment fragment, final String title1) {

        if (fragment != null ) {
            title.setText(title1);

            if(fm_active != fragment){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction().hide(fm_active).show(fragment);
                /*transaction.detach(fragment);
                transaction.attach(fragment);*/
                transaction.commit();

                //fragmentManager.beginTransaction().hide(fm_active).show(fragment).commit();
                //fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).hide(fm_active).show(fragment).commit();

                fm_active = fragment;
            }
        }

        return true;
    }

    private void InitFragment() {


        fm_active = new Fragment();

        //region Left Menu
        //region Quản lý
        fm_createCus = new CreateCustomerFragment();
        AddFragment(fm_createCus);
    }

    private void AddFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction()
                .addToBackStack(fragment.getTag())
                .add(R.id.fragment_container, fragment)
                .hide(fragment)
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(CreateCustomersActivity.this, HomeNavigationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
