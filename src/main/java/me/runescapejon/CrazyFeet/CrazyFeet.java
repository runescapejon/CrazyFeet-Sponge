package me.runescapejon.CrazyFeet;

import java.io.File;
import java.util.*;

import com.google.inject.Inject;
import me.runescapejon.CrazyFeet.Commands.*;
import me.runescapejon.CrazyFeet.Commands.ColorHelix.CrazyBlueHelixCommands;
import me.runescapejon.CrazyFeet.Commands.ColorHelix.CrazyGreenHelixCommands;
import me.runescapejon.CrazyFeet.Commands.ColorHelix.*;
import me.runescapejon.CrazyFeet.utils.Config;
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
import me.runescapejon.CrazyFeet.Listeners.CrazyFeetListener;
import me.runescapejon.CrazyFeet.Listeners.CrazyHeadListener;
import me.runescapejon.CrazyFeet.Commands.head.CrazyFireHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyHeartHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyMagicHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyNoteHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyPearlHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazySmokeHeadCommand;
import me.runescapejon.CrazyFeet.Commands.head.CrazyWitchHeadCommand;
import me.runescapejon.CrazyFeet.CrazyFeet;

@Plugin(id = "crazyfeetsponge", name = "CrazyFeetSponge", authors = {"runescapejon"}, description = "CrazyFeet Ported over to Sponge", version = "1.9")
public class CrazyFeet {

	private static CrazyFeet instance;

	public static CrazyFeet getInstance() {
		return instance;
	}

	private ArrayList<UUID> crazyFireHead = new ArrayList<>();
	private ArrayList<UUID> crazyHeartHead = new ArrayList<>();
	private ArrayList<UUID> crazyMagicHead = new ArrayList<>();
	private ArrayList<UUID> crazyNoteHead = new ArrayList<>();
	private ArrayList<UUID> crazyWitchHead = new ArrayList<>();
	private ArrayList<UUID> crazySmokeHead = new ArrayList<>();
	private ArrayList<UUID> crazyPearlHead = new ArrayList<>();
	private ArrayList<UUID> crazyFire = new ArrayList<>();
	private ArrayList<UUID> crazySmoke = new ArrayList<>();
	private ArrayList<UUID> crazyMagic = new ArrayList<>();
	private ArrayList<UUID> crazyPearl = new ArrayList<>();
	private ArrayList<UUID> crazyNote = new ArrayList<>();
	private ArrayList<UUID> crazyWitch = new ArrayList<>();
	private ArrayList<UUID> crazyHeart = new ArrayList<>();
	private ArrayList<UUID> bluehelix = new ArrayList<>();
	private ArrayList<UUID> whitehelix = new ArrayList<>();
	private ArrayList<UUID> Greenhelix = new ArrayList<>();
	private ArrayList<UUID> globe = new ArrayList<>();

	
	//private File autoFirePlayers;
	//public static CrazyAutoSmokeFile aSmokeP;
	//public static CrazyAutoPearlFile aPearlP;
	//public static CrazyAutoMagicFile aMagicP;
    //public static CrazyAutonoteFile anoteP;
	//public static CrazyAutoWitchFile aWitchP;
	//public static CrazyAutoHeartFile aHeartP;

	
	
