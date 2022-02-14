class Pattern
{
	public static void main(String[] args)
	{
		String astres1 = "*", astres2 = "*";
		String sapce= "         ";
		String space1, space2;
		for(int i = 0; i < 7; i++)
		{
			space2 = sapce.substring(i);
			space1 = sapce.substring(i);
			System.out.println(astres1 + space1 + space2 + astres2);
			astres1 += "*";
			astres2 += " *";
		}
	}
}