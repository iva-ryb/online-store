package com.company.onlinestore.web.screens.storeproduct;

import com.haulmont.cuba.gui.screen.*;
import com.company.application.entity.StoreProduct;

@UiController("application_StoreProduct.browse")
@UiDescriptor("store-product-browse.xml")
@LookupComponent("storeProductsTable")
@LoadDataBeforeShow
public class StoreProductBrowse extends StandardLookup<StoreProduct> {
}