import java.io.*;
import java.net.Socket;

public class GreetingClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try{
            System.out.println("connect to server " + serverName + " port: "+ port);
            Socket client = new Socket(serverName, port);
            System.out.println("remote server address " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("hello from "+ client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("server response" + in.readUTF());
            client.close();


        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
