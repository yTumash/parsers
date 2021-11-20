package com.solvd.parsers;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        DomParser dom = new DomParser();
        dom.parse(new File("src/main/resources/booking.xml"));
        //JaxbParser jaxbparser = new JaxbParser();
        //jaxbparser.parse(new File("src/main/resources/booking.xml"));
        //JacksonParser jp = new JacksonParser();
        //jp.parse(new File("src/main/resources/booking.json"));
    }
}
