package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/16/17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins","Tucuman 2330");
        Book  ddd = new Book("Domain Driven Design", "1234");
        eric.getBooks().add(ddd);
        ddd.setPublisher(harper);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wx = new Publisher("Wrox","New York 2031");
        Book noEJB = new Book("J2EE Development without EJB", "23444");
        rod.getBooks().add(noEJB);
        noEJB.setPublisher(wx);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(wx);
        bookRepository.save(noEJB);

    }
}
