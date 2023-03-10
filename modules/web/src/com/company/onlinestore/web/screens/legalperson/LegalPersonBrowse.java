package com.company.onlinestore.web.screens.legalperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.onlinestore.entity.LegalPerson;

@UiController("onlinestore_LegalPerson.browse")
@UiDescriptor("legal-person-browse.xml")
@LookupComponent("legalPersonsTable")
@LoadDataBeforeShow
public class LegalPersonBrowse extends StandardLookup<LegalPerson> {
}