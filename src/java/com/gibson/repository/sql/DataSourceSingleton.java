package com.gibson.repository.sql;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;
import lombok.NoArgsConstructor;

/**
 *
 * @author Filip Kisic
 */
@NoArgsConstructor
public class DataSourceSingleton {
    
    private static final String SERVER_NAME = "localhost";
    private static final String DATABASE_NAME = "GibsonWebShop";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "SQL";
    
    private static DataSource instance;
    
    public static DataSource getInstace(){
        if(instance == null){
            synchronized (DataSource.class){
                if(instance == null){
                    instance = createInstance();
                }
            }
        }
        return instance;
    }

    private static DataSource createInstance() {
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setServerName(SERVER_NAME);
        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }
}
