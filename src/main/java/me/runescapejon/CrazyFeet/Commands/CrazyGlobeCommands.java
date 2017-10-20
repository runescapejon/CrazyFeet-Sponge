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

public class CrazyGlobeCommands implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cGlobe = CrazyFeet.getInstance().getCrazyGlobe();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyFeet.crazyglobe")) {
				if (cGlobe.contains(player.getUniqueId())) {
					cGlobe.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyGlobeDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cGlobe.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyGlobeEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("crazyFeet.crazyglobeother")) {
			Player targ = target.get();

			if (cGlobe.contains(targ.getUniqueId())) {
				cGlobe.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyGlobeDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyGlobeDisabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cGlobe.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyGlobeEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyGlobeEnabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}