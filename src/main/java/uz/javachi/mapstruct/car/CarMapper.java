package uz.javachi.mapstruct.car;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface CarMapper {
    CarMapper CAR_MAPPER = Mappers.getMapper(CarMapper.class);

    /*@Mappings(
            value = {
                    @Mapping(target = "carName", source = "name", ignore = true),
                    @Mapping(target = "carPrice", source = "price")
            }
    )
    CarDTO toDto(Car car);*/


   /* @InheritInverseConfiguration
    @Mapping(target = "id", expression = "java(generateId())")
    Car toEntity(CarDTO carDTO);

    default String generateId() {
        return UUID.randomUUID().toString();
    }*/

    /*default Car toEntityWithCustomMethod(CarDTO carDTO) {
        return new Car("2", carDTO.getName(), "GM", carDTO.getPrice());
    }*/

}
