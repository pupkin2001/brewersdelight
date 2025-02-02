package pupkin.brewersdelight;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class DatapackFileReader {
	/**
	 * Reads a JSON file from a loaded datapack.
	 *
	 * @param server    The Minecraft server instance.
	 * @param namespace The namespace (e.g., "mynamespace").
	 * @param path      The path within the namespace (e.g., "path/to/file.json").
	 * @return An Optional containing the parsed JSON if successful.
	 */
	public static Optional<JsonElement> readJsonFile(MinecraftServer server, String namespace, String path) {
		// Build the resource location: "namespace:path/file.json"
		ResourceLocation resourceLocation = new ResourceLocation(namespace, path);
		
		try {
			// Get the ResourceManager from ReloadableResources
			ResourceManager resourceManager = server.getServerResources().resourceManager();
			
			// Open the resource
			try (InputStream inputStream = resourceManager.open(resourceLocation);
			     InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
				
				// Parse and return the JSON
				JsonElement jsonElement = JsonParser.parseReader(reader);
				BrewersDelight.LOGGER.info("JSONJSONJSON {}", jsonElement);
				return Optional.of(jsonElement);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Return empty if the file is not found or an error occurs
		return Optional.empty();
	}
}
