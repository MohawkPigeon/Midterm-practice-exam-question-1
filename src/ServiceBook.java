import service.Service;
import service.data.Date;

import java.util.*;
import java.util.LinkedList;

public class ServiceBook {
    private LinkedList<Service> serviceList = new LinkedList<>();

    public  void  addService(Service service){
        serviceList.add(service);
    }

    public int getNumberOfServices(){
        return serviceList.size();
    }

    public Service getService(int index){

        if (index<0||index>serviceList.size()){
            return null;
        }
        return serviceList.get(index);
    }

    public List<Service> getAllServices(){
        return serviceList;
        //serviceList.forEach(System.out::println);
    }
    public List<Integer> getAllServiceMilages(){
        List<Integer> mileage=new ArrayList<>();

        for(Service service: serviceList){
            mileage.add(service.getMileage());
        }
        return mileage;
    }

    public boolean hasServiceOnDate(Date date){

        for (Service service : serviceList) {
            if(service.getDate().equals(date))
            {
                return true;
            }
        }
        return false;
    }

    public Date getDateOfLastService(){
        int y=1;
        while(y==1) {

            int firstday = serviceList.getFirst().getDate().getDay();
            int firstmonth = serviceList.getFirst().getDate().getMonth();
            int firstyear = serviceList.getFirst().getDate().getYear();
            int lastday = serviceList.getLast().getDate().getDay();
            int lastmonth = serviceList.getLast().getDate().getMonth();
            int lastyear = serviceList.getLast().getDate().getYear();
            int x = 1;

            while (x == 1) {
                if (firstyear > lastyear) {
                    serviceList.addLast(serviceList.getFirst());
                    serviceList.removeFirst();
                    x = 0;
                }
                if (firstyear == lastyear) {
                    if (firstmonth > lastmonth) {
                        serviceList.addLast(serviceList.getFirst());
                        serviceList.removeFirst();
                        x = 0;
                    }
                    if (firstmonth == lastmonth) {
                        if (firstday > lastday) {
                            serviceList.addLast(serviceList.getFirst());
                            serviceList.removeFirst();
                            x = 0;
                        } else {
                            x=0;
                            y = 0;
                        }
                    }
                    if (firstmonth < lastmonth) {
                        x=0;
                        y = 0;
                    }
                }
                if (firstyear < lastyear) {
                    x=0;
                    y = 0;
                }
            }
        }
    return serviceList.getLast().getDate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceBook that = (ServiceBook) o;

        return Objects.equals(serviceList, that.serviceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceList);
    }

    @Override
    public String toString() {
        return "ServiceBook{" +
                "serviceList=" + serviceList;
    }
}

