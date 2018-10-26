package com.epam.lab.webmodel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "summarySuccess")
public class SummarySuccess extends Summary {

    private String successMessage;

    public SummarySuccess() {
    }

    public SummarySuccess(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}
