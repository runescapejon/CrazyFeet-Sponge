package me.runescapejon.CrazyFeet.Commands.ColorHelix;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;

import me.runescapejon.CrazyFeet.CrazyFeet;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;

public class CrazyGreenHelixCommands implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cGreenhelix = CrazyFeet.getInstance().getCrazyGreenHelix();
		final ArrayList<UUID> cBrownhelix = CrazyFeet.getInstance().getCrazyBrownHelix();
		final ArrayList<UUID> corangehelix = CrazyFeet.getInstance().getCrazyOrangeHelix();
		final ArrayList<UUID> cpurplehelix = CrazyFeet.getInstance().getCrazyPurpleHelix();
		final ArrayList<UUID> credhelix = CrazyFeet.getInstance().getCrazyRedHelix();
		final ArrayList<UUID> cwhitehelix = CrazyFeet.getInstance().getCrazyWhiteHelix();
		final ArrayList<UUID> cyellowhelix = CrazyFeet.getInstance().getCrazyYellowHelix();
		final ArrayList<UUID> cbluehelix = CrazyFeet.getInstance().getCrazyBlueHelix();
		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyFeet.crazygreenhelix")) {
				if (cGreenhelix.contains(player.getUniqueId())) {
					cGreenhelix.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyGreenHelixDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cGreenhelix.add(player.getUniqueId());
					cBrownhelix.remove(player.getUniqueId());
					corangehelix.remove(player.getUniqueId());
					cpurplehelix.remove(player.getUniqueId());
					credhelix.remove(player.getUniqueId());
					cwhitehelix.remove(player.getUniqueId());
					cyellowhelix.remove(player.getUniqueId());
					cbluehelix.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyGreenHelixEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("crazyFeet.crazygreenhelixother")) {
			Player targ = target.get();

			if (cGreenhelix.contains(targ.getUniqueId())) {
				cGreenhelix.remove(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyGreenHelixDisabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyGreenHelixDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cGreenhelix.add(targ.getUniqueId());
				cBrownhelix.remove(targ.getUniqueId());
				cbluehelix.remove(targ.getUniqueId());
				corangehelix.remove(targ.getUniqueId());
				cpurplehelix.remove(targ.getUniqueId());
				credhelix.remove(targ.getUniqueId());
				cwhitehelix.remove(targ.getUniqueId());
				cyellowhelix.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyGreenHelixEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyGreenHelixEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}