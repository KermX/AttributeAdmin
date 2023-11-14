package me.kermx.attributeadmin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AACommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1){
            String targetUsername = args[0];
            Player targetPlayer = Bukkit.getPlayer(targetUsername);
            if (targetPlayer != null){
                //do stuff
                double maxHealth = targetPlayer.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
                double attackSpeed = targetPlayer.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue();
                double movementSpeed = targetPlayer.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue();
                double attackDamage = targetPlayer.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();

                sender.sendMessage(ChatColor.GREEN + "Attribute Modifiers for " + targetUsername);
                sender.sendMessage(ChatColor.GREEN + "Max Health: " + maxHealth);
                sender.sendMessage(ChatColor.GREEN + "Movement Speed: " + movementSpeed);
                sender.sendMessage(ChatColor.GREEN + "Attack Speed: " + attackSpeed);
                sender.sendMessage(ChatColor.GREEN + "Attack Damage: " + attackDamage);

            }else {
                sender.sendMessage(targetUsername + " not found.");
            }
        }
        return true;
    }
}
