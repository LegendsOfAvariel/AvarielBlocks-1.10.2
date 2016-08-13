package rox.customblocks.items;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
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
import rox.customblocks.trees.Logs;

public class BlockstateChanger extends Item {
	public BlockstateChanger() {
		this.setRegistryName("blockstate_changer");
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        IBlockState blockState = player.worldObj.getBlockState(pos);
        Block block = blockState.getBlock();
        int metaCur, metaNew = 0;
        IBlockState bsNew = null;
		
        if (block == Logs.logOne || block == Logs.logTwo || block == Logs.logThree || block == Logs.logFour || block == Logs.logFive || block == Logs.logSix || block == Logs.logSeven || block == Logs.logEight || block == Logs.logNine || block == Logs.logTen || block == Logs.logEleven || block == Logs.logTwelve || block == Logs.logThirteen || block == Logs.logFourteen || block == Logs.logFifteen || block == Logs.logSixteen) {
        	metaCur = block.getMetaFromState(blockState);
        	
        	switch(metaCur) {
        	case 0: metaNew = 1; break;
        	case 1: metaNew = 2; break;
        	case 2: metaNew = 3; break;
        	case 3: metaNew = 0; break;
        	}
        	
        	bsNew = block.getStateFromMeta(metaNew);
        	world.setBlockState(pos, bsNew);
        	
        	return EnumActionResult.SUCCESS;
        }
        
        else if (block == Blocks.LOG) {
        	metaCur = block.getMetaFromState(blockState);
        	
        	switch(metaCur) {
        	case 0: metaNew = 4; break;
        	case 1: metaNew = 5; break;
        	case 2: metaNew = 6; break;
        	case 3: metaNew = 7; break;
        	case 4: metaNew = 8; break;
        	case 5: metaNew = 9; break;
        	case 6: metaNew = 10; break;
        	case 7: metaNew = 11; break;
        	case 8: metaNew = 12; break;
        	case 9: metaNew = 13; break;
        	case 10: metaNew = 14; break;
        	case 11: metaNew = 15; break;
        	case 12: metaNew = 0; break;
        	case 13: metaNew = 1; break;
        	case 14: metaNew = 2; break;
        	case 15: metaNew = 3; break;
        	}
        	
        	bsNew = block.getStateFromMeta(metaNew);
        	world.setBlockState(pos, bsNew);
        	
        	return EnumActionResult.SUCCESS;
        }
        
        else if (block == Blocks.LOG2) {
        	metaCur = block.getMetaFromState(blockState);
        	
        	switch(metaCur) {
        	case 0: metaNew = 4; break;
        	case 1: metaNew = 5; break;
        	case 4: metaNew = 8; break;
        	case 5: metaNew = 9; break;
        	case 8: metaNew = 12; break;
        	case 9: metaNew = 13; break;
        	case 12: metaNew = 0; break;
        	case 13: metaNew = 1; break;
        	}
        	
        	bsNew = block.getStateFromMeta(metaNew);
        	world.setBlockState(pos, bsNew);
        	
        	return EnumActionResult.SUCCESS;
        }
        
        else return EnumActionResult.FAIL;
    }
	
	public static Item blockstateChanger = new BlockstateChanger();
	
	public static void serverInit() {
		GameRegistry.register(blockstateChanger);
	}
	
	public static void clientInit() {
		render(blockstateChanger);
	}
	
	public static void render(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
