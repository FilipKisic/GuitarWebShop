package com.gibson.utils;

import com.gibson.model.ConnectionInfo;
import com.gibson.services.InfoService;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Filip Kisic
 */
public class ConnectionUtils {
    
    private static final InfoService infoService = new InfoService();
    
    public static void createConnectionInfo(HttpServletRequest request, String username) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        infoService.create(ConnectionInfo.builder().username(username).ipAddress(ipAddress).timeOfConnection(LocalDateTime.now()).build());
    }
    
    public static List<ConnectionInfo> getConnectionInfoList(){
        return infoService.findAll();
    }
}
