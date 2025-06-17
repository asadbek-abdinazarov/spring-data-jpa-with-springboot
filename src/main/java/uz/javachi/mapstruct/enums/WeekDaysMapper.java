package uz.javachi.mapstruct.enums;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface WeekDaysMapper {

    WeekDaysMapper WEEK_DAYS_MAPPER = Mappers.getMapper(WeekDaysMapper.class);

    @ValueMapping(target = "MONDAY", source = "DUSHANBA")
    @ValueMapping(target = "TUESDAY", source = "SESHANBA")
    @ValueMapping(target = "WEDNESDAY", source = "CHORSHANBA")
    @ValueMapping(target = "THURSDAY", source = "PAYSHANBA")
    @ValueMapping(target = "FRIDAY", source = "JUMA")
    @ValueMapping(target = "SATURDAY", source = "SHANBA")
    @ValueMapping(target = "SUNDAY", source = "YAKSHANBA")
    WeekDays from(Week week);

    @InheritInverseConfiguration
    Week to(WeekDays weekDays);
}
