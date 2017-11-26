package com.pavel.bookshop.resources;

import com.codahale.metrics.annotation.Timed;
import com.github.davidmoten.rx.jdbc.Database;
import com.google.inject.Inject;
import com.pavel.bookshop.BookshopConfiguration;
import com.pavel.bookshop.api.Book;
import com.pavel.bookshop.db.RxDb;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BooksResource {

    final private Database db;

    @Inject
    public BooksResource(RxDb rxDb) {
        this.db = rxDb.getDbProvider();
    }

    @GET
    @Timed
    @Path("list")
    public List<Book> list() throws Throwable {

        List<Book> books = db
                .select("select book_id, book_name from book")
                .autoMap(Book.class)
                .toList().toBlocking().single();

        return books;
    }

    @GET
    @Timed
    @Path("{id}")
    public Book book(@PathParam("id") Long id) throws Throwable {

        Book book = db
                .select("select book_id, book_name from book where book_id = " + id)
                .autoMap(Book.class)
                .firstOrDefault(null)
                .toBlocking().single();

        return book;
    }
}
