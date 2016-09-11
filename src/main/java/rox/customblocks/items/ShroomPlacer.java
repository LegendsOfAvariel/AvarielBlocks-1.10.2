package rox.customblocks.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.customblocks.AvarielTabs;

public class ShroomPlacer extends Item {
	public ShroomPlacer() {
		this.setRegistryName("mushroom_placer");
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(AvarielTabs.tabAvarielTools);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(player.isSneaking()) {
			world.setBlockState(pos.offset(facing), Blocks.BROWN_MUSHROOM_BLOCK.getStateFromMeta(14));
			return EnumActionResult.SUCCESS;
		} else if(!player.isSneaking()) {
			world.setBlockState(pos.offset(facing), Blocks.RED_MUSHROOM_BLOCK.getStateFromMeta(14));
			return EnumActionResult.SUCCESS;
		} else return EnumActionResult.FAIL;
	}
	
	public static Item shroomPlacer = new ShroomPlacer();
	
	public static void serverInit() {
		GameRegistry.register(shroomPlacer);
	}
	
	public static void clientInit() {
		render(shroomPlacer);
	}
	
	public static void render(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
