 class Complex 
{
    private int real;
    private int imeg;
 
    public void  setReal(int r) {
            real=r;        
    }
    public void  setImeg(int i) {
        imeg=i;        
    }

    public int getreal() {
        return real;   
    }
    
    public int getimeg() {
        return imeg;   
    }

    public Complex add(Complex c1) {
        Complex temp= new Complex();
        temp.real = real + c1.real;
        temp.imeg = imeg + c1.imeg;
        return temp;
    }
    public Complex substract(Complex c1) {
        Complex temp = new Complex();;
        temp.real = real - c1.real;
        temp.imeg = imeg - c1.imeg;
        return temp;
    }

    public static void main(String args[])
{
   Complex cpl1 =new Complex();
   Complex cpl2 = new Complex ();
   Complex cpl3 = new Complex ();
   Complex cpl4 = new Complex ();
   cpl1.setReal(1);
   cpl1.setImeg(2);
   cpl2.setReal(3);
   cpl2.setImeg(4);
   
   cpl3= cpl1.add(cpl2);
   System.out.println(cpl3.getreal()+" " +cpl3.getimeg() );

   cpl4= cpl1.substract(cpl2);
   System.out.println(cpl4.getreal()+" " +cpl4.getimeg() );
}
}


