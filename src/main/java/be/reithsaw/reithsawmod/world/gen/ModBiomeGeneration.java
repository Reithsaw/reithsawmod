package be.reithsaw.reithsawmod.world.gen;

import be.reithsaw.reithsawmod.ReithsawMod;
import be.reithsaw.reithsawmod.world.biome.ModBiomes;
import be.reithsaw.reithsawmod.world.biome.ModConfiguredSurfaceBuilders;
import be.reithsaw.reithsawmod.world.biome.ModSurfaceBuilders;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static net.minecraftforge.common.BiomeDictionary.Type.*;
@Mod.EventBusSubscriber(modid = ReithsawMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBiomeGeneration
{
    @SubscribeEvent(priority = EventPriority.LOW)
    public  static void register(final RegistryEvent.Register<SurfaceBuilder<?>> event)
    {
        registerConfiguredSurfaceBuilder(ModConfiguredSurfaceBuilders.OIL_SURFACE.getLocation(),
                Blocks.SOUL_SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
    }

    @SubscribeEvent
    public static void setupBiome(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            addBiome(ModBiomes.OIL_BIOME.get(), BiomeManager.BiomeType.WARM, 100, HOT, DEAD, DRY);
        });
    }

    private static void registerConfiguredSurfaceBuilder(ResourceLocation configuredSurfaceBuilderRL, BlockState topBlock, BlockState fillerBlock, BlockState underwaterBlock)
    {
        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, configuredSurfaceBuilderRL, ModSurfaceBuilders.LOGGIN_DEFAULT.get().func_242929_a(
                new SurfaceBuilderConfig(topBlock, fillerBlock, underwaterBlock)));
    }

    private static void addBiome(Biome biome, BiomeManager.BiomeType type, int weight, BiomeDictionary.Type... types)
    {
        RegistryKey<Biome> key = RegistryKey.getOrCreateKey(ForgeRegistries.Keys.BIOMES,
                Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome)));

        BiomeDictionary.addTypes(key, types);
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(key, weight));
    }
}
