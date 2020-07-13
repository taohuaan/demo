package com.example.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client_Test extends Thread {

    private Socket so;

    private Client_Test(String ip, int port) {

        try {
            so = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        new acceptMessage().start();

        try {
            InputStream is = so.getInputStream();
            byte[] buf = new byte[1024];
            int a;
            while ((a = is.read(buf)) != -1) {
                System.out.println("server say ;" + new String(buf, 0, a, StandardCharsets.UTF_8));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    class acceptMessage extends Thread {

        public void run() {

            OutputStream is;
            Scanner sc;

            try {
                sc = new Scanner(System.in);
                is = so.getOutputStream();
                String str = "";
                do {
                    str = sc.next();
                    is.write(str.getBytes(StandardCharsets.UTF_8));
                    is.flush();
                } while (!"q".equals(str));

                sc.close();
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client_Test ct = new Client_Test("127.0.0.1", 8081);
        ct.start();
    }
}
