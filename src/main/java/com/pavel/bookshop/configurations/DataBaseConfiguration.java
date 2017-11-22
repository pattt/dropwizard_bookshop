package com.pavel.bookshop.configurations;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DataBaseConfiguration {

    @Size(min = 40)
    @NotNull
    private String host;
    @NotNull
    private String port;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    @NotEmpty
    private String dbName;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDbName() {
        return dbName;
    }
}
