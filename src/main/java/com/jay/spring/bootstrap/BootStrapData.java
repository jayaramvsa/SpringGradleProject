package com.jay.spring.bootstrap;

import com.jay.spring.domain.Author;
import com.jay.spring.domain.Book;
import com.jay.spring.domain.Publisher;
import com.jay.spring.repositories.AuthorRepository;
import com.jay.spring.repositories.BookRepository;
import com.jay.spring.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {

        //Publisher Details
        Publisher pBhalaBhavan = new Publisher();
        pBhalaBhavan.setPublisherName("Bhala Bhavan");
        pBhalaBhavan.setAddressLine1("14 Mg Road");
        pBhalaBhavan.setCity("Bangalore");
        pBhalaBhavan.setZipCode("560008");
        pBhalaBhavan.setState("KA");

        publisherRepository.save(pBhalaBhavan);
        //Author Details
        Author aRajaji = new Author("Rajagopala","Chari");
        //Book  Mahabaratha Details
        Book bMahabrath = new Book("Mahabarath" , "4523412");
        aRajaji.getBookSet().add(bMahabrath);
        bMahabrath.getAuthors().add(aRajaji);
        bMahabrath.setPublisher(pBhalaBhavan);
        pBhalaBhavan.getBooks().add(bMahabrath);

        authorRepository.save(aRajaji);
        bookRepository.save(bMahabrath);
        publisherRepository.save(pBhalaBhavan);


        Author aVyas = new Author("Valmiki","Sri");

       //Book Ramayan
        Book bRamayan = new Book("Ramayana","IBSN17213123");
        aVyas.getBookSet().add(bRamayan);
        bRamayan.getAuthors().add(aVyas);
        bRamayan.setPublisher(pBhalaBhavan);
        pBhalaBhavan.getBooks().add(bRamayan);

        authorRepository.save(aVyas);
        bookRepository.save(bRamayan);
        publisherRepository.save(pBhalaBhavan);


        System.out.println("Started in BootStrap");
        System.out.println("Number of Authors :" + authorRepository.count());
        System.out.println("Number of Books:" + bookRepository.count());
        System.out.println("Number of books published by Publisher " + pBhalaBhavan.getBooks().size());

    }

}
