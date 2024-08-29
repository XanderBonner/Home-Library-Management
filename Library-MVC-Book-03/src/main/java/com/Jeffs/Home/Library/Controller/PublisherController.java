package com.Jeffs.Home.Library.Controller;

import com.Jeffs.Home.Library.Entity.Publisher;
import com.Jeffs.Home.Library.Service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api") //base mapping
public class PublisherController {

    private final PublisherService publisherService;

    //Constructor injection for Service
    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    //GET Mapping for return a "list"
    @GetMapping("/publishers")
    public String findAllPublisher(Model theModel){

        //get publishers from the db
        List<Publisher> thePublishers = publisherService.findAllPublisher();
        //add to the spring model
        theModel.addAttribute("publisher", thePublishers);

        return "Publisher/list-publisher"; //Since we are using Thymeleaf this will send it to the html page. Need to look into Publisher directory in templates.
    }

    //GET Request for CREATING a publisher
    @GetMapping("/publishers/showPublisherFormForAdd")
    public String showPublisherFormForAdd(Model theModel){

        //create model attribute to bind form data
        Publisher thePublisher = new Publisher();

        theModel.addAttribute("publisher", thePublisher);

        return "Publisher/publisher-form";
    }

    //GET Request, for updating a publisher
    @GetMapping("/publishers/showPublisherFormForUpdate")
    public String showPublisherFormForUpdate(@RequestParam("publisherID") int theID, Model theModel){

        //get the publisher from the service
        Publisher thePublisher = publisherService.findPublisherById(theID);
        //set publisher in the model to prepopulate the form
        theModel.addAttribute("publisher", thePublisher);
        //send over to our updateform
        return "Publisher/publisher-form";
    }


    //POST Request, CREATE a new publisher
    @PostMapping("/publishers/save")
    public String addPublisher(@ModelAttribute("publisher") Publisher thePublisher) { //we know the request body will bind the JSON to the given publisher object

        //save the publisher
        publisherService.savePublisher(thePublisher);

        //use a redirect to prevent duplicate submissions
        return "redirect:/api/publishers";
    }


    //DELETE Request, will delete an existing publisher
    @GetMapping("/publishers/deletePublisher")
    public String deletePublisher(@RequestParam("publisherID") int theID){

        //delete the publisher
        publisherService.deletePublisherById(theID);

        //redirect to publishers url
        return "redirect:/api/publishers";
    }


}
