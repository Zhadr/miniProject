package my.project;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ManyCl extends Thread{
    private Socket socket;

    public ManyCl(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            PackageData md = null;

            while((md=(PackageData) inputStream.readObject())!=null){
                System.out.println(md.toString());
            }

            inputStream.close();
            outputStream.close();
            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
