package com.ssk.retailshop.screen.register.presenter;

import com.ssk.retailshop.screen.register.model.UserRegisterDTO;

public interface RegisterInterator {
    void Register(final UserRegisterDTO userDTO, final RegisterListener listener);
}
