package com.company.onlinestore.web.screens.onlineorder;

import com.company.application.entity.StoreProduct;
import com.company.onlinestore.entity.ExtUser;
import com.company.onlinestore.entity.OnlineOrder;
import com.company.onlinestore.entity.ProductList;
import com.company.onlinestore.entity.RandomProduct;
import com.company.onlinestore.web.screens.storeproduct.StoreProductBrowse;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@UiController("onlinestore_OnlineOrder.edit")
@UiDescriptor("online-order-edit.xml")
@EditedEntityContainer("onlineOrderDc")
@LoadDataBeforeShow
public class OnlineOrderEdit extends StandardEditor<OnlineOrder> {

    @Inject
    private UniqueNumbersService uniqueNumbersService;

    @Inject
    private UserSession userSession;

    @Inject
    private DataManager dataManager;

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private Metadata metadata;

    @Inject
    private CollectionContainer<RandomProduct> customDatasourceDc;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        OnlineOrder onlineOrder = getEditedEntity();
        if (!userSession.getUser().getLoginLowerCase().equals("admin")) {
            ExtUser user = (ExtUser) dataManager.load(ExtUser.class).id(userSession.getUser().getId()).one();
            onlineOrder.setBuyer(user.getBuyer());
        }
        if (onlineOrder.getNumber() == null) {
            onlineOrder.setNumber(String.valueOf(uniqueNumbersService.getNextNumber("sequence")));
        }
        BigDecimal sum = new BigDecimal(0);

        if (onlineOrder.getProducts() != null) {
            for (int i = 0; i < onlineOrder.getProducts().size(); i++) {
                sum = sum.add(onlineOrder.getProducts().get(i).getPrice());
            }
            double disc = (double) onlineOrder.getDiscount() / 100;
            BigDecimal sumDiscount = sum.multiply(BigDecimal.valueOf(disc));
            onlineOrder.setSum(sum.subtract(sumDiscount));
        } else {
            onlineOrder.setProducts(new ArrayList<>());
            onlineOrder.setSum(sum);
        }
    }

    @Subscribe("openProductListScreen")
    public void onOpenProductListScreenClick(Button.ClickEvent event) {
        screenBuilders.lookup(StoreProduct.class, this)
                .withScreenClass(StoreProductBrowse.class)
                .withLaunchMode(OpenMode.DIALOG)
                .build()
                .show();
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        List<StoreProduct> products = dataManager.load(StoreProduct.class).list();
        Set<RandomProduct> set = new HashSet<>();
        int randAmount = getRandomIntegerBetweenRange(1, products.size() - 1);
        for (int i = 0; i < randAmount; i++) {
            int randIndex = getRandomIntegerBetweenRange(0, products.size() - 1);
            RandomProduct randomProduct = metadata.create(RandomProduct.class);
            StoreProduct storeProduct = products.get(randIndex);
            randomProduct.setAmount(storeProduct.getCount());
            randomProduct.setPrice(products.get(randIndex).getPrice());
            randomProduct.setProduct(products.get(randIndex).getProduct());
            set.add(randomProduct);
        }

        customDatasourceDc.getMutableItems().addAll(set);
    }

    @Subscribe("productsTable")
    public void onProductsTableSelection(Table.SelectionEvent<RandomProduct> event) {
        OnlineOrder onlineOrder = getEditedEntity();
        List<RandomProduct> list = new ArrayList<>(event.getSelected());
        List<ProductList> productLists = onlineOrder.getProducts();
        for (int i = 0; i < event.getSelected().size(); i++) {
            ProductList product = dataManager.create(ProductList.class);
            product.setProduct(list.get(i).getProduct());
            product.setPrice(list.get(i).getPrice());
            product.setAmount(1);
            productLists.add(product);
            product.setOnlineOrder(onlineOrder);
        }
        onlineOrder.setProducts(productLists);
        closeWithCommit();
    }

    private int getRandomIntegerBetweenRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}