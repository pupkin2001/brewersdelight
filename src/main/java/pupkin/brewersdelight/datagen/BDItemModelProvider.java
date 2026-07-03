package pupkin.brewersdelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;
import pupkin.brewersdelight.BrewersDelight;
import pupkin.brewersdelight.item.BrewersItems;

import java.util.List;

public class BDItemModelProvider extends ItemModelProvider
{
	public BDItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
	{
		super(output, BrewersDelight.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerModels()
	{
		List<DeferredRegister<Item>> registries = List.of(
				BrewersItems.DRINKS,
				BrewersItems.VINTAGE_DRINKS,
				BrewersItems.CHALLENGE_DRINKS
		                                                 );
		
		registries.forEach(this::processRegistry);
	}
	
	private void processRegistry(DeferredRegister<Item> registry)
	{
		registry.getEntries().forEach(item -> {
			assert item.getId() != null;
			String itemName = item.getId().getPath();
			
			if (itemName.endsWith("_glass")) {
				String baseName = itemName.substring(0, itemName.length() - 6); // Remove "_glass"
				withExistingParent(itemName, "farmersdelight:item/mug")
						.texture("layer0", modLoc("item/drink/glass/" + baseName));
			} else {
				withExistingParent(itemName, "farmersdelight:item/mug")
						.texture("layer0", modLoc("item/drink/" + itemName));
			}
		});
	}
}