package com.grochu.authserver.Model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterUserDetailsRepoImp implements RegisterUserDetailsRepo
{
    JdbcTemplate jdbcTemplate;

    public RegisterUserDetailsRepoImp(@Qualifier("userDetailsJdbcTemplate") JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public RegisterUserDetails save(RegisterUserDetails registerUserDetails) {
        jdbcTemplate.update("INSERT INTO users (name, surname, email, phone_number, address_street, address_city,address_state, address_zip) " +
                "VALUES (?,?,?,?,?,?,?,?)",
                registerUserDetails.getName(),
                registerUserDetails.getSurname(),
                registerUserDetails.getEmail(),
                registerUserDetails.getPhoneNumber(),
                registerUserDetails.getAddressStreet(),
                registerUserDetails.getAddressCity(),
                registerUserDetails.getAddressState(),
                registerUserDetails.getAddressZip());
        return null;
    }
}
