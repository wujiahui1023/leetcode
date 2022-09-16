package util.json;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author wuJiaHui
 * @date 2022/9/16 13:13
 */
public class JsonUtils {

    /**
     * https://blog.csdn.net/lqk1603/article/details/101309313
     * @param args
     * @param <T>
     * @return
     */
    public static <T> List<T> main(String args) {

        String result= "{\"data\":[{\"id\":0,\"orgName\":null,\"orgCode\":null,\"brand\":1,\"brandName\":null,\"ip\":\"111.2.68.16\",\"port\":8062,\"user\":\"admin\",\"pwd\":\"AHKyLd5/SX+MlS+6Ua+ByQ==\",\"cameraChannel\":\"23\",\"cameraName\":\"相机-2\",\"cameraId\":\"0f2c6ce5dabb4006b6632f55c74b6824\",\"point\":3,\"cycle\":300,\"typeName\":\"小循环\"},{\"id\":0,\"orgName\":null,\"orgCode\":null,\"brand\":1,\"brandName\":null,\"ip\":\"111.2.68.16\",\"port\":8062,\"user\":\"admin\",\"pwd\":\"AHKyLd5/SX+MlS+6Ua+ByQ==\",\"cameraChannel\":\"22\",\"cameraName\":\"相机-3\",\"cameraId\":\"6696fbd7c9e74189b79052a925e27722\",\"point\":3,\"cycle\":300,\"typeName\":\"小循环\"}],\"success\":true}";
//        JsonNode nodes = CaptureManager.getMAPPER().readTree(result);
//        boolean success = nodes.path("success").asBoolean();
//        if (!success) {
//            return Collections.emptyList();
//        }
//        JsonNode data = nodes.get("data");
//        Iterator<JsonNode> elements = data.elements();
//        while (elements.hasNext()) {
//            JsonNode next = elements.next();
//            String text = next.toString();
//            String cameraId = next.get("cameraId").asText();
//            String digestAsHex = DigestUtils.md5DigestAsHex(text.getBytes(StandardCharsets.UTF_8));
//            if (!digestAsHex.equals(CaptureManager.getConfigMd5().get(cameraId))) {
//                CaptureManager.getConfigMd5().put(cameraId, digestAsHex);
//                Config value = CaptureManager.getMAPPER().readValue(text, Config.class);
//                value.setPwd(AESCipher.decrypt(value.getPwd(), aesSecret));
//                value.setCycle(value.getCycle());
//                configs.add(value);
//            }
//        }
        return Collections.emptyList();
    }
}
