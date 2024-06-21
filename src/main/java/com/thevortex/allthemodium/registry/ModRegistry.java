package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.blocks.*;
import com.thevortex.allthemodium.blocks.entity.ATMBrushableBlockEntity;
import com.thevortex.allthemodium.init.ModFoods;
import com.thevortex.allthemodium.items.*;
import com.thevortex.allthemodium.items.toolitems.armor.*;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;

@EventBusSubscriber(modid = Reference.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModRegistry {


	public static final DeferredRegister<Block> SHAPED_BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister<Block> STAIRBLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister<Block> WALLBLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister<Block> SLABBLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister<Block> PILLARBLOCKS = DeferredRegister.createBlocks(Reference.MOD_ID);
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(Registries.BIOME,
			Reference.MOD_ID);

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(Reference.MOD_ID);

	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);


	public static final DeferredRegister<BlockEntityType<?>> ENTITY = DeferredRegister
			.create(Registries.BLOCK_ENTITY_TYPE, Reference.MOD_ID);
	public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister
			.create(Registries.CARVER, Reference.MOD_ID);
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister
			.create(Registries.ENTITY_TYPE, Reference.MOD_ID);

	public static final DeferredRegister<Feature<?>> FEATURES =
			DeferredRegister.create(Registries.FEATURE, Reference.MOD_ID);

	private static ArrayList<Item> SPAWN_EGGS = new ArrayList<Item>();

		// BIOMES

	public static final DeferredHolder<Biome,Biome> MINING = BIOMES.register("mining", () -> ATMBiomes.mining());
	
	//



	// FOOD

	public static DeferredHolder<Item,Item> ALLTHEMODIUM_APPLE = ITEMS.register("allthemodium_apple", () -> new Allthemodium_Apple(new Item.Properties().fireResistant().food(ModFoods.ALLTHEMODIUM_APPLE).rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,Item> ALLTHEMODIUM_CARROT = ITEMS.register("allthemodium_carrot", () -> new Allthemodium_Carrot(new Item.Properties().fireResistant().food(ModFoods.ALLTHEMODIUM_CARROT).rarity(Rarity.EPIC)));

	// ARMORS

	public static DeferredHolder<Item,ArmorItem> ALLTHEMODIUM_HELMET = ITEMS.register("allthemodium_helmet", () -> new Allthemodium_Helmet(ArmorRegistries.ATM, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> ALLTHEMODIUM_CHESTPLATE = ITEMS.register("allthemodium_chestplate", () -> new Allthemodium_Chestplate(ArmorRegistries.ATM, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> ALLTHEMODIUM_LEGGINGS = ITEMS.register("allthemodium_leggings", () -> new Allthemodium_Leggings(ArmorRegistries.ATM, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> ALLTHEMODIUM_BOOTS = ITEMS.register("allthemodium_boots", () -> new Allthemodium_Boots(ArmorRegistries.ATM, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));


	public static DeferredHolder<Item,ArmorItem> VIBRANIUM_HELMET = ITEMS.register("vibranium_helmet", () -> new Allthemodium_Helmet(ArmorRegistries.VIB, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> VIBRANIUM_CHESTPLATE = ITEMS.register("vibranium_chestplate", () -> new Allthemodium_Chestplate(ArmorRegistries.VIB, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> VIBRANIUM_LEGGINGS = ITEMS.register("vibranium_leggings", () -> new Allthemodium_Leggings(ArmorRegistries.VIB, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> VIBRANIUM_BOOTS = ITEMS.register("vibranium_boots", () -> new Allthemodium_Boots(ArmorRegistries.VIB, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

	public static DeferredHolder<Item,ArmorItem> UNOBTAINIUM_HELMET = ITEMS.register("unobtainium_helmet", () -> new Allthemodium_Helmet(ArmorRegistries.UNOB, EquipmentSlot.HEAD, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> UNOBTAINIUM_CHESTPLATE = ITEMS.register("unobtainium_chestplate", () -> new Allthemodium_Chestplate(ArmorRegistries.UNOB, EquipmentSlot.CHEST, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> UNOBTAINIUM_LEGGINGS = ITEMS.register("unobtainium_leggings", () -> new Allthemodium_Leggings(ArmorRegistries.UNOB, EquipmentSlot.LEGS, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));
	public static DeferredHolder<Item,ArmorItem> UNOBTAINIUM_BOOTS = ITEMS.register("unobtainium_boots", () -> new Allthemodium_Boots(ArmorRegistries.UNOB, EquipmentSlot.FEET, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

	
	
	//Volcano



	public static final DeferredHolder<Block, AncientCaveVines> ANCIENT_CAVEVINES_ = PILLARBLOCKS.register("ancient_cavevines", () -> new AncientCaveVines(BlockBehaviour.Properties.of()
			.randomTicks()
			.noCollission()
			.noOcclusion()
			.lightLevel(ACaveVines.emission(14))
			.instabreak()
			.sound(SoundType.CAVE_VINES)
			,Direction.DOWN
			,ACaveVines.SHAPE
			,false
			,0.1D));

	public static final DeferredHolder<Block, AncientCaveVinesPlant> ANCIENT_CAVEVINES_PLANT_ = PILLARBLOCKS.register("ancient_cavevines_plant", () -> new AncientCaveVinesPlant(BlockBehaviour.Properties.of()
			.noCollission()
			.noOcclusion()
			.lightLevel(ACaveVines.emission(14))
			.instabreak()
			.sound(SoundType.CAVE_VINES)
			,Direction.DOWN
			,ACaveVines.SHAPE
			, false));

	public static final DeferredHolder<Block,Block> PIGLICH_HEART_BLOCK = BLOCKS.register("piglich_heart_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST)));
	public static final DeferredHolder<Item,Item> PIGLICH_HEART_BLOCK_ITEM = ITEMS.register("piglich_heart_block", () -> new BlockItem(PIGLICH_HEART_BLOCK.get(),new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

	public static final DeferredHolder<Block,Block> ANCIENT_HERB = PILLARBLOCKS.register("ancient_herb",() -> new AncientHerb(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));

	public static final DeferredHolder<Block,Block> ANCIENT_SMOOTH_STONE = BLOCKS.register("ancient_smooth_stone", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(2.25f)));
	public static final DeferredHolder<Block,Block> ANCIENT_STONE = BLOCKS.register("ancient_stone", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1.5f)));
	public static final DeferredHolder<Block,Block> ANCIENT_DIRT = BLOCKS.register("ancient_dirt", () -> new AncientDirt(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(0.6f)));
	public static final DeferredHolder<Block,Block> ANCIENT_GRASS = BLOCKS.register("ancient_grass", () -> new Ancient_Grass(BlockBehaviour.Properties.of().sound(SoundType.MOSS).strength(0.6f)));
	public static final DeferredHolder<Block,Block> ANCIENT_MOSSY_STONE = BLOCKS.register("ancient_mossy_stone", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS_CARPET).strength(1.5f)));
	public static final DeferredHolder<Block,Block> ANCIENT_STONE_BRICKS = BLOCKS.register("ancient_stone_bricks", () -> new AncientStone());
	public static final DeferredHolder<Block,Block> ANCIENT_CHISELED_STONE_BRICKS = BLOCKS.register("ancient_chiseled_stone_bricks", () -> new AncientStone());
	public static final DeferredHolder<Block,Block> ANCIENT_CRACKED_STONE_BRICKS = BLOCKS.register("ancient_cracked_stone_bricks", () -> new AncientStone());
	public static final DeferredHolder<Block,Block> ANCIENT_POLISHED_STONE = BLOCKS.register("ancient_polished_stone", () -> new AncientStone());

	public static final DeferredHolder<Block,Block> ANCIENT_LOG_0 = PILLARBLOCKS.register("ancient_log_0",() -> log(DyeColor.BLUE, DyeColor.BLUE));
	public static final DeferredHolder<Block,Block> ANCIENT_LOG_1 = PILLARBLOCKS.register("ancient_log_1",() -> log(DyeColor.BLUE, DyeColor.BLUE));
	public static final DeferredHolder<Block,Block> ANCIENT_LOG_2 = PILLARBLOCKS.register("ancient_log_2",() -> log(DyeColor.BLUE, DyeColor.BLUE));
	public static final DeferredHolder<Block,Block> ANCIENT_LOG_STRIPPED = PILLARBLOCKS.register("stripped_ancient_log",() -> log(DyeColor.BLUE, DyeColor.BLUE));
	public static final DeferredHolder<Block,Block> ANCIENT_LEAVES = BLOCKS.register("ancient_leaves", () -> new AncientLeaves(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().mapColor(DyeColor.PURPLE)));
	public static final DeferredHolder<Block,Block> ANCIENT_LEAVES_BOTTOM = PILLARBLOCKS.register("ancient_leaves_bottom", () -> new AncientLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
	public static final DeferredHolder<Block,Block> ANCIENT_PLANKS = BLOCKS.register("ancient_planks", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, TrapDoorBlock> ANCIENT_TRAPDOOR = PILLARBLOCKS.register("ancient_trap_door", () -> new TrapDoorBlock(ATMBlockSets.ANCIENT, BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
	public static final DeferredHolder<Block, FenceBlock> ANCIENT_WOOD_FENCE = PILLARBLOCKS.register("ancient_wooden_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, FenceGateBlock> ANCIENT_WOOD_FENCE_GATE = PILLARBLOCKS.register("ancient_wooden_fence_gate", () -> new FenceGateBlock(ATMBlockSets.ANCIENTWOOD,BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, DoorBlock> ANCIENT_DOOR_ = PILLARBLOCKS.register("ancient_door", () -> new DoorBlock(ATMBlockSets.ANCIENT,BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)));

	public static final DeferredHolder<Block,Block> DEMONIC_HERB = PILLARBLOCKS.register("demonic_herb",() -> new AncientHerb(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));
	public static final DeferredHolder<Block,Block> DEMONIC_LOG = PILLARBLOCKS.register("demonic_log",() -> log(DyeColor.RED, DyeColor.RED));
	public static final DeferredHolder<Block,Block> DEMONIC_LOG_STRIPPED = PILLARBLOCKS.register("stripped_demonic_log",() -> log(DyeColor.RED, DyeColor.RED));
	public static final DeferredHolder<Block,Block> DEMONIC_LEAVES = BLOCKS.register("demonic_leaves", () -> new DemonicLeaves(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion()));
	public static final DeferredHolder<Block,Block> DEMONIC_LEAVES_BOTTOM = PILLARBLOCKS.register("demonic_leaves_bottom", () -> new DemonicLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
	public static final DeferredHolder<Block,Block> DEMONIC_PLANKS = BLOCKS.register("demonic_planks", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, TrapDoorBlock> DEMONIC_TRAPDOOR = PILLARBLOCKS.register("demonic_trap_door", () -> new TrapDoorBlock(ATMBlockSets.DEMONIC, BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
	public static final DeferredHolder<Block, FenceBlock> DEMONIC_WOOD_FENCE = PILLARBLOCKS.register("demonic_wooden_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, FenceGateBlock> DEMONIC_WOOD_FENCE_GATE = PILLARBLOCKS.register("demonic_wooden_fence_gate", () -> new FenceGateBlock(ATMBlockSets.DEMONICWOOD,BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, DoorBlock> DEMONIC_DOOR_ = PILLARBLOCKS.register("demonic_door", () -> new DoorBlock(ATMBlockSets.DEMONIC, BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)));

	public static final DeferredHolder<Block,Block> SOUL_HERB = PILLARBLOCKS.register("soul_herb",() -> new AncientHerb(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));
	public static final DeferredHolder<Block,Block> SOUL_LOG = PILLARBLOCKS.register("soul_log",() -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
	public static final DeferredHolder<Block,Block> SOUL_LOG_0 = PILLARBLOCKS.register("soul_log_0",() -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
	public static final DeferredHolder<Block,Block> SOUL_LOG_1 = PILLARBLOCKS.register("soul_log_1",() -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
	public static final DeferredHolder<Block,Block> SOUL_LOG_2 = PILLARBLOCKS.register("soul_log_2",() -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
	public static final DeferredHolder<Block,Block> SOUL_LOG_STRIPPED = PILLARBLOCKS.register("stripped_soul_log",() -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
	public static final DeferredHolder<Block,Block> SOUL_LEAVES = BLOCKS.register("soul_leaves", () -> new SoulLeaves(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion()));
	public static final DeferredHolder<Block,Block> SOUL_LEAVES_BOTTOM = PILLARBLOCKS.register("soul_leaves_bottom", () -> new SoulLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
	public static final DeferredHolder<Block,Block> SOUL_PLANKS = BLOCKS.register("soul_planks", () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, TrapDoorBlock> SOUL_TRAPDOOR = PILLARBLOCKS.register("soul_trap_door", () -> new TrapDoorBlock(ATMBlockSets.SOUL, BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion()));
	public static final DeferredHolder<Block, FenceBlock> SOUL_WOOD_FENCE = PILLARBLOCKS.register("soul_wooden_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, FenceGateBlock> SOUL_WOOD_FENCE_GATE = PILLARBLOCKS.register("soul_wooden_fence_gate", () -> new FenceGateBlock(ATMBlockSets.SOULWOOD, BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block, DoorBlock> SOUL_DOOR_ = PILLARBLOCKS.register("soul_door", () -> new DoorBlock(ATMBlockSets.SOUL,BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD)));


	public static final DeferredHolder<Block, WallBlock> ANCIENT_STONE_WALL = WALLBLOCKS.register("ancient_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_STONE.get())));
	public static final DeferredHolder<Block, WallBlock> ANCIENT_SMOOTH_STONE_WALL = WALLBLOCKS.register("ancient_smooth_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_SMOOTH_STONE.get())));
	public static final DeferredHolder<Block, WallBlock> ANCIENT_POLISHED_STONE_WALL = WALLBLOCKS.register("ancient_polished_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_POLISHED_STONE.get())));
	public static final DeferredHolder<Block, WallBlock> ANCIENT_STONE_BRICK_WALL = WALLBLOCKS.register("ancient_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_STONE_BRICKS.get())));
	public static final DeferredHolder<Block, WallBlock> ANCIENT_CHISELED_STONE_BRICK_WALL = WALLBLOCKS.register("ancient_chiseled_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_CHISELED_STONE_BRICKS.get())));
	public static final DeferredHolder<Block, WallBlock> ANCIENT_CRACKED_STONE_BRICK_WALL = WALLBLOCKS.register("ancient_cracked_stone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_CRACKED_STONE_BRICKS.get())));
	public static final DeferredHolder<Block, WallBlock> ANCIENT_MOSSY_STONE_WALL = WALLBLOCKS.register("ancient_mossy_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(ANCIENT_MOSSY_STONE.get())));


	public static final DeferredHolder<Item,Item> ANCIENT_CAVEVINE_PLANT_ITEM = ITEMS.register("ancient_cavevines_plant", () ->new BlockItem(ANCIENT_CAVEVINES_PLANT_.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_SOULBERRY = ITEMS.register("ancient_soulberries",() -> new SoulBerries(ANCIENT_CAVEVINES_.get(),(new Item.Properties()).food(ModFoods.SOUL_BERRIES)));
	public static final DeferredHolder<Item,Item> ANCIENT_TRAP_DOOR_ITEM = ITEMS.register("ancient_trap_door", () -> new BlockItem(ANCIENT_TRAPDOOR.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_TRAP_DOOR_ITEM = ITEMS.register("demonic_trap_door", () -> new BlockItem(DEMONIC_TRAPDOOR.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_TRAP_DOOR_ITEM = ITEMS.register("soul_trap_door", () -> new BlockItem(SOUL_TRAPDOOR.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_DOOR_ITEM = ITEMS.register("ancient_door", () -> new BlockItem(ANCIENT_DOOR_.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_DOOR_ITEM = ITEMS.register("demonic_door", () -> new BlockItem(DEMONIC_DOOR_.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_DOOR_ITEM = ITEMS.register("soul_door", () -> new BlockItem(SOUL_DOOR_.get(),new Item.Properties()));


	public static final DeferredHolder<Item,Item> ANCIENT_STONE_WALL_ITEM = ITEMS.register("ancient_stone_wall", () -> new BlockItem(ANCIENT_STONE_WALL.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_SMOOTH_STONE_WALL_ITEM = ITEMS.register("ancient_smooth_stone_wall", () -> new BlockItem(ANCIENT_SMOOTH_STONE_WALL.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_POLISHED_STONE_WALL_ITEM = ITEMS.register("ancient_polished_stone_wall", () -> new BlockItem(ANCIENT_POLISHED_STONE_WALL.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_STONE_BRICK_WALL_ITEM = ITEMS.register("ancient_stone_brick_wall", () ->  new BlockItem(ANCIENT_STONE_BRICK_WALL.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_CHISELED_STONE_BRICK_WALL_ITEM = ITEMS.register("ancient_chiseled_stone_brick_wall", () -> new BlockItem(ANCIENT_CHISELED_STONE_BRICK_WALL.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_CRACKED_STONE_BRICK_WALL_ITEM = ITEMS.register("ancient_cracked_stone_brick_wall", () -> new BlockItem(ANCIENT_CRACKED_STONE_BRICK_WALL.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_MOSSY_STONE_WALL_ITEM = ITEMS.register("ancient_mossy_stone_wall", () -> new BlockItem(ANCIENT_MOSSY_STONE_WALL.get(),new Item.Properties()));

	public static final DeferredHolder<Block,Block> ANCIENT_BOOKSHELF = PILLARBLOCKS.register("ancient_bookshelf", () -> new AncientBookShelf(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block,Block> DEMONIC_BOOKSHELF = PILLARBLOCKS.register("demonic_bookshelf", () -> new AncientBookShelf(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
	public static final DeferredHolder<Block,Block> SOUL_BOOKSHELF = PILLARBLOCKS.register("soul_bookshelf", () -> new AncientBookShelf(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));

	public static final DeferredHolder<Block, StairBlock> ANCIENT_WOODEN_STAIRS = STAIRBLOCKS.register("ancient_wooden_stairs", () -> new StairBlock(ANCIENT_PLANKS.get().defaultBlockState(), ANCIENT_PLANKS.get().properties()));
	public static final DeferredHolder<Block, StairBlock> DEMONIC_WOODEN_STAIRS = STAIRBLOCKS.register("demonic_wooden_stairs", () -> new StairBlock(DEMONIC_PLANKS.get().defaultBlockState(), DEMONIC_PLANKS.get().properties()));
	public static final DeferredHolder<Block, StairBlock> SOUL_WOODEN_STAIRS = STAIRBLOCKS.register("soul_wooden_stairs", () -> new StairBlock(SOUL_PLANKS.get().defaultBlockState(), SOUL_PLANKS.get().properties()));
	public static final DeferredHolder<Block, StairBlock> ANCIENT_STONE_STAIRS = STAIRBLOCKS.register("ancient_stone_stairs", () -> new StairBlock(ANCIENT_STONE.get().defaultBlockState(), ANCIENT_STONE.get().properties()));
	public static final DeferredHolder<Block, StairBlock> ANCIENT_SMOOTH_STONE_STAIRS = STAIRBLOCKS.register("ancient_smooth_stone_stairs", () -> new StairBlock(ANCIENT_SMOOTH_STONE.get().defaultBlockState(), ANCIENT_SMOOTH_STONE.get().properties()));
	public static final DeferredHolder<Block, StairBlock> ANCIENT_STONE_BRICK_STAIRS = STAIRBLOCKS.register("ancient_stone_brick_stairs", () -> new StairBlock(ANCIENT_STONE_BRICKS.get().defaultBlockState(), ANCIENT_STONE.get().properties()));

	public static final DeferredHolder<Block, StairBlock> ANCIENT_MOSSY_STONE_STAIRS = STAIRBLOCKS.register("ancient_mossy_stone_stairs", () -> new StairBlock(ANCIENT_MOSSY_STONE.get().defaultBlockState(),ANCIENT_MOSSY_STONE.get().properties()));
	public static final DeferredHolder<Block, StairBlock> ANCIENT_CHISELED_STONE_STAIRS = STAIRBLOCKS.register("ancient_chiseled_stone_brick_stairs", () -> new StairBlock(ANCIENT_CHISELED_STONE_BRICKS.get().defaultBlockState(), ANCIENT_MOSSY_STONE.get().properties()));
	public static final DeferredHolder<Block, StairBlock> ANCIENT_CRACKED_STONE_STAIRS = STAIRBLOCKS.register("ancient_cracked_stone_brick_stairs", () -> new StairBlock(ANCIENT_CRACKED_STONE_BRICKS.get().defaultBlockState(), ANCIENT_MOSSY_STONE.get().properties()));
	public static final DeferredHolder<Block, StairBlock> ANCIENT_POLISHED_STONE_STAIRS = STAIRBLOCKS.register("ancient_polished_stone_stairs", () -> new StairBlock(ANCIENT_POLISHED_STONE.get().defaultBlockState(), ANCIENT_MOSSY_STONE.get().properties()));

	public static final DeferredHolder<Block, SlabBlock> ANCIENT_WOODEN_SLABS = SLABBLOCKS.register("ancient_wooden_slabs", () -> new SlabBlock(ANCIENT_PLANKS.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> DEMONIC_WOODEN_SLABS = SLABBLOCKS.register("demonic_wooden_slabs", () -> new SlabBlock(DEMONIC_PLANKS.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> SOUL_WOODEN_SLABS = SLABBLOCKS.register("soul_wooden_slabs", () -> new SlabBlock(SOUL_PLANKS.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> ANCIENT_STONE_SLABS = SLABBLOCKS.register("ancient_stone_slabs", () -> new SlabBlock(ANCIENT_STONE.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> ANCIENT_SMOOTH_STONE_SLABS = SLABBLOCKS.register("ancient_smooth_stone_slabs", () -> new SlabBlock(ANCIENT_SMOOTH_STONE.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> ANCIENT_STONE_BRICK_SLABS = SLABBLOCKS.register("ancient_stone_brick_slabs", () -> new SlabBlock(ANCIENT_STONE.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> ANCIENT_MOSSY_STONE_SLABS = SLABBLOCKS.register("ancient_mossy_stone_slabs", () -> new SlabBlock(ANCIENT_MOSSY_STONE.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> ANCIENT_CHISELED_STONE_SLABS = SLABBLOCKS.register("ancient_chiseled_stone_brick_slabs", () -> new SlabBlock(ANCIENT_MOSSY_STONE.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> ANCIENT_CRACKED_STONE_SLABS = SLABBLOCKS.register("ancient_cracked_stone_brick_slabs", () -> new SlabBlock(ANCIENT_MOSSY_STONE.get().properties()));
	public static final DeferredHolder<Block, SlabBlock> ANCIENT_POLISHED_STONE_SLABS = SLABBLOCKS.register("ancient_polished_stone_slabs", () -> new SlabBlock(ANCIENT_MOSSY_STONE.get().properties()));

	public static final DeferredHolder<Item,Item> ANCIENT_WOODEN_SLABS_ITEM = ITEMS.register("ancient_wooden_slabs", () -> new BlockItem(ANCIENT_WOODEN_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_WOODEN_SLABS_ITEM = ITEMS.register("demonic_wooden_slabs", () -> new BlockItem(DEMONIC_WOODEN_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_WOODEN_SLABS_ITEM = ITEMS.register("soul_wooden_slabs", () -> new BlockItem(SOUL_WOODEN_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_STONE_SLABS_ITEM = ITEMS.register("ancient_stone_slabs", () -> new BlockItem(ANCIENT_STONE_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_SMOOTH_STONE_SLABS_ITEM = ITEMS.register("ancient_smooth_stone_slabs", () -> new BlockItem(ANCIENT_SMOOTH_STONE_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_STONE_BRICK_SLABS_ITEM = ITEMS.register("ancient_stone_brick_slabs", () -> new BlockItem(ANCIENT_STONE_BRICK_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_MOSSY_STONE_SLABS_ITEM = ITEMS.register("ancient_mossy_stone_slabs", () -> new BlockItem(ANCIENT_MOSSY_STONE_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_CHISELED_STONE_SLABS_ITEM = ITEMS.register("ancient_chiseled_stone_brick_slabs", () -> new BlockItem(ANCIENT_CHISELED_STONE_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_CRACKED_STONE_SLABS_ITEM = ITEMS.register("ancient_cracked_stone_brick_slabs", () -> new BlockItem(ANCIENT_CRACKED_STONE_SLABS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_POLISHED_STONE_SLABS_ITEM = ITEMS.register("ancient_polished_stone_slabs", () -> new BlockItem(ANCIENT_POLISHED_STONE_SLABS.get(),new Item.Properties()));

	public static final DeferredHolder<Item,Item> ANCIENT_HERB_ITEM = ITEMS.register("ancient_herb",() -> new BlockItem(ANCIENT_HERB.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_HERB_ITEM = ITEMS.register("demonic_herb",() -> new BlockItem(DEMONIC_HERB.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_HERB_ITEM = ITEMS.register("soul_herb",() -> new BlockItem(SOUL_HERB.get(),new Item.Properties()));



	public static final DeferredHolder<Item,Item> ANCIENT_LOG_0_ITEM = ITEMS.register("ancient_log_0",() -> new BlockItem(ANCIENT_LOG_0.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_LOG_1_ITEM = ITEMS.register("ancient_log_1",() -> new BlockItem(ANCIENT_LOG_1.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_LOG_2_ITEM = ITEMS.register("ancient_log_2",() -> new BlockItem(ANCIENT_LOG_2.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_LOG_STRIPPED_ITEM = ITEMS.register("stripped_ancient_log",() -> new BlockItem(ANCIENT_LOG_STRIPPED.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_LEAVES_ITEM = ITEMS.register("ancient_leaves", () -> new BlockItem(ANCIENT_LEAVES.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_PLANKS_ITEM = ITEMS.register("ancient_planks", () -> new BlockItem(ANCIENT_PLANKS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_BOOKSHELF_ITEM = ITEMS.register("ancient_bookshelf", () -> new BlockItem(ANCIENT_BOOKSHELF.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_LOG_ITEM = ITEMS.register("soul_log",() -> new BlockItem(SOUL_LOG.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_LOG_0_ITEM = ITEMS.register("soul_log_0",() -> new BlockItem(SOUL_LOG_0.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_LOG_1_ITEM = ITEMS.register("soul_log_1",() -> new BlockItem(SOUL_LOG_1.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_LOG_2_ITEM = ITEMS.register("soul_log_2",() -> new BlockItem(SOUL_LOG_2.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_LOG_STRIPPED_ITEM = ITEMS.register("stripped_soul_log",() -> new BlockItem(SOUL_LOG_STRIPPED.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_LEAVES_ITEM = ITEMS.register("soul_leaves", () -> new BlockItem(SOUL_LEAVES.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_PLANKS_ITEM = ITEMS.register("soul_planks", () -> new BlockItem(SOUL_PLANKS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_BOOKSHELF_ITEM = ITEMS.register("soul_bookshelf", () -> new BlockItem(SOUL_BOOKSHELF.get(),new Item.Properties()));

	public static final DeferredHolder<Item,Item> DEMONIC_LOG_ITEM = ITEMS.register("demonic_log",() -> new BlockItem(DEMONIC_LOG.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_LOG_STRIPPED_ITEM = ITEMS.register("stripped_demonic_log",() -> new BlockItem(DEMONIC_LOG_STRIPPED.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_LEAVES_ITEM = ITEMS.register("demonic_leaves", () -> new BlockItem(DEMONIC_LEAVES.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_PLANKS_ITEM = ITEMS.register("demonic_planks", () -> new BlockItem(DEMONIC_PLANKS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_BOOKSHELF_ITEM = ITEMS.register("demonic_bookshelf", () -> new BlockItem(DEMONIC_BOOKSHELF.get(),new Item.Properties()));

	public static final DeferredHolder<Item,Item> ANCIENT_WOODEN_STAIRS_ITEM = ITEMS.register("ancient_wooden_stairs", () -> new BlockItem(ANCIENT_WOODEN_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_WOODEN_STAIRS_ITEM = ITEMS.register("demonic_wooden_stairs", () -> new BlockItem(DEMONIC_WOODEN_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_WOODEN_STAIRS_ITEM = ITEMS.register("soul_wooden_stairs", () -> new BlockItem(SOUL_WOODEN_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_STONE_STAIRS_ITEM = ITEMS.register("ancient_stone_stairs", () -> new BlockItem(ANCIENT_STONE_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_SMOOTH_STONE_STAIRS_ITEM = ITEMS.register("ancient_smooth_stone_stairs", () -> new BlockItem(ANCIENT_SMOOTH_STONE_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_STONE_BRICK_STAIRS_ITEM = ITEMS.register("ancient_stone_brick_stairs", () -> new BlockItem(ANCIENT_STONE_BRICK_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_MOSSY_STONE_STAIRS_ITEM = ITEMS.register("ancient_mossy_stone_stairs", () -> new BlockItem(ANCIENT_MOSSY_STONE_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_CHISELED_STONE_STAIRS_ITEM = ITEMS.register("ancient_chiseled_stone_brick_stairs", () -> new BlockItem(ANCIENT_CHISELED_STONE_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_CRACKED_STONE_STAIRS_ITEM = ITEMS.register("ancient_cracked_stone_brick_stairs", () -> new BlockItem(ANCIENT_CRACKED_STONE_STAIRS.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_POLISHED_STONE_STAIRS_ITEM = ITEMS.register("ancient_polished_stone_stairs", () -> new BlockItem(ANCIENT_POLISHED_STONE_STAIRS.get(),new Item.Properties()));


	public static final DeferredHolder<Item,Item> ANCIENT_WOOD_FENCE_ITEM = ITEMS.register("ancient_wooden_fence", () -> new BlockItem(ANCIENT_WOOD_FENCE.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_WOOD_FENCE_GATE_ITEM = ITEMS.register("ancient_wooden_fence_gate", () -> new BlockItem(ANCIENT_WOOD_FENCE_GATE.get(),new Item.Properties()));;
	public static final DeferredHolder<Item,Item> DEMONIC_WOOD_FENCE_ITEM = ITEMS.register("demonic_wooden_fence", () -> new BlockItem(DEMONIC_WOOD_FENCE.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> DEMONIC_WOOD_FENCE_GATE_ITEM = ITEMS.register("demonic_wooden_fence_gate", () -> new BlockItem(DEMONIC_WOOD_FENCE_GATE.get(),new Item.Properties()));;
	public static final DeferredHolder<Item,Item> SOUL_WOOD_FENCE_ITEM = ITEMS.register("soul_wooden_fence", () -> new BlockItem(SOUL_WOOD_FENCE.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> SOUL_WOOD_FENCE_GATE_ITEM = ITEMS.register("soul_wooden_fence_gate", () -> new BlockItem(SOUL_WOOD_FENCE_GATE.get(),new Item.Properties()));;


	public static final DeferredHolder<Item,Item> ANCIENT_SMOOTH_STONE_ITEM = ITEMS.register("ancient_smooth_stone", () -> new BlockItem(ANCIENT_SMOOTH_STONE.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_STONE_ITEM = ITEMS.register("ancient_stone", () -> new BlockItem(ANCIENT_STONE.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_DIRT_ITEM = ITEMS.register("ancient_dirt", () -> new BlockItem(ANCIENT_DIRT.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_GRASS_ITEM = ITEMS.register("ancient_grass", () -> new BlockItem(ANCIENT_GRASS.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_MOSSY_STONE_ITEM = ITEMS.register("ancient_mossy_stone", () -> new BlockItem(ANCIENT_MOSSY_STONE.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_STONE_BRICKS_ITEM = ITEMS.register("ancient_stone_bricks", () -> new BlockItem(ANCIENT_STONE_BRICKS.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_CHISELED_STONE_BRICKS_ITEM = ITEMS.register("ancient_chiseled_stone_bricks", () -> new BlockItem(ANCIENT_CHISELED_STONE_BRICKS.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_CRACKED_STONE_BRICKS_ITEM = ITEMS.register("ancient_cracked_stone_bricks", () -> new BlockItem(ANCIENT_CRACKED_STONE_BRICKS.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ANCIENT_POLISHED_STONE_ITEM = ITEMS.register("ancient_polished_stone", () -> new BlockItem(ANCIENT_POLISHED_STONE.get(), new Item.Properties()));

	public static final DeferredHolder<Block, Allthemodium_Ore> ALLTHEMODIUM_ORE = BLOCKS.register("allthemodium_ore", Allthemodium_Ore::new);
	public static final DeferredHolder<Block, Allthemodium_Ore> ALLTHEMODIUM_SLATE_ORE = BLOCKS.register("allthemodium_slate_ore", Allthemodium_Ore::new);

	public static final DeferredHolder<Block,Block> VIBRANIUM_ORE = BLOCKS.register("vibranium_ore", Vibranium_Ore::new);
	public static final DeferredHolder<Block,Block> OTHER_VIBRANIUM_ORE = BLOCKS.register("other_vibranium_ore", Vibranium_Ore::new);
	public static final DeferredHolder<Block,Block> UNOBTAINIUM_ORE = BLOCKS.register("unobtainium_ore", Unobtainium_Ore::new);

	public static final DeferredHolder<Block,Block> ALLTHEMODIUM_BLOCK = BLOCKS.register("allthemodium_block", ATM_Block::new);
	public static final DeferredHolder<Block,Block> VIBRANIUM_BLOCK = BLOCKS.register("vibranium_block", VIB_Block::new);
	public static final DeferredHolder<Block,Block> UNOBTAINIUM_BLOCK = BLOCKS.register("unobtainium_block", UNOB_Block::new);

	public static final DeferredHolder<Block,Block> RAW_ALLTHEMODIUM_BLOCK = BLOCKS.register("raw_allthemodium_block", Raw_ATM::new);
	public static final DeferredHolder<Block,Block> RAW_VIBRANIUM_BLOCK = BLOCKS.register("raw_vibranium_block", Raw_VIB::new);
	public static final DeferredHolder<Block,Block> RAW_UNOBTAINIUM_BLOCK = BLOCKS.register("raw_unobtainium_block", Raw_UNO::new);

	public static final DeferredHolder<Item,Item> RAW_ALLTHEMODIUM_BLOCK_ITEM = ITEMS.register("raw_allthemodium_block", () -> new BlockItem(RAW_ALLTHEMODIUM_BLOCK.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> RAW_VIBRANIUM_BLOCK_ITEM = ITEMS.register("raw_vibranium_block", () -> new BlockItem(RAW_VIBRANIUM_BLOCK.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> RAW_UNOBTAINIUM_BLOCK_ITEM = ITEMS.register("raw_unobtainium_block", () -> new BlockItem(RAW_UNOBTAINIUM_BLOCK.get(), new Item.Properties()));

	public static final DeferredHolder<Item,Item> ALLTHEMODIUM_ORE_ITEM = ITEMS.register("allthemodium_ore", () -> new Allthemodium_Ore_Item(ALLTHEMODIUM_ORE.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> ALLTHEMODIUM_SLATE_ORE_ITEM = ITEMS.register("allthemodium_slate_ore", () -> new Allthemodium_Ore_Item(ALLTHEMODIUM_SLATE_ORE.get(), new Item.Properties()));

	public static final DeferredHolder<Item,Item> VIBRANIUM_ORE_ITEM = ITEMS.register("vibranium_ore", () -> new Vibranium_Ore_Item(VIBRANIUM_ORE.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> OTHER_VIBRANIUM_ORE_ITEM = ITEMS.register("other_vibranium_ore", () -> new Vibranium_Ore_Item(OTHER_VIBRANIUM_ORE.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> UNOBTAINIUM_ORE_ITEM = ITEMS.register("unobtainium_ore", () -> new Unobtainium_Ore_Item(UNOBTAINIUM_ORE.get(), new Item.Properties()));

	public static final DeferredHolder<Item,Item> ALLTHEMODIUM_BLOCK_ITEM = ITEMS.register("allthemodium_block", () -> new BlockItem(ALLTHEMODIUM_BLOCK.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIBRANIUM_BLOCK_ITEM = ITEMS.register("vibranium_block", () -> new BlockItem(VIBRANIUM_BLOCK.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> UNOBTAINIUM_BLOCK_ITEM = ITEMS.register("unobtainium_block", () -> new BlockItem(UNOBTAINIUM_BLOCK.get(), new Item.Properties()));

	public static final DeferredHolder<Item,Item> RAW_ALLTHEMODIUM = ITEMS.register("raw_allthemodium", () -> new RawOre(new Item.Properties()));
	public static final DeferredHolder<Item,Item> RAW_VIBRANIUM = ITEMS.register("raw_vibranium", () -> new RawOre(new Item.Properties()));
	public static final DeferredHolder<Item,Item> RAW_UNOBTAINIUM = ITEMS.register("raw_unobtainium", () -> new RawOre(new Item.Properties()));


	public static final DeferredHolder<Item,Item> SUS_CLAY_ITEM = ITEMS.register("suspicious_clay", () -> new BlockItem(BlockRegistry.SUS_CLAY.get(), new Item.Properties()));
	public static final DeferredHolder<Item,Item> SUS_SOUL_SAND_ITEM = ITEMS.register("suspicious_soul_sand", () -> new BlockItem(BlockRegistry.SUS_SOUL_SAND.get(), new Item.Properties()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ATMBrushableBlockEntity>> BRUSHABLE_BLOCK = ENTITY.register("brushable_block", () ->
			BlockEntityType.Builder.of(ATMBrushableBlockEntity::new,
					BlockRegistry.SUS_CLAY.get(),
					BlockRegistry.SUS_SOUL_SAND.get()
			).build(null)
	);

	public static final DeferredHolder<Item,Item> ALLTHEMODIUM_INGOT = ITEMS.register("allthemodium_ingot", () -> new Ingot(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIBRANIUM_INGOT = ITEMS.register("vibranium_ingot", () -> new Ingot(new Item.Properties()));
	public static final DeferredHolder<Item,Item> UNOBTAINIUM_INGOT = ITEMS.register("unobtainium_ingot", () -> new Ingot(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ATM_PLATE = ITEMS.register("allthemodium_plate", () -> new Plate(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_PLATE = ITEMS.register("vibranium_plate", () -> new Plate(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_PLATE = ITEMS.register("unobtainium_plate", () -> new Plate(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_GEAR = ITEMS.register("allthemodium_gear", () -> new Gear(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_GEAR = ITEMS.register("vibranium_gear", () -> new Gear(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_GEAR = ITEMS.register("unobtainium_gear", () -> new Gear(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_ROD = ITEMS.register("allthemodium_rod", () -> new Rod(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_ROD = ITEMS.register("vibranium_rod", () -> new Rod(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_ROD = ITEMS.register("unobtainium_rod", () -> new Rod(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ALLTHEMODIUM_NUGGET = ITEMS.register("allthemodium_nugget", () -> new Nugget(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIBRANIUM_NUGGET = ITEMS.register("vibranium_nugget", () -> new Nugget(new Item.Properties()));
	public static final DeferredHolder<Item,Item> UNOBTAINIUM_NUGGET = ITEMS.register("unobtainium_nugget", () -> new Nugget(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ALLTHEMODIUM_DUST = ITEMS.register("allthemodium_dust", () -> new Dust(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIBRANIUM_DUST = ITEMS.register("vibranium_dust", () -> new Dust(new Item.Properties()));
	public static final DeferredHolder<Item,Item> UNOBTAINIUM_DUST = ITEMS.register("unobtainium_dust", () -> new Dust(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_CLUMP = ITEMS.register("allthemodium_clump", () -> new Clump(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_CLUMP = ITEMS.register("vibranium_clump", () -> new Clump(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_CLUMP = ITEMS.register("unobtainium_clump", () -> new Clump(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_SHARD = ITEMS.register("allthemodium_shard", () -> new Shard(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_SHARD = ITEMS.register("vibranium_shard", () -> new Shard(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_SHARD = ITEMS.register("unobtainium_shard", () -> new Shard(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_DIRTY = ITEMS.register("dirty_allthemodium_dust", () -> new DirtyDust(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_DIRTY = ITEMS.register("dirty_vibranium_dust", () -> new DirtyDust(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_DIRTY = ITEMS.register("dirty_unobtainium_dust", () -> new DirtyDust(new Item.Properties()));

	public static final DeferredHolder<Item,Item> ATM_CRYSTAL = ITEMS.register("allthemodium_crystal", () -> new Crystal(new Item.Properties()));
	public static final DeferredHolder<Item,Item> VIB_CRYSTAL = ITEMS.register("vibranium_crystal", () -> new Crystal(new Item.Properties()));
	public static final DeferredHolder<Item,Item> ONOB_CRYSTAL = ITEMS.register("unobtainium_crystal", () -> new Crystal(new Item.Properties()));

	public static final DeferredHolder<Item,Item> UNOBTAINIUM_ALLTHEMODIUM_DUST = ITEMS.register("unobtainium_allthemodium_alloy_dust",() -> new Alloy_Dust(new Item.Properties().fireResistant()));
	public static final DeferredHolder<Item,Item> UNOBTAINIUM_VIBRANIUM_DUST = ITEMS.register("unobtainium_vibranium_alloy_dust" , () -> new Alloy_Dust(new Item.Properties().fireResistant()));
	public static final DeferredHolder<Item,Item> VIBRANIUM_ALLTHEMODIUM_DUST = ITEMS.register("vibranium_allthemodium_alloy_dust", ()-> new Alloy_Dust(new Item.Properties().fireResistant()));

	public static final DeferredHolder<Item,Item> UNOBTAINIUM_ALLTHEMODIUM_ALLOY = ITEMS.register("unobtainium_allthemodium_alloy_ingot", () -> new Alloy_Ingot(new Item.Properties().fireResistant()));
	public static final DeferredHolder<Item,Item> UNOBTAINIUM_VIBRANIUM_ALLOY = ITEMS.register("unobtainium_vibranium_alloy_ingot", () -> new Alloy_Ingot(new Item.Properties().fireResistant()));
	public static final DeferredHolder<Item,Item> VIBRANIUM_ALLTHEMODIUM_ALLOY = ITEMS.register("vibranium_allthemodium_alloy_ingot", ()-> new Alloy_Ingot(new Item.Properties().fireResistant()));



	public static final DeferredHolder<Block,Block> TELEPORT_PAD = SHAPED_BLOCKS.register("teleport_pad", () -> new TeleportPad(Block.Properties.of().noLootTable().noOcclusion().strength(20.0F)));
	public static final DeferredHolder<Item,Item> TELEPORT_PAD_ITEM = ITEMS.register("teleport_pad", () -> new BlockItem(TELEPORT_PAD.get(), new Item.Properties()));

	
	public static final DeferredHolder<Block,Block> UA_ALLOY = BLOCKS.register("unobtainium_allthemodium_alloy_block", UAAlloy_Block::new);
	public static final DeferredHolder<Block,Block> UV_ALLOY = BLOCKS.register("unobtainium_vibranium_alloy_block", UVAlloy_Block::new);
	public static final DeferredHolder<Block,Block> VA_ALLOY = BLOCKS.register("vibranium_allthemodium_alloy_block", VAAlloy_Block::new);

	public static final DeferredHolder<Item,Item> UA_ALLOY_ITEM = ITEMS.register("unobtainium_allthemodium_alloy_block", () -> new BlockItem(UA_ALLOY.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> UV_ALLOY_ITEM = ITEMS.register("unobtainium_vibranium_alloy_block", () -> new BlockItem(UV_ALLOY.get(),new Item.Properties()));
	public static final DeferredHolder<Item,Item> VA_ALLOY_ITEM = ITEMS.register("vibranium_allthemodium_alloy_block", () -> new BlockItem(VA_ALLOY.get(),new Item.Properties()));


	
	public static final DeferredHolder<Item,Item> ATM_SMITHING = ITEMS.register("allthemodium_upgrade_smithing_template", () -> ATMSmithingItem.createAllthemodiumUpgradeTemplate());

	public static final DeferredHolder<Item,Item> VIB_SMITHING = ITEMS.register("vibranium_upgrade_smithing_template", () -> ATMSmithingItem.createVibraniumUpgradeTemplate());

	public static final DeferredHolder<Item,Item> UNO_SMITHING = ITEMS.register("unobtainium_upgrade_smithing_template", () -> ATMSmithingItem.createUnobtainiumUpgradeTemplate());

	public static final DeferredHolder<Item,Item> PIGLICH_HEART = ITEMS.register("piglich_heart", () -> new PiglichHeart(new Item.Properties()));
	//public static final DeferredHolder<EntityType<?>,EntityType<PiglichEntity>> PIGLICH = createMonsterEntity("piglich",PiglichEntity::new,0.6F,3.0F,0x000000,0xebe834);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
			.title(Component.translatable(Reference.tab()))
			.icon(() -> RAW_ALLTHEMODIUM.get().getDefaultInstance())
			.displayItems((parameters, output) -> ITEMS.getEntries().stream()
					.map(DeferredHolder::get)
					.map(Item::getDefaultInstance)
					.forEach(output::accept))
			.build()
	);



/*
	private static <T extends Monster> DeferredHolder<EntityType<T>, EntityType<PiglichEntity>> createMonsterEntity(String name, EntityType.EntityFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);

		return ENTITIES.register(name, () ->EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString()));
		//EntityType<T> entity = EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
		//Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()));
		//spawnEgg.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "_spawn_egg"));
		//SPAWN_EGGS.add(spawnEgg);

		//return ENTITIES.register(name, () -> entity);
	}

	private static <T extends AbstractGolem> RegistryObject<EntityType<T>> createShulkerEntity(String name, EntityType.EntityFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		EntityType<T> entity = EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
		Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()));
		spawnEgg.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "_spawn_egg"));
		SPAWN_EGGS.add(spawnEgg);

		return ENTITIES.register(name, () -> entity);
	}

 */

	@SubscribeEvent
	public static void addEntityAttributes(EntityAttributeCreationEvent event) {
		//event.put(PIGLICH.get(), PiglichEntity.createAttributes().build());
		//event.put(ATM_SHULKER.get(), UNOBShulkerEntity.createAttributes().build());
	}
	private static RotatedPillarBlock log(DyeColor color1, DyeColor color2) {
		return new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD));
	}




}
