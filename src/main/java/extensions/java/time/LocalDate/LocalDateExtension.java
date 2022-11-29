package extensions.java.time.LocalDate;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;

@Extension
public class LocalDateExtension {

    /**
     * Null Exception Throw
     *
     * @param source
     * @return void
     * @throws
     * @author Henny
     * @cdate 2022/11/29 11:10
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 11:10
     * @since 1.0
     */
    private static void isNullException(LocalDate source) {
        if (source.customIsNull()) {
            //TODO 增加异常返回
            throw new NullPointerException("com.dlanqi:base-type-utils Error : source is null");
        }
    }

    //region    判断型

    /**
     * If source Is Null Re true Else Re false
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/11/29 11:10
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 11:10
     * @since 1.0
     */
    public static Boolean customIsNull(@This LocalDate source) {
        return source == null;
    }

    /**
     * If source Is Not Null Re true Else Re false
     * Null Range : Null
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/11/29 11:09
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 11:09
     * @since 1.0
     */
    public static Boolean customIsNotNull(@This LocalDate source) {
        return !source.customIsNull();
    }

    /**
     * If source Is Not Null Re source Else Re errorBack
     * Null Range : Null
     *
     * @param source
     * @param errorBack
     * @return java.time.LocalDate
     * @throws
     * @author Henny
     * @cdate 2022/11/29 11:09
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 11:09
     * @since 1.0
     */
    public static LocalDate customIsNotNull(@This LocalDate source, LocalDate errorBack) {
        return source.customIsNotNull() ? source : errorBack;
    }

    //endregion

    //region 转换型

    /**
     * LocalDate 转Date
     *
     * @param localDate
     * @return java.util.Date
     * @throws
     * @author Henny
     * @cdate 2022/11/29 11:05
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 11:05
     * @since 1.0
     */
    public static Date customToDate(LocalDate localDate) {
        isNullException(localDate);
        return Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
    }

    /**
     * LocalDate 转 Date
     *
     * @param localDate
     * @param errorBack
     * @return java.util.Date
     * @throws
     * @author Henny
     * @cdate 2022/11/29 12:30
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 12:30
     * @since 1.0
     */
    public static Date customToDate(LocalDate localDate, Date errorBack) {
        try {
            return Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        } catch (Exception ex) {
            return errorBack;
        }
    }

    /**
     * LocalDate 转 LocalDateTime
     *
     * @param localDate
     * @return java.time.LocalDateTime
     * @throws
     * @author Henny
     * @cdate 2022/11/29 12:31
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 12:31
     * @since 1.0
     */
    public static LocalDateTime customToLocalDateTime(LocalDate localDate) {
        isNullException(localDate);
        return localDate.atTime(0, 0, 0);
    }

    /**
     * LocalDate 转 LocalDateTime
     *
     * @param localDate
     * @param errorBack
     * @return java.time.LocalDateTime
     * @throws
     * @author Henny
     * @cdate 2022/11/29 12:31
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 12:31
     * @since 1.0
     */
    public static LocalDateTime customToLocalDateTime(LocalDate localDate, LocalDateTime errorBack) {
        try {
            return localDate.atTime(0, 0, 0);
        } catch (Exception ex) {
            return errorBack;
        }
    }

    public static Long customToTimeStamp(LocalDate localDate) {
        isNullException(localDate);
        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
    }

    public static Long customToTimeStamp(LocalDate localDate, Long errorBack) {
        try {
            return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        } catch (Exception ex) {
            return errorBack;
        }
    }

    public static Long customToTimeStamp(LocalDate localDate, Date errorBack) {
        try {
            return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
        } catch (Exception ex) {
            return errorBack.customToTimeStamp();
        }
    }


    //endregion
}
