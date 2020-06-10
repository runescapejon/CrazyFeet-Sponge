package me.runescapejon.CrazyFeet.Commands;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import me.runescapejon.CrazyFeet.utils.ConfigUtils;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyPearlCommands implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cPearl = CrazyFeet.getInstance().getCrazyPearl();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazypearl")) {
				if (ConfigUtils.onetimeparticle) {
					if (cPearl.contains(player.getUniqueId())) {
						cPearl.remove(player.getUniqueId());
						player.sendMessage(LanguageUtils.getText("crazyPearlDisabled",
								new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					} else {
						CrazyFeet.clearPlayer(player);
						cPearl.add(player.getUniqueId());
						player.sendMessage(LanguageUtils.getText("crazyPearlEnabled",
								new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					}
			}
			if (ConfigUtils.onetimeparticle == false) {
				if (cPearl.contains(player.getUniqueId())) {
					cPearl.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyPearlDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cPearl.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyPearlEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}

		}
		} else if (src.hasPermission("CrazyFeet.crazypearlother")) {
			Player targ = target.get();

			if (cPearl.contains(targ.getUniqueId())) {
				cPearl.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyPearlDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyPearlDisabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cPearl.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyPearlEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyPearlEnabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}