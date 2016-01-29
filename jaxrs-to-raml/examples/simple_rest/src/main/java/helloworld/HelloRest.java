package helloworld;

import contacts.Contact;
import contacts.Contacts;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Path("/hello")
public class HelloRest {


    //    @Path("/composite/contacts")
//    @GET
//    @Produces({"application/xml","application/json"})
//    public Contacts getContacts1() {
//        return null;
//    }
//
//    @Path("/collection/contacts")
//    @GET
//    @Produces({"application/xml","application/json"})
//    public ArrayList<Contact> getContacts2() {
//        return null;
//    }
//
//    @Path("/array/contacts")
//    @GET
//    @Produces({"application/xml","application/json"})
//    public Contact[] getContacts3() {
//        return null;
//    }
//
//    @Path("/map/contacts")
//    @GET
//    @Produces({"application/xml","application/json"})
//    public HashMap<Long,Contact> getContacts4() {
//        return null;
//    }
//    @Path("/collection/entity")
//    @GET
//    @Produces({"application/xml","application/json"})
//    public CollectionEntity getCollectionEntity() {
//        return null;
//    }
    @Path("/array/entity")
    @GET
    @Produces({"application/xml", "application/json"})
    public CollectionEntity[] getArray() {
        return null;
    }

    @Path("/collection/entity")
    @GET
    @Produces({"application/xml", "application/json"})
    public Collection<CollectionEntity> getCollection() {
        return null;
    }

    @Path("/collection-entity")
    @GET
    @Produces({"application/xml", "application/json"})
    public CollectionEntity getCollectionEntity() {
        return null;
    }
//    @Path("/contacts/{id}")
//    @POST
//    public void addContact1(@PathParam("id") Long id,
//                           @QueryParam("name") String name,
//                           @QueryParam("email") String email,
//                           @QueryParam("telephone") String telephone) {
//
//    }
//
//    @Path("/contacts/form/{id}")
//    @POST
//    @Consumes("application/x-www-form-urlencoded")
//    public void addContact2(@PathParam("id") Long id,
//                           @FormParam("name") String name,
//                           @FormParam("email") String email,
//                           @FormParam("telephone") String telephone) {
//
//    }
//
//    @Path("/contacts/{id}")
//    @PUT
//    @Consumes({"application/xml","application/json"})
//    @Produces({"application/xml","application/json"})
//    public Contact updateContact(@PathParam("id") Long id ,Contact contact) {
//        return null;
//    }
//
//    @Path("/contacts/{id}")
//    @DELETE
//    public void deleteContact(@PathParam("id") Long id) {
//
//    }

}
