package com.solvd.parsers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser implements Parsable {

    final Logger LOGGER = LogManager.getLogger(DomParser.class);
    

    @Override
    public Airport parse(File aFile1) {

        Airport airport = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(aFile1);
            document.getDocumentElement().normalize();
            LOGGER.debug("Root element: " + document.getDocumentElement().getNodeName());
            NodeList airline = document.getElementsByTagName("airline");
            for (int i = 0; i < airline.getLength(); i++) {
                Node aNode = airline.item(i);
                LOGGER.debug("Element: " + aNode.getNodeName());
                if (aNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) aNode;
                    Node node1 = e.getElementsByTagName("name").item(0);
                    String name = node1.getTextContent();
                    Node node2 = e.getElementsByTagName("dob").item(0);
                    String dob = node2.getTextContent();
                    NodeList airplanes = document.getElementsByTagName("airplane");
                    for (int j = 0; j < airplanes.getLength(); j++) {
                        Node bNode = airplanes.item(j);
                        LOGGER.debug("Element: " + bNode.getNodeName());
                        if (bNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element el = (Element) bNode;
                            String id = el.getAttribute("id");
                            Node node4 = el.getElementsByTagName("model").item(0);
                            String model = node4.getTextContent();
                            Node node5 = el.getElementsByTagName("capacity").item(0);
                            String capacity = node5.getTextContent();
                            LOGGER.debug("Airline name: " + name);
                            LOGGER.debug("Airline dob: " + dob);
                            LOGGER.debug("Airplane id: " + id);
                            LOGGER.debug("Airplane model: " + model);
                            LOGGER.debug("Airplane capacity: " + capacity);
                            NodeList seats = document.getElementsByTagName("seat");
                            for (int k = 0; j < airplanes.getLength(); k++) {
                                Node cNode = airplanes.item(k);
                                LOGGER.debug("Element: " + cNode.getNodeName());
                                if (bNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element element = (Element) bNode;
                                    Node node6 = el.getElementsByTagName("seatPitch").item(0);
                                    String seatPitch = node6.getTextContent();
                                    Node node7 = element.getElementsByTagName("width").item(0);
                                    String width = node7.getTextContent();
                                    Node node8 = element.getElementsByTagName("seatRows").item(0);
                                    String seatRows = node8.getTextContent();
                                    Node node9 = element.getElementsByTagName("type").item(0);
                                    String type = node9.getTextContent();
                                    LOGGER.debug("Seat pitch: " + seatPitch);
                                    LOGGER.debug("Seat width: " + width);
                                    LOGGER.debug("Distance between rows: " + seatRows);
                                    LOGGER.debug("Seat type: " + type);
                                }
                            }
                        }
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return airport;
    }
}
