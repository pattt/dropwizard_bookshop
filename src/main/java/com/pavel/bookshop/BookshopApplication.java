package com.pavel.bookshop;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pavel.bookshop.module.BookShopModule;
import com.pavel.bookshop.resources.BooksResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BookshopApplication extends Application<BookshopConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BookshopApplication().run(args);
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
        Injector injector = Guice.createInjector(new BookShopModule(configuration));
        environment.jersey().register(injector.getInstance(BooksResource.class));
    }

}
