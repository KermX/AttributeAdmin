package me.kermx.attributeadmin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AFCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1)
            return true;

        String targetUsername = args[0];
        Player targetPlayer = Bukkit.getPlayer(targetUsername);

        if (targetPlayer == null) {
            sender.sendMessage(targetUsername + " not found.");
            return true;
        }

        for (AttributeModifier im : targetPlayer.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getModifiers()) {
            targetPlayer.getAttribute(Attribute.GENERIC_ATTACK_SPEED).removeModifier(im);
        }

        for (AttributeModifier im : targetPlayer.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getModifiers()) {
            targetPlayer.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).removeModifier(im);
        }

        sender.sendMessage(targetUsername + ChatColor.GREEN + " attack speed and damage fixed!");

        return true;
    }
}
