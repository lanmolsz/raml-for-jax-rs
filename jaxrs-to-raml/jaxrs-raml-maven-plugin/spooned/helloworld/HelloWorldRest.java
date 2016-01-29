package helloworld;


@javax.ws.rs.Path(value = "/simple")
public class HelloWorldRest {
    @javax.ws.rs.Path(value = "countries/{countryId}/states/{stateId}")
    @javax.ws.rs.DELETE
    public helloworld.Country hello(@javax.ws.rs.PathParam(value = "countryId")
                                    int countryId, @javax.ws.rs.PathParam(value = "stateId")
                                    int stateId) throws java.lang.IllegalArgumentException {
        return null;
    }
}

