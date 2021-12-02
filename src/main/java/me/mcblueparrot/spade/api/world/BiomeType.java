package me.mcblueparrot.spade.api.world;

import java.util.List;
import java.util.Objects;

import me.mcblueparrot.spade.api.Spade;
import me.mcblueparrot.spade.api.id.Identifiable;
import me.mcblueparrot.spade.api.id.Identifier;
import me.mcblueparrot.spade.api.server.Server;

/**
 * Represents a type of biome.
 */
public abstract class BiomeType implements Identifiable {

	private Identifier id;

	protected BiomeType(Identifier id) {
		this.id = id;
	}

	/**
	 * Gets the biome type's identifier.
	 * @return the identifier
	 */
	@Override
	public Identifier getId() {
		return id;
	}

	@Override
	public String toString() {
		return id.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		BiomeType other = (BiomeType) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * @see Server#getBiomeType(Identifier)
	 */
	public static BiomeType getBiomeType(Identifier id) {
		return Spade.getBiomeType(id);
	}

	/**
	 * @see Server#getBiomeType(String)
	 */
	public static BiomeType getBiomeType(String id) {
		return Spade.getBiomeType(id);
	}

	/**
	 * @see Server#getBiomeTypes()
	 */
	public static List<BiomeType> getBiomeTypes() {
		return Spade.getBiomeTypes();
	}

	public static final BiomeType OCEAN = getBiomeType("ocean");
	public static final BiomeType PLAINS = getBiomeType("plains");
	public static final BiomeType DESERT = getBiomeType("desert");
	public static final BiomeType MOUNTAINS = getBiomeType("mountains");
	public static final BiomeType FOREST = getBiomeType("forest");
	public static final BiomeType TAIGA = getBiomeType("taiga");
	public static final BiomeType SWAMP = getBiomeType("swamp");
	public static final BiomeType RIVER = getBiomeType("river");
	public static final BiomeType NETHER_WASTES = getBiomeType("nether_wastes");
	public static final BiomeType THE_END = getBiomeType("the_end");
	public static final BiomeType FROZEN_OCEAN = getBiomeType("frozen_ocean");
	public static final BiomeType FROZEN_RIVER = getBiomeType("frozen_river");
	public static final BiomeType SNOWY_TUNDRA = getBiomeType("snowy_tundra");
	public static final BiomeType SNOWY_MOUNTAINS = getBiomeType("snowy_mountains");
	public static final BiomeType MUSHROOM_FIELDS = getBiomeType("mushroom_fields");
	public static final BiomeType MUSHROOM_FIELD_SHORE = getBiomeType("mushroom_field_shore");
	public static final BiomeType BEACH = getBiomeType("beach");
	public static final BiomeType DESERT_HILLS = getBiomeType("desert_hills");
	public static final BiomeType WOODED_HILLS = getBiomeType("wooded_hills");
	public static final BiomeType TAIGA_HILLS = getBiomeType("taiga_hills");
	public static final BiomeType MOUNTAIN_EDGE = getBiomeType("mountain_edge");
	public static final BiomeType JUNGLE = getBiomeType("jungle");
	public static final BiomeType JUNGLE_HILLS = getBiomeType("jungle_hills");
	public static final BiomeType JUNGLE_EDGE = getBiomeType("jungle_edge");
	public static final BiomeType DEEP_OCEAN = getBiomeType("deep_ocean");
	public static final BiomeType STONE_SHORE = getBiomeType("stone_shore");
	public static final BiomeType SNOWY_BEACH = getBiomeType("snowy_beach");
	public static final BiomeType BIRCH_FOREST = getBiomeType("birch_forest");
	public static final BiomeType BIRCH_FOREST_HILLS = getBiomeType("birch_forest_hills");
	public static final BiomeType DARK_FOREST = getBiomeType("dark_forest");
	public static final BiomeType SNOWY_TAIGA = getBiomeType("snowy_taiga");
	public static final BiomeType SNOWY_TAIGA_HILLS = getBiomeType("snowy_taiga_hills");
	public static final BiomeType GIANT_TREE_TAIGA = getBiomeType("giant_tree_taiga");
	public static final BiomeType GIANT_TREE_TAIGA_HILLS = getBiomeType("giant_tree_taiga_hills");
	public static final BiomeType WOODED_MOUNTAINS = getBiomeType("wooded_mountains");
	public static final BiomeType SAVANNA = getBiomeType("savanna");
	public static final BiomeType SAVANNA_PLATEAU = getBiomeType("savanna_plateau");
	public static final BiomeType BADLANDS = getBiomeType("badlands");
	public static final BiomeType WOODED_BADLANDS_PLATEAU = getBiomeType("wooded_badlands_plateau");
	public static final BiomeType BADLANDS_PLATEAU = getBiomeType("badlands_plateau");
	public static final BiomeType SMALL_END_ISLANDS = getBiomeType("small_end_islands");
	public static final BiomeType END_MIDLANDS = getBiomeType("end_midlands");
	public static final BiomeType END_HIGHLANDS = getBiomeType("end_highlands");
	public static final BiomeType END_BARRENS = getBiomeType("end_barrens");
	public static final BiomeType WARM_OCEAN = getBiomeType("warm_ocean");
	public static final BiomeType LUKEWARM_OCEAN = getBiomeType("lukewarm_ocean");
	public static final BiomeType COLD_OCEAN = getBiomeType("cold_ocean");
	public static final BiomeType DEEP_WARM_OCEAN = getBiomeType("deep_warm_ocean");
	public static final BiomeType DEEP_LUKEWARM_OCEAN = getBiomeType("deep_lukewarm_ocean");
	public static final BiomeType DEEP_COLD_OCEAN = getBiomeType("deep_cold_ocean");
	public static final BiomeType DEEP_FROZEN_OCEAN = getBiomeType("deep_frozen_ocean");
	public static final BiomeType THE_VOID = getBiomeType("the_void");
	public static final BiomeType SUNFLOWER_PLAINS = getBiomeType("sunflower_plains");
	public static final BiomeType DESERT_LAKES = getBiomeType("desert_lakes");
	public static final BiomeType GRAVELLY_MOUNTAINS = getBiomeType("gravelly_mountains");
	public static final BiomeType FLOWER_FOREST = getBiomeType("flower_forest");
	public static final BiomeType TAIGA_MOUNTAINS = getBiomeType("taiga_mountains");
	public static final BiomeType SWAMP_HILLS = getBiomeType("swamp_hills");
	public static final BiomeType ICE_SPIKES = getBiomeType("ice_spikes");
	public static final BiomeType MODIFIED_JUNGLE = getBiomeType("modified_jungle");
	public static final BiomeType MODIFIED_JUNGLE_EDGE = getBiomeType("modified_jungle_edge");
	public static final BiomeType TALL_BIRCH_FOREST = getBiomeType("tall_birch_forest");
	public static final BiomeType TALL_BIRCH_HILLS = getBiomeType("tall_birch_hills");
	public static final BiomeType DARK_FOREST_HILLS = getBiomeType("dark_forest_hills");
	public static final BiomeType SNOWY_TAIGA_MOUNTAINS = getBiomeType("snowy_taiga_mountains");
	public static final BiomeType GIANT_SPRUCE_TAIGA = getBiomeType("giant_spruce_taiga");
	public static final BiomeType GIANT_SPRUCE_TAIGA_HILLS = getBiomeType("giant_spruce_taiga_hills");
	public static final BiomeType MODIFIED_GRAVELLY_MOUNTAINS = getBiomeType("modified_gravelly_mountains");
	public static final BiomeType SHATTERED_SAVANNA = getBiomeType("shattered_savanna");
	public static final BiomeType SHATTERED_SAVANNA_PLATEAU = getBiomeType("shattered_savanna_plateau");
	public static final BiomeType ERODED_BADLANDS = getBiomeType("eroded_badlands");
	public static final BiomeType MODIFIED_WOODED_BADLANDS_PLATEAU = getBiomeType("modified_wooded_badlands_plateau");
	public static final BiomeType MODIFIED_BADLANDS_PLATEAU = getBiomeType("modified_badlands_plateau");
	public static final BiomeType BAMBOO_JUNGLE = getBiomeType("bamboo_jungle");
	public static final BiomeType BAMBOO_JUNGLE_HILLS = getBiomeType("bamboo_jungle_hills");
	public static final BiomeType SOUL_SAND_VALLEY = getBiomeType("soul_sand_valley");
	public static final BiomeType CRIMSON_FOREST = getBiomeType("crimson_forest");
	public static final BiomeType WARPED_FOREST = getBiomeType("warped_forest");
	public static final BiomeType BASALT_DELTAS = getBiomeType("basalt_deltas");

}
