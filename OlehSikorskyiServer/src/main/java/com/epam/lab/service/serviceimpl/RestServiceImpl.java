package com.epam.lab.service.serviceimpl;

import com.epam.lab.model.WalletOperation;
import com.epam.lab.service.WalletService;
import com.epam.lab.webmodel.SummaryFault;
import com.epam.lab.webmodel.SummarySuccess;
import com.epam.lab.webmodel.SummaryWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static com.epam.lab.model.Wallet.MAX_MONEY_AMOUNT;

@Path("wallet")
public class RestServiceImpl implements WalletService {
    private final static Logger LOG = LogManager.getLogger(SoapServiceImpl.class);
    WalletOperation walletOperation;

    public RestServiceImpl() {
        walletOperation = new WalletOperation();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/checkBalance")
    public SummaryWrapper checkBalance() {
        walletOperation.checkBalance();
        LOG.info(String.format("Your account balance is - %.2f", walletOperation.checkBalance()));
        return SummaryWrapper.success(SummarySuccess.WITHDRAW_MONEY_SUCCESS);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/refillAccount")
    public SummaryWrapper refillAccount(@QueryParam("money") Double transferAmountPut) {
        if ((walletOperation.checkBalance() + transferAmountPut) <= MAX_MONEY_AMOUNT) {
            walletOperation.refillAccount(transferAmountPut);
            LOG.info(String.format("Account was refilled on %.2f", transferAmountPut));
            return SummaryWrapper.success(SummarySuccess.REFILL_ACCOUNT_SUCCESS);
        } else {
            LOG.debug(String.format("Account was not refilled, max limit - %.2f", MAX_MONEY_AMOUNT));
            return SummaryWrapper.fault(SummaryFault.REFILL_ACCOUNT_FAULT);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @PathParam("/withdrawMoney")
    public SummaryWrapper withdrawMoney(@QueryParam("money") Double transferAmountGet) {
        if ((Math.abs(walletOperation.checkBalance())) > transferAmountGet) {
            walletOperation.withdrawMoney(transferAmountGet);
            LOG.info("Money was withdrawMoney from account");
            return SummaryWrapper.success(SummarySuccess.WITHDRAW_MONEY_SUCCESS);
        } else {
            LOG.info(String.format("Money was not withdrawMoney from account. Low limit - %.2f,", walletOperation.checkBalance()));
            return SummaryWrapper.fault(SummaryFault.WITHDRAW_MONEY_FAULT);
        }
    }
}