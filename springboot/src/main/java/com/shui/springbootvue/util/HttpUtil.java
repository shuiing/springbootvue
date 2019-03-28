package com.shui.springbootvue.util;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * 请求方式
 */

public class HttpUtil {


    /**
     *
     * 参数为map
     * @param url
     * @param map
     * @return
     * @throws Exception
     */
    public static String doPostData(String url, Map<String,String> map) throws Exception{
        String result = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            // 设置请求的header
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
            StringEntity entity = new StringEntity(HttpUtil.getMapToString(map), "gbk");
            entity.setContentEncoding("gbk");
            httpPost.setEntity(entity);
            // 执行请求
            HttpResponse response = httpClient.execute(httpPost);
//            if (response.getStatusLine().getStatusCode() != 200) {
//                logger.error(String.format("----------调用第三方接口错误,[status:%s]", response.getStatusLine().getStatusCode()));
//                throw new TradeException(BusinessMsg.CALL_REMOTE_ERROR, "调用第三方接口异常");
//            }
            result = EntityUtils.toString(response.getEntity(), "gbk");
        } catch (Exception e) {
//            logger.error("-----------调用第三方接口异常-----------,error:",e);
//            if (e instanceof TradeException) {
//                throw new TradeException(((TradeException) e).getBaseResponse());
//            }else {
//                throw new TradeException(BusinessMsg.CALL_REMOTE_ERROR, "调用第三方接口未知异常");
//            }

        }
        return result;
    }

    /**
     *
     * map转str
     * @param map
     * @return
     */
    public static String getMapToString(Map<String,String> map){
        Set<String> keySet = map.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder。
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if (map.get(keyArray[i]).trim().length() > 0) {
                sb.append(keyArray[i]).append("=").append(map.get(keyArray[i]).trim());
            }
            if(i != keyArray.length-1){
                sb.append("&");
            }
        }
        return sb.toString();
    }

}
