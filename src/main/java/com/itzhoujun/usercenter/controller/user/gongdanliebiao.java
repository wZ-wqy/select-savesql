package com.itzhoujun.usercenter.controller.user;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.itzhoujun.usercenter.controller.user.savesql.moreinsertdata;


public class gongdanliebiao  {
    final static String url = "https://oapi.shb.ltd/service/auth/get_access_token";
    final static String jsonContent = null;
    final static JSONObject js = new JSONObject();

    public static void insertshb() {
        try {
            for(int i = 1;i>0;i++) {

                Thread thread = new Thread();
                String res = TestPost.httpPostJson(url, jsonContent);
                res = res.replace("\\", "");
                res = res.substring(0, res.length() - 1);
                res = res.substring(1);
                JSONObject js = JSONObject.fromObject(res);
                String token = js.getJSONObject("data").get("access_token").toString();
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//            String time = df.format(new Date());// new Date()为获取当前系统时间
                //writeTXT("G:\\","token",token+time);
                String gdlb;
                String urlg = "https://oapi.shb.ltd/service/task/get_tasks?accessToken=" + token;
                ArrayList<String> strs = new ArrayList<>();
                JSONObject jso = new JSONObject();
                for (int j = 1; j > 0; j++) {
                    jso = new JSONObject();
                    jso.put("access_token", token);
                    jso.put("pageSize", 50);
                    jso.put("pageNum", j);
                    gdlb = jso.toString();
                    strs.add(gongdan(urlg, gdlb));
                    String code = strs.get(j - 1).replace("\\", "");
                    code = code.substring(0, code.length() - 1);
                    code = code.substring(1);
                    JSONObject cod = JSONObject.fromObject(code);
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                    String time = df.format(new Date());// new Date()为获取当前系统时间
                    System.out.println("时间：" + time);
                    if (cod.getString("errorCode").equals("2006") || cod.getString("errorCode") == "2006" || cod.getString("message") == "未找到有效数据") {

                        break;
                    }
                    String[] st = strs.get(j - 1).split("acceptTime");
                    System.out.println("第" + j + "次循环");
                    moreinsertdata( st);
                    try {
                        thread.sleep(10 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                try {
                    thread.sleep(1800 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception e){

        }


    }

//    public static void writeTXT(String path,String title,String content){
//        try {
//            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
//            /* 写入Txt文件 */
//            File writename = new File(path);// 相对路径，如果没有则要建立一个新的output。txt文件
//            if(!writename.exists()){
//                writename.mkdirs();
//            }
//            writename = new File(path+"\\"+title+".txt");// 相对路径，如果没有则要建立一个新的output。txt文件
//            writename.createNewFile(); // 创建新文件
//            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
//            out.write(content); // \r\n即为换行
//            out.flush(); // 把缓存区内容压入文件
//            out.close(); // 最后记得关闭文件
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }





    public static String gongdan(String url, String jsonContent) {
        CloseableHttpResponse response = null;

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(3000).setConnectTimeout(3000).build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json");
        StringEntity requestEntity = new StringEntity(jsonContent, "utf-8");
        httpPost.setEntity(requestEntity);

        try {
            response = httpClient.execute(httpPost, new BasicHttpContext());
            System.out.println("ok"+ HttpStatus.SC_OK);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK  ) {
                System.out.println("返回空");
                return null;
            }
            HttpEntity entity = response.getEntity();

            if (entity != null) {

                String str = EntityUtils.toString(entity, "utf-8");
                return str;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        } finally {
            try {

                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
