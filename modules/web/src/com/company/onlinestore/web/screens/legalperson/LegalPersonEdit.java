package com.company.onlinestore.web.screens.legalperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.onlinestore.entity.LegalPerson;

@UiController("onlinestore_LegalPerson.edit")
@UiDescriptor("legal-person-edit.xml")
@EditedEntityContainer("legalPersonDc")
@LoadDataBeforeShow
public class LegalPersonEdit extends StandardEditor<LegalPerson> {
}