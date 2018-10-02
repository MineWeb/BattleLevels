package fr.phpierre.battlelevelsmineweb;

import fr.phpierre.battlelevelsmineweb.methods.GetBattleLevels;
import fr.phpierre.battlelevelsmineweb.methods.GetBattlePlayer;
import fr.vmarchaud.mineweb.bukkit.BukkitCore;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {

    @Override
    public void onEnable() {
        String version = Bukkit.getPluginManager().getPlugin("BattleLevels").getDescription().getVersion();
        BukkitCore.get().getMethods().put("GET_BATTLELEVEL_LIST", new GetBattleLevels());
        BukkitCore.get().getMethods().put("GET_BATTLELEVEL_PLAYER", new GetBattlePlayer());
    }

    @Override
    public void onDisable() {
    }

}
