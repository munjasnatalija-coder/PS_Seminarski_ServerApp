/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.Controller;
import domain.Kupac;
import domain.Zaposleni;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalija
 */
public class HandleClientThread extends Thread{
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private Zaposleni zaposleni;

    public HandleClientThread(Socket socket) {
        this.socket = socket;
        receiver = new Receiver(socket);
        sender = new Sender(socket);
    }

    @Override
    public void run() {
        while(!socket.isClosed()){
            try {
                Request request = (Request) receiver.receive();
                Response response = handleRequest(request);
                sender.send(response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response();
        try {
            switch (request.getOperation()) {
                case LOGIN:
                    return login(request);
                case UCIATAJ_KUPCE:
                    return ucitajKupce();
                    
            default:
                throw new AssertionError();
            }
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    public Socket getSocket() {
        return socket;
    }

    private Response login(Request request) {
        Response response = new Response();
        Zaposleni trazenZaposleni = (Zaposleni) request.getArgument();
        
        try {
            Zaposleni z = Controller.getInstance().login(trazenZaposleni);
            response.setResponseType(ResponseType.SUCCESS);
            response.setObject(z);
            System.out.println("Uspesna prijava na sistem...");
            zaposleni = z;
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response ucitajKupce() {
        Response response = new Response();
     
        try {
            List<Kupac> kupci = Controller.getInstance().ucitajKupce();
            response.setResponseType(ResponseType.SUCCESS);
            response.setObject(kupci);
            System.out.println("Uspesna prijava na sistem...");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }
    
    
    
    
}
