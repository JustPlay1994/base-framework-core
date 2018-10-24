package com.justplay1994.github.baseframework;

import com.justplay1994.github.baseframework.util.HttpClientUtils;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

/**
 * @Package: com.justplay1994.github.baseframework
 * @Project: oauth2-server
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/24 16:17
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/24 16:17
 * @Update_Description: huangzezhou 补充
 **/

public class AuthHttpClientTest {

    String authorize_url = "http://localhost:11000/oauth/authorize?" +
            "client_id=admin-oauth&" +
            "response_type=code&" +
            "redirect_uri=http://localhost:11000/index&" +
                "scope=read&" +
                "user_oauth_approval=true&" +
                "scope.read=true&" +
                "authorize=Authorize";

    String token_url = "http://admin-oauth:123-oauth@localhost:11000/oauth/token?" +
            "grant_type=password&" +
            "username=admin&" +
            "password=123&" +
            "scope=read,write,trust";
    @Test
    public void authorize() throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String basicAuth = encoder.encode("admin:123".getBytes());
        HashMap map = new HashMap();
        map.put("Authorization", "Basic "+basicAuth);
        System.out.println(HttpClientUtils.doGet(authorize_url, map));
    }

    @Test
    public void token() throws IOException {
        System.out.println(HttpClientUtils.doPostByForm(token_url,null,null));
    }
}
