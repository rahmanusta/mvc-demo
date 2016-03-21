package com.kodcu;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.MvcContext;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.CsrfValid;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by usta on 12.02.2015.
 */
@Path("/")
@Controller
public class PersonController {

    @Inject
    private Models models;

    @Inject
    private DataStore dataStore;

    @Inject
    private BindingResult bindingResult;

    @POST
    @Path("/person")
    @ValidateOnExecution(type = ExecutableType.NONE)
    @CsrfValid
    public String addPerson(@BeanParam @Valid Person person) {

        if (bindingResult.isFailed()) {
            models.put("messages", bindingResult.getAllMessages());
        } else {
            dataStore.addPerson(person);
        }

        List<Person> personList = dataStore.getPersonList();
        models.put("personList", personList);

        return "person.jsp";
    }

    @GET
    @Path("/person")
    public String person() {
        List<Person> personList = dataStore.getPersonList();
        models.put("personList", personList);
        return "person.jsp";
    }

}
