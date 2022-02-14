import java.util.zip.InflaterOutputStream;

import java.util.stream.IntStream;
public class StreamAPI {
public static void main(String[] args){
int[] values = {3,10,6,1,4,8,2,5,9,7};
System.out.println("Original values ");
    IntStream.of(values).forEach(value->System.out.printf("%d ",value));
    System.out.println();
    IntStream.of(values).filter(value ->value % 2== 0).sorted().forEach(value->System.out.printf("%d ",value));
    System.out.println();
    
}
    
}