	//rewriting this
	/**
	String folder = this.getDataFolder().getAbsolutePath();
	(new File(folder)).mkdir();
	*/

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
	}
	public static PluginContainer getPlugin() {
		return plugin;
	}
	
	@Listener
	public void onGamePreInitialization(GamePreInitializationEvent event) {
		if (!configDirectory.exists()) {
			configDirectory.mkdirs();
		}
		languageConfig.activate();
	}

	@Listener
	public void onGameInitlization(GameInitializationEvent event) {
		// CrazyFeet Register
		HashMap<List<String>, CommandSpec> subcommands = new HashMap<>();
		subcommands.put(Collections.singletonList("admin"), CommandSpec.builder()
				.description(Text.of("crazyfeet admin"))
				.permission("crazyfeet.admin")
				.executor(new CrazyFeetAdminCmd())
				.build());
		
		CommandSpec CrazyFeetSpec = CommandSpec.builder()
				.description(Text.of("crazyfeet"))
				.permission("crazyfeet.crazyfeet")
				.executor(new CrazyFeetCommands()).children(subcommands).build();
		Sponge.getCommandManager().register(this, CrazyFeetSpec, "crazyfeet");

		//CrazyFeetListener Registering Here
	Sponge.getEventManager().registerListeners(this, new CrazyFeetListener());
		
		//CrazyHeadListener Registering here
		CrazyHeadListener head = new CrazyHeadListener();
		Sponge.getEventManager().registerListeners(this, head);
		
	    Sponge.getEventManager().registerListeners(this, new GuiCommand());
		
	    Sponge.getEventManager().registerListeners(this, new HelixGUICommand());
	    
	    Sponge.getEventManager().registerListeners(this, new GuiPage2Cmd());
	    
		CommandSpec reload = CommandSpec.builder().
				description(Text.of("reloads crazyfeet configs!")).
				permission("crazyfeet.reload").
				executor(new CrazyFeetReloadCommand()).
				build();
		Sponge.getCommandManager().register(this, reload, "crazyfeetreload");

		CommandSpec gui = CommandSpec.builder()
				.description(Text.of("crazy a nice gui for crazyfeet particles"))
				.permission("crazyfeet.crazygui")
				.executor(new GuiCommand())
				.build();
		Sponge.getCommandManager().register(this, gui, "crazymenu", "crazygui");
		
		// CrazyWitchHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyWitchHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Pearl Head particles"))
				.permission("crazyfeet.crazywitchhead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyWitchHeadCommand())
				.build();
		//adding alises /cwh for CrazyWitchhead
		Sponge.getCommandManager().register(this, CrazyWitchHeadSpec, "crazywitchhead", "cwh");
		
		// CrazySmokeHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazySmokeHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Pearl Head particles"))
				.permission("crazyfeet.crazysmokehead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazySmokeHeadCommand())
				.build();
		//adding alises /csh for CrazySmokehead
		Sponge.getCommandManager().register(this, CrazySmokeHeadSpec, "crazysmokehead", "csh");
		
		// CrazyPearlHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyPearlHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Pearl Head particles"))
				.permission("crazyfeet.crazypearlhead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyPearlHeadCommand())
				.build();
		//adding alises /cph for CrazyPearlhead
		Sponge.getCommandManager().register(this, CrazyPearlHeadSpec, "crazypearlhead", "cph");	
		
		
		// CrazyNoteHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazynoteHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Magic Head particles"))
				.permission("crazyfeet.crazynotehead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyNoteHeadCommand())
				.build();
		//adding alises /cph for crazypearlhead
		Sponge.getCommandManager().register(this, CrazynoteHeadSpec, "crazynotehead", "cnh");	
		
		// CrazyMagicHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyMagicHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable Magic Head particles"))
				.permission("crazyfeet.crazymagichead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyMagicHeadCommand())
				.build();
		//adding alises /cmh for crazymagichead
		Sponge.getCommandManager().register(this, CrazyMagicHeadSpec, "crazymagichead", "cmh");	
		
		// CrazyHeartHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyHeartHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable fire Head particles"))
				.permission("crazyfeet.crazyfirehead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyHeartHeadCommand())
				.build();
		//adding alises /chh for crazyheartehead
		Sponge.getCommandManager().register(this, CrazyHeartHeadSpec, "crazyHearthead", "chh");
		
		// CrazyFireHead <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyFireHeadSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable fire Head particles"))
				.permission("crazyfeet.crazyfirehead")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyFireHeadCommand())
				.build();
		//adding alises /cfh for crazyfirehead
		Sponge.getCommandManager().register(this, CrazyFireHeadSpec, "crazyfirehead", "cfh");
		
		// CrazyFire <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyFireSpec = CommandSpec.builder()
				.description(Text.of("crazyfire to enable/disable fire particles"))
				.permission("crazyfeet.crazyfire")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyFireCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazyFireSpec, "crazyfire");
		
		// Crazynote <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyNoteSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable note particles"))
				.permission("crazyfeet.crazynote")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyNoteCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazyNoteSpec, "crazynote");

		// Crazymagic <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyMagicSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable magic particles"))
				.permission("crazyfeet.crazymagic")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyMagicCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazyMagicSpec, "crazymagic");
	
		// Crazyheart <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyHeartSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable heart particles"))
				.permission("crazyfeet.crazyheart")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyHeartCommands()).build();
		Sponge.getCommandManager().register(this, CrazyHeartSpec, "crazyheart");
		
		// CrazySmoke <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazySmokeSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable Smoke particles"))
				.permission("crazyfeet.crazysmoke")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazySmokeCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazySmokeSpec, "crazysmoke");
		
		// CrazyPearl <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazypearlSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable Pearl particles"))
				.permission("crazyfeet.crazypearl")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyPearlCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazypearlSpec, "crazypearl");
		
		// CrazyWitch <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyWitchSpec = CommandSpec.builder()
				.description(Text.of("crazymagic to enable/disable Witch particles"))
				.permission("crazyfeet.crazywitch")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyWitchCommands()).build();
		Sponge.getCommandManager().register(this, CrazyWitchSpec, "crazywitch");
	
		CommandSpec CrazyHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazybluehelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyBlueHelixCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazyHelixSpec, "crazybluehelix");

		CommandSpec CrazyCheckSpec = CommandSpec.builder()
				.description(Text.of("crazycheck your particles status - helpful to see what enabled"))
				.permission("crazyfeet.crazycheck")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyCheckCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazyCheckSpec, "crazycheck");
	
		//crazydisable <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyDisableSpec = CommandSpec.builder()
				.description(Text.of("crazydisable disable your/other particles all of them"))
				.permission("crazyfeet.crazydisable")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyDisableCmds())
				.build();
		Sponge.getCommandManager().register(this, CrazyDisableSpec, "crazydisable");
		
		CommandSpec CrazyRingSpec = CommandSpec.builder()
				.description(Text.of("crazyglobe to enable/disable globe particles"))
				.permission("crazyfeet.crazyglobe")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyGlobeCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazyRingSpec, "crazyglobe");
		
		CommandSpec CrazyhelixmenuSpec = CommandSpec.builder()
				.description(Text.of("crazyguihelix access Gui for helixes colors"))
				.permission("crazyfeet.crazyhelixmenu")
				//.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new HelixGUICommand())
				.build();
		Sponge.getCommandManager().register(this, CrazyhelixmenuSpec, "crazyhelixmenu");
	
		CommandSpec CrazywhiteHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazywhitehelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyWhiteHelixCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazywhiteHelixSpec, "crazywhitehelix");
		
		CommandSpec CrazyGreenHelixSpec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.permission("crazyFeet.crazygreenhelix")
				.arguments(GenericArguments.firstParsing(GenericArguments.flags().buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets")))))))
				.executor(new CrazyGreenHelixCommands())
				.build();
		Sponge.getCommandManager().register(this, CrazyGreenHelixSpec, "crazygreenhelix");
		
		
		CommandSpec CrazyGui2Spec = CommandSpec.builder()
				.description(Text.of("crazyhelix to enable/disable Helix Particles"))
				.executor(new GuiPage2Cmd())
				.build();
		Sponge.getCommandManager().register(this, CrazyGui2Spec, "crazymenu2");
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
	
	public ArrayList<UUID> getCrazyGreenHelix() {
		Greenhelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::playanimationGreen));
		return Greenhelix;
	}
    
	public void playanimationGreen(Player player){
		Task.builder().intervalTicks(3).execute(() -> { 
			Greenhelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::GreenHelix)); 
			}).submit(CrazyFeet.getInstance());
}
	public void GreenHelix(Player player) {
		phi = phi + Math.PI / 16;
	double x, y, z;
		for (double t = 0; t <= 2 * Math.PI; t = t + Math.PI / 16) {
			for (double i = 0; i <= 1; i = i + 1) {
				x = 0.15 * (2 * Math.PI - t) *Math.cos(t + phi + i * Math.PI);
				y = 0.5 * t;
				z = 0.15 * (2 * Math.PI - t) *Math.sin(t + phi + i * Math.PI);
				World world = player.getWorld();
				world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).option(ParticleOptions.COLOR, Color.ofRgb(2, 255, 15)).build(),
						player.getLocation().getPosition().add(x, y, z));
				
			}		
	   }
	}

	public ArrayList<UUID> getCrazyWhiteHelix() {
		whitehelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::playanimationWhite));
		return whitehelix;
	}
    
	public void playanimationWhite(Player player){
		Task.builder().intervalTicks(3).execute(() -> { 
			whitehelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::WhiteHelix)); 
			}).submit(CrazyFeet.getInstance());
}
	public void WhiteHelix(Player player) {
		phi = phi + Math.PI / 16;
	double x, y, z;
		for (double t = 0; t <= 2 * Math.PI; t = t + Math.PI / 16) {
			for (double i = 0; i <= 1; i = i + 1) {
				x = 0.15 * (2 * Math.PI - t) *Math.cos(t + phi + i * Math.PI);
				y = 0.5 * t;
				z = 0.15 * (2 * Math.PI - t) *Math.sin(t + phi + i * Math.PI);
				World world = player.getWorld();
				world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).option(ParticleOptions.COLOR, Color.ofRgb(255, 255, 255)).build(),
						player.getLocation().getPosition().add(x, y, z));
				
			}		
	   }
	}
	
	public ArrayList<UUID> getCrazyBlueHelix() {
		bluehelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::playanimation));
		return bluehelix;
	}

    Task task;
	public void playanimation(Player player){
		Task.builder().intervalTicks(3).execute(() -> { 
			bluehelix.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::BlueHelix)); 
			}).submit(CrazyFeet.getInstance());
}
	
    double phi = 0;
	public void BlueHelix(Player player) {
		phi = phi + Math.PI / 16;
	double x, y, z;
		for (double t = 0; t <= 2 * Math.PI; t = t + Math.PI / 16) {
			for (double i = 0; i <= 1; i = i + 1) {
				x = 0.15 * (2 * Math.PI - t) *Math.cos(t + phi + i * Math.PI);
				y = 0.5 * t;
				z = 0.15 * (2 * Math.PI - t) *Math.sin(t + phi + i * Math.PI);
				World world = player.getWorld();
				world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).option(ParticleOptions.COLOR, Color.ofRgb(15, 86, 253)).build(),
						player.getLocation().getPosition().add(x, y, z));
				
			}		
	   }
	}
	
	public ArrayList<UUID> getCrazyGlobe() {
		globe.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::playanimationglobe));
		return globe;
	}
	
	public void playanimationglobe(Player player){
		Task.builder().intervalTicks(3).execute(() -> { 
			globe.forEach(uuid -> Sponge.getServer().getPlayer(uuid).ifPresent(this::StyleGlobe)); 
			}).submit(CrazyFeet.getInstance());
		
	}
	
	 
	double pi = 0;
	public void StyleGlobe(Player player) {
	  	pi += Math.PI/10;
           for (double theta = 0; theta <= 2*Math.PI; theta += Math.PI/40) {
        	   double r = 1.5;
        	   double x = r*Math.cos(theta)*Math.sin(pi);
        	   double y = r*Math.cos(pi) + 1.5;
        	   double z = r*Math.sin(theta)*Math.sin(pi);
        	   
        	   //double z = r*Math.sin(theta)+Math.sin(pi);
        	   
           World world = player.getWorld();
				world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).option(ParticleOptions.COLOR, Color.ofRgb(255,0,0)).build(),
						player.getLocation().getPosition().add(x, y, z));
				
			}		
	   }
	
	public void Rain(Player player){
		World world = player.getWorld();
		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.WATER_DROP).build(),
				player.getLocation().getPosition().add(0, 2.5, 0));
		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.DRIP_WATER).build(),
				player.getLocation().getPosition().add(0, 2.5, 0));
	}
	Integer r;
	public void Cloud(Player player) {
		for (int degree = 0; degree < 360; degree++) {
            double radians = Math.toRadians(degree);
            double x = Math.cos(360);
            double z = Math.sin(360);

		    World world = player.getWorld();
			world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).option(ParticleOptions.COLOR, Color.ofRgb(255, 255, 255)).build(),
					player.getLocation().getPosition().add(x, 2.5, z));
			    }
}
	public void StyleYinYang(Player player) {	    	  
	    	  for (int degree = 90; degree < 360; degree++) {
	    		    double radians = Math.toRadians(degree);
	    		    double x = Math.cos(radians);
	    		    double z = Math.sin(radians);
              World world = player.getWorld();
		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
				player.getLocation().getPosition().add(x, 2.5, z));
	}
	    	  for (int degree = 90; degree < 360; degree++) {
	    		    double radians = Math.toRadians(degree);
	    		    double x = Math.cos(radians);
	    		    double z = Math.sin(radians);
            World world = player.getWorld();
		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
				player.getLocation().getPosition().add(x, 1.5, z));
	}
	    	  for (int degree = 90; degree < 360; degree++) {
	    		    double radians = Math.toRadians(degree);
	    		    double x = Math.cos(radians);
	    		    double z = Math.sin(radians);
            World world = player.getWorld();
  		world.spawnParticles(ParticleEffect.builder().type(ParticleTypes.REDSTONE_DUST).option(ParticleOptions.COLOR, Color.ofRgb(254, 33, 254)).build(),
				player.getLocation().getPosition().add(x, 0.1, z));
	    	  }
}
}