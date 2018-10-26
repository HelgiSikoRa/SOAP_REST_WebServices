package com.epam.lab.service.serviceimpl;

import com.epam.lab.service.model.WalletService;

public class ServicesFactory {

    public static final String SOAP = "SOAP";
    private static WalletService userServiceSoap;

    public static WalletService getUserService(String param) {
        if (param.equals(SOAP)) {
            if (userServiceSoap == null) {
                userServiceSoap = new SoapServiceImplService().getSoapServiceImplPort();
            }
        }
        return userServiceSoap;
    }
}