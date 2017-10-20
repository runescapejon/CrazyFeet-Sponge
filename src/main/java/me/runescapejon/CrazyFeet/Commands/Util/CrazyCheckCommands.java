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
import org.spongepowered.api.text.Text;

public class CrazyCheckCommands implements CommandExecutor {

	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource sender, CommandContext args) {
		Optional<Player> target = args.getOne("target");
		Optional<String> targets = args.getOne("targets");
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
		final ArrayList<UUID> cHelix = CrazyFeet.getInstance().getCrazyBlueHelix();
		final ArrayList<UUID> cGlobe = CrazyFeet.getInstance().getCrazyGlobe();

		if (!target.isPresent() && !targets.isPresent()) {
			// if (sender instanceof Player) { had to disable this due to it's
			// not detected /crazycheck others
			Player player = (Player) sender;
			if (player.hasPermission("crazyfeet.crazyfirehead") || player.hasPermission("crazyfeet.crazysmokeheaed")
					|| player.hasPermission("crazyfeet.crazymagichead")
					|| player.hasPermission("crazyfeet.crazywitchhead")
					|| player.hasPermission("crazyfeet.crazynotehead")
					|| player.hasPermission("crazyfeet.crazyhearthead") || player.hasPermission("crazyfeet.crazyhelix")
					|| player.hasPermission("crazyfeet.crazypearlhead") || player.hasPermission("crazyfeet.crazyfire")
					|| player.hasPermission("crazyfeet.crazysmoke") || player.hasPermission("crazyfeet.crazymagic")
					|| player.hasPermission("crazyfeet.crazywitch") || player.hasPermission("crazyfeet.crazynote")
					|| player.hasPermission("crazyfeet.crazyheart") || player.hasPermission("crazyfeet.crazypearl"))
			// || player.hasPermission("CrazyFeet.crazyhearthead")
			// || player.hasPermission("CrazyFeet.crazysmoke") ||
			// player.hasPermission("CrazyFeet.crazymagic")
			// System.out.println("It's being called crazycheck");
			{
				player.sendMessage(LanguageUtils.getText("crazyFeetModes"));
				if (cGlobe.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyGlobe"));
				}
				if (cHelix.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyHelix"));
				}
				if (cFireh.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyFireHead"));
				}
				if (cSmokeh.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazySmokeHead"));
				}
				if (cHearth.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyHeartHead"));
				}
				if (cMagich.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyMagicHead"));
				}
				if (cWitchh.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyWitchHead"));
				}
				if (cnoteh.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazynoteHead"));
				}
				if (cPearlh.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyPearlHead"));
				}
				if (cFire.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyFire"));
				}
				if (cSmoke.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazySmoke"));
				}
				if (cHeart.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyHeart"));
				}
				if (cMagic.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyMagic"));
				}
				if (cWitch.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyWitch"));
				}
				if (cnote.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyNote"));
				}
				if (cPearl.contains(player.getUniqueId())) {
					player.sendMessage(Text.of("- CrazyPearl"));
				}
				if (!cFireh.contains(player.getUniqueId()) && !cHearth.contains(player.getUniqueId())
						&& !cnoteh.contains(player.getUniqueId()) && !cGlobe.contains(player.getUniqueId())
						&& !cHelix.contains(player.getUniqueId()) && !cWitchh.contains(player.getUniqueId())
						&& !cSmokeh.contains(player.getUniqueId()) && !cMagich.contains(player.getUniqueId())
						&& !cPearlh.contains(player.getUniqueId()) && !cFire.contains(player.getUniqueId())
						&& !cHeart.contains(player.getUniqueId()) && !cnote.contains(player.getUniqueId())
						&& !cWitch.contains(player.getUniqueId()) && !cSmoke.contains(player.getUniqueId())
						&& !cMagic.contains(player.getUniqueId()) && !cPearl.contains(player.getUniqueId())) {
					player.sendMessage(LanguageUtils.getText("crazyFeetModesEmpty"));
					// return CommandResult.success();
				}
			}
		} else if (target.isPresent() && sender.hasPermission("crazyfeet.checkothers")) {
			Player targ = target.get();
			sender.sendMessage(
					LanguageUtils.getText("crazyFeetOtherPlayerModes", new Pair<>("%PLAYER%", targ.getName())));
			// System.out.println("It's being called crazycheck other");
			if (cGlobe.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyGlobe"));
			}
			if (cHelix.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyHelix"));
			}
			if (cFireh.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyFireHead"));
			}
			if (cSmokeh.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazySmokeHead"));
			}
			if (cMagich.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyMagicHead"));
			}
			if (cWitchh.contains(targ.getUniqueId())) {
				targ.sendMessage(Text.of("- CrazyWitchHead"));
			}
			if (cnoteh.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazynoteHead"));
			}
			if (cHearth.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyHeartHead"));
			}
			if (cPearlh.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyPearlHead"));
			}
			if (cFire.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyFire"));
			}
			if (cSmoke.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazySmoke"));
			}
			if (cMagic.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyMagic"));
			}
			if (cWitch.contains(targ.getUniqueId())) {
				targ.sendMessage(Text.of("- CrazyWitch"));
			}
			if (cnote.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- Crazynote"));
			}
			if (cHeart.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyHeart"));
			}
			if (cPearl.contains(targ.getUniqueId())) {
				sender.sendMessage(Text.of("- CrazyPearl"));
			}
			if (!cFireh.contains(targ.getUniqueId()) && !cSmokeh.contains(targ.getUniqueId())
					&& !cnoteh.contains(targ.getUniqueId()) && !cGlobe.contains(targ.getUniqueId())
					&& !cHelix.contains(targ.getUniqueId()) && !cWitchh.contains(targ.getUniqueId())
					&& !cHearth.contains(targ.getUniqueId()) && !cMagich.contains(targ.getUniqueId())
					&& !cPearlh.contains(targ.getUniqueId()) && !cFire.contains(targ.getUniqueId())
					&& !cSmoke.contains(targ.getUniqueId()) && !cnote.contains(targ.getUniqueId())
					&& !cWitch.contains(targ.getUniqueId()) && !cHeart.contains(targ.getUniqueId())
					&& !cMagic.contains(targ.getUniqueId()) && !cPearl.contains(targ.getUniqueId())) {
				sender.sendMessage(LanguageUtils.getText("crazyFeetOtherPlayerModesEmpty",
						new Pair<>("%PLAYER%", targ.getName())));
			}
		}

		return CommandResult.success();
	}
}
