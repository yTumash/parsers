import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser implements Parsable {

    final Logger LOGGER = LogManager.getLogger(DomParser.class);
    private Airport airport;

    @Override
    public Airport parse(File aFile) {

        try {
            JAXBContext context = JAXBContext.newInstance(Airport.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Airport airport = (Airport) unmarshaller.unmarshal(aFile);
            LOGGER.debug("Airport id: " + airport.getId());
            LOGGER.debug("Airport name : " + airport.getName());
            LOGGER.debug("Airport airlines : " + airport.getAirlines());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return airport;
    }
}
