package App.Model;

import App.Controller.Simulation;

import java.util.ArrayList;

public class Queue extends Thread {
    private boolean isServing;
    private final ArrayList<Client> clientsToServe=new ArrayList<>();
    int ID;
    Client currentClient;
    int timeToFinish=0;

    public int getTimeToFinish(){
        return timeToFinish;
    }
    public ArrayList<Client> getClientsToServe(){
        return clientsToServe;
    }

    public boolean isServing() {
        return isServing;
    }

    public Queue(int ID) {
        this.isServing = false;
        this.ID=ID;
    }

    public synchronized void addClient(Client client){
        clientsToServe.add(client);
        notifyAll();
    }

    public synchronized void serveClient(){
        if(timeToFinish==0 && !clientsToServe.isEmpty()){
            currentClient=clientsToServe.get(0);
            timeToFinish=currentClient.serviceTime-1;
            isServing=true;
            notifyAll();
        }

    }


    public void run() {
        while(Simulation.time<Simulation.simulationTime){
            if(!isServing){
                serveClient();
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }else {
                if(timeToFinish!=0) {
                    try {
                        timeToFinish--;
                        sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                else{
                    clientsToServe.remove(0);
                    currentClient.serve();
                    isServing=false;
                }
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder queue= new StringBuilder("Queue " + ID + ": ");
        for(Client client:clientsToServe){
            queue.append(client.toString()).append(" ");
        }
        queue.append(";");

        return queue.toString();
    }


}
