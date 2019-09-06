package com.shui.springbootvue.other.pom;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 读取jar文件的sha1码，请求maven官方的solrsearch接口查询该jar文件所对应的maven坐标信息
 */
public class MakeMaveInfo {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

        Element dependencys = new DOMElement("dependencys");
        File dir = new File("E:/project/eifini/WebRoot/WEB-INF/lib");        //需生成pom.xml 文件的 lib路径
        for (File jar : dir.listFiles()) {
            String sha1 = getSha1ByFile(jar);
            Element ele = getMavenInfoBySha1(jar, sha1);
            if(ele.elements().size()>0){
                dependencys.add(ele);
                System.out.println(ele.asXML());
            }
//            else {
//                System.out.println(jar+"====");
//            }
        }
        System.out.println("---------------------------------");
        System.out.println(dependencys.asXML());
    }

    /**
     * 根据jar包输入流获取该文件的sha1码
     * @param file
     * @return
     */
    public static String getSha1ByFile(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest sha1 = MessageDigest.getInstance("SHA1");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[1024];
        int read;
        while ((read = fis.read(data)) != -1) {
            sha1.update(data, 0, read);
        }
        byte[] hashBytes = sha1.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < hashBytes.length; i++) {
            sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    /**
     * 根据sha1码请求接口拿到该jar包对应的maven坐标信息
     * @param jar
     * @param sha1
     * @return
     */
    public static Element getMavenInfoBySha1(File jar, String sha1){
        Element dependency = new DOMElement("dependency");
        String url = "http://search.maven.org/solrsearch/select?q=1:\"";
        StringBuilder sb = new StringBuilder();
        sb.append(url).append(sha1).append("\"&rows=20&wt=json");
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(sb.toString()).ignoreContentType(true).timeout(30000).get();
            String elem = doc.body().text();
            JSONObject response = JSONObject.parseObject(elem).getJSONObject("response");
            if (response.containsKey("docs") && response.getJSONArray("docs").size() > 0) {
                JSONObject obj = response.getJSONArray("docs").getJSONObject(0);
                Element groupId = new DOMElement("groupId");
                Element artifactId = new DOMElement("artifactId");
                Element version = new DOMElement("version");
                groupId.addText(obj.getString("g"));
                artifactId.addText(obj.getString("a"));
                version.addText(obj.getString("v"));
                dependency.add(groupId);
                dependency.add(artifactId);
                dependency.add(version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dependency;
    }

}