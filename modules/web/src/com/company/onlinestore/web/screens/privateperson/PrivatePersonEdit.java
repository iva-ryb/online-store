package com.company.onlinestore.web.screens.privateperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.onlinestore.entity.PrivatePerson;

@UiController("onlinestore_PrivatePerson.edit")
@UiDescriptor("private-person-edit.xml")
@EditedEntityContainer("privatePersonDc")
@LoadDataBeforeShow
public class PrivatePersonEdit extends StandardEditor<PrivatePerson> {
}