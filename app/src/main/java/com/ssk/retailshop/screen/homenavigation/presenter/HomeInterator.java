package com.ssk.retailshop.screen.homenavigation.presenter;

import com.ssk.retailshop.screen.register.model.UserRegisterDTO;
import com.ssk.retailshop.screen.register.presenter.RegisterListener;

public interface HomeInterator {
    void Home(final String user, final HomeListener listener);
}
