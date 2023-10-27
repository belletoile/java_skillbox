import com.mod5.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    User user = null;

    @BeforeAll
    @DisplayName("Проверка создания объекта без передачи параметров")
    public void setUp() {
        user = new User();
    }

    @AfterAll
    public void tearDown() {
        user = null;
    }

    @Test
    @DisplayName("Проверка создания объекта с двумя параметрами")
    public void CreateUserWithParameters() {
        User user = new User("task1", "task1@mail.ru");
        assertNotNull(user);
        assertEquals("task1", user.getLogin());
        assertEquals("task1@mail.ru", user.getEmail());
    }



    @Nested
    @DisplayName("Проверка установки значений")
    class setLoginEmail {
        @Test
        @DisplayName("Установка email")
        public void testSetEmail() {
            user.setEmail("test@example.com");
            assertEquals("test@example.com", user.getEmail());

            assertFalse(user.setEmail("test@examplecom"));
            assertFalse(user.setEmail("testexample.com"));
        }

        @Test
        @DisplayName("Установка login")
        public void testSetLogin() {
            user.setLogin("Test1");
            assertEquals("Test1", user.getLogin());

            assertFalse(user.setLogin("Tst"));
        }
    }
}

