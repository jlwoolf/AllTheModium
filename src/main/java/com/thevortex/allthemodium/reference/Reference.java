package com.thevortex.allthemodium.reference;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;


public class Reference {

	public static final ResourceLocation ORETYPE = location("c:ores/allthemodium");
	public static final ResourceLocation ORETYPE2 = location("c:ores/vibranium");
	public static final ResourceLocation ORETYPE3 = location("c:ores/unobtainium");
	public static final String MOD_ID = "allthemodium";
	public static String tab() {
		return String.format("itemGroup.%s", MOD_ID);
	}
	public static ResourceLocation atm(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
	public static ResourceLocation mek(String path) {
		return ResourceLocation.fromNamespaceAndPath("mekanism", path);
	}
	public static ResourceLocation location(String pathIn) {
		return ResourceLocation.tryParse(pathIn);
	}
	public static ResourceLocation forge(String path) {
		return ResourceLocation.fromNamespaceAndPath("c", path);
	}
	public static ResourceLocation raw_ores(String path) {
		return forge("raw_ores/" + path);
	}
	public static ResourceLocation material(String path) {
		return forge("raw_materials/" + path);
	}
	public static ResourceLocation ingot(String path) {
		return forge("ingots/" + path);
	}
	public static ResourceLocation dust(String path) {
		return forge("dusts/" + path);
	}
	public static ResourceLocation dirty(String path) {
		return mek("dirty_dusts/" + path);
	}
	public static ResourceLocation shard(String path) {
		return mek("shards/" + path);
	}
	public static ResourceLocation clump(String path) {
		return mek("clumps/" + path);
	}
	public static ResourceLocation crystal(String path) {
		return mek("crystals/" + path);
	}
	public static ResourceLocation nugget(String path) {
		return forge("nuggets/" + path);
	}
	public static ResourceLocation ore(String path) {
		return forge("ores/" + path);
	}
	public static ResourceLocation rod(String path) {
		return forge("rods/" + path);
	}
	public static ResourceLocation gear(String path) {
		return forge("gears/" + path);
	}
	public static ResourceLocation plate(String path) {
		return forge("plates/" + path);
	}
	public static ResourceLocation block(String path) {
		return forge("storage_blocks/" + path);
	}
	public static ResourceLocation raw_block(String path) {
		return forge("raw_blocks/" + path);
	}
}
