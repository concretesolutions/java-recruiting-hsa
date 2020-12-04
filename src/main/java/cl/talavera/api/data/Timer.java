package cl.talavera.api.data;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

public class Timer {
    public Date now() throws ParseException {
        return Date.from(Instant.now());
    }
}
