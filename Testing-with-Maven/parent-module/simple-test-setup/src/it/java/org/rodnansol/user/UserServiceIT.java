package org.rodnansol.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceIT {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService underTest;

    @Test
    void save_shouldSaveIncomingParametersAsUser() {
        // Given
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/it-users.csv");
        Scanner scanner = new Scanner(resourceAsStream);
        List<String> list = scanner.tokens().toList();
        System.out.println(list);
        // When
        underTest.createNewUser("admin", "StrongPassword!!");
        // Then
        verify(userRepository).save(new User("admin", "StrongPassword!!"));
    }

}