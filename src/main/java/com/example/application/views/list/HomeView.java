package com.example.application.views.list;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

@PageTitle("Home")
@Route(value = "")
@AnonymousAllowed
public class HomeView extends VerticalLayout {
    private final OAuth2AuthorizedClientService clientService;

    public HomeView(OAuth2AuthorizedClientService clientService) {
        this.clientService = clientService;
        setSpacing(false);
        setPadding(false);
        add(body());
        add(navbar());
    }

    private Component navbar() {
        HorizontalLayout root = new HorizontalLayout();
        root.setWidthFull();
        root.setAlignItems(Alignment.CENTER);

        root.setAlignItems(Alignment.CENTER);
        root.addClassNames("contrast-5pct");

        return root;
    }


    private Component body() {
        VerticalLayout root = new VerticalLayout();
        root.add(new H1("BBW Praktikum Deutsche Bank 19.04.2022 -29.04.2022"));
        root.add(new H2(""));
        root.add(new H3("Dies ist eine Webserver Applikation die folgende Technologien und Frameworks einsetzt:"));
        root.add(new ListItem("Java 11"));
        root.add(new ListItem("Spring Boot 2.6.7"));


        ListItem listItemSpringSecurity = new ListItem("Spring Security 5.6.3");
        Button springSecurityButton = new Button();
        springSecurityButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        springSecurityButton.setText("SpringSecurity");

        Anchor anchorSpringSecurity = new Anchor("https://spring.io/projects/spring-security", springSecurityButton);
        anchorSpringSecurity.setHref("https://spring.io/projects/spring-security");
        listItemSpringSecurity.add(anchorSpringSecurity);
        root.add(listItemSpringSecurity);



        ListItem listItemOAuth = new ListItem("Spring Oauth 5.6.3");
        Button oAuthButton = new Button();
        oAuthButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        oAuthButton.setText("OAuth2");

        Anchor anchorOAuth = new Anchor("https://oauth.net/2/", oAuthButton);
        anchorOAuth.setHref("https://oauth.net/2/");
        listItemOAuth.add(anchorOAuth);
        root.add(listItemOAuth);

        Button vaadinButton = new Button();
        vaadinButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        vaadinButton.setText("Vaadin");

        ListItem listItemVaadin = new ListItem();
        listItemVaadin.setText("Vaadin 23.06. - Frontend Generierung");
        root.add(listItemVaadin);

        Anchor anchorVaadin = new Anchor ("https//vaadin.com/docs/latest/flow/application", vaadinButton);
        anchorVaadin.setHref("https://vaadin.com/docs/latest/flow/application");
        listItemVaadin.add(anchorVaadin);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof OAuth2AuthenticationToken)) {
            Button loginButton = new Button();
            loginButton.setText("Login");
            loginButton.getStyle().set("text-align", "center");
            loginButton.addClassName("toolbar");

            Anchor anchorLogin = new Anchor("/login", loginButton);
            anchorLogin.getElement().setAttribute("router-ignore",true);
            root.add(anchorLogin);
        }else {
            Notification.show("Logged In");
            OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
            OAuth2AuthorizedClient client = this.clientService.loadAuthorizedClient(token.getAuthorizedClientRegistrationId(), token.getName());
            String accessToken = client.getAccessToken().getTokenValue();
            Notification.show("Logged in with token: " + accessToken);
        }

        root.setSizeFull();
        root.setJustifyContentMode(JustifyContentMode.CENTER);
        root.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        root.getStyle().set("text-align", "center");

        return root;
    }
}
