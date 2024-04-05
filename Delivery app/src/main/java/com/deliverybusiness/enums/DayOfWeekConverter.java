package com.deliverybusiness.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class DayOfWeekConverter implements AttributeConverter<DayOfWeek, String> {
    @Override
    public String convertToDatabaseColumn(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return "Monday";
            case TUESDAY:
                return "Tuesday";

            case WEDNESDAY:
                return "Wednesday";

            case THURSDAY:
                return "Thursday";

            case FRIDAY:
                return "Friday";

            case SATURDAY:
                return "Saturday";

            case SUNDAY:
                return "Sunday";

            default:
                return null;
        }
    }

    @Override
    public DayOfWeek convertToEntityAttribute(String s) {
        switch (s) {
            case "Monday":
                return DayOfWeek.MONDAY;
            case "Tuesday":
                return DayOfWeek.TUESDAY;

            case "Wednesday":
                return DayOfWeek.WEDNESDAY;

            case "Thursday":
                return DayOfWeek.THURSDAY;

            case "Friday":
                return DayOfWeek.FRIDAY;

            case "Saturday":
                return DayOfWeek.SATURDAY;

            case "Sunday":
                return DayOfWeek.SUNDAY;

            default:
                return null;
        }
    }
}
