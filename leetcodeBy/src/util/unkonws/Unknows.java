package util.unkonws;

/**
 * @author wuJiaHui
 * @date 2022/9/16 9:30
 */
public class Unknows {

    //分辨率解析
    public static String parseResolution(int dwResolution) {
        int interlace = (((dwResolution) >> 28) & 0x1);
        int width = ((((dwResolution) >> 19) & 0x1ff) << 3);  //宽
        int hight = ((((dwResolution) >> 8) & 0x7ff) << 1); //高
        int fps = ((dwResolution) & 0xff);  //帧率
        String result = width + "*" + hight + "_" + fps;
        return result;


    }
}
