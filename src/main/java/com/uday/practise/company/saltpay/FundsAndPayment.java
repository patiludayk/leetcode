package com.uday.practise.company.saltpay;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/*
* Problem : Company SaltPay HackerRank Test
*
* 1. Payment batches
SaltPay acquiring merchants across Europe are paid out everyday, with the funds coming from Saltay bank accounts in different currencies.
Your objective is to write the part of the payment engine that deducts processing fees from the payments to be made and batches the payments by currency, subject to availability of funds.
The function you need to write (change according to programming language):
string GenerateBatchPayments(string
    fundsAndPayments) {
    / your code here
    }
Input
The input is a single delimited UTF-8 string which contains the available funds and the payments to be made.
The pipe character | separates the funds and the payments, both of which are delimited strings themselves (see next sections).
Format:
GBP: 100, EUR: 200, CZK: 1000 |743: EUR: 5.76,932 :GBP: 32.10 ,909:CZK:223.26,23:CZK:890.22,902:GBP:58.23,89:EUR:
104.25,663: EUR: 97.43,902: EUR: 20.01
Available Funds
Represents the funds available in various SaltPay bank accounts
(1 account = 1 currency). There is no currency conversion, so to
make a payment, the funds have to come from the account in that currency.
e.g. if a payment of GBP 34.56 needs to be made, then it must come from the SaltPay GBP account.
Format: delimited string, looks like this:
GBP: 100, EUR: 200, CZK: 1000
Only EUR, GBP and CZK currencies are currently supported. All funds will be positive numbers.
Payments to be made
Format: delimited string, looks like this:
743: EUR:5.76,932:GBP:32.10,909:CZK:223.26,23:CZK:89
0.22,902:GBP:58.23,89EUR: 104.25,663:EUR:97.43,902:
EUR:20.01
Fields: Merchant ID (internal to SaltPay), currency and amount.
All amounts will be positive numbers.
Business Rules
1. Before paying out, deduct processing fees for each payment as a % of amount being processed: 1/3rd of a percent for GBP, 1/2 a percent for the other currencies
2. For each currency, create a batch of payments that can be paid based on the funds available.
3. Batching should be done in a way that processes the most number of payments that can be paid using the available funds.
Include the smallest payments first. Please do not optimise for maximum utilisation of funds. e.g. if the EUR payments after fees are 1, 1, 2, 2, 3, 4, 5, 6, 7 and the funds available are EUR 10, then the batch of EUR payments is 1, 1, 2, 2, 3.
4. When paying merchants, amounts should be always be rounded up e.g. 43.545 -> 43.55, and 43.512 -> 43.52, 43.5102
-> 43.52
Output
The return value of your top-level GenerateBatchPayments function should be a string which represents the payment batches, in alphabetical order of currencies and decreasing order of amounts.
e.g. for the payments and funds shown above, the batches will be:
    CZK
    909:CZK:222.15
    EUR
    743: EUR: 5.74
    902:EUR:19.91
    663:EUR: 96.95
    GBP
    932:GBP:32.00
    902:GBP: 58.04
If there are no batches for a given currency, do not include the currency at all
Guidelines
1. If you encounter bad, unknown or irrelevant input, log it out but don't stop processing the rest of the input
2. You will be asked to extend/modify the code you write here, so think about structure and maintainability
3. Feel free to use your own editor/IDE and then paste the output into HackerRank
4. You can submit the code and run the tests as many times as you like. There are some test cases you can't see the test data for, so consider edge cases when you see these fail
5. The test should take roughly 2 hours to complete. The timeout on Hackerrank is set to 3 hours to allow a buffer.
* */
public class FundsAndPayment {
    public static void main(String[] args) {

        String input = "GBP:100,EUR:200,CZK:1000|743:EUR:5.76,932:GBP:32.10,909:CZK:223.26,23:CZK:890.22,902:GBP:58.23,89:EUR:104.25,663:EUR:97.43,902:EUR:20.01";

        final String output = generatePaymentBatches(input);
        System.out.println(output);

    }

    public static String generatePaymentBatches(String fundsAndPayments) {

        String[] fundsAndPaymentArray = fundsAndPayments.split("\\|");
        String funds = fundsAndPaymentArray[0];
        String agentPayments = fundsAndPaymentArray[1];

        //GBP:100,EUR:200,CZK:1000
        String[] allCurrencies = funds.split(",");
        //build map balance as value for each currency as key and sort based on currency ie key
        final HashMap<String, Integer> availableBalance = Arrays.stream(allCurrencies)
                .map(currencyBalance -> new AbstractMap.SimpleEntry<String, Integer>(currencyBalance.split(":")[0], Integer.valueOf(currencyBalance.split(":")[1])))
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m0, m1) -> m1, LinkedHashMap::new));

        DecimalFormat df = new DecimalFormat("#.00");
        df.setRoundingMode(RoundingMode.CEILING);

        //743:EUR:5.76,932:GBP:32.10,909:CZK:223.26,23:CZK:890.22,902:GBP:58.23,89:EUR:104.25,663:EUR:97.43,902:EUR:20.01
        String[] allPayments = agentPayments.split(",");
        //build map agentId:currency as key and payment to be made + processing fee as value and sort based on value from lowest to highest
        final LinkedHashMap<String, Double> paymentsMap = Arrays.stream(allPayments)
                //map to agentId:currency as key and payment to be made
                .map(payments -> new AbstractMap.SimpleEntry<String, Double>(payments.split(":")[0] + ":" + payments.split(":")[1], Double.valueOf(payments.split(":")[2])))
                // deduct processing fee from payment
                .map(paymentEntry -> new AbstractMap.SimpleEntry<String, Double>(paymentEntry.getKey(), Double.valueOf(df.format(getFinalPaymentAfterDeductingProcessingFee(paymentEntry.getKey().split(":")[1], paymentEntry.getValue())))))
                //sort based on payment to be made the smallest first
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m0, m1) -> m1, LinkedHashMap::new));

        //build final output
        StringBuilder finalOutput = new StringBuilder("");
        availableBalance.entrySet().stream().forEach(entry -> {
            int balance = availableBalance.get(entry.getKey());
            finalOutput.append(entry.getKey() + "\n");
            AtomicReference<Double> amtToDeduct = new AtomicReference<>(0.0);
            paymentsMap.entrySet().stream().filter(agentsPayment -> agentsPayment.getKey().contains(entry.getKey())).forEach(agentPayment -> {
                amtToDeduct.updateAndGet(v -> v + agentPayment.getValue());
                if (balance > amtToDeduct.get()) {
                    finalOutput.append(agentPayment.getKey() + ":" + agentPayment.getValue() + "\n");
                }
            });
        });

        return finalOutput.toString();
    }

    private static Double getFinalPaymentAfterDeductingProcessingFee(String currency, Double amt) {
        Double pf = 0.0;
        switch (currency) {
            case "GBP":
                pf = (amt * 0.33) / 100;
                break;
            default:
                pf = (amt * 0.50) / 100;
                break;
        }
        return amt - pf;
    }
}

/* Sample Input
GBP:100,EUR:200,CZK:1000|743:EUR:5.76,932:GBP:32.10,909:CZK:223.26,23:CZK:890.22,902:GBP:58.23,89:EUR:104.25,663:EUR:97.43,902:EUR:20.01
* */

/* expected output
CZK
909:CZK:222.15
EUR
743:EUR:5.74
902:EUR:19.91
663:EUR:96.95
GBP
932:GBP:32.00
902:GBP:58.04
* */