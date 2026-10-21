package pupkin.brewersdelight.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;
import pupkin.brewersdelight.BrewersDelight;

import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

public class BDFluidDisplayProvider implements DataProvider
{
	private static final String MOD_ID = BrewersDelight.MOD_ID;
	private static final String OUTPUT_PATH =
			MOD_ID + "/brewinandchewin/fluid_item_displays/brewers_displays.json";
	private static final Map<String, Display> OVERRIDES = Map.of(
			"melon_juice", new Display("farmersdelight:melon_juice", false),
			"froststone_cheese", new Display(MOD_ID + ":unripe_froststone_cheese_wheel", false)
	                                                            );
	// Source fluids that should get NO display entry (BnC then falls back to the fluid's pouring recipe output)
	private static final Set<String> EXCLUDE = Set.of(
			"wine", "red_wine", "white_wine"
	                                                 );
	private final PackOutput output;
	
	public BDFluidDisplayProvider(PackOutput output) { this.output = output; }
	
	private static JsonElement serialize(Display d)
	{
		if (!d.optional()) return new JsonPrimitive(d.item());
		JsonObject o = new JsonObject();
		o.addProperty("id", d.item());
		o.addProperty("optional", true);
		return o;
	}
	
	@Override
	public @NotNull CompletableFuture<?> run(@NotNull CachedOutput cache)
	{
		// TreeMap → alphabetical, stable diffs
		Map<String, JsonElement> entries = new TreeMap<>();
		
		for (Fluid fluid : BuiltInRegistries.FLUID) {
			ResourceLocation id = BuiltInRegistries.FLUID.getKey(fluid);
			if (!MOD_ID.equals(id.getNamespace())) continue; // only our fluids
			if (!fluid.isSource(fluid.defaultFluidState())) continue; // skip flowing variants
			String path = id.getPath();
			if (EXCLUDE.contains(path)) continue;
			
			Display d = OVERRIDES.getOrDefault(path, new Display(MOD_ID + ":" + path, false));
			entries.put(MOD_ID + ":" + path, serialize(d));
		}
		
		JsonObject root = new JsonObject();
		entries.forEach(root::add);
		
		Path target = output.getOutputFolder(PackOutput.Target.RESOURCE_PACK).resolve(OUTPUT_PATH);
		return DataProvider.saveStable(cache, root, target);
	}
	
	@Override
	public @NotNull String getName() { return "Brewers Delight fluid item displays"; }
	
	// Fluids whose display item ISN'T the same-named drink item.
	// optional=true → emits {id, optional:true} for compat targets that may be absent.
	private record Display(String item, boolean optional) {}
}