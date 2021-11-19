import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JacksonParser implements Parsable{

    private static final Logger LOGGER = LogManager.getLogger(Airport.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void parse() {
        Airport airport;
        {
            try {
                airport = objectMapper.readValue(new File("C:\\Users\\Yana\\Desktop\\ticket_booking\\src\\main\\resources\\booking.json"), Airport.class);
                LOGGER.debug(" Airport ID: " + airport.getId() + " Airport Name: " + airport.getName() + " Airport Airlines: " + airport.getAirlines());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
