/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientservertcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * Trivial client for the date server.
 */
public class DateClient {

    /**
     * Runs the client as an application. First it displays a dialog box asking
     * for the IP address or hostname of a host running the date server, then
     * connects to it and displays the date that it serves.
     */
    public static void main(String[] args) throws IOException {
        String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is\n" + "running the date service on port 9090:");
        Socket socket = new Socket(serverAddress, 9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String answer = input.readLine();
        JOptionPane.showMessageDialog(null, answer);

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        PrintWriter out = new PrintWriter(output, true);
        out.println("ciao");
        
        input.close();
        output.close();
        socket.close();
    }
}
