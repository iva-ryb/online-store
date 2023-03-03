package com.company.onlinestore.web.screens.extuser;

import com.haulmont.cuba.gui.screen.*;
import com.company.onlinestore.entity.ExtUser;

@UiController("sec$ExtUser.browse")
@UiDescriptor("ext-user-browse.xml")
@LookupComponent("extUsersTable")
@LoadDataBeforeShow
public class ExtUserBrowse extends StandardLookup<ExtUser> {
}