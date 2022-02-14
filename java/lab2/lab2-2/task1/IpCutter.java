class IpCutter{
public static void main(String[] args){
    if(args.length > 0)
    {
        String ip = args[0];
        int start = 0, end = 0;
        while(ip.indexOf('.', start) != -1){
                end = ip.indexOf('.', start);
                System.out.println(ip.substring(start, end));
                start = ip.indexOf('.', start)+1;
        }
        System.out.println(ip.substring(start));
    }
    else 
    {
        System.out.println("please enter an input!");
    }
    
}
}