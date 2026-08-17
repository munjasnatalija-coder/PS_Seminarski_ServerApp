/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalija
 */
public class ServerThread extends Thread{
    private ServerSocket serverSocket;
    private List<HandleClientThread> clients;

    public ServerThread() throws IOException {
        serverSocket = new ServerSocket(9000);
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        while(!serverSocket.isClosed()){
            try {
                System.out.println("Waiting for clients...");
                Socket socket = serverSocket.accept();
                HandleClientThread clientThread = new HandleClientThread(socket);
                clientThread.start();
                clients.add(clientThread);
                System.out.println("Clients connected!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
    private void stopAllThreads(){
        for (HandleClientThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
//    private List<User> getAllUsers(){
//        List<User> users=new ArrayList<>();
//        for (HandleClientThread client : clients) {
//            users.add(client.getUser());
//        }
//        return users;
//    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    
}
