package be.reithsaw.reithsawmod.setup;

import be.reithsaw.reithsawmod.ReithsawMod;
import be.reithsaw.reithsawmod.block.ModBlocks;
import be.reithsaw.reithsawmod.container.ModContainers;
import be.reithsaw.reithsawmod.entity.ModEntityTypes;
import be.reithsaw.reithsawmod.entity.render.BuffaloRenderer;
import be.reithsaw.reithsawmod.item.ModSpawnEggItem;
import be.reithsaw.reithsawmod.screens.ElectrifierScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ReithsawMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy {
    @Override
    public void init()
    {
        RenderTypeLookup.setRenderLayer(ModBlocks.ZUCCINI_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_SAPLING.get(), RenderType.getCutout());


        ScreenManager.registerFactory(ModContainers.ELECTRIFIRE_CONTAINER.get(), ElectrifierScreen::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUFFALO.get(), BuffaloRenderer::new);

        ModSpawnEggItem.initSpawnEggs();
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
