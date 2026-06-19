package pupkin.brewersdelight.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;

public class BrewersTags
{
	public static final TagKey<Item>
			VINTAGE_DRINKS = modItemTag("vintage_drinks"),
			CHALLENGE_DRINKS = modItemTag("challenge_drinks");
	
	private static @NotNull TagKey<Item> modItemTag(String path)
	{
		return ItemTags.create(new ResourceLocation(BrewersDelight.MOD_ID, path));
	}
}
