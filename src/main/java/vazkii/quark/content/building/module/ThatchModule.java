package vazkii.quark.content.building.module;

import net.minecraft.world.level.block.ComposterBlock;
import vazkii.quark.base.handler.VariantHandler;
import vazkii.quark.base.module.LoadModule;
import vazkii.quark.base.module.ModuleCategory;
import vazkii.quark.base.module.QuarkModule;
import vazkii.quark.base.module.config.Config;
import vazkii.quark.content.building.block.ThatchBlock;

@LoadModule(category = ModuleCategory.BUILDING)
public class ThatchModule extends QuarkModule {

	@Config.Min(0)
	@Config.Max(1)
	@Config public static double fallDamageMultiplier = 0.5;
	
	public static ThatchBlock thatch;
	
	@Override
	public void register() {
		thatch = new ThatchBlock(this);
		VariantHandler.addSlabAndStairs(thatch);
	}
	
	@Override
	public void loadComplete() {
		enqueue(() -> ComposterBlock.COMPOSTABLES.put(thatch.asItem(), 0.65F));
	}
	
}
