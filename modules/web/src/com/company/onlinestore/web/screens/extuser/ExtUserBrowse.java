package com.company.onlinestore.web.screens.extuser;

import com.company.onlinestore.entity.ExtUser;
import com.haulmont.cuba.gui.screen.*;

@UiController("sec$ExtUser.browse")
@UiDescriptor("ext-user-browse.xml")
@LookupComponent("extUsersTable")
@LoadDataBeforeShow
public class ExtUserBrowse extends StandardLookup<ExtUser> {
}