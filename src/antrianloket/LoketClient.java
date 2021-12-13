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

/**
 *
 * @author Sigma
 */
public class Test {

    public static DatagramSocket clientsocket;
    public static DatagramPacket dp;
    public static BufferedReader dis;
    public static InetAddress ia;
    public static byte buf[] = new byte[1024];
    public static int cport = 789, sport = 790;
    
    public ArrayList<String> antrianAdmin = new ArrayList<String>();
    public ArrayList<String> antrianTeller = new ArrayList<String>();
    public ArrayList<String> antrianCs = new ArrayList<String>();

    public int nomorAntrianAdmin = 0;
    public int nomorAntrianTeller = 0;
    public int nomorAntrianCs = 0;

    public static void main(String[] args) throws IOException {
        clientsocket = new DatagramSocket(cport);
        dp = new DatagramPacket(buf, buf.length);
        dis = new BufferedReader(new InputStreamReader(System.in));
        ia = InetAddress.getLocalHost();
        System.out.println("Server is Running...");
        
        while(true){
        clientsocket.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength());
        
        String[] arrOfStr = str.split(",");
        
        System.out.println(arrOfStr[0]);
        System.out.println(arrOfStr[1]);
        System.out.println(arrOfStr[2]);
        
        System.out.println("Server: " + str);
        }
        
    }
}
