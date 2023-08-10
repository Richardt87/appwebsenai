package com.example.appwebsenai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    List<Person> persons = new ArrayList<>();
    int id = 0;


    @GetMapping("/person")
    public Person addPerson(@PathParam("name")String name){
        for(Person p : persons){
            if (p.getName().equals(name)){
                return p;
            }
        }

        return null;

    }

    @PostMapping ("/person")
    public Person addPerson(@PathParam("name") String name, @PathParam("sexo") String sexo){
        Person person = new Person();
        person.setName(name);
        person.setSexo(sexo);
        id++;
        person.setId(id);
        persons.add(person);
        return person;

    }

    @GetMapping("/home")
    public String helloWorld(){
        return "Hello World";
    }
}
