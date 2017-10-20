package me.runescapejon.CrazyFeet.Commands;

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

public class CrazyStormCommand  implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cStorm = CrazyFeet.getInstance().getCrazyStorm();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazystorm")) {
				if (cStorm.contains(player.getUniqueId())) {
					cStorm.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyStormDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cStorm.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyStormEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazystormother")) {
			Player targ = target.get();

			if (cStorm.contains(targ.getUniqueId())) {
				cStorm.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyStormDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyStormDisabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cStorm.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyStormEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyStormEnabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}