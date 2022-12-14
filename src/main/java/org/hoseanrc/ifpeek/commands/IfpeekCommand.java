package org.hoseanrc.ifpeek.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.utils.Utils;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.entity.decoration.GlowItemFrameEntity;
import net.minecraft.item.ItemStack;
import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class IfpeekCommand extends Command {
        private static final ItemStack[] ITEMS = new ItemStack[27];
    public IfpeekCommand() {
        super("ifpeek", "shows whats inside a shulker on itemframe.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(this::run);
    }

    private int run(CommandContext<CommandSource> context) {
        if (mc.targetedEntity == null || !(mc.targetedEntity instanceof ItemFrameEntity itemframe) || !(mc.targetedEntity instanceof GlowItemFrameEntity)) {
            info("you have to point at an itemframe first.");
            return SINGLE_SUCCESS;
        }

        ItemStack shulker = itemframe.getHeldItemStack();
        if (shulker == ItemStack.EMPTY) {
            info("there is no item on the itemframe.");
            return SINGLE_SUCCESS;
        }
        if (!Utils.isShulker(shulker.getItem())) {
            info("this item is not a shulker!");
            return SINGLE_SUCCESS;
        }
        if (!Utils.hasItems(shulker)) {
            info("the shulker is empty!");
            return SINGLE_SUCCESS;
        }
        if (Utils.openContainer(shulker, ITEMS, true)) return SINGLE_SUCCESS;
        else if (Utils.openContainer(shulker, ITEMS, true)) return SINGLE_SUCCESS;
        return SINGLE_SUCCESS;
    }
}
