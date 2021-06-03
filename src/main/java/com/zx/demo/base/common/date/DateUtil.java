package com.zx.demo.base.common.date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;


public class DateUtil {
    public static final String DATETIME_FORMAT_STRING = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd";

    public static final String DATE_FORMAT_STRIN_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_STRIN_YYYYMMDD_HHMM = "yyyy-MM-dd HH:mm";

    public static final String DATE_FORMAT_STRIN_YYYYMMDD = "yyyyMMdd";

    public static final String DATE_FORMAT_STRIN_YYMMDD = "yyMMdd";

    public static final String DATE_FORMAT_STRIN_YYYYMM = "yyyyMM";

    public static final String DATE_FORMAT_STRIN_YYYY = "yyyy";

    public static final String DATE_FORMAT_STRIN_HHMM = "HHmm";

    public static final String DATE_FORMAT_STRIN_HHMMSS = "HH:mm:ss";

    public static final String DATE_FORMAT_STRIN_DD = "dd";

    public static final String DATE_FORMAT_STRIN_MMDD = "MMdd";

    /**
     * 格式化日期 yyyy-MM-dd
     *
     * @param date 日期
     * @return 日期字符串
     */
    public static final String format(Date date) {
        return Optional.ofNullable(date)
                .map(e -> DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(e))
                .orElse(StringUtils.EMPTY);
    }

    /**
     * 格式化日期 指定格式
     *
     * @param date 日期
     * @return 日期字符串
     */
    public static final String format(Date date, String format) {
        return Optional.ofNullable(date).map(e -> DateFormatUtils.format(e, format))
                .orElse(StringUtils.EMPTY);
    }

    /**
     * 格式化日期时间 yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param date 日期
     * @return 日期时间字符串
     */
    public static final String formatDateTime(Date date) {
        return Optional.ofNullable(date)
                .map(e -> DateFormatUtils.format(e, DATETIME_FORMAT_STRING))
                .orElse(StringUtils.EMPTY);
    }

    /**
     * 转换为日期
     *
     * @param dateStr 日期字符串
     * @return 日期
     * @throws ParseException 转换异常
     */
    public static final Date parse(String dateStr) throws ParseException {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }

        return DateUtils.parseDate(dateStr, DATE_FORMAT_STRING, DATETIME_FORMAT_STRING, DATE_FORMAT_STRIN_YYYYMMDD_HHMMSS);
    }

    /**
     * 获取明天日期
     *
     * @param date 日期
     * @return 明天日期
     */
    public static final Date getNextDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    /**
     * 获取星期几
     *
     * @param date 日期
     * @return 1=星期一  2=星期二 ... 7=星期日
     */
    public static final String getWeek(Date date) {
        // 再转换为时间
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int hour = c.get(Calendar.DAY_OF_WEEK);
        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        switch (hour) {
            case 1:
                return "7";
            case 2:
                return "1";
            case 3:
                return "2";
            case 4:
                return "3";
            case 5:
                return "4";
            case 6:
                return "5";
            case 7:
                return "6";
            default:
                return "0";
        }
    }

    public static final String getWeek(String date) throws ParseException {
        return getWeek(parse(date));
    }

    /**
     * 判断是否是月末
     *
     * @param date
     * @return true：是月末  false:不是月末
     */
    public static final boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    /**
     * 获取上一个月
     *
     * @return 返回六位  YYYYMM
     */
    public static final String getLastMonth() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STRIN_YYYYMM);
        //过去一月
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String ret = format.format(m);
//        System.out.println("过去一个月："+mon);
        return ret;
    }

    /**
     * 获取去年
     *
     * @return 返回格式  YYYY
     */
    public static final String getLastYear() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STRIN_YYYYMM);
        //过去一月
        c.setTime(new Date());
        c.add(Calendar.YEAR, -1);
        Date m = c.getTime();
        String ret = format.format(m);
