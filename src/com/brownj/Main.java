package com.brownj;

import java.io.File;
import java.util.Scanner;

public class Main {
    enum Profession{SCIENTIST, TEACHER, UNKNOWN}

    class employeeRec{
        private int id;
        private char jobCode;
        private String lastName;
        private String firstName;
        private String profession;

        employeeRec(int id, char jobCode, String lastName, String firstName, String profession){
            this.id = id;
            this.jobCode = jobCode;
            this.lastName = lastName;
            this.firstName = firstName;
            this.profession = profession;
        }

        public String getId() {
            String idString = String.valueOf(id);
            return idString;
        }

        public char getJob() {
            return jobCode;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getProfession() {
            return profession;
        }
    }


    public static void main(String[] args) {
	char[] scientistCodes = {'B', 'C', 'P'};
	char[] teacherCodes = {'E', 'H', 'U'};
	String[] lineElements;

	try{
        File file = new File("//home//captread//JavaProgramming//Employee_Listing"+
                "employee.txt");
        Scanner fileIn = new Scanner(file);
        lineElements = fileIn.nextLine().split("\\s");

        while(fileIn.hasNextLine()){
            for(String value : lineElements){
                System.out.println(value);
            }
        }

    }
	catch(Exception e){
	    e.printStackTrace();
    }


    }


}
