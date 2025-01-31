package be.reithsaw.reithsawmod.container;

import be.reithsaw.reithsawmod.block.Electrifier;
import be.reithsaw.reithsawmod.util.Registration;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class ModContainers
{
    public static final RegistryObject<ContainerType<ElectrifierContainer>> ELECTRIFIRE_CONTAINER
            = Registration.CONTAINERS.register("electrifier_container",
            () -> IForgeContainerType.create((((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new ElectrifierContainer(windowId, world, pos, inv, inv.player);
            }))));

    public static void register() { }


}
