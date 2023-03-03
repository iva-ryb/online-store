package com.company.onlinestore.web.screens.extuser;

import com.company.onlinestore.entity.*;
import com.company.onlinestore.web.screens.buyer.BuyerEdit;
import com.company.onlinestore.web.screens.legalperson.LegalPersonEdit;
import com.company.onlinestore.web.screens.privateperson.PrivatePersonEdit;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Actions;
import com.haulmont.cuba.gui.components.DialogAction;
import com.haulmont.cuba.gui.components.HBoxLayout;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("sec$ExtUser.edit")
@UiDescriptor("ext-user-edit.xml")
@EditedEntityContainer("extUserDc")
@LoadDataBeforeShow
public class ExtUserEdit extends StandardEditor<ExtUser> {

    @Inject
    protected DataManager dataManager;
    @Inject
    private Screens screens;
    @Inject
    private Dialogs dialogs;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (getEditedEntity().getBuyer() == null) {
            dialogs.createOptionDialog()
                    .withCaption("warning")
                    .withMessage("Create buyer?")
                    .withActions(
                            new DialogAction(DialogAction.Type.YES, Action.Status.PRIMARY).withHandler(e -> {
                                createBuyer(getEditedEntity());
                            }),
                            new DialogAction(DialogAction.Type.NO)
                    ).show();
        }
    }

    private void createBuyer(ExtUser user) {
        dialogs.createOptionDialog()
                .withCaption("Create Buyer")
                .withMessage("Select type of Buyer")
                .withActions(
                        new BaseAction(BuyerType.PRIVATE.getId())
                                .withCaption(BuyerType.PRIVATE.getId())
                                .withHandler(e -> {
                            PrivatePersonEdit screen = screens.create(PrivatePersonEdit.class);
                            PrivatePerson privatePerson = dataManager.create(PrivatePerson.class);
                            privatePerson.setFirstName(user.getFirstName());
                            privatePerson.setSecondName(user.getMiddleName());
                            privatePerson.setPatronymic(user.getLastName());
                            privatePerson.setEmail(user.getEmail());
                            privatePerson.setUser(user);
                            privatePerson.setBuyerType(BuyerType.PRIVATE);

                            screen.setEntityToEdit(privatePerson);
                            screens.show(screen);
                        }),
                        new BaseAction(BuyerType.LEGAL.getId())
                                .withCaption(BuyerType.LEGAL.getId())
                                .withHandler(e -> {
                            LegalPersonEdit screen = screens.create(LegalPersonEdit.class);
                            LegalPerson legalPerson = dataManager.create(LegalPerson.class);
                            legalPerson.setName(user.getName());
                            legalPerson.setEmail(user.getEmail());
                            legalPerson.setBuyerType(BuyerType.LEGAL);
                            legalPerson.setUser(user);

                            screen.setEntityToEdit(legalPerson);
                            screens.show(screen);
                        }),
                        new DialogAction(DialogAction.Type.NO)

                ).show();
    }
}