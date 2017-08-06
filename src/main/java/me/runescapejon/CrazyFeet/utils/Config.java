package me.runescapejon.CrazyFeet.utils;

import me.runescapejon.CrazyFeet.CrazyFeet;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.spongepowered.api.Sponge;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Config {

    public static final int AUTO_SAVE_DELAY = 600;

    private String name;
    private boolean autoSave;
    private File file;
    private ConfigurationLoader<CommentedConfigurationNode> loader;
    private ConfigurationNode node;

    public Config(String name, boolean autoSave) {
        this.name = name;
        this.autoSave = autoSave;
    }

    public void activate() {
        try {
            file = new File(CrazyFeet.getInstance().getConfigDirectory(), name);
            loader = HoconConfigurationLoader.builder().setFile(file).build();
            node = loader.load();
            if (!file.exists()) {
                file.createNewFile();
                URL defaultsURL = CrazyFeet.class.getResource("/" + name);
                ConfigurationLoader<CommentedConfigurationNode> defaultsLoader =
                        HoconConfigurationLoader.builder().setURL(defaultsURL).build();
                ConfigurationNode defaultsNode = defaultsLoader.load();
                node.mergeValuesFrom(defaultsNode);
                save();
            }
            if (autoSave) {
                Sponge.getScheduler().createTaskBuilder().async().execute(this::save).
                        interval(AUTO_SAVE_DELAY, TimeUnit.SECONDS).submit(CrazyFeet.getInstance());
            }
        } catch (Exception e) {
            CrazyFeet.getInstance().getLogger().warn("Exception during config initialization \"" + getName() + "\"!", e);
        }
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    protected void setFile(File file) {
        this.file = file;
    }

    public ConfigurationLoader<CommentedConfigurationNode> getLoader() {
        return loader;
    }

    protected void setLoader(ConfigurationLoader<CommentedConfigurationNode> loader) {
        this.loader = loader;
    }

    public ConfigurationNode getNode() {
        return node;
    }

    protected void setNode(ConfigurationNode node) {
        this.node = node;
    }

    public ConfigurationNode getNode(Object... objects) {
        return node.getNode(objects);
    }

    public void save() {
        try {
            loader.save(node);
            CrazyFeet.getInstance().getLogger().info("Config \"" + name + "\" successfully saved!");
        } catch (Exception e) {
            CrazyFeet.getInstance().getLogger().warn("Fail saving config \"" + name + "\"!", e);
        }
    }

    public void reload() {
        try {
            node = loader.load();
            CrazyFeet.getInstance().getLogger().info("Config \"" + name + "\" successfully reloaded!");
        } catch (Exception e) {
            CrazyFeet.getInstance().getLogger().warn("Fail reloading config \"" + name + "\"!", e);
        }
    }
}