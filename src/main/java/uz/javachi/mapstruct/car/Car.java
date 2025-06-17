package uz.javachi.mapstruct.car;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String id;
    private String name;
    private String maker;
    private Double price;
}
