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
		Optional<Player> target = args.getOne("target");
		
		final ArrayList<Player> cFire = CrazyFeet.crazyFire;
		final ArrayList<Player> cSmoke = CrazyFeet.crazySmoke;
		final ArrayList<Player> cMagic = CrazyFeet.crazyMagic;
		final ArrayList<Player> cPearl = CrazyFeet.crazyPearl;
		final ArrayList<Player> cnote = CrazyFeet.crazynote;
		final ArrayList<Player> cHeart = CrazyFeet.crazyHeart;
		final ArrayList<Player> cWitch = CrazyFeet.crazyWitch;

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
				}
				if (cSmoke.contains(player)) {
					cSmoke.remove(player);
				}
				if (cHeart.contains(player)) {
					cHeart.remove(player);
				}
				if (cWitch.contains(player)) {
					cWitch.remove(player);
				}
				if (cnote.contains(player)) {
					cnote.remove(player);
				}
				if (cMagic.contains(player)) {
					cMagic.remove(player);
				}
				if (cPearl.contains(player)) {
					cPearl.remove(player);
				}
				player.sendMessage(Text.of(TextColors.AQUA, "All of your CrazyFeet modes have been cleared!"));
			}
		} else if (sender.hasPermission("crazyfeet.disableothers")) {
			Player targ = target.get();
			if (cFire.contains(targ)) {
				cFire.remove(targ);
			}
			if (cSmoke.contains(targ)) {
				cSmoke.remove(targ);
			}
			if (cMagic.contains(targ)) {
				cMagic.remove(targ);
			}
			if (cHeart.contains(targ)) {
				cHeart.remove(targ);
			}
			if (cWitch.contains(targ)) {
				cWitch.remove(targ);
			}
			if (cnote.contains(targ)) {
				cnote.remove(targ);
			}
			if (cPearl.contains(targ)) {
				cPearl.remove(targ);
			}
				targ.sendMessage(Text.of(TextColors.YELLOW, "All of your CrazyFeet modes have been cleared by ",
						sender.getName(), "!"));
				sender.sendMessage(Text.of(TextColors.YELLOW, "All of ", TextColors.AQUA, targ.getName(), "'s ",
						TextColors.YELLOW, "CrazyFeet modes have been cleared!"));
			}
		return CommandResult.success();

		}
	}
