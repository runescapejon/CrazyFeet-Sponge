package me.runescapejon.CrazyFeet.Commands.Util;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import me.runescapejon.CrazyFeet.CrazyFeet;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

public class CrazyDisableCmds implements CommandExecutor {

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		final ArrayList<UUID> cglobe = CrazyFeet.getInstance().getCrazyGlobe();
		final ArrayList<UUID> credhelix = CrazyFeet.getInstance().getCrazyRedHelix();
		final ArrayList<UUID> cPurplehelix = CrazyFeet.getInstance().getCrazyPurpleHelix();
		final ArrayList<UUID> corangehelix = CrazyFeet.getInstance().getCrazyOrangeHelix();
		final ArrayList<UUID> cGreenhelix = CrazyFeet.getInstance().getCrazyGreenHelix();
		final ArrayList<UUID> cBrownhelix = CrazyFeet.getInstance().getCrazyBrownHelix();
		final ArrayList<UUID> cwhitehelix = CrazyFeet.getInstance().getCrazyWhiteHelix();
		final ArrayList<UUID> cYellowhelix = CrazyFeet.getInstance().getCrazyYellowHelix();
		final ArrayList<UUID> cbluehelix = CrazyFeet.getInstance().getCrazyBlueHelix();
		final ArrayList<UUID> cstorm = CrazyFeet.getInstance().getCrazyStorm();

