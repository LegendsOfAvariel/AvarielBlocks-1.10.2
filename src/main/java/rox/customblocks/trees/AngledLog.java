package rox.customblocks.trees;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import rox.customblocks.AvarielTabs;

public class AngledLog extends Block {
	//Unfinished
	
	public AngledLog(String name) {
		super(Material.WOOD);
		
		this.setRegistryName(name);
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(AvarielTabs.tabAvarielTrees);
		
		this.setDefaultState(blockState.getBaseState());
	}
	
}
