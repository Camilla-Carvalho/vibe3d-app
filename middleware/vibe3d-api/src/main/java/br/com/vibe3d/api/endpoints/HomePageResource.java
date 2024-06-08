package br.com.vibe3d.api.endpoints;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;

@ApplicationScoped
public class HomePageResource {

    //@Inject
    //HomePageRepository homePageRepository;

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/hello2")
//    public HomePage mainPage(){
//
//        HomePage home = HomePage.findAll(Sort.descending("id")).firstResult();
//        //HomePage home = homePageRepository.findLastHomePage();
//
//        System.out.println("titulo: "+home.titulo);
//
//        return home;
//    }

    @GET
    @Path("/")
    public String home(){
        return "Hello my friend!";
    }

    @GET
    @Path("/{name}")
    public String greet(@PathParam("name") String name) {
        return "Hello "+name+"!";
    }
}