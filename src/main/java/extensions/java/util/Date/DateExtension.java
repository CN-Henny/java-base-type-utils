package extensions.java.util.Date;

import cn.hutool.core.date.DateUtil;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Extension
public class DateExtension {

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
     * @param date
     * @return java.lang.Integer
     * @throws
     * @author Henny
     * @cdate 2022/10/18 17:08
     * @version 1.0
     * @mdate 2022/10/18 17:08
     * @since 1.0
     */
    public static Integer customGetWeekByDate(@This Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
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

}
