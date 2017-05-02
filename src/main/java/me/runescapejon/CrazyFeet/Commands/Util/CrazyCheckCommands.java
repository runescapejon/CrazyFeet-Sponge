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

public class CrazyCheckCommands implements CommandExecutor {

	public CommandResult execute(CommandSource sender, CommandContext args) {
		Optional<Player> target = args.<Player>getOne("target");
		Optional<String> targets = args.<String>getOne("targets");
		final ArrayList<Player> cFire = CrazyFeet.CrazyFire;
		final ArrayList<Player> cSmoke = CrazyFeet.CrazySmoke;
		final ArrayList<Player> cMagic = CrazyFeet.CrazyMagic;
		final ArrayList<Player> cPearl = CrazyFeet.CrazyPearl;
		final ArrayList<Player> cnote = CrazyFeet.Crazynote;
		final ArrayList<Player> cHeart = CrazyFeet.CrazyHeart;
		final ArrayList<Player> cWitch = CrazyFeet.CrazyWitch;

		if (!target.isPresent() && !targets.isPresent()) {
			//if (sender instanceof Player) { had to disable this due to it's not detected /crazycheck others
				Player player = (Player) sender;
				if (player.hasPermission("CrazyFeet.crazyfire") || player.hasPermission("CrazyFeet.crazyheart")
						|| player.hasPermission("CrazyFeet.crazymagic") || player.hasPermission("CrazyFeet.crazynote")
						|| player.hasPermission("CrazyFeet.crazypearl") || player.hasPermission("CrazyFeet.crazysmoke")
						|| player.hasPermission("CrazyFeet.crazywitch"))
				// || player.hasPermission("CrazyFeet.crazyhearthead")
				// || player.hasPermission("CrazyFeet.crazysmoke") ||
				// player.hasPermission("CrazyFeet.crazymagic")
					System.out.println("It's being called crazycheck");
				{
					player.sendMessage(Text.of(TextColors.AQUA, "Your ", TextColors.YELLOW, "Active CrazyFeet modes", TextColors.GRAY, ":"));
					if (cFire.contains(player)) {
						player.sendMessage(Text.of("- CrazyFire"));
					} else {
						// return CommandResult.success();
					}
					if (cSmoke.contains(player)) {
						player.sendMessage(Text.of("- CrazySmoke"));
					} else {
						// return CommandResult.success();
					}
					if (cHeart.contains(player)) {
						player.sendMessage(Text.of("- CrazyHeart"));
					} else {
						// return CommandResult.success();
					}
					if (cMagic.contains(player)) {
						player.sendMessage(Text.of("- CrazyMagic"));
					} else {
						// return CommandResult.success();
					}
					if (cWitch.contains(player)) {
						player.sendMessage(Text.of("- CrazyWitch"));
					} else {
						// return CommandResult.success();
					}
					if (cnote.contains(player)) {
						player.sendMessage(Text.of("- Crazynote"));
					} else {
						// return CommandResult.success();
					}
					if (cPearl.contains(player)) {
						player.sendMessage(Text.of("- CrazyPearl"));
					} else {
						// return CommandResult.success();
					}
					if (!cFire.contains(player) && !cHeart.contains(player) && !cnote.contains(player)
							&& !cWitch.contains(player) && !cSmoke.contains(player) && !cMagic.contains(player)
							&& !cPearl.contains(player)) {
						player.sendMessage(
								Text.of(TextColors.RED, "You do not have any CrazyFeet modes currently activated. Type",
										TextColors.GOLD, " /crazyfeet ", TextColors.RED, "for information."));
						//return CommandResult.success();
					}
				}
		} else if (target.isPresent() && sender.hasPermission("CrazyFeet.checkothers")) {
						Player targ = target.get();
						sender.sendMessage(Text.of(TextColors.YELLOW, targ.getName(), "'s", TextColors.AQUA,
								" active CrazyFeet modes:"));
						System.out.println("It's being called crazycheck other");
						if (cFire.contains(targ)) {
							sender.sendMessage(Text.of("- CrazyFire"));
						} else {
							// return CommandResult.success();
						}
						if (cSmoke.contains(targ)) {
							sender.sendMessage(Text.of("- CrazySmoke"));
						} else {
							// return CommandResult.success();
						}
						if (cMagic.contains(targ)) {
							sender.sendMessage(Text.of("- CrazyMagic"));
						} else {
							// return CommandResult.success();
						}
						if (cWitch.contains(targ)) {
							targ.sendMessage(Text.of("- CrazyWitch"));
						} else {
							// return CommandResult.success();
						}
						if (cnote.contains(targ)) {
							sender.sendMessage(Text.of("- Crazynote"));
						} else {
							// return CommandResult.success();
						}
						if (cHeart.contains(targ)) {
							sender.sendMessage(Text.of("- CrazyHeart"));
						} else {
							// return CommandResult.success();
						}
						if (cPearl.contains(targ)) {
							sender.sendMessage(Text.of("- CrazyPearl"));
						} else {
							// return CommandResult.success();
						}
						if (!cFire.contains(targ) && !cSmoke.contains(targ) && !cnote.contains(targ)
								&& !cWitch.contains(targ) && !cHeart.contains(targ) && !cMagic.contains(targ)
								&& !cPearl.contains(targ)) {
							sender.sendMessage(Text.of(TextColors.GOLD, targ.getName(), TextColors.GRAY,
									" does not have any CrazyFeet modes currently activated."));
						//	return CommandResult.success();
						} else {
							// return CommandResult.success();
						}

					}
					//return CommandResult.success();
		return CommandResult.success();
		}
	}
