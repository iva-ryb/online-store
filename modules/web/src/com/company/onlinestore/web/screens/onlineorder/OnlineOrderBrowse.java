package com.company.onlinestore.web.screens.onlineorder;

import com.company.onlinestore.entity.OnlineOrder;
import com.haulmont.cuba.gui.screen.*;

@UiController("onlinestore_OnlineOrder.browse")
@UiDescriptor("online-order-browse.xml")
@LookupComponent("onlineOrdersTable")
@LoadDataBeforeShow
public class OnlineOrderBrowse extends StandardLookup<OnlineOrder> {
}