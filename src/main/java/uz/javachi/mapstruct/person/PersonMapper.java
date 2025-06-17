package uz.javachi.mapstruct.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

 /*   @Mappings(
            value = {
                    @Mapping(target = "fullName", source = "personDTO.name"),
                    @Mapping(target = "age", source = "personDTO.age"),
                    @Mapping(target = "addressCity", source = "addressDTO.city"),
                    @Mapping(target = "apartment", source = "addressDTO.apartment"),
                    @Mapping(target = "passportNumber", source = "passportDTO.passportNumber"),
                    @Mapping(target = "passportSerial", source = "passportDTO.passportSerial")
            }
    )*/
   /* @Mapping(target = "name", source = "personDTO.name")
    @Mapping(target = "age", source = "personDTO.age")
    @Mapping(target = "city", source = "addressDTO.city")
    @Mapping(target = "apartment", source = "addressDTO.apartment")
    @Mapping(target = "passportSerial", source = "passportDTO.passportSerial")
    @Mapping(target = "passportNumber", source = "passportDTO.passportNumber")
    Person toEntity(PersonDTO personDTO, AddressDTO addressDTO, PassportDTO passportDTO);*/
}
