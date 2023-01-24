package com.uday.practise.company.elsvier;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

/**
 * Que : Implement find method
 */
public class TDDTest {

    List<Page> pages;

    {
        pages = generateData();
    }

    public static void main(String[] args) {

        List<Page> result;

        //0. find all pages who's content contains below term
        result = find("corporation");


        //1. return InvalidArgumentException if term is empty
        result = find("");

        //2. return all pages containing term in content - case insensative
        result = find("Corporation");

        //3. retrun all pages with url and content containing term
        result = find("google");

        //4.return InvalidArgumentException if term in invalid ie empty
        result = find("software", "", "online");

        //5. return InvalidArgumentException if term is invalid ie null
        result = find("software", "online", null);

        //6.return all pages containing all terms in its content - should be 0 here as software is in google and microsoft only and online is in goole and amazon only
        result = find("software", "online");

        //6.1 same criteria - result all 3 pages
        result = find("computer", "is", "multinational");

        //6.2 same criteria result only 1 page google
        result = find("engine", "llc");

    }

    private static List<Page> find(String... word) {    //signature should not change

        return null;
    }


    private List<Page> generateData() {

        Page google = Page.builder().url("Google.com").content("Google LLC is an American multinational technology company focusing on search engine technology, online advertising, cloud computing, computer software").build();
        Page microsoft = Page.builder().url("microsoft.com").content("Microsoft Corporation is an American multinational technology corporation producing computer software, consumer electronics, personal computers").build();
        Page amazon = Page.builder().url("amazon.com").content("Amazon.com, Inc. is an American multinational technology company focusing on e-commerce, cloud computing, online advertising, digital streaming").build();

        return Arrays.asList(google, microsoft, amazon);
    }


    @Builder
    class Page {
        String url;
        String content;
    }
}
