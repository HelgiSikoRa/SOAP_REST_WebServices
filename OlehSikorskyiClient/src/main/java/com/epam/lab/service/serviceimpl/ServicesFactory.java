package com.epam.lab.service.serviceimpl;

public class ServicesFactory {

    public static final String REST = "REST";
    public static final String SOAP = "SOAP";
    private static WalletServiceRest walletServiceRest;
    private static WalletService userServiceSoap;

    public static WalletService getUserService(String param) {
        if (param.equals(REST)) {
            if (walletServiceRest == null) {
                walletServiceRest = new WalletServiceRest();
            }
            return walletServiceRest;
        } else if (param.equals(SOAP)) {
            if (userServiceSoap == null) {
                userServiceSoap = new SoapServiceImplService().getSoapServiceImplPort();
            }
        }
        return userServiceSoap;
    }
}