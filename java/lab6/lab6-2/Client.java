import java.net.*;
import java.io.*;
import java.util.Vector;


public class Client{
    Socket mySocket;
    BufferedReader dis ;
    PrintStream ps;
    public static void main(String[] args) throws Exception{
        new Client();
    }
    public Client(){
        try{
            mySocket = new Socket(InetAddress.getLocalHost(), 5005);
            dis = new BufferedReader(new InputStreamReader(mySocket.getInputStream ()));
            ps = new PrintStream(mySocket.getOutputStream ());
            ps.println("Test Test");
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        try{
            ps.close();
            dis.close();
            mySocket.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}