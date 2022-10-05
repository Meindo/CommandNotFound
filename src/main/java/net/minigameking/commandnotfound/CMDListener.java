package net.minigameking.commandnotfound;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CMDListener implements Listener {
    @EventHandler
    public static void onCommand(PlayerCommandPreprocessEvent e){
        String msg = e.getMessage();
        String[] args = msg.split(" ");
        Player pl = e.getPlayer();
        if(Bukkit.getServer().getHelpMap().getHelpTopic(args[0]) == null){
            e.setCancelled(true);
            pl.sendMessage(CommandNotFound.msg);
        }
    }
}
