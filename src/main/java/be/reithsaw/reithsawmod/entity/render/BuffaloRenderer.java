package be.reithsaw.reithsawmod.entity.render;

import be.reithsaw.reithsawmod.ReithsawMod;
import be.reithsaw.reithsawmod.entity.BuffaloEntity;
import be.reithsaw.reithsawmod.entity.model.BuffaloModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BuffaloRenderer extends MobRenderer<BuffaloEntity, BuffaloModel<BuffaloEntity>>
{
    public BuffaloRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new BuffaloModel<>(), 0.9f);
    }

    @Override
    public ResourceLocation getEntityTexture(BuffaloEntity entity)
    {
        return new ResourceLocation(ReithsawMod.MOD_ID, "textures/entity/buffalo.png");
    }
}
