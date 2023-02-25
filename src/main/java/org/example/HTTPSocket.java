package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class HTTPSocket {
    @SneakyThrows
    public static void main(String[] args) {
        try (var socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8080)) {
            var writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer.println("GET /demo HTTP/1.1");
            writer.println("Host: 8080");
            writer.println("Cookie:JSESSIONID=69B870ED1BA6C58A79C4F09343CBA138");
            writer.println("Accept: application/json");
            writer.println("Connection: close");
            writer.println();
            writer.flush();
            reader.lines().forEach(System.out::println);
        }
    }
}
