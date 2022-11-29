package extensions.java.time.LocalDateTime;

import manifold.ext.rt.api.Extension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Extension
public class LocalDateTimeExtension {

    public static Date customToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneOffset.ofHours(8)).toInstant());
    }

}
