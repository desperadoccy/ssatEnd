package pers.ccy.ssatweb.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

/**
 * @author desperado
 * @ClassName GetRequestJsonUtils
 * @Description
 * @date 2020/6/30 16:44
 * @Version 1.0
 */
public class GetRequestJsonUtils {
    /**
     * @param [request]
     * @MethodName getPostRequestJsonString
     * @Description 返回 json  字符串
     */
    public static String getPostRequestJsonString(HttpServletRequest request) {
        BufferedReader br;
        StringBuilder sb = null;
        String jsonString = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    request.getInputStream()));
            String line = null;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            jsonString = URLDecoder.decode(sb.toString(), "UTF-8");
            jsonString = jsonString.substring(jsonString.indexOf("{"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
