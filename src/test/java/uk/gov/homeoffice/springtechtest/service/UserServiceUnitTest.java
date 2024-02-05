package uk.gov.homeoffice.springtechtest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.homeoffice.springtechtest.models.dto.UserPayload;
import uk.gov.homeoffice.springtechtest.models.entities.User;
import uk.gov.homeoffice.springtechtest.repository.UserRepository;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    public void testCreateUser() {
        when(userRepository.save(any(User.class))).thenReturn(new User("User 5", Collections.emptyList()));

        var user = userService.createUser(new UserPayload("User 5"));

        verify(userRepository).save(any(User.class));
        assertNotNull(user);
        assertEquals("User 5", user.getName());
    }

    @Test
    public void testGetUserById_returnsEmptyWithEmpty() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        var user = userService.getUserById(1L);

        verify(userRepository).findById(1L);
        assertNull(user);
    }

    @Test
    public void testGetUserById_returnsNullWithEmpty() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User("User 1", Collections.emptyList())));

        var user = userService.getUserById(1L);

        verify(userRepository).findById(1L);
        assertNotNull(user);
        assertEquals("User 1", user.getName());
    }

}
