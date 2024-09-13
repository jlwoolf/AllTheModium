package com.thevortex.allthemodium.registry;

import com.thevortex.allthemodium.blocks.*;
import com.thevortex.allthemodium.blocks.AllthemodiumBlock;
import com.thevortex.allthemodium.blocks.AllthemodiumOre;
import com.thevortex.allthemodium.blocks.TeleportPad;
import com.thevortex.allthemodium.blocks.UnobtainiumBlock;
import com.thevortex.allthemodium.blocks.UnobtainiumOre;
import com.thevortex.allthemodium.blocks.VibraniumBlock;
import com.thevortex.allthemodium.blocks.VibraniumOre;
import com.thevortex.allthemodium.blocks.entity.ATMBrushableBlockEntity;
import com.thevortex.allthemodium.entity.PiglichEntity;
import com.thevortex.allthemodium.init.ModFoods;
import com.thevortex.allthemodium.items.*;
import com.thevortex.allthemodium.items.toolitems.armor.*;
import com.thevortex.allthemodium.items.toolitems.tools.*;
import com.thevortex.allthemodium.material.AArmorMaterial;
import com.thevortex.allthemodium.material.ToolTiers;
import com.thevortex.allthemodium.reference.Reference;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSource;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.feature.Feature;

import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistry {

    public static final DeferredRegister<Block> SHAPED_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> STAIR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> WALL_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> SLAB_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Block> PILLAR_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Reference.MOD_ID);
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES,
            Reference.MOD_ID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);

    public static final DeferredRegister<BlockEntityType<?>> ENTITY = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITY_TYPES, Reference.MOD_ID);
    public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister
            .create(ForgeRegistries.WORLD_CARVERS, Reference.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister
            .create(ForgeRegistries.ENTITY_TYPES, Reference.MOD_ID);

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES,
            Reference.MOD_ID);

    // private static ArrayList<Item> SPAWN_EGGS = new ArrayList<Item>(); // TODO: Add spawn eggs

    // BIOMES
    RegistryObject<Biome> MINING = BIOMES.register("mining", () -> ATMBiomes.mining());

    // FOOD

    public static RegistryObject<Item> ALLTHEMODIUM_APPLE = ITEMS.register("allthemodium_apple",
            () -> new AllthemodiumApple(
                    new Item.Properties().fireResistant().food(ModFoods.ALLTHEMODIUM_APPLE).rarity(Rarity.EPIC)));
    public static RegistryObject<Item> ALLTHEMODIUM_CARROT = ITEMS.register("allthemodium_carrot",
            () -> new AllthemodiumCarrot(
                    new Item.Properties().fireResistant().food(ModFoods.ALLTHEMODIUM_CARROT).rarity(Rarity.EPIC)));

    // ARMORS

    public static RegistryObject<ArmorItem> ALLTHEMODIUM_BOOTS = ITEMS.register("allthemodium_boots",
            () -> (ArmorItem) new AllthemodiumBoots(AArmorMaterial.ALLTHEMODIUM, EquipmentSlot.FEET,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> ALLTHEMODIUM_LEGGINGS = ITEMS.register("allthemodium_leggings",
            () -> (ArmorItem) new AllthemodiumLeggings(AArmorMaterial.ALLTHEMODIUM, EquipmentSlot.LEGS,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> ALLTHEMODIUM_CHESTPLATE = ITEMS.register("allthemodium_chestplate",
            () -> (ArmorItem) new AllthemodiumChestplate(AArmorMaterial.ALLTHEMODIUM, EquipmentSlot.CHEST,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> ALLTHEMODIUM_HELMET = ITEMS.register("allthemodium_helmet",
            () -> (ArmorItem) new AllthemodiumHelmet(AArmorMaterial.ALLTHEMODIUM, EquipmentSlot.HEAD,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));

    public static RegistryObject<ArmorItem> VIBRANIUM_BOOTS = ITEMS.register("vibranium_boots",
            () -> (ArmorItem) new AllthemodiumBoots(AArmorMaterial.VIBRANIUM, EquipmentSlot.FEET,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> VIBRANIUM_LEGGINGS = ITEMS.register("vibranium_leggings",
            () -> new AllthemodiumLeggings(AArmorMaterial.VIBRANIUM, EquipmentSlot.LEGS,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> VIBRANIUM_CHESTPLATE = ITEMS.register("vibranium_chestplate",
            () -> (ArmorItem) new AllthemodiumChestplate(AArmorMaterial.VIBRANIUM, EquipmentSlot.CHEST,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> VIBRANIUM_HELMET = ITEMS.register("vibranium_helmet",
            () -> new AllthemodiumHelmet(AArmorMaterial.VIBRANIUM, EquipmentSlot.HEAD,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));

    public static RegistryObject<ArmorItem> UNOBTAINIUM_BOOTS = ITEMS.register("unobtainium_boots",
            () -> (ArmorItem) new AllthemodiumBoots(AArmorMaterial.UNOBTAINIUM, EquipmentSlot.FEET,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> UNOBTAINIUM_LEGGINGS = ITEMS.register("unobtainium_leggings",
            () -> new AllthemodiumLeggings(AArmorMaterial.UNOBTAINIUM, EquipmentSlot.LEGS,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> UNOBTAINIUM_CHESTPLATE = ITEMS.register("unobtainium_chestplate",
            () -> (ArmorItem) new AllthemodiumChestplate(AArmorMaterial.UNOBTAINIUM, EquipmentSlot.CHEST,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));
    public static RegistryObject<ArmorItem> UNOBTAINIUM_HELMET = ITEMS.register("unobtainium_helmet",
            () -> new AllthemodiumHelmet(AArmorMaterial.UNOBTAINIUM, EquipmentSlot.HEAD,
                    new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC)));

    //Volcano

    public static final RegistryObject<AncientCaveVines> ANCIENT_CAVEVINES_ = PILLAR_BLOCKS.register(
            "ancient_cavevines",
            () -> new AncientCaveVines(BlockBehaviour.Properties.of()
                    .randomTicks()
                    .noCollission()
                    .noOcclusion()
                    .lightLevel(ACaveVines.emission(14))
                    .instabreak()
                    .sound(SoundType.CAVE_VINES), Direction.DOWN, ACaveVines.SHAPE, false, 0.1D));

    public static final RegistryObject<AncientCaveVinesPlant> ANCIENT_CAVEVINES_PLANT_ = PILLAR_BLOCKS
            .register("ancient_cavevines_plant", () -> new AncientCaveVinesPlant(BlockBehaviour.Properties.of()
                    .noCollission()
                    .noOcclusion()
                    .lightLevel(ACaveVines.emission(14))
                    .instabreak()
                    .sound(SoundType.CAVE_VINES), Direction.DOWN, ACaveVines.SHAPE, false));

    public static final RegistryObject<Block> PIGLICH_HEART_BLOCK = BLOCKS.register("piglich_heart_block",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST)));
    public static final RegistryObject<Item> PIGLICH_HEART_BLOCK_ITEM = ITEMS.register("piglich_heart_block",
            () -> new BlockItem(PIGLICH_HEART_BLOCK.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Block> ANCIENT_HERB = PILLAR_BLOCKS.register("ancient_herb",
            () -> new AncientHerb(
                    BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));

    public static final RegistryObject<Block> ANCIENT_SMOOTH_STONE = BLOCKS.register("ancient_smooth_stone",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(2.25f)));
    public static final RegistryObject<Block> ANCIENT_STONE = BLOCKS.register("ancient_stone",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(1.5f)));
    public static final RegistryObject<Block> ANCIENT_DIRT = BLOCKS.register("ancient_dirt",
            () -> new AncientDirt(BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).strength(0.6f)));
    public static final RegistryObject<Block> ANCIENT_GRASS = BLOCKS.register("ancient_grass",
            () -> new AncientGrass(BlockBehaviour.Properties.of().sound(SoundType.MOSS).strength(0.6f)));
    public static final RegistryObject<Block> ANCIENT_MOSSY_STONE = BLOCKS.register("ancient_mossy_stone",
            () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.MOSS_CARPET).strength(1.5f)));
    public static final RegistryObject<Block> ANCIENT_STONE_BRICKS = BLOCKS.register("ancient_stone_bricks",
            () -> new AncientStone());
    public static final RegistryObject<Block> ANCIENT_CHISELED_STONE_BRICKS = BLOCKS
            .register("ancient_chiseled_stone_bricks", () -> new AncientStone());
    public static final RegistryObject<Block> ANCIENT_CRACKED_STONE_BRICKS = BLOCKS
            .register("ancient_cracked_stone_bricks", () -> new AncientStone());
    public static final RegistryObject<Block> ANCIENT_POLISHED_STONE = BLOCKS.register("ancient_polished_stone",
            () -> new AncientStone());

    public static final RegistryObject<Block> ANCIENT_LOG_0 = PILLAR_BLOCKS.register("ancient_log_0",
            () -> log(DyeColor.BLUE, DyeColor.BLUE));
    public static final RegistryObject<Block> ANCIENT_LOG_1 = PILLAR_BLOCKS.register("ancient_log_1",
            () -> log(DyeColor.BLUE, DyeColor.BLUE));
    public static final RegistryObject<Block> ANCIENT_LOG_2 = PILLAR_BLOCKS.register("ancient_log_2",
            () -> log(DyeColor.BLUE, DyeColor.BLUE));
    public static final RegistryObject<Block> ANCIENT_LOG_STRIPPED = PILLAR_BLOCKS.register("stripped_ancient_log",
            () -> log(DyeColor.BLUE, DyeColor.BLUE));
    public static final RegistryObject<Block> ANCIENT_LEAVES = BLOCKS.register("ancient_leaves",
            () -> new AncientLeaves(BlockBehaviour.Properties.of().strength(0.2F).randomTicks()
                    .sound(SoundType.AZALEA_LEAVES).noOcclusion().mapColor(DyeColor.PURPLE)));
    public static final RegistryObject<Block> ANCIENT_LEAVES_BOTTOM = PILLAR_BLOCKS.register("ancient_leaves_bottom",
            () -> new AncientLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks()
                    .sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
    public static final RegistryObject<Block> ANCIENT_PLANKS = BLOCKS.register("ancient_planks",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final RegistryObject<TrapDoorBlock> ANCIENT_TRAPDOOR = PILLAR_BLOCKS.register("ancient_trap_door",
            () -> new TrapDoorBlock(
                    BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion(),
                    ATMBlockSets.ANCIENT));
    public static final RegistryObject<FenceBlock> ANCIENT_WOOD_FENCE = PILLAR_BLOCKS.register("ancient_wooden_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final RegistryObject<FenceGateBlock> ANCIENT_WOOD_FENCE_GATE = PILLAR_BLOCKS.register(
            "ancient_wooden_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD),
                    ATMBlockSets.ANCIENTWOOD));
    public static final RegistryObject<DoorBlock> ANCIENT_DOOR_ = PILLAR_BLOCKS.register("ancient_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD),
                    ATMBlockSets.ANCIENT));

    public static final RegistryObject<Block> DEMONIC_HERB = PILLAR_BLOCKS.register("demonic_herb",
            () -> new AncientHerb(
                    BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));
    public static final RegistryObject<Block> DEMONIC_LOG = PILLAR_BLOCKS.register("demonic_log",
            () -> log(DyeColor.RED, DyeColor.RED));
    public static final RegistryObject<Block> DEMONIC_LOG_STRIPPED = PILLAR_BLOCKS.register("stripped_demonic_log",
            () -> log(DyeColor.RED, DyeColor.RED));
    public static final RegistryObject<Block> DEMONIC_LEAVES = BLOCKS.register("demonic_leaves",
            () -> new DemonicLeaves(BlockBehaviour.Properties.of().strength(0.2F).randomTicks()
                    .sound(SoundType.AZALEA_LEAVES).noOcclusion()));
    public static final RegistryObject<Block> DEMONIC_LEAVES_BOTTOM = PILLAR_BLOCKS.register("demonic_leaves_bottom",
            () -> new DemonicLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks()
                    .sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
    public static final RegistryObject<Block> DEMONIC_PLANKS = BLOCKS.register("demonic_planks",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final RegistryObject<TrapDoorBlock> DEMONIC_TRAPDOOR = PILLAR_BLOCKS.register("demonic_trap_door",
            () -> new TrapDoorBlock(
                    BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion(),
                    ATMBlockSets.DEMONIC));
    public static final RegistryObject<FenceBlock> DEMONIC_WOOD_FENCE = PILLAR_BLOCKS.register("demonic_wooden_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final RegistryObject<FenceGateBlock> DEMONIC_WOOD_FENCE_GATE = PILLAR_BLOCKS.register(
            "demonic_wooden_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD),
                    ATMBlockSets.DEMONICWOOD));
    public static final RegistryObject<DoorBlock> DEMONIC_DOOR_ = PILLAR_BLOCKS.register("demonic_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD),
                    ATMBlockSets.DEMONIC));

    public static final RegistryObject<Block> SOUL_HERB = PILLAR_BLOCKS.register("soul_herb", () -> new AncientHerb(
            BlockBehaviour.Properties.of().sound(SoundType.WET_GRASS).instabreak().noCollission()));
    public static final RegistryObject<Block> SOUL_LOG = PILLAR_BLOCKS.register("soul_log",
            () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> SOUL_LOG_0 = PILLAR_BLOCKS.register("soul_log_0",
            () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> SOUL_LOG_1 = PILLAR_BLOCKS.register("soul_log_1",
            () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> SOUL_LOG_2 = PILLAR_BLOCKS.register("soul_log_2",
            () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> SOUL_LOG_STRIPPED = PILLAR_BLOCKS.register("stripped_soul_log",
            () -> log(DyeColor.LIGHT_BLUE, DyeColor.LIGHT_BLUE));
    public static final RegistryObject<Block> SOUL_LEAVES = BLOCKS.register("soul_leaves", () -> new SoulLeaves(
            BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion()));
    public static final RegistryObject<Block> SOUL_LEAVES_BOTTOM = PILLAR_BLOCKS.register("soul_leaves_bottom",
            () -> new SoulLeavesBottom(BlockBehaviour.Properties.of().strength(0.2F).randomTicks()
                    .sound(SoundType.AZALEA_LEAVES).noCollission().noOcclusion()));
    public static final RegistryObject<Block> SOUL_PLANKS = BLOCKS.register("soul_planks",
            () -> new Block(BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final RegistryObject<TrapDoorBlock> SOUL_TRAPDOOR = PILLAR_BLOCKS.register("soul_trap_door",
            () -> new TrapDoorBlock(
                    BlockBehaviour.Properties.of().strength(0.2F).randomTicks().sound(SoundType.WOOD).noOcclusion(),
                    ATMBlockSets.SOUL));
    public static final RegistryObject<FenceBlock> SOUL_WOOD_FENCE = PILLAR_BLOCKS.register("soul_wooden_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD)));
    public static final RegistryObject<FenceGateBlock> SOUL_WOOD_FENCE_GATE = PILLAR_BLOCKS.register(
            "soul_wooden_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().strength(0.8F).dynamicShape().sound(SoundType.WOOD),
                    ATMBlockSets.SOULWOOD));
    public static final RegistryObject<DoorBlock> SOUL_DOOR_ = PILLAR_BLOCKS.register("soul_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD),
                    ATMBlockSets.SOUL));

    public static final RegistryObject<WallBlock> ANCIENT_STONE_WALL = WALL_BLOCKS.register("ancient_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));
    public static final RegistryObject<WallBlock> ANCIENT_SMOOTH_STONE_WALL = WALL_BLOCKS.register(
            "ancient_smooth_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ANCIENT_SMOOTH_STONE.get())));
    public static final RegistryObject<WallBlock> ANCIENT_POLISHED_STONE_WALL = WALL_BLOCKS.register(
            "ancient_polished_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ANCIENT_POLISHED_STONE.get())));
    public static final RegistryObject<WallBlock> ANCIENT_STONE_BRICK_WALL = WALL_BLOCKS.register(
            "ancient_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ANCIENT_STONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> ANCIENT_CHISELED_STONE_BRICK_WALL = WALL_BLOCKS.register(
            "ancient_chiseled_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ANCIENT_CHISELED_STONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> ANCIENT_CRACKED_STONE_BRICK_WALL = WALL_BLOCKS.register(
            "ancient_cracked_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(ANCIENT_CRACKED_STONE_BRICKS.get())));
    public static final RegistryObject<WallBlock> ANCIENT_MOSSY_STONE_WALL = WALL_BLOCKS.register(
            "ancient_mossy_stone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));

    public static final RegistryObject<Item> ANCIENT_CAVEVINE_PLANT_ITEM = ITEMS.register("ancient_cavevines_plant",
            () -> new BlockItem(ANCIENT_CAVEVINES_PLANT_.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_SOULBERRY = ITEMS.register("ancient_soulberries",
            () -> new SoulBerries(ANCIENT_CAVEVINES_.get(), (new Item.Properties()).food(ModFoods.SOUL_BERRIES)));
    public static final RegistryObject<Item> ANCIENT_TRAP_DOOR_ITEM = ITEMS.register("ancient_trap_door",
            () -> new BlockItem(ANCIENT_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_TRAP_DOOR_ITEM = ITEMS.register("demonic_trap_door",
            () -> new BlockItem(DEMONIC_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_TRAP_DOOR_ITEM = ITEMS.register("soul_trap_door",
            () -> new BlockItem(SOUL_TRAPDOOR.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_DOOR_ITEM = ITEMS.register("ancient_door",
            () -> new BlockItem(ANCIENT_DOOR_.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_DOOR_ITEM = ITEMS.register("demonic_door",
            () -> new BlockItem(DEMONIC_DOOR_.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_DOOR_ITEM = ITEMS.register("soul_door",
            () -> new BlockItem(SOUL_DOOR_.get(), new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_STONE_WALL_ITEM = ITEMS.register("ancient_stone_wall",
            () -> new BlockItem(ANCIENT_STONE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_WALL_ITEM = ITEMS.register(
            "ancient_smooth_stone_wall", () -> new BlockItem(ANCIENT_SMOOTH_STONE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_WALL_ITEM = ITEMS.register(
            "ancient_polished_stone_wall",
            () -> new BlockItem(ANCIENT_POLISHED_STONE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_STONE_BRICK_WALL_ITEM = ITEMS.register("ancient_stone_brick_wall",
            () -> new BlockItem(ANCIENT_STONE_BRICK_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_BRICK_WALL_ITEM = ITEMS.register(
            "ancient_chiseled_stone_brick_wall",
            () -> new BlockItem(ANCIENT_CHISELED_STONE_BRICK_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_BRICK_WALL_ITEM = ITEMS.register(
            "ancient_cracked_stone_brick_wall",
            () -> new BlockItem(ANCIENT_CRACKED_STONE_BRICK_WALL.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_WALL_ITEM = ITEMS.register("ancient_mossy_stone_wall",
            () -> new BlockItem(ANCIENT_MOSSY_STONE_WALL.get(), new Item.Properties()));

    public static final RegistryObject<Block> ANCIENT_BOOKSHELF = PILLAR_BLOCKS.register("ancient_bookshelf",
            () -> new AncientBookShelf(
                    BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DEMONIC_BOOKSHELF = PILLAR_BLOCKS.register("demonic_bookshelf",
            () -> new AncientBookShelf(
                    BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SOUL_BOOKSHELF = PILLAR_BLOCKS.register("soul_bookshelf",
            () -> new AncientBookShelf(
                    BlockBehaviour.Properties.of().strength(0.8F).randomTicks().sound(SoundType.WOOD)));

    public static final RegistryObject<StairBlock> ANCIENT_WOODEN_STAIRS = STAIR_BLOCKS.register(
            "ancient_wooden_stairs",
            () -> new StairBlock(() -> ANCIENT_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_PLANKS.get())));
    public static final RegistryObject<StairBlock> DEMONIC_WOODEN_STAIRS = STAIR_BLOCKS.register(
            "demonic_wooden_stairs",
            () -> new StairBlock(() -> DEMONIC_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(DEMONIC_PLANKS.get())));
    public static final RegistryObject<StairBlock> SOUL_WOODEN_STAIRS = STAIR_BLOCKS.register("soul_wooden_stairs",
            () -> new StairBlock(() -> SOUL_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(SOUL_PLANKS.get())));
    public static final RegistryObject<StairBlock> ANCIENT_STONE_STAIRS = STAIR_BLOCKS.register("ancient_stone_stairs",
            () -> new StairBlock(() -> ANCIENT_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_SMOOTH_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_smooth_stone_stairs", () -> new StairBlock(() -> ANCIENT_SMOOTH_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_SMOOTH_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_STONE_BRICK_STAIRS = STAIR_BLOCKS.register(
            "ancient_stone_brick_stairs", () -> new StairBlock(() -> ANCIENT_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));

    public static final RegistryObject<StairBlock> ANCIENT_MOSSY_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_mossy_stone_stairs", () -> new StairBlock(() -> ANCIENT_MOSSY_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_CHISELED_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_chiseled_stone_brick_stairs",
            () -> new StairBlock(() -> ANCIENT_CHISELED_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_CRACKED_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_cracked_stone_brick_stairs",
            () -> new StairBlock(() -> ANCIENT_CRACKED_STONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<StairBlock> ANCIENT_POLISHED_STONE_STAIRS = STAIR_BLOCKS.register(
            "ancient_polished_stone_stairs",
            () -> new StairBlock(() -> ANCIENT_POLISHED_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));

    public static final RegistryObject<SlabBlock> ANCIENT_WOODEN_SLABS = SLAB_BLOCKS.register("ancient_wooden_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ANCIENT_PLANKS.get())));
    public static final RegistryObject<SlabBlock> DEMONIC_WOODEN_SLABS = SLAB_BLOCKS.register("demonic_wooden_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(DEMONIC_PLANKS.get())));
    public static final RegistryObject<SlabBlock> SOUL_WOODEN_SLABS = SLAB_BLOCKS.register("soul_wooden_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(SOUL_PLANKS.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_STONE_SLABS = SLAB_BLOCKS.register("ancient_stone_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_SMOOTH_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_smooth_stone_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ANCIENT_SMOOTH_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_STONE_BRICK_SLABS = SLAB_BLOCKS.register(
            "ancient_stone_brick_slabs", () -> new SlabBlock(BlockBehaviour.Properties.copy(ANCIENT_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_MOSSY_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_mossy_stone_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_CHISELED_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_chiseled_stone_brick_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_CRACKED_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_cracked_stone_brick_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));
    public static final RegistryObject<SlabBlock> ANCIENT_POLISHED_STONE_SLABS = SLAB_BLOCKS.register(
            "ancient_polished_stone_slabs",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(ANCIENT_MOSSY_STONE.get())));

    public static final RegistryObject<Item> ANCIENT_WOODEN_SLABS_ITEM = ITEMS.register("ancient_wooden_slabs",
            () -> new BlockItem(ANCIENT_WOODEN_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_WOODEN_SLABS_ITEM = ITEMS.register("demonic_wooden_slabs",
            () -> new BlockItem(DEMONIC_WOODEN_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_WOODEN_SLABS_ITEM = ITEMS.register("soul_wooden_slabs",
            () -> new BlockItem(SOUL_WOODEN_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_STONE_SLABS_ITEM = ITEMS.register("ancient_stone_slabs",
            () -> new BlockItem(ANCIENT_STONE_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_smooth_stone_slabs", () -> new BlockItem(ANCIENT_SMOOTH_STONE_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_STONE_BRICK_SLABS_ITEM = ITEMS.register(
            "ancient_stone_brick_slabs", () -> new BlockItem(ANCIENT_STONE_BRICK_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_mossy_stone_slabs", () -> new BlockItem(ANCIENT_MOSSY_STONE_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_chiseled_stone_brick_slabs",
            () -> new BlockItem(ANCIENT_CHISELED_STONE_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_cracked_stone_brick_slabs",
            () -> new BlockItem(ANCIENT_CRACKED_STONE_SLABS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_SLABS_ITEM = ITEMS.register(
            "ancient_polished_stone_slabs",
            () -> new BlockItem(ANCIENT_POLISHED_STONE_SLABS.get(), new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_HERB_ITEM = ITEMS.register("ancient_herb",
            () -> new BlockItem(ANCIENT_HERB.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_HERB_ITEM = ITEMS.register("demonic_herb",
            () -> new BlockItem(DEMONIC_HERB.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_HERB_ITEM = ITEMS.register("soul_herb",
            () -> new BlockItem(SOUL_HERB.get(), new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_LOG_0_ITEM = ITEMS.register("ancient_log_0",
            () -> new BlockItem(ANCIENT_LOG_0.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_LOG_1_ITEM = ITEMS.register("ancient_log_1",
            () -> new BlockItem(ANCIENT_LOG_1.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_LOG_2_ITEM = ITEMS.register("ancient_log_2",
            () -> new BlockItem(ANCIENT_LOG_2.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_LOG_STRIPPED_ITEM = ITEMS.register("stripped_ancient_log",
            () -> new BlockItem(ANCIENT_LOG_STRIPPED.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_LEAVES_ITEM = ITEMS.register("ancient_leaves",
            () -> new BlockItem(ANCIENT_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_PLANKS_ITEM = ITEMS.register("ancient_planks",
            () -> new BlockItem(ANCIENT_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_BOOKSHELF_ITEM = ITEMS.register("ancient_bookshelf",
            () -> new BlockItem(ANCIENT_BOOKSHELF.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_LOG_ITEM = ITEMS.register("soul_log",
            () -> new BlockItem(SOUL_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_LOG_0_ITEM = ITEMS.register("soul_log_0",
            () -> new BlockItem(SOUL_LOG_0.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_LOG_1_ITEM = ITEMS.register("soul_log_1",
            () -> new BlockItem(SOUL_LOG_1.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_LOG_2_ITEM = ITEMS.register("soul_log_2",
            () -> new BlockItem(SOUL_LOG_2.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_LOG_STRIPPED_ITEM = ITEMS.register("stripped_soul_log",
            () -> new BlockItem(SOUL_LOG_STRIPPED.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_LEAVES_ITEM = ITEMS.register("soul_leaves",
            () -> new BlockItem(SOUL_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_PLANKS_ITEM = ITEMS.register("soul_planks",
            () -> new BlockItem(SOUL_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_BOOKSHELF_ITEM = ITEMS.register("soul_bookshelf",
            () -> new BlockItem(SOUL_BOOKSHELF.get(), new Item.Properties()));

    public static final RegistryObject<Item> DEMONIC_LOG_ITEM = ITEMS.register("demonic_log",
            () -> new BlockItem(DEMONIC_LOG.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_LOG_STRIPPED_ITEM = ITEMS.register("stripped_demonic_log",
            () -> new BlockItem(DEMONIC_LOG_STRIPPED.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_LEAVES_ITEM = ITEMS.register("demonic_leaves",
            () -> new BlockItem(DEMONIC_LEAVES.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_PLANKS_ITEM = ITEMS.register("demonic_planks",
            () -> new BlockItem(DEMONIC_PLANKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_BOOKSHELF_ITEM = ITEMS.register("demonic_bookshelf",
            () -> new BlockItem(DEMONIC_BOOKSHELF.get(), new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_WOODEN_STAIRS_ITEM = ITEMS.register("ancient_wooden_stairs",
            () -> new BlockItem(ANCIENT_WOODEN_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_WOODEN_STAIRS_ITEM = ITEMS.register("demonic_wooden_stairs",
            () -> new BlockItem(DEMONIC_WOODEN_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_WOODEN_STAIRS_ITEM = ITEMS.register("soul_wooden_stairs",
            () -> new BlockItem(SOUL_WOODEN_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_STONE_STAIRS_ITEM = ITEMS.register("ancient_stone_stairs",
            () -> new BlockItem(ANCIENT_STONE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_smooth_stone_stairs",
            () -> new BlockItem(ANCIENT_SMOOTH_STONE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_STONE_BRICK_STAIRS_ITEM = ITEMS.register(
            "ancient_stone_brick_stairs", () -> new BlockItem(ANCIENT_STONE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_mossy_stone_stairs", () -> new BlockItem(ANCIENT_MOSSY_STONE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_chiseled_stone_brick_stairs",
            () -> new BlockItem(ANCIENT_CHISELED_STONE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_cracked_stone_brick_stairs",
            () -> new BlockItem(ANCIENT_CRACKED_STONE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_STAIRS_ITEM = ITEMS.register(
            "ancient_polished_stone_stairs",
            () -> new BlockItem(ANCIENT_POLISHED_STONE_STAIRS.get(), new Item.Properties()));

    public static final RegistryObject<Item> ANCIENT_WOOD_FENCE_ITEM = ITEMS.register("ancient_wooden_fence",
            () -> new BlockItem(ANCIENT_WOOD_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_WOOD_FENCE_GATE_ITEM = ITEMS.register("ancient_wooden_fence_gate",
            () -> new BlockItem(ANCIENT_WOOD_FENCE_GATE.get(), new Item.Properties()));;
    public static final RegistryObject<Item> DEMONIC_WOOD_FENCE_ITEM = ITEMS.register("demonic_wooden_fence",
            () -> new BlockItem(DEMONIC_WOOD_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> DEMONIC_WOOD_FENCE_GATE_ITEM = ITEMS.register("demonic_wooden_fence_gate",
            () -> new BlockItem(DEMONIC_WOOD_FENCE_GATE.get(), new Item.Properties()));;
    public static final RegistryObject<Item> SOUL_WOOD_FENCE_ITEM = ITEMS.register("soul_wooden_fence",
            () -> new BlockItem(SOUL_WOOD_FENCE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SOUL_WOOD_FENCE_GATE_ITEM = ITEMS.register("soul_wooden_fence_gate",
            () -> new BlockItem(SOUL_WOOD_FENCE_GATE.get(), new Item.Properties()));;

    public static final RegistryObject<Item> ANCIENT_SMOOTH_STONE_ITEM = ITEMS.register("ancient_smooth_stone",
            () -> new BlockItem(ANCIENT_SMOOTH_STONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_STONE_ITEM = ITEMS.register("ancient_stone",
            () -> new BlockItem(ANCIENT_STONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_DIRT_ITEM = ITEMS.register("ancient_dirt",
            () -> new BlockItem(ANCIENT_DIRT.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_GRASS_ITEM = ITEMS.register("ancient_grass",
            () -> new BlockItem(ANCIENT_GRASS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_MOSSY_STONE_ITEM = ITEMS.register("ancient_mossy_stone",
            () -> new BlockItem(ANCIENT_MOSSY_STONE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_STONE_BRICKS_ITEM = ITEMS.register("ancient_stone_bricks",
            () -> new BlockItem(ANCIENT_STONE_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_CHISELED_STONE_BRICKS_ITEM = ITEMS.register(
            "ancient_chiseled_stone_bricks",
            () -> new BlockItem(ANCIENT_CHISELED_STONE_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_CRACKED_STONE_BRICKS_ITEM = ITEMS.register(
            "ancient_cracked_stone_bricks",
            () -> new BlockItem(ANCIENT_CRACKED_STONE_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_POLISHED_STONE_ITEM = ITEMS.register("ancient_polished_stone",
            () -> new BlockItem(ANCIENT_POLISHED_STONE.get(), new Item.Properties()));

    public static final RegistryObject<AllthemodiumOre> ALLTHEMODIUM_ORE = BLOCKS.register("allthemodium_ore",
            AllthemodiumOre::new);
    public static final RegistryObject<AllthemodiumOre> ALLTHEMODIUM_SLATE_ORE = BLOCKS
            .register("allthemodium_slate_ore", AllthemodiumOre::new);

    public static final RegistryObject<Block> VIBRANIUM_ORE = BLOCKS.register("vibranium_ore", VibraniumOre::new);
    public static final RegistryObject<Block> OTHER_VIBRANIUM_ORE = BLOCKS.register("other_vibranium_ore",
            VibraniumOre::new);
    public static final RegistryObject<Block> UNOBTAINIUM_ORE = BLOCKS.register("unobtainium_ore",
            UnobtainiumOre::new);

    public static final RegistryObject<Block> ALLTHEMODIUM_BLOCK = BLOCKS.register("allthemodium_block",
            AllthemodiumBlock::new);
    public static final RegistryObject<Block> VIBRANIUM_BLOCK = BLOCKS.register("vibranium_block",
            VibraniumBlock::new);
    public static final RegistryObject<Block> UNOBTAINIUM_BLOCK = BLOCKS.register("unobtainium_block",
            UnobtainiumBlock::new);

    public static final RegistryObject<Block> RAW_ALLTHEMODIUM_BLOCK = BLOCKS.register("raw_allthemodium_block",
            RawATM::new);
    public static final RegistryObject<Block> RAW_VIBRANIUM_BLOCK = BLOCKS.register("raw_vibranium_block",
            RawVIB::new);
    public static final RegistryObject<Block> RAW_UNOBTAINIUM_BLOCK = BLOCKS.register("raw_unobtainium_block",
            RawUNO::new);

    public static final RegistryObject<Item> RAW_ALLTHEMODIUM_BLOCK_ITEM = ITEMS.register("raw_allthemodium_block",
            () -> new BlockItem(RAW_ALLTHEMODIUM_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAW_VIBRANIUM_BLOCK_ITEM = ITEMS.register("raw_vibranium_block",
            () -> new BlockItem(RAW_VIBRANIUM_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> RAW_UNOBTAINIUM_BLOCK_ITEM = ITEMS.register("raw_unobtainium_block",
            () -> new BlockItem(RAW_UNOBTAINIUM_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> ALLTHEMODIUM_ORE_ITEM = ITEMS.register("allthemodium_ore",
            () -> new AllthemodiumOreItem(ALLTHEMODIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> ALLTHEMODIUM_SLATE_ORE_ITEM = ITEMS.register("allthemodium_slate_ore",
            () -> new AllthemodiumOreItem(ALLTHEMODIUM_SLATE_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> VIBRANIUM_ORE_ITEM = ITEMS.register("vibranium_ore",
            () -> new VibraniumOreItem(VIBRANIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> OTHER_VIBRANIUM_ORE_ITEM = ITEMS.register("other_vibranium_ore",
            () -> new VibraniumOreItem(OTHER_VIBRANIUM_ORE.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_ORE_ITEM = ITEMS.register("unobtainium_ore",
            () -> new UnobtainiumOreItem(UNOBTAINIUM_ORE.get(), new Item.Properties()));

    public static final RegistryObject<Item> ALLTHEMODIUM_BLOCK_ITEM = ITEMS.register("allthemodium_block",
            () -> new BlockItem(ALLTHEMODIUM_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> VIBRANIUM_BLOCK_ITEM = ITEMS.register("vibranium_block",
            () -> new BlockItem(VIBRANIUM_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_BLOCK_ITEM = ITEMS.register("unobtainium_block",
            () -> new BlockItem(UNOBTAINIUM_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> RAW_ALLTHEMODIUM = ITEMS.register("raw_allthemodium",
            () -> new RawOre(new Item.Properties()));
    public static final RegistryObject<Item> RAW_VIBRANIUM = ITEMS.register("raw_vibranium",
            () -> new RawOre(new Item.Properties()));
    public static final RegistryObject<Item> RAW_UNOBTAINIUM = ITEMS.register("raw_unobtainium",
            () -> new RawOre(new Item.Properties()));

    public static final RegistryObject<Item> SUS_CLAY_ITEM = ITEMS.register("suspicious_clay",
            () -> new BlockItem(BlockRegistry.SUS_CLAY.get(), new Item.Properties()));
    public static final RegistryObject<Item> SUS_SOUL_SAND_ITEM = ITEMS.register("suspicious_soul_sand",
            () -> new BlockItem(BlockRegistry.SUS_SOUL_SAND.get(), new Item.Properties()));
            
    @SuppressWarnings("null")
    public static final RegistryObject<BlockEntityType<ATMBrushableBlockEntity>> BRUSHABLE_BLOCK = ENTITY
            .register("brushable_block", () -> BlockEntityType.Builder.of(ATMBrushableBlockEntity::new,
                    BlockRegistry.SUS_CLAY.get(),
                    BlockRegistry.SUS_SOUL_SAND.get()).build(null));

    public static final RegistryObject<Item> ALLTHEMODIUM_INGOT = ITEMS.register("allthemodium_ingot",
            () -> new Ingot(new Item.Properties()));
    public static final RegistryObject<Item> VIBRANIUM_INGOT = ITEMS.register("vibranium_ingot",
            () -> new Ingot(new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_INGOT = ITEMS.register("unobtainium_ingot",
            () -> new Ingot(new Item.Properties()));
    public static final RegistryObject<Item> ATM_PLATE = ITEMS.register("allthemodium_plate",
            () -> new Plate(new Item.Properties()));
    public static final RegistryObject<Item> VIB_PLATE = ITEMS.register("vibranium_plate",
            () -> new Plate(new Item.Properties()));
    public static final RegistryObject<Item> UNOB_PLATE = ITEMS.register("unobtainium_plate",
            () -> new Plate(new Item.Properties()));

    public static final RegistryObject<Item> ATM_GEAR = ITEMS.register("allthemodium_gear",
            () -> new Gear(new Item.Properties()));
    public static final RegistryObject<Item> VIB_GEAR = ITEMS.register("vibranium_gear",
            () -> new Gear(new Item.Properties()));
    public static final RegistryObject<Item> UNOB_GEAR = ITEMS.register("unobtainium_gear",
            () -> new Gear(new Item.Properties()));

    public static final RegistryObject<Item> ATM_ROD = ITEMS.register("allthemodium_rod",
            () -> new Rod(new Item.Properties()));
    public static final RegistryObject<Item> VIB_ROD = ITEMS.register("vibranium_rod",
            () -> new Rod(new Item.Properties()));
    public static final RegistryObject<Item> UNOB_ROD = ITEMS.register("unobtainium_rod",
            () -> new Rod(new Item.Properties()));

    public static final RegistryObject<Item> ALLTHEMODIUM_NUGGET = ITEMS.register("allthemodium_nugget",
            () -> new Nugget(new Item.Properties()));
    public static final RegistryObject<Item> VIBRANIUM_NUGGET = ITEMS.register("vibranium_nugget",
            () -> new Nugget(new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_NUGGET = ITEMS.register("unobtainium_nugget",
            () -> new Nugget(new Item.Properties()));

    public static final RegistryObject<Item> ALLTHEMODIUM_DUST = ITEMS.register("allthemodium_dust",
            () -> new Dust(new Item.Properties()));
    public static final RegistryObject<Item> VIBRANIUM_DUST = ITEMS.register("vibranium_dust",
            () -> new Dust(new Item.Properties()));
    public static final RegistryObject<Item> UNOBTAINIUM_DUST = ITEMS.register("unobtainium_dust",
            () -> new Dust(new Item.Properties()));

    public static final RegistryObject<Item> ATM_CLUMP = ITEMS.register("allthemodium_clump",
            () -> new Clump(new Item.Properties()));
    public static final RegistryObject<Item> VIB_CLUMP = ITEMS.register("vibranium_clump",
            () -> new Clump(new Item.Properties()));
    public static final RegistryObject<Item> UNOB_CLUMP = ITEMS.register("unobtainium_clump",
            () -> new Clump(new Item.Properties()));

    public static final RegistryObject<Item> ATM_SHARD = ITEMS.register("allthemodium_shard",
            () -> new Shard(new Item.Properties()));
    public static final RegistryObject<Item> VIB_SHARD = ITEMS.register("vibranium_shard",
            () -> new Shard(new Item.Properties()));
    public static final RegistryObject<Item> UNOB_SHARD = ITEMS.register("unobtainium_shard",
            () -> new Shard(new Item.Properties()));

    public static final RegistryObject<Item> ATM_DIRTY = ITEMS.register("dirty_allthemodium_dust",
            () -> new DirtyDust(new Item.Properties()));
    public static final RegistryObject<Item> VIB_DIRTY = ITEMS.register("dirty_vibranium_dust",
            () -> new DirtyDust(new Item.Properties()));
    public static final RegistryObject<Item> UNOB_DIRTY = ITEMS.register("dirty_unobtainium_dust",
            () -> new DirtyDust(new Item.Properties()));

    public static final RegistryObject<Item> ATM_CRYSTAL = ITEMS.register("allthemodium_crystal",
            () -> new Crystal(new Item.Properties()));
    public static final RegistryObject<Item> VIB_CRYSTAL = ITEMS.register("vibranium_crystal",
            () -> new Crystal(new Item.Properties()));
    public static final RegistryObject<Item> UNOB_CRYSTAL = ITEMS.register("unobtainium_crystal",
            () -> new Crystal(new Item.Properties()));

    public static final RegistryObject<Item> UNOBTAINIUM_ALLTHEMODIUM_DUST = ITEMS.register(
            "unobtainium_allthemodium_alloy_dust", () -> new Alloy_Dust(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> UNOBTAINIUM_VIBRANIUM_DUST = ITEMS
            .register("unobtainium_vibranium_alloy_dust", () -> new Alloy_Dust(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VIBRANIUM_ALLTHEMODIUM_DUST = ITEMS
            .register("vibranium_allthemodium_alloy_dust", () -> new Alloy_Dust(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> UNOBTAINIUM_ALLTHEMODIUM_ALLOY = ITEMS.register(
            "unobtainium_allthemodium_alloy_ingot", () -> new Alloy_Ingot(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> UNOBTAINIUM_VIBRANIUM_ALLOY = ITEMS.register(
            "unobtainium_vibranium_alloy_ingot", () -> new Alloy_Ingot(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> VIBRANIUM_ALLTHEMODIUM_ALLOY = ITEMS.register(
            "vibranium_allthemodium_alloy_ingot", () -> new Alloy_Ingot(new Item.Properties().fireResistant()));

    public static final RegistryObject<Block> TELEPORT_PAD = SHAPED_BLOCKS.register("teleport_pad",
            () -> new TeleportPad(Block.Properties.of().noLootTable().noOcclusion().strength(20.0F)));
    public static final RegistryObject<Item> TELEPORT_PAD_ITEM = ITEMS.register("teleport_pad",
            () -> new BlockItem(TELEPORT_PAD.get(), new Item.Properties()));

    public static final RegistryObject<SwordItem> ALLTHEMODIUM_SWORD = ITEMS.register("allthemodium_sword",
            () -> new SwordItem(ToolTiers.ALLTHEMODIUM_TIER, 4, 1.5f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

            });

    public static final RegistryObject<PickaxeItem> ALLTHEMODIUM_PICKAXE = ITEMS.register("allthemodium_pickaxe",
            () -> new PickaxeItem(ToolTiers.ALLTHEMODIUM_TIER, 2, 1.0f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
                    if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<AxeItem> ALLTHEMODIUM_AXE = ITEMS.register("allthemodium_axe",
            () -> new AxeItem(ToolTiers.ALLTHEMODIUM_TIER, 6, 1.0f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_AXE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_AXE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
                    if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<ShovelItem> ALLTHEMODIUM_SHOVEL = ITEMS.register("allthemodium_shovel",
            () -> new ShovelItem(ToolTiers.ALLTHEMODIUM_TIER, 1, 1.5f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
                    if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<HoeItem> ALLTHEMODIUM_HOE = ITEMS.register("allthemodium_hoe",
            () -> new HoeItem(ToolTiers.ALLTHEMODIUM_TIER, 0, 1.5f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_HOE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_HOE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
                    if (state.is(ToolTiers.ALLTHEMODIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.ALLTHEMODIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<SwordItem> VIBRANIUM_SWORD = ITEMS.register("vibranium_sword",
            () -> new SwordItem(ToolTiers.VIBRANIUM_TIER, 10, 2.8f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

            });
    public static final RegistryObject<PickaxeItem> VIBRANIUM_PICKAXE = ITEMS.register("vibranium_pickaxe",
            () -> new PickaxeItem(ToolTiers.VIBRANIUM_TIER, 7, 2.0f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
                        return speed * 2.0f;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
                    if (state.is(ToolTiers.VIBRANIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<AxeItem> VIBRANIUM_AXE = ITEMS.register("vibranium_axe",
            () -> new AxeItem(ToolTiers.VIBRANIUM_TIER, 11, 1.0f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_AXE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_AXE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
                    if (state.is(ToolTiers.VIBRANIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<ShovelItem> VIBRANIUM_SHOVEL = ITEMS.register("vibranium_shovel",
            () -> new ShovelItem(ToolTiers.VIBRANIUM_TIER, 2, 1.5f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
                    if (state.is(ToolTiers.VIBRANIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<HoeItem> VIBRANIUM_HOE = ITEMS.register("vibranium_hoe",
            () -> new HoeItem(ToolTiers.VIBRANIUM_TIER, 1, 1.5f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_HOE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_HOE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
                    if (state.is(ToolTiers.VIBRANIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.VIBRANIUM_TIER, state);
                    return false;
                }
            });
    public static final RegistryObject<SwordItem> UNOBTAINIUM_SWORD = ITEMS.register("unobtainium_sword",
            () -> new SwordItem(ToolTiers.UNOBTAINIUM_TIER, 16, 3.2f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

            });
    public static final RegistryObject<PickaxeItem> UNOBTAINIUM_PICKAXE = ITEMS.register("unobtainium_pickaxe",
            () -> new PickaxeItem(ToolTiers.UNOBTAINIUM_TIER, 12, 4.0f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
                        return speed * 8.0f;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_PICKAXE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
                    if (state.is(ToolTiers.UNOBTAINIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
                    return false;
                }
            });
    public static final RegistryObject<AxeItem> UNOBTAINIUM_AXE = ITEMS.register("unobtainium_axe",
            () -> new AxeItem(ToolTiers.UNOBTAINIUM_TIER, 20, 1.4f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_AXE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_AXE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
                    if (state.is(ToolTiers.UNOBTAINIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<ShovelItem> UNOBTAINIUM_SHOVEL = ITEMS.register("unobtainium_shovel",
            () -> new ShovelItem(ToolTiers.UNOBTAINIUM_TIER, 3, 1.5f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_SHOVEL))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
                    if (state.is(ToolTiers.UNOBTAINIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
                    return false;
                }
            });

    public static final RegistryObject<HoeItem> UNOBTAINIUM_HOE = ITEMS.register("unobtainium_hoe",
            () -> new HoeItem(ToolTiers.UNOBTAINIUM_TIER, 2, 1.5f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
                @Override
                public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_HOE))
                        return speed;
                    return super.getDestroySpeed(stack, state);
                }

                @Override
                public boolean isEnchantable(@Nonnull ItemStack stack) {
                    return true;
                }

                @Override
                public boolean canBeDepleted() {
                    return false;
                }

                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level worldIn,
                        @Nonnull List<Component> tooltip,
                        @Nonnull TooltipFlag flagIn) {
                    tooltip.add(TextComponentHelper
                            .createComponentTranslation(CommandSource.NULL, "indestructible", new Object())
                            .withStyle(ChatFormatting.GOLD));

                    super.appendHoverText(stack, worldIn, tooltip, flagIn);
                }

                @Override
                public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
                    if (state.is(BlockTags.MINEABLE_WITH_HOE))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
                    if (state.is(ToolTiers.UNOBTAINIUM_TOOL_TAG))
                        return TierSortingRegistry.isCorrectTierForDrops(ToolTiers.UNOBTAINIUM_TIER, state);
                    return false;
                }
            });
    public static final RegistryObject<Block> UA_ALLOY = BLOCKS.register("unobtainium_allthemodium_alloy_block",
            UAAlloyBlock::new);
    public static final RegistryObject<Block> UV_ALLOY = BLOCKS.register("unobtainium_vibranium_alloy_block",
            UVAlloyBlock::new);
    public static final RegistryObject<Block> VA_ALLOY = BLOCKS.register("vibranium_allthemodium_alloy_block",
            VAAlloyBlock::new);

    public static final RegistryObject<Item> UA_ALLOY_ITEM = ITEMS.register("unobtainium_allthemodium_alloy_block",
            () -> new BlockItem(UA_ALLOY.get(), new Item.Properties()));
    public static final RegistryObject<Item> UV_ALLOY_ITEM = ITEMS.register("unobtainium_vibranium_alloy_block",
            () -> new BlockItem(UV_ALLOY.get(), new Item.Properties()));
    public static final RegistryObject<Item> VA_ALLOY_ITEM = ITEMS.register("vibranium_allthemodium_alloy_block",
            () -> new BlockItem(VA_ALLOY.get(), new Item.Properties()));

    public static final RegistryObject<SwordItem> ATM_ALLOY_SWORD = ITEMS.register("alloy_sword",
            () -> new AlloySword(ToolTiers.ALLOY_TIER, 35, 5.0F,
                    new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<AxeItem> ATM_ALLOY_AXE = ITEMS.register("alloy_axe",
            () -> new AlloyAxe(ToolTiers.ALLOY_TIER, 39, 5.0F,
                    new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<PickaxeItem> ATM_ALLOY_PICK = ITEMS.register("alloy_pick",
            () -> new AlloyPick(ToolTiers.ALLOY_TIER, 15, 5.0F,
                    new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<ShovelItem> ATM_ALLOY_SHOVEL = ITEMS.register("alloy_shovel",
            () -> new AlloyShovel(ToolTiers.ALLOY_TIER, 13, 5.0F,
                    new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC)));
    public static final RegistryObject<DiggerItem> ATM_ALLOY_PAXEL = ITEMS.register("alloy_paxel",
            () -> new AlloyPaxel(33, 5.0F, ToolTiers.ALLOY_TIER, TagRegistry.PAXEL_TARGETS,
                    new Item.Properties().fireResistant().stacksTo(1).rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> ATM_SMITHING = ITEMS.register("allthemodium_upgrade_smithing_template",
            () -> ATMSmithingItem.createAllthemodiumUpgradeTemplate());

    public static final RegistryObject<Item> VIB_SMITHING = ITEMS.register("vibranium_upgrade_smithing_template",
            () -> ATMSmithingItem.createVibraniumUpgradeTemplate());

    public static final RegistryObject<Item> UNO_SMITHING = ITEMS.register("unobtainium_upgrade_smithing_template",
            () -> ATMSmithingItem.createUnobtainiumUpgradeTemplate());

    public static final RegistryObject<Item> PIGLICH_HEART = ITEMS.register("piglich_heart",
            () -> new PiglichHeart(new Item.Properties()));
    public static final RegistryObject<EntityType<PiglichEntity>> PIGLICH = createMonsterEntity("piglich",
            PiglichEntity::new, 0.6F, 3.0F, 0x000000, 0xebe834);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable(Reference.tab()))
                    .icon(() -> RAW_ALLTHEMODIUM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> ITEMS.getEntries().stream()
                            .map(RegistryObject::get)
                            .map(Item::getDefaultInstance)
                            .forEach(output::accept))
                    .build());

    private static <T extends Monster> RegistryObject<EntityType<T>> createMonsterEntity(String name,
            EntityType.EntityFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);

        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height)
                .setTrackingRange(64).setUpdateInterval(1).build(location.toString()));
        //EntityType<T> entity = EntityType.Builder.of(factory, MobCategory.MONSTER).sized(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        //Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()));
        //spawnEgg.setRegistryName(new ResourceLocation(Reference.MOD_ID, name + "_spawn_egg"));
        //SPAWN_EGGS.add(spawnEgg);

        //return ENTITIES.register(name, () -> entity);
    }
    /*
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
        event.put(PIGLICH.get(), PiglichEntity.createAttributes().build());
        //event.put(ATM_SHULKER.get(), UNOBShulkerEntity.createAttributes().build());
    }

    private static RotatedPillarBlock log(DyeColor color1, DyeColor color2) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.WOOD));
    }

}
