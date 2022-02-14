import java.util.*;
class IpCutter{
    public static void main(String[] args){
       if(args.length > 0)
       {
        String ip = args[0]; 
        String parts[] = ip.split("\\.");
        for(String part: parts) {
            System.out.println(part);
        }  
        
        
    }
    else{System.out.println("PLEASE ENTER IP NUMBER");}

    }
}
    