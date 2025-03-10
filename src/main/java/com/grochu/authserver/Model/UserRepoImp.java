package com.grochu.authserver.Model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoImp implements UserRepo
{
    private JdbcTemplate jdbcTemplate;

    public UserRepoImp(@Qualifier("credentialJdbcTemplate") JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        List<User> result = jdbcTemplate.query("SELECT * FROM credentials WHERE email=?",this::rowToUser,email);
        return (result.size()>0)?Optional.of(result.get(0)) : Optional.empty();
    }

    private User rowToUser(ResultSet row, int rowNum) throws SQLException {
        return new User(row.getString("email"), row.getString("passwd"), row.getString("role"));
    }

    @Override
    public User save(User user) {
        jdbcTemplate.update("INSERT INTO credentials(email, passwd, role) VALUES (?,?,?)",
                user.getEmail(),
                user.getPassword(),
                user.getRole());
        return user;
    }

    @Override
    public User delete(User user) {
        jdbcTemplate.update("DELETE FROM credentials WHERE email=?",user.getEmail());
        return user;
    }

    @Override
    public User update(User user) {
        jdbcTemplate.update("UPDATE credentials SET passwd=? WHERE email=?",user.getPassword(),user.getEmail());
        return user;
    }
}
