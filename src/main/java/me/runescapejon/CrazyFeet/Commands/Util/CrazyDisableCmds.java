package me.runescapejon.CrazyFeet.Commands.Util;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;
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

		final ArrayList<UUID> cFire = CrazyFeet.getInstance().getCrazyFire();
		final ArrayList<UUID> cSmoke = CrazyFeet.getInstance().getCrazySmoke();
		final ArrayList<UUID> cMagic = CrazyFeet.getInstance().getCrazyMagic();
		final ArrayList<UUID> cPearl = CrazyFeet.getInstance().getCrazyPearl();
		final ArrayList<UUID> cnote = CrazyFeet.getInstance().getCrazyNote();
		final ArrayList<UUID> cHeart = CrazyFeet.getInstance().getCrazyHeart();
		final ArrayList<UUID> cWitch = CrazyFeet.getInstance().getCrazyWitch();
		final ArrayList<UUID> cFireh = CrazyFeet.getInstance().getCrazyFireHead();
		final ArrayList<UUID> cSmokeh = CrazyFeet.getInstance().getCrazySmokeHead();
		final ArrayList<UUID> cMagich = CrazyFeet.getInstance().getCrazyMagicHead();
		final ArrayList<UUID> cPearlh = CrazyFeet.getInstance().getCrazyPearlHead();
		final ArrayList<UUID> cnoteh = CrazyFeet.getInstance().getCrazyNoteHead();
		final ArrayList<UUID> cHearth = CrazyFeet.getInstance().getCrazyHeartHead();
		final ArrayList<UUID> cWitchh = CrazyFeet.getInstance().getCrazyWitchHead();

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
				player.sendMessage(LanguageUtils.getText("crazyFeetModesCleared"));
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
			targ.sendMessage(LanguageUtils.getText("crazyFeetModesClearedByPlayer",
					new Pair("%PLAYER%", sender.getName())));
			sender.sendMessage(LanguageUtils.getText("crazyFeetModesClearedForPlayer",
					new Pair("%PLAYER%", targ.getName())));
		}
		return CommandResult.success();

	}
}
