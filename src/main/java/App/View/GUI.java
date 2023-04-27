package App.View;

import App.Controller.Simulation;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    JLabel title=new JLabel("Assignment 2, Queues");
    JLabel queueLabel = new JLabel("Queues");
    JTextField queueField = new JTextField("2");
    JLabel simulationTimeLabel = new JLabel("Time of simulation (seconds)");
    JTextField simulationTimeField = new JTextField("60");
    JLabel ClientsLabel = new JLabel("Number of clients");
    JTextField ClientsField = new JTextField("4");
    JLabel minArrivalLabel = new JLabel("Min arrival time");
    JTextField minArrivalField = new JTextField("2");
    JLabel maxArrivalLabel = new JLabel("Max arrival time");
    JTextField maxArrivalField = new JTextField("30");
    JLabel minServiceLabel = new JLabel("Min service time");
    JTextField minServiceField = new JTextField("2");
    JLabel maxServiceLabel = new JLabel("Max service time");
    JTextField maxServiceField = new JTextField("4");
    JButton startButton = new JButton("Start");
    JLabel currentTimeLabel = new JLabel("Current time"+ Simulation.time);

    JTextField currentState;

    public GUI() {
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Assignment 2, Queues");
        JPanel bigTitle = new JPanel();
        bigTitle.add(title);
        JPanel queuePanel = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        GridBagConstraints q = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx=2;

        add(bigTitle, c);
        c.weightx=1;
        c.gridy = 1;

        queueField.setPreferredSize(new Dimension(100, 20));
        simulationTimeField.setPreferredSize(new Dimension(100, 20));
        ClientsField.setPreferredSize(new Dimension(100, 20));
        minArrivalField.setPreferredSize(new Dimension(100, 20));
        maxArrivalField.setPreferredSize(new Dimension(100, 20));
        minServiceField.setPreferredSize(new Dimension(100, 20));
        maxServiceField.setPreferredSize(new Dimension(100, 20));

        queueField.setHorizontalAlignment(JTextField.RIGHT);
        simulationTimeField.setHorizontalAlignment(JTextField.RIGHT);
        ClientsField.setHorizontalAlignment(JTextField.RIGHT);
        minArrivalField.setHorizontalAlignment(JTextField.RIGHT);
        maxArrivalField.setHorizontalAlignment(JTextField.RIGHT);
        minServiceField.setHorizontalAlignment(JTextField.RIGHT);
        maxServiceField.setHorizontalAlignment(JTextField.RIGHT);

        queuePanel.setLayout(new GridBagLayout());
        queuePanel.add(queueLabel, q);
        q.gridx = 1;

        queuePanel.add(queueField, q);
        q.gridx = 0;
        q.gridy = 1;
        queuePanel.add(simulationTimeLabel, q);
        q.gridx = 1;
        queuePanel.add(simulationTimeField, q);
        q.gridx = 0;
        q.gridy = 2;
        queuePanel.add(ClientsLabel, q);
        q.gridx = 1;
        queuePanel.add(ClientsField, q);
        q.gridx = 0;
        q.gridy = 3;
        queuePanel.add(minArrivalLabel, q);
        q.gridx = 1;
        queuePanel.add(minArrivalField, q);
        q.gridx = 0;
        q.gridy = 4;
        queuePanel.add(maxArrivalLabel, q);
        q.gridx = 1;
        queuePanel.add(maxArrivalField, q);
        q.gridx = 0;
        q.gridy = 5;
        queuePanel.add(minServiceLabel, q);
        q.gridx = 1;
        queuePanel.add(minServiceField, q);
        q.gridx = 0;
        q.gridy = 6;
        queuePanel.add(maxServiceLabel, q);
        q.gridx = 1;
        queuePanel.add(maxServiceField, q);
        q.gridx = 0;
        q.gridy = 7;
        queuePanel.add(startButton, q);
        q.gridx = 0;
        q.gridy = 8;

        c.gridy = 2;
        add(queuePanel, c);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setVisible(true);

    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public JLabel getQueueLabel() {
        return queueLabel;
    }

    public void setQueueLabel(JLabel queueLabel) {
        this.queueLabel = queueLabel;
    }

    public JTextField getQueueField() {
        return queueField;
    }

    public void setQueueField(JTextField queueField) {
        this.queueField = queueField;
    }

    public JLabel getSimulationTimeLabel() {
        return simulationTimeLabel;
    }

    public void setSimulationTimeLabel(JLabel simulationTimeLabel) {
        this.simulationTimeLabel = simulationTimeLabel;
    }

    public JTextField getSimulationTimeField() {
        return simulationTimeField;
    }

    public void setSimulationTimeField(JTextField simulationTimeField) {
        this.simulationTimeField = simulationTimeField;
    }

    public JLabel getClientsLabel() {
        return ClientsLabel;
    }

    public void setClientsLabel(JLabel clientsLabel) {
        ClientsLabel = clientsLabel;
    }

    public JTextField getClientsField() {
        return ClientsField;
    }

    public void setClientsField(JTextField clientsField) {
        ClientsField = clientsField;
    }

    public JLabel getMinArrivalLabel() {
        return minArrivalLabel;
    }

    public void setMinArrivalLabel(JLabel minArrivalLabel) {
        this.minArrivalLabel = minArrivalLabel;
    }

    public JTextField getMinArrivalField() {
        return minArrivalField;
    }

    public void setMinArrivalField(JTextField minArrivalField) {
        this.minArrivalField = minArrivalField;
    }

    public JLabel getMaxArrivalLabel() {
        return maxArrivalLabel;
    }

    public void setMaxArrivalLabel(JLabel maxArrivalLabel) {
        this.maxArrivalLabel = maxArrivalLabel;
    }

    public JTextField getMaxArrivalField() {
        return maxArrivalField;
    }

    public void setMaxArrivalField(JTextField maxArrivalField) {
        this.maxArrivalField = maxArrivalField;
    }

    public JLabel getMinServiceLabel() {
        return minServiceLabel;
    }

    public void setMinServiceLabel(JLabel minServiceLabel) {
        this.minServiceLabel = minServiceLabel;
    }

    public JTextField getMinServiceField() {
        return minServiceField;
    }

    public void setMinServiceField(JTextField minServiceField) {
        this.minServiceField = minServiceField;
    }

    public JLabel getMaxServiceLabel() {
        return maxServiceLabel;
    }

    public void setMaxServiceLabel(JLabel maxServiceLabel) {
        this.maxServiceLabel = maxServiceLabel;
    }

    public JTextField getMaxServiceField() {
        return maxServiceField;
    }

    public void setMaxServiceField(JTextField maxServiceField) {
        this.maxServiceField = maxServiceField;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JLabel getCurrentTimeLabel() {
        return currentTimeLabel;
    }

    public void setCurrentTimeLabel(JLabel currentTimeLabel) {
        this.currentTimeLabel = currentTimeLabel;
    }


    public JTextField getCurrentState() {
        return currentState;
    }

    public void setCurrentState(JTextField currentState) {
        this.currentState = currentState;
    }

}
