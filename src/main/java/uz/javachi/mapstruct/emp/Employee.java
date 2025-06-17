package uz.javachi.mapstruct.emp;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String fistName;
    private String lastName;
    private Integer age;
}
