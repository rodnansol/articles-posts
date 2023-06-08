package org.rodnansol.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService underTest;

    @Test
    void save_shouldSaveIncomingParametersAsUser() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/unit-users.csv");
        Scanner scanner = new Scanner(resourceAsStream);
        List<String> list = scanner.tokens().toList();
        System.out.println(list);
        // Given
        // When
        underTest.createNewUser("admin", "StrongPassword!!");
        // Then
        verify(userRepository).save(new User("admin", "StrongPassword!!"));
    }
}