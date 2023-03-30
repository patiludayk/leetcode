package com.uday.practise.company.saltpay;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        String s = "GBP:100,EUR:200,CZK:1000|743:EUR:5.76,932:GBP:32.10,909:CZK:223.26,23:CZK:890.22,902:GBP:58.23,89:EUR:104.25,663:EUR:97.43,902:EUR:20.01";

        String firstpart = s.split("\\|")[0];
        Map<String, Double> ccrbalnce = new TreeMap<>();

        Arrays.asList(firstpart.split(","))
                .forEach(val -> ccrbalnce.put(val.split(":")[0], Double.valueOf(val.split(":")[1])));

        // System.out.println(ccrbalnce.toString());


        String secondpart = s.split("\\|")[1];
        ArrayList<Agent> agentCurrencyAmount = new ArrayList();
        ArrayList<Agent> finalList = new ArrayList();


        Map<Integer, Map<String, Double>> deductmap = new TreeMap<>();
        Arrays.asList(secondpart.split(","))
                .forEach(val -> agentCurrencyAmount.add(new Agent(Integer.valueOf(val.split(":")[0]),
                        val.split(":")[1],
                        Double.valueOf(val.split(":")[2]))));

        agentCurrencyAmount.sort(Comparator.comparing((Agent b) -> b.getCurrency()).thenComparing((Agent b) -> b.getAmount()));

        //  System.out.println(agentCurrencyAmount.toString());

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        agentCurrencyAmount.forEach(entry -> {

            String ccType = entry.getCurrency();
            Double fundToDeduct = entry.getAmount();

            if (ccrbalnce.get(ccType) >= fundToDeduct) {
                if (ccType.equals("GBP")) {
                    entry.setAmount(Double.parseDouble(df.format(fundToDeduct - (fundToDeduct * 0.33) / 100)));
                } else {
                    entry.setAmount(Double.parseDouble(df.format(fundToDeduct - (fundToDeduct * 0.50) / 100)));
                }
                ccrbalnce.put(ccType, ccrbalnce.get(ccType) - entry.getAmount());
                finalList.add(entry);
                //   System.out.println(entry.toString());
            }
        });

        finalList.stream().collect(Collectors.groupingBy(Agent::getCurrency));

        System.out.println(finalList.toString());


        finalList.stream().forEach(agent -> {
            System.out.println(agent.getCurrency());
            System.out.println(agent.getId()+":"+agent.getCurrency()+":"+ agent.getAmount());


        });
    }
}




/* expected output
 "GBP:100,
 EUR:200,
 CZK:1000

 |743:EUR:5.76,

 909:CZK:223.26,
 23:CZK:890.22,
 89:EUR:104.25,
 663:EUR:97.43,
 902:EUR:20.01"


 902:GBP:58.23,
 932:GBP:32.10,;


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

class Agent {
    int id;
    String currency;
    double amount;

    public Agent(int id, String currency, double amount) {
        this.id = id;
        this.currency = currency;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}