package com.ssk.retailshop.screen.accountfrag;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ssk.retailshop.R;
import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.model.UserInfo;
import com.ssk.retailshop.screen.login_qlnv.LoginQLNV;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AccountFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView textUserName;
    private TextView btnLogout;
    private TextView textPhoneUser;
    private TextView textGmailUser;
    private TextView btnEditInfo;
    private TextView textAddress;
    private TextView textPass;

    UserInfo nguoiDung;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnAccountInteractionListener mListener;

    public AccountFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaiKhoanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //init view
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        textUserName = (TextView) view.findViewById(R.id.input_name_user);
        textPhoneUser = (TextView) view.findViewById(R.id.input_sdt);
        textGmailUser = (TextView) view.findViewById(R.id.input_mail);
        textAddress = (TextView) view.findViewById(R.id.input_address);
        btnLogout = (TextView) view.findViewById(R.id.log_out);
        btnEditInfo = (TextView) view.findViewById(R.id.editInfor);
        textPass = (TextView) view.findViewById(R.id.input_matkhau);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });

        btnEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //create dialog --> show
                final AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                TextView title = new TextView(getActivity());
                title.setText("Thông tin thay đổi");
                title.setTextSize(20);
                title.setGravity(Gravity.CENTER);

                builder.setCustomTitle(title);

                // Inflate the layout for this fragment
                LayoutInflater inflater = LayoutInflater.from(v.getContext());
                final View edit_layout = inflater.inflate(R.layout.edit_user_layout, null);

                final EditText edt_name = (EditText) edit_layout.findViewById(R.id.editName);
                final EditText edt_address = (EditText) edit_layout.findViewById(R.id.editDiaChi);
                final EditText edt_mail = (EditText) edit_layout.findViewById(R.id.editGmail);
                final EditText edt_pass = (EditText) edit_layout.findViewById(R.id.editPassword);

                Button btn_save = (Button) edit_layout.findViewById(R.id.btn_saveInform);


                edt_name.setText(textUserName.getText());
                edt_address.setText(textAddress.getText());
                edt_mail.setText(textGmailUser.getText());
                edt_pass.setText(textPass.getText());

                //set view for dialog --> get layout --> use dialog --> lets show and dismiss
                builder.setView(edit_layout);
                final AlertDialog dialog = builder.create();

                btn_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //init API --> delare
//                         APIUtils.getSOService();

                        //Check null text
                        if (TextUtils.isEmpty(edt_name.getText().toString())) {
                            Toast.makeText(getContext(), "Vui lòng nhập tên muốn thay đổi", Toast.LENGTH_SHORT).show();
                        }
                        if (TextUtils.isEmpty(edt_pass.getText().toString())) {
                            Toast.makeText(getContext(), "Vui lòng nhập mật khẩu muốn thay đổi", Toast.LENGTH_SHORT).show();
                        }
                        if (TextUtils.isEmpty(edt_address.getText().toString())) {
                            Toast.makeText(getContext(), "Vui lòng nhập địa chỉ muốn thay đổi", Toast.LENGTH_SHORT).show();
                        }
                        if (TextUtils.isEmpty(edt_mail.getText().toString())) {
                            Toast.makeText(getContext(), "Vui lòng nhập địa chỉ mail muốn thay đổi", Toast.LENGTH_SHORT).show();
                        }

                        //show dialog please...
//                        final AlertDialog waitingDialog = new Dial(getActivity());
//                        waitingDialog.show();
//                        waitingDialog.setMessage("Vui lòng đợi...");

                        //set value for object must have SDT and ID
//                        nguoiDung.setSoDienThoai(SDT);
//                        nguoiDung.setTenNguoiDung(edt_name.getText().toString());
//                        nguoiDung.setDiaChi(edt_address.getText().toString());
//                        nguoiDung.setMatKhau(edt_pass.getText().toString());
//                        nguoiDung.Email = edt_mail.getText().toString();
//
//                        service.updateCustomer(nguoiDung).enqueue(new Callback<SucceedUpdate>() {
//                            @Override
//                            public void onResponse(Call<SucceedUpdate> call, Response<SucceedUpdate> response) {
//
//                                //check response value
//                                if (response.message().equals("OK")) {
//                                    textUserName.setText(edt_name.getText().toString());
//                                    textGmailUser.setText(edt_mail.getText().toString());
//                                    textAddress.setText(edt_address.getText().toString());
//                                    textPass.setText(edt_pass.getText().toString());
//                                    dialog.dismiss();
//
//                                    PreferenceUtils.saveUser(UtilBasic.getGs().toJson(nguoiDung));
//
////                                    PreferenceUtils.saveTenNguoiDung(edt_name.getText().toString(), getActivity());
////                                    PreferenceUtils.saveDiaChiNguoiDung(edt_address.getText().toString(), getActivity());
////                                    PreferenceUtils.saveEmailNguoiDung(edt_mail.getText().toString(), getActivity());
////                                    PreferenceUtils.savePassword(edt_pass.getText().toString(), getActivity());
//
//                                    waitingDialog.dismiss();
//
//                                    Toast.makeText(getContext(), "Bạn đã thay đổi thông tin thành công", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    dialog.dismiss();
//                                    waitingDialog.dismiss();
//                                    Toast.makeText(getContext(), "Thay đổi thông tin không thành công! Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<SucceedUpdate> call, Throwable t) {
//
//                                //check network again --> can error network
//                                dialog.dismiss();
//                                waitingDialog.dismiss();
//                                Toast.makeText(getContext(), "Thay đổi thông tin không thành công! Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
//                            }
//                        });

                    }

                });

                dialog.show();
            }
        });


        return view;
        // Inflate the layout for this fragment
    }

    //logout ---> format preference
    private void logOut() {

        PreferenceUtils.prefs.edit().clear().commit();
        Intent intent = new Intent(getActivity(), LoginQLNV.class);
        startActivity(intent);
    }


    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAccountInteractionListener) {
            mListener = (OnAccountInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnAccountInteractionListener {
        // TODO: Update argument type and name
        void onAccountInteraction(Uri uri);
    }
}
