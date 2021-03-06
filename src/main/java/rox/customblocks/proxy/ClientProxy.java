package rox.customblocks.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rox.customblocks.items.BlockstateChanger;
import rox.customblocks.items.ShroomPlacer;
import rox.customblocks.particle.ParticleBlock;
import rox.customblocks.trees.Leaves;
import rox.customblocks.trees.Logs;
import rox.customblocks.trees.Planks;

public class ClientProxy extends ServerProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e); //Calls preinit from ServerProxy
		Planks.clientInit(); //Initialize planks clientside
		Logs.clientInit();
		Leaves.clientInit();
		BlockstateChanger.clientInit();
		ShroomPlacer.clientInit();
		ParticleBlock.clientInit();
	}
	
	public void init(FMLInitializationEvent e) {
		super.init(e); //Calls init from ServerProxy
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e); //Calls postinit from ServerProxy
	}
	
}
