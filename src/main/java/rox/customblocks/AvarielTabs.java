package rox.customblocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import rox.customblocks.items.BlockstateChanger;
import rox.customblocks.trees.Logs;

public class AvarielTabs {
	
	public static final CreativeTabs tabAvarielTools = new CreativeTabs("AvarielTools") {
		@Override
		public Item getTabIconItem() {
			return BlockstateChanger.blockstateChanger;
		}
	};
	
	//Tree tab
	public static final CreativeTabs tabAvarielTrees = new CreativeTabs("AvarielTrees") {
		@Override
		public Item getTabIconItem() {
			//Sets an icon for the tab; Change this to change the icon. Will crash if null.
			return Item.getItemFromBlock(Logs.logOne);
		}
	};
	
	//Foliage tab
	public static final CreativeTabs tabAvarielFoliage = new CreativeTabs("AvarielFoliage") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.BARRIER);
		}
	};
	
}
