public class StarsPattern
{
    public static void main(String[] args)
    {
        int i,j,k,rowsNumber;
        rowsNumber = Integer.parseInt(args[0]);
        for(i=1;i<=rowsNumber;i++)
        {

            for(j=1; j<=i; j++)
            {
                System.out.print("*");
            }
            
            for (k=0; k <= rowsNumber-i ; k++)
            {
                System.out.print(" ");
            }
            
            for (j=i; j<=rowsNumber ; j++)
            {
                System.out.print(" ");
            }

            for (j=1; j <= i; j++)
            {
                System.out.print("* ");
            }

        System.out.print("\n");

        }
    }
}