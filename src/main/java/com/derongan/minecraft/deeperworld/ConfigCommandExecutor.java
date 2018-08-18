package com.derongan.minecraft.deeperworld;

import com.derongan.minecraft.deeperworld.world.WorldManager;
import com.derongan.minecraft.deeperworld.world.section.Section;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.stream.Collectors;

public class ConfigCommandExecutor implements CommandExecutor {
    private WorldManager worldManager;

    public ConfigCommandExecutor(WorldManager worldManager) {
        this.worldManager = worldManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equals("listsections")) {
                StringBuilder builder = new StringBuilder();
                builder.append("" + ChatColor.GREEN + ChatColor.BOLD + "Sections\n");
                builder.append("=======\n");
                builder.append(worldManager.getSections().stream().map(this::getSectionDisplayString).collect(Collectors.joining("\n")));
                sender.sendMessage(builder.toString());
                return true;
            }
        }

        return false;
    }

    private String getSectionDisplayString(Section section) {
        return section.getKey().getName() +
                ChatColor.WHITE +
                " [" + section.getKeyForSectionAbove().getName() +
                ChatColor.WHITE +
                "," + section.getKeyForSectionBelow().getName() +
                ChatColor.WHITE + "]";
    }
}
