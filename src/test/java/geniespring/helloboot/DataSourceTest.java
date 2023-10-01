package geniespring.helloboot;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// 신기한 방식으로 Testing!  SpringContainer를 띄워달라!
// Property 정보도 따로 필요하다.
@HellobootTest
public class DataSourceTest {

    @Autowired
    DataSource dataSource;

    @Test
    void connect() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.close();
    }
}
