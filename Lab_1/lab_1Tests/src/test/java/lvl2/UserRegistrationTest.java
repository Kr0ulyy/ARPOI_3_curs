package lvl2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {
    @Test
    void testRegisterUser_Positive() {
        // Правильные значения login и password
        boolean result = UserRegistration.registerUser("Viktor", "Secret123", "Secret123");
        assertTrue(result);
    }

    @Test
    void testPasswordNegative_Equals() {
        Exception exception = assertThrows(WrongPasswordException.class, () ->
                UserRegistration.validatePassword("Secret123", "Diffjht456"));
        assertEquals("Invalid password format or passwords do not match", exception.getMessage());
    }

    @Test
    void testPasswordNegative_Matches() {
        Exception exception = assertThrows(WrongPasswordException.class, () ->
                UserRegistration.validatePassword("Secreт123", "Secreт123"));
        assertEquals("Invalid passwor+d format or passwords do not match", exception.getMessage());
    }

    @Test
    void testWrongLoginNegative_Matches() {
        Exception exception = assertThrows(WrongLoginException.class, () ->
                UserRegistration.validateLogin("Vиктор"));
        assertEquals("Invalid LOGIN format", exception.getMessage());
    }

    @Test
    void testWrongLoginNegative_Length() {
        Exception exception = assertThrows(WrongLoginException.class, () ->
                UserRegistration.validateLogin("ViktorButMoreThenTwentySymbols"));
        assertEquals("Invalid LOGIN format", exception.getMessage());
    }
}
