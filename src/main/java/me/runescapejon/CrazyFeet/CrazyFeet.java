package me.runescapejon.CrazyFeet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import me.runescapejon.CrazyFeet.Commands.CrazyFireCommands;
import me.runescapejon.CrazyFeet.Commands.CrazyHeartCommands;
import me.runescapejon.CrazyFeet.Commands.CrazyMagicCommands;
import me.runescapejon.CrazyFeet.Commands.CrazyNoteCommands;
import me.runescapejon.CrazyFeet.Commands.CrazyPearlCommands;
import me.runescapejon.CrazyFeet.Commands.CrazySmokeCommands;
import me.runescapejon.CrazyFeet.Commands.CrazyWitchCommands;
import me.runescapejon.CrazyFeet.Commands.Auto.CrazyAutoFire;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyAutoFeetCommands;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyCheckCommands;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyDisableCmds;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyFeetAdminCmd;
import me.runescapejon.CrazyFeet.Commands.Util.CrazyFeetCommands;
import me.runescapejon.CrazyFeet.Listeners.CrazyFeetListener;
import me.runescapejon.CrazyFeet.Commands.Util.Files.CrazyAutoFireFile;

@Plugin(id = "crazyfeetsponge", name = "CrazyFeetSponge", description = "CrazyFeet Ported over to Sponge", version = "1.3")
public class CrazyFeet {
	public static ArrayList<Player> CrazyFireHead;
	public static ArrayList<Player> CrazyHeartHead;
	public static ArrayList<Player> CrazyMagicHead;
	public static ArrayList<Player> CrazyNoteHead;
	public static ArrayList<Player> CrazyWitchHead;
	public static ArrayList<Player> CrazySmokeHead;
	public static ArrayList<Player> CrazyPearlHead;
	public static ArrayList<Player> CrazyFire;
	public static ArrayList<Player> CrazySmoke;
	public static ArrayList<Player> CrazyMagic;
	public static ArrayList<Player> CrazyPearl;
	public static ArrayList<Player> Crazynote;
	public static ArrayList<Player> CrazyWitch;
	public static ArrayList<Player> CrazyHeart;
	public static CrazyAutoFireFile aFirePlayer;
	//public static CrazyAutoSmokeFile aSmokeP;
	//public static CrazyAutoPearlFile aPearlP;
	//public static CrazyAutoMagicFile aMagicP;
    //public static CrazyAutonoteFile anoteP;
	//public static CrazyAutoWitchFile aWitchP;
	//public static CrazyAutoHeartFile aHeartP;

	@Listener
	public void onServerStart(GameStartedServerEvent event) {
		CrazyFire = new ArrayList<Player>();
		Crazynote = new ArrayList<Player>();
		CrazyMagic = new ArrayList<Player>();
		CrazyHeart = new ArrayList<Player>();
		CrazySmoke = new ArrayList<Player>();
		CrazyPearl = new ArrayList<Player>();
		CrazyWitch = new ArrayList<Player>();
		
		aFirePlayer.loadAutoFirePlayers();
	}

	HashMap<List<String>, CommandSpec> subcommands = new HashMap<List<String>, CommandSpec>();

