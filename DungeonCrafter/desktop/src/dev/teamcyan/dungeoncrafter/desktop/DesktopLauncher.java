package dev.teamcyan.dungeoncrafter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();


		config.title = "Dungeon Crafter";
		config.width = DungeonCrafter.WIDTH;
		config.height = DungeonCrafter.HEIGHT;
		config.resizable = true;

		config.foregroundFPS = 60; //fps for when game is being played


		//Pack all textures into texture atlas
		//TODO: remove code before release and just release game with pre packed atlas

		TexturePacker.Settings sets = new TexturePacker.Settings();
		sets.pot =true; // sets size of images
		sets.fast = true; // good for dev make texture packer run faster but can be changed to false before release
		sets.combineSubdirectories = true;
		sets.paddingX = 1; //space out images in atlas to help with texture bleeding
		sets.paddingY = 1;
		sets.edgePadding = true;
		//TexturePacker.process(sets, "raw_textures", "./", "textures"); //pack the textures



		new LwjglApplication(new DungeonCrafter(), config);
	}
}
