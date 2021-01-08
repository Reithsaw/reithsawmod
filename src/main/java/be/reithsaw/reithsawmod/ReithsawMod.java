package be.reithsaw.reithsawmod;

import be.reithsaw.reithsawmod.block.ModBlocks;
import be.reithsaw.reithsawmod.block.ModFluids;
import be.reithsaw.reithsawmod.container.ModContainers;
import be.reithsaw.reithsawmod.entity.BuffaloEntity;
import be.reithsaw.reithsawmod.entity.ModEntityTypes;
import be.reithsaw.reithsawmod.events.ModEvents;
import be.reithsaw.reithsawmod.item.ModItems;
import be.reithsaw.reithsawmod.setup.ClientProxy;
import be.reithsaw.reithsawmod.setup.IProxy;
import be.reithsaw.reithsawmod.setup.ServerProxy;
import be.reithsaw.reithsawmod.tileentity.ModTileEntities;
import be.reithsaw.reithsawmod.util.Config;
import be.reithsaw.reithsawmod.util.Registration;
import be.reithsaw.reithsawmod.world.biome.ModBiomes;
import be.reithsaw.reithsawmod.world.biome.ModSurfaceBuilders;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(ReithsawMod.MOD_ID)
public class ReithsawMod
{
    public static final String MOD_ID = "reithsawmod";

    public static final ItemGroup REITHSAW_TAB = new ItemGroup("reithsawTab")
    {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_WIRE.get());
        }
    };

    public static IProxy proxy;

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public ReithsawMod()
    {
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        registerConfigs();

        proxy.init();

        DeferredWorkQueue.runLater(() ->
                GlobalEntityTypeAttributes.put(ModEntityTypes.BUFFALO.get(), BuffaloEntity.setCustomAttributes().create()));

        loadConfigs();
    }

    private void registerConfigs()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }

    private void loadConfigs()
    {
        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("reithsawmod-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("reithsawmod-server.toml").toString());
    }

    private void registerModAdditions()
    {
        //Inits the registration of our additions
        Registration.init();

        // registers items, blocks etc added by our mod
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();

        ModBiomes.register();
        ModSurfaceBuilders.register();

        ModTileEntities.register();
        ModContainers.register();
        ModEntityTypes.register();


        // register mod event
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }
}
