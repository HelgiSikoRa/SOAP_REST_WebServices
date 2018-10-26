package com.epam.lab.service.serviceimpl;

import com.epam.lab.service.SummaryWrapper;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WalletServiceRest implements WalletService {
    public static final String ENDPOINT = "http://localhost:8080/OlehSikorskyiService/rest/wallet";
    public static final String CHECK_BALANCE = "/checkBalance";
    public static final String WITHDRAW_MONEY = "/withdrawMoney";
    public static final String REFILL_AMOUNT = "/refillAccount";
    public static final String ARGUMENT = "?money=";
    private static HttpResponse RESPONSE;

    private static Gson gson = new Gson();
    private static HttpClient HTTP_CLIENT = HttpClientBuilder.create().build();

    @Override
    public SummaryWrapper checkBalance() {
        String requestURL = ENDPOINT + CHECK_BALANCE;
        HttpGet get = new HttpGet(requestURL);
        return executeHTTP(get);
    }

    @Override
    public SummaryWrapper refillAccount(double transferAmountPut) {
        String requestURL = ENDPOINT + REFILL_AMOUNT + ARGUMENT + transferAmountPut;
        HttpPost post = new HttpPost(requestURL);
        return executeHTTP(post);
    }

    @Override
    public SummaryWrapper withdrawMoney(double transferAmountGet) {
        String requestURL = ENDPOINT + WITHDRAW_MONEY + ARGUMENT + transferAmountGet;
        HttpPost post = new HttpPost(requestURL);
        return executeHTTP(post);
    }

    /**
     * executeHTTP com.epam.lab.service.serviceimpl.WalletServiceRest
     */

    private SummaryWrapper executeHTTP(HttpRequestBase request) {
        SummaryWrapper result = null;
        try {
            RESPONSE = HTTP_CLIENT.execute(request);
            int retCode = RESPONSE.getStatusLine().getStatusCode();
            if (retCode != 200) {
                throw new RuntimeException(String.format("HTTP response code %s instead of 200", retCode));
            }
            String jsonResponseStr = getResponseAsString(RESPONSE);
            result = gson.fromJson(jsonResponseStr, SummaryWrapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String getResponseAsString(HttpResponse response) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        (response.getEntity().getContent())
                )
        );
        StringBuilder content = new StringBuilder();
        String line;
        while (null != (line = br.readLine())) {
            content.append(line);
        }
        return content.toString();
    }
}