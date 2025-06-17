package uz.javachi.mapstruct.enums;

import org.junit.jupiter.api.Test;

import static uz.javachi.mapstruct.enums.WeekDaysMapper.WEEK_DAYS_MAPPER;

class WeekDaysMapperTest {

    @Test
    void from() {

        WeekDays MONDAY = WEEK_DAYS_MAPPER.from(Week.DUSHANBA);
        WeekDays TUESDAY = WEEK_DAYS_MAPPER.from(Week.SESHANBA);
        WeekDays WEDNESDAY = WEEK_DAYS_MAPPER.from(Week.CHORSHANBA);
        WeekDays THURSDAY = WEEK_DAYS_MAPPER.from(Week.PAYSHANBA);
        WeekDays FRIDAY = WEEK_DAYS_MAPPER.from(Week.JUMA);
        WeekDays SATURDAY = WEEK_DAYS_MAPPER.from(Week.SHANBA);
        WeekDays SUNDAY = WEEK_DAYS_MAPPER.from(Week.YAKSHANBA);

        System.out.println(MONDAY);
        System.out.println(TUESDAY);
        System.out.println(WEDNESDAY);
        System.out.println(THURSDAY);
        System.out.println(FRIDAY);
        System.out.println(SATURDAY);
        System.out.println(SUNDAY);

    }

    @Test
    void to() {

        Week DUSHANBA = WEEK_DAYS_MAPPER.to(WeekDays.MONDAY);
        Week SESHANBA = WEEK_DAYS_MAPPER.to(WeekDays.TUESDAY);
        Week CHORSHANBA = WEEK_DAYS_MAPPER.to(WeekDays.WEDNESDAY);
        Week PAYSHANBA = WEEK_DAYS_MAPPER.to(WeekDays.THURSDAY);
        Week JUMA = WEEK_DAYS_MAPPER.to(WeekDays.FRIDAY);
        Week SHANBA = WEEK_DAYS_MAPPER.to(WeekDays.SATURDAY);
        Week YAKSHANBA = WEEK_DAYS_MAPPER.to(WeekDays.SUNDAY);

        System.out.println(DUSHANBA);
        System.out.println(SESHANBA);
        System.out.println(CHORSHANBA);
        System.out.println(PAYSHANBA);
        System.out.println(JUMA);
        System.out.println(SHANBA);
        System.out.println(YAKSHANBA);

    }
}