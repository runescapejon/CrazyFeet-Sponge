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

public class CrazyWitchCommands implements CommandExecutor {

	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cWitch = CrazyFeet.getInstance().getCrazyWitch();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazywitch")) {
				if (ConfigUtils.onetimeparticle) {
					if (cWitch.contains(player.getUniqueId())) {
						cWitch.remove(player.getUniqueId());
						player.sendMessage(LanguageUtils.getText("crazyWitchDisabled",
								new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					} else {
						CrazyFeet.clearPlayer(player);
						cWitch.add(player.getUniqueId());
						player.sendMessage(LanguageUtils.getText("crazyWitchEnabled",
								new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					}
			}
			if (ConfigUtils.onetimeparticle == false) {
				if (cWitch.contains(player.getUniqueId())) {
					cWitch.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyWitchDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cWitch.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyWitchEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}

		}
		} else if (src.hasPermission("CrazyFeet.crazywitchother")) {
			Player targ = target.get();

			if (cWitch.contains(targ.getUniqueId())) {
				cWitch.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyWitchDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyWitchDisabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cWitch.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyWitchEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyWitchEnabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}