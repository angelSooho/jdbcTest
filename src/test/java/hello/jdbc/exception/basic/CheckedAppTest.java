package hello.jdbc.exception.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.ConnectException;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckedAppTest {

    @DisplayName("체크 예외는 밖으로 던질 수 밖에 없다.")
    @Test
    void checked() throws Exception {
        Controller controller = new Controller();
        assertThatThrownBy(controller::request)
                .isInstanceOf(SQLException.class)
                .hasMessage("ex");
    }

    static class Controller {
        Service service = new Service();

        public void request() throws ConnectException, SQLException {
            service.logic();
        }
    }

    static class Service {
        Repository repository = new Repository();
        NetworkClient networkClient = new NetworkClient();

        public void logic() throws ConnectException, SQLException {
            repository.call();
            networkClient.call();
        }
    }

    static class NetworkClient {
        public void call() throws ConnectException {
            throw new ConnectException("연결 실패");
        }
    }

    static class Repository {
        public void call() throws SQLException {
            throw new SQLException("ex");
        }
    }
}
