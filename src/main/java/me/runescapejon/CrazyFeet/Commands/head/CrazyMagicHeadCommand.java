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

public class CrazyMagicHeadCommand implements CommandExecutor {

	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cMagicHead = CrazyFeet.getInstance().getCrazyMagicHead();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazymagichead")) {
				if (cMagicHead.contains(player.getUniqueId())) {
					cMagicHead.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyMagicHeadDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					CrazyFeet.clearPlayer(player);
					cMagicHead.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyMagicHeadEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
				if (ConfigUtils.onetimeparticle == false) {
					if (cMagicHead.contains(player.getUniqueId())) {
						cMagicHead.remove(player.getUniqueId());
						player.sendMessage(
								LanguageUtils.getText("crazyMagicHeadDisabled", new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					} else {
						cMagicHead.add(player.getUniqueId());
						player.sendMessage(
								LanguageUtils.getText("crazyMagicHeadEnabled", new Pair<>("%PLAYER%", player.getName())));
						return CommandResult.success();
					}
		}
		} else if (src.hasPermission("CrazyFeet.crazymagicheadother")) {
			Player targ = target.get();

			if (cMagicHead.contains(targ.getUniqueId())) {
				cMagicHead.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyMagicHeadDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyMagicHeadDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cMagicHead.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyMagicHeadEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyMagicHeadEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
