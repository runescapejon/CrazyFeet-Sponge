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
		final ArrayList<Player> cFireh = CrazyFeet.crazyFireHead;
		final ArrayList<Player> cSmokeh = CrazyFeet.crazySmokeHead;
		final ArrayList<Player> cMagich = CrazyFeet.crazyMagicHead;
		final ArrayList<Player> cPearlh = CrazyFeet.crazyPearlHead;
		final ArrayList<Player> cnoteh = CrazyFeet.crazyNoteHead;
		final ArrayList<Player> cHearth = CrazyFeet.crazyHeartHead;
		final ArrayList<Player> cWitchh = CrazyFeet.crazyWitchHead;

		if (!target.isPresent()) {
			// if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("crazyfeet.crazyfirehead") || player.hasPermission("crazyfeet.crazysmokeheaed")
					|| player.hasPermission("crazyfeet.crazymagichead") || player.hasPermission("crazyfeet.crazywitchhead")
					|| player.hasPermission("crazyfeet.crazynotehead") || player.hasPermission("crazyfeet.crazyhearthead")
					|| player.hasPermission("crazyfeet.crazypearlhead") || 
					player.hasPermission("crazyfeet.crazyfire") || player.hasPermission("crazyfeet.crazysmoke")
					|| player.hasPermission("crazyfeet.crazymagic") || player.hasPermission("crazyfeet.crazywitch")
					|| player.hasPermission("crazyfeet.crazynote") || player.hasPermission("crazyfeet.crazyheart")
					|| player.hasPermission("crazyfeet.crazypearl")){
				if (cFireh.contains(player)) {
					cFireh.remove(player);
				}
				if (cSmokeh.contains(player)) {
					cSmokeh.remove(player);
				}
				if (cHearth.contains(player)) {
					cHearth.remove(player);
				}
				if (cWitchh.contains(player)) {
					cWitchh.remove(player);
				}
				if (cnoteh.contains(player)) {
					cnoteh.remove(player);
				}
				if (cMagich.contains(player)) {
					cMagich.remove(player);
				}
				if (cPearlh.contains(player)) {
					cPearlh.remove(player);
				}
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
			if (cFireh.contains(targ)) {
				cFireh.remove(targ);
			}
			if (cSmokeh.contains(targ)) {
				cSmokeh.remove(targ);
			}
			if (cMagich.contains(targ)) {
				cMagich.remove(targ);
			}
			if (cHearth.contains(targ)) {
				cHearth.remove(targ);
			}
			if (cWitchh.contains(targ)) {
				cWitchh.remove(targ);
			}
			if (cnoteh.contains(targ)) {
				cnoteh.remove(targ);
			}
			if (cPearlh.contains(targ)) {
				cPearlh.remove(targ);
			}
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
