package uz.javachi.mapstruct.car;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDTO {
    private String carName;
    private Double carPrice;
}
