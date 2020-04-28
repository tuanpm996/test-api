/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viettel.vtcc.reputa.orm.api.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.*;

import static java.net.Proxy.Type.SOCKS;

@Slf4j
public class HttpAction {
    //use for local


    public static final boolean DISABLE_HTTPS_CERTIFICATE = false;
    public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) SFive/76.0 Chrome/76.0.3809.94 Safari/537.36";

    static {
        if (DISABLE_HTTPS_CERTIFICATE) {
            log.info("Disable https certificate");
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };
            try {
                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            } catch (NoSuchAlgorithmException | KeyManagementException e) {
                e.printStackTrace();
            }

            HostnameVerifier allHostsValid = (hostname, session) -> true;

            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        }
    }

    public static String redirectUrl(String Url) {
        try {
            HttpURLConnection con = null;
            String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) SFive/76.0 Chrome/76.0.3809.94 Safari/537.36";
            URL obj = new URL(Url);


            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setConnectTimeout(10000);
            con.setReadTimeout(10000);
            int response_code = con.getResponseCode();
            URL urlLast = con.getURL();
            return urlLast.toString();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }


    public static Map<String, Map<String, List<String>>> sendRequest(Request request) {
        HttpURLConnection con = null;
        try {
            URL obj = new URL(request.getUrl());

            if (request.getIpAddress() != null) {
                Proxy proxy;
                String[] splitAddress = request.getIpAddress().split(":");
                String ip = splitAddress[0];
                int port = Integer.parseInt(splitAddress[1]);
                switch (request.getProxyType()) {
                    case HTTP:
                        proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
                        con = (HttpURLConnection) obj.openConnection(proxy);
                        break;
                    case SOCKS:
                        SocketAddress sockAddr = new InetSocketAddress(ip, port);
                        proxy = new Proxy(SOCKS, sockAddr);
                        con = (HttpURLConnection) obj.openConnection(proxy);
                        break;
                    default:
                        con = (HttpURLConnection) obj.openConnection();
                        break;
                }
            } else {
                con = (HttpURLConnection) obj.openConnection();
            }
            if(request.getHeaders() != null) {
                for (String key: request.getHeaders().keySet()) {
                    con.setRequestProperty(key, request.getHeaders().get(key));
                }
            }
            con.setRequestMethod(request.getMethod());
            con.addRequestProperty("content-type", "application/json;charset=UTF-8");
            con.addRequestProperty("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0dWFucG05OTYiLCJleHAiOjE1ODkxOTQwNzZ9.tfdnRue5TPyOdXIOUGh897csfDnwqpp2FKBw-N8UkSVNI0nhGGlbLutz_vOyeBwPgFluabX55Jt9dAE2IoVyvA");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setReadTimeout(20000);
            con.setConnectTimeout(20000);
            con.setUseCaches(false);
            if (request.getAuthentication() != null) {
                con.addRequestProperty("Authorization", request.getAuthentication());
            }
            con.setDoOutput(true);
            con.setDoInput(true);
            if (request.getParameters() != null) {
                byte[] data = request.getParameters().getBytes(StandardCharsets.UTF_8);
                con.addRequestProperty("content-length", String.valueOf(data.length));
                try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                    wr.write(data, 0, data.length);
                    wr.flush();
                }
            }
            int responseCode = con.getResponseCode();
//            Map<String, List<String>> map = con.getHeaderFields();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                Map<String, Map<String, List<String>>> test = new HashMap<>();
                test.put(response.toString(), con.getHeaderFields());
                return test;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream(), StandardCharsets.UTF_8));

            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Map<String, Map<String, List<String>>> test = new HashMap<>();
            test.put(response.toString(), con.getHeaderFields());
        } catch (IOException ex) {
            log.error(ex.getMessage());
            log.error("error request: {}", request);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return null;
    }

}
