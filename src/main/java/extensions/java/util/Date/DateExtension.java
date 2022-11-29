package extensions.java.util.Date;

import cn.hutool.core.date.DateUtil;
import com.Utils.CustomTimeZone;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Extension
public class DateExtension {

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
    private static void isNullException(Date source) {
        if (source.customIsNull()) {
            //TODO 增加异常返回
            throw new NullPointerException("com.dlanqi:base-type-utils Error : source is null");
        }
    }

    /**
     * 默认为标准时间格式带毫秒
     */
    private static String pattern = "yyyy-MM-dd HH:mm:ss.fff";

    /**
     * 默认时区为上海
     */
    private static CustomTimeZone timeZone = CustomTimeZone.Asia_Shanghai;

    //region   初始化

    private static void init() {
        DateExtension.pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        DateExtension.timeZone = CustomTimeZone.Asia_Shanghai;
    }

    private static void init(String pattern) {
        DateExtension.pattern = pattern;
        DateExtension.timeZone = CustomTimeZone.Asia_Shanghai;
    }

    private static void init(CustomTimeZone timeZone) {
        DateExtension.pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        DateExtension.timeZone = timeZone;
    }

    private static void init(String pattern,CustomTimeZone timeZone) {
        DateExtension.pattern = pattern;
        DateExtension.timeZone = timeZone;
    }

    //endregion

    private static String of(Date date) {
        return sdf().format(date);
    }

    private static SimpleDateFormat sdf(){
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat(pattern);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timeZone.customToString()));
        return simpleDateFormat;
    }

    //region    判断型

    /**
     * If source Is Null Re true Else Re false
     *
     * @param source
     * @return java.lang.Boolean
     * @throws
     * @author Henny
     * @cdate 2022/11/29 12:42
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 12:42
     * @since 1.0
     */
    public static Boolean customIsNull(@This Date source) {
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
    public static Boolean customIsNotNull(@This Date source) {
        return !source.customIsNull();
    }

    /**
     * If source Is Not Null Re source Else Re errorBack
     * Null Range : Null
     *
     * @param source
     * @param errorBack
     * @return java.util.Date
     * @throws
     * @author Henny
     * @cdate 2022/11/29 12:42
     * @version 1.0
     * @muser Henny
     * @mdate 2022/11/29 12:42
     * @since 1.0
     */
    public static Date customIsNotNull(@This Date source, Date errorBack) {
        return source.customIsNotNull() ? source : errorBack;
    }

    //endregion

    //region    功能型

    /**
     * 时间累加
     *
     * @param source
     * @param dayOfMonth
     * @return java.util.Date
     * @throws
     * @author Henny
     * @cdate 2022/10/17 20:15
     * @version 1.0
     * @mdate 2022/10/17 20:15
     * @since 1.0
     */
    public static Date customPlusDay(@This Date source, int dayOfMonth) {
        if (source == null) {
            return null;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(source);
        ca.add(Calendar.DATE, dayOfMonth);
        return ca.getTime();
    }

    /**
     * 根据日期获取星期几
     *
     * @param source
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/10/18 17:08
     * @version 1.0
     * @mdate 2022/10/18 17:08
     * @since 1.0
     */
    public static Integer customGetWeekByDate(@This Date source) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(source);
        //因为数组下标从0开始，而返回的是数组的内容，是数组{1,2,3,4,5,6,7}中用1~7来表示，所以要减1
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w == 0) {
            w = 7;
        }
        return w;
    }

    /**
     * 获取日期间隔月份集合
     *
     * @param startTime
     * @param endTime
     * @return java.util.List<java.lang.String>
     * @throws
     * @author Henny
     * @cdate 2022/10/18 17:24
     * @version 1.0
     * @mdate 2022/10/18 17:24
     * @since 1.0
     */
    public static List<String> customGetMonthListByDateRange(@This Date startTime, Date endTime) {
        SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM");
        List<String> month = new ArrayList<>();
        month.add(dfm.format(startTime));
        if (!dfm.format(startTime).equals(dfm.format(endTime))) {
            long monthsBetween = ChronoUnit.MONTHS.between(
                    startTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().withDayOfMonth(1),
                    endTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().withDayOfMonth(1));
            for (int i = 1; i <= (int) monthsBetween; i++) {
                Date addDate = DateUtil.offsetMonth(startTime, i);
                month.add(dfm.format(addDate));
            }
        }
        return month;
    }

    public static Date customSetTimeZone(@This Date source, CustomTimeZone customTimeZone) {
        init(customTimeZone);
        return source.customToLocalDateTime(customTimeZone).customToDate(CustomTimeZone.Asia_Shanghai);
    }

    public static String customFormat(@This Date source) {
        init();
        return of(source);
    }
    public static String customFormat(@This Date source,String pattern) {
        init(pattern);
        return of(source);
    }
    public static String customFormat(@This Date source,CustomTimeZone customTimeZone) {
        init(customTimeZone);
        return of(source);
    }
    public static String customFormat(@This Date source,String pattern, CustomTimeZone customTimeZone) {
        init(pattern,customTimeZone);
        return of(source);
    }

    //endregion


    //region   转换型

    public static LocalDateTime customToLocalDateTime(@This Date source) {
        isNullException(source);
        init();
        return source.customToLocalDateTime(timeZone);
    }

    public static LocalDateTime customToLocalDateTime(@This Date source, CustomTimeZone customTimeZone) {
        isNullException(source);
        init(customTimeZone);
        return source.toInstant().atZone(ZoneOffset.ofHours(timeZone.customToInt())).toLocalDateTime();
    }

    public static LocalDate customToLocalDate(@This Date source) {
        isNullException(source);
        return source.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }

    public static LocalTime customToLocalTime(@This Date source) {
        isNullException(source);
        return source.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalTime();
    }

    public static Long customToTimeStamp(@This Date source) {
        isNullException(source);
        return source.getTime();
    }

    //endregion

}
