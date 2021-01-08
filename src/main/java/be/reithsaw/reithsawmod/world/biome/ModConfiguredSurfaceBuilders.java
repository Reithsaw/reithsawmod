package be.reithsaw.reithsawmod.world.biome;

import be.reithsaw.reithsawmod.ReithsawMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;

public class ModConfiguredSurfaceBuilders
{
    public static RegistryKey<ConfiguredSurfaceBuilder<?>> OIL_SURFACE
            = RegistryKey.getOrCreateKey(Registry.CONFIGURED_SURFACE_BUILDER_KEY,
            new ResourceLocation(ReithsawMod.MOD_ID, "oil_surface"));
}
