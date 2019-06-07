package com.ssk.retailshop.screen.customer;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ssk.retailshop.BR;
import com.ssk.retailshop.R;
import com.ssk.retailshop.databinding.LayoutCreateCustomerBinding;
import com.ssk.retailshop.screen.customer.model.CreateCustomersDTO;
import com.ssk.retailshop.screen.customer.presenter.CreateCustomerPresenter;

import net.grandcentrix.thirtyinch.TiFragment;

public class CreateCustomerFragment extends TiFragment<CreateCustomerPresenter, CreateCustomersView> implements CreateCustomersView {

    Context context;
    CreateCustomersDTO customerItem;
    LayoutCreateCustomerBinding viewBind;
    ProgressDialog progressDialog;
    Button btnSave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewBind = DataBindingUtil.inflate(inflater, R.layout.layout_create_customer, container, false);
        customerItem = new CreateCustomersDTO();
        viewBind.setVariable(BR.CreateCustomerItem, customerItem);
        return viewBind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getContext();
        btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "aaaaaaaa", Toast.LENGTH_SHORT).show();
                signUp();
                // Finish the registration screen and return to the Login activity
            }
        });


    }

    private void createCustomer(CreateCustomersDTO customerItem) {
        getPresenter().doRegisterCustomer(customerItem);
    }

    private void SwitchDialog() {

        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(context, "", "Loading...", true, false);
        } else {
            if (!progressDialog.isShowing()) {
                progressDialog = ProgressDialog.show(context, "", "Loading...", true, false);
            } else {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void onRegisterCustomersSuccess(String user) {
        Toast.makeText(context,  user, Toast.LENGTH_SHORT).show();
        viewBind.btnSave.setEnabled(true);
        progressDialog.dismiss();
        Fragment mFragment = new CustomerFragment();



    }

    @Override
    public void onRegisterCustomersError(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        viewBind.btnSave.setEnabled(true);
        progressDialog.dismiss();

    }

    @Override
    public boolean valid() {
        boolean valid = true;

        String name = customerItem.getFullName();
//        String address = customerItem.getAddress().toString();
//        String email = customerItem.getEmail().toString();
//        String mobile = customerItem.getCellPhone().toString();

//        String reEnterPassword = _reEnterPasswordText.getText().toString();

        if (name == null) {
            Toast.makeText(context, "Vui lòng nhập tên khách hàng", Toast.LENGTH_SHORT).show();
            valid = false;
        } else {
            viewBind.edtNameCus.setError(null);
        }

//        if (address.isEmpty()) {
//            viewBind.edtAddress.setError("Vui lòng nhập địa chỉ");
//            valid = false;
//        } else {
//            viewBind.edtAddress.setError(null);
//        }
//
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            viewBind.edtMail.setError("Vui lòng nhập một địa chỉ Email hợp lệ");
//            valid = false;
//        } else {
//            viewBind.edtMail.setError(null);
//        }
//
//        if (mobile.isEmpty() || mobile.length() != 10) {
//            viewBind.editText2.setError("Vui lòng nhập một số điện thoại hợp lệ");
//            valid = false;
//        } else {
//            viewBind.editText2.setError(null);
//        }

        return valid;
    }

    @NonNull
    @Override
    public CreateCustomerPresenter providePresenter() {
        return new CreateCustomerPresenter(context);
    }

//    public void onClickRegisterCustomer(View view) {
//
////        signUp();
//    }

    void signUp() {
        progressDialog = new ProgressDialog(getActivity(),
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Đang tạo khách hàng ...");
        progressDialog.show();
        if (!valid()) {
            onRegisterCustomersError("");
            return;
        }
        btnSave.setEnabled(false);


        createCustomer(customerItem);

////        Toast.makeText(this, vm.username, Toast.LENGTH_SHORT).show();
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either onSignupSuccess or onSignupFailed
//                        // depending on success
//                        onRegisterCustomersSuccess(customerItem.getCusName());
//                        // onSignupFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
    }
}
