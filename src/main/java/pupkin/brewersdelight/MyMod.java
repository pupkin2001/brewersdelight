package pupkin.brewersdelight;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import pupkin.brewersdelight.item.ModBoozeItem;
import umpaz.brewinandchewin.common.registry.BCItems;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class MyMod
{
	public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BrewersDelight.MOD_ID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BrewersDelight.MOD_ID);
	@SuppressWarnings("unused")
	public static final RegistryObject<CreativeModeTab> CUSTOM_CREATIVE_TAB = CREATIVE_TAB_REGISTRY.register("custom_tab",
	                                                                                                         () -> CreativeModeTab.builder()
	                                                                                                                              .title(Component.translatable(
			                                                                                                                              "itemgroup."
					                                                                                                                              + BrewersDelight.MOD_ID
					                                                                                                                              + ".custom_tab"))
	                                                                                                                              .icon(() -> new ItemStack(
			                                                                                                                              Items.DIRT))
	                                                                                                                              .displayItems(
			                                                                                                                              (displayParameters, output) -> ITEM_REGISTRY
					                                                                                                                              .getEntries()
					                                                                                                                              .forEach(
							                                                                                                                              item -> output.accept(
									                                                                                                                              item.get())))
	                                                                                                                              .build());
	public static final Path CONFIG_FILE_PATH = FMLPaths.CONFIGDIR.get().resolve("custom_items.json");
	public static final FoodProperties.Builder foodPropertiesBuilder = new FoodProperties.Builder().alwaysEat();
	static final Map<String, JsonArray> itemEffectsMap = new HashMap<>();
	private static final Logger LOGGER = LogUtils.getLogger();
	private static final List<String> registeredItemIds = Collections.synchronizedList(new ArrayList<>());
	static List<MobEffect> mobEffectList = new ArrayList<>();
	static List<ResourceLocation> mobEffectKeysList = new ArrayList<ResourceLocation>();
	
	public static void considerFiles()
	{
		File directory = new File(String.valueOf(FMLPaths.CONFIGDIR.get().resolve("beverages")));
		LOGGER.info("Considering directory: {}", directory);
		
		if (!directory.exists()) {
			LOGGER.warn("Beverage folder not found at {}", directory);
			LOGGER.info("Attempting to create beverage folder at {}...", directory);
			if (!directory.mkdir()) {
				LOGGER.error("Failed to create beverage folder at {}", directory);
				return;
			}
			LOGGER.info("Successfully created beverage folder at {}", directory);
		}
		
		if (!directory.canRead()) {
			LOGGER.error("Cannot read beverage folder {}", directory.getName());
			return;
		}
		
		if (directory.isHidden()) {
			LOGGER.warn("Beverage folder {} is hidden. Skipping...", directory.getName());
			return;
		}
		
		LOGGER.info("Processing beverage directory: {}", directory);
		File[] listOfFiles = directory.listFiles();
		if (listOfFiles == null || listOfFiles.length == 0) {
			LOGGER.warn("Beverage folder {} is empty.", directory.getName());
			return;
		}
		LOGGER.info("Found {} beverage file candidates", listOfFiles.length);
		
		for (File file : listOfFiles) {
			LOGGER.info("Considering beverage file candidate: {}", file);
			
			if (!file.canRead()) {
				LOGGER.warn("Cannot read beverage file candidate: {}", file.getName());
				continue;
			}
			
			if (file.isHidden()) {
				LOGGER.warn("Beverage file candidate {} is hidden. Skipping...", file.getName());
				continue;
			}
			
			if (file.getName().isBlank()) {
				LOGGER.warn("Beverage file candidate {} has an invalid name: \"{}\"", file, file.getName());
				continue;
			}
			
			if (file.isDirectory()) {
				LOGGER.warn(
						"Found a subdirectory instead of a beverage file candidate at: {}. Parsing subdirectories is only supported by the experimental build of the mod. Skipping...",
						file); // TODO: Add support for parsing subdirectories
				continue;
			}
			
			if (!file.isFile()) {
				LOGGER.warn("Beverage file candidate {} does not satisfy system-dependent criteria. Skipping...", file.getName());
				continue;
			}
			
			if (!file.getName().endsWith(".json")) {
				LOGGER.info("Beverage file candidate {} is not a JSON file. Skipping...", file.getName());
				continue;
			}
			
			try (FileReader fileReader = new FileReader(file)) {
				if (!isValidJson(file)) {
					LOGGER.warn("Beverage file {} is not a valid JSON. Skipping...", file.getName());
					continue;
				}
				LOGGER.info("Found valid beverage file: {}", file);
				parseBeverageFile(file);
			} catch (IOException e) {
				LOGGER.error("Error reading file candidate {}: {}", file.getName(), e.getMessage());
			}
		}
	}
	
	public static boolean isValidJson(File jsonFile)
	{
		try (FileReader reader = new FileReader(jsonFile)) {
			JsonParser.parseReader(reader);
			return true;
		} catch (JsonSyntaxException | IOException e) {
			return false;
		}
	}
	
	public static void cacheCurrentlyKnownEffects()
	{
		for (ResourceLocation itemKey : ForgeRegistries.MOB_EFFECTS.getKeys()) {
			MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(itemKey);
			mobEffectKeysList.add(itemKey);
			mobEffectList.add(effect);
			//LOGGER.info("{} - {}", itemKey, effect);
		}
	}
	
	public static void logBeverageFileInfo()
	{
		for (int i = 0; i < mobEffectList.size(); i++) {
			ResourceLocation itemKey = mobEffectKeysList.get(i);
			MobEffect effect = mobEffectList.get(i);
			LOGGER.info("{} - {}", itemKey, effect);
		}
	}
	
	private static void parseBeverageFile(File configFile)
	{
		LOGGER.info("Starting to parse beverage file: {}", configFile);
		
		try (FileReader fileReader = new FileReader(configFile)) {
			JsonObject beverageData = JsonParser.parseReader(fileReader).getAsJsonObject();
			
			String itemId = beverageData.get("id").getAsString();
			if (isItemAlreadyRegistered(itemId)) {
				LOGGER.warn("Item {} is already registered. Skipping.", itemId);
				return;
			}
			
			int potency = beverageData.get("potency").getAsInt();
			int durationSeconds = beverageData.get("durationSeconds").getAsInt();
			int nutritionValue = beverageData.get("nutrition").getAsInt();
			float saturationModifier = beverageData.get("saturation").getAsFloat();
			
			JsonArray effectsArray = beverageData.getAsJsonArray("effects");
			
			// Store itemId and effectsArray in the map
			itemEffectsMap.put(itemId, effectsArray);
			
			// Register the custom item
			registerCustomItem(itemId, potency, durationSeconds, nutritionValue, saturationModifier);
		} catch (IOException exception) {
			throw new IllegalCallerException(
					"Unexpected error reading the beverage configuration file: " + configFile +
							". This should never happen, unless something calls beverage file parser directly!"
			);
		}
	}
	
	public static @NotNull JsonArray getEffectsFromMapById(@NotNull Map<String, JsonArray> ieMap, @NotNull String iId)
	{
		JsonArray jsonArray;
		if (ieMap.containsKey(iId)) {
			jsonArray = ieMap.get(iId);
			System.out.println("Values for " + iId + ": " + jsonArray.toString());
			return jsonArray;
		} else {
			LOGGER.error("Item identifier {} not found in provided map {}", iId, ieMap);
		}
		throw new IllegalStateException(); // TODO
	}
	
	private static boolean isItemAlreadyRegistered(String itemId)
	{
		return registeredItemIds.contains(itemId);
	}
	
	static @NotNull List<MobEffectInstance> processEffectsFromJsonArray(@NotNull JsonArray effectsArray)
	{
		List<MobEffectInstance> mobEffects = new ArrayList<>();
		
		for (int i = 0; i < effectsArray.size(); i++) {
			JsonObject effectObject = effectsArray.get(i).getAsJsonObject();
			String effectType = effectObject.get("type").getAsString();
			int effectDuration = effectObject.get("durationSeconds").getAsInt();
			int effectAmplifier = effectObject.get("amplifier").getAsInt();
			
			if (effectDuration < 0 || effectAmplifier < 0) {
				LOGGER.warn("Skipping effect with invalid parameters: type={}, duration={}, amplifier={}", effectType, effectDuration, effectAmplifier);
				continue;
			}
			
			MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(effectType));
			if (effect != null) {
				mobEffects.add(new MobEffectInstance(effect, effectDuration, effectAmplifier));
			} else {
				LOGGER.warn("Unknown effect type: {}", effectType);
				MyMod.logBeverageFileInfo();
			}
		}
		
		return mobEffects;
	}
	
	private static void registerCustomItem(String itemId, int potency, int durationSeconds, int nutrition, float saturationModifier)
	{
		foodPropertiesBuilder.nutrition(nutrition).saturationMod(saturationModifier);
		
		ITEM_REGISTRY.register(itemId, () -> new ModBoozeItem(
				potency, durationSeconds,
				new Item.Properties()
						.food(foodPropertiesBuilder.build())
						.stacksTo(16)
						.craftRemainder(BCItems.TANKARD.get())
		));
		
		registeredItemIds.add(itemId);
		LOGGER.info("Successfully registered custom item: {}", itemId);
	}
	
	public static void register(IEventBus eventBus)
	{
		ITEM_REGISTRY.register(eventBus);
		CREATIVE_TAB_REGISTRY.register(eventBus);
	}
}
