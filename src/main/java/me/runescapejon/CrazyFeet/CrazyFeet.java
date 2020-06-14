package me.runescapejon.CrazyFeet;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import me.runescapejon.CrazyFeet.Commands.*;
import me.runescapejon.CrazyFeet.Commands.ColorHelix.*;
import me.runescapejon.CrazyFeet.utils.Config;
import me.runescapejon.CrazyFeet.utils.ConfigUtils;
import ninja.leaping.configurate.ConfigurationOptions;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.GuiceObjectMapperFactory;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.effect.particle.ParticleEffect;
import org.spongepowered.api.effect.particle.ParticleOptions;
import org.spongepowered.api.effect.particle.ParticleTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.world.World;

import me.runescapejon.CrazyFeet.Commands.Util.CrazyCheckCommands;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyDisableCmds;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyFeetAdminCmd;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyFeetCommands;
import me.runescapejon.CrazyFeet.Listeners.CrazyListener;
import me.runescapejon.CrazyFeet.Commands.head.CrazyFireHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyHeartHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyMagicHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyNoteHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyPearlHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazySmokeHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyWitchHeadCommand;

@Plugin(id = "crazyfeetsponge", name = "CrazyFeetSponge", authors = {
		"runescapejon" }, description = "CrazyFeet Ported over to Sponge", version = "1.16")
public class CrazyFeet {
	private static ArrayList<UUID> crazyFireHead = new ArrayList<>();
	private static ArrayList<UUID> crazyHeartHead = new ArrayList<>();
	private static ArrayList<UUID> crazyMagicHead = new ArrayList<>();
	private static ArrayList<UUID> crazyNoteHead = new ArrayList<>();
	private static ArrayList<UUID> crazyWitchHead = new ArrayList<>();
	private static ArrayList<UUID> crazySmokeHead = new ArrayList<>();
	private static ArrayList<UUID> crazyPearlHead = new ArrayList<>();
	private static ArrayList<UUID> crazyFire = new ArrayList<>();
	private static ArrayList<UUID> crazySmoke = new ArrayList<>();
	private static ArrayList<UUID> crazyMagic = new ArrayList<>();
	private static ArrayList<UUID> crazyPearl = new ArrayList<>();
	private static ArrayList<UUID> crazyNote = new ArrayList<>();
	private static ArrayList<UUID> crazyWitch = new ArrayList<>();
	private static ArrayList<UUID> crazyHeart = new ArrayList<>();
	private static ArrayList<UUID> bluehelix = new ArrayList<>();
	private static ArrayList<UUID> whitehelix = new ArrayList<>();
	private static ArrayList<UUID> Greenhelix = new ArrayList<>();
	private static ArrayList<UUID> Redhelix = new ArrayList<>();
	private static ArrayList<UUID> globe = new ArrayList<>();
	private static ArrayList<UUID> Purplehelix = new ArrayList<>();
	private static ArrayList<UUID> Yellowhelix = new ArrayList<>();
	private static ArrayList<UUID> Orangehelix = new ArrayList<>();
	private static ArrayList<UUID> Brownhelix = new ArrayList<>();
	private static ArrayList<UUID> Storm = new ArrayList<>();
	private static CrazyFeet instance;
	@SuppressWarnings("unused")
	private ConfigUtils configoptions;
	private CrazyFeet pl;
	private GuiceObjectMapperFactory factory;

	@Inject
	public CrazyFeet(Logger logger, @ConfigDir(sharedRoot = false) File configDir, GuiceObjectMapperFactory factory) {
		this.logger = logger;
		this.configDirectory = configDir;
		this.factory = factory;
	}

	public static CrazyFeet getInstance() {
		return instance;
	}

	@Inject
	private Logger logger;

	@Inject()
	@ConfigDir(sharedRoot = false)
	private File configDirectory;

	private Config languageConfig = new Config("language.conf", false);

