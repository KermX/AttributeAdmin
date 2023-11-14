package me.kermx.attributeadmin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ARCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            String targetUsername = args[0];
            Player targetPlayer = Bukkit.getPlayer(targetUsername);
            if (targetPlayer != null){
                AttributeInstance attackSpeedAttribute = targetPlayer.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
                if (attackSpeedAttribute != null){
                    attackSpeedAttribute.setBaseValue(4.0);
                }
                AttributeInstance attackDamageAttribute = targetPlayer.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
                if (attackDamageAttribute != null) {
                    attackDamageAttribute.setBaseValue(1.0);
                }
                sender.sendMessage(targetUsername + ChatColor.GREEN + " attack speed and damage fixed!");
            }else {
                sender.sendMessage(targetUsername + " not found.");
            }
        }
        return true;
    }
}
