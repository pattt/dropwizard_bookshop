package com.pavel.bookshop.db;

import com.github.davidmoten.rx.jdbc.ConnectionProvider;
import com.github.davidmoten.rx.jdbc.ConnectionProviderFromUrl;
import com.github.davidmoten.rx.jdbc.Database;
import com.google.inject.Inject;
import com.pavel.bookshop.BookshopConfiguration;
import com.pavel.bookshop.Interface.DB;
import com.pavel.bookshop.configurations.DataBaseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RxDb implements DB {
    private static final Logger LOG = LoggerFactory.getLogger(RxDb.class);

    final private DataBaseConfiguration configuration;

    @Inject
    public RxDb(BookshopConfiguration configuration) {
        this.configuration = configuration.getDbConfig();
    }

    public Database getDbProvider() {
        Database db = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ConnectionProvider connectionProvider
                    = new ConnectionProviderFromUrl(
                    String.format("jdbc:mysql://%s:%s/bookShop", configuration.getHost(), configuration.getPort()),
                                  configuration.getLogin(),
                                  configuration.getPassword());
            db = Database.from(connectionProvider);
        } catch (ClassNotFoundException e) {
            LOG.error("Error creation db connection", e);
        }
        return db;
    }
}
