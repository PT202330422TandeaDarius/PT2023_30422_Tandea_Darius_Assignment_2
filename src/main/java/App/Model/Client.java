package App.Model;

public class Client {
    int id;
    int arrivalTime;
    int serviceTime;
    String name;
    int currentQueue=-1;
    boolean served;

    public Client(int id, int arrivalTime, int serviceTime, String name) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
        this.name = name;
        this.served = false;
    }

    public int getId() {
        return id;
    }
    public void setCurrentQueue(int currentQueue) {
        this.currentQueue = currentQueue;
    }
    public int getCurrentQueue() {
        return currentQueue;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getServiceTime() {
        return serviceTime;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isServed() {
        return served;
    }public void serve() {
        served=true;
    }

    @Override
    public String toString(){
        return " ( "+id+", "+arrivalTime+", "+serviceTime + ") ";
    }
}
