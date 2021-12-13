/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package antrianloket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Sigma
 */
public class LoketClient {

    public static DatagramSocket clientsocket;
    public static DatagramPacket dp;
    public static BufferedReader dis;
    public static InetAddress ia;
    public static byte buf[] = new byte[1024];
    public static int cport = 788, sport = 790;

    public ArrayList<String> antrianAdmin;
    public ArrayList<String> antrianTeller;
    public ArrayList<String> antrianCs;

    public int nomorAntrianAdmin = 0;
    public int nomorAntrianTeller = 0;
    public int nomorAntrianCs = 0;

    public static void main(String[] args) throws IOException {
        clientsocket = new DatagramSocket(cport);
        dp = new DatagramPacket(buf, buf.length);
        dis = new BufferedReader(new InputStreamReader(System.in));
        
        JFrame frame = new JFrame();
        Object result = JOptionPane.showInputDialog(frame, "Input IP Kiosk :");
        
        ia = InetAddress.getByName(String.valueOf(result));
        System.out.println("Server is Running...");
        
        LoketForm loketForm = new LoketForm();

        loketForm.setEnabled(true);
        loketForm.setVisible(true);

        while (true) {
            clientsocket.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            loketForm.receiveArray(str);
            String pesan = (loketForm.antrianAdmin.size() - loketForm.selesaiAdmin)
                    + "," + (loketForm.antrianTeller.size() - loketForm.selesaiTeller)
                    + "," + (loketForm.antrianCs.size() - loketForm.selesaiCs);
            buf = pesan.getBytes();
            clientsocket.send(new DatagramPacket(buf, pesan.length(), ia, sport));
        }
    }

    public LoketClient() {
        this.antrianAdmin = new ArrayList<>();
        this.antrianTeller = new ArrayList<>();
        this.antrianCs = new ArrayList<>();
        
    }
}