//        System.out.println("去年："+mon);
        return ret;
    }

    /**
     * 获取上季度
     *
     * @return 返回格式  YYYY+ 01 02 03 04
     */
    public static final String getLastQuarter() {

        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STRIN_YYYYMM);
        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        Date m = c.getTime();
        String ret = format.format(m);
        String year = ret.substring(0, 4);
        String month = ret.substring(4);
        String quarter = "";
        switch (month) {
            case "01":
                quarter = "01";
                break;
            case "02":
                quarter = "01";
                break;
            case "03":
                quarter = "01";
                break;
            case "04":
                quarter = "02";
                break;
            case "05":
                quarter = "02";
                break;
            case "06":
                quarter = "02";
                break;
            case "07":
                quarter = "03";
                break;
            case "08":
                quarter = "03";
                break;
            case "09":
                quarter = "03";
                break;
            case "10":
                quarter = "04";
                break;
            case "11":
                quarter = "04";
                break;
            case "12":
                quarter = "04";
                break;
            default:
                quarter = "0";
        }
        return year + quarter;
    }

    /**
     * 获取本周一
     *
     * @return
     */
    public static Date getThisWeekFirstDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获取本周日
     *
     * @return
     */
    public static Date getThisWeekLastDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekFirstDay());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return cal.getTime();
    }

    /**
     * 获取本月第一天
     *
     * @return
     */
    public static Date getThisMonthFirstDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 获取本月最后一天
     *
     * @return
     */
    public static Date getThisMonthLastDay() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        return cal.getTime();
    }

    private static Calendar getCalendarFormYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }

    /**
     * 获取 某年  第几周  的第一天
     *
     * @param year
     * @param weekNo
     * @return
     */
    public static String getStartDayOfWeekNo(int year, int weekNo) {
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        return cal.get(Calendar.YEAR) + "-"
                + String.format("%0" + 2 + "d", cal.get(Calendar.MONTH) + 1) + "-"
                + String.format("%0" + 2 + "d", cal.get(Calendar.DAY_OF_MONTH));

    }

    /**
     * 获取 某年  第几周 最后一天
     *
     * @param year
     * @param weekNo
     * @return
     */
    public static String getEndDayOfWeekNo(int year, int weekNo) {
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return cal.get(Calendar.YEAR) + "-"
                + String.format("%0" + 2 + "d", cal.get(Calendar.MONTH) + 1) + "-"
                + String.format("%0" + 2 + "d", cal.get(Calendar.DAY_OF_MONTH));
    }

    public static String getLastDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        int day = calendar.getActualMaximum(Calendar.DATE);

        calendar.set(Calendar.DAY_OF_MONTH, day);
        String lastDayOfMonth = (new SimpleDateFormat("yyyy-MM-dd")).format(calendar.getTime());
        return lastDayOfMonth;
    }

    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }

    public static Date getYestDay() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day1 = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day1 - 1);
        return c.getTime();
    }

    /**
     * 获取N天以后的日期
     *
     * @param
     * @return
     */
    public static Date getDaysLater(Date date, int n) {
        Calendar calendar = new java.util.GregorianCalendar();
        calendar.add(Calendar.DATE, n);
        date = calendar.getTime();
        return date;
    }

    public static Map<String, Long> getLast12Month() {
        Map<String, Long> last12Months = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisMonthFirstDay());
        for (int i = 0; i < 12; i++) {
            last12Months.put(cal.get(Calendar.YEAR) + "-" + String.format("%02d", (cal.get(Calendar.MONTH) + 1)), 0L);
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
        }
        return last12Months;
    }


    /**
     * 判断当前时间是否在[8:00, 21:00]区间，注意时间格式要一致
     *
     * @param now 当前时间
     * @return
     */
    public static boolean isEffectiveDate(Date now) {
        Instant instant = now.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localTime = instant.atZone(zoneId).toLocalDateTime();
        LocalDateTime startTime = LocalDate.now().atTime(8, 0, 0);
        LocalDateTime endTime = LocalDate.now().atTime(20, 59, 59);
        if (localTime.isAfter(startTime) && localTime.isBefore(endTime)) {
            return true;
        }else{
            return false;
        }
    }
}