	@Listener
	public void onGameInitlization(GameInitializationEvent event) {

		// CrazyFeet Register
		subcommands.put(Arrays.asList("admin"), CommandSpec.builder().description(Text.of("crazyfeet admin"))
				.permission("crazyfeet.admin").executor(new CrazyFeetAdminCmd()).build());
		CommandSpec CrazyFeetSpec = CommandSpec.builder().description(Text.of("crazyfeet")).permission("social.help")
				.executor(new CrazyFeetCommands()).children(subcommands).build();
		Sponge.getCommandManager().register(this, CrazyFeetSpec, "crazyfeet");

		//CrazyFeetListener Registering Here
		CrazyFeetListener listener = new CrazyFeetListener();
		Sponge.getEventManager().registerListeners(this, listener);

		// CrazyFire Register
		CommandSpec CrazyFireSpec = CommandSpec.builder().description(Text.of("crazyfire to enable/disable fire particles"))
				.permission("CrazyFeet.crazyfire").executor(new CrazyFireCommands()).build();
		Sponge.getCommandManager().register(this, CrazyFireSpec, "crazyfire");

		// Crazynote Register
		CommandSpec CrazyNoteSpec = CommandSpec.builder().description(Text.of("crazynote to enable/disable note particles"))
				.permission("CrazyFeet.crazyfire").executor(new CrazyNoteCommands()).build();
		Sponge.getCommandManager().register(this, CrazyNoteSpec, "crazynote");

		// Crazymagic Register
		CommandSpec CrazyMagicSpec = CommandSpec.builder().description(Text.of("crazymagic to enable/disable magic particles"))
				.permission("CrazyFeet.crazymagic").executor(new CrazyMagicCommands()).build();
		Sponge.getCommandManager().register(this, CrazyMagicSpec, "crazymagic");
	
		// Crazyheart Register
		CommandSpec CrazyHeartSpec = CommandSpec.builder().description(Text.of("crazymagic to enable/disable heart particles"))
				.permission("CrazyFeet.crazyheart").executor(new CrazyHeartCommands()).build();
		Sponge.getCommandManager().register(this, CrazyHeartSpec, "crazyheart");
		
		// CrazySmoke Register
		CommandSpec CrazySmokeSpec = CommandSpec.builder().description(Text.of("crazymagic to enable/disable Smoke particles"))
				.permission("CrazyFeet.crazysmoke").executor(new CrazySmokeCommands()).build();
		Sponge.getCommandManager().register(this, CrazySmokeSpec, "crazysmoke");
		
		// CrazyPearl Register
		CommandSpec CrazypearlSpec = CommandSpec.builder().description(Text.of("crazymagic to enable/disable Pearl particles"))
				.permission("CrazyFeet.crazypearl").executor(new CrazyPearlCommands()).build();
		Sponge.getCommandManager().register(this, CrazypearlSpec, "crazypearl");
		
		// CrazyWitch Register
		CommandSpec CrazyWitchSpec = CommandSpec.builder().description(Text.of("crazymagic to enable/disable Witch particles"))
				.permission("CrazyFeet.crazywitch").executor(new CrazyWitchCommands()).build();
		Sponge.getCommandManager().register(this, CrazyWitchSpec, "crazywitch");
		
		// Crazyautofeet Register
		CommandSpec CrazyautofeetSpec = CommandSpec.builder().description(Text.of("Displays a help menu for Crazy-Auto"))
				.permission("crazyfeet.autofeet").executor(new CrazyAutoFeetCommands()).build();
		Sponge.getCommandManager().register(this, CrazyautofeetSpec, "crazyautofeet");
		
		//crazycheck <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyCheckSpec = CommandSpec.builder().description(Text.of("crazycheck your particles status - helpful to see what enabled"))
				.permission("CrazyFeet.crazycheck").arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets"))))))).executor(new CrazyCheckCommands()).build();
		Sponge.getCommandManager().register(this, CrazyCheckSpec, "crazycheck");
	
		//crazydisable <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyDisableSpec = CommandSpec.builder().description(Text.of("crazydisable disable your/other particles all of them"))
				.permission("CrazyFeet.crazydisable").arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets"))))))).executor(new CrazyDisableCmds()).build();
		Sponge.getCommandManager().register(this, CrazyDisableSpec, "crazydisable");
		
		//crazyautofire <PlayerName> - Register and <PlayerName> is Optional
		CommandSpec CrazyAutoFireSpec = CommandSpec.builder().description(Text.of("crazyautofire enable/disable auto fire when you join")) 
				.permission("CrazyFeet.crazyautofire").arguments(GenericArguments.firstParsing(GenericArguments.flags()
						.buildWith(GenericArguments.firstParsing(GenericArguments.optional(GenericArguments.player(Text.of("target"))), GenericArguments.optional(GenericArguments.string(Text.of("targets"))))))).executor(new CrazyAutoFire()).build();
		Sponge.getCommandManager().register(this, CrazyAutoFireSpec, "crazyautofire");
	}
    public CrazyAutoFireFile getAFirePlayers() {
		return aFirePlayer;
	}
}
