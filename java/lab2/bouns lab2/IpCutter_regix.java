import java.util.regex.*;

class IpCutter{
		
		public static boolean isValidIPAddress(String ip)
		{
		
		String zeroTo255
		= "(\\d{1,2}|(0|1)\\"
		  + "d{2}|2[0-4]\\d|25[0-5])";

		  String regex
            = zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255 + "\\."
              + zeroTo255;
 
			  Pattern p = Pattern.compile(regex);

			  if (ip == null) {
				return false;
			} Matcher m = p.matcher(ip);
 
		
			return m.matches();
		}
		
   
  
	public static void main(String args[])
    {  
		if(args.length > 0 && isValidIPAddress(args[0])=="true" )
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