	@Listener
	public void onConstruct(GameConstructionEvent event) {
		instance = this;
	}

	private static PluginContainer plugin;

	@Listener
	public void onPreInitializationEvent(GamePreInitializationEvent event) {
		plugin = Sponge.getPluginManager().getPlugin("crazyfeetsponge").get();
		instance = this;
		pl = this;
	}

	public static PluginContainer getPlugin() {
		return plugin;
	}

	@Listener
	public void onGamePreInitialization(GamePreInitializationEvent event) {

		loadConfig();
	}

	@Listener
	public void onGameInitlization(GameInitializationEvent event) {
		pl = this;
		// CrazyFeet Register
		HashMap<List<String>, CommandSpec> subcommands = new HashMap<>();
		subcommands.put(Collections.singletonList("admin"),
				CommandSpec.builder().description(Text.of("crazyfeet admin")).permission("crazyfeet.admin")
						.executor(new CrazyFeetAdminCmd()).build());

		CommandSpec CrazyFeetSpec = CommandSpec.builder().description(Text.of("crazyfeet"))
				.permission("crazyfeet.crazyfeet").executor(new CrazyFeetCommands()).children(subcommands).build();
		Sponge.getCommandManager().register(this, CrazyFeetSpec, "crazyfeet");

		// CrazyHeadListener Registering here
		CrazyListener head = new CrazyListener();
		Sponge.getEventManager().registerListeners(this, head);

		Sponge.getEventManager().registerListeners(this, new GuiCommand());

		Sponge.getEventManager().registerListeners(this, new HelixGUICommand());

		Sponge.getEventManager().registerListeners(this, new GuiPage2Cmd());

		CommandSpec reload = CommandSpec.builder().description(Text.of("reloads crazyfeet configs!"))
				.permission("crazyfeet.reload").executor(new CrazyFeetReloadCommand()).build();
		Sponge.getCommandManager().register(this, reload, "crazyfeetreload");

		CommandSpec gui = CommandSpec.builder().description(Text.of("crazy a nice gui for crazyfeet particles"))
				.permission("crazyfeet.crazygui").executor(new GuiCommand()).build();
		Sponge.getCommandManager().register(this, gui, "crazymenu", "crazygui");

		// CrazyWitchHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyWitchHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Pearl Head particles"))
				.permission("crazyfeet.crazywitchhead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyWitchHeadCommand()).build();
		// adding alises /cwh for CrazyWitchhead
		Sponge.getCommandManager().register(this, CrazyWitchHeadSpec, "crazywitchhead", "cwh");

		// CrazySmokeHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazySmokeHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Pearl Head particles"))
				.permission("crazyfeet.crazysmokehead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazySmokeHeadCommand()).build();
		// adding alises /csh for CrazySmokehead
		Sponge.getCommandManager().register(this, CrazySmokeHeadSpec, "crazysmokehead", "csh");

		// CrazyPearlHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyPearlHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Pearl Head particles"))
				.permission("crazyfeet.crazypearlhead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyPearlHeadCommand()).build();
		// adding alises /cph for CrazyPearlhead
		Sponge.getCommandManager().register(this, CrazyPearlHeadSpec, "crazypearlhead", "cph");

		// CrazyNoteHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazynoteHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Magic Head particles"))
				.permission("crazyfeet.crazynotehead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyNoteHeadCommand()).build();
		// adding alises /cph for crazypearlhead
		Sponge.getCommandManager().register(this, CrazynoteHeadSpec, "crazynotehead", "cnh");

		// CrazyMagicHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyMagicHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Magic Head particles"))
				.permission("crazyfeet.crazymagichead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyMagicHeadCommand()).build();
		// adding alises /cmh for crazymagichead
		Sponge.getCommandManager().register(this, CrazyMagicHeadSpec, "crazymagichead", "cmh");

		// CrazyHeartHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyHeartHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable fire Head particles"))
				.permission("crazyfeet.crazyfirehead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyHeartHeadCommand()).build();
		// adding alises /chh for crazyheartehead
		Sponge.getCommandManager().register(this, CrazyHeartHeadSpec, "crazyHearthead", "chh");

		// CrazyFireHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyFireHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable fire Head particles"))
				.permission("crazyfeet.crazyfirehead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyFireHeadCommand()).build();
		// adding alises /cfh for crazyfirehead
		Sponge.getCommandManager().register(this, CrazyFireHeadSpec, "crazyfirehead", "cfh");

		// CrazyFire <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyFireSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable fire particles")).permission("crazyfeet.crazyfire")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyFireCommands()).build();
		Sponge.getCommandManager().register(this, CrazyFireSpec, "crazyfire");

		// Crazynote <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyNoteSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable note particles")).permission("crazyfeet.crazynote")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyNoteCommands()).build();
		Sponge.getCommandManager().register(this, CrazyNoteSpec, "crazynote");

		// Crazymagic <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyMagicSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable magic particles")).permission("crazyfeet.crazymagic")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyMagicCommands()).build();
		Sponge.getCommandManager().register(this, CrazyMagicSpec, "crazymagic");

		// Crazyheart <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyHeartSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable heart particles")).permission("crazyfeet.crazyheart")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyHeartCommands()).build();
		Sponge.getCommandManager().register(this, CrazyHeartSpec, "crazyheart");

		// CrazySmoke <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazySmokeSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable Smoke particles")).permission("crazyfeet.crazysmoke")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazySmokeCommands()).build();
		Sponge.getCommandManager().register(this, CrazySmokeSpec, "crazysmoke");

		// CrazyPearl <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazypearlSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable Pearl particles")).permission("crazyfeet.crazypearl")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyPearlCommands()).build();
		Sponge.getCommandManager().register(this, CrazypearlSpec, "crazypearl");

		// CrazyWitch <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyWitchSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable Witch particles")).permission("crazyfeet.crazywitch")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyWitchCommands()).build();
		Sponge.getCommandManager().register(this, CrazyWitchSpec, "crazywitch");

		CommandSpec CrazyHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazybluehelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyBlueHelixCommands()).build();
		Sponge.getCommandManager().register(this, CrazyHelixSpec, "crazybluehelix");

		CommandSpec CrazyCheckSpec = CommandSpec.builder()
				.description(Text.of("crazycheck your particles status - helpful to see what enabled"))
				.permission("crazyfeet.crazycheck")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyCheckCommands()).build();
		Sponge.getCommandManager().register(this, CrazyCheckSpec, "crazycheck");

		// crazydisable <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyDisableSpec = CommandSpec.builder()
				.description(Text.of("crazydisable disable your/other particles all of them"))
				.permission("crazyfeet.crazydisable")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyDisableCmds()).build();
		Sponge.getCommandManager().register(this, CrazyDisableSpec, "crazydisable");

		CommandSpec CrazyRingSpec = CommandSpec.builder()
				.description(Text.of("crazyglobe to enable/disable globe particles")).permission("crazyfeet.crazyglobe")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyGlobeCommands()).build();
		Sponge.getCommandManager().register(this, CrazyRingSpec, "crazyglobe");

		CommandSpec CrazyhelixmenuSpec = CommandSpec.builder()
				.description(Text.of("crazyguihelix access Gui for helixes colors")).executor(new HelixGUICommand())
				.build();
		Sponge.getCommandManager().register(this, CrazyhelixmenuSpec, "crazyhelixmenu");

		CommandSpec CrazywhiteHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazywhitehelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyWhiteHelixCommands()).build();
		Sponge.getCommandManager().register(this, CrazywhiteHelixSpec, "crazywhitehelix");

		CommandSpec CrazyGreenHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazygreenhelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyGreenHelixCommands()).build();
		Sponge.getCommandManager().register(this, CrazyGreenHelixSpec, "crazygreenhelix");

		CommandSpec CrazyGui2Spec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles")).executor(new GuiPage2Cmd())
				.permission("crazyfeet.crazygui").build();
		Sponge.getCommandManager().register(this, CrazyGui2Spec, "crazymenu2");

		CommandSpec CrazyRedHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazyredhelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyRedHelixCommands()).permission("crazyfeet.crazygui").build();
		Sponge.getCommandManager().register(this, CrazyRedHelixSpec, "crazyredhelix");

		CommandSpec CrazypurpleHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazypurplehelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyPurpleHelixCommand()).build();
		Sponge.getCommandManager().register(this, CrazypurpleHelixSpec, "crazypurplehelix");

