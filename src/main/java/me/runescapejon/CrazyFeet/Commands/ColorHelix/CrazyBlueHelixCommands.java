package me.runescapejon.CrazyFeet.Commands.ColorHelix;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.scheduler.Task;

import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyBlueHelixCommands implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cbrownhelix = CrazyFeet.getInstance().getCrazyBrownHelix();
		final ArrayList<UUID> cbluehelix = CrazyFeet.getInstance().getCrazyBlueHelix();
		final ArrayList<UUID> cGreenhelix = CrazyFeet.getInstance().getCrazyGreenHelix();
		final ArrayList<UUID> corangehelix = CrazyFeet.getInstance().getCrazyOrangeHelix();
		final ArrayList<UUID> cpurplehelix = CrazyFeet.getInstance().getCrazyPurpleHelix();
		final ArrayList<UUID> credhelix = CrazyFeet.getInstance().getCrazyRedHelix();
		final ArrayList<UUID> cwhitehelix = CrazyFeet.getInstance().getCrazyWhiteHelix();
		final ArrayList<UUID> cyellowhelix = CrazyFeet.getInstance().getCrazyYellowHelix();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyFeet.crazybluehelix")) {
				if (cbluehelix.contains(player.getUniqueId())) {
					cbluehelix.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyBlueHelixDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {

					cbluehelix.add(player.getUniqueId());
					// add this to remove to some particle's effect that cause's
					// lag issues cause you dont want too many of them all at
					// once
					cbrownhelix.remove(player.getUniqueId());
					cGreenhelix.remove(player.getUniqueId());
					corangehelix.remove(player.getUniqueId());
					cpurplehelix.remove(player.getUniqueId());
					credhelix.remove(player.getUniqueId());
					cwhitehelix.remove(player.getUniqueId());
					cyellowhelix.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyBlueHelixEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("crazyFeet.crazybluehelixother")) {
			Player targ = target.get();

			if (cbluehelix.contains(targ.getUniqueId())) {
				cbluehelix.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyBlueHelixDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyBlueHelixDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cbluehelix.add(targ.getUniqueId());
				cbrownhelix.remove(targ.getUniqueId());
				cGreenhelix.remove(targ.getUniqueId());
				corangehelix.remove(targ.getUniqueId());
				cpurplehelix.remove(targ.getUniqueId());
				credhelix.remove(targ.getUniqueId());
				cwhitehelix.remove(targ.getUniqueId());
				cyellowhelix.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyBlueHelixEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyBlueHelixEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}