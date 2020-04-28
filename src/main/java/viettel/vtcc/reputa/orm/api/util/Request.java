package viettel.vtcc.reputa.orm.api.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.net.Proxy;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class Request {
    private String url;
    private String parameters;
    private String authentication;
    private String ipAddress;
    private String method;
    private Proxy.Type proxyType;
    private Map<String, String> headers;
}
