package com.epam.lab.service;

import com.epam.lab.webmodel.SummaryWrapper;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WalletService {

    @WebMethod(operationName = "checkBalance", action = "checkBalance")
    SummaryWrapper checkBalance();

    @WebMethod(operationName = "withdrawMoney", action = "withdrawMoney")
    SummaryWrapper withdrawMoney(@WebParam(name = "money") Double transferAmountGet);

    @WebMethod(operationName = "refillAccount", action = "refillAccount")
    SummaryWrapper refillAccount(@WebParam(name = "money") Double transferAmountPut);
}