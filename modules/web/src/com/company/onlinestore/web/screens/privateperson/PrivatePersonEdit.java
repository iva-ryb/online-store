package com.company.onlinestore.web.screens.privateperson;

import com.company.onlinestore.entity.ExtUser;
import com.company.onlinestore.web.screens.extuser.ExtUserBrowse;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.actions.picker.ClearAction;
import com.haulmont.cuba.gui.actions.picker.LookupAction;
import com.haulmont.cuba.gui.actions.picker.OpenAction;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.onlinestore.entity.PrivatePerson;
import com.haulmont.cuba.web.gui.components.WebPickerField;

import javax.inject.Inject;

@UiController("onlinestore_PrivatePerson.edit")
@UiDescriptor("private-person-edit.xml")
@EditedEntityContainer("privatePersonDc")
@LoadDataBeforeShow
public class PrivatePersonEdit extends StandardEditor<PrivatePerson> {

    @Inject
    private Dialogs dialogs;

    @Subscribe("onShowDialogBtnClick")
    public void onOnShowDialogBtnClickClick(Button.ClickEvent event) {
        if (getEditedEntity().getUser() == null) {
            dialogs.createOptionDialog()
                    .withCaption("Warning")
                    .withMessage("You not joined with user, continue?")
                    .withActions(
                            new DialogAction(DialogAction.Type.YES, Action.Status.PRIMARY).withHandler(e -> {
                                close(StandardOutcome.CLOSE);
                            }),
                            new DialogAction(DialogAction.Type.NO))
                    .show();
        }
    }
}