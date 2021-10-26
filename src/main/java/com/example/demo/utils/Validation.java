package com.example.demo.utils;

import com.example.demo.exception.InvalidDataException;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.GenericValidator;

import java.util.Date;
import java.util.TimeZone;

import static com.example.demo.utils.Constants.DATE_NOT_AFTER;
import static com.example.demo.utils.Constants.DATE_NOT_BEFORE_TODAY;
import static com.example.demo.utils.Constants.DAYS_TO_COMPARE_DATES;
import static com.example.demo.utils.Constants.IS_REQUIRED;
import static com.example.demo.utils.Constants.BLANK_SPACE;


public class Validation {
    public static void validateBlankOrNullString(String fieldName, String field){
        if (GenericValidator.isBlankOrNull(field)){
            throw new InvalidDataException(fieldName.concat(BLANK_SPACE.concat(IS_REQUIRED)));
        }
    }

    public static void validateDayAfter(Date endDate, Date startDate){
        if (DateValidator.getInstance().compareDates(endDate, startDate, TimeZone.getDefault()) < DAYS_TO_COMPARE_DATES){
            throw new InvalidDataException(DATE_NOT_AFTER);
        }
    }

    public static void  validateDateABeforeToday(Date date){
        Date currentDate = new Date();
        if(date.before(currentDate)){
            throw new InvalidDataException(DATE_NOT_BEFORE_TODAY);
        }
    }
}
