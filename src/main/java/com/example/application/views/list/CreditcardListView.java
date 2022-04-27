package com.example.application.views.list;

import com.example.application.data.model.Creditcard;
import com.example.application.data.service.CreditcardService;
import com.example.application.security.oauth.UserSession;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.List;

@Route(value = "Creditcards", layout = MainLayout.class)
@PermitAll
public class CreditcardListView extends VerticalLayout {
    Grid<Creditcard> creditcardGrid = new Grid<>(Creditcard.class);

    public CreditcardListView(UserSession userSession, CreditcardService creditcardService)
    {
        addClassName("overview");
        setSizeFull();

        add(userSession.getUser().getFirstName());
        add(creditcardGrid);

        String accessToken = userSession.getAccessToken();
        configureGrid(creditcardService.getCreditcards(accessToken));

    }

    private void configureGrid(List<Creditcard> creditcards)
    {
        creditcardGrid.addClassName("CreditcardGrid");
        creditcardGrid.setSizeFull();
        creditcardGrid.setColumns("technicalId", "embossedLine1", "embossedLine2", "hasDebitFeatures", "expiryDate", "productName", "securePAN");
        creditcardGrid.getColumns().forEach(col -> col.setAutoWidth(true));
        creditcardGrid.setItems(creditcards);


    }

}
