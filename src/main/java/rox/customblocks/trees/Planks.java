package rox.customblocks.trees;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import rox.customblocks.AvarielTabs;
import rox.customblocks.AvarielBlocks;

public class Planks extends Block {
	
	//Constructor
	public Planks(String name) {
		//All planks should be wood
		super(Material.WOOD);
		
		//Registry name set at initialization
		this.setRegistryName(name);
		//Gets unlocalized name from registry name
		this.setUnlocalizedName(this.getRegistryName().toString());
		//All planks should go under the tree tab
		this.setCreativeTab(AvarielTabs.tabAvarielTrees);
		
		//Hardness is similar to vanilla planks
		this.setHardness(2.0f);
	}
	
	/* All blocks and itemblocks need to be initialized as a static, otherwise we can't register them with Forge.
	 * I've already tried adding them to an Array to where we only need to register the block.
	 * It doesn't work, so don't try it. Initialize, register and render everything seperately!  */
	
	//Blocks
	//To add a new block, just initialize a new instance of Planks and give it a registry name.
	public static Block planksOne = new Planks("planks_one");
	public static Block planksTwo = new Planks("planks_two");
	public static Block planksThree = new Planks("planks_three");
	public static Block planksFour = new Planks("planks_four");
	public static Block planksFive = new Planks("planks_five");
	public static Block planksSix = new Planks("planks_six");
	public static Block planksSeven = new Planks("planks_seven");
	public static Block planksEight = new Planks("planks_eight");
	public static Block planksNine = new Planks("planks_nine");
	public static Block planksTen = new Planks("planks_ten");
	public static Block planksEleven = new Planks("planks_eleven");
	public static Block planksTwelve = new Planks("planks_twelve");
	public static Block planksThirteen = new Planks("planks_thirteen");
	public static Block planksFourteen = new Planks("planks_fourteen");
	public static Block planksFifteen = new Planks("planks_fifteen");
	public static Block planksSixteen = new Planks("planks_sixteen");
	
	//Blocks in item form
	/* To create a new ItemBlock, initialize a new ItemBlock and cast it as ItemBlock (I don't know why you
	 * have to, but you do.), then set the registry name to the same thing  as it's block counterpart.
	 * DO NOT try to set the registry name of the ItemBlock using the registry name of the Block! It won't work, so set it manually.  */
	public static ItemBlock planksOneItem = (ItemBlock) new ItemBlock(planksOne).setRegistryName("planks_one");
	public static ItemBlock planksTwoItem = (ItemBlock) new ItemBlock(planksTwo).setRegistryName("planks_two");
	public static ItemBlock planksThreeItem = (ItemBlock) new ItemBlock(planksThree).setRegistryName("planks_three");
	public static ItemBlock planksFourItem = (ItemBlock) new ItemBlock(planksFour).setRegistryName("planks_four");
	public static ItemBlock planksFiveItem = (ItemBlock) new ItemBlock(planksFive).setRegistryName("planks_five");
	public static ItemBlock planksSixItem = (ItemBlock) new ItemBlock(planksSix).setRegistryName("planks_six");
	public static ItemBlock planksSevenItem = (ItemBlock) new ItemBlock(planksSeven).setRegistryName("planks_seven");
	public static ItemBlock planksEightItem = (ItemBlock) new ItemBlock(planksEight).setRegistryName("planks_eight");
	public static ItemBlock planksNineItem = (ItemBlock) new ItemBlock(planksNine).setRegistryName("planks_nine");
	public static ItemBlock planksTenItem = (ItemBlock) new ItemBlock(planksTen).setRegistryName("planks_ten");
	public static ItemBlock planksElevenItem = (ItemBlock) new ItemBlock(planksEleven).setRegistryName("planks_eleven");
	public static ItemBlock planksTwelveItem = (ItemBlock) new ItemBlock(planksTwelve).setRegistryName("planks_twelve");
	public static ItemBlock planksThirteenItem = (ItemBlock) new ItemBlock(planksThirteen).setRegistryName("planks_thirteen");
	public static ItemBlock planksFourteenItem = (ItemBlock) new ItemBlock(planksFourteen).setRegistryName("planks_fourteen");
	public static ItemBlock planksFifteenItem = (ItemBlock) new ItemBlock(planksFifteen).setRegistryName("planks_fifteen");
	public static ItemBlock planksSixteenItem = (ItemBlock) new ItemBlock(planksSixteen).setRegistryName("planks_sixteen");
	
	public static void serverInit() { //Register everything here.
		register(planksOne, planksOneItem);
		register(planksTwo, planksTwoItem);
		register(planksThree, planksThreeItem);
		register(planksFour, planksFourItem);
		register(planksFive, planksFiveItem);
		register(planksSix, planksSixItem);
		register(planksSeven, planksSevenItem);
		register(planksEight, planksEightItem);
		register(planksNine, planksNineItem);
		register(planksTen, planksTenItem);
		register(planksEleven, planksElevenItem);
		register(planksTwelve, planksTwelveItem);
		register(planksThirteen, planksThirteenItem);
		register(planksFourteen, planksFourteenItem);
		register(planksFifteen, planksFifteenItem);
		register(planksSixteen, planksSixteenItem);
	}
	
	public static void clientInit() { //Render everything here.
		render(planksOne);
		render(planksTwo);
		render(planksThree);
		render(planksFour);
		render(planksFive);
		render(planksSix);
		render(planksSeven);
		render(planksEight);
		render(planksNine);
		render(planksTen);
		render(planksEleven);
		render(planksTwelve);
		render(planksThirteen);
		render(planksFourteen);
		render(planksFifteen);
		render(planksSixteen);
	}
	
	//Applies textures and models to a given block and it's item form.
	public static void render(Block block) {
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	//Registers a block and itemblock pair. This exists for the sake of compactness.
	public static void register(Block block, ItemBlock itemBlock) {
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);
	}

}
