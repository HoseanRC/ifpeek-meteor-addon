package org.hoseanrc.ifsv;

import org.hoseanrc.ifsv.commands.IFSVCommand;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import org.slf4j.Logger;

public class IFSVAddon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOG.info("Initializing itemframe shulker viewer");

        // Commands
        Commands.get().add(new IFSVCommand());
    }

    @Override
    public String getPackage() {
        return "org.hoseanrc.ifsv";
    }
}
