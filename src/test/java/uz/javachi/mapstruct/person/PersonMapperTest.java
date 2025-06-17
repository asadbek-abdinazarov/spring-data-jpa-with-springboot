package uz.javachi.mapstruct.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static uz.javachi.mapstruct.person.PersonMapper.PERSON_MAPPER;

class PersonMapperTest {

    @Test
    void toEntity() {

        PersonDTO personDTO = new PersonDTO("Asadbek Abdinazarov", 20);
        AddressDTO addressDTO = new AddressDTO("Toshkent", "Qorasaroy 45");
        PassportDTO passportDTO = new PassportDTO("00345334", "AD");
//        Person entity = PERSON_MAPPER.toEntity(personDTO, addressDTO, passportDTO);
//        System.out.println(entity);
    }
}