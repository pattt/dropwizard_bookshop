package com.pavel.bookshop.Interface;

import com.github.davidmoten.rx.jdbc.Database;

public interface DB {
    Database getDbProvider();
}
