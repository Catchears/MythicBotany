package mythicbotany.mjoellnir;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffects;

public enum MjoellnirHoldRequirement {

    NOTHING,
    EFFECT,
    HEARTS;
    
    public boolean test(Player player) {
        return switch (this) {
            case NOTHING -> true;
            case EFFECT -> player.getEffect(MobEffects.ABSORPTION) != null;
            case HEARTS -> player.getAbsorptionAmount() > 0;
        };
    }
}
