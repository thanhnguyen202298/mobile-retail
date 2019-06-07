package com.ssk.retailshop.screen.money.presenter;

import com.ssk.retailshop.screen.register.model.UserRegisterDTO;

public interface CreatePayslipMoneyInterater  {
    void CreatePayslipMoneyInterater(final UserRegisterDTO userDTO, final CreatePayslipMoneyListener listener);
}
