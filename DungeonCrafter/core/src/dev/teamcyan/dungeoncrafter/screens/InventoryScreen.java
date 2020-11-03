package dev.teamcyan.dungeoncrafter.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.kotcrab.vis.ui.widget.*;
import dev.teamcyan.dungeoncrafter.DungeonCrafter;
import dev.teamcyan.dungeoncrafter.classes.GameModel;

public class InventoryScreen extends BaseScreen{
    private VisList<String> lstItems;
    private VisImage imgItem;
    private VisTextArea txtDescription;
    private VisTextButton btnBack;

    public InventoryScreen(DungeonCrafter parent, GameModel model) {
        super(parent, model);


        // Initialize the image
        imgItem = new VisImage();
        imgItem.setSize(ui.getWidth() / 2, ui.getWidth() / 2); // TODO: Refactor to world size.

        // Create the item list
        lstItems = new VisList<>();
        lstItems.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                updateSelection(lstItems.getSelected());
            }
        });

        // Create the description field
        txtDescription = new VisTextArea();
        txtDescription.setDisabled(true);

        // Add a "back" button
        //btnBack = makeNavButton("Back", StationScreen.class);

        // Create the layout
        VisTable tblLayout = new VisTable();
        tblLayout.columnDefaults(0).pad(10f);
        tblLayout.columnDefaults(1).pad(10f);
        tblLayout.setFillParent(true);
        tblLayout.add(imgItem).size(ui.getWidth() / 2);
        tblLayout.add(new VisScrollPane(lstItems)).fillY();
        tblLayout.row();
        tblLayout.add(txtDescription).size(ui.getWidth() / 2, 100.0f);
        tblLayout.add(btnBack).expandX().fillX();

        ui.addActor(tblLayout);
    }

    @Override
    public void init() {
        // Refresh the player data
        //Array<String> items = new Array<>();
        String[] items = {};
        model.getPlayer();//.getInventory().forEach(i -> items.add(new ItemEntry(i.key, i.value)));
        //items.sort(new ItemEntry.ItemEntryComparator());
        lstItems.setItems(items);
        updateSelection(lstItems.getSelected());
    }

    public void pause() {

    }
    public void resume() {

    }

    /**
     * Flush all stateful data.
     */
    @Override
    public void hide() {
        //super.hide();
        lstItems.clear();
        updateSelection(lstItems.getSelected());
    }

    private void updateSelection(String selected) {
        imgItem.setDrawable(controller.getManagedTexture(selected));
        txtDescription.setText(selected);
    }
}
