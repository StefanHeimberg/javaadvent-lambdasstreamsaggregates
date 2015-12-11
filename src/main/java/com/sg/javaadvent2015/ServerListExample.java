package com.sg.javaadvent2015;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ward: 2015-12-09
 */
public class ServerListExample {

    public static void main(String[] args) {

        // we'll keep servers in an ArrayList
        List<Server> servers = new ArrayList<>();

        // create several Servers to manipulate
        Server one = new Server();
        one.setName("web01");
        one.setIp("192.168.1.1");
        one.setManufacturer("Dell");
        one.setRam(8);
        one.setNumProcessors(9);
        one.setPurchaseDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
        one.setName("db01");
        one.setIp("192.168.3.45");
        one.setManufacturer("HP");
        one.setRam(16);
        one.setNumProcessors(24);
        one.setPurchaseDate(LocalDate.parse("2013-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
        one.setName("hr124");
        one.setIp("192.168.32.111");
        one.setManufacturer("IBM");
        one.setRam(16);
        one.setNumProcessors(12);
        one.setPurchaseDate(LocalDate.parse("2014-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
        one.setName("eng16");
        one.setIp("192.168.32.56");
        one.setManufacturer("HP");
        one.setRam(4);
        one.setNumProcessors(8);
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        one = new Server();
        one.setName("eng64");
        one.setIp("192.168.34.56");
        one.setManufacturer("HP");
        one.setRam(8);
        one.setNumProcessors(16);
        one.setPurchaseDate(LocalDate.parse("2001-01-01", DateTimeFormatter.ISO_DATE));

        servers.add(one);

        // First Example: Print the names of all the Dell servers in inventory
        String manufacturer = "Dell";
        System.out.println("++++++++++");
        System.out.println("Here are the names of the servers made by " + manufacturer + " currently in inventory:");

        servers
                .stream()
                .filter(s -> s.getManufacturer().equalsIgnoreCase(manufacturer))
                .forEach(server -> System.out.println(server.getName()));

        System.out.println();

        // Second Example: Print the names of all the servers older than 3 years old in inventory
        long age = 3;
        System.out.println("++++++++++");
        System.out.println("Here are the names of the servers older than " + age + " years in inventory:");

        servers
                .stream()
                .filter(s -> s.getServerAge() > age)
                .forEach(s -> System.out.println(s.getName()));

        System.out.println();

        // Third Example:  Put all of the servers older than 3 years into a new List and print the names of the servers
        //                 in the new List:
        System.out.println("++++++++++");
        System.out.println("Here are the names of the servers older than " + age + " years in inventory again.");
        System.out.println("This time we extracted them into a separate list and then printed the names.");
        System.out.println("Same result as the previous example but with a different approach.");
        List<Server> oldServers =
                servers
                .stream()
                .filter(s -> s.getServerAge() > age)
                .collect(Collectors.toList());

        oldServers
                .stream()
                .forEach(s -> System.out.println(s.getName()));


        System.out.println();

        // Fourth Example:  Calculate the average age of the servers in inventory:
        System.out.println("++++++++++");
        System.out.println("The average age of the servers in inventory (in years) is:");
        double averageAge =
                servers
                .stream()
                .mapToLong(s -> s.getServerAge())
                //.mapToLong(Server::getServerAge())
                .average()
                .getAsDouble();

        System.out.println(averageAge);
        System.out.println();
    }
}
