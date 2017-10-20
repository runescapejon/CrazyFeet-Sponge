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

public class CrazySmokeCommands implements CommandExecutor {
	@SuppressWarnings("unchecked")
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cSmoke = CrazyFeet.getInstance().getCrazySmoke();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("CrazyFeet.crazysmoke")) {
				if (cSmoke.contains(player.getUniqueId())) {
					cSmoke.remove(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazySmokeDisabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cSmoke.add(player.getUniqueId());
					player.sendMessage(
							LanguageUtils.getText("crazySmokeEnabled", new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		} else if (src.hasPermission("CrazyFeet.crazysmokeother")) {
			Player targ = target.get();

			if (cSmoke.contains(targ.getUniqueId())) {
				cSmoke.remove(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazySmokeDisabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazySmokeDisabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cSmoke.add(targ.getUniqueId());
				targ.sendMessage(
						LanguageUtils.getText("crazySmokeEnabledByPlayer", new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(
						LanguageUtils.getText("crazySmokeEnabledForPlayer", new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}