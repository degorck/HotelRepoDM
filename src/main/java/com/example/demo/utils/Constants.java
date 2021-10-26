package com.example.demo.utils;

public class Constants {
    public static String DELETED_SUCCESSFULLY = "Deleted successfully";
    public static String IS_REQUIRED = "is required";
    public static String VIP_LABEL = "VIP";
    public static String VALUE_LABEL = "Value";
    public static String BLANK_SPACE = " ";
    public static String INVALID_DATA = "Invalid data";
    public static String HANDLE_ERRORS = "Server error";
    public static String VALIDATION_FAILED = "Validation failed";
    public static String WAS_NOTIFIED= "was notified";
    public static String NEWS_SENT= "News sent";
    public static int DAYS_TO_COMPARE_DATES = 1;
    public static boolean BOOLEAN_TRUE = true;
    public static boolean BOOLEAN_FALSE = false;
    public static String DATE_NOT_AFTER = "Finish date is not after start date";
    public static String ALREADY_CHECKED_IN = "Already checked in";
    public static String DATE_NOT_BEFORE_TODAY = "Start date is not before today";
    public static String METHOD_LABEL = "Class Method: ";
    public static String EXECUTED_IN_LABEL = " executed in ";
    public static String MS_LABEL = "ms";
    public enum ResponseConstant{
        SUCCESS("Success"),
        FAILURE("Failure");

        private String description;

        ResponseConstant(final String description){
            this.description = description;
        }

        public String getDescription(){
            return this.description;
        }
    }
}
