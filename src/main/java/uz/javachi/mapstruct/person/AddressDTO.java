package uz.javachi.mapstruct.person;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String city;
    private String apartment;
}
