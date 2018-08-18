package com.derongan.minecraft.deeperworld.world.section;

import org.bukkit.ChatColor;

public interface SectionKey {
    SectionKey TERMINAL = new SectionKey() {
        @Override
        public String getName() {
            return ChatColor.RED + "TERMINAL";
        }
    };

    String getName();
}
