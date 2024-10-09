package me.adarsh.autoupdate;

import de.craftleben.core.manager.Prefix;

/**
 * The entrance point of the ViaVersionAutoUpdate program
 */
public class ViaVersionAutoUpdate {

    private IPlugin plugin;

    public ViaVersionAutoUpdate(IPlugin plugin) {
        this.plugin = plugin;

        // Check for an update on startup,
        new UpdateChecker(this).run();
    }

    /**
     * Get the plugin
     * @return The IPlugin for this instance
     */
    public IPlugin getPlugin() {
        return plugin;
    }

    /**
     * Restarts the server after a 5 minute countdown
     */
    public void startRestartCountdown() {
        // 0 seconds from now
        plugin.runTaskLaterAsync(() -> {
            plugin.broadcastMessage(Prefix.CURRENT + "Ein Update wird in §e5 Minuten §7automatisiert aufgespielt");
        }, 0);

        // 3 minutes from now
        plugin.runTaskLaterAsync(() -> {
            plugin.broadcastMessage(Prefix.CURRENT + "Ein Update wird in §e2 Minuten §7automatisiert aufgespielt");
        }, 3*60);

        // 4 minutes from now
        plugin.runTaskLaterAsync(() -> {
            plugin.broadcastMessage(Prefix.CURRENT + "Ein Update wird in §e1 Minute §7automatisiert aufgespielt");
        }, 4*60);

        // 4 minutes and a half from now
        plugin.runTaskLaterAsync(() -> {
            plugin.broadcastMessage(Prefix.CURRENT + "Ein Update wird in §e30 Sekunden §7automatisiert aufgespielt");
        }, 4*60 + 30);

        // 5 minutes from now
        plugin.runTaskLaterAsync(() -> {
            plugin.restart();
        }, 5*60);
    }
}