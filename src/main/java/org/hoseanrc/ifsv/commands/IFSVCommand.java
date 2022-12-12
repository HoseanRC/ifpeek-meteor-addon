package org.hoseanrc.ifsv.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class IFSVCommand extends Command {
    public IFSVCommand() {
        super("ifsv", "shows whats inside a shulker on itemframe.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            info("hi");
            return SINGLE_SUCCESS;
        });
    }
}
