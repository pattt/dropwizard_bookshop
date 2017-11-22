package com.pavel.bookshop;

import com.pavel.bookshop.configurations.DataBaseConfiguration;
import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class BookshopConfiguration extends Configuration {
    public DataBaseConfiguration getDbConfig() {
        return dbConfig;
    }

    @NotNull
    @JsonProperty("dbConfig")
    private DataBaseConfiguration dbConfig;
}
