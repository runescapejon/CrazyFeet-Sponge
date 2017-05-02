package me.runescapejon.CrazyFeet.Commands.Util;

import java.util.ArrayList;
import java.util.Optional;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyDisableCmds implements CommandExecutor {

	public CommandResult execute(CommandSource sender, CommandContext args) {
		Optional<Player> target = args.<Player>getOne("target");
		
		final ArrayList<Player> cFire = CrazyFeet.CrazyFire;
		final ArrayList<Player> cSmoke = CrazyFeet.CrazySmoke;
		final ArrayList<Player> cMagic = CrazyFeet.CrazyMagic;
		final ArrayList<Player> cPearl = CrazyFeet.CrazyPearl;
		final ArrayList<Player> cnote = CrazyFeet.Crazynote;
		final ArrayList<Player> cHeart = CrazyFeet.CrazyHeart;
		final ArrayList<Player> cWitch = CrazyFeet.CrazyWitch;

		if (!target.isPresent()) {
			// if (sender instanceof Player) {
			Player player = (Player) sender;
			// debugged System.out.println("It's being called runescapejon!
			// crazydisable");
			if (player.hasPermission("crazyfeet.crazyfire") || player.hasPermission("crazyfeet.crazysmoke")
					|| player.hasPermission("crazyfeet.crazymagic") || player.hasPermission("crazyfeet.crazywitch")
					|| player.hasPermission("crazyfeet.crazynote") || player.hasPermission("crazyfeet.crazyheart") 
		   		 || player.hasPermission("crazyfeet.crazypearl")) {
				if (cFire.contains(player)) {
					cFire.remove(player);
				} else {
					// return CommandResult.success();
				}
				if (cSmoke.contains(player)) {
					cSmoke.remove(player);
				} else {
					// return CommandResult.success();
				}
				if (cHeart.contains(player)) {
					cHeart.remove(player);
				} else {
					// return CommandResult.success();
				}
				if (cWitch.contains(player)) {
					cWitch.remove(player);
				} else {
					// return CommandResult.success();
				}
				if (cnote.contains(player)) {
					cnote.remove(player);
				} else {
					// return CommandResult.success();
				}
				if (cMagic.contains(player)) {
					cMagic.remove(player);
				} else {
					// return CommandResult.success();
				}
				if (cPearl.contains(player)) {
					cPearl.remove(player);
				} else {

				}
				player.sendMessage(Text.of(TextColors.AQUA, "All of your CrazyFeet modes have been cleared!"));
			}
		} else if (target.isPresent() && sender.hasPermission("crazyfeet.disableothers")) {
			Player targ = target.get();
			// debugged System.out.println("It's being called runescapejon!
			// crazydisable other");
			if (cFire.contains(targ)) {
				cFire.remove(targ);
			} else {
				// return CommandResult.success();
			}
			if (cSmoke.contains(targ)) {
				cSmoke.remove(targ);
			} else {
				// return CommandResult.success();
			}
			if (cMagic.contains(targ)) {
				cMagic.remove(targ);
			} else {
				// return CommandResult.success();
			}
			if (cHeart.contains(targ)) {
				cHeart.remove(targ);
			} else {
				// return CommandResult.success();
			}
			if (cWitch.contains(targ)) {
				cWitch.remove(targ);
			} else {
				// return CommandResult.success();
			}
			if (cnote.contains(targ)) {
				cnote.remove(targ);
			} else {
				// return CommandResult.success();
			}
			if (cPearl.contains(targ)) {
				cPearl.remove(targ);
			} else {
				// return CommandResult.success();
			}
				targ.sendMessage(Text.of(TextColors.YELLOW, "All of your CrazyFeet modes have been cleared by ",
						sender.getName(), "!"));
				sender.sendMessage(Text.of(TextColors.YELLOW, "All of ", TextColors.AQUA, targ.getName(), "'s ",
						TextColors.YELLOW, "CrazyFeet modes have been cleared!"));
			} else {
				// return CommandResult.success();
			}
		return CommandResult.success();

		}
		// return CommandResult.success();
	}
