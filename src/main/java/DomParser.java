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
import java.io.IOException;

public class DomParser implements Parsable {

    final Logger LOGGER = LogManager.getLogger(DomParser.class);

    @Override
    public void parse() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("C:\\Users\\Yana\\Desktop\\ticket_booking\\src\\main\\resources\\booking.xml");
            NodeList airplaneList = document.getElementsByTagName("airplane");
            for (int i = 0; i < airplaneList.getLength(); i++) {
                Node a = airplaneList.item(i);
                if (a.getNodeType() == Node.ELEMENT_NODE) {
                    Element airplane = (Element) a;
                    String id = airplane.getAttribute("id");
                    NodeList info = airplane.getChildNodes();
                    for (int j = 0; j < info.getLength(); j++) {
                        Node in = info.item(j);
                        if (in.getNodeType() == Node.ELEMENT_NODE) {
                            Element information = (Element) in;
                            LOGGER.debug("Airline :" + id + "\n" + information.getTagName() + ":" + information.getTextContent());
                        }
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
