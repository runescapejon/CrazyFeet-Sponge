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

public class CrazyPurpleHelixCommand implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cPurplehelix = CrazyFeet.getInstance().getCrazyPurpleHelix();
		final ArrayList<UUID> corangehelix = CrazyFeet.getInstance().getCrazyOrangeHelix();
		final ArrayList<UUID> cGreenhelix = CrazyFeet.getInstance().getCrazyGreenHelix();
		final ArrayList<UUID> cBrownhelix = CrazyFeet.getInstance().getCrazyBrownHelix();
		final ArrayList<UUID> credhelix = CrazyFeet.getInstance().getCrazyRedHelix();
		final ArrayList<UUID> cwhitehelix = CrazyFeet.getInstance().getCrazyWhiteHelix();
		final ArrayList<UUID> cyellowhelix = CrazyFeet.getInstance().getCrazyYellowHelix();
		final ArrayList<UUID> cbluehelix = CrazyFeet.getInstance().getCrazyBlueHelix();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyFeet.crazypurplehelix")) {
				if (cPurplehelix.contains(player.getUniqueId())) {
					cPurplehelix.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyPurpleHelixDisabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cPurplehelix.add(player.getUniqueId());
					cGreenhelix.remove(player.getUniqueId());
					corangehelix.remove(player.getUniqueId());
					credhelix.remove(player.getUniqueId());
					cwhitehelix.remove(player.getUniqueId());
					cyellowhelix.remove(player.getUniqueId());
					cbluehelix.remove(player.getUniqueId());
					cBrownhelix.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyPurpleHelixEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("crazyFeet.crazypurplehelixother")) {
			Player targ = target.get();

			if (cPurplehelix.contains(targ.getUniqueId())) {
				cPurplehelix.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyRedHelixDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyRednHelixDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cPurplehelix.add(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyPurpleHelixEnabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyPurpleHelixEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
