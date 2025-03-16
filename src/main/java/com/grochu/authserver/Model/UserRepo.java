package com.grochu.authserver.Model;

import java.util.Optional;

public interface UserRepo
{
    Optional<User> findByLogin(String email);
    User save(User user);
    User delete(User user);
    User update(User user);
}
