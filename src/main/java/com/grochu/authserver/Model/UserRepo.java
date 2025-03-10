package com.grochu.authserver.Model;

import java.util.Optional;

public interface UserRepo
{
    Optional<User> findByEmail(String email);
    User save(User user);
    User delete(User user);
    User update(User user);
}
