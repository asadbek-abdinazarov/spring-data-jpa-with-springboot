package uz.javachi.mapstruct.emp;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static uz.javachi.mapstruct.emp.EmployeeMapper.EMPLOYEE_MAPPER;

class EmployeeMapperTest {

    @Test
    void fromMap() {

        Map<String, String> fistName = Map.of("fistName", "Asadbek",
                "lastName", "Abdinazarov",
                "age", "20");

        Employee employee = EMPLOYEE_MAPPER.fromMap(fistName);
        System.out.println(employee);

    }

    @Test
    void fromMapParamObj() {
        Map<String, Object> fistName = Map.of("fistName", "Asadbek",
                "lastName", "Abdinazarov",
                "age", 20);

        Employee employee = EMPLOYEE_MAPPER.fromMapParamObj(fistName);
        System.out.println(employee);
    }
}