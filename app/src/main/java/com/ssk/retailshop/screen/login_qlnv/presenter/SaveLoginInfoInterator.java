package com.ssk.retailshop.screen.login_qlnv.presenter;

import com.ssk.retailshop.datahelper.preferenceapi.PreferenceUtils;
import com.ssk.retailshop.datahelper.webapi.APIUtils;
import com.ssk.retailshop.datahelper.webapi.PathApi;
import com.ssk.retailshop.model.UserInfo;
import com.ssk.retailshop.utilities.UtilBasic;

public class SaveLoginInfoInterator {
    private PathApi mApi;
    public SaveLoginInfoInterator(){
        mApi = APIUtils.getService();
    }

    public void saveUserInfo(UserInfo userInfo){
        PreferenceUtils.saveUser(UtilBasic.ObjectToJson(userInfo));
    }
}
