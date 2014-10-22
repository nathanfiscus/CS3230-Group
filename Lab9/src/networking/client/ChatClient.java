package networking.client;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ChatClient extends Application {

    private BufferedReader serverReceiver;
    private PrintWriter out;
    private Stage primaryStage;
    private Scene primaryScene;
    private Pane rootPane;
    private TextField txtInput;
    private TextArea txtDisplay;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chat Window");
        getPrimaryScene().widthProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
                txtDisplay.setPrefSize(rootPane.getWidth(),rootPane.getHeight() - txtInput.getHeight());
                txtInput.setTranslateY(txtDisplay.getHeight());
                txtInput.setPrefWidth(rootPane.getWidth());
                System.out.println("Width: " + newSceneWidth);
            }
        });
        getPrimaryScene().heightProperty().addListener(new ChangeListener<Number>() {
            @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
                txtDisplay.setPrefSize(rootPane.getWidth(),rootPane.getHeight() - txtInput.getHeight()-5);
                txtInput.setTranslateY(txtDisplay.getHeight()+5);
                txtInput.setPrefWidth(rootPane.getWidth());
            }
        });
        this.primaryStage.setScene(getPrimaryScene());

        txtDisplay.setPrefSize(400,350);
        txtInput.setTranslateY(355);
        txtInput.setPrefWidth(400);

        this.primaryStage.show();
        Thread th = new Thread(run());
        th.start();

    }

    public Scene getPrimaryScene(){
        if(primaryScene == null){
            primaryScene = new Scene(getRootPane(),400,400,true, SceneAntialiasing.BALANCED);
        }
        return primaryScene;
    }

    private Pane getRootPane() {

        if(null == rootPane) {
            rootPane = new Pane();
            rootPane.setId("rootPanel");
            txtInput = new TextField();
            txtDisplay = new TextArea();
            txtInput.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent e) {
                    if(e.getCharacter().equals("\r")) {
                        out.println(txtInput.getText());
                        txtInput.setText("");
                    }
                }
            });
            txtDisplay.appendText("tst");
            rootPane.getChildren().addAll(txtDisplay,txtInput);


        }

        return rootPane;
    }

        private String getServerAddress() {
            return JOptionPane.showInputDialog(new Frame(),
                    "Enter IP Address of Server",
                    "Welcome to the Chatter",
                    JOptionPane.QUESTION_MESSAGE);
        }

        private String getName() {
            return JOptionPane.showInputDialog(
                    new Frame(),
                    "Choose a screen name:",
                    "Screen name selection",
                    JOptionPane.PLAIN_MESSAGE);
        }

        private Task run(){
            return new Task<Integer>() {
                protected Integer call()
                        throws IOException {
                    String serverAddress = getServerAddress();
                    Socket socket = new Socket(serverAddress, 9001);
                    serverReceiver = new

                            BufferedReader(new InputStreamReader(socket.getInputStream()

                    ));
                    out = new

                            PrintWriter(socket.getOutputStream(),

                            true);

                    while (true)

                    {
                        System.out.println("waiting for server");
                        final String line = serverReceiver.readLine();
                        System.out.println("response received");
                        if (line.startsWith("SUBMITNAME")) {
                            out.println(getName());
                        } else if (line.startsWith("NAMEACCEPTED")) {
                            txtInput.setEditable(true);
                        } else if (line.startsWith("MESSAGE")) {
                            System.out.println("Message received");
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    txtDisplay.appendText(line.substring(8) + "\n");
                                }
                            });
                        }

                    }
                }
            };
        }


}
