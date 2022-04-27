package com.example.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class AppProperties {

    @Value("${dbApi.url.cashAccounts}")
    private String dbApiCashAccountsUrl;

    @Value("${dbApi.url.cashAccountTransactions}")
    private String dbApiCashAccountTransactionsUrl;

    @Value("${dbApi.url.readAddresses}")
    private String dbApireadAddresses;

    public String getDbApiCashAccountsUrl() {
        return dbApiCashAccountsUrl;
    }

    public void setDbApiCashAccountsUrl(String dbApiCashAccountsUrl) {
        this.dbApiCashAccountsUrl = dbApiCashAccountsUrl;
    }

    public String getDbApiCashAccountTransactionsUrl() {
        return dbApiCashAccountTransactionsUrl;
    }

    public void setDbApiCashAccountTransactionsUrl(String dbApiCashAccountTransactionsUrl) {
        this.dbApiCashAccountTransactionsUrl = dbApiCashAccountTransactionsUrl;
    }

    public String getDbApireadAddresses(){ return dbApireadAddresses; }

    public void setDbApireadAddresses(String dbApireadAddressesUrl) {
        this.dbApireadAddresses = dbApireadAddressesUrl;
    }

}
