package vue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.layout.TilePane;

public class AllPlayersTP extends TilePane{
	
	private final int NB_PLAYER_MAX = 8;
	private List<PlayersAP> nodes;
	
	public AllPlayersTP(){
		this.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		this.getStyleClass().add("addpane");
		this.getChildren().addAll(getNodes());
		this.setOrientation(Orientation.);
	}
	
	public List<PlayersAP> getNodes(){
		
		if(nodes== null) {
			nodes = new ArrayList<>();
			for(int i = 0; i< NB_PLAYER_MAX; i++) {
				nodes.add(new PlayersAP());
				nodes.get(i).setTxtPlayer(i+1);
			}
		}
		return nodes;
	}
}
