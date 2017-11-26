package com.pavel.bookshop.module;

import com.google.inject.AbstractModule;
import com.pavel.bookshop.BookshopConfiguration;
import com.pavel.bookshop.Interface.DB;
import com.pavel.bookshop.db.RxDb;

public class BookShopModule extends AbstractModule {

    BookshopConfiguration configuration;
    public BookShopModule(BookshopConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    protected void configure() {
        bind(DB.class).to(RxDb.class);
        bind(BookshopConfiguration.class).toInstance(this.configuration);
    }
}
