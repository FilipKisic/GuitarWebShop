package com.gibson.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Filip Kisic
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnectionInfo extends BaseEntity {

    private String username;
    private String ipAddress;
    private LocalDateTime timeOfConnection;

    public ConnectionInfo(int id, String username, String ipAddress, LocalDateTime timeOfConnection) {
        super(id);
        this.username = username;
        this.ipAddress = ipAddress;
        this.timeOfConnection = timeOfConnection;
    }
}
