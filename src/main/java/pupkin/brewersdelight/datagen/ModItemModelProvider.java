package pupkin.brewersdelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.MyMod;
import pupkin.brewersdelight.item.BrewersItems;

public class ModItemModelProvider extends ItemModelProvider
{
	public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
	{
		super(output, BrewersDelight.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerModels()
	{
		MyMod.ITEM_REGISTRY.getEntries().forEach(item -> {
			String itemName = item.getId().getPath();
			
			withExistingParent(itemName, "brewinandchewin:item/tankard").texture("layer0", modLoc("item/" + itemName));
		});
	}
}