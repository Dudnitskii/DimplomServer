package com.example.diplomserver;

import com.example.diplomserver.Model.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.diplomserver.Handler.findUser;

public class Server extends Thread{
    private final Handler handler = new Handler();
    private Socket clientSocket = null;
    public Server(Socket socket){
        this.clientSocket = socket;
    }

    private static final String LOG_IN = "logIn";
    private static final String SHOW_QUERY = "show";
    private static final String DELETE_QUERY = "delete";
    private static final String UPDATE_QUERY = "update";
    private static final String SEARCH_QUERY = "search";
    private static final String ADD_USER = "add user";
    private static final String CHECK_USER = "check user";

    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8000);

        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился!");
            Server server = new Server(clientSocket);
            server.start();
        }
    }

    public void run(){
        try
        {
            while (true) {
                ObjectOutputStream writerObj = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream readerObj = new ObjectInputStream(clientSocket.getInputStream());

                while (!clientSocket.isClosed()){
                    String action = (String) readerObj.readObject();
                    String request;
                    String[] arr;
                    switch (action){
                        case ADD_USER -> {
                            String requestObj = (String) readerObj.readObject();
                            arr = requestObj.split("=");
                            User user = new User(arr[0], arr[1],arr[2]);
                            handler.insertUser(user);
                            writerObj.writeObject("Пользователь успешно добавлен!");
                        }

                        case DELETE_QUERY -> {
                            request = (String) readerObj.readObject();
                            arr = request.split(";");
                            handler.delete(Integer.parseInt(arr[0]), arr[1]);
                        }

                        case UPDATE_QUERY -> {
                            Basic basic = (Basic) readerObj.readObject();
                            request = (String) readerObj.readObject();
                            handler.update(basic, request);
                        }

                        case SHOW_QUERY -> {
                            request = (String) readerObj.readObject();
                            ArrayList list = handler.show(request);
                            writerObj.writeObject(list);
                        }

//                        case SEARCH_QUERY -> {
//                            Basic basic = (Basic) readerObj.readObject();
//                            request = (String) readerObj.readObject();
//                            writerObj.writeObject(handler.search(basic, request));
//                        }

                        case LOG_IN -> {
                            request = (String) readerObj.readObject();
                            String res = findUser(request);
                            writerObj.writeObject(res);
                        }

                        case CHECK_USER -> {
                            request = (String) readerObj.readObject();
                            writerObj.writeObject(handler.checkUser(request));
                            System.out.println("Request complite");
                        }
                    }
                }

                readerObj.close();
                writerObj.close();
                clientSocket.close();
            }
        }catch (IOException | ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        }
    }
}