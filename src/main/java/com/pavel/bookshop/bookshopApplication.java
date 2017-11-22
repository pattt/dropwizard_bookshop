package com.pavel.bookshop;

import com.pavel.bookshop.resources.BooksResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class bookshopApplication extends Application<BookshopConfiguration> {

    public static void main(final String[] args) throws Exception {
        new bookshopApplication().run(args);
    }

    @Override
    public String getName() {
        return "bookshop";
    }

    @Override
    public void initialize(final Bootstrap<BookshopConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final BookshopConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new BooksResource(configuration));
    }

}
