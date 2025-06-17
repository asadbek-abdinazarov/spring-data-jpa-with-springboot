package uz.javachi.spring_data_jpa_with_spring_boot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Setter
@Getter
@ConfigurationProperties(prefix = "example")
public class PersonProperties {
    private List<String> languages;
    private List<String> languages2;
    private Person person;
    private List<Person> peoples;
}
