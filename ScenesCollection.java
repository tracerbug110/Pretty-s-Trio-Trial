import java.math.BigInteger;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ScenesCollection 
{
	private Stage mainStage;
	private Utilities util;
	private ArrayList<Integer> dice;
	private Label rollCounter;
	private BigInteger rollCount = BigInteger.valueOf(0);
	private Button rollButton;
	private Button addDie;
	
	ScenesCollection(Stage s)
	{
		mainStage = s;
		util = new Utilities();
	}
	
	public Scene mainScene()
	{
		Label title = new Label("Pretty\'s Trio Trial");
		title.setAlignment(Pos.TOP_CENTER);
		title = setLabelStyle(title);
		
		Button startGame = new Button("Start Rolling!");
		startGame.setAlignment(Pos.CENTER);
		startGame.setOnAction(e -> { mainStage.setScene(gameScene()); });
		startGame = setButtonStyle(startGame);
		
		VBox sceneContainer = new VBox(title, startGame);
		sceneContainer.setAlignment(Pos.CENTER);
		sceneContainer.setPadding(new Insets(5));
		sceneContainer.setSpacing(25);
		sceneContainer.setStyle(getSceneStyle());
		
		Scene mainScene = new Scene(sceneContainer, 300, 300);
		return mainScene;
	}
	
	public Scene gameScene()
	{
		rollCount = BigInteger.ZERO;
		dice = new ArrayList<>();
		dice.add(1);
		
		Label instructions = new Label("Get all 3\'s!");
		instructions = setLabelStyle(instructions);
		instructions.setAlignment(Pos.TOP_CENTER);
		
		rollCounter = new Label("Rolls: " + rollCount.toString());
		rollCounter = setLabelStyle(rollCounter);
		
		VBox topContainer = new VBox(instructions, rollCounter);
		topContainer.setSpacing(5);
		topContainer.setAlignment(Pos.TOP_CENTER);
		
		GridPane diceGrid = new GridPane(5, 5);
		diceGrid.setAlignment(Pos.CENTER);

		rollButton = new Button("Roll!");
		rollButton.setOnAction(e -> 
		{ 
			ObservableList<Node> images = diceGrid.getChildren();
			
			rollCount = rollCount.add(BigInteger.ONE);
			rollCounter.setText("Rolls: " + rollCount.toString());
			dice = util.rollDice(dice);
			for(int i = 0 ; i < dice.size() - 1; i++)
			{
				((ImageView)images.get(i)).setImage(new Image(util.getDieImage(dice.get(i))));
			}
			if(util.isAllThrees(dice))
			{
				addDie.setDisable(false);
				addDie = setButtonStyle(addDie);
				rollButton.setDisable(true);
				rollButton = setDisabledButtonStyle(rollButton);
				if(dice.size() == 25)
				{
					addDie.setText("Win!");
				}
			}
		});
		rollButton = setButtonStyle(rollButton);
		
		addDie = new Button("Add Die!");
		addDie.setOnAction(e -> 
		{
			if(dice.size() <= 25)
			{
				dice.add(1);
				
				ImageView die = new ImageView(util.getDieImage(dice.get(dice.size() - 1)));
				
				GridPane.setConstraints(die, (dice.size() - 2) % 5, (dice.size() - 2) / 5);
				diceGrid.getChildren().add(die);
				
				addDie.setDisable(true);
				addDie = setDisabledButtonStyle(addDie);
				rollButton.setDisable(false);
				rollButton = setButtonStyle(rollButton);
			}
			else
			{
				mainStage.setScene(winScene());
			}
		});
		addDie = setButtonStyle(addDie);
		addDie.fire();
		
		HBox bottomContainer = new HBox(rollButton, addDie);
		bottomContainer.setSpacing(5);
		bottomContainer.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox sceneContainer = new VBox(topContainer, diceGrid, bottomContainer);
		sceneContainer.setStyle(getSceneStyle());
		sceneContainer.setAlignment(Pos.CENTER);
		
		Scene testScene = new Scene(sceneContainer, 500, 500);
		return testScene;
	}
	
	public Scene winScene()
	{
		Label winMessage = new Label("Congradulations!\nYou Win!");
		winMessage = setLabelStyle(winMessage);
		winMessage.setTextAlignment(TextAlignment.CENTER);
		
		ImageView die = new ImageView(util.getDieImage(3));
		
		Label joke = new Label("Now, go touch some grass.");
		joke = setLabelStyle(joke);
		
		Button menu = new Button("Return to Menu");
		menu.setOnAction(e -> { mainStage.setScene(mainScene()); });
		menu = setButtonStyle(menu);
		
		VBox sceneContainer = new VBox(winMessage, die, joke, menu);
		sceneContainer.setPadding(new Insets(5));
		sceneContainer.setSpacing(20);
		sceneContainer.setAlignment(Pos.CENTER);
		sceneContainer.setStyle(getSceneStyle());
		
		Scene winScene = new Scene(sceneContainer, 350, 350);
		return winScene;
	}
	
	public String getSceneStyle()
	{
		return "-fx-background-color: #5203fc; -fx-border-width: 5px; -fx-border-color: cyan;";
	}
	
	public Label setLabelStyle(Label l)
	{
		Label stylizedLabel = l;
		stylizedLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		stylizedLabel.setTextFill(Color.CYAN);
		return stylizedLabel;
	}
	
	public Button setButtonStyle(Button b)
	{
		Button stylizedButton = b;
		
		stylizedButton.setBackground(null);
		stylizedButton.setTextFill(Color.CYAN);
		stylizedButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		stylizedButton.setUnderline(true);
		stylizedButton.setOnMouseEntered(e -> { stylizedButton.setTextFill(Color.MAGENTA); });
		stylizedButton.setOnMouseExited(e -> { stylizedButton.setTextFill(Color.CYAN); });
		return stylizedButton;
	}
	
	public Button setDisabledButtonStyle(Button b)
	{
		Button stylizedButton = b;
		
		stylizedButton.setBackground(null);
		stylizedButton.setTextFill(Color.BLACK);
		stylizedButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		stylizedButton.setUnderline(true);
		stylizedButton.setOnMouseEntered(null);
		stylizedButton.setOnMouseExited(null);
		return stylizedButton;
	}
}
