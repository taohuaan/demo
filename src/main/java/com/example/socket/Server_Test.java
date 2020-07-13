package com.example.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server_Test extends Thread {

    private Socket so = null;
    private ServerSocket ss = null;

    private Server_Test(int port) {

        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            System.out.println("server ok !");
            so = ss.accept();
            new sendMessage().start();
            InputStream is = so.getInputStream();
            byte[] buf = new byte[1024];
            int a;
            while ((a = is.read(buf)) != -1) {
                System.out.println("clinet say :" + new String(buf, 0, a, StandardCharsets.UTF_8));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class sendMessage extends Thread {

        public void run() {
            Scanner sc;
            OutputStream os;

            try {
                sc = new Scanner(System.in);
                os = so.getOutputStream();
                String in;
                do {
                    in = sc.next();
                    os.write(in.getBytes(StandardCharsets.UTF_8));
                    os.flush();
                } while (!"q".equals(in));

                sc.close();
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server_Test st = new Server_Test(8081);
        st.start();
    }
}
