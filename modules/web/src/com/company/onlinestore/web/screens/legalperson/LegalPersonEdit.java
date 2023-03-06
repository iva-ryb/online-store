package com.company.onlinestore.web.screens.legalperson;

import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.DialogAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.onlinestore.entity.LegalPerson;

import javax.inject.Inject;

@UiController("onlinestore_LegalPerson.edit")
@UiDescriptor("legal-person-edit.xml")
@EditedEntityContainer("legalPersonDc")
@LoadDataBeforeShow
public class LegalPersonEdit extends StandardEditor<LegalPerson> {

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
        } else {
            closeWithCommit();
        }

    }
}