		CommandSpec CrazyyellowHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazyyellowhelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyYellowHelixCommands()).build();
		Sponge.getCommandManager().register(this, CrazyyellowHelixSpec, "crazyyellowhelix");

		CommandSpec CrazyOrangeHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazyorangehelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyOrangeHelixCommand()).build();
		Sponge.getCommandManager().register(this, CrazyOrangeHelixSpec, "crazyorangehelix");

		CommandSpec CrazyBrownHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazybrownhelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyBrownHelixCommands()).build();
		Sponge.getCommandManager().register(this, CrazyBrownHelixSpec, "crazybrownhelix");

		CommandSpec CrazystormSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Storm Particles")).permission("crazyFeet.crazystorm")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(
								GenericArguments.optional(GenericArguments.player(Text.of("target"))),
								GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyStormCommand()).build();
		Sponge.getCommandManager().register(this, CrazystormSpec, "crazystorm");
	}

	public boolean loadConfig() {
		if (!configDirectory.exists()) {
			configDirectory.mkdirs();
		}
		languageConfig.activate();
		try {
			File configFile = new File(getConfigDirectory(), "configuration.conf");
			if (!configFile.exists()) {
				configFile.createNewFile();
				logger.info("Creating Config for CrazyFeet");
			}
			ConfigurationLoader<CommentedConfigurationNode> loader = HoconConfigurationLoader.builder()
					.setFile(configFile).build();
			CommentedConfigurationNode config = loader.load(ConfigurationOptions.defaults()
					.setObjectMapperFactory(pl.getFactory()).setShouldCopyDefaults(true));
			configoptions = config.getValue(TypeToken.of(ConfigUtils.class), new ConfigUtils());
			loader.save(config);
			return true;
		} catch (Exception error) {
			getLogger().error("coudnt make the config", error);
			return false;
		}
	}

	public GuiceObjectMapperFactory getFactory() {
		return factory;
	}

	public Logger getLogger() {
		return logger;
	}

	public File getConfigDirectory() {
		return configDirectory;
	}

	public Config getLanguageConfig() {
		return languageConfig;
	}

	public ArrayList<UUID> getCrazyFireHead() {
		return crazyFireHead;
	}

	public ArrayList<UUID> getCrazyHeartHead() {
		return crazyHeartHead;
	}

	public ArrayList<UUID> getCrazyMagicHead() {
		return crazyMagicHead;
	}

	public ArrayList<UUID> getCrazyNoteHead() {
		return crazyNoteHead;
	}

	public ArrayList<UUID> getCrazyWitchHead() {
		return crazyWitchHead;
	}

	public ArrayList<UUID> getCrazySmokeHead() {
		return crazySmokeHead;
	}

	public ArrayList<UUID> getCrazyPearlHead() {
		return crazyPearlHead;
	}

	public ArrayList<UUID> getCrazyFire() {
		return crazyFire;
	}

	public ArrayList<UUID> getCrazySmoke() {
		return crazySmoke;
	}

	public ArrayList<UUID> getCrazyMagic() {
		return crazyMagic;
	}

	public ArrayList<UUID> getCrazyPearl() {
		return crazyPearl;
	}

	public ArrayList<UUID> getCrazyNote() {
		return crazyNote;
	}

	public ArrayList<UUID> getCrazyWitch() {
		return crazyWitch;
	}

	public ArrayList<UUID> getCrazyHeart() {
		return crazyHeart;
	}

	private void BrownHelix(Player player) {
		helixMath(player, Color.ofRgb(127, 85, 42));
	}

	private void YellowHelix(Player player) {
		helixMath(player, Color.ofRgb(249, 255, 48));
	}

	private void OrangeHelix(Player player) {
		helixMath(player, Color.ofRgb(249, 119, 7));
	}

	private void purpleHelix(Player player) {
		helixMath(player, Color.ofRgb(255, 0, 255));
	}

	private void RedHelix(Player player) {
		helixMath(player, Color.ofRgb(255, 0, 0));
	}

	private void GreenHelix(Player player) {
		helixMath(player, Color.ofRgb(2, 255, 15));
	}

	private void WhiteHelix(Player player) {
		helixMath(player, Color.ofRgb(255, 255, 255));
	}

	private void BlueHelix(Player player) {
		helixMath(player, Color.ofRgb(15, 86, 253));
	}

	public ArrayList<UUID> getCrazyBrownHelix() {
		return Brownhelix;
	}

	public ArrayList<UUID> getCrazyYellowHelix() {
		return Yellowhelix;
	}

	public ArrayList<UUID> getCrazyOrangeHelix() {
		return Orangehelix;
	}

	public ArrayList<UUID> getCrazyPurpleHelix() {
		return Purplehelix;
	}

	public ArrayList<UUID> getCrazyRedHelix() {
		return Redhelix;
	}

	public ArrayList<UUID> getCrazyGreenHelix() {
		return Greenhelix;
	}

	public ArrayList<UUID> getCrazyWhiteHelix() {
		return whitehelix;
	}

	public ArrayList<UUID> getCrazyBlueHelix() {
		return bluehelix;
	}

	public ArrayList<UUID> getCrazyGlobe() {
		return globe;
	}

	public ArrayList<UUID> getCrazyStorm() {
		return Storm;

	}

	public static void clearHelixPlayer(Player player) {
		if (Brownhelix.contains(player.getUniqueId())) {
			Brownhelix.remove(player.getUniqueId());
		}
		if (Yellowhelix.contains(player.getUniqueId())) {
			Yellowhelix.remove(player.getUniqueId());
		}
		if (Orangehelix.contains(player.getUniqueId())) {
			Orangehelix.remove(player.getUniqueId());
		}
		if (Purplehelix.contains(player.getUniqueId())) {
			Purplehelix.remove(player.getUniqueId());
		}
		if (Redhelix.contains(player.getUniqueId())) {
			Redhelix.remove(player.getUniqueId());
		}
		if (Greenhelix.contains(player.getUniqueId())) {
			Greenhelix.remove(player.getUniqueId());
		}
		if (whitehelix.contains(player.getUniqueId())) {
			whitehelix.remove(player.getUniqueId());
		}
		if (bluehelix.contains(player.getUniqueId())) {
			bluehelix.remove(player.getUniqueId());
		}
	}

	public static void clearPlayer(Player player) {
		if (Brownhelix.contains(player.getUniqueId())) {
			Brownhelix.remove(player.getUniqueId());
		}
		if (Yellowhelix.contains(player.getUniqueId())) {
			Yellowhelix.remove(player.getUniqueId());
		}
		if (Orangehelix.contains(player.getUniqueId())) {
			Orangehelix.remove(player.getUniqueId());
		}
		if (Purplehelix.contains(player.getUniqueId())) {
			Purplehelix.remove(player.getUniqueId());
		}
		if (Redhelix.contains(player.getUniqueId())) {
			Redhelix.remove(player.getUniqueId());
		}
		if (Greenhelix.contains(player.getUniqueId())) {
			Greenhelix.remove(player.getUniqueId());
		}
		if (whitehelix.contains(player.getUniqueId())) {
			whitehelix.remove(player.getUniqueId());
		}
		if (bluehelix.contains(player.getUniqueId())) {
			bluehelix.remove(player.getUniqueId());
		}
		if (globe.contains(player.getUniqueId())) {
			globe.remove(player.getUniqueId());
		}
		if (crazyFire.contains(player.getUniqueId())) {
			crazyFire.remove(player.getUniqueId());
		}
		if (crazyNote.contains(player.getUniqueId())) {
			crazyNote.remove(player.getUniqueId());
		}
		if (crazyHeart.contains(player.getUniqueId())) {
			crazyHeart.remove(player.getUniqueId());
		}
		if (crazyMagic.contains(player.getUniqueId())) {
			crazyMagic.remove(player.getUniqueId());
		}
		if (crazyNote.contains(player.getUniqueId())) {
			crazyNote.remove(player.getUniqueId());
		}
		if (crazyPearl.contains(player.getUniqueId())) {
			crazyPearl.remove(player.getUniqueId());
		}
		if (crazySmoke.contains(player.getUniqueId())) {
			crazySmoke.remove(player.getUniqueId());
		}
		if (Storm.contains(player.getUniqueId())) {
			Storm.remove(player.getUniqueId());
		}
		if (crazyWitchHead.contains(player.getUniqueId())) {
			crazyWitchHead.remove(player.getUniqueId());
		}
		if (crazyFireHead.contains(player.getUniqueId())) {
			crazyFireHead.remove(player.getUniqueId());
		}
		if (crazyNoteHead.contains(player.getUniqueId())) {
			crazyNoteHead.remove(player.getUniqueId());
		}
		if (crazyHeartHead.contains(player.getUniqueId())) {
			crazyHeartHead.remove(player.getUniqueId());
		}
		if (crazyMagicHead.contains(player.getUniqueId())) {
			crazyMagicHead.remove(player.getUniqueId());
		}
		if (crazyNoteHead.contains(player.getUniqueId())) {
			crazyNoteHead.remove(player.getUniqueId());
		}
		if (crazyPearlHead.contains(player.getUniqueId())) {
			crazyPearlHead.remove(player.getUniqueId());
		}
		if (crazySmokeHead.contains(player.getUniqueId())) {
			crazySmokeHead.remove(player.getUniqueId());
		}
		if (Storm.contains(player.getUniqueId())) {
			Storm.remove(player.getUniqueId());
		}
		if (crazyWitch.contains(player.getUniqueId())) {
			crazyWitch.remove(player.getUniqueId());
		}
	}

	private void cloudMath(Player player, double x, double y, double z) {
		World world = player.getWorld();
		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.CLOUD).build(),
				player.getLocation().getPosition().add(x, y, z));
	}

	private void helixMath(Player player, Color c) {
		phi = phi + Math.PI / 16;
		double x, y, z;
		for (double t = 0; t <= 2 * Math.PI; t = t + Math.PI / 16) {
			for (double i = 0; i <= 1; i = i + 1) {
				x = 0.15 * (2 * Math.PI - t) * Math.cos(t + phi + i * Math.PI);
				y = 0.5 * t;
				z = 0.15 * (2 * Math.PI - t) * Math.sin(t + phi + i * Math.PI);
				World world = player.getWorld();
				world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
						.option(ParticleOptions.COLOR, c).build(), player.getLocation().getPosition().add(x, y, z));

			}
		}
	}

	private void StyleGlobe(Player player) {
		pi += Math.PI / 10;
		for (double theta = 0; theta <= 2 * Math.PI; theta += Math.PI / 40) {
			double r = 1.5;
			double x = r * Math.cos(theta) * Math.sin(pi);
			double y = r * Math.cos(pi) + 1.5;
			double z = r * Math.sin(theta) * Math.sin(pi);

			// double z = r*Math.sin(theta)+Math.sin(pi);
			World world = player.getWorld();
			world.spawnParticles(
					ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
							.option(ParticleOptions.COLOR, Color.ofRgb(255, 0, 0)).build(),
					player.getLocation().getPosition().add(x, y, z));

		}
	}

	private void Cloud(Player player) {
		cloudMath(player, 0, 2.5, 0);
		cloudMath(player, 0.2, 2.5, 0.2);
		cloudMath(player, 0, 2.5, 0.4);
		cloudMath(player, 0.4, 2.5, 0);
	}

	private void Rain(Player player) {
		World world = player.getWorld();
		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.WATER_DROP).build(),
				player.getLocation().getPosition().add(0, 2.5, 0));
	}

	private double phi = 0;
	private double pi = 0;

	@Listener
	public void onServerStart(GameStartedServerEvent event) {
		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("globe").execute(() -> {
			if (!globe.isEmpty()) {
				globe.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::StyleGlobe));
			}
		}).submit(this);

		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("blueHelix").execute(() -> {
			if (!bluehelix.isEmpty()) {
				bluehelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::BlueHelix));
			}
		}).submit(this);

		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("brownHelix").execute(() -> {
			if (!Brownhelix.isEmpty()) {
				Brownhelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::BrownHelix));
			}
		}).submit(this);

		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("greenHelix").execute(() -> {
			if (!Greenhelix.isEmpty()) {
				Greenhelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::GreenHelix));
			}
		}).submit(this);

		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("yellowHelix").execute(() -> {
			if (!Yellowhelix.isEmpty()) {
				Yellowhelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::YellowHelix));
			}
		}).submit(this);

		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("orangeHelix").execute(() -> {
			if (!Orangehelix.isEmpty()) {
				Orangehelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::OrangeHelix));
			}
		}).submit(this);

		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("purpleHelix").execute(() -> {
			if (!Purplehelix.isEmpty()) {
				Purplehelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::purpleHelix));
			}
		}).submit(this);

		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("whiteHelix").execute(() -> {
			if (!whitehelix.isEmpty()) {
				whitehelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::WhiteHelix));
			}
		}).submit(this);

		Task.builder().interval(63, TimeUnit.MILLISECONDS).name("redHelix").execute(() -> {
			if (!Redhelix.isEmpty()) {
				Redhelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::RedHelix));
			}
		}).submit(this);

		Task.builder().intervalTicks(1).execute(() -> {
			if (!Storm.isEmpty()) {
				Storm.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::Cloud));
				Storm.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::Rain));
			}
		}).submit(this);
	}

	// this here is basically so i can test and do a bit of math
	// so i can add new particle animation and things like that you can ignore this
	/*
	 * public void test(Player player) { for (int degree = 90; degree < 360;
	 * degree++) { double radians = Math.toRadians(degree); double x =
	 * Math.cos(radians); double z = Math.sin(radians); World world =
	 * player.getWorld(); world.spawnParticles(
	 * ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
	 * .option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
	 * player.getLocation().getPosition().add(x, 2.5, z)); } for (int degree = 90;
	 * degree < 360; degree++) { double radians = Math.toRadians(degree); double x =
	 * Math.cos(radians); double z = Math.sin(radians); World world =
	 * player.getWorld(); world.spawnParticles(
	 * ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
	 * .option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
	 * player.getLocation().getPosition().add(x, 1.5, z)); } for (int degree = 90;
	 * degree < 360; degree++) { double radians = Math.toRadians(degree); double x =
	 * Math.cos(radians); double z = Math.sin(radians); World world =
	 * player.getWorld(); world.spawnParticles(
	 * ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST)
	 * .option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
	 * player.getLocation().getPosition().add(x, 0.1, z)); } }
	 */

}
