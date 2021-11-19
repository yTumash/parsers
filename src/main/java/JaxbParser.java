import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements Parsable {

    final Logger LOGGER = LogManager.getLogger(DomParser.class);

    @Override
    public void parse() {

        File file = new File("C:\\Users\\Yana\\Desktop\\ticket_booking\\src\\main\\resources\\booking.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(Airport.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Airport airport = (Airport) unmarshaller.unmarshal(file);
            LOGGER.debug("Airport id: " + airport.getId());
            LOGGER.debug("Airport name : " + airport.getName());
            LOGGER.debug("Airport airlines : " + airport.getAirlines());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
