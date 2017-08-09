package com.aharryhughes;


import javax.xml.ws.EndpointReference;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Entry> entries = Entry.populate();
        printEntries(entries);
        printTuesdays(entries);
        countTueWedThur(entries);
        weekendList(entries);
        weekdaySet(entries);
        printDurationGreaterThan10(entries);
        findMaxDuration(entries);
        listGreaterThan50(entries);
    }


    public static void printEntries(List<Entry> entries) {
        System.out.println("For Loop:");
        for (Entry entry : entries) {
            System.out.println(entry + ", ");
        }
        System.out.println("\nStream, forEach:");
        entries.stream().forEach(entry -> System.out.println(entry + ", "));
        System.out.println();
    }

    public static void printTuesdays(List<Entry> entries) {

        //Print out tuesday entries
        System.out.println("For Loop:");
        // write for loop
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getDay() == Day.TUESDAY){
                System.out.println(entries.get(i).toString());
            }
        }
        System.out.println("\nStream, filter, forEach:");
        // write stream
        entries.stream()
                .filter(e -> e.getDay() == Day.TUESDAY)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void countTueWedThur(List<Entry> entries) {
        //Count the number of Tuesday, Wednesday, and Thursday entries
        System.out.println("For Loop:");
        int count = 0;
        // write for loop
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getDay() == Day.TUESDAY || entries.get(i).getDay() == Day.WEDNESDAY || entries.get(i).getDay() == Day.THURSDAY){
                count += 1;
            }
        }
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count);
        System.out.println("Stream, filter, count: ");
        long count1 = 0;
        // write stream
        count1 = entries.stream()
                .filter(e -> e.getDay() == Day.TUESDAY || e.getDay() == Day.WEDNESDAY || e.getDay() == Day.THURSDAY)
                .count();
        System.out.println("Number of entries on Tuesday, Wednesday or Thursday: " + count1);
        System.out.println();
    }

    public static void weekendList(List<Entry> entries) {
        //Create a list of weekend (Saturday and Sunday) entries
        System.out.println("For Loop:");
        List<Entry> weekends = new ArrayList<>();
        // write for loop
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getDay() == Day.SATURDAY || entries.get(i).getDay() == Day.SUNDAY){
                weekends.add(entries.get(i));
            }
        }
        System.out.println(weekends);
        System.out.println("Stream, filter, collect:");
        weekends = entries.stream()
                .filter(e -> e.getDay() == Day.SATURDAY || e.getDay() == Day.SUNDAY)
                .collect(Collectors.toList());
        System.out.println(weekends);
        System.out.println();
    }

    public static void weekdaySet(List<Entry> entries) {
        //Create a SET of weekday entries
        System.out.println("For Loop:");
        Set<String> weekdays = new HashSet<>();
        // write for loop
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getDay() != Day.SATURDAY || entries.get(i).getDay() != Day.SUNDAY){
                weekdays.add(entries.get(i).getNote());
            }
        }
        System.out.println(weekdays);
        System.out.println("Stream, filter, map, collect:");
        weekdays = entries.stream()
                .filter(e -> e.getDay() != Day.SATURDAY || e.getDay() != Day.SUNDAY)
                .map(e -> e.getNote())
                .collect(Collectors.toSet());
        System.out.println(weekdays);
        System.out.println();
    }

    public static void printDurationGreaterThan10(List<Entry> entries){
        System.out.println("For Loop:");
        // write for loop
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getDuration() > 10){
                System.out.println(entries.get(i));
            }
        }
        System.out.println("Stream, filter, forEach:");
        // write stream
        entries.stream()
                .filter(e -> e.getDuration() > 10)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void findMaxDuration(List<Entry> entries){
        System.out.println("For Loop:");
        int temp = 0;
        // write for loop
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getDuration() > temp){
                temp = entries.get(i).getDuration();
            }
        }
        System.out.println("The Max Duration is: " + temp);
        System.out.println("Stream, mapToInt, max, getAsInt:");
        temp = entries.stream()
                .mapToInt(e -> e.getDuration())
                .max()
                .getAsInt();
        System.out.println("The Max Duration is: " + temp);
        System.out.println();
    }

    public static void listGreaterThan50(List<Entry> entries){
        System.out.println("For Loop:");
        List<Entry> greaterThan50 = new ArrayList<>();
        // write for looop
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getDuration() > 50){
                greaterThan50.add(entries.get(i));
            }
        }
        System.out.println(greaterThan50);
        System.out.println("Stream, filter, collect:");
        // write stream
        greaterThan50 = entries.stream()
                .filter(e -> e.getDuration() > 50)
                .collect(Collectors.toList());
        System.out.println(greaterThan50);
        System.out.println();
    }
}
