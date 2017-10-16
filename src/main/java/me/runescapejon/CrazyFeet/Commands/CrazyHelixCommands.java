package me.runescapejon.CrazyFeet.Commands;

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
import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyHelixCommands implements CommandExecutor {
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> chelix = CrazyFeet.getInstance().getCrazyHelix();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyFeet.crazyhelix")) {
				if (chelix.contains(player.getUniqueId())) {
					chelix.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyHelixDisabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					chelix.add(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyHelixEnabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("crazyFeet.crazyhelixother")) {
			Player targ = target.get();

			if (chelix.contains(targ.getUniqueId())) {
				chelix.remove(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyHelixDisabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyHelixDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				chelix.add(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyHelixEnabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyHelixEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}