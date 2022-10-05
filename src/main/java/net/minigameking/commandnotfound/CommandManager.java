package net.minigameking.commandnotfound;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("commandnotfound")){
            if(args.length == 0){
                sendInfo(sender);
                return true;
            } else if(args[0].equalsIgnoreCase("reload")){
                if(!sender.hasPermission("admin.commandnotfound.reload")) {
                    sendInfo(sender);
                    return true;
                }
                CommandNotFound.getPlugin().reloadConfig();
                CommandNotFound.msg = CommandNotFound.getPlugin().getConfig().getString("Message");
                sender.sendMessage("§3[§2§lCommandNotFound§3] §aSuccessfully reloaded config file");
                return true;
            } else {
                sendInfo(sender);
            }
        }
        return true;
    }

    public static void sendInfo(CommandSender s){
        s.sendMessage("§3[§2§lCommandNotFound§3] Running CommandNotFound by MeindoMC version " + CommandNotFound.getPlugin().getDescription().getVersion());
    }
}
