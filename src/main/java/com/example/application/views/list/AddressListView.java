package com.example.application.views.list;

import com.example.application.data.model.Address;
import com.example.application.data.service.AddressService;
import com.example.application.security.oauth.UserSession;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.List;


    @Route(value = "Addresses", layout = MainLayout.class)
    @PermitAll
    public class AddressListView extends VerticalLayout {

        Grid<Address> addressGrid = new Grid<>(Address.class);

        public AddressListView(UserSession userSession, AddressService addressService) {
            addClassName("overview");
            setSizeFull();

            add(userSession.getUser().getFirstName());
            add(addressGrid);

            String accessToken = userSession.getAccessToken();
            configureGrid(addressService.getAddresses(accessToken));
        }

        private void configureGrid(List<Address> addresses) {
            addressGrid.addClassName("AddressesGrid");
            addressGrid.setSizeFull();
            addressGrid.setColumns("street", "addressType");
            addressGrid.getColumns().forEach(col -> col.setAutoWidth(true));
            addressGrid.setItems(addresses);


        }
    }


