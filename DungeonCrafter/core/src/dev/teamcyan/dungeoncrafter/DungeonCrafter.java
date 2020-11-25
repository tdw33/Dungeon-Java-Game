package dev.teamcyan.dungeoncrafter;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;
import com.kotcrab.vis.ui.VisUI;
import dev.teamcyan.dungeoncrafter.classes.GameModel;
import dev.teamcyan.dungeoncrafter.screens.*;
import dev.teamcyan.dungeoncrafter.classes.AudioManager;
import dev.teamcyan.dungeoncrafter.classes.KeyListener;


public class DungeonCrafter extends Game {

	private AssetManager assetManager;

	public static final int WIDTH = 720;
	public static final int HEIGHT = 720;
	public static final float ZOOM_FACTOR = 0.1f;
	public float totTime;

	public SpriteBatch batch;
	public AudioManager audioManager;
	public KeyListener keyListener;

	private GameModel model;
	private boolean debugMode = true;
	private ObjectMap<Class<? extends BaseScreen>, BaseScreen> screens = new ObjectMap<>();



   public void init_asset_manager()
   {
     /** 
      * Init asset manager 
      */
		assetManager = new AssetManager();
		assetManager.load("spritesheets/sprites.atlas", TextureAtlas.class);
		assetManager.finishLoading();
   }

	@Override
	public void create () 
   {
		this.setDebugOn(false);
		this.model = new GameModel();
		VisUI.load();
      
	   // Initialise the audio manager
	   audioManager = new AudioManager();

	   // Initialise the key listener
	   keyListener = new KeyListener();
	   init_asset_manager();
	   loadScreens();
	   newGame();
	}

	@Override
	public void dispose () 
   {
		setScreen(null); // Dispose of the view
		for (ObjectMap.Entry<Class<? extends BaseScreen>,BaseScreen> var : screens)
		{
			var.value.dispose();
		}
		screens.clear();
		if(VisUI.isLoaded()) VisUI.dispose();

		// Dispose of the model
		model.dispose();
	}

	/**
    * Convenience method to safely load textures. If the texture isn't found, a
    * blank one is created and the error is logged.
	 * @param textureName The name of the image that is being looked up.
	 * @return
	 */

	public TextureAtlas.AtlasRegion getAtlasRegion(String textureName) {
		try 
      {
			return assetManager.get("spritesheets/sprites.atlas", TextureAtlas.class)
           .findRegion(textureName);
		} 
      catch(Exception e) 
      {
			Gdx.app.error(
             getClass()
             .getCanonicalName(), "Couldn't get managed texture.", e);
			return getEmptyAtlasRegion();
		}
	}

	public TextureAtlas.AtlasRegion getEmptyAtlasRegion() {
		return new TextureAtlas
        .AtlasRegion(
            new TextureRegion(
              new Texture(
                new Pixmap(1,1, Pixmap.Format.RGBA8888))));
	}

	//	  Create a new game, starting with the story screen
	public void newGame() {
		model.startNewGame(this);
		this.changeScreen(MainMenuScreen.class);
	}

	// === Debug Logic === //
	public boolean isDebugOn() {
		return debugMode;
	}

	public DungeonCrafter setDebugOn(boolean on) {
		this.debugMode = on;
		Gdx.app.setLogLevel(on ? Application.LOG_DEBUG : Application.LOG_INFO);
		return this;
	}

	// Screen Management
	public void changeScreen(Class<? extends BaseScreen> key) {
		this.setScreen(screens.get(key));
		//handle(new GameEvent("SCREEN_CHANGE").set("SCREEN", screens.get(key)));
		if(key.getName() != "dev.teamcyan.dungeoncrafter.screens.MainMenuScreen") {
			audioManager.fadeMusic(audioManager.menuSound);
		}
	}

	public void loadScreens() {
		screens.put(InventoryScreen.class, new InventoryScreen(this, model));
		screens.put(MainGameScreen.class, new MainGameScreen(this, model));
		screens.put(MainMenuScreen.class, new MainMenuScreen(this, model));
		screens.put(SettingsScreen.class, new SettingsScreen(this, model));
		screens.put(DifficultyScreen.class, new DifficultyScreen(this, model));
	}

	public void restartGame() {
		this.screens = new ObjectMap<>();
		loadScreens();
		model.startNewGame(this);
		this.changeScreen(DifficultyScreen.class);
	}

	public GameModel getModel() {
		return this.model;
	}
	/*@Override
	public void render () {
		super.render();
	}*/

}
