package uz.javachi.mapstruct.person;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String apartment;
}
