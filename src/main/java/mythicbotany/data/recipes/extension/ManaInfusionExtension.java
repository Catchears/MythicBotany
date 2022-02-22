package mythicbotany.data.recipes.extension;

import io.github.noeppi_noeppi.libx.data.provider.recipe.RecipeExtension;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import vazkii.botania.data.recipes.ManaInfusionProvider;

public interface ManaInfusionExtension extends RecipeExtension {

    default void manaInfusion(ItemLike input, ItemLike result, int mana) {
        manaInfusion(input, new ItemStack(result), mana);
    }

    default void manaInfusion(Tag.Named<Item> input, ItemLike result, int mana) {
        manaInfusion(input, new ItemStack(result), mana);
    }

    default void manaInfusion(Ingredient input, ItemLike result, int mana) {
        manaInfusion(input, new ItemStack(result), mana);
    }
    
    default void manaInfusion(ItemLike input, ItemStack result, int mana) {
        manaInfusion(Ingredient.of(input), result, mana);
    }
    
    default void manaInfusion(Tag.Named<Item> input, ItemStack result, int mana) {
        manaInfusion(Ingredient.of(input), result, mana);
    }
    
    default void manaInfusion(Ingredient input, ItemStack result, int mana) {
        this.consumer().accept(Wrapper.create(this.provider().loc(result.getItem(), "from_mana_infusion"), result, input, mana));
    }

    default void manaAlchemy(ItemLike input, ItemLike result, int mana) {
        manaAlchemy(input, new ItemStack(result), mana);
    }

    default void manaAlchemy(Tag.Named<Item> input, ItemLike result, int mana) {
        manaAlchemy(input, new ItemStack(result), mana);
    }

    default void manaAlchemy(Ingredient input, ItemLike result, int mana) {
        manaAlchemy(input, new ItemStack(result), mana);
    }
    
    default void manaAlchemy(ItemLike input, ItemStack result, int mana) {
        manaAlchemy(Ingredient.of(input), result, mana);
    }

    default void manaAlchemy(Tag.Named<Item> input, ItemStack result, int mana) {
        manaAlchemy(Ingredient.of(input), result, mana);
    }

    default void manaAlchemy(Ingredient input, ItemStack result, int mana) {
        this.consumer().accept(Wrapper.alchemy(this.provider().loc(result.getItem(), "from_mana_alchemy"), result, input, mana));
    }

    default void manaConjuration(ItemLike input, ItemLike result, int mana) {
        manaConjuration(input, new ItemStack(result), mana);
    }

    default void manaConjuration(Tag.Named<Item> input, ItemLike result, int mana) {
        manaConjuration(input, new ItemStack(result), mana);
    }

    default void manaConjuration(Ingredient input, ItemLike result, int mana) {
        manaConjuration(input, new ItemStack(result), mana);
    }
    
    default void manaConjuration(ItemLike input, ItemStack result, int mana) {
        manaConjuration(Ingredient.of(input), result, mana);
    }

    default void manaConjuration(Tag.Named<Item> input, ItemStack result, int mana) {
        manaConjuration(Ingredient.of(input), result, mana);
    }

    default void manaConjuration(Ingredient input, ItemStack result, int mana) {
        this.consumer().accept(Wrapper.conjuration(this.provider().loc(result.getItem(), "from_mana_conjuration"), result, input, mana));
    }
    
    class Wrapper extends ManaInfusionProvider {

        public Wrapper(DataGenerator gen) {
            super(gen);
        }
        
        private static FinishedRecipe create(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
            return new FinishedRecipe(id, output, input, mana);
        }

        private static FinishedRecipe alchemy(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
            return FinishedRecipe.alchemy(id, output, input, mana);
        }

        private static FinishedRecipe conjuration(ResourceLocation id, ItemStack output, Ingredient input, int mana) {
            return FinishedRecipe.conjuration(id, output, input, mana);
        }
    }
}