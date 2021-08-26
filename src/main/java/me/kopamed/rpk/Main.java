package me.kopamed.rpk;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "RandomResourcePack";
    public static final String VERSION = "1.0";
    public static Minecraft mc;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        mc = Minecraft.getMinecraft();
        ClientCommandHandler.instance.registerCommand(new Command());
    }
}
