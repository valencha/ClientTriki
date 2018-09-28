package com.example.estudiante.clienttriki;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Comunicacion extends Thread {
    private DatagramSocket ds;
    boolean conectado;

    public Comunicacion(MainActivity activity) {
        conectado = false;

    }

    @Override
    public void run() {
        while (true) {
            try {
                ds = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }

        }
    }




    public void enviarMensaje(final int pos) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    DataOutputStream salida = new DataOutputStream(baos);
                    salida.writeInt(pos);


                    byte[] buf = baos.toByteArray();

                    InetAddress ip = InetAddress.getByName("127.0.0.1");
                    int puerto = 5000;
                    DatagramPacket p = new DatagramPacket(buf, buf.length, ip, puerto);
                    ds.send(p);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();



    }
}





