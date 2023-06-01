package net.cyber2000.metallics.block;



import net.cyber2000.metallics.Metallics;
import net.cyber2000.metallics.item.MetallicsItems;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MetallicsBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Metallics.MOD_ID);




public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.0f)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.0f)));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TIN_GLASS = registerBlock("tin_glass",
            () -> new GlassBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.6f).noOcclusion().sound(SoundType.GLASS)));


    public static final RegistryObject<Block> TIN_GLASS_PANE = registerBlock("tin_glass_pane",
            () -> new IronBarsBlock(BlockBehaviour.Properties.of(Material.GLASS).strength(0.6f).noOcclusion().sound(SoundType.GLASS)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0f).requiresCorrectToolForDrops()));







    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return MetallicsItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

}
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}


