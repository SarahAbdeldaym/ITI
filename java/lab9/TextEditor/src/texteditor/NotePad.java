package texteditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javafx.stage.WindowEvent;


public class NotePad extends BorderPane {

    protected final MenuBar menuBar;
    protected final Menu fileMenu;
    protected final MenuItem newMenuItem;
    protected final MenuItem openMenuItem;
    protected final MenuItem saveMenuItem;
     protected final MenuItem saveAsMenuItem;
    protected final MenuItem exitMenuItem;
    protected final Menu editMenu;
    protected final MenuItem undoMenuItem;
    protected final MenuItem cutMenuItem;
    protected final MenuItem copyMenuItem;
    protected final MenuItem pasteMenuItem;
    protected final MenuItem deleteMenuItem;
    protected final MenuItem SelectAllMenuItem;
    protected final Menu helpMenu;
    protected final MenuItem AboutMenuItem;
    protected final TextArea textArea;
    String currentText = null;
    String currentPath = null;
    String noteName = null;
    ObservableList<String> cliboardList = FXCollections.observableArrayList();
    boolean isNew = false;
    
    public NotePad(Stage stage) {
       
        menuBar = new MenuBar();
        fileMenu = new Menu();
        newMenuItem = new MenuItem();
        openMenuItem = new MenuItem();
        saveMenuItem = new MenuItem();
        saveAsMenuItem =new MenuItem();
        exitMenuItem = new MenuItem();
        editMenu = new Menu();
        undoMenuItem = new MenuItem();
        cutMenuItem = new MenuItem();
        copyMenuItem = new MenuItem();
        pasteMenuItem = new MenuItem();
        deleteMenuItem = new MenuItem();
        SelectAllMenuItem = new MenuItem();
        helpMenu = new Menu();
        AboutMenuItem = new MenuItem();
        textArea = new TextArea();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);

        //** file menu
        fileMenu.setMnemonicParsing(false);
        fileMenu.setText("File");

            //new menu ITem
        newMenuItem.setMnemonicParsing(false);
        newMenuItem.setText("new");
        newMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
    
        newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                textArea.clear();
                isNew = true;

            }
        });
        
        //new open item 
        openMenuItem.setMnemonicParsing(false);
        openMenuItem.setText("open");
        openMenuItem.setAccelerator
        (new KeyCodeCombination(KeyCode.P, KeyCombination.CONTROL_DOWN));
    openMenuItem.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select File");
                File selectedFile = fileChooser.showOpenDialog(stage);
                
                if (selectedFile != null) {
                    String path = selectedFile.getPath();
                    currentPath = path;
                    try {
                        FileInputStream fileInputStream = new FileInputStream(path);
                        byte[] text = new byte[fileInputStream.available()];
                        fileInputStream.read(text);
                        textArea.setText(new String(text));
                        currentText = textArea.getText();
                        noteName = selectedFile.getName();
                        stage.setTitle(noteName);
                        fileInputStream.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
                
        //save menu item
        saveMenuItem.setMnemonicParsing(false);
        saveMenuItem.setText("save");
         saveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        saveMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (currentPath == null) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("Save File");
                    File selectedFile = fileChooser.showSaveDialog(stage);
                    if (selectedFile != null) {
                        String path = selectedFile.getPath();
                        currentPath = path;
                        noteName = selectedFile.getName();
                        stage.setTitle(noteName);
                    }
                }
                if (currentPath != null) {
                    try {
                        try (FileOutputStream fileOutputStream = new FileOutputStream(currentPath)) {
                            byte[] text = textArea.getText().getBytes();
                            fileOutputStream.write(text);
                            textArea.setText(new String(text));
                            currentText = textArea.getText();
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        //save as menu item 
           saveAsMenuItem.setMnemonicParsing(false);
        saveAsMenuItem.setText("save As");
        saveAsMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        saveAsMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save File As");
                File selectedFile = fileChooser.showSaveDialog(stage);
                if (selectedFile != null) {
                    String path = selectedFile.getPath();
                    currentPath = path;
                    noteName = selectedFile.getName();
                    stage.setTitle(noteName);
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(currentPath);
                        byte[] text = textArea.getText().getBytes();
                        fileOutputStream.write(text);
                        textArea.setText(new String(text));
                        currentText = textArea.getText();
                        fileOutputStream.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
        //exit menu item
        exitMenuItem.setMnemonicParsing(false);
        exitMenuItem.setText("exit");
         exitMenuItem.setMnemonicParsing(false);
        exitMenuItem.setText("exit");
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        exitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ButtonType save = new ButtonType("Save");//ButtonType.OK;
                ButtonType cancel = new ButtonType("Donot Save");//ButtonType.CANCEL;
                ButtonType close = new ButtonType("Close");//ButtonType.CLOSE;
                String text = textArea.getText();
                if ((text.isEmpty() == true && currentText == null) || text.equals(currentText) == true) {
                    System.exit(0);
                } else {
                    Alert alert = new Alert(AlertType.WARNING, "Do you want to save changes??", save, cancel, close);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == save) {
                        if (currentPath == null) {
                            FileChooser fileChooser = new FileChooser();
                            fileChooser.setTitle("Save File");
                            File selectedFile = fileChooser.showSaveDialog(stage);
                            if (selectedFile != null) {
                                String path = selectedFile.getPath();
                                currentPath = path;
                            }
                        }
                        try {
                            if (currentPath != null) {
                                FileOutputStream fileOutputStream = new FileOutputStream(currentPath);
                                byte[] textArray = textArea.getText().getBytes();
                                fileOutputStream.write(textArray);
                                textArea.setText(new String(textArray));
                                currentText = textArea.getText();
                                fileOutputStream.close();
                            } else {
                                System.err.println("You did not choose file to save\nPlease save the file to close");
                            }
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        if (result.get() == cancel) {
                            //System.exit(0);
                            stage.close();
                        }
                    }
                }

            }
        });

        //** edit menu 
        editMenu.setMnemonicParsing(false);
        editMenu.setText("Edit");

        //undo menu item 
        undoMenuItem.setMnemonicParsing(false);
        undoMenuItem.setText("Undo");

        //cut menu item 
        cutMenuItem.setMnemonicParsing(false);
        cutMenuItem.setText("Cut");
         cutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        cutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                cliboardList.add(textArea.getSelectedText());
                textArea.cut();
            }
        });

        //copy menu item 
        copyMenuItem.setMnemonicParsing(false);
        copyMenuItem.setText("Copy");
        copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        copyMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cliboardList.add(textArea.getSelectedText());
                textArea.copy();
            }
        });
        //paste menu item 
        pasteMenuItem.setMnemonicParsing(false);
        pasteMenuItem.setText("Paste");
          pasteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        pasteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                textArea.paste();
            }
        });
        
        //delete menu item
        deleteMenuItem.setMnemonicParsing(false);
        deleteMenuItem.setText("Delete");
         deleteMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                cliboardList.add(textArea.getSelectedText());
                textArea.deleteText(textArea.getSelection());
            }
        });

        //select all menu item 
        SelectAllMenuItem.setMnemonicParsing(false);
        SelectAllMenuItem.setText("Select All");
        SelectAllMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        SelectAllMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                textArea.selectAll();
            }
        });

        //** help menu
        helpMenu.setMnemonicParsing(false);
        helpMenu.setText("Help");
        

        //about menu item 
        AboutMenuItem.setMnemonicParsing(false);
        AboutMenuItem.setText("About NotePad");
        setTop(menuBar);
        AboutMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.B, KeyCombination.CONTROL_DOWN));
        AboutMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Alert alert = new Alert(AlertType.INFORMATION, "You pressed About Item in Help Menu");
                alert.show();
            }
        });
        //** text area 
        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        setCenter(textArea);
        
       

        fileMenu.getItems().add(newMenuItem);
        fileMenu.getItems().add(openMenuItem);
        fileMenu.getItems().add(saveMenuItem);
         fileMenu.getItems().add(saveAsMenuItem);
        fileMenu.getItems().add(exitMenuItem);
        menuBar.getMenus().add(fileMenu);
        editMenu.getItems().add(undoMenuItem);
        editMenu.getItems().add(cutMenuItem);
        editMenu.getItems().add(copyMenuItem);
        editMenu.getItems().add(pasteMenuItem);
        editMenu.getItems().add(deleteMenuItem);
        editMenu.getItems().add(SelectAllMenuItem);
        menuBar.getMenus().add(editMenu);
        helpMenu.getItems().add(AboutMenuItem);
        menuBar.getMenus().add(helpMenu);
    }


}



