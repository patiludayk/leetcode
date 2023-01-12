package com.uday.practise.ps;

import java.util.ArrayList;
import java.util.List;

/**
 * Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.
 * <p>
 * The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
 * <p>
 * It is much easier to understand with an example:
 * <p>
 * * For seconds = 62, your function should return
 * "1 minute and 2 seconds"
 * * For seconds = 3662, your function should return
 * "1 hour, 1 minute and 2 seconds"
 * For the purpose of this Kata, a year is 365 days and a day is 24 hours.
 * <p>
 * Note that spaces are important.
 * <p>
 * Detailed rules
 * <p>
 * The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
 * <p>
 * The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ", just like it would be written in English.
 * <p>
 * A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.
 * <p>
 * Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
 * <p>
 * A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
 * <p>
 * A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
 */
public class HumanReadableTime {

    public static void main(String[] args) {

        int seconds = 3662; //1 hour, 1 minute and 2 seconds

        HumanReadableTime readableTime = new HumanReadableTime();
        readableTime.readTime(seconds);
    }

    private void readTime(int seconds) {
        int years = 0, hours = 0, minutes = 0;
        List<String> timeString = new ArrayList<>();
        boolean year, hour, minute;

        StringBuilder time = new StringBuilder();
        if ((years = seconds / (365 * 24 * 60 * 60)) >= 1) {
            //year or +
            seconds = seconds % 365 * 24 * 60 * 60;
            time.append(years);
            //time.append(" years, ");
            year = true;
        }
        if ((hours = seconds / (60 * 60)) >= 1) {
            //hour
            seconds = seconds % (60 * 60);

            time.append(hours);
            //time.append(" hour, ");
            hour = true;
        }
        if ((minutes = seconds / 60) >= 1) {
            //minutes
            seconds = seconds % 60;
            time.append(minutes);
            //time.append(" minute and ");
            minute = true;
        }


        if (seconds != 0) {
            time.append(seconds);
            if (seconds == 1) {
                time.append(" second");
            } else if (seconds != 0) {
                time.append(" seconds");
            }
        }

        System.out.println("year:" + years + " hour:" + hours + " minute:" + minutes + " seconds:" + seconds);
    }
}
