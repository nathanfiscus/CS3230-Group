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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.*;
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
    private TextField tBox;
    private TextArea txtDisplay;
    private String serverName;
    private String userName;
    private Stage dialog;

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

        getServerAddress();
        getName();
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
            txtDisplay = new TextArea();
            txtDisplay.setFocusTraversable(false);
            txtInput = new TextField();
            txtDisplay.setEditable(false);
            txtInput.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>(){
                @Override
                public void handle(KeyEvent e) {
                    if(e.getCharacter().equals("\r")) {
                        out.println(txtInput.getText());
                        txtInput.setText("");
                    }
                }
            });

            rootPane.getChildren().addAll(txtInput, txtDisplay);
            txtInput.requestFocus();


        }

        return rootPane;
    }

        private void getServerAddress() {

            dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(this.primaryStage);
            VBox dialogVbox = new VBox(20);
            tBox = new TextField();
            tBox.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent e) {
                            if (e.getCharacter().equals("\r")) {
                                serverName = tBox.getText();
                                dialog.close();
                            }
                        }
                    });
            dialogVbox.getChildren().addAll(new Text("Enter IP Address of Server:"), tBox);
            Scene dialogScene = new Scene(dialogVbox, 200, 100);
            dialog.setScene(dialogScene);
            dialog.showAndWait();

        }

        private void getName() {

            dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(this.primaryStage);
            VBox dialogVbox = new VBox(20);
            tBox = new TextField();
            tBox.addEventHandler(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent e) {
                    if (e.getCharacter().equals("\r")) {
                        userName = tBox.getText();
                        dialog.close();
                    }
                }
            });
            dialogVbox.getChildren().addAll(new Text("Choose a screen name:"), tBox);
            Scene dialogScene = new Scene(dialogVbox, 200, 100);
            dialog.setScene(dialogScene);
            dialog.showAndWait();

        }

        private Task run(){
            return new Task<Integer>() {
                protected Integer call()
                        throws IOException {
                    Socket socket = new Socket(serverName, 9001);
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
                            out.println(userName);
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
