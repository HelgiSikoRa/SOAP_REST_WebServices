package com.epam.lab.service.serviceimpl;

import com.epam.lab.model.WalletOperation;
import com.epam.lab.service.WalletService;
import com.epam.lab.webmodel.SummaryFault;
import com.epam.lab.webmodel.SummarySuccess;
import com.epam.lab.webmodel.SummaryWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import static com.epam.lab.model.Wallet.CREDIT_LIMIT;
import static com.epam.lab.model.Wallet.MAX_MONEY_AMOUNT;

@WebService(endpointInterface = "com.epam.lab.service.WalletService")
public class SoapServiceImpl implements WalletService {

    private final static Logger LOG = LogManager.getLogger(SoapServiceImpl.class);
    WalletOperation walletOperation;

    public SoapServiceImpl() {
        walletOperation = new WalletOperation();
    }

    @WebMethod
    public SummaryWrapper checkBalance() {
         walletOperation.checkBalance();
        LOG.info(String.format("Your money balance - %.2f", walletOperation.checkBalance()));
        return SummaryWrapper.success(SummarySuccess.GET_BALANCE_SUCCESS);
    }

    @WebMethod
    public SummaryWrapper refillAccount(@WebParam(name = "money") Double transferAmountPut) {
        if ((walletOperation.checkBalance() + transferAmountPut) <= MAX_MONEY_AMOUNT) {
            walletOperation.refillAccount(transferAmountPut);
            LOG.info(String.format("Account was refilled on %.2f", transferAmountPut));
            return SummaryWrapper.success(SummarySuccess.REFILL_ACCOUNT_SUCCESS);
        } else {
            LOG.debug(String.format("Account was not refilled, max limit - %.2f", MAX_MONEY_AMOUNT));
            return SummaryWrapper.fault(SummaryFault.REFILL_ACCOUNT_FAULT);
        }
    }

    @WebMethod
    public SummaryWrapper withdrawMoney(@WebParam(name = "money") Double transferAmountGet) {
        if ((walletOperation.checkBalance() - transferAmountGet >= CREDIT_LIMIT)) {
            walletOperation.withdrawMoney(transferAmountGet);
            LOG.info("Money was withdrawMoney from account");
            return SummaryWrapper.success(SummarySuccess.WITHDRAW_MONEY_SUCCESS);
        } else {
            LOG.info(String.format("Money was not withdrawMoney from account. Low limit - %.2f,", walletOperation.checkBalance()));
            return SummaryWrapper.fault(SummaryFault.WITHDRAW_MONEY_FAULT);
        }
    }
}