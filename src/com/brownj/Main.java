package com.brownj;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    enum Profession{SCIENTIST, TEACHER, UNKNOWN}
    enum ScientistCodes{B, C, P}

    public static void main(String[] args) {
    EmployeeRec myRec;
	String[] lineElements;
	ArrayList<EmployeeRec> records;
	String id = "";
	char jobCode = ' ';
	String lastName = "";
	String firstName= "";
	String profession = "";


	try{
        File file = new File("//home//captdread//JavaProgramming//Employee_Listing"+
                "//employees.txt");
        FileWriter fileWriter = new FileWriter("output.txt",true);
        Scanner fileIn = new Scanner(file);
        records = new ArrayList<>();

        while(fileIn.hasNextLine()){

            lineElements = fileIn.nextLine().split("\\s");

            for(int i = 0; i < lineElements.length; i++){

                switch(i){
                    case 0:
                            id = lineElements[i];
                            break;

                    case 1:
                            jobCode = lineElements[i].charAt(0);
                            break;

                    case 2:
                            lastName = lineElements[i];
                            break;

                    case 3:
                            if(lineElements.length > 4){
                                lastName = lastName + " " + lineElements[i];
                                break;
                            }

                            firstName = lineElements[i];
                            break;

                    case 4:
                            firstName = lineElements[i];
                            break;
                    default:
                        System.out.println("Unable to process file");
                        break;
                }//end switch

            }//end for

            switch(jobCode){
                case 'B':
                        profession = String.valueOf(Profession.SCIENTIST);
                        break;
                case 'C':
                        profession = String.valueOf(Profession.SCIENTIST);
                        break;
                case 'P':
                        profession = String.valueOf(Profession.SCIENTIST);
                        break;
                case 'E':
                        profession = String.valueOf(Profession.TEACHER);
                        break;
                case 'H':
                        profession = String.valueOf(Profession.TEACHER);
                        break;
                case 'U':
                        profession = String.valueOf(Profession.TEACHER);
                        break;
                default:
                    profession = String.valueOf(Profession.UNKNOWN);
                    break;
            }
            myRec = new EmployeeRec(id, jobCode,lastName, firstName, profession.toLowerCase());
            records.add(myRec);
        }//end while

        fileIn.close();

        for(int i = 0; i < records.size(); i++){
            System.out.println("Id: " + records.get(i).getId());
            fileWriter.write("Id: " + records.get(i).getId()+"\n");

            System.out.println("Job Code: "+ records.get(i).getJob());
            fileWriter.write("Job Code: "+ records.get(i).getJob()+"\n");

            System.out.println("Last name: "+ records.get(i).getLastName());
            fileWriter.write("Last name: "+ records.get(i).getLastName()+"\n");

            System.out.println("First name: "+ records.get(i).getFirstName());
            fileWriter.write("First name: "+ records.get(i).getFirstName()+"\n");

            System.out.println("Profession: "+ records.get(i).getProfession());
            fileWriter.write("Profession: "+ records.get(i).getProfession()+"\n");

            System.out.println("\n");
            fileWriter.write("\n");

        }
        fileWriter.close();
    }//end try
	catch(Exception e){
	    e.printStackTrace();
    }


    }


}

class EmployeeRec{
    private String id;
    private char jobCode;
    private String lastName;
    private String firstName;
    private String profession;

    public EmployeeRec(String id, char jobCode, String lastName, String firstName, String profession){
        this.id = id;
        this.jobCode = jobCode;
        this.lastName = lastName;
        this.firstName = firstName;
        this.profession = profession;
    }

    public String getId() {

        return id;
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
