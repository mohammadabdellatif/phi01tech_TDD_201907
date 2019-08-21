package com.phi01tech.um.ws;

import com.phi01tech.um.handlers.AddUserHandler;
import com.phi01tech.um.UserRepository;
import com.phi01tech.um.handlers.DefaultAddUserHandler;
import com.phi01tech.um.repo.CSVUserRepository;
import com.phi01tech.um.utils.PasswordGenerator;
import com.phi01tech.um.utils.UUIDPasswordGenerator;

import javax.xml.ws.Endpoint;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

public class WSMain {

    public static void main(String[] args) {
        UserRepository repository = new CSVUserRepository(Paths.get("./users.csv"));
        PasswordGenerator generator = new UUIDPasswordGenerator();
        AddUserHandler handler = new DefaultAddUserHandler(repository, generator);
        // Decorator design pattern
        AddUserHandlerTrack track = new AddUserHandlerTrack(handler);
        DefaultUserManagementWebService webService = new DefaultUserManagementWebService(track);
        Endpoint.publish("http://localhost:7071/um.webservice", webService);
        System.out.println("started");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("S: " + track.getSuccess() + ", F: " + track.getFailed());
            }
        }, 1000, 3000);
    }
}
