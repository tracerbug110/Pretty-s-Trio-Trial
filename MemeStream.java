import javafx.application.Application;
import javafx.stage.Stage;

public class MemeStream extends Application
{
	private ScenesCollection scenes;
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage mainStage) throws Exception 
	{	
		scenes = new ScenesCollection(mainStage);
		mainStage.setScene(scenes.mainScene());
		mainStage.setTitle("Pretty\'s Trio Trial");
		mainStage.setResizable(false);
		mainStage.show();
	}
}
