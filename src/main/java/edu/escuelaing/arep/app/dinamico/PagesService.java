package edu.escuelaing.arep.app.dinamico;

import java.io.IOException;
import java.nio.file.*;
public class PagesService implements RESTService{

    public static PagesService instance;

    private PagesService(){}

    public static PagesService getInstance(){
        if(instance == null){
            instance = new PagesService();
        }
        return instance;
    }

    @Override
    public String getHeader(String type) {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/"+type+"\r\n" +
                "\r\n";
    }

    @Override
    public String getResponse(String path) {
        byte[] fileContent;
        try {
            fileContent = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String(fileContent);
    }
}
