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
import me.runescapejon.CrazyFeet.utils.ConfigUtils;
import me.runescapejon.CrazyFeet.utils.LanguageUtils;
import me.runescapejon.CrazyFeet.utils.Pair;

public class CrazyPurpleHelixCommand implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cPurplehelix = CrazyFeet.getInstance().getCrazyPurpleHelix();

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
					if (ConfigUtils.onetimeparticle) {
					CrazyFeet.clearPlayer(player);
					}
					if (ConfigUtils.onetimeparticle == false) {
					CrazyFeet.clearHelixPlayer(player);
					}
					cPurplehelix.add(player.getUniqueId());
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
