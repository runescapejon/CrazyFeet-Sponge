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
import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyBlueHelixCommands implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> chelix = CrazyFeet.getInstance().getCrazyBlueHelix();
		final ArrayList<UUID> cfire = CrazyFeet.getInstance().getCrazyFire();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyFeet.crazybluehelix")) {
				if (chelix.contains(player.getUniqueId())) {
					chelix.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyBlueHelixDisabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					chelix.add(player.getUniqueId());
					cfire.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyBlueHelixEnabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("crazyFeet.crazybluehelixother")) {
			Player targ = target.get();

			if (chelix.contains(targ.getUniqueId())) {
				chelix.remove(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyBlueHelixDisabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyBlueHelixDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				chelix.add(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyBlueHelixEnabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyBlueHelixEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}