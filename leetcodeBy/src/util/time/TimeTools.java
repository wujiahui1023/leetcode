package util.time;

/**
 * @author wuJiaHui
 * @date 2022/9/16 9:29
 */
public class TimeTools {

    //SDK时间解析
    public static String parseTime(int time) {
        int year = (time >> 26) + 2000;
        int month = (time >> 22) & 15;
        int day = (time >> 17) & 31;
        int hour = (time >> 12) & 31;
        int min = (time >> 6) & 63;
        int second = (time >> 0) & 63;
        String sTime = year + "-" + month + "-" + day + "-" + hour + ":" + min + ":" + second;
//        System.out.println(sTime);
        return sTime;
    }
}
