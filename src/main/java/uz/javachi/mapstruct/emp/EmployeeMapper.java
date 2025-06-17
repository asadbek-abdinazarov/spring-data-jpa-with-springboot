package uz.javachi.mapstruct.emp;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Map;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);


    @MapMapping(keyTargetType = String.class, valueTargetType = String.class)
    Employee fromMap(Map<String, String> params);

    @MapMapping(keyTargetType = String.class, valueTargetType = Object.class)
    Employee fromMapParamObj(Map<String, Object> params);

    default String fromObjToStr(Object obj) {
        return String.valueOf(obj);
    }
}
