package mythicbotany.data;

import io.github.noeppi_noeppi.libx.annotation.data.Datagen;
import io.github.noeppi_noeppi.libx.data.provider.ItemModelProviderBase;
import io.github.noeppi_noeppi.libx.mod.ModX;
import mythicbotany.ModBlocks;
import mythicbotany.ModItems;
import mythicbotany.functionalflora.base.BlockFunctionalFlower;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

@Datagen
public class ItemModelProvider extends ItemModelProviderBase {

	public ItemModelProvider(ModX mod, DataGenerator generator, ExistingFileHelper fileHelper) {
		super(mod, generator, fileHelper);
	}

	@Override
	protected void setup() {
        this.handheld(ModItems.alfsteelSword);
        this.manualModel(ModItems.alfsteelPick);
        this.manualModel(ModItems.alfsteelAxe);
        this.manualModel(ModItems.fadedNetherStar);
        this.manualModel(ModItems.dreamwoodTwigWand);
        this.manualModel(ModBlocks.alfsteelPylon.asItem());
	}

	@Override
	protected void defaultBlock(ResourceLocation id, BlockItem item) {
		if (item.getBlock() instanceof BlockFunctionalFlower<?>) {
			this.withExistingParent(id.getPath(), GENERATED).texture("layer0", new ResourceLocation(id.getNamespace(), "block/" + id.getPath()));
		} else {
			super.defaultBlock(id, item);
		}
	}
}
