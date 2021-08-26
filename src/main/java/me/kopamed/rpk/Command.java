package me.kopamed.rpk;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;


import java.io.File;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Command extends CommandBase {
    private final String COMMAND = "rpk";
    private static final List<String> ALIASES = ImmutableList.of("randompack");
    protected Minecraft mc;

    public String getCommandName() {
        return COMMAND;
    }

    public String getCommandUsage(ICommandSender sender) {
        return "/" + COMMAND;
    }

    public List<String> getCommandAliases()
    {
        return ALIASES;
    }

    public void processCommand(ICommandSender sender, String[] args) {
        Utils.sendMessageToSelf("&7&m-------------------------");
        double startTime = System.currentTimeMillis();
        mc = Minecraft.getMinecraft();
        File dir = new File(mc.mcDataDir + File.separator + "resourcepacks");
        if(dir.list() == null || !dir.exists()){
            Utils.sendMessageToSelf("&cMake sure that you have your packs in the correct directory!");
        } else {
            Utils.sendMessageToSelf("&2Found &d" + dir.list().length + " &2resourcepacks!");
            int randomPackInt = ThreadLocalRandom.current().nextInt(0, dir.list().length - 1);
            File randomRpk = new File(dir, dir.list()[randomPackInt]);
            Utils.sendMessageToSelf("&2Decided a random pack! &8[&d" + ++randomPackInt +  "/" + dir.list().length + "&8]");
            Utils.sendMessageToSelf("&3Setting...");
            try{
                mc.getResourcePackRepository().setResourcePackInstance(randomRpk);
                Utils.sendMessageToSelf("&2Successfully set the pack to &d" + randomRpk.getName() + "&2!");
            } catch (Exception e){
                Utils.sendMessageToSelf("&cAn error occurred!");
                e.printStackTrace();
            }
        }
        Utils.sendMessageToSelf("&eTime taken: &d" + Utils.round((System.currentTimeMillis() - startTime) / 1000, 2) + " &eseconds!");
        Utils.sendMessageToSelf("&7&m-------------------------");
    }

    public int getRequiredPermissionLevel() {
        return 0;
    }

    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
