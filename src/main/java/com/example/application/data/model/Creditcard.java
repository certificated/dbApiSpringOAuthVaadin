package com.example.application.data.model;

public class Creditcard {
    private String technicalId;
    private String embossedLine1;
    private String embossedLine2;
    private Boolean hasDebitFeatures;
    private String expiryDate;
    private String productName;
    private String securePAN;

    public String getTechnicalId() {
        return technicalId;
    }

    public void setTechnicalId(String technicalId) {
        this.technicalId = technicalId;
    }

    public String getEmbossedLine1() {
        return embossedLine1;
    }

    public void setEmbossedLine1(String embossedLine1) {
        this.embossedLine1 = embossedLine1;
    }

    public String getEmbossedLine2() {
        return embossedLine2;
    }

    public void setEmbossedLine2(String embossedLine2) {
        this.embossedLine2 = embossedLine2;
    }

    public boolean isHasDebitFeatures() {
        return hasDebitFeatures;
    }

    public void setHasDebitFeatures(boolean hasDebitFeatures) {
        this.hasDebitFeatures = hasDebitFeatures;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSecurePAN() {
        return securePAN;
    }

    public void setSecurePAN(String securePAN) {
        this.securePAN = securePAN;
    }
}
