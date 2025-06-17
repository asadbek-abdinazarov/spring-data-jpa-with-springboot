package uz.javachi.mapstruct.person;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PassportDTO {
    private String passportNumber;
    private String passportSerial;
}
