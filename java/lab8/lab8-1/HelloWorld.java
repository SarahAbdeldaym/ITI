import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application{
public static void main(String[] args) {
    launch(args);
}

public void start(Stage primaryStage){
    StackPane root = new StackPane();
    Scene scene = new Scene(root ,400,400);
    scene.getStylesheets().add(getClass().getResource("HelloWorld.css").toString());


    Rectangle rec = new Rectangle(0,0,400,400);
    rec.setId("rectangle");
    root.getChildren().add(rec);
    
    Text txt = new Text("Hello World");
    txt.setId("text");
    root.getChildren().add(txt);    

    Text reflectedText = new Text("Hello World");
    reflectedText.setId("reflectedText");
    root.getChildren().add(reflectedText);    

    primaryStage.setScene(scene);
    primaryStage.show();
    
}

}