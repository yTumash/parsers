import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonParser implements Parsable{

    private static final Logger LOGGER = LogManager.getLogger(Airport.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private Airport airport;

    @Override
    public Airport parse(File aFile2) {
        {
            try {
                airport = objectMapper.readValue(aFile2, Airport.class);
                LOGGER.debug(" Airport ID: " + airport.getId() + " Airport Name: " + airport.getName() + " Airport Airlines: " + airport.getAirlines());

            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return airport;
    }
}
