package me.kopamed.rpk;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class Utils {
    public static final String prefix = "&7[&eRPK&7]&r ";
    public static final Minecraft mc = Minecraft.getMinecraft();

    public static void sendMessageToSelf(String msg){
        if(isPlayerInGame()){
            mc.thePlayer.addChatMessage(new ChatComponentText(getFormatedString(prefix + msg)));
        }
    }

    public static boolean isPlayerInGame() {
        return (mc.thePlayer != null && mc.theWorld != null);
    }

    public static String getFormatedString(String str){
        return str.replace("&", "§");
    }

    public static double round(double n, int d) {
        if (d == 0) {
            return (double)Math.round(n);
        } else {
            double p = Math.pow(10.0D, d);
            return (double)Math.round(n * p) / p;
        }
    }
}
