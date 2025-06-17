package uz.javachi.spring_data_jpa_with_spring_boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SimpleController {

    private final PersonProperties personProperties;

    public SimpleController(PersonProperties personProperties) {
        this.personProperties = personProperties;
    }

    @Value("${example.string:'Hello PDP'}")
    private String string;

    @Value("#{${example.numbers}}")
    private Map<String, Integer> numbers;

    @GetMapping
    public String get() {
        return string;
    }

    @GetMapping("/lang")
    public List<String> languages() {
        return personProperties.getLanguages();
    }

    @GetMapping("/lang2")
    public List<String> languages2() {
        return personProperties.getLanguages2();
    }

    @GetMapping("/num")
    public Map<String, Integer> numbers() {
        return numbers;
    }

    @GetMapping("/per")
    public Person getPerson() {
        return personProperties.getPerson();
    }


    @GetMapping("/people")
    public List<Person> getPeoples() {
        return personProperties.getPeoples();
    }

/*

    *//*@Value("${example.languages}")
    private List<String> languages;*//*
    @Value("#{'${example.languages}'.split('# ')}")
    private List<String> languages;



*/


}
