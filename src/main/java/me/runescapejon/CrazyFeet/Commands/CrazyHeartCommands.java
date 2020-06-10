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

public class CrazyHeartCommands implements CommandExecutor {

	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cHeart = CrazyFeet.getInstance().getCrazyHeart();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazyheart")) {
				if (ConfigUtils.onetimeparticle) {
					if (cHeart.contains(player.getUniqueId())) {
						cHeart.remove(player.getUniqueId());
						player.sendMessage(LanguageUtils.getText("crazyHeartDisabled",
								new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					} else {
						CrazyFeet.clearPlayer(player);
						cHeart.add(player.getUniqueId());
						player.sendMessage(LanguageUtils.getText("crazyHeartEnabled",
								new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					}
			}
			if (ConfigUtils.onetimeparticle == false) {
				if (cHeart.contains(player.getUniqueId())) {
					cHeart.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyHeartDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cHeart.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyHeartEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}

		}
		} else if (src.hasPermission("CrazyFeet.crazyheartother")) {
			Player targ = target.get();

			if (cHeart.contains(targ.getUniqueId())) {
				cHeart.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyHeartDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyHeartDisabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cHeart.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyHeartEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyHeartEnabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
