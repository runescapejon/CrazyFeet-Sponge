package me.runescapejon.CrazyFeet.Commands.ColorHelix;

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

public class CrazyBlueHelixCommands implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

		final ArrayList<UUID> cbluehelix = CrazyFeet.getInstance().getCrazyBlueHelix();

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
					if (ConfigUtils.onetimeparticle) {
					CrazyFeet.clearPlayer(player);
					}
					if (ConfigUtils.onetimeparticle == false) {
					CrazyFeet.clearHelixPlayer(player);
					}
					cbluehelix.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyBlueHelixEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("crazyFeet.crazyBluehelixother")) {
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