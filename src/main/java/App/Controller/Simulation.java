package App.Controller;

import App.Model.Client;
import App.Model.Queue;
import App.View.GUI;
import App.View.SimulationView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Simulation {
    static GUI view;
    static volatile ArrayList<Client> clients;
    static volatile ArrayList<Queue> queues;
    public static volatile int time = 0;
    public static volatile int simulationTime = 0;
    private static int nextQueue = 0;


    public Simulation() {
        view = new GUI();
        view.getStartButton().addActionListener(start);
    }


    static void generateSimulationObjects(int queues, int clients, int maxTime, int minTime, int minServing, int maxServing) {
        ArrayList<Client> clientsList = new ArrayList<>();
        ArrayList<Queue> queuesList = new ArrayList<>();

        for (int i = 0; i < clients; i++) {
            clientsList.add(new Client(i, (int) (Math.random() * (maxTime - minTime) + minTime),
                    (int) (Math.random() * (maxServing - minServing) + minServing), "Client " + i));
        }

        clientsList.sort(Comparator.comparingInt(Client::getArrivalTime));
        setClients(clientsList);

        for (int i = 0; i < queues; i++) {
            queuesList.add(new Queue(i));
        }

        setQueues(queuesList);
    }

    static boolean initialized = false;

    public static synchronized void addToFastestQueue(Client client) {
        Queue targetQueue = queues.get(nextQueue);
        targetQueue.addClient(client);
        nextQueue = (nextQueue + 1) % queues.size();
    }
    public static synchronized void writeInFile(String data)  {
        File file = new File("output.txt");
        try {
            FileWriter fr = new FileWriter(file, true);
            fr.write(data);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private static void startSimulation() {
        if (!initialized) for (Queue q : queues) q.start();initialized = true;
        SimulationView sv = new SimulationView(clients, queues);sv.setVisible(true);
        sv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread(() -> {
            while (time <= simulationTime) {
                if (!clients.isEmpty() && !queues.isEmpty())
                    while (clients.get(0).getArrivalTime() <= time) {
                        addToFastestQueue(clients.get(0));
                        clients.remove(clients.get(0));
                        if (clients.isEmpty()) {
                            break;
                        }
                    }
                StringBuilder clients = new StringBuilder();
                for (Client c : Simulation.clients) clients.append(c.toString()).append(" ");
                StringBuilder queues = new StringBuilder();
                for (Queue q : Simulation.queues) queues.append(q.toString()).append(" ");
                writeInFile("Time: " + time + "\n" + "Waiting Clients: " + clients.toString() + "\n" + queues.toString() + "\n");
                time++;
                sv.update();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(stopSimulation()) {sv.update(); writeInFile("Time: " + time + "\n" + "Waiting Clients: " + clients.toString() + "\n" + queues.toString() + "\n");break;}
            }
            for(Queue q: queues) q.interrupt();}).start();
    }

    public static boolean stopSimulation(){
        boolean stop=true;
        for(Queue q: queues){
            if(q.getClientsToServe().size()!=0){
                stop=false;
            }
        }
        if(clients.size()!=0){
            stop=false;
        }
        return stop;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static void setClients(ArrayList<Client> clients) {
        Simulation.clients = clients;
    }

    public static void setQueues(ArrayList<Queue> queues) {
        Simulation.queues = queues;
    }

    static ActionListener start = e -> {
        int timeMin, timeMax, queues, clients, minServing, maxServing;
        try {
            timeMin = view.getMinArrivalField().getText().isEmpty() ? 2 : Math.abs(Integer.parseInt(view.getMinArrivalField().getText()));
            timeMax = view.getMaxArrivalField().getText().isEmpty() ? 30 : Math.abs(Integer.parseInt(view.getMaxArrivalField().getText()));
            queues = view.getQueueField().getText().isEmpty() ? 2 : Math.abs(Integer.parseInt(view.getQueueField().getText()));
            clients = view.getClientsField().getText().isEmpty() ? 4 : Math.abs(Integer.parseInt(view.getClientsField().getText()));
            minServing = view.getMinServiceField().getText().isEmpty() ? 2 : Math.abs(Integer.parseInt(view.getMinServiceField().getText()));
            maxServing = view.getMaxServiceField().getText().isEmpty() ? 4 : Math.abs(Integer.parseInt(view.getMaxServiceField().getText()));
            simulationTime = view.getSimulationTimeField().getText().isEmpty()?60:Math.abs(Integer.parseInt(view.getSimulationTimeField().getText()));
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            return;

        }
        generateSimulationObjects(queues, clients, timeMax, timeMin, minServing, maxServing);
        writeInFile("Simulation Data: \n Number of queues: " + queues + "\n Number of clients: "+
                + clients + "\n Simulation time: " + simulationTime + "\n");
        startSimulation();
    };

    public static void main(String[] args) {
        Simulation s = new Simulation();
    }
}
