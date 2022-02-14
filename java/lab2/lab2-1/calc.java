class Calc {

    public static void main(String[] args){
        if(args.length == 3) //because the lenth in the arg will only be 3 
        {
            String num1 = args[0];
            String mainOperator = args[1];
            String num2 = args[2];

            double result = 0;
            
            double first_num= Double.parseDouble(num1);
			double second_num= Double.parseDouble(num2);
                    switch(mainOperator){
                        case "+" :
                        result = first_num + second_num ;
                        System.out.println("result = " + result );
                        break;

                        case "-" :
                        result = first_num - second_num ;
                        System.out.println("result = " + result);
                        break;

                        case "x" : 
                        result = first_num * second_num ;
                        System.out.println("result = " + result);
                        break;

                        case "/" : 
                        if (second_num == 0)
                        {System.out.println("Undefined Value");}
                        else
                        {result= first_num/second_num;
                        System.out.println("result = " + result);}
                        break;

                    }
                }
                else{
                    System.out.println("please enter 2 numbers");
                }

        }
    }
