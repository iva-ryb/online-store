package com.company.onlinestore.web.screens.buyer;

import com.haulmont.cuba.gui.screen.*;
import com.company.onlinestore.entity.Buyer;

@UiController("onlinestore_Buyer.browse")
@UiDescriptor("buyer-browse.xml")
@LookupComponent("buyersTable")
@LoadDataBeforeShow
public class BuyerBrowse extends StandardLookup<Buyer> {
}