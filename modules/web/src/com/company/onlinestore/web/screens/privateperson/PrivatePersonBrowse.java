package com.company.onlinestore.web.screens.privateperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.onlinestore.entity.PrivatePerson;

@UiController("onlinestore_PrivatePerson.browse")
@UiDescriptor("private-person-browse.xml")
@LookupComponent("privatePersonsTable")
@LoadDataBeforeShow
public class PrivatePersonBrowse extends StandardLookup<PrivatePerson> {
}