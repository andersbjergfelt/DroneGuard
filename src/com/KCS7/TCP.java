package com.KCS7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCP {


    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            Thread.sleep(3000);
            try (
                    ServerSocket aServer = new ServerSocket(6789);
                    Socket cn = aServer.accept();
                    BufferedReader bis = new BufferedReader(new InputStreamReader(cn.getInputStream()));
                    BufferedOutputStream bos = new BufferedOutputStream(cn.getOutputStream());)

            {
                String line = bis.readLine();
                while(line != null && !line.equals(""))
                {
                    System.out.println(line);
                    line = bis.readLine();
                }
                byte[] message="200 OK".getBytes();

                bos.write("HTTP/1.1 200 OK\r\n".getBytes());
                bos.write("Content-Type: text/plain\r\n".getBytes());
                bos.write(("Content-Length: "+message.length+"\r\n").getBytes());
                bos.write("\r\n".getBytes()); // empty line between HTTP header and HTTP content
                bos.write(message);

            } catch (IOException ex) {
                System.out.println("Error in connnection: " + ex.getMessage());
            }
        }
    }
    /*

        DataOutputStream outToServer = new DataOutputStream(welcomeSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + 'n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();

     */

}
