package com.epam.lab;

import com.epam.lab.service.SummaryWrapper;
import com.epam.lab.service.serviceimpl.ServicesFactory;
import com.epam.lab.service.serviceimpl.WalletService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SummaryResponseTest {
    private final static Logger LOG = LogManager.getLogger(SummaryResponseTest.class);
    public static WalletService servicesFactory;
    public static final Double TRANSFER_AMOUNT_PUT = 50.00;
    public static final Double TRANSFER_AMOUNT_PUT_FAULT = 2000.00;
    public static final Double TRANSFER_AMOUNT_GET = 30.00;
    public static final Double TRANSFER_AMOUNT_GET_FAULT = 500.00;

    @BeforeClass
    public static void setUserService() {
        servicesFactory = ServicesFactory.getUserService(ServicesFactory.SOAP);
    }

    @Test
    public static void checkBalance() {
        SummaryWrapper summaryWrapper =servicesFactory.checkBalance();
        Assert.assertEquals(summaryWrapper.getSummarySuccess().getSuccessMessage(),"Successful operation 'Check Balance'");
        LOG.info("Successful operation 'Check Balance'");
    }

    @Test
    public void refillAccountNegative() {
        SummaryWrapper response = servicesFactory.refillAccount(TRANSFER_AMOUNT_PUT_FAULT);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getSummaryFault().getErrorMessage(),"Error. You have exceeded the possible limit");
        LOG.info("Error. You have exceeded the possible limit");
    }

    @Test
    public void refillAccountPositive() {
        SummaryWrapper response = servicesFactory.refillAccount(TRANSFER_AMOUNT_PUT);
        Assert.assertNotNull(response);
        Assert.assertEquals( response.getSummarySuccess().getSuccessMessage(),"Account was refilled successfully");
        LOG.info(String.format("Account was refilled successfully by %.2f", TRANSFER_AMOUNT_PUT));
    }

    @Test
    public void withdrawMoneyPositive() {
        SummaryWrapper response = servicesFactory.withdrawMoney(TRANSFER_AMOUNT_GET);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getSummarySuccess().getSuccessMessage(),"Perfectly. The money are withdrawn from your account");
        LOG.info(String.format("Perfectly. The money are withdrawn from your account - %.2f", TRANSFER_AMOUNT_GET));
    }

    @Test
    public void withdrawMoneyNegative() {
        SummaryWrapper response = servicesFactory.withdrawMoney(TRANSFER_AMOUNT_GET_FAULT);
        Assert.assertNotNull(response);
        Assert.assertEquals(response.getSummaryFault().getErrorMessage(),"An error occurred. The amount on your account is insufficient for transfer");
        LOG.info("An error occurred. The amount on your account is insufficient for transfer");
    }
}
