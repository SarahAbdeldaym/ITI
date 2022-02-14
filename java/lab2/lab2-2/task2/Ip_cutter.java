import java.util.*;

class IpCutter{
    public static void main(String[] args){
        if(args.length > 0)
        {
            StringTokenizer ip = new StringTokenizer(args[0], ".");
            while (ip.hasMoreTokens())
            {
            System.out.println(ip.nextToken());
            } 
        }
        else 
        {
            System.out.println("please enter an input!");
        }
        
    }
    }