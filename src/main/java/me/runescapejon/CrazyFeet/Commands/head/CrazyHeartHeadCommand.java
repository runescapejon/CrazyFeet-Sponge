package me.runescapejon.CrazyFeet.Commands.head;

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
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import me.runescapejon.CrazyFeet.CrazyFeet;

public class CrazyHeartHeadCommand implements CommandExecutor {

	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
		final ArrayList<UUID> cHeartHead = CrazyFeet.getInstance().getCrazyHeartHead();

		Optional<Player> target = args.getOne("target");

		if (!target.isPresent()) {
			Player player = (Player) src;
			if (player.hasPermission("crazyfeet.crazyhearthead")) {
				if (cHeartHead.contains(player.getUniqueId())) {
					cHeartHead.remove(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyHeartHeadDisabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				} else {
					cHeartHead.add(player.getUniqueId());
					player.sendMessage(LanguageUtils.getText("crazyHeartHeadEnabled",
							new Pair<>("%PLAYER%", player.getName())));
					return CommandResult.success();
				}
			}
		}

		else if (src.hasPermission("CrazyFeet.crazyheartheadother")) {
			Player targ = target.get();

			if (cHeartHead.contains(targ.getUniqueId())) {
				cHeartHead.remove(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyHeartHeadDisabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyHeartHeadDisabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			} else {
				cHeartHead.add(targ.getUniqueId());
				targ.sendMessage(LanguageUtils.getText("crazyHeartHeadEnabledByPlayer",
						new Pair<>("%PLAYER%", src.getName())));
				src.sendMessage(LanguageUtils.getText("crazyHeartHeadEnabledForPlayer",
						new Pair<>("%PLAYER%", targ.getName())));
				return CommandResult.success();
			}
		}
		return CommandResult.success();
	}
}