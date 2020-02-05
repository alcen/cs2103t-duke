package bot.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Pos;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

import java.io.IOException;

public class ChatBox extends HBox {
    private static Image USER_IMAGE;
    private static Image BOT_IMAGE;

    @FXML
    private Text text;
    @FXML
    private ImageView displayPicture;

    /**
     * Constructor for a custom HBox, for use
     * in 4LC3N-BOT's GUI
     *
     * @param text String representing text to be
     *             shown in the ChatBox
     * @param img Image of the user who would
     *            generate the text
     */
    public ChatBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    MainWindow.class.getResource("/view/ChatBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // give this ChatBox its text and image
        this.text.setText(text);
        this.displayPicture.setImage(img);
    }

    /**
     * Moves this ChatBox to the left instead
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    /**
     * Formats this ChatBox to the right. To be used
     * for user input
     *
     * @param s The string containing dialogue text
     * @return A new ChatBox, formatted to the right
     */
    public static ChatBox getUserBox(String s) {
        return new ChatBox(s, ChatBox.USER_IMAGE);
    }

    /**
     * Formats this ChatBox to the left. To be used
     * for bot output
     *
     * @param s The String containing dialogue text
     * @return A new ChatBox, formatted to the left
     */
    public static ChatBox getBotBox(String s) {
        ChatBox chat = new ChatBox(s, ChatBox.BOT_IMAGE);
        chat.flip();
        return chat;
    }

    /**
     * Sets the user's image for all ChatBoxes
     * @param img The image to be set as the
     *           user image
     */
    public static void setUserImage(Image img) {
        ChatBox.USER_IMAGE = img;
    }

    /**
     * Sets the bot's image for all ChatBoxes
     * @param img The image to be set as the
     *           bot image
     */
    public static void setBotImage(Image img) {
        ChatBox.BOT_IMAGE = img;
    }
}