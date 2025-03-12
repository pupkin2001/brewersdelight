package pupkin.brewersdelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BrewersDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        BrewersItems.BEVERAGES.getEntries().forEach(item -> {
            String itemName = item.getId().getPath();

            withExistingParent(itemName, "farmersdelight:item/mug").texture("layer0", modLoc("item/" + itemName));
        });

        BrewersItems.CHALLENGE_BEVERAGES.getEntries().forEach(item -> {
            String itemName = item.getId().getPath();

            withExistingParent(itemName, "farmersdelight:item/mug").texture("layer0", modLoc("item/" + itemName));
        });

        BrewersItems.VINTAGE_BEVERAGES.getEntries().forEach(item -> {
            String itemName = item.getId().getPath();

            withExistingParent(itemName, "farmersdelight:item/mug").texture("layer0", modLoc("item/" + itemName));
        });

        BrewersItems.COMPAT_BEVERAGES.getEntries().forEach(item -> {
            String itemName = item.getId().getPath();

            withExistingParent(itemName, "farmersdelight:item/mug").texture("layer0", modLoc("item/" + itemName));
        });
    }
}