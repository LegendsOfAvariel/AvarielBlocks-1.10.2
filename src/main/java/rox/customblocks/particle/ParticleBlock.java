package rox.customblocks.particle;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import rox.customblocks.AvarielTabs;

public class ParticleBlock extends Block {
	
	private EnumParticleTypes particle;
	
	public ParticleBlock(String name, EnumParticleTypes particles) {
		super(Material.PISTON);
		this.setRegistryName(name);
		this.setUnlocalizedName(this.getRegistryName().toString());
		this.setCreativeTab(AvarielTabs.tabAvarielTools);
		
		this.particle = particles;
	}
	
	//This and...
	public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
	
	//... this prevent textrue culling issues.
	//This also prevents the player from getting pushed out of the block.
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	//Removes the collision box so the player can walk through the block.
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
	//So the block can be transparent, move it's rendering layer to the equivalent of ladders, vines and glass.
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
	
	//This fires when the block ticks randomly.
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		Random random = worldIn.rand;
		
		//Increase the number in the for loop to increase the amount of particles spawned per tick.
        for(int i = 0; i < 4; i++) {
        	//Particle spawn positions; X, Y and Z in order.
        	double px = (double)((float)pos.getX() + random.nextFloat());
        	double py = (double)((float)pos.getY() + random.nextFloat());
        	double pz = (double)((float)pos.getZ() + random.nextFloat());
        	
        	//Particle movement directions; X, Y and Z in order.
        	double dx = (((random.nextDouble()*2)-1)/16);
        	double dy = 0.125D;
        	double dz = (((random.nextDouble()*2)-1)/16);
        	
        	//This actually spawns the particle. Particle is set when initializing a new ParticleBlock.
        	worldIn.spawnParticle(this.particle, px, py, pz, dx, dy, dz, new int[0]);
        }
	}
	
	//Blocks registry
	public static Block smokeBlock = new ParticleBlock("smoke_block", EnumParticleTypes.SMOKE_LARGE);
	
	//ItemBlocks registry
	public static ItemBlock smokeBlockItem = (ItemBlock) new ItemBlock(smokeBlock).setRegistryName("smoke_block");
	
	//Serverside initialization.
	public static void serverInit() {
		register(smokeBlock, smokeBlockItem);
	}
	
	//Clientside initialization.
	public static void clientInit() {
		render(smokeBlock);
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
