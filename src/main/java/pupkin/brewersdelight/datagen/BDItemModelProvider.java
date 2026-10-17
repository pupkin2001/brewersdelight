package pupkin.brewersdelight.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredRegister;
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
		List<DeferredRegister.Items> registries = List.of(
				BrewersItems.DRINKS,
				BrewersItems.VINTAGE_DRINKS,
				BrewersItems.CHALLENGE_DRINKS
		                                                 );
		
		registries.forEach(this::processRegistry);
	}
	
	private void processRegistry(DeferredRegister.Items registry)
	{
		registry.getEntries().forEach(item -> {
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