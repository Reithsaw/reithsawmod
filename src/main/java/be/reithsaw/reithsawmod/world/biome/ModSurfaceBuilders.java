package be.reithsaw.reithsawmod.world.biome;

import be.reithsaw.reithsawmod.util.Registration;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;

public class ModSurfaceBuilders
{
    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> LOGGIN_DEFAULT =
            Registration.SURFACE_BUILDERS.register("logging_default",
                    () -> new LoggingSurfaceBuilder<>(() -> SurfaceBuilder.DEFAULT, SurfaceBuilderConfig.field_237203_a_));

    public static void register() { }
}
