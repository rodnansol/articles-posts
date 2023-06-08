package org.rodnansol.user;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(String username, String password) {
        return userRepository.save(new User(username, password));
    }

}
