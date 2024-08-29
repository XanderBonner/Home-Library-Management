package com.Jeffs.Home.Library.Service;

import com.Jeffs.Home.Library.Entity.Publisher;
import com.Jeffs.Home.Library.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    //find all publishers
    public List<Publisher> findAllPublisher(){
        return publisherRepository.findAll();
    }

    //find publisher by id
    public Publisher findPublisherById(int publisherID){
        Optional<Publisher> result = publisherRepository.findById(publisherID);
        Publisher publisher = null;
        //if value is present that we can retrieve
        if(result.isPresent()){
            publisher = result.get();
        } else {
            //we didn't find the publisher
            throw new RuntimeException("Did not find the publisher id: " + publisherID);
        }
        return publisher;
    }

    //save publisher
    public Publisher savePublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    //delete publisher
    public void deletePublisherById(int publisherID) {
        if (!publisherRepository.existsById(publisherID)) {
            throw new RuntimeException("Did not find author id: " + publisherID);
        }
        publisherRepository.deleteById(publisherID);
    }
}
