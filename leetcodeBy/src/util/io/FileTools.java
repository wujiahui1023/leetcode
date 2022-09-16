package util.io;

import java.io.*;

/**
 * @author wuJiaHui
 * @date 2022/9/16 9:28
 */
public class FileTools {

    /**
     * 读取本地文件到数组中
     *
     * @param filename 本地文件
     * @return 返回读取到的数据到 byte数组
     * @throws IOException
     */
    public static byte[] toByteArray(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException(filename);
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] buffer = new byte[1024];
            int len;
            while (-1 != (len = in.read(buffer, 0, buffer.length))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            bos.close();
            in.close();
        }
    }

}
