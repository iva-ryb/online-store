package com.company.onlinestore.web.screens.buyer;

import com.company.onlinestore.entity.Buyer;
import com.haulmont.cuba.gui.screen.*;

@UiController("onlinestore_Buyer.edit")
@UiDescriptor("buyer-edit.xml")
@EditedEntityContainer("buyerDc")
@LoadDataBeforeShow
public class BuyerEdit extends StandardEditor<Buyer> {


}