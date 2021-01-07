package be.reithsaw.reithsawmod.tileentity;

import be.reithsaw.reithsawmod.block.Electrifier;
import be.reithsaw.reithsawmod.block.ModBlocks;
import be.reithsaw.reithsawmod.util.Registration;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

import java.lang.annotation.ElementType;

public class ModTileEntities
{
    public static final RegistryObject<TileEntityType<ElectrifierTile>> ELECTIFIER_TILE_ENTITY
            = Registration.TILE_ENTITY_TYPES.register("electrifier_tile_entity", () -> TileEntityType.Builder.create(
                    () -> new ElectrifierTile(), ModBlocks.ELECTRIFIER.get()).build(null));

    public static void register() { }
}