		if (!target.isPresent()) {
			// if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.hasPermission("crazyfeet.crazyfirehead") || player.hasPermission("crazyfeet.crazysmokeheaed")
					|| player.hasPermission("crazyfeet.crazymagichead")
					|| player.hasPermission("crazyfeet.crazywitchhead")
					|| player.hasPermission("crazyfeet.crazynotehead")
					|| player.hasPermission("crazyfeet.crazystorm")
					|| player.hasPermission("crazyfeet.crazyredhelix")
					|| player.hasPermission("crazyfeet.crazybluehelix")
					|| player.hasPermission("crazyfeet.crazybrownhelix")
					|| player.hasPermission("crazyfeet.crazygreenhelix")
					|| player.hasPermission("crazyfeet.crazyorangehelix")
					|| player.hasPermission("crazyfeet.crazypurplehelix")
					|| player.hasPermission("crazyfeet.crazywhitehelix")
					|| player.hasPermission("crazyfeet.crazyyellowhelix")
					|| player.hasPermission("crazyfeet.crazyhearthead")
					|| player.hasPermission("crazyfeet.crazypearlhead") || player.hasPermission("crazyfeet.crazyfire")
					|| player.hasPermission("crazyfeet.crazysmoke") || player.hasPermission("crazyfeet.crazymagic")
					|| player.hasPermission("crazyfeet.crazywitch") || player.hasPermission("crazyfeet.crazynote")
					|| player.hasPermission("crazyfeet.crazyhelix") | player.hasPermission("crazyfeet.crazyheart")
					|| player.hasPermission("crazyfeet.crazypearl")) {
				if (cFireh.contains(player.getUniqueId())) {
					cFireh.remove(player.getUniqueId());
				}
				if (cstorm.contains(player.getUniqueId())) {
					cstorm.remove(player.getUniqueId());
				}
				if (cbluehelix.contains(player.getUniqueId())) {
					cbluehelix.remove(player.getUniqueId());
				}
				if (credhelix.contains(player.getUniqueId())) {
					credhelix.remove(player.getUniqueId());
				}
				if (corangehelix.contains(player.getUniqueId())) {
					corangehelix.remove(player.getUniqueId());
				}
				if (cGreenhelix.contains(player.getUniqueId())) {
					cGreenhelix.remove(player.getUniqueId());
				}
				if (cBrownhelix.contains(player.getUniqueId())) {
					cBrownhelix.remove(player.getUniqueId());
				}
				if (cwhitehelix.contains(player.getUniqueId())) {
					cwhitehelix.remove(player.getUniqueId());
				}
				if (cYellowhelix.contains(player.getUniqueId())) {
					cYellowhelix.remove(player.getUniqueId());
				}
				if (cPurplehelix.contains(player.getUniqueId())) {
					cPurplehelix.remove(player.getUniqueId());
				}
				if (cglobe.contains(player.getUniqueId())) {
					cglobe.remove(player.getUniqueId());
				}
				if (cSmokeh.contains(player.getUniqueId())) {
					cSmokeh.remove(player.getUniqueId());
				}
				if (cHearth.contains(player.getUniqueId())) {
					cHearth.remove(player.getUniqueId());
				}
				if (cWitchh.contains(player.getUniqueId())) {
					cWitchh.remove(player.getUniqueId());
				}
				if (cnoteh.contains(player.getUniqueId())) {
					cnoteh.remove(player.getUniqueId());
				}
				if (cMagich.contains(player.getUniqueId())) {
					cMagich.remove(player.getUniqueId());
				}
				if (cPearlh.contains(player.getUniqueId())) {
					cPearlh.remove(player.getUniqueId());
				}
				if (cFire.contains(player.getUniqueId())) {
					cFire.remove(player.getUniqueId());
				}
				if (cSmoke.contains(player.getUniqueId())) {
					cSmoke.remove(player.getUniqueId());
				}
				if (cHeart.contains(player.getUniqueId())) {
					cHeart.remove(player.getUniqueId());
				}
				if (cWitch.contains(player.getUniqueId())) {
					cWitch.remove(player.getUniqueId());
				}
				if (cnote.contains(player.getUniqueId())) {
					cnote.remove(player.getUniqueId());
				}
				if (cMagic.contains(player.getUniqueId())) {
					cMagic.remove(player.getUniqueId());
				}
				if (cPearl.contains(player.getUniqueId())) {
					cPearl.remove(player.getUniqueId());
				}
				player.sendMessage(LanguageUtils.getText("crazyFeetModesCleared"));
			}
		} else if (sender.hasPermission("crazyfeet.disableothers")) {
			Player targ = target.get();
			if (cglobe.contains(targ.getUniqueId())) {
				cglobe.remove(targ.getUniqueId());
			}
			if (cstorm.contains(targ.getUniqueId())) {
				cstorm.remove(targ.getUniqueId());
			}
			if (cbluehelix.contains(targ.getUniqueId())) {
				cbluehelix.remove(targ.getUniqueId());
			}
			if (credhelix.contains(targ.getUniqueId())) {
				credhelix.remove(targ.getUniqueId());
			}
			if (cYellowhelix.contains(targ.getUniqueId())) {
				cYellowhelix.remove(targ.getUniqueId());
			}
			if (cGreenhelix.contains(targ.getUniqueId())) {
				cGreenhelix.remove(targ.getUniqueId());
			}
			if (cBrownhelix.contains(targ.getUniqueId())) {
				cBrownhelix.remove(targ.getUniqueId());
			}
			if (cwhitehelix.contains(targ.getUniqueId())) {
				cwhitehelix.remove(targ.getUniqueId());
			}
			if (cPurplehelix.contains(targ.getUniqueId())) {
				cPurplehelix.remove(targ.getUniqueId());
			}
			if (cFireh.contains(targ.getUniqueId())) {
				cFireh.remove(targ.getUniqueId());
			}
			if (cSmokeh.contains(targ.getUniqueId())) {
				cSmokeh.remove(targ.getUniqueId());
			}
			if (cMagich.contains(targ.getUniqueId())) {
				cMagich.remove(targ.getUniqueId());
			}
			if (cHearth.contains(targ.getUniqueId())) {
				cHearth.remove(targ.getUniqueId());
			}
			if (cWitchh.contains(targ.getUniqueId())) {
				cWitchh.remove(targ.getUniqueId());
			}
			if (cnoteh.contains(targ.getUniqueId())) {
				cnoteh.remove(targ.getUniqueId());
			}
			if (cPearlh.contains(targ.getUniqueId())) {
				cPearlh.remove(targ.getUniqueId());
			}
			if (cFire.contains(targ.getUniqueId())) {
				cFire.remove(targ.getUniqueId());
			}
			if (cSmoke.contains(targ.getUniqueId())) {
				cSmoke.remove(targ.getUniqueId());
			}
			if (cMagic.contains(targ.getUniqueId())) {
				cMagic.remove(targ.getUniqueId());
			}
			if (cHeart.contains(targ.getUniqueId())) {
				cHeart.remove(targ.getUniqueId());
			}
			if (cWitch.contains(targ.getUniqueId())) {
				cWitch.remove(targ.getUniqueId());
			}
			if (cnote.contains(targ.getUniqueId())) {
				cnote.remove(targ.getUniqueId());
			}
			if (cPearl.contains(targ.getUniqueId())) {
				cPearl.remove(targ.getUniqueId());
			}
			targ.sendMessage(
					LanguageUtils.getText("crazyFeetModesClearedByPlayer", new Pair("%PLAYER%", sender.getName())));
			sender.sendMessage(
					LanguageUtils.getText("crazyFeetModesClearedForPlayer", new Pair("%PLAYER%", targ.getName())));
		}
		return CommandResult.success();

	}
}
