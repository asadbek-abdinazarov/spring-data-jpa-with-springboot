package uz.javachi.spring_data_jpa_with_spring_boot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer id;
    private String firstname;
    private String lastname;
    private String fullname;
    private Integer age;
}
