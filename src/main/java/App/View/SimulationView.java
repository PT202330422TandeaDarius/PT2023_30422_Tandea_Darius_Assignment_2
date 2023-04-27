package App.View;

import App.Controller.Simulation;
import App.Model.Client;
import App.Model.Queue;

import javax.swing.*;
import java.util.ArrayList;

public class SimulationView extends JFrame {
    ArrayList<Client> clients;
    ArrayList<Queue> queues;
    JScrollPane scrollPane;
    JTextArea textArea;

    public SimulationView(ArrayList<Client> clients, ArrayList<Queue> queues){
        this.clients=clients;
        this.queues=queues;
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Simulation");
        this.setLayout(null);
        this.setVisible(true);
        textArea = new JTextArea();
        textArea.setBounds(0,0,500,500);
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0,0,500,500);
        this.add(scrollPane);
        this.setVisible(true);
    }

    public void update() {
        textArea.setText("");
        textArea.append("Time: " + App.Controller.Simulation.time + "\n");
        textArea.append("Waiting Clients: ");
        ArrayList<Client> clientsCopy;
        ArrayList<Queue> queuesCopy;
        synchronized (clients) {
            clientsCopy = new ArrayList<>(clients);
        }
        synchronized (queues) {
            queuesCopy = new ArrayList<>(queues);
        }
        if (!clientsCopy.isEmpty())
            for (Client client : clientsCopy) {
                textArea.append(client.toString() + " ");
            }
        else {
            textArea.append("No clients available");
        }
        textArea.append("\n");
        if (!queuesCopy.isEmpty())
            for (Queue queue : queuesCopy) {
                textArea.append(queue.toString() + "\n");
            }
        else {
            textArea.append("No queues available");
        }
        Simulation.writeInFile(textArea.getText());
    }
}