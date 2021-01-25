package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String host = "netology.homework";
        int port = 8081;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {

            //   получаю сообщение об имени
            String serverWord = in.readLine();
            System.out.println(serverWord);

            // ввод сообщения
            String nameClient = scanner.nextLine();
            out.write(nameClient + "\r\n");
            out.flush();

            //   получаю сообщение о возрасте
            String serverWord1 = in.readLine();
            System.out.println(serverWord1);

            // ввод сообщения
            String answer = scanner.nextLine();
            out.write(answer + "\r\n");
            out.flush();

            String serverWord2 = in.readLine();
            System.out.println(serverWord2);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
