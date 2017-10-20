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

public class CrazyMagicCommands implements CommandExecutor {

	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cMagic = CrazyFeet.getInstance().getCrazyMagic();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazymagic")) {
				if (cMagic.contains(player.getUniqueId())) {
					cMagic.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyMagicDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cMagic.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazyMagicEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazymagicother")) {
			Player targ = target.get();

			if (cMagic.contains(targ.getUniqueId())) {
				cMagic.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyMagicDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyMagicDisabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cMagic.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazyMagicEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazyMagicEnabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}
