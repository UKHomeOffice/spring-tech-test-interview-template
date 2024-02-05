package uk.gov.homeoffice.springtechtest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import uk.gov.homeoffice.springtechtest.models.dto.UserPayload;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() {
        System.out.println("testCreateUser");
        UserPayload user = new UserPayload("User 5");

        UserPayload result = userService.createUser(user);

        assertNotNull(result);
        assertEquals(5L, result.getId());
        assertEquals("User 5", result.getName());
    }

    @Test
    public void testGetUserById() {
        UserPayload result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("User 1", result.getName());
    }

    @Test
    public void testGetNonExistentUserById() {
        UserPayload result = userService.getUserById(100L);

        assertNull(result);
    }

    @Test
    public void testGetAllUsers() {
        List<UserPayload> result = userService.getAllUsers();

        assertNotNull(result);
        assertEquals(4, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals("User 1", result.get(0).getName());
        assertEquals(4L, result.get(3).getId());
        assertEquals("User 4", result.get(3).getName());
    }

}
