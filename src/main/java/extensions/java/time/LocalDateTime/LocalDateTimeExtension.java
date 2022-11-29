package extensions.java.time.LocalDateTime;

import com.Utils.CustomTimeZone;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Extension
public class LocalDateTimeExtension {

    public static Date customToDate(@This LocalDateTime localDateTime, CustomTimeZone customTimeZone) {
        // 当前系统时区
        //ZoneId currentZone = OffsetDateTime.now().getOffset();
        //// 新时区
        //ZoneId newZone = ZoneId.of(zoneIdEnum.getZoneIdName());
        //// 时区转换
        //return localDateTime.atZone(currentZone).withZoneSameInstant(newZone).toLocalDateTime();
        return Date.from(localDateTime.atZone(ZoneOffset.ofHours(customTimeZone.customToInt())).toInstant());
    }

}
