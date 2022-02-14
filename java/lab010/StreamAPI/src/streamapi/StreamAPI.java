/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamapi;
import java.util.zip.InflaterOutputStream;

import java.util.stream.IntStream;
/**
 *
 * @author sarah
 */
public class StreamAPI {

    /**
     * @param args the command line arguments
     */
  
public static void main(String[] args){
int[] values = {1,10,15,16,45,58,7,8,12};
System.out.println("Original values ");
    IntStream.of(values).forEach(value->System.out.printf("%d ",value));
    System.out.println();
    IntStream.of(values).filter(value ->value % 2  0).sorted().forEach(value->System.out.printf("%d ",value));
    System.out.println();
    
}
    
}
    

