package com.epam.lab.webmodel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "summaryFault")
public class SummaryFault extends Summary {

    private String errorMessage;

    public SummaryFault() {
    }

    public SummaryFault(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
