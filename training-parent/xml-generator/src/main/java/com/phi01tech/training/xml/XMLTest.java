package com.phi01tech.training.xml;

import java.util.Arrays;
import java.util.List;

public class XMLTest {

    public static void main(String[] args) {
        GeoLocationXMLGenerator generator = new GeoLocationXMLGenerator();

        List<GeoLocation> l1 = Arrays.asList(new GeoLocation(0.0, 0.0));
        List<GeoLocation> l2 = Arrays.asList(new GeoLocation(0.0, 90.0));

        String xml = generator.toXml(l1);
        System.out.println(xml);

        xml = generator.toXml(l2);
        System.out.println(xml);
    }
}
