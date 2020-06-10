package me.runescapejon.CrazyFeet.Commands.head;

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

public class CrazySmokeHeadCommand implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cSmokeHead = CrazyFeet.getInstance().getCrazySmokeHead();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazysmokehead")) {
				if (cSmokeHead.contains(player.getUniqueId())) {
					cSmokeHead.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazySmokeHeadDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					CrazyFeet.clearPlayer(player);
					cSmokeHead.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazySmokeHeadEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
				if (ConfigUtils.onetimeparticle == false) {
					if (cSmokeHead.contains(player.getUniqueId())) {
						cSmokeHead.remove(player.getUniqueId());
						player.sendMessage(
								LanguageUtils.getText("crazySmokeHeadDisabled", new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					} else {
						cSmokeHead.add(player.getUniqueId());
						player.sendMessage(
								LanguageUtils.getText("crazySmokeHeadEnabled", new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					}
		}
		} else if (src.hasPermission("CrazyFeet.crazysmokeheadother")) {
			Player targ = target.get();

			if (cSmokeHead.contains(targ.getUniqueId())) {
				cSmokeHead.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazySmokeHeadDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazySmokeHeadDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cSmokeHead.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazySmokeHeadEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazySmokeHeadEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}