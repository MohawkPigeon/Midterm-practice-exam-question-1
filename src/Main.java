import service.Service;
import service.data.Date;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        int day;
        int month;
        int year;
        int day1;
        int month1;
        int year1;

        Scanner keyboard=new Scanner(System.in);

        day=5;
        month=7;
        year=3;
        Date dag=new Date(day, month, year);
        System.out.println(dag);

        day1=2;
        month1=4;
        year1=3;

        Date dag1=new Date(day1, month1, year1);
        Service miles1=new Service(11,dag1);

        Service miles=new Service(20,dag);
        System.out.println(miles);
        System.out.println(miles.getMileage());
        System.out.println(miles.getDate());

        ServiceBook bog=new ServiceBook();
        bog.addService(miles);
        System.out.println(bog);
        bog.addService(miles1);
        System.out.println(bog);

        System.out.println(bog.getNumberOfServices());

        int index=1;
        System.out.println(bog.getService(index));

        System.out.println(bog.getAllServices());

        System.out.println(bog.getAllServiceMilages());

        System.out.println(bog.hasServiceOnDate(dag));

        System.out.println(bog.getDateOfLastService());
    }